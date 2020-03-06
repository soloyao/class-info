$(function() {
	var zTreeObj;
	var setting = {
		check: {
			enable: true,
			chkStyle: "checkbox"
		},
		view: {
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "pid",
				rootPId: 0
			},
			key: {
				url: "xUrl"
			}
		},
		callback: {
			onClick: function(e, treeId, treeNode, clickFlag) {
				zTreeObj.checkNode(treeNode, !treeNode.checked, true);
			}
		}
	};
	var zTreeNodes = [];
	
	var zTreeObjBatch;
	var settingBatch = {
		check: {
			enable: true,
			chkStyle: "checkbox"
		},
		view: {
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "pid",
				rootPId: 0
			},
			key: {
				url: "xUrl"
			}
		},
		callback: {
			onClick: function(e, treeId, treeNode, clickFlag) {
				zTreeObjBatch.checkNode(treeNode, !treeNode.checked, true);
			}
		}
	};
	var zTreeNodesBatch = [];
	
	var data4Vue = {
		permissions: [],
		roles: [],
		role4Add: {id: 0, name: "", desc: "", permissions: []},
		pagination: {},
		keyword: "",
		isEditShow: false,
		isLoading: false,
		editTitle: "",
		size: 15,
		checkboxAllFlag: false
	};
	
	var vue = new Vue({
		el: "#app",
		data: data4Vue,
		mounted: function() {
			this.list(1);
			this.listPermissions();
		},
		methods: {
			//表格前面的全选框
			checkboxAll: function(e) {
				if (!this.checkboxAllFlag) {
					$(".checkbox-parent").addClass("checked");
					$(".checkbox-children").addClass("checked");
					this.checkboxAllFlag = true;
				} else {
					$(".checkbox-parent").removeClass("checked");
					$(".checkbox-children").removeClass("checked");
					this.checkboxAllFlag = false;
				}
			},
			//单行前面的单选框
			checkbox: function(e) {
				var el = e.target;
				$(el).parent(".checkbox-primary").toggleClass("checked");
				var allFlag = true;
				$(".checkbox-children").map(function(item, ele) {
					if (!$(ele).hasClass("checked")) {
						allFlag = false;
					}
				});
				if (allFlag) {
					$(".checkbox-parent").addClass("checked");
				} else {
					$(".checkbox-parent").removeClass("checked");
				}
			},
			//获取全部菜单到ztree中
			listPermissions: function() {
				var _this = this;
				var url ="listPermissions";
				axios.get(url).then(function(res) {
					_this.permissions = res.data;
					zTreeNodesBatch = res.data;
					zTreeNodes = res.data;
					zTreeObjBatch = $.fn.zTree.init($("#treeBatch"), settingBatch, zTreeNodesBatch);
					zTreeObjBatch.checkAllNodes(false);
					zTreeObj = $.fn.zTree.init($("#tree"), setting, zTreeNodes);
					zTreeObjBatch.expandAll(true);
					zTreeObj.expandAll(true);
				});
			},
			//批量分配菜单给角色
			saveBatch() {
				var _this = this;
				var nodes = zTreeObjBatch.transformToArray(zTreeObjBatch.getNodes());
				var arr = [];
				for (var i = 0, l = nodes.length; i < l; i++) {
					if(nodes[i].checked && nodes[i].id != "pid"){
						arr.push(nodes[i].id);
					}
				}
				var permissionIds = arr.join(",");
				var roleIds = $("tbody .checked").map(function(item, ele) {
					return $(ele).data("id");
				}).get().join(",");
				if (!roleIds || !permissionIds) {
					myzui._error("所选角色或权限不能为空");
					return;
				}
				axios.post("rolesBatch", {roleIds: roleIds, permissionIds: permissionIds}).then(function(res) {
					myzui._success("权限分配成功");
					zTreeObjBatch.checkAllNodes(false);
					_this.list(1);
					_this.checkboxAllFlag = true;
					_this.checkboxAll();
				});
			},
			//保存角色
			save: function() {
				var _this = this;
				if (!_this.role4Add.name || !_this.role4Add.desc) {
					myzui._error("必填参数不能为空");
					return;
				}
				var url = "roles";
				_this.role4Add.permissions = [];
				zTreeObj.getCheckedNodes(true).map(function(item) {
					_this.role4Add.permissions.push({id: item.id});
				});
				if (_this.role4Add.id == 0) { //add
					axios.post(url, _this.role4Add).then(function(res) {
						if (res.data.code == 0) {
							_this.list(1);
							_this.role4Add = {id: 0, name: "", desc: "", permissions: []};
							myzui._success(res.data.msg);
							_this.isEditShow = false;
						} else {
							myzui._error(res.data.msg);
						}
					});
				} else { //update
					axios.put(url, _this.role4Add).then(function(res) {
						_this.list(1);
						_this.role4Add = {id: 0, name: "", desc: "", permissions: []};
						myzui._success(res.data);
						_this.isEditShow = false;
					});
				}
			},
			//取消按钮
			cancel: function() {
				this.isEditShow = false;
			},
			//新增角色按钮
			addEdit: function() {
				this.isEditShow = true;
				this.editTitle = "新增";
				this.role4Add = {id: 0, name: "", desc: "", permissions: []};
				zTreeObj.checkAllNodes(false);
			},
			//修改角色按钮
			updateEdit: function(role) {
				var _this = this;
				this.isEditShow = true;
				this.editTitle = "修改";
				this.role4Add.id = role.id;
				this.role4Add.name = role.name;
				this.role4Add.desc = role.desc;
				zTreeObj.checkAllNodes(false);
				role.permissions.map(function(item) {
					zTreeObj.checkNode(zTreeObj.getNodeByParam("id", item.id, null), true, false);
				});
			},
			//根据页数获取数据
			list: function(start) {
				var _this = this;
				_this.isLoading = true;
				//传入参数：页码，关键词，一页记录大小
				var url = "roles?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.roles = res.data.list;
					_this.isLoading = false;
				});
			},
			//保存角色按钮
			add: function() {
				var _this = this;
				var url = "roles";
				if (!this.role4Add.name || !this.role4Add.desc) {
					myzui._error("必填参数不能为空");
					return;
				}
				axios.post(url, this.role4Add).then(function(res) {
					if (res.data.code == 0) {
						_this.list(1);
						_this.role4Add = {id: 0, name: "", desc: ""};
						myzui._success(res.data.msg);
					} else {
						myzui._error(res.data.msg);
					}
				});
			},
			//删除角色按钮
			deleteRole: function(id) {
				var _this = this;
				myzui.confirm("确认删除？", function() {
					var url = "roles/" + id;
					axios.delete(url).then(function(res) {
						_this.list(1);
					});
				});
			},
			//重置
			reset: function() {
				var _this = this;
				$("#keyword").val("");
				_this.keyword = $("#keyword").val();
				_this.list(1);
			},
			//搜索
			search: function() {
				var _this = this;
				_this.keyword = $("#keyword").val();
				if (_this.keyword) {
					_this.list(1);
				}
			}
		}
	});
});