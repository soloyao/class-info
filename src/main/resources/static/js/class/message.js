$(function() {
	var data4Vue = {
		messages: [],
		message4Add: {id: 0, name: "", title: "", content: ""},
		pagination: {},
		keyword: "",
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
			submit() {
				var _this = this;
				var url = "messages";
				if (!_this.message4Add.title || !_this.message4Add.content) {
					myzui._error("必填参数不能为空");
					return;
				}
				axios.post(url, _this.message4Add).then(function(res) {
					$("#messageModal").modal("hide");
					myzui._success("留言发表成功");
					_this.list(1);
					_this.message4Add = {id: 0, name: "", title: "", content: ""};
				});
			},
			add() {
				$("#messageModal").modal({
					show: true
				});
				this.message4Add = {id: 0, name: "", title: "", content: ""};
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