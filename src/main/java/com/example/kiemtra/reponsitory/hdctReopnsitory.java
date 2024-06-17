package com.example.kiemtra.reponsitory;

import com.example.kiemtra.connect.HibernateUtil;
import com.example.kiemtra.model.ChiTietSanPham;
import com.example.kiemtra.model.hdct;
import com.example.kiemtra.model.hoadon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class hdctReopnsitory {
    Session session;

    public ArrayList<hdct> getall() {
        ArrayList<hdct> list = new ArrayList<>();
        session = HibernateUtil.getFACTORY().openSession();
        list = (ArrayList<hdct>) session.createQuery("from  hdct ").list();
        session.close();
        return list;
    }

    public ArrayList<hdct> getall2(Integer idhd) {
        ArrayList<hdct> list = new ArrayList<>();
        session = HibernateUtil.getFACTORY().openSession();
        list = (ArrayList<hdct>) session.createQuery("from  hdct where hoadon.id = :idhd").setParameter("idhd",idhd).list();
        session.close();
        return list;
    }

    public hdct getone(Integer id) {
        hdct list = new hdct();
        session = HibernateUtil.getFACTORY().openSession();
        list = (hdct) session.createQuery("from  hdct where id = :id").setParameter("id",id).getSingleResult();
        session.close();
        return list;
    }

    public void add(hdct hdct) {
        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(hdct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

        session.close();

    }


    public void delete(hdct hdct){
        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(hdct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();

    }

    public hdct timhdvssp(hoadon hd, ChiTietSanPham chiTietSanPham) {
        hdct hdct = null;
        session = HibernateUtil.getFACTORY().openSession();
        try {
            hdct = (hdct) session.createQuery("FROM hdct WHERE hoadon = :hd AND chiTietSanPham = :chiTietSanPham")
                    .setParameter("hd", hd)
                    .setParameter("chiTietSanPham", chiTietSanPham)
                    .uniqueResult(); // Sử dụng uniqueResult() vì kỳ vọng trả về một đối tượng duy nhất
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
        return hdct;
    }

}
