package com.project.SIMS.repo;

import com.project.SIMS.HibernateUtil;
import com.project.SIMS.model.Supplier.Supplier;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SupplierDAO {

    public void save(Supplier supplier) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(supplier);
        tx.commit();
        session.close();
    }
    public Supplier findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Supplier supplier = session.get(Supplier.class, id);
        session.close();
        return supplier;
    }

}
