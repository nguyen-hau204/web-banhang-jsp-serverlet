package com.example.kiemtra.reponsitory;

import com.example.kiemtra.connect.HibernateUtil;
import com.example.kiemtra.model.DanhMuc;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DanhMucrepository {

    Session session;

    public ArrayList<DanhMuc> getList(){
        ArrayList<DanhMuc> list = new ArrayList<>();

        session = HibernateUtil.getFACTORY().openSession();
        list = (ArrayList<DanhMuc>) session.createQuery("from DanhMuc ").list();
        session.close();
        return list;

    }

    public void add(DanhMuc danhMuc){
    session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
                session.saveOrUpdate(danhMuc);
                transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();


        }

        session.close();

    }

    public static void main(String[] args) {
        ArrayList<DanhMuc> list =  (ArrayList<DanhMuc>) new DanhMucrepository().getList();
        for ( DanhMuc dm : list) {
            System.out.printf(dm.toString());
        }
    }

    public DanhMuc getOne(Integer id) {
        DanhMuc danhMuc = new DanhMuc();
        session = HibernateUtil.getFACTORY().openSession();
        danhMuc = (DanhMuc) session.createQuery("from DanhMuc where  id  = :id").setParameter("id",id).getSingleResult();
        session.close();
        return danhMuc;
    }

    public void delete(DanhMuc danhMuc) {
        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(danhMuc);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();


        }

        session.close();
    }
}
