$(function() {
	var data4Vue = {
		users: [],
		money4Add: {id: 0, name: "", count: 0},
		pagination: {},
		keyword: "",
		isLoading: false,
		size: 15,
		allMoney: 0
	};
	
	var vue = new Vue({
		el: "#app",
		data: data4Vue,
		mounted: function() {
			this.list(1);
			this.listAllMoney();
		},
		methods: {
			//表格前面的全选框
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
			//单行前面的单选框
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
			//班费缴纳框中缴纳按钮
			submit() {
				var _this = this;
				if (_this.money4Add.count <= 0) {
					myzui._error("缴纳金额必须大于0");
					return;
				}
				var url = "moneyIns";
				axios.post(url, _this.money4Add).then(function(res) {
					$("#inMoneyModal").modal("hide");
					myzui._success("缴纳成功");
					_this.list(1);
					_this.listAllMoney();
					_this.money4Add = {id: 0, name: "", count: 0};
				});
			},
			//班费缴纳按钮
			inMoney(user) {
				$("#inMoneyModal").modal({
					show: true
				});
				this.money4Add = {id: 0, name: user.name, count: 0};
			},
			//获取班费剩余总额
			listAllMoney() {
				var _this = this;
				var url = "allMoney";
				axios.get(url).then(function(res) {
					_this.allMoney = res.data;
				});
			},
			//根据页数获取数据
			list(start) {
				var _this = this;
				_this.isLoading = true;
				//传入参数：页码，关键词，一页记录大小
				var url = "users?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.users = res.data.list;
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