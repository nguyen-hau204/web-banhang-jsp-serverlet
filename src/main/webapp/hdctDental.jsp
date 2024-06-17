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

<form method="post" action="/suahdcts?id=${hdct.id}">

  <div class="mb-3">
    <label class="form-label">id hóa đơn</label>
    <select class="form-select" aria-label="Default select example" name="idhds">
      <c:forEach items="${listHD}" var="s">
        <option value="${s.id}"

                <c:if test="${hdct.hoadon.id == s.id}">selected</c:if>

        >${s.id}</option>
      </c:forEach>
    </select>
  </div>
  <div class="mb-3">
    <label class="form-label">sản phẩm</label>
    <select class="form-select" aria-label="Default select example" name="idhds">
      <c:forEach items="${listSPCT}" var="s">
        <option value="${s.id}"

                <c:if test="${hdct.chiTietSanPham.id == s.id}">selected</c:if>
        >${s.sanPham.tenSanPham}</option>
      </c:forEach>
    </select>
  </div>


  <div class="mb-3">
    <label class="form-label">số lượng</label>
    <input type="number" class="form-control" name="soluong" value="${hdct.soLuongMua}">
  </div>
  <div class="mb-3">
    <label class="form-label">giá bán</label>
    <input type="text" class="form-control" name="giaban" value="${hdct.soLuongMua}">
  </div>
  <div class="mb-3">
    <label class="form-label">ngày tạo</label>
    <input type="text" class="form-control" name="ngaytao" value="${hdct.ngayTao}">
  </div>
  <div class="mb-3">
    <label class="form-label">trạng thái</label>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="trangthai"  value="conhang" id="flexRadioDefault1"


      <c:if test="${hdct.trangThai eq 'conhang'}">checked</c:if>

      >
      <label class="form-check-label" for="flexRadioDefault1">
        còn hàng
      </label>
    </div>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="trangthai"  value="hethang" id="flexRadioDefault2"

             <c:if test="${hdct.trangThai eq 'hethang'}">checked</c:if>
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
