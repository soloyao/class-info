$(function() {
	var data4Vue = {
		addressBooks: [],
		addressBook4Add: {id: 0, studyNumber: "", name: "", nativePlace: "", phone: "", qqNumber: "", address: ""},
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
		},
		methods: {
			//表格前面的全选框
			checkboxAll() {
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
			checkbox(e) {
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
			//根据页数获取数据
			list(start) {
				var _this = this;
				_this.isLoading = true;
				//传入参数：页码，关键词，一页记录大小
				var url = "addressBooks?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.addressBooks = res.data.list;
					_this.isLoading = false;
				});
			},
			//保存通讯录按钮
			save() {
				var _this = this;
				if (!_this.addressBook4Add.studyNumber || !_this.addressBook4Add.name || !_this.addressBook4Add.nativePlace || !_this.addressBook4Add.phone
						|| !_this.addressBook4Add.qqNumber || !_this.addressBook4Add.address) {
					myzui._error("必填参数不能为空");
					return;
				}
				var url = "addressBooks";
				if (_this.addressBook4Add.id == 0) {//新增
					axios.post(url, _this.addressBook4Add).then(function(res) {
						if (res.data.code == 0) {
							_this.list(1);
							_this.addressBook4Add = {id: 0, studyNumber: "", name: "", nativePlace: "", phone: "", qqNumber: "", address: ""};
							myzui._success("新增成功");
							_this.isEditShow = false;
						} else {
							myzui._error("新增失败");
						}
					});
				} else {//修改
					axios.put(url, _this.addressBook4Add).then(function(res) {
						if (res.data.code == 0) {
							_this.list(1);
							_this.addressBook4Add = {id: 0, studyNumber: "", name: "", nativePlace: "", phone: "", qqNumber: "", address: ""};
							myzui._success("修改成功");
							_this.isEditShow = false;
						} else {
							myzui._error("修改失败");
						}
					});
				}
			},
			//取消按钮
			cancel() {
				this.isEditShow = false;
			},
			//新增按钮
			addEdit() {
				this.isEditShow = true;
				this.editTitle = "新增";
				this.addressBook4Add = {id: 0, studyNumber: "", name: "", nativePlace: "", phone: "", qqNumber: "", address: ""};
			},
			//修改按钮
			updateEdit(item) {
				this.isEditShow = true;
				this.editTitle = "修改";
				this.addressBook4Add.id = item.id;
				this.addressBook4Add.studyNumber = item.studyNumber;
				this.addressBook4Add.name = item.name;
				this.addressBook4Add.nativePlace = item.nativePlace;
				this.addressBook4Add.phone = item.phone;
				this.addressBook4Add.qqNumber = item.qqNumber;
				this.addressBook4Add.address = item.address;
			},
			//删除按钮
			deleteItem(id) {
				var _this = this;
				myzui.confirm("确认删除？", function() {
					var url = "addressBooks/" + id;
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