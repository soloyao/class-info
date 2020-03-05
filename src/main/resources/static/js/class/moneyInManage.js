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
					_this.money4Add = {id: 0, name: "", count: 0};
				});
			},
			inMoney(user) {
				$("#inMoneyModal").modal({
					show: true
				});
				this.money4Add = {id: 0, name: user.name, count: 0};
			},
			listAllMoney() {
				var _this = this;
				var url = "allMoney";
				axios.get(url).then(function(res) {
					_this.allMoney = res.data;
				});
			},
			list(start) {
				var _this = this;
				_this.isLoading = true;
				var url = "users?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.users = res.data.list;
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