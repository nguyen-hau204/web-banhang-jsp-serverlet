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
<form method="post" action="/suaHDS?idsp=${listHd.id}">

    <div class="mb-3">
        <label class="form-label">khách hàng</label>
        <select class="form-select" aria-label="Default select example" name="khachHang">
            <c:forEach items="${listkh}" var="s">
                <option value="${s.id}" <c:if test="${listHd.khachHang.id == s.id}">selected</c:if>>
                        ${s.hoTen}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">ngày tạo</label>
        <input type="text" class="form-control" name="ngayTao" value="${listHd.ngayTao}" readonly>
    </div>
    <div class="mb-3">
        <label class="form-label">ngày sửa</label>
        <input type="text" class="form-control" name="ngaySua" value="${listHd.ngaySua}" readonly>
    </div>
    <div class="mb-3">
        <label class="form-label">số điện thoại</label>
        <input type="text" class="form-control" name="sdt" value="${listHd.sdt}" readonly>
    </div>
    <div class="mb-3">
        <label class="form-label">địa chỉ</label>
        <input type="text" class="form-control" name="diaChi" value="${listHd.diaChi}" readonly>
    </div>

    <div class="mb-3">
        <label class="form-label">trạng thái</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangThai" value="dathanhtoan" id="flexRadioDefault1"
                   <c:if test="${listHd.trangThai eq 'dathanhtoan'}">checked</c:if>>
            <label class="form-check-label" for="flexRadioDefault1">
                dathanhtoan
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangThai" value="chuathanhtoan" id="flexRadioDefault2"
                   <c:if test="${listHd.trangThai eq 'chuathanhtoan'}">checked</c:if>>
            <label class="form-check-label" for="flexRadioDefault2">
                chuathanhtoan
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
