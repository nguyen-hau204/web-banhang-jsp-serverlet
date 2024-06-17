package com.example.kiemtra.reponsitory;

import com.example.kiemtra.connect.HibernateUtil;
import com.example.kiemtra.model.hoadon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class hoaDonReponsitory {
    Session session;


    public ArrayList<hoadon> getlistHD(){
        ArrayList<hoadon> list = new ArrayList<>();
        session = HibernateUtil.getFACTORY().openSession();
        list= (ArrayList<hoadon>) session.createQuery("from  hoadon ").list();
        session.close();
        return list;
    }

    public  hoadon getOne(Integer id){
        hoadon hoadon1 = new hoadon();
        session = HibernateUtil.getFACTORY().openSession();
        hoadon1 = (hoadon) session.createQuery("from  hoadon  where  id = :id").setParameter("id",id).getSingleResult();
        session.close();
        return hoadon1;
    }
    public void add(hoadon hd) {
        session  = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.saveOrUpdate(hd);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(hoadon hoadon) {
        session  = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(hoadon);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
