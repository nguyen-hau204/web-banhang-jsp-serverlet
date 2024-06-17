package com.example.kiemtra.servlet;

import com.example.kiemtra.model.DanhMuc;
import com.example.kiemtra.model.SanPham;
import com.example.kiemtra.reponsitory.DanhMucrepository;
import com.example.kiemtra.reponsitory.SanPhamReponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ServletSanPham", value ={"/sanpham","/themsp","/xoa","/chitiet","/sua"})
public class ServletSanPham extends HttpServlet {

    SanPhamReponsitory spli = new SanPhamReponsitory();
    DanhMucrepository dmli = new DanhMucrepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/sanpham")){
            ArrayList<SanPham> list = spli.getList();
            ArrayList<DanhMuc> list2 = dmli.getList();
            request.setAttribute("list2",list2);
            request.setAttribute("list",list);
            request.getRequestDispatcher("/sanpham.jsp").forward(request,response);
        } else if (uri.contains("/xoa")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            SanPham sanPham = spli.getsp(id);
            System.out.printf(sanPham.toString());
            spli.delete(sanPham);
            response.sendRedirect("/sanpham");


        } else if (uri.contains("/chitiet")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            ArrayList<SanPham> list = spli.getList();
            ArrayList<DanhMuc> list2 = dmli.getList();
            request.setAttribute("list2",list2);
            request.setAttribute("list",list);
             SanPham sp = new SanPham();

            for ( SanPham sps : list) {
                 if (sps.getId() == id){
                     sp = sps;

                 }

            }

            request.setAttribute("sanpham",sp);
            request.getRequestDispatcher("/dentalSP.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/themsp")){
            SanPham sanPham = new SanPham();
            sanPham.setMaSanPham(request.getParameter("masp"));
            sanPham.setTenSanPham(request.getParameter("tensp"));
            sanPham.setTrangThai(request.getParameter("trangthai"));
            Integer danhmuc = Integer.parseInt(request.getParameter("danhmuc"));
            DanhMuc dm = new DanhMuc();
            dm.setId(danhmuc);
            sanPham.setDanhMuc(dm);
            sanPham.setNgaySua(new Date());
            sanPham.setNgayTao(new Date());
            SanPhamReponsitory.add(sanPham);
            response.sendRedirect("/sanpham");


        } else if (uri.contains("/sua")) {
               System.out.printf("chay vao sua");
               Integer id = Integer.parseInt(request.getParameter("id")); // Lấy ID sản phẩm từ form
               System.out.println("id nhận đuọc là "+ id);

                String maSanPham = request.getParameter("masp"); // Lấy mã sản phẩm từ form
                String tenSanPham = request.getParameter("tensp"); // Lấy tên sản phẩm từ form
                String trangThai = request.getParameter("trangthai"); // Lấy trạng thái từ form
                Integer danhMucId = Integer.parseInt(request.getParameter("danhmuc")); // Lấy ID danh mục từ form
                 System.out.println("mã danh mục nhận đuọc là "+ danhMucId);
                SanPham sanPham = new SanPham();
                sanPham.setId(id);
                sanPham.setMaSanPham(maSanPham);
                sanPham.setTenSanPham(tenSanPham);
                sanPham.setTrangThai(trangThai);
                sanPham.setNgaySua(new Date());
                sanPham.setNgayTao(new Date());
                DanhMuc dm = new DanhMuc();
                dm.setId(danhMucId);
                sanPham.setDanhMuc(dm);


                SanPhamReponsitory.update(sanPham);


                response.sendRedirect("/sanpham");

        }
    }
}
