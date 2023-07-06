<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
<h1>이젠 사원정보 등록</h1>>
	<form id="employeeJoin" method="post">
		<table>
			<tr>
				<td>사번</td>
				<td><input name="empNo"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="eName"></td>
			</tr>
			<tr>
				<td>직무</td>
				<td><input name="job"></td>
			</tr>
			<tr>
				<td>상사</td>
				<td><input name="mgr"></td>
			</tr>

			<tr>
				<td>급여</td>
				<td><input name="sal"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" class="join_button" value="등록"></td>
			</tr>
		</table>
	</form>



	<script>
		/* 사원등록 결과 얼럿 */
		$(".join_button").click(function() {

			$.ajax({
				url : "/emp/write",
				type : "POST",
				data : $("#employeeJoin").serialize(),
				success : function(response) {
					alert("사원등록 완료");
					window.location.href = "/"; 
				},
				error : function(xhr, status, error) {
					alert("사원등록 실패");
					console.log(error);
				}
			});
		});
	</script>
</body>
</html>