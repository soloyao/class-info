$(function() {
	var data4Vue = {
		photos: [],
		photo4Add: {id: 0, title: "", content: ""},
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
			$("#lightBoxToggle").lightbox();
		},
		methods: {
			showImage() {
				var myLightBox = $("#lightBoxToggle").data("zui.lightbox");
				myLightBox.show("upload/" + this.photo4Add.content);
			},
			listShowImage(content) {
				var myLightBox = $("#lightBoxToggle").data("zui.lightbox");
				myLightBox.show("upload/" + content);
			},
			deleteItemImage() {
				this.photo4Add.content = "";
			},
			upload() {
				var _this = this;
				$.uploader("../upload", function(data) {
					_this.photo4Add.content = data;
				}, {
					filters: {
						mime_types: [
							{title: "图片", extensions: "jpg,png"}
						]
					},
					limitFilesCount: 1
				}, true);
			},
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
				var url = "classPhotos?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.photos = res.data.list;
					_this.isLoading = false;
				});
			},
			save() {
				var _this = this;
				if (!_this.photo4Add.title || !_this.photo4Add.content) {
					myzui._error("必填参数不能为空");
					return;
				}
				var url = "classPhotos";
				if (_this.photo4Add.id == 0) {//新增
					axios.post(url, _this.photo4Add).then(function(res) {
						if (res.data.code == 0) {
							_this.list(1);
							_this.photo4Add = {id: 0, title: "", content: ""};
							myzui._success("新增成功");
							_this.isEditShow = false;
						} else {
							myzui._error("新增失败");
						}
					});
				} else {//修改
					axios.put(url, _this.photo4Add).then(function(res) {
						if (res.data.code == 0) {
							_this.list(1);
							_this.photo4Add = {id: 0, title: "", content: ""};
							myzui._success("新增成功");
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
				this.photo4Add = {id: 0, title: "", content: ""};
			},
			updateEdit(item) {
				this.isEditShow = true;
				this.editTitle = "修改";
				this.photo4Add.id = item.id;
				this.photo4Add.title = item.title;
				this.photo4Add.content = item.content;
			},
			deleteItem(id) {
				var _this = this;
				myzui.confirm("确认删除？", function() {
					var url = "classPhotos/" + id;
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