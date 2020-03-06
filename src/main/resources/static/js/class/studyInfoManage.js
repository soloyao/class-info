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
			//删除按钮
			deleteItem(id) {
				var _this = this;
				myzui.confirm("确认删除？", function() {
					axios.delete("studyInfos/" + id).then(function(res) {
						_this.list(1);
					}); 
				});
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