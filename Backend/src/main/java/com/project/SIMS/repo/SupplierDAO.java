package com.project.SIMS.repo;

import com.project.SIMS.HibernateUtil;
import com.project.SIMS.model.Supplier;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SupplierDAO {

    public void save(Supplier supplier) {
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(supplier);
        tx.commit();
        session.close();
    }

    public void update(Supplier supplier){
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(supplier);
        tx.commit();
        session.close();

    }

    public void delete(Supplier supplier){
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.remove(supplier);
        tx.commit();
        session.close();
    }

    public Optional<Supplier> findById(int id) {
        Session session = HibernateUtil.openSession();
        Optional<Supplier>  optionalSupplier = Optional.ofNullable(session.get(Supplier.class, id));
        session.close();
        return optionalSupplier;
    }

    public boolean supplierExist(int id){
        try (Session session = HibernateUtil.openSession()) {
            Query<Supplier> query = session.createNamedQuery("from Supplier s where s.id = :sid",Supplier.class);
            query.setParameter("sid", id);
            return (query.uniqueResult() != null);
        }
    }


}
