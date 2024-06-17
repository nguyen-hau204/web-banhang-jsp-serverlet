package com.example.kiemtra.reponsitory;

import com.example.kiemtra.connect.HibernateUtil;
import com.example.kiemtra.model.DanhMuc;
import com.example.kiemtra.model.KhachHang;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class KhachHangReponsitory {

    Session session;

    public ArrayList<KhachHang> getList(){
        ArrayList<KhachHang> list = new ArrayList<>();

        session = HibernateUtil.getFACTORY().openSession();
        list = (ArrayList<KhachHang>) session.createQuery("from KhachHang ").list();
        session.close();
        return list;

    }

    public KhachHang getOne(Integer id){
        KhachHang khachHang = new KhachHang();
        session = HibernateUtil.getFACTORY().openSession();
        khachHang= (KhachHang) session.createQuery("from KhachHang  where  id = : id").setParameter("id",id).getSingleResult();
        session.close();
        return khachHang;

    }

    public static void main(String[] args) {
        ArrayList<KhachHang> list =  new KhachHangReponsitory().getList();
        for ( KhachHang kh : list) {
            System.out.printf(kh.toString());
        }
    }


    public KhachHang timsdt(String sdt) {
        KhachHang kh = null;
        Session session = null;
        try {
            session = HibernateUtil.getFACTORY().openSession();
            kh = (KhachHang) session.createQuery("from KhachHang where sdt = :sdt")
                    .setParameter("sdt", sdt)
                    .getSingleResult();
        } catch (NoResultException e) {
           e.printStackTrace();

        } finally {
            if (session != null) session.close();
        }
        return kh;
    }

    public void addAndupdate(KhachHang khachHang) {
        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.saveOrUpdate(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }public void delete(KhachHang khachHang) {
        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
