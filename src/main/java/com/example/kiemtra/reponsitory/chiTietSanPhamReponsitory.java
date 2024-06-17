package com.example.kiemtra.reponsitory;

import com.example.kiemtra.connect.HibernateUtil;
import com.example.kiemtra.model.ChiTietSanPham;
import com.example.kiemtra.model.DanhMuc;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class chiTietSanPhamReponsitory {

    Session session ;

    public ArrayList<ChiTietSanPham> getlist(){
        ArrayList<ChiTietSanPham> list = new ArrayList<>();
        session = HibernateUtil.getFACTORY().openSession();
        list = (ArrayList<ChiTietSanPham>) session.createQuery("from ChiTietSanPham ").list();
        session.close();
        return list;
    }
    public ChiTietSanPham getOne(Integer id){
        ChiTietSanPham list = new ChiTietSanPham();
        session = HibernateUtil.getFACTORY().openSession();
        list = (ChiTietSanPham) session.createQuery("from ChiTietSanPham  where id = :id ").setParameter("id",id).getSingleResult();
        session.close();
        return list;
    }

    public static void main(String[] args) {
        ArrayList<ChiTietSanPham> list =  (ArrayList<ChiTietSanPham>) new chiTietSanPhamReponsitory().getlist();
        for ( ChiTietSanPham spct : list) {
            System.out.printf(spct.toString());
        }
    }

    public void add(ChiTietSanPham chiTietSanPham) {
        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(chiTietSanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();

        }

    }
    public void delete(ChiTietSanPham chiTietSanPham) {
        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(chiTietSanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();

        }

    }
}
