package model;

import model.bootstrapper.EMFBootstrapper;
import model.schemas.Crop;
import model.schemas.Report;
import model.schemas.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.sql.Date;

public class TestApp {

    public static void main(String[] args) {

        User alex = new User();
        alex.setName("Alejandro");
        alex.setLast_name("Torre");
        alex.setEmail("a18016309@alumnos.uady.mx");
        alex.setPhone("9999037192");
        alex.setUsername("alextorrer");

        Crop chileHab = new Crop();
        chileHab.setCrop_name("Chile habanero sur");
        chileHab.setType("Chile habanero");
        chileHab.setLocation("Umán");
        String date1 = "2019-11-21";
        String date2 = "2020-02-21";
        Date seed = Date.valueOf(date1);
        Date harv = Date.valueOf(date2);
        chileHab.setSeed_date(seed);
        chileHab.setHarvest_date(harv);
        chileHab.setHarvest_status(false);
        chileHab.setUser(alex);

        Report dragonAmarillo = new Report();
        dragonAmarillo.setTitle("Dragón amarillo en mi cultivo");
        dragonAmarillo.setDescription("Encontré indicios de que hay una plaga de dragón amarillo en mi plantío de chiles habaneros");
        dragonAmarillo.setCrop(chileHab);


        EntityManager manager = EMFBootstrapper.openEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(alex);
            manager.persist(chileHab);
            manager.persist(dragonAmarillo);
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
