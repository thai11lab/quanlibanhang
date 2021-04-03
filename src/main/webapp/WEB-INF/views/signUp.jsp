<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí tài khoản</title>

</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form" >
			<div class="main-div" >
				<form id="formSignUp" method="post">
					<div class="form-group">
						<label for="username" style="float: left;font-size: 15px">Tên tài khoản</label>
						<input type="text" class="form-control" id="userName" name="userName" placeholder="Tên đăng nhập" style="height: 35px;">
						<span style="display: flex;justify-content: flex-start;font-size: 13px;color: red" id="validate-username"></span>
					</div>
					<div class="form-group">
						<label for="username" style="float: left;font-size: 15px" >Họ tên</label>
						<input type="text" class="form-control" id="fullName" name="fullName" placeholder="Họ tên" style="height: 35px;">
						<span style="display: flex;justify-content: flex-start;font-size: 13px;color: red" id="validate-fullName"></span>
					</div>
					<div class="form-group">
						<label for="username" style="float: left;font-size: 15px">Email</label>
						<input type="email" class="form-control" id="email" name="email" placeholder="Email" style="height: 35px;">
						<span style="display: flex;justify-content: flex-start;font-size: 13px;color: red" id="validate-email"></span>
					</div>
					<div class="form-group">
						<label for="username" style="float: left;font-size: 15px">Mật khẩu</label>
						<input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu" style="height: 35px;">
						<span style="display: flex;justify-content: flex-start;font-size: 13px;color: red" id="validate-password"></span>
					</div>
					
					<div class="form-group">
						<label for="username" style="float: left;font-size: 15px">Nhập lại mật khẩu</label>
						<input type="password" class="form-control" id="passwordRe" placeholder="Nhập lại mật khẩu" style="height: 35px;">
						<span style="display: flex;justify-content: flex-start;font-size: 13px;color: red" id="validate-passwordRe"></span>
					</div>
					<div type="submit" class="btn btn-primary" onclick="signUp()">Đăng kí</div>
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function signUp() {
			
			debugger;
			var username = $("#userName").val();
			var	fullName = $("#fullName").val();
			var email = $("#email").val();
			var password = $("#password").val();
			var passwordRe = $("#passwordRe").val();
			var countError = 0;
			
			if(username.trim() == ""){
				$("#validate-username").html("Vui lòng không để trống");
				countError++;
			}
			if(fullName ==""){
				$("#validate-fullName").html("Vui lòng không để trống");
				countError++;
			}
			
			if(email ==""){
				$("#validate-email").html("Vui lòng không để trống");
				countError++;
			}
			
			if(password==""){
				$("#validate-password").html("Vui lòng không để trống");
				countError++;
			}
		    
			if(passwordRe==""){
				$("#validate-passwordRe").html("Vui lòng không để trống");
				countError++;
			}
			
			if(password && passwordRe){
				if(password !== passwordRe){
					$("#validate-passwordRe").html("Phải trùng với mật khẩu đã nhập");
					countError++;
				}else{
					$("#validate-passwordRe").html("");
				}
			}
			
			if(parseInt(countError)==0){
				
			}
			
		}
	</script>
</body>
</html>