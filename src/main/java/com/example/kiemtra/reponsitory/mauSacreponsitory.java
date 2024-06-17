package com.example.kiemtra.reponsitory;

import com.example.kiemtra.connect.HibernateUtil;
import com.example.kiemtra.model.mausacc;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class mauSacreponsitory {
    Session session ;

    public ArrayList<mausacc> getlistMC(){
        ArrayList<mausacc> list = new ArrayList<>();
        session = HibernateUtil.getFACTORY().openSession();
        list = (ArrayList<mausacc>) session.createQuery("from mausacc ").list();
        session.close();
        return list;

    }



    public  mausacc getMau(Integer id){
        mausacc mc = new mausacc();
        session = HibernateUtil.getFACTORY().openSession();
        mc = (mausacc) session.createQuery("from mausacc where  id = :id").setParameter("id",id).getSingleResult();
        session.close();
        return mc;
    }

    public void xoamau(mausacc mausacc){
        session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(mausacc);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();

        }

        session.close();
    }

    public void themmau(mausacc mausacc){
         session  = HibernateUtil.getFACTORY().openSession();
         Transaction transaction = session.beginTransaction();
         try{
             session.saveOrUpdate(mausacc);
             transaction.commit();


         }catch (Exception e){
              e.printStackTrace();
              transaction.rollback();
         }

         session.close();


    }

    public static void main(String[] args) {
        ArrayList<mausacc> list = (ArrayList<mausacc>) new mauSacreponsitory().getlistMC();
        for ( mausacc mc : list) {
            System.out.println(mc);
        }
    }
}
