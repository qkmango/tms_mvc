$(function() {
	var $inputs = $("input");
	var id = $('#id')[0];
	var password = $('#password')[0];
	var button = $('#login_btn')[0];
	var $error_tips = $(".tip");
	var id_errorTip = $error_tips[0];
	var password_errorTip = $error_tips[1];

	id.onblur = chechid;
	
	password.onblur = checkPassword;
	
	function chechid() {
		if(check(id.value)) {
			id_errorTip.innerText='';
			return true;
		} else{
			id_errorTip.innerText='用户名长度不合法';
			return false;
		}
	}
	
	function checkPassword() {
		if(check(password.value)) {
			password_errorTip.innerText='';
			return true;
		} else{
			password_errorTip.innerText='密码长度不合法';
			return false;
		}
	}

	//登陆按钮绑定监听时间 登陆
	button.onclick = function() {
		if(chechid() & checkPassword()) {
			login()
		}
	}

})

function check(str) {
	// if(str.length>=5 && str.length <=10) {
	// 	return true;
	// }
	// return false;
	
	return true;
}

function login() {
	$.ajax({
		url:"system/login.do",
		data:{
			id:$.trim($("#id").val()),
			password:$.trim($("#password").val()),
			userType:$('#userType').val()
		},
		type:"post",
		dataType:"json",
		success:function (data) {
			if (data.success) {
				console.log("登陆成功");
				window.location.href = "index.html";
			} else{
				cocoMessage.error(2000,"登陆失败，用户名或密码错误")
			}
		}
	})
}