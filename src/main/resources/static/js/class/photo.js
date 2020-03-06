$(function() {
	var data4Vue = {
		photos: [],
		keyword: "",
		isLoading: false,
		size: 15
	};
	
	var vue = new Vue({
		el: "#app",
		data: data4Vue,
		mounted: function() {
			this.list(1);
			$("#lightBoxToggle").lightbox();
		},
		methods: {
			//展开大图
			listShowImage(content) {
				var myLightBox = $("#lightBoxToggle").data("zui.lightbox");
				myLightBox.show("upload/" + content);
			},
			//根据页数获取数据
			list(start) {
				var _this = this;
				_this.isLoading = true;
				//传入参数：页码，关键词，一页记录大小
				var url = "allClassPhotos?keyword=" + _this.keyword;
				axios.get(url).then(function(res) {
					_this.photos = res.data;
					_this.isLoading = false;
				});
			},
			//重置按钮
			reset: function() {
				var _this = this;
				$("#keyword").val("");
				_this.keyword = $("#keyword").val();
				_this.list(1);
			},
			//搜索按钮
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