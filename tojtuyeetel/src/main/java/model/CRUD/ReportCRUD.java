package model.CRUD;

import model.bootstrapper.EMFBootstrapper;
import model.schemas.Report;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class ReportCRUD {

    /**
     * Method to create a report
     * @param report
     */
    public void createReport(Report report){
        EntityManager manager = EMFBootstrapper.openEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(report);
            transaction.commit();
        }
        catch(PersistenceException e) {
            transaction.rollback();
            throw e;
        }
        finally {
            manager.close();
        }
    }

}
