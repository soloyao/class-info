$(function() {
	var data4Vue = {
		moneyOuts: [],
		users: [],
		money4Add: {id: 0, content: "", count: 0},
		money4AddUser: {id: 0, content: "", count: 0, users: ""},
		pagination: {},
		keyword: "",
		userKeyword: "",
		allMoney: 0,
		isLoading: false,
		size: 15
	};
	
	var vue = new Vue({
		el: "#app",
		data: data4Vue,
		mounted: function() {
			this.list(1);
			this.listAllMoney();
			this.listUser();
		},
		methods: {
			//表格前面的全选框
			checkboxAllUser() {
				if (!this.checkboxAllFlag) {
					$(".checkbox-parentUser").addClass("checked");
					$(".checkbox-childrenUser").addClass("checked");
					this.checkboxAllFlag = true;
				} else {
					$(".checkbox-parentUser").removeClass("checked");
					$(".checkbox-childrenUser").removeClass("checked");
					this.checkboxAllFlag = false;
				}
			},
			//单行前面的单选框
			checkboxUser(e) {
				var el = e.target;
				$(el).parent(".checkbox-primary").toggleClass("checked");
				var allFlag = true;
				$(".checkbox-childrenUser").map(function(item, ele) {
					if (!$(ele).hasClass("checked")) {
						allFlag = false;
					}
				});
				if (allFlag) {
					$(".checkbox-parentUser").addClass("checked");
				} else {
					$(".checkbox-parentUser").removeClass("checked");
				}
			},
			//表格前面的全选框
			checkboxAll() {
				if (!this.checkboxAllFlag) {
					$(".checkbox-parentMoneyOut").addClass("checked");
					$(".checkbox-childrenMoneyOut").addClass("checked");
					this.checkboxAllFlag = true;
				} else {
					$(".checkbox-parentMoneyOut").removeClass("checked");
					$(".checkbox-childrenMoneyOut").removeClass("checked");
					this.checkboxAllFlag = false;
				}
			},
			//单行前面的单选框
			checkbox(e) {
				var el = e.target;
				$(el).parent(".checkbox-primary").toggleClass("checked");
				var allFlag = true;
				$(".checkbox-childrenMoneyOut").map(function(item, ele) {
					if (!$(ele).hasClass("checked")) {
						allFlag = false;
					}
				});
				if (allFlag) {
					$(".checkbox-parentMoneyOut").addClass("checked");
				} else {
					$(".checkbox-parentMoneyOut").removeClass("checked");
				}
			},
			//班费缴纳框中缴纳班费按钮
			submit() {
				var _this = this;
				if (_this.money4Add.count <= 0 || _this.money4Add.count > _this.allMoney) {
					myzui._error("缴纳金额必须大于0且小于班费总额");
					return;
				}
				if (!_this.money4Add.content) {
					myzui._error("必填参数不能为空");
					return;
				}
				var url = "moneyOuts";
				axios.post(url, _this.money4Add).then(function(res) {
					$("#outMoneyModal").modal("hide");
					myzui._success("支出成功");
					_this.list(1);
					_this.listUser();
					_this.listAllMoney();
					_this.money4Add = {id: 0, content: "", count: 0};
				});
			},
			submitUser() {
				var _this = this;
				if (_this.money4AddUser.count <= 0 || _this.money4AddUser.count > _this.allMoney) {
					myzui._error("缴纳金额必须大于0且小于班费总额");
					return;
				}
				if (!_this.money4AddUser.content) {
					myzui._error("必填参数不能为空");
					return;
				}
				var url = "moneyOutsUser";
				axios.post(url, _this.money4AddUser).then(function(res) {
					$("#outMoneyModalUser").modal("hide");
					myzui._success("支出成功");
					_this.list(1);
					_this.listUser();
					_this.listAllMoney();
					_this.money4AddUser = {id: 0, content: "", count: 0, users: ""};
				});
			},
			outUserMoney() {
				var str = $(".userTbody .checked").map(function(item, ele) {
					return $(ele).data("id");
				}).get().join(",");
				if (!str) {
					myzui._error("请先选择需要支出班费的学生");
					return;
				}
				var _this = this;
				$("#outMoneyModalUser").modal({
					show: true
				});
				this.money4AddUser = {id: 0, content: "", count: 0, users: str};
			},
			//表格中缴纳班费按钮
			outMoney() {
				var _this = this;
				$("#outMoneyModal").modal({
					show: true
				});
				this.money4Add = {id: 0, content: "", count: 0};
			},
			//获取剩余班费总额
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
				var url = "moneyOuts?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.moneyOuts = res.data.list;
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
			},
			listUser() {
				var _this = this;
				var url = "allUsers?keyword=" + _this.userKeyword;
				axios.get(url).then(function(res) {
					_this.users = res.data;
				});
			},
			resetUser() {
				var _this = this;
				$("#userKeyword").val("");
				_this.userKeyword = $("#userKeyword").val();
				_this.listUser();
			},
			searchUser() {
				var _this = this;
				_this.userKeyword = $("#userKeyword").val();
				if (_this.userKeyword) {
					_this.listUser();
				}
			}
		}
	});
});