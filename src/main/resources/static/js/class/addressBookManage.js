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
			list(start) {
				var _this = this;
				_this.isLoading = true;
				var url = "addressBooks?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.addressBooks = res.data.list;
					_this.isLoading = false;
				});
			},
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
			cancel() {
				this.isEditShow = false;
			},
			addEdit() {
				this.isEditShow = true;
				this.editTitle = "新增";
				this.addressBook4Add = {id: 0, studyNumber: "", name: "", nativePlace: "", phone: "", qqNumber: "", address: ""};
			},
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
			deleteItem(id) {
				var _this = this;
				myzui.confirm("确认删除？", function() {
					var url = "addressBooks/" + id;
					axios.delete(url).then(function(res) {
						_this.list(1);
					});
				});
			},
			reset: function() {
				var _this = this;
				$("#keyword").val("");
				_this.keyword = $("#keyword").val();
				_this.list(1);
			},
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