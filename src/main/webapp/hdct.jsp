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

<form method="post" action="/addhdcts">

    <div class="mb-3">
        <label class="form-label">id hóa đơn</label>
        <select class="form-select" aria-label="Default select example" name="idhds">
            <c:forEach items="${listHD}" var="s">
                <option value="${s.id}">${s.id}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">sản phẩm</label>
        <select class="form-select" aria-label="Default select example" name="idhds">
            <c:forEach items="${listSPCT}" var="s">
                <option value="${s.id}">${s.sanPham.tenSanPham}</option>
            </c:forEach>
        </select>
    </div>


    <div class="mb-3">
        <label class="form-label">số lượng</label>
        <input type="number" class="form-control" name="soluong">
    </div>
    <div class="mb-3">
        <label class="form-label">giá bán</label>
        <input type="text" class="form-control" name="giaban">
    </div>
    <div class="mb-3">
        <label class="form-label">trạng thái</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangthai"  value="conhang" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
                còn hàng
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangthai"  value="hethang" id="flexRadioDefault2" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                hết hàng
            </label>
        </div>
    </div>

    <button type="submit" class="btn btn-primary">thêm</button>
</form>


<table class="table">
    <thead>
    <tr>
        <th scope="col">stt</th>
        <th scope="col">id</th>
        <th scope="col">id hóa đơn</th>
        <th scope="col"> sản phẩm</th>
        <th scope="col">so luong mua</th>
        <th scope="col">giaBan</th>
        <th scope="col">tongTien </th>
        <th scope="col">trạng thái</th>
        <th scope="col">ngày tạo</th>
        <th scope="col">ngày sửa</th>
        <th scope="col">thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listHDCT}" var="hdct" varStatus="i">
        <tr>
            <th scope="row">${i.index}</th>
            <td>${hdct.id}</td>
            <td>${hdct.hoadon.id}</td>
            <td>${hdct.chiTietSanPham.sanPham.tenSanPham}</td>
            <td>${hdct.soLuongMua}</td>
            <td>${hdct.giaBan}</td>
            <td>${hdct.tongTien}</td>
            <td>${hdct.trangThai}</td>
            <td>${hdct.ngayTao}</td>
            <td>${hdct.ngaySua}</td>

            <td>
                <a href="/chitiethdct?id=${hdct.id}" class   ="btn btn-primary">chi tiết</a>
                <a href="/xoahdcts?id=${hdct.id}" class="btn btn-danger">xóa</a>
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
