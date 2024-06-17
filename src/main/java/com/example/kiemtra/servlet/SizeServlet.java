package com.example.kiemtra.servlet;

import com.example.kiemtra.model.Sizes;
import com.example.kiemtra.reponsitory.sizeReponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "SizeServlet", value = {"/size","/themsize","/xoaSize","/chitietSize","/suasize"})
public class SizeServlet extends HttpServlet {

    sizeReponsitory sizeReponsitory = new sizeReponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String uri = request.getRequestURI();
       if (uri.contains("/size")){
           sizeReponsitory size = new sizeReponsitory();
           ArrayList<Sizes> list = size.getListsize();
           request.setAttribute("listSize",list);
           request.getRequestDispatcher("/size.jsp").forward(request,response);
       } else if (uri.contains("/xoaSize")) {

           Integer id = Integer.parseInt(request.getParameter("id"));

           Sizes sizes = sizeReponsitory.getSize(id);


           sizeReponsitory.deleteSize(sizes);


           response.sendRedirect("/size");



           
       }else if (uri.contains("/chitietSize")){

           Integer id = Integer.parseInt(request.getParameter("id"));
           Sizes sizes = sizeReponsitory.getSize(id);
           request.setAttribute("size",sizes);
           request.getRequestDispatcher("/dentalSize.jsp").forward(request,response);
       }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/themsize")){

            String ma = request.getParameter("maSize");
            String ten = request.getParameter("tenSize");
            String trangthai = request.getParameter("trangthai");

            Sizes sizes = new Sizes();
            sizes.setMaSize(ma);
            sizes.setTenSize(ten);
            sizes.setNgayTao(new Date());
            sizes.setNgaySua(new Date());
            sizes.setTrangThai(trangthai);

            sizeReponsitory sizeReponsitory = new sizeReponsitory();
            sizeReponsitory.add(sizes);

            response.sendRedirect("/size");


        }else if (uri.contains("/suasize")){
            String ma = request.getParameter("maSize");
            String ten = request.getParameter("tenSize");
            String trangthai = request.getParameter("trangthai");
            Integer id = Integer.parseInt(request.getParameter("id"));
            Sizes sizes = sizeReponsitory.getSize(id);
            sizes.setMaSize(ma);
            sizes.setTenSize(ten);
            sizes.setNgaySua(new Date());
            sizes.setTrangThai(trangthai);
            sizeReponsitory.add(sizes);
            response.sendRedirect("/size");

        }
    }
}
