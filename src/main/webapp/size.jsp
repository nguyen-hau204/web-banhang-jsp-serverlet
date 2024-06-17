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
<form action="/themsize" method="post">
    <div class="mb-3">
        <label  class="form-label">má size</label>
        <input type="text" class="form-control" name="maSize" >
    </div>
    <div class="mb-3">
        <label  class="form-label">tên size</label>
        <input type="text" class="form-control" name="tenSize">
    </div>

    <div class="mb-3">
        <label  class="form-label">trang thái </label>
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
    <button type="submit" class="btn btn-primary"> thêm size </button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">stt</th>
        <th scope="col">id</th>
        <th scope="col">mã size</th>
        <th scope="col">tên size</th>
        <th scope="col">trạng thái</th>
        <th scope="col">ngày sửa</th>
        <th scope="col">ngày tạo</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSize}" var="size" varStatus="i">
        <tr>
            <th scope="row">${i.index}</th>
            <td>${size.id}</td>
            <td>${size.maSize}</td>
            <td>${size.tenSize}</td>
            <td>${size.trangThai}</td>
            <td>${size.ngaySua}</td>
            <td>${size.ngayTao}</td>
            <td>
                <a  href="/xoaSize?id=${size.id}" class="btn btn-danger"> xoóa</a>
               <a href="/chitietSize?id=${size.id}" class="btn btn-primary"> chi tiết</a>

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
