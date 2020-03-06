$(function() {
	var data4Vue = {
		studyInfos: [],
		studyInfo4Add: {id: 0, name: "", title: "", content: ""},
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
			//发布学习交流框中发布按钮
			submit() {
				var _this = this;
				var url = "studyInfos";
				if (!_this.studyInfo4Add.title || !_this.studyInfo4Add.content) {
					myzui._error("必填参数不能为空");
					return;
				}
				axios.post(url, _this.studyInfo4Add).then(function(res) {
					$("#studyInfoModal").modal("hide");
					myzui._success("帖子发表成功");
					_this.list(1);
					_this.studyInfo4Add = {id: 0, name: "", title: "", content: ""};
				});
			},
			//发布学习交流贴按钮
			add() {
				$("#studyInfoModal").modal({
					show: true
				});
				this.studyInfo4Add = {id: 0, name: "", title: "", content: ""};
			},
			//根据页数获取数据
			list(start) {
				var _this = this;
				_this.isLoading = true;
				//传入参数：页码，关键词，一页记录大小
				var url = "studyInfos?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.studyInfos = res.data.list;
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