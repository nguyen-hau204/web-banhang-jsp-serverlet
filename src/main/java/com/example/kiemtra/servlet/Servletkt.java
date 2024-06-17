//package com.example.kiemtra.servlet;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//import com.example.kiemtra.model.hoadon;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//@WebServlet(name = "Servletkt", value = {"/hoa-don/trangchu", "/hoa-don/chi-tiet", "/hoa-don/xoa","/hoa-don/update"})
//public class Servletkt extends HttpServlet {
//    ArrayList<hoadon> list1;
//    ArrayList list2;
//
//    public Servletkt() {
//        list1 = new ArrayList<>();
//        list2 = new ArrayList<>();
//
//        list1.add(new hoadon("hd1", 1, 1000, "nguyen huu hau ", "tienmat"));
//        list1.add(new hoadon("hd2", 2, 1000, "nguyen van hau", "tienmat"));
//        list1.add(new hoadon("hd3", 3, 1000, "tran van hau", "chuyenkhoan"));
//        list1.add(new hoadon("hd4", 4, 1000, "tran van hau", "chuyenkhoan"));
//        list1.add(new hoadon("hd5", 44, 1000, "nguyen huu hau", "chuyenkhoan"));
//        list1.add(new hoadon("hd6", 1, 1000, "nguyen huu hau", "chuyenkhoan"));
//
//        list2.add("nguyen huu hau");
//        list2.add("nguyen van hau");
//        list2.add("tran van hau");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String uri = request.getRequestURI();
//        if (uri.contains("/hoa-don/trangchu")) {
//
//        } else if (uri.contains("/hoa-don/chi-tiet")) {
//            this.chitiet(request,response);
//        } else if (uri.contains("/hoa-don/xoa")) {
//            this.xoa(request,response);
//
//
//
//        }
//
//
//    }
//
//    private void trangchu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.trangchu(request,response);
//        request.setAttribute("list1", list1);
//        request.setAttribute("list2", list2);
//        request.getRequestDispatcher("/trangchu.jsp").forward(request, response);
//    }
//
//    private void xoa(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String id = request.getParameter("id");
//        for (hoadon hd : list1) {
//            if (hd.getMahoadon().equals(id)) {
//                list1.remove(hd);
//                break;
//            }
//        }
//
//        response.sendRedirect("/hoa-don/trangchu");
//    }
//
//    private void chitiet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        hoadon hoadon = new hoadon();
//        for (hoadon hd : list1) {
//            if (hd.getMahoadon().equals(id)) {
//                hoadon = hd;
//            }
//        }
//
//        request.setAttribute("hoadon", hoadon);
//        request.setAttribute("list2", list2);
//        request.getRequestDispatcher("/chitiet.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String uri = request.getRequestURI();
//        if (uri.contains("/hoa-don/update")){
//
//
//
//            response.sendRedirect("/hoa-don/trangchu");
//
//        }
//
//    }
//
//    private void update(HttpServletRequest request, HttpServletResponse response) {
//        this.update(request,response);
//        for (hoadon hd : list1) {
//            if (hd.getMahoadon().equals(request.getParameter("mahd"))){
//                hd.setSoluong(Integer.parseInt(request.getParameter("soluong")));
//                hd.setGiaban(Integer.parseInt(request.getParameter("giaban")));
//                hd.setNhanvien(request.getParameter("nhanvien"));
//                hd.setHinhthucthanhtoan(request.getParameter("hinhthucthanhtoan"));
//
//            }
//        }
//    }
//}
