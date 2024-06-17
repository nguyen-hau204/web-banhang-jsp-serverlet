package com.example.kiemtra.servlet;

import com.example.kiemtra.model.mausacc;
import com.example.kiemtra.reponsitory.mauSacreponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ServletMau", value = {"/mausac","/xoamau","/themmau","/suamau","/chitietmau"})
public class ServletMau extends HttpServlet {
            mauSacreponsitory mauSacreponsitory = new mauSacreponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/mausac")){
            mauSacreponsitory mau = new mauSacreponsitory();
            ArrayList<mausacc> list = mau.getlistMC();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/mausac.jsp").forward(request,response);
        }else  if (uri.contains("/xoamau")){
            Integer id = Integer.parseInt(request.getParameter("id"));
             mausacc mc = mauSacreponsitory.getMau(id);
             mauSacreponsitory.xoamau(mc);
             response.sendRedirect("/mausac");

        }else if (uri.contains("/chitietmau")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            mausacc mau = mauSacreponsitory.getMau(id);
            request.setAttribute("mau",mau);
            request.getRequestDispatcher("dentalMau.jsp").forward(request,response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/themmau")){
             mausacc mc = new mausacc();
             mc.setMaMau(request.getParameter("mamau"));
             mc.setTenMau(request.getParameter("tenmau"));
             mc.setTrangThai(request.getParameter("trangthai"));
             mc.setNgaySua(new Date());
             mc.setNgayTao(new Date());
            mauSacreponsitory.themmau(mc);
          response.sendRedirect("/mausac");
        }else if (uri.contains("/suamau")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            mausacc mc = mauSacreponsitory.getMau(id);
            mc.setMaMau(request.getParameter("mamau"));
            mc.setTenMau(request.getParameter("tenmau"));
            mc.setTrangThai(request.getParameter("trangthai"));
            mc.setNgaySua(new Date());
            mc.setNgayTao(new Date());
            mauSacreponsitory.themmau(mc);
            response.sendRedirect("/mausac");
        }
    }
}
