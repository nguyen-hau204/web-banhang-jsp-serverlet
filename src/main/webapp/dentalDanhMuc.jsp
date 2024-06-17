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
<body class="container">
<form action="/suaDM?id=${danhmuc.id}" method="post">
    <div class="mb-3">
        <label  class="form-label">mã danh mục</label>
        <input type="text" class="form-control" name="madm" value="${danhmuc.maDanhMuc}" >
    </div>
    <div class="mb-3">
        <label  class="form-label">tên danh mục </label>
        <input type="text" class="form-control" name="tendm"  value="${danhmuc.tenDanhMuc}">
    </div>

    <div class="mb-3">
        <label  class="form-label">ngày đặt </label>
        <input type="text" class="form-control" name="tensp"  value="${danhmuc.ngayTao}">
    </div>
    <div class="mb-3">
        <label  class="form-label"> ngày sửa </label>
        <input type="text" class="form-control" name="tensp"  value="${danhmuc.ngaySua}">
    </div>



    <div class="mb-3">
        <label  class="form-label">trang thái </label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangthai" id="flexRadioDefault1" value="khonghoatdong" readonly

            <c:if test="${danhmuc.trangThai == 'khonghoatdong'}"> checked </c:if>

            >
            <label class="form-check-label" for="flexRadioDefault1">
                khonghoatdong
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangthai" id="flexRadioDefault2" value="hoatdong" readonly
            <c:if test="${danhmuc.trangThai == 'hoatdong'}"> checked </c:if>
            >
            <label class="form-check-label" for="flexRadioDefault2">
                hoatdong
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">sửa</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>