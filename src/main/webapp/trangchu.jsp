<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 3/20/2024
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
<form>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">tên nhân viên</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <button type="submit" class="btn btn-primary">tìm kiếm</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">stt</th>
        <th scope="col">ma hoa don</th>
        <th scope="col">so luong</th>
        <th scope="col">gia ban</th>
        <th scope="col">nhan vien</th>
        <th scope="col">hình thức thanh toán</th>
        <th scope="col">thành tiền</th>
        <th scope="col">thao tác</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list1}" var="hd" varStatus="i">
    <tr>

        <th scope="row">${i.index+1}</th>
        <td>${hd.mahoadon}</td>
        <td>${hd.soluong}</td>
        <td>${hd.giaban}</td>
        <td>${hd.nhanvien}</td>
        <td>${hd.hinhthucthanhtoan}</td>
        <td>${hd.giaban*hd.soluong}</td>
        <td>

            <a href="/hoa-don/chi-tiet?id=${hd.mahoadon}" class="btn btn-dark">chi tiết </a>
            <a href="/hoa-don/xoa?id=${hd.mahoadon}" class="btn btn-dark">xoa</a>

        </td>

    </tr>
    </c:forEach>


</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
