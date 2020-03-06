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
			//发布留言框中发布按钮
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
			//页面上方留言按钮
			add() {
				$("#messageModal").modal({
					show: true
				});
				this.message4Add = {id: 0, name: "", title: "", content: ""};
			},
			//根据页数获取数据
			list(start) {
				var _this = this;
				_this.isLoading = true;
				//传入参数：页码，关键词，一页记录大小
				var url = "messages?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.messages = res.data.list;
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