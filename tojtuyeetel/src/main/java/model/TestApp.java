package model;

import model.schemas.Crop;
import model.schemas.Report;
import model.schemas.User;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import model.CRUD.CropCRUD;
import model.CRUD.ReportCRUD;
import model.CRUD.UserCRUD;

public class TestApp {

    public static void main(String[] args) {
        
        
        
        /*
        //Importing some data
        User alex = new User();
        alex.setName("Alejandro");
        alex.setLast_name("Torre");
        alex.setEmail("alextorre@correo.com");
        alex.setPhone("9999037192");
        alex.setUsername("alextorrer29");
        
        User daniel = new User();
        daniel.setName("Daniel");
        daniel.setLast_name("Perez");
        daniel.setEmail("daniel@correo.com");
        daniel.setPhone("999958652");
        daniel.setUsername("daniPerez_45");
        

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
        chileHab.setUser(new UserCRUD().getUserByEmail("alextorre@correo.com"));
        
        Crop pepino = new Crop();
        pepino.setCrop_name("Pepino oeste");
        pepino.setType("Pepino");
        pepino.setLocation("Baca");
        String date01 = "2019-11-25";
        String date02 = "2020-02-24";
        Date toseed = Date.valueOf(date01);
        Date toharv = Date.valueOf(date02);
        pepino.setSeed_date(toseed);
        pepino.setHarvest_date(toharv);
        pepino.setHarvest_status(false);
        pepino.setUser(new UserCRUD().getUserByEmail("alextorre@correo.com"));
        

        Report dragonAmarillo = new Report();
        dragonAmarillo.setTitle("Dragón amarillo en mi cultivo");
        dragonAmarillo.setPlague("Dragon Amarillo");
        dragonAmarillo.setDescription("Encontré indicios de que hay una plaga de dragón amarillo en mi plantío de chiles habaneros");
        dragonAmarillo.setUser(new UserCRUD().getUserByEmail("alextorre@correo.com"));
        */
        Report acaro = new Report();
        acaro.setTitle("Acaro Blanco en cítricos");
        acaro.setPlague("Acaro Blanco");
        acaro.setDescription("Tomen sus precauciones, al parecer el acaro blanco ya esta afectando a los citricos, me pasó con mis naranjas y limones");
        acaro.setUser(new UserCRUD().getUserByEmail("daniel@correo.com"));
        
        Report minador = new Report();
        minador.setTitle("Nueva plaga");
        minador.setPlague("Minador de hojas");
        minador.setDescription("Tengan cuidado, anoche revisé mi invernadero y en mis calabazas noté unas manchas extrañas, investigué que puede ser una plaga llamada minador de hojas");
        minador.setUser(new UserCRUD().getUserByEmail("daniel@correo.com"));
        
        /*
        UserCRUD usermodel = new UserCRUD();
        usermodel.registerUser(daniel); 
        
        CropCRUD cropmodel = new CropCRUD();
        cropmodel.addCrop(chileHab);
        cropmodel.addCrop(pepino);
        
        ReportCRUD reportmodel = new ReportCRUD();
        reportmodel.createReport(acaro);
        reportmodel.createReport(minador);
     */
        
        
        
    }

}
