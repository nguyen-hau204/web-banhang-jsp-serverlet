<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 12/03/2024
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/show">bán hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/sanpham">sản phẩm </a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/sanphamchitiets">chi tiết sản phẩm</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/mausac">màu sắc</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/size">size</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/ServletDanhMuc">danh mục</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/khachhang">khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/hoaDonServlet">hóa đơn</a>

                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/hdcts">hóa đơn chi tiet</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="row">
    <div class="col-7">
        <h2>Danh sách hoá đơn</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Tên khách hàng</td>
                <td>Ngày tạo</td>
                <td>Tổng tiền</td>
                <td>Trạng thái</td>
                <td>Chức năng</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHDTongTien}" var="hdTongTien" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${hdTongTien.hoaDon.id}</td>
                    <td>${hdTongTien.hoaDon.khachHang.hoTen}</td>
                    <td>${hdTongTien.hoaDon.ngayTao}</td>
                    <td>${hdTongTien.tongTien}</td>
                    <td>${hdTongTien.hoaDon.trangThai}</td>
                    <td>
                        <a href="/chonHd?idHDtext=${hdTongTien.hoaDon.id}" class="btn btn-primary"> Chọn </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <h2>Danh sách hoá đơn chi tiết</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten san pham</td>
                <td>So luong</td>
                <td>Gia ban</td>
                <td>Tong tien</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listhdct}" var="hdct" varStatus="i" >
                <tr>
                    <td>${i.index+1}</td>
                    <td>${hdct.id}</td>
                    <td>${hdct.chiTietSanPham.sanPham.tenSanPham}</td>
                    <td>${hdct.soLuongMua}</td>
                    <td>${hdct.chiTietSanPham.giaBan}</td>
                    <td>${hdct.tongTien}</td>
                    <td>

                         <a href="/congslsp?idspct=${hdct.chiTietSanPham.id}&idHDtext=${hoadonf.id}&idspgh=${hdct.id}"class="btn btn-success" >+</a>
                        <a href="/truslsp?idspct=${hdct.chiTietSanPham.id}&idHDtext=${hoadonf.id}&idspgh=${hdct.id}" class="btn btn-warning" >-</a>
                        <a href="/xoaspgh?idspgh=${hdct.id}&idHDtext=${hoadonf.id}" class="btn btn-danger" > xóa sản phẩm</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="col-5">
        <h2>Tạo hoá đơn</h2>
        <div class="row">
            <div>
                <div>
                    <label class="mb-3 col-3">Số điện thoại</label>
                    <form class="d-flex" action="/timkh" method="post">
                        <input class="form-control me-2" type="text" name="sdt" placeholder="Số điện thoại" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Tìm</button>
                    </form>

                </div>
<%--                <a href="/timkh"   class="btn btn-primary">Tìm</a>--%>
            </div>
            <div class="col-5">
                <h2>Tạo hoá đơn</h2>
                <form action="/taoHoaDon" method="post"> <!-- Thay đổi action tùy theo địa chỉ xử lý form của bạn -->
                    <div>
                        <label class="mb-3 col-3">Số điện thoại</label>
                        <input type="text" class="col-7" id="sdt" name="sdt" value="${khachhang.sdt}"   readonly>
                    </div>
                    <div class="mb-3">
                        <label class="col-3">Ten Khach hang</label>
                        <input type="text" class="col-7" readonly name="khachhang" value="${khachhang.hoTen}">
                    </div>
                    <div class="mb-3">
                        <label class="col-3">ID Hoa don</label>
                        <input type="text" class="col-7" readonly value="${hoadonf.id}" name="idHDtext">
                    </div>
                    <div class="mb-3">
                        <label class="col-3">Tong tien</label>
                        <input type="text" class="col-7" value="${tongtien}" readonly>
                    </div>
                    <div>
                        <input type="hidden" name="sdtAn" value="${khachhang.sdt}"> <!-- Trường ẩn chứa số điện thoại -->
                        <button type="submit" class="btn btn-primary">Tạo hóa đơn</button>
                        <a href="/thanhtoan?idHDtext=${hoadonf.id}"  class="btn btn-primary">Thanh toán</a>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


    <div>
        <h2>Danh sách chi tiếtsản phẩm</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID CTSP</td>
                <td>Ten san pham</td>
                <td>Mau sac</td>
                <td>Size</td>
                <td>Gia ban</td>
                <td>So luong ton</td>
                <td>Trang Thai</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSPCT}" var="sp" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${sp.id}</td>
                    <td>${sp.sanPham.tenSanPham}</td>
                    <td>${sp.mauSac.tenMau}</td>
                    <td>${sp.sizes.tenSize}</td>
                    <td>${sp.giaBan}</td>
                    <td>${sp.soLuongTon}</td>
                    <td>${sp.trangThai}</td>

                    <td>
                        <a href="/chonSp?idSP=${sp.id}&idHDtext=${hoadonf.id}" class="btn btn-primary">Chọn mua</a>

                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>



</script>
</body>
</html>
