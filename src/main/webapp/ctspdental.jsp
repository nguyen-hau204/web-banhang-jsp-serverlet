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

<form method="post" action="/suascpts?idsp=${sanPhamct.id}">

  <div class="mb-3">
    <label class="form-label">sản phẩm</label>
    <select class="form-select" aria-label="Default select example" name="sanpham">
      <c:forEach items="${listSp}" var="s">
        <option value="${s.id}"
                <c:if test="${sanPhamct.sanPham.id == s.id}">  selected</c:if>
        >${s.tenSanPham}</option>
      </c:forEach>

    </select>
  </div>
  <div class="mb-3">
    <label class="form-label">size</label>
    <select class="form-select" aria-label="Default select example" name="size">
      <c:forEach items="${listSize}" var="s">
        <option value="${s.id}"
                <c:if test="${sanPhamct.sizes.id == s.id}">  selected</c:if>
        >${s.tenSize}</option>
      </c:forEach>
    </select>
  </div>
  <div class="mb-3">
    <label class="form-label">màu</label>
    <select class="form-select" aria-label="Default select example" name="mau">
      <c:forEach items="${listmc}" var="s">
        <option value="${s.id}" disabled
                <c:if test="${sanPhamct.mauSac.id == s.id}">  selected</c:if>
        >${s.tenMau}</option>
      </c:forEach>
    </select>
  </div>

  <div class="mb-3">
    <label class="form-label">số lượng</label>
    <input type="number" class="form-control" name="soluong" value="${sanPhamct.soLuongTon}">
  </div>
  <div class="mb-3">
    <label class="form-label">giá bán</label>
    <input type="number" class="form-control" name="giaban" value="${sanPhamct.giaBan}">
  </div>
  <div class="mb-3">
    <label class="form-label">trạng thái</label>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="trangthai"  value="conhang" id="flexRadioDefault1"

      <c:if test="${sanPhamct.trangThai eq 'conhang'}">  checked</c:if>
      >
      <label class="form-check-label" for="flexRadioDefault1">
        còn hàng
      </label>
    </div>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="trangthai"  value="hethang" id="flexRadioDefault2"
      <c:if test="${sanPhamct.trangThai eq 'hethang'}">  checked</c:if>>
      <label class="form-check-label" for="flexRadioDefault2">
        hết hàng
      </label>
    </div>
  </div>

  <button type="submit" class="btn btn-primary">sửa</button>
</form>


</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous">

</script>
</body>
</html>
