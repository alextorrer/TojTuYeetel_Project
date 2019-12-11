package model.CRUD;

import exceptions.MyRuntimeException;
import java.util.List;
import model.bootstrapper.EMFBootstrapper;
import model.schemas.Crop;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import model.schemas.User;

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
    
    /**
     * Method to get a Crop given his name
     * @param name
     * @return Crop
     */
    public Crop getCrop(String name)throws PersistenceException{
        Crop crop;
        EntityManager manager = EMFBootstrapper.openEntityManager();
        crop = (Crop) manager.createQuery("from Crop u where u.crop_name = '"+ name +"' ").getSingleResult(); 
        return crop;
    }
    
    
    /**
     * Method to get a list of all the crops registered by a user
     * @param user_id
     * @return Crops List
     */
    public List<Crop> getCrops(int user_id)throws PersistenceException{
        List<Crop> crops;
        EntityManager manager = EMFBootstrapper.openEntityManager();
        
        crops = manager.createQuery("from Crop").getResultList();
        //crops =  manager.createQuery("from Crop u where u.crop_from_user_id = '" + user_id + "' ", Crop.class).getResultList();
        
        return crops;
    }
}
