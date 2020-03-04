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
			listShowImage(content) {
				var myLightBox = $("#lightBoxToggle").data("zui.lightbox");
				myLightBox.show("upload/" + content);
			},
			list(start) {
				var _this = this;
				_this.isLoading = true;
				var url = "allClassPhotos?keyword=" + _this.keyword;
				axios.get(url).then(function(res) {
					_this.photos = res.data;
					_this.isLoading = false;
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