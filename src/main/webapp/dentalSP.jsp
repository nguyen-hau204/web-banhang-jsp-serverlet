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
<form action="/sua?id=${sanpham.id}" method="post">
    <div class="mb-3">
        <label  class="form-label">mã sản phẩm</label>
        <input type="text" class="form-control" name="masp" value="${sanpham.maSanPham}" >
    </div>
    <div class="mb-3">
        <label  class="form-label">tên sản phẩm </label>
        <input type="text" class="form-control" name="tensp"  value="${sanpham.tenSanPham}">
    </div>
    <div class="mb-3">
        <label  class="form-label">trạng thái </label>
        <input type="text" class="form-control" name="tensp"  value="${sanpham.trangThai}">
    </div>
    <div class="mb-3">
        <label  class="form-label">ngày đặt </label>
        <input type="text" class="form-control" name="tensp"  value="${sanpham.ngayTao}">
    </div>
    <div class="mb-3">
        <label  class="form-label"> ngày sửa </label>
        <input type="text" class="form-control" name="tensp"  value="${sanpham.ngaySua}">
    </div>
    <div class="mb-3">
        <label  class="form-label"> trạng thái </label>
        <input type="text" class="form-control" name="tensp"  value="${sanpham.trangThai}">
    </div>

    <div class="mb-3">
        <label  class="form-label"> danh mục </label>
        <select class="form-select" aria-label="Default select example" name="danhmuc">
            <c:forEach items="${list2}" var="list2">
                <option value="${list2.id}"
                <c:if test="${sanpham.danhMuc.tenDanhMuc eq list2.tenDanhMuc}"> selected</c:if>>${list2.tenDanhMuc}</option>
            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label  class="form-label">trang thái </label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangthai" id="flexRadioDefault1" value="conhang" readonly

                   <c:if test="${sanpham.trangThai == 'conhang'}"> checked </c:if>

            >
            <label class="form-check-label" for="flexRadioDefault1">
                còn hàng
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangthai" id="flexRadioDefault2" value="hethang" readonly
            <c:if test="${sanpham.trangThai == 'hethang'}"> checked </c:if>
            >
            <label class="form-check-label" for="flexRadioDefault2">
                hết hàng
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