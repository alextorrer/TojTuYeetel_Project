package model.CRUD;

import model.bootstrapper.EMFBootstrapper;
import model.schemas.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class UserCRUD {

    /**
     * Method to register a user
     * @param user
     */
    public void registerUser(User user)throws PersistenceException{
        EntityManager manager = EMFBootstrapper.openEntityManager();
        EntityTransaction transaction = manager.getTransaction();

            transaction.begin();
            manager.persist(user);
            transaction.commit();

            manager.close();

    }

    /**
     * Method to get a user given his email
     * @param email
     * @return el usuario con el email enlazado
     */
    public User getUserByEmail(String email)throws PersistenceException{
        EntityManager manager = EMFBootstrapper.openEntityManager();
        User user;

            user = (User) manager.createQuery("from User u where u.email='" + email + "'").getSingleResult();

        return user;
    }
}
