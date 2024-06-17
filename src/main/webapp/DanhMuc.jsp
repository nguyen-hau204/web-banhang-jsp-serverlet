<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 3/20/2024
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">
<form action="/add-dm" method="post">
    <div class="mb-3">
        <label  class="form-label">mã danh mục</label>
        <input type="text" class="form-control" name="madm" >
    </div>
    <div class="mb-3">
        <label  class="form-label">ten danh mục</label>
        <input type="text" class="form-control" name="tendm">
    </div>

    <div class="mb-3">
        <label  class="form-label">mã hoá đơn </label>
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
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">stt</th>
        <th scope="col">id</th>
        <th scope="col">mã</th>
        <th scope="col">tên </th>
        <th scope="col">trang thái</th>
        <th scope="col">hình thức thanh toán</th>
        <th scope="col">thành tiền</th>
        <th scope="col">thao tác</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="hd" varStatus="i">
    <tr>

        <th scope="row">${i.index+1}</th>
        <td>${hd.id}</td>
        <td>${hd.maDanhMuc}</td>
        <td>${hd.tenDanhMuc}</td>
        <td>${hd.trangThai}</td>
        <td>${hd.ngayTao}</td>
        <td>${hd.ngaySua}</td>
        <td>

            <a href="/ChitietDanhMuc?id=${hd.id}" class="btn btn-dark">chi tiết </a>
            <a href="/xoaDM?id=${hd.id}" class="btn btn-dark">xoa</a>

        </td>

    </tr>
    </c:forEach>


</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
