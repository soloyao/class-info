$(function() {
	var data4Vue = {
		messages: [],
		message4Add: {id: 0, name: "", title: "", content: ""},
		pagination: {},
		keyword: "",
		messageTitle: "",
		isLoading: false,
		size: 15
	};
	
	var vue = new Vue({
		el: "#app",
		data: data4Vue,
		mounted: function() {
			this.list(1);
		},
		methods: {
			deleteItem(id) {
				var _this = this;
				myzui.confirm("确认删除？", function() {
					axios.delete("messages/" + id).then(function(res) {
						_this.list(1);
					}); 
				});
			},
			list(start) {
				var _this = this;
				_this.isLoading = true;
				var url = "messages?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.messages = res.data.list;
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