package com.example.kiemtra.servlet;

import com.example.kiemtra.model.ChiTietSanPham;
import com.example.kiemtra.model.SanPham;
import com.example.kiemtra.model.hdct;
import com.example.kiemtra.model.hoadon;
import com.example.kiemtra.reponsitory.chiTietSanPhamReponsitory;
import com.example.kiemtra.reponsitory.hdctReopnsitory;
import com.example.kiemtra.reponsitory.hoaDonReponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "Servlethdct", value = {"/hdcts","/addhdcts","/xoahdcts","/suahdcts","/chitiethdct"})
public class Servlethdct extends HttpServlet {
    hdctReopnsitory hdctReopnsitory = new hdctReopnsitory();
    chiTietSanPhamReponsitory sanPhamReponsitory = new chiTietSanPhamReponsitory();

    hoaDonReponsitory hoaDonReponsitory = new hoaDonReponsitory();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  uri = request.getRequestURI();
        if(uri.contains("/hdcts")){
            ArrayList<hdct> listHDCT = new ArrayList<>();
            ArrayList<ChiTietSanPham> listSPCT = new ArrayList<>();
            ArrayList<hoadon> listHD = new ArrayList<>();
            listHD = hoaDonReponsitory.getlistHD();
            listHDCT =hdctReopnsitory.getall();
            listSPCT = sanPhamReponsitory.getlist();
            request.setAttribute("listHD",listHD);
            request.setAttribute("listHDCT",listHDCT);
            request.setAttribute("listSPCT",listSPCT);
            request.getRequestDispatcher("/hdct.jsp").forward(request,response);
        }else if (uri.contains("/xoahdcts")){
            Integer id = Integer.parseInt(request.getParameter("id"));
                hdct hdct = hdctReopnsitory.getone(id);
                hdctReopnsitory.delete(hdct);
               response.sendRedirect("/hdcts");

        }else if (uri.contains("/chitiethdct")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            ArrayList<hdct> listHDCT = new ArrayList<>();
            ArrayList<ChiTietSanPham> listSPCT = new ArrayList<>();
            ArrayList<hoadon> listHD = new ArrayList<>();
            listHD = hoaDonReponsitory.getlistHD();
            listHDCT =hdctReopnsitory.getall();
            listSPCT = sanPhamReponsitory.getlist();

            hdct hdct = hdctReopnsitory.getone(id);
            request.setAttribute("hdct",hdct);
            request.setAttribute("listHD",listHD);
            request.setAttribute("listHDCT",listHDCT);
            request.setAttribute("listSPCT",listSPCT);
            request.getRequestDispatcher("/hdctDental.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/addhdcts")){
            hdct hdct = new hdct();
            hoadon hoadon = new hoadon();
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
            hoadon.setId(Integer.parseInt(request.getParameter("idhds")));
            chiTietSanPham.setId(Integer.parseInt(request.getParameter("idhds")));
            hdct.setHoadon(hoadon);
            hdct.setChiTietSanPham(chiTietSanPham);
            hdct.setGiaBan(Double.parseDouble(request.getParameter("giaban")));
            hdct.setSoLuongMua(Integer.parseInt(request.getParameter("soluong")));
            hdct.setTrangThai(request.getParameter("trangthai"));
            hdct.setTongTien(hdct.getSoLuongMua()*hdct.getGiaBan());
            hdct.setNgayTao(new Date());
            hdctReopnsitory.add(hdct);
            response.sendRedirect("/hdcts");


        }else if (uri.contains("suahdcts")){

            Integer id = Integer.parseInt(request.getParameter("id"));
            hdct hdct = hdctReopnsitory.getone(id);
            hoadon hoadon = new hoadon();
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
            hoadon.setId(Integer.parseInt(request.getParameter("idhds")));
            chiTietSanPham.setId(Integer.parseInt(request.getParameter("idhds")));
            hdct.setHoadon(hoadon);
            hdct.setChiTietSanPham(chiTietSanPham);
            hdct.setGiaBan(Double.parseDouble(request.getParameter("giaban")));
            hdct.setSoLuongMua(Integer.parseInt(request.getParameter("soluong")));
            hdct.setTrangThai(request.getParameter("trangthai"));
            hdct.setNgaySua(new Date());
            hdct.setTongTien(hdct.getSoLuongMua()*hdct.getGiaBan());
            hdctReopnsitory.add(hdct);
            response.sendRedirect("/hdcts");
        }
    }
}
