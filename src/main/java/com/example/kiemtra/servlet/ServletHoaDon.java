package com.example.kiemtra.servlet;

import com.example.kiemtra.model.KhachHang;
import com.example.kiemtra.model.hoadon;
import com.example.kiemtra.reponsitory.KhachHangReponsitory;
import com.example.kiemtra.reponsitory.hoaDonReponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ServletHoaDon", value = {"/hoaDonServlet","/hoaDon/add","/suaHDS","/hoaDon/xoa","/chitietHdS"})
public class ServletHoaDon extends HttpServlet {
    hoaDonReponsitory donReposi = new hoaDonReponsitory();
    KhachHangReponsitory khachHangReponsitory = new KhachHangReponsitory();

    ArrayList<hoadon> listHd;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hoaDonServlet")){
            listHd = donReposi.getlistHD();
            ArrayList<KhachHang> listkh = khachHangReponsitory.getList();

            request.setAttribute("listkh",listkh);
            request.setAttribute("listHd",listHd);
            request.getRequestDispatcher("/hoadon.jsp").forward(request,response);
        } else if (uri.contains("/chitietHdS")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            hoadon hoaDondt = donReposi.getOne(id);
            ArrayList<KhachHang> listkh = khachHangReponsitory.getList();
            request.setAttribute("listkh",listkh);
            request.setAttribute("listHd",hoaDondt);
            request.getRequestDispatcher("/dentalHoaDon.jsp").forward(request,response);
        } else if (uri.contains("/hoaDon/xoa")) {
            int id = Integer.parseInt(request.getParameter("id"));
            hoadon hoadon = donReposi.getOne(id);
            donReposi.delete(hoadon);
            response.sendRedirect("/hoaDonServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hoaDon/add")) {

            String trangThai = request.getParameter("trangThai");
            Integer khachHang = Integer.parseInt(request.getParameter("khachHang"));

            KhachHang dm = khachHangReponsitory.getOne(khachHang);
            hoadon hoaDon = new hoadon();
            hoaDon.setKhachHang(dm);
            hoaDon.setTrangThai(trangThai);
            hoaDon.setNgayTao(new Date());
            hoaDon.setNgaySua(new Date());
            hoaDon.setDiaChi(dm.getDiaChi());
            hoaDon.setSdt(dm.getSdt());
            donReposi.add(hoaDon);
            response.sendRedirect("/hoaDonServlet");
        } else if (uri.contains("/suaHDS")) {
            try {
                int id = Integer.parseInt(request.getParameter("idsp"));
                String diaChi = request.getParameter("diaChi");
                String sdt = request.getParameter("sdt");
                String trangThai = request.getParameter("trangThai");
                int khachHangId = Integer.parseInt(request.getParameter("khachHang")); // Lấy ID của khách hàng

                KhachHang dm = khachHangReponsitory.getOne(khachHangId);
                hoadon hoaDon = donReposi.getOne(id);
                hoaDon.setKhachHang(dm);
                hoaDon.setTrangThai(trangThai);
                hoaDon.setNgaySua(new Date());
                hoaDon.setDiaChi(diaChi);
                hoaDon.setSdt(sdt);

                donReposi.add(hoaDon);
                response.sendRedirect("/hoaDonServlet");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("/hoaDonServlet");

            }
        }

    }
}
