<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 3/25/2024
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 3/22/2024
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="/themkh" method="post">
    <div class="mb-3">
        <label  class="form-label">ten khách </label>
        <input type="text" class="form-control" name="tenkhach" >
    </div>
    <div class="mb-3">
        <label  class="form-label">dia chi  </label>
        <input type="text" class="form-control" name="diachi">
    </div>

    <div class="mb-3">
        <label  class="form-label">sdt</label>
        <input type="text" class="form-control" name="sdt">
    </div>

    <div class="mb-3">
        <label  class="form-label">trang thái </label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangthai" id="flexRadioDefault1" value="Active">
            <label class="form-check-label" for="flexRadioDefault1">
                Active
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangthai" id="flexRadioDefault2" value="Inactive">
            <label class="form-check-label" for="flexRadioDefault2">
                Inactive
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">thêm  khách hàng</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">stt</th>
        <th scope="col">id</th>
        <th scope="col">họ tên</th>
        <th scope="col">địa chỉ</th>
        <th scope="col">trạng thái</th>
        <th scope="col">ngày sửa</th>
        <th scope="col">ngày tạo</th>
        <th scope="col">thao taác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="kh" varStatus="i">
        <tr>
            <th scope="row">${i.index}</th>
            <td>${kh.id}</td>
            <td>${kh.hoTen}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.trangThai}</td>
            <td>${kh.ngaySua}</td>
            <td>${kh.ngayTao}</td>
            <td>
                <a href="/xoakh?id=${kh.id}" class="btn btn-danger">xóa</a>
                <a  href="/chitietkh?id=${kh.id}"  class="btn btn-primary"> chi tiết</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>

