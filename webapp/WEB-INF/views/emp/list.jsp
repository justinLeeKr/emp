<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원조회</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="/resources/css/exam1.css">
</head>
<body>

<div class="container">
        <table id="employeeTable">
            <!-- 테이블 헤더 -->
            <thead>
                <tr>
                    <th>사번</th>
                    <th>이름</th>
                    <th>직무</th>
                    <th>상사</th>
                    <th>급여</th>
                </tr>
            </thead>

            <!-- 사원목록출력 -->
            <tbody id="employeeList">
                <c:forEach var="employee" items="${employeeList}">
                    <tr>
                        <td><a href="#" class="deleteEmployee" data-empno=
                        "${employee.empno}">${employee.empno}</a></td>
                        <td>${employee.ename}</td>
                        <td>${employee.job}</td>
                        <td><a href="${pageContext.request.contextPath}
                        /employee/read?empno=${employee.mgr}">${employee.mgr}</a></td>
                        <td>${employee.sal}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</div>

<script>
    $(document).ready(function() {
        $('.deleteEmployee').click(function(event) {
            event.preventDefault();
            var empno = $(this).data('empno');
            deleteEmployee(empno);
        });

        function deleteEmployee(empno) {
            if (confirm('')) {
                $.ajax({
                    type: 'DELETE',
                    url: '${pageContext.request.contextPath}/emp/remove/' + empno,
                    success: function(data) {
                        if (data === 'success') {
                            alert('success');
                            // 페이지 새로고침
                            location.reload();
                        } else {
                            alert('사원 정보 삭제 실패');
                        }
                    },
                    error: function() {
                        alert('사원 정보 삭제 실패');
                    }
                });
            }
        }
    });
</script>

</body>
</html>
