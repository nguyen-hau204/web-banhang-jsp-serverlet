package com.example.kiemtra.servlet;

import com.example.kiemtra.model.*;
import com.example.kiemtra.reponsitory.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "Servletx", value = {"/show", "/taoHoaDon", "/timkh", "/chonHd", "/chonSp", "/xoaspgh", "/thanhtoan", "/congslsp","/truslsp"})
public class Servletx extends HttpServlet {
    hoaDonReponsitory hoaDonReponsitory = new hoaDonReponsitory();
    SanPhamReponsitory sanPhamReponsitory = new SanPhamReponsitory();
    hdctReopnsitory getHdctReopnsitory = new hdctReopnsitory();

    hdctReopnsitory hdctReopnsitory = new hdctReopnsitory();
    KhachHangReponsitory khachHangReponsitory = new KhachHangReponsitory();

    chiTietSanPhamReponsitory chiTietSanPhamReponsitory = new chiTietSanPhamReponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/show")) {
            this.showall(request, response);
        } else if (uri.contains("/chonHd")) {
            this.chonHd(request, response);
        } else if (uri.contains("/chonSp")) {
            this.chonsp(request, response);
        } else if (uri.contains("/xoaspgh")) {
            this.xoaspgh(request, response);
        } else if (uri.contains("/thanhtoan")) {
            this.thanhtoan(request, response);
        } else if (uri.contains("congslsp")) {
            this.congSl(request, response);
        }else if (uri.contains("truslsp")){
            this.truSl(request, response);

        }


    }

    private void truSl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("idspgh"));
        Integer idhd = Integer.parseInt(request.getParameter("idHDtext"));
        System.out.println("id nhận được là : "+idhd);
        Integer idSP = Integer.parseInt(request.getParameter("idspct"));
        System.out.println("idsp nhận được là : "+idSP);
        ChiTietSanPham chiTietSanPham = chiTietSanPhamReponsitory.getOne(idSP);
        hoadon hd = hoaDonReponsitory.getOne(idhd);
        hdct sptt = hdctReopnsitory.timhdvssp(hd, chiTietSanPham);
        // Sản phẩm đã tồn tại, cập nhật số lượng mua
        if (sptt.getSoLuongMua()<=1){
            xoaspgh(request,response);
        }else {
            sptt.setSoLuongMua(sptt.getSoLuongMua() -1);
            sptt.setTongTien(sptt.getSoLuongMua() * sptt.getGiaBan());
            hdctReopnsitory.add(sptt);
            // cập nhật lại số lượng spct
            chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() +1);
            chiTietSanPhamReponsitory.add(chiTietSanPham);

        }
        chiTietSanPham.setTrangThai("conhang");
        chiTietSanPhamReponsitory.add(chiTietSanPham);
        request.setAttribute("hoadonf", hd);
        chonHd(request, response);
        showall(request, response);
    }

    private void congSl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idhd = Integer.parseInt(request.getParameter("idHDtext"));
        System.out.println("id nhận được là : "+idhd);
        Integer idSP = Integer.parseInt(request.getParameter("idspct"));
        System.out.println("idsp nhận được là : "+idSP);
        ChiTietSanPham chiTietSanPham = chiTietSanPhamReponsitory.getOne(idSP);
        hoadon hd = hoaDonReponsitory.getOne(idhd);
        hdct sptt = hdctReopnsitory.timhdvssp(hd, chiTietSanPham);
        // Sản phẩm đã tồn tại, cập nhật số lượng mua
       if  (chiTietSanPham.getSoLuongTon()==0){
           sptt.setSoLuongMua(sptt.getSoLuongMua() +0);
           sptt.setTongTien(sptt.getSoLuongMua() * sptt.getGiaBan());
           hdctReopnsitory.add(sptt);
           // cập nhật lại số lượng spct
           chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() - 0);
           chiTietSanPhamReponsitory.add(chiTietSanPham);
           chiTietSanPham.setTrangThai("hethang");
           chiTietSanPhamReponsitory.add(chiTietSanPham);
       }else if  (chiTietSanPham.getSoLuongTon()<=1){
            sptt.setSoLuongMua(sptt.getSoLuongMua() +1);
            sptt.setTongTien(sptt.getSoLuongMua() * sptt.getGiaBan());
            hdctReopnsitory.add(sptt);
            // cập nhật lại số lượng spct
            chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() - 1);
            chiTietSanPhamReponsitory.add(chiTietSanPham);
            chiTietSanPham.setTrangThai("hethang");
            chiTietSanPhamReponsitory.add(chiTietSanPham);
        }else {
           sptt.setSoLuongMua(sptt.getSoLuongMua() + 1);
           sptt.setTongTien(sptt.getSoLuongMua() * sptt.getGiaBan());
           hdctReopnsitory.add(sptt);
           // cập nhật lại số lượng spct
           chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() - 1);
           chiTietSanPhamReponsitory.add(chiTietSanPham);
           chiTietSanPham.setTrangThai("conhang");
           chiTietSanPhamReponsitory.add(chiTietSanPham);
       }
        request.setAttribute("hoadonf", hd);
        chonHd(request, response);
        showall(request, response);
    }

    private void thanhtoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idhd = Integer.parseInt(request.getParameter("idHDtext"));
        hoadon hd = hoaDonReponsitory.getOne(idhd);
        System.out.println("hóa đơn tìm được là " + hd);
        hd.setTrangThai("dathanhtoan");
        hoaDonReponsitory.add(hd);
        showall(request, response);

    }

    private void xoaspgh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("idspgh"));
        hdct hdct = hdctReopnsitory.getone(id);
        ChiTietSanPham chiTietSanPham = chiTietSanPhamReponsitory.getOne(hdct.getChiTietSanPham().getId());
        chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() + hdct.getSoLuongMua());
        chiTietSanPhamReponsitory.add(chiTietSanPham);
        hdctReopnsitory.delete(hdct);
        chonHd(request, response);


    }


    private void chonHd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<hdct> listhHdct = new ArrayList<>();
        Integer idhd = Integer.parseInt(request.getParameter("idHDtext"));
        hoadon hd = hoaDonReponsitory.getOne(idhd);
        if (hd != null && hd.getKhachHang() != null) {
            KhachHang khachHang = khachHangReponsitory.getOne(hd.getKhachHang().getId());
            request.setAttribute("khachhang", khachHang);
        }

        listhHdct = hdctReopnsitory.getall2(idhd);

        double tongtien = 0;
        for (hdct hdct : listhHdct) {
            tongtien += hdct.getTongTien();
        }
        request.setAttribute("tongtien", tongtien);

        request.setAttribute("hoadonf", hd);

        request.setAttribute("listhdct", listhHdct);


        showall(request, response);
    }

    private void chonsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idhd = Integer.parseInt(request.getParameter("idHDtext"));
        Integer idSP = Integer.parseInt(request.getParameter("idSP"));
        ChiTietSanPham chiTietSanPham = chiTietSanPhamReponsitory.getOne(idSP);
        hoadon hd = hoaDonReponsitory.getOne(idhd);

        // Kiểm tra xem có khách hàng nào không và set thuộc tính
        if (hd != null && hd.getKhachHang() != null) {
            KhachHang khachHang = khachHangReponsitory.getOne(hd.getKhachHang().getId());
            request.setAttribute("khachhang", khachHang);
        }

        // Tìm hdct hiện tại với sản phẩm đã chọn, nếu có
        hdct sptt = hdctReopnsitory.timhdvssp(hd, chiTietSanPham);

        if (sptt != null) {
            // Sản phẩm đã tồn tại, cập nhật số lượng mua
           if (chiTietSanPham.getSoLuongTon()==1){
               sptt.setSoLuongMua(sptt.getSoLuongMua() + 1);
               sptt.setTongTien(sptt.getSoLuongMua() * sptt.getGiaBan());
               hdctReopnsitory.add(sptt);
               chiTietSanPham.setTrangThai("hethang");
               chiTietSanPhamReponsitory.add(chiTietSanPham);
               chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() - 1);

           }else if (chiTietSanPham.getSoLuongTon()==0){
               sptt.setSoLuongMua(sptt.getSoLuongMua() + 0);
               sptt.setTongTien(sptt.getSoLuongMua() * sptt.getGiaBan());
               hdctReopnsitory.add(sptt);
               chiTietSanPham.setTrangThai("hethang");
               chiTietSanPhamReponsitory.add(chiTietSanPham);
               chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() - 0);
           }else {
               sptt.setSoLuongMua(sptt.getSoLuongMua() + 0);
               sptt.setTongTien(sptt.getSoLuongMua() * sptt.getGiaBan());
               chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon() - 1);
               hdctReopnsitory.add(sptt);

           }



        } else {
            // Sản phẩm không tồn tại, thêm mới
            hdct newHdct = new hdct();
            newHdct.setHoadon(hd);
            newHdct.setChiTietSanPham(chiTietSanPham);
            newHdct.setSoLuongMua(1);
            newHdct.setGiaBan(chiTietSanPham.getGiaBan());
            newHdct.setTongTien(newHdct.getSoLuongMua() * chiTietSanPham.getGiaBan());
            newHdct.setTrangThai("dangban");
            newHdct.setNgayTao(new Date());
            hdctReopnsitory.add(newHdct);
        }


        chiTietSanPhamReponsitory.add(chiTietSanPham);
        request.setAttribute("hoadonf", hd);
        chonHd(request, response);
        showall(request, response);
    }

    private void timkh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sdt = request.getParameter("sdt");
        if (sdt != null && !sdt.trim().equals("")) {
            System.out.println("Số điện thoại lấy được là " + sdt);
            KhachHang khach = khachHangReponsitory.timsdt(sdt);
            if (khach != null) {
                System.out.println("Khách lọc được: " + khach.toString());
            } else {
                System.out.println("Không tìm thấy khách hàng với số điện thoại: " + sdt);
            }
            request.setAttribute("khachhang", khach);
        } else {
            System.out.println("Số điện thoại không hợp lệ.");
        }
        showall(request, response);
    }



    private void taohd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sdt = request.getParameter("sdt");
        System.out.println("sdt nhận được là " + sdt);
        if (sdt != null && !sdt.trim().isEmpty()) {
            KhachHang khach = khachHangReponsitory.timsdt(sdt);
            if (khach != null) {
                hoadon hd = new hoadon();
                // Không cần tạo mới KhachHang ở đây vì bạn đã có khach
                System.out.println(khach.getId());
                // Đặt trực tiếp khach vào hóa đơn thay vì khachHang mới
                hd.setKhachHang(khach); // Sử dụng đối tượng khach đã có
                System.out.println("id khách thêm hd" + khach.getId());
                hd.setTrangThai("chuathanhtoan");
                hd.setNgayTao(new Date());
                hd.setDiaChi("ha noi");
                hd.setSdt(sdt);
                hoaDonReponsitory.add(hd);
            } else {
                // Xử lý trường hợp không tìm thấy khách hàng
                System.out.println("Không tìm thấy khách hàng với SĐT: " + sdt);
                hoadon hd = new hoadon();
                hd.setKhachHang(null); // Sử dụng đối tượng khach đã có
                hd.setTrangThai("chuathanhtoan");
                hd.setNgayTao(new Date());
                hd.setDiaChi("ha noi");
                hd.setSdt(sdt);
                hoaDonReponsitory.add(hd);
            }
        } else {
            // SĐT không hợp lệ hoặc không được cung cấp
            System.out.println("Không tìm thấy khách hàng với SĐT: " + sdt);
            hoadon hd = new hoadon();
            hd.setKhachHang(null); // Sử dụng đối tượng khach đã có
            hd.setTrangThai("chuathanhtoan");
            hd.setNgayTao(new Date());
            hd.setDiaChi("ha noi");
            hd.setSdt(sdt);
            hoaDonReponsitory.add(hd);
        }
        response.sendRedirect("/show");
    }


    private void showall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<hoadon> listHD = hoaDonReponsitory.getlistHD();
        ArrayList<HoaDonTongTien> listHDTongTien = new ArrayList<>();

        for (hoadon hd : listHD) {
            ArrayList<hdct> listhHdct = hdctReopnsitory.getall2(hd.getId());
            double tongtien = 0;
            for (hdct hdct : listhHdct) {
                tongtien += hdct.getTongTien();
            }
            listHDTongTien.add(new HoaDonTongTien(hd, tongtien));
        }


        request.setAttribute("listHDTongTien", listHDTongTien);
        request.setAttribute("listSPCT", chiTietSanPhamReponsitory.getlist());
        request.getRequestDispatcher("/x.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/timkh")) {
            this.timkh(request, response);
        } else if (uri.contains("/taoHoaDon")) {
            this.taohd(request, response);
        }
    }
}
