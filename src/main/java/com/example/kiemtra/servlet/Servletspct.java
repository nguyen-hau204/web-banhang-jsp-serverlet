package com.example.kiemtra.servlet;

import com.example.kiemtra.model.ChiTietSanPham;
import com.example.kiemtra.model.SanPham;
import com.example.kiemtra.model.Sizes;
import com.example.kiemtra.model.mausacc;
import com.example.kiemtra.reponsitory.SanPhamReponsitory;
import com.example.kiemtra.reponsitory.chiTietSanPhamReponsitory;
import com.example.kiemtra.reponsitory.mauSacreponsitory;
import com.example.kiemtra.reponsitory.sizeReponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "Servletspct", value = {"/sanphamchitiets","/addSPCtS","/xoaspcts","/dentalspct","/suascpts"})
public class Servletspct extends HttpServlet {
      chiTietSanPhamReponsitory chiTietSanPhamReponsitory = new chiTietSanPhamReponsitory();
      SanPhamReponsitory sanPhamReponsitory = new SanPhamReponsitory();

        mauSacreponsitory mauSacreponsitory = new mauSacreponsitory();

         sizeReponsitory sizeReponsitory = new sizeReponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/sanphamchitiets")){
            ArrayList<ChiTietSanPham> list = chiTietSanPhamReponsitory.getlist();
            ArrayList<mausacc> listmc = mauSacreponsitory.getlistMC();
            ArrayList<SanPham> listSp = sanPhamReponsitory.getList();
            ArrayList<Sizes> listSize = sizeReponsitory.getListsize();
            request.setAttribute("listmc",listmc);
            request.setAttribute("listSp",listSp);
            request.setAttribute("listSize",listSize);
            request.setAttribute("list",list);
            request.getRequestDispatcher("/ctsp.jsp").forward(request,response);
        }else if (uri.contains("/xoaspcts")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            ChiTietSanPham chiTietSanPham = chiTietSanPhamReponsitory.getOne(id);
            chiTietSanPhamReponsitory.delete(chiTietSanPham);
            response.sendRedirect("/sanphamchitiets");
        }else if (uri.contains("/dentalspct")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            ChiTietSanPham sanPhamct = chiTietSanPhamReponsitory.getOne(id);
            ArrayList<mausacc> listmc = mauSacreponsitory.getlistMC();
            ArrayList<SanPham> listSp = sanPhamReponsitory.getList();
            ArrayList<Sizes> listSize = sizeReponsitory.getListsize();
            request.setAttribute("listmc",listmc);
            request.setAttribute("listSp",listSp);
            request.setAttribute("listSize",listSize);
            request.setAttribute("sanPhamct",sanPhamct);

            request.getRequestDispatcher("/ctspdental.jsp").forward(request,response);


        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/addSPCtS")){
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
            SanPham sanPham = new SanPham();

            String sanPhamIdStr = request.getParameter("sanpham");
            if (sanPhamIdStr != null && !sanPhamIdStr.isEmpty()) {
                sanPham.setId(Integer.parseInt(sanPhamIdStr));
            }

            String mauIdStr = request.getParameter("mau");
            if (mauIdStr != null && !mauIdStr.isEmpty()) {
                mausacc mausacc = new mausacc();
                mausacc.setId(Integer.parseInt(mauIdStr));
                chiTietSanPham.setMauSac(mausacc);
            }

            String sizeIdStr = request.getParameter("size");
            if (sizeIdStr != null && !sizeIdStr.isEmpty()) {
                Sizes sizes = new Sizes();
                sizes.setId(Integer.parseInt(sizeIdStr));
                chiTietSanPham.setSizes(sizes);
            }

            String trangThai = request.getParameter("trangthai");
            chiTietSanPham.setTrangThai(trangThai);

            String soLuongTonStr = request.getParameter("soluong");
            if (soLuongTonStr != null && !soLuongTonStr.isEmpty()) {
                chiTietSanPham.setSoLuongTon(Integer.parseInt(soLuongTonStr));
            }

            String giaBanStr = request.getParameter("giaban");
            if (giaBanStr != null && !giaBanStr.isEmpty()) {
                chiTietSanPham.setGiaBan(Double.parseDouble(giaBanStr));
            }

            chiTietSanPham.setNgayTao(new Date());
            chiTietSanPham.setNgaySua(new Date());
            chiTietSanPhamReponsitory.add(chiTietSanPham);
            response.sendRedirect("/sanphamchitiets");
        }else if (uri.contains("/suascpts")){
            Integer id = Integer.parseInt(request.getParameter("idsp"));
            ChiTietSanPham chiTietSanPham = chiTietSanPhamReponsitory.getOne(id);
            SanPham sanPham = new SanPham();

            String sanPhamIdStr = request.getParameter("sanpham");
            if (sanPhamIdStr != null && !sanPhamIdStr.isEmpty()) {
                sanPham.setId(Integer.parseInt(sanPhamIdStr));
            }

            String mauIdStr = request.getParameter("mau");
            if (mauIdStr != null && !mauIdStr.isEmpty()) {
                mausacc mausacc = new mausacc();
                mausacc.setId(Integer.parseInt(mauIdStr));
                chiTietSanPham.setMauSac(mausacc);
            }

            String sizeIdStr = request.getParameter("size");
            if (sizeIdStr != null && !sizeIdStr.isEmpty()) {
                Sizes sizes = new Sizes();
                sizes.setId(Integer.parseInt(sizeIdStr));
                chiTietSanPham.setSizes(sizes);
            }

            String trangThai = request.getParameter("trangthai");
            chiTietSanPham.setTrangThai(trangThai);

            String soLuongTonStr = request.getParameter("soluong");
            if (soLuongTonStr != null && !soLuongTonStr.isEmpty()) {
                chiTietSanPham.setSoLuongTon(Integer.parseInt(soLuongTonStr));
            }

            String giaBanStr = request.getParameter("giaban");
            if (giaBanStr != null && !giaBanStr.isEmpty()) {
                chiTietSanPham.setGiaBan(Double.parseDouble(giaBanStr));
            }

            chiTietSanPham.setNgayTao(new Date());
            chiTietSanPham.setNgaySua(new Date());
            chiTietSanPhamReponsitory.add(chiTietSanPham);
            response.sendRedirect("/sanphamchitiets");

        }
    }
}
