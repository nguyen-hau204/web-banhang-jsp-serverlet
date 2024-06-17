<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 3/20/2024
  Time: 12:24 PM
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
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<form action="/hoa-don/update" method="post">
  <div class="mb-3">
    <label  class="form-label">mã hoá đơn </label>
    <input type="text" class="form-control" value="${hoadon.mahoadon}" name="mahd" readonly>
  </div>
   <div class="mb-3">
    <label  class="form-label">số lượng </label>
    <input type="number" class="form-control"value="${hoadon.soluong}" name="soluong">
  </div>
   <div class="mb-3">
    <label  class="form-label">giá bán </label>
    <input type="text" class="form-control" value="${hoadon.giaban}" name="giaban">
  </div>
   <div class="mb-3">
    <label  class="form-label">nhân viên </label>
     <select class="form-select" aria-label="Default select example" name="nhanvien" >
    <c:forEach items="${list2}" var="s">
        <option value="${s}"
                <c:if test="${hoadon.nhanvien eq s}"> selected</c:if>
        >${s}</option>
    </c:forEach>


     </select>

  </div>
   <div class="mb-3">
    <label  class="form-label">mã hoá đơn </label>
       <div class="form-check">
           <input class="form-check-input" type="radio" name="hinhthucthanhtoan" id="flexRadioDefault1" value="chuyenkhoan"
                  <c:if test="${hoadon.hinhthucthanhtoan == chuyenkhoan }">checked</c:if>>
           <label class="form-check-label" for="flexRadioDefault1">
              chuyển khoản
           </label>
       </div>
       <div class="form-check">
           <input class="form-check-input" type="radio" name="hinhthucthanhtoan" id="flexRadioDefault2" value="tienmat"

           <c:if test="${hoadon.hinhthucthanhtoan == tienmat }">checked</c:if>

           >
           <label class="form-check-label" for="flexRadioDefault2">
              tiền mặt
           </label>
       </div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>