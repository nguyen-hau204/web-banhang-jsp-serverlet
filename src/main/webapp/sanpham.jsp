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
<form action="/themsp" method="post">
  <div class="mb-3">
    <label  class="form-label">mã sản phẩm</label>
    <input type="text" class="form-control" name="masp" >
  </div>
  <div class="mb-3">
    <label  class="form-label">tên sản phẩm </label>
    <input type="text" class="form-control" name="tensp">
  </div>
  <div class="mb-3">
    <label  class="form-label"> danh mục </label>
    <select class="form-select" aria-label="Default select example" name="danhmuc">
      <c:forEach items="${list2}" var="list2">
        <option value="${list2.id}">${list2.tenDanhMuc}</option>
      </c:forEach>
    </select>
  </div>

  <div class="mb-3">
    <label  class="form-label">trang thái </label>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="trangthai" id="flexRadioDefault1" value="conhang">
      <label class="form-check-label" for="flexRadioDefault1">
        còn hàng
      </label>
    </div>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="trangthai" id="flexRadioDefault2" value="hehang">
      <label class="form-check-label" for="flexRadioDefault2">
        hết hàng
      </label>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">thêm sản phẩm </button>
</form>

<table class="table">
  <thead>
  <tr>
    <th scope="col">stt</th>
    <th scope="col">id</th>
    <th scope="col">mã sản phẩm</th>
    <th scope="col">mã sản phẩm</th>
    <th scope="col">trạng thái sản phẩm</th>
    <th scope="col">danh mục</th>
    <th scope="col">ngay tao</th>
    <th scope="col">ngay sua</th>
    <th scope="col">thao tác</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="sanpham" varStatus="i">
    <tr>
      <th scope="row">${i.index}</th>
      <td>${sanpham.id}</td>
      <td>${sanpham.maSanPham}</td>
      <td>${sanpham.tenSanPham}</td>
      <td>${sanpham.trangThai}</td>
      <td>${sanpham.danhMuc.tenDanhMuc}</td>
      <td>${sanpham.ngaySua}</td>
      <td>${sanpham.ngayTao}</td>
      <td>
         <a class="btn btn-danger" href="/xoa?id=${sanpham.id}">xóa</a>
         <a class="btn btn-primary" href="/chitiet?id=${sanpham.id}">chi tiết</a>
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
