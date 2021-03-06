$(function() {
	var data4Vue = {
		classInfos: [],
		classInfo4Add: {id: 0, name: "", title: "", content: ""},
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
					axios.delete("classInfos/" + id).then(function(res) {
						_this.list(1);
					});
				});
			},
			//修改按钮
			updateItem(c) {
				var _this = this;
				$("#classInfoModal").modal({
					show: true
				});
				this.classInfo4Add.id = c.id;
				this.classInfo4Add.name = c.name;
				this.classInfo4Add.title = c.title;
				this.classInfo4Add.content = c.content;
			},
			//发表按钮
			submit() {
				var _this = this;
				if (!_this.classInfo4Add.title || !_this.classInfo4Add.content) {
					myzui._error("必填参数不能为空");
					return;
				}
				var url = "classInfos";
				if (_this.classInfo4Add.id == 0) {//新增
					axios.post(url, _this.classInfo4Add).then(function(res) {
						$("#classInfoModal").modal("hide");
						myzui._success("班级消息发表成功");
						_this.list(1);
						_this.classInfo4Add = {id: 0, name: "", title: "", content: ""};
					});
				} else {//修改
					axios.put(url, _this.classInfo4Add).then(function(res) {
						$("#classInfoModal").modal("hide");
						myzui._success("修改成功");
						_this.list(1);
						_this.classInfo4Add = {id: 0, name: "", title: "", content: ""};
					});
				}
			},
			//发布班级消息按钮
			add() {
				$("#classInfoModal").modal({
					show: true
				});
				this.classInfo4Add = {id: 0, name: "", title: "", content: ""};
			},
			//根据页数获取数据
			list(start) {
				var _this = this;
				_this.isLoading = true;
				//传入参数：页码，关键词，一页记录大小
				var url = "classInfos?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.classInfos = res.data.list;
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