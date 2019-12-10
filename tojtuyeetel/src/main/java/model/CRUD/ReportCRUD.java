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
    public void createReport(Report report)throws PersistenceException{
        EntityManager manager = EMFBootstrapper.openEntityManager();
        EntityTransaction transaction = manager.getTransaction();

            transaction.begin();
            manager.persist(report);
            transaction.commit();

            manager.close();

    }

}
