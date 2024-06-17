package com.example.kiemtra.servlet;

import com.example.kiemtra.model.DanhMuc;
import com.example.kiemtra.model.KhachHang;
import com.example.kiemtra.reponsitory.DanhMucrepository;
import com.example.kiemtra.reponsitory.KhachHangReponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ServletDanhMuc", value = {"/ServletDanhMuc","/add-dm","/xoaDM","/ChitietDanhMuc","/suaDM"})
public class ServletDanhMuc extends HttpServlet {
    DanhMucrepository danhMucrepository = new DanhMucrepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri  = request.getRequestURI();
        if (uri.contains("/ServletDanhMuc")){
            ArrayList<DanhMuc> list = danhMucrepository.getList();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/DanhMuc.jsp").forward(request,response);
        }else if (uri.contains("/xoaDM")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            DanhMuc danhMuc = danhMucrepository.getOne(id);
            danhMucrepository.delete(danhMuc);
            response.sendRedirect("/ServletDanhMuc");
        }else if (uri.contains("/ChitietDanhMuc")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            DanhMuc danhMuc = danhMucrepository.getOne(id);
            request.setAttribute("danhmuc",danhMuc);
            request.getRequestDispatcher("/dentalDanhMuc.jsp").forward(request,response);
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri  = request.getRequestURI();
        if (uri.contains("/add-dm")){
            DanhMuc dm = new DanhMuc();
            dm.setMaDanhMuc(request.getParameter("madm"));
            dm.setTenDanhMuc(request.getParameter("tendm"));
            dm.setTrangThai(request.getParameter("trangthai"));
            dm.setNgayTao(new Date());
            dm.setNgaySua(new Date());
            danhMucrepository.add(dm);
            response.sendRedirect("/ServletDanhMuc");
        }else if (uri.contains("/suaDM")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            DanhMuc danhMuc = danhMucrepository.getOne(id);
            danhMuc.setMaDanhMuc(request.getParameter("madm"));
            danhMuc.setTenDanhMuc(request.getParameter("tendm"));
            danhMuc.setTrangThai(request.getParameter("trangthai"));
            danhMuc.setNgaySua(new Date());
            danhMucrepository.add(danhMuc);
            response.sendRedirect("/ServletDanhMuc");

        }




    }
}
