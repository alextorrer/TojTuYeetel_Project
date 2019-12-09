package model.CRUD;

import model.bootstrapper.EMFBootstrapper;
import model.schemas.Crop;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class CropCRUD {

    /**
     *Method to add a Crop
     * @param crop
     */
    public void addCrop(Crop crop)throws PersistenceException{
        EntityManager manager = EMFBootstrapper.openEntityManager();
        EntityTransaction transaction = manager.getTransaction();

            transaction.begin();
            manager.persist(crop);
            transaction.commit();

            manager.close();

    }

    /**
     * Method to delete a crop
     * @param crop
     */
    public void deleteCrop(Crop crop)throws PersistenceException{
        EntityManager manager = EMFBootstrapper.openEntityManager();
        EntityTransaction transaction = manager.getTransaction();

            transaction.begin();
            manager.remove(crop);
            transaction.commit();

            manager.close();


    }
}
