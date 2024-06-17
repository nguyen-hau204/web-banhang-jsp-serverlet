package com.example.kiemtra.reponsitory;

import com.example.kiemtra.connect.HibernateUtil;
import com.example.kiemtra.model.KhachHang;
import com.example.kiemtra.model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SanPhamReponsitory {
    static Session session;

    public static void update(SanPham sanPham) {
        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sanPham);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();


        }

    }


    public ArrayList<SanPham> getList(){
        ArrayList<SanPham> list = new ArrayList<>();

        session = HibernateUtil.getFACTORY().openSession();
        list = (ArrayList<SanPham>) session.createQuery("from SanPham ").list();
        session.close();
        return list;

    }
    public SanPham getsp(Integer id){
       SanPham sanPham = new SanPham();

        session = HibernateUtil.getFACTORY().openSession();
        sanPham = (SanPham) session.createQuery("from SanPham where id =  :id").setParameter("id",id).getSingleResult();
        session.close();
        return sanPham;

    }

    public static void main(String[] args) {
        ArrayList<SanPham> list =  new SanPhamReponsitory().getList();
        for ( SanPham sp : list) {
            System.out.printf(sp.toString());
        }
    }


    public static void add(SanPham sanPham) {
        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sanPham);
            transaction.commit();

        }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();


        }

        session.close();
    }

    public void delete(SanPham  sanPham) {

        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(sanPham);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();


        }

        session.close();
    }
}
