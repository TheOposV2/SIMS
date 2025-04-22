package com.project.SIMS.repo;

import com.project.SIMS.HibernateUtil;
import com.project.SIMS.model.Supplier;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierDAO {

    public void save(Supplier supplier) {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.save(supplier);
        tx.commit();
        session.close();
    }
    public Supplier findById(int id) {
        Session session = HibernateUtil.openSession();
        Supplier supplier = session.get(Supplier.class, id);
        session.close();
        return supplier;
    }

    public boolean supplierExist(int id){
        try (Session session = HibernateUtil.openSession()) {
            Query query = session.createQuery("from Supplier s where s.id = :sid");
            query.setParameter("sid", id);
            return (query.uniqueResult() != null);
        }
    }

}
