package model.CRUD;

import model.bootstrapper.EMFBootstrapper;
import model.schemas.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class UserCRUD {

    /**
     * Método para registrar un usuario
     * @param user
     */
    public void createUser(User user){
        EntityManager manager = EMFBootstrapper.openEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(user);
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
     * Método que consulta en la BD para obtener el usuario buscado por email
     * @param email
     * @return el usuario con el email enlazado
     */
    public User getUserByEmail(String email){
        EntityManager manager = EMFBootstrapper.openEntityManager();
        User user = new User();
        try {
            user = (User) manager.createQuery("from User u where u.email='" + email + "'").getSingleResult();
        }
        catch(PersistenceException e) {
            throw e;
        }

        return user;
    }
}
