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

<form method="post" action="/addSPCtS">

    <div class="mb-3">
        <label class="form-label">sản phẩm</label>
        <select class="form-select" aria-label="Default select example" name="sanpham">
          <c:forEach items="${listSp}" var="s">
              <option value="${s.id}">${s.tenSanPham}</option>
          </c:forEach>

        </select>
    </div>
  <div class="mb-3">
        <label class="form-label">size</label>
        <select class="form-select" aria-label="Default select example" name="size">
            <c:forEach items="${listSize}" var="s">
                <option value="${s.id}">${s.tenSize}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">màu</label>
        <select class="form-select" aria-label="Default select example" name="mau">
            <c:forEach items="${listmc}" var="s">
                <option value="${s.id}">${s.tenMau}</option>
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
        <th scope="col">mã sản phẩm</th>
        <th scope="col">màu</th>
        <th scope="col">size</th>
        <th scope="col">số lượng tồn kho</th>
        <th scope="col">Giá bán </th>
        <th scope="col">trạng thái</th>
        <th scope="col">ngày tạo</th>
        <th scope="col">ngày sửa</th>
        <th scope="col">thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="spct" varStatus="i">
        <tr>
            <th scope="row">${i.index}</th>
            <td>${spct.id}</td>
            <td>${spct.sanPham.maSanPham}</td>
            <td>${spct.mauSac.tenMau}</td>
            <td>${spct.sizes.tenSize}</td>
            <td>${spct.soLuongTon}</td>
            <td>${spct.giaBan}</td>
            <td>${spct.trangThai}</td>
            <td>${spct.ngayTao}</td>
            <td>${spct.ngaySua}</td>

            <td>
                <a href="/dentalspct?id=${spct.id}" class   ="btn btn-primary">chi tiết</a>
                <a href="/xoaspcts?id=${spct.id}" class="btn btn-danger">xóa</a>
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
