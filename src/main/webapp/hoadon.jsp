<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 3/22/2024
  Time: 3:50 PM
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


<form action="/hoaDon/add" method="post">
    <div class="mb-3">
        <label  class="form-label">id khach hang</label>
        <select class="form-select" aria-label="Default select example" name="khachHang">
            <c:forEach items="${listkh}" var="s">
                <option value="${s.id}">${s.hoTen}</option>
            </c:forEach>
        </select>
    </div>

    <label  class="form-label">Trang Thai</label>
    <div class="form-check">
        <input class="form-check-input" type="radio" value="chuathanhtoan" name="trangThai" id="flexRadioDefault1">
        <label class="form-check-label" for="flexRadioDefault1">
            chưa thanh toán
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" value="dathantoan" name="trangThai" id="flexRadioDefault2" checked>
        <label class="form-check-label" for="flexRadioDefault2">
            đã thanh toán
        </label>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">ten khach hang</th>
        <th scope="col">Trang Thai</th>
        <th scope="col">Ngay tao</th>
        <th scope="col">Ngay sua</th>
        <th scope="col">Dia chi</th>
        <th scope="col">So dien thoai</th>
        <th scope="col">Chuc Nang</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listHd}" var="hoaDon" varStatus="i">
        <tr>
            <td>${hoaDon.id}</td>
            <td>${hoaDon.khachHang.hoTen}</td>
            <td>${hoaDon.trangThai}</td>
            <td>${hoaDon.ngayTao}</td>
            <td>${hoaDon.ngaySua}</td>
            <td>${hoaDon.khachHang.diaChi}</td>
            <td>${hoaDon.khachHang.sdt}</td>
            <td>
                <a class="btn btn-primary" href="/chitietHdS?id=${hoaDon.id}">chi tiết</a>
                <a  class="btn btn-danger" href="/hoaDon/xoa?id=${hoaDon.id}">xóa</a>
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