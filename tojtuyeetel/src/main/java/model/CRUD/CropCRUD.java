package model.CRUD;

import model.bootstrapper.EMFBootstrapper;
import model.schemas.Crop;
import model.schemas.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class CropCRUD {

    /**
     *Method to add a Crop
     * @param crop
     */
    public void addCrop(Crop crop){
        EntityManager manager = EMFBootstrapper.openEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(crop);
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

    /**
     * Method to delete a crop
     * @param crop
     */
    public void deleteCrop(Crop crop){
        EntityManager manager = EMFBootstrapper.openEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(crop);
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
