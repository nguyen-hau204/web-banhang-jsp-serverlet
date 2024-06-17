package com.example.kiemtra.reponsitory;

import com.example.kiemtra.connect.HibernateUtil;
import com.example.kiemtra.model.Sizes;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class sizeReponsitory {
    Session session;

    public ArrayList<Sizes> getListsize(){
        ArrayList<Sizes> list = new ArrayList<>();

        session = HibernateUtil.getFACTORY().openSession();
        list = (ArrayList<Sizes>) session.createQuery("from  Sizes ").list();
        session.close();
        return list;

    }





    public  Sizes  getSize(Integer id){
        Sizes sizes = new Sizes();
        session = HibernateUtil.getFACTORY().openSession();
        sizes = (Sizes) session.createQuery("from Sizes where  id = :id").setParameter("id",id).getSingleResult();
        session.close();
        return sizes;
    }
    public static void main(String[] args) {
        ArrayList<Sizes> list =  (ArrayList<Sizes>) new sizeReponsitory().getListsize();
        for ( Sizes size : list) {
            System.out.printf(size.toString());
        }
    }

    public void  deleteSize(Sizes sizes){
        session = HibernateUtil.getFACTORY().openSession();
         Transaction transaction = session.beginTransaction();

         try{
             session.delete(sizes);
             transaction.commit();
         }catch (Exception e){
             e.printStackTrace();
             transaction.rollback();

         }

         session.close();
    }

    public void add(Sizes sizes) {

        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sizes);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

        session.close();

    }
}
