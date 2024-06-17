package com.example.kiemtra.servlet;

import com.example.kiemtra.model.KhachHang;
import com.example.kiemtra.model.mausacc;
import com.example.kiemtra.reponsitory.KhachHangReponsitory;
import com.example.kiemtra.reponsitory.mauSacreponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ServletKhachHang", value = {"/khachhang", "/themkh" , "/xoakh","/chitietkh","/suakhachHang"})
public class ServletKhachHang extends HttpServlet {
    KhachHangReponsitory khachHangReponsitory = new KhachHangReponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/khachhang")){
            ArrayList<KhachHang> list = khachHangReponsitory.getList();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/khachHang.jsp").forward(request,response);
        }else if (uri.contains("/xoakh")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            KhachHang khachHang = khachHangReponsitory.getOne(id);
            khachHangReponsitory.delete(khachHang);
            response.sendRedirect("/khachhang");
        }else if (uri.contains("/chitietkh")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            KhachHang khachHang = khachHangReponsitory.getOne(id);
            request.setAttribute("khachHang",khachHang);
            request.getRequestDispatcher("/khachhangDental.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/themkh")){
            KhachHang khachHang = new KhachHang();
            khachHang.setHoTen(request.getParameter("tenkhach"));
            khachHang.setDiaChi(request.getParameter("diachi"));
            khachHang.setSdt(request.getParameter("sdt"));
            khachHang.setTrangThai(request.getParameter("trangthai"));
            khachHang.setNgayTao(new Date());
            khachHang.setNgaySua(new Date());
            khachHangReponsitory.addAndupdate(khachHang);
            response.sendRedirect("/khachhang");
        }else if (uri.contains("suakhachHang")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            KhachHang khachHang = khachHangReponsitory.getOne(id);
            khachHang.setHoTen(request.getParameter("tenkhach"));
            khachHang.setDiaChi(request.getParameter("diachi"));
            khachHang.setSdt(request.getParameter("sdt"));
            khachHang.setTrangThai(request.getParameter("trangthai"));
            khachHang.setNgayTao(new Date());
            khachHang.setNgaySua(new Date());
            khachHangReponsitory.addAndupdate(khachHang);
            response.sendRedirect("/khachhang");
        }
    }
}
