package controller;

//model
import exceptions.DateBeforeException;
import exceptions.EmptyException;
import exceptions.MyException;
import exceptions.MyPersistenceException;
import exceptions.NameRegisteredException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.persistence.NoResultException;
import model.CRUD.CropCRUD;
import model.schemas.Crop;

//views
import view.AddCrop_UI;
import javax.swing.JOptionPane;
import model.CRUD.UserCRUD;
import model.schemas.User;
import static view.starter.EMAIL;


    /**
     * Class to manage the corresponding view to add a new crop
     * 
     */
    public class AddCrop_Controller
    {
        CropCRUD cropModel = new CropCRUD();
        UserCRUD userModel = new UserCRUD();

        /**
         * Method to add/register a new crop
         * @param view 
        * @throws exceptions.EmptyException  
        * @throws exceptions.DateBeforeException  
        * @throws exceptions.NameRegisteredException  
         */
     public void add_crop(AddCrop_UI view) throws EmptyException, DateBeforeException, NameRegisteredException{
         
         Crop crop = null;
         User user;
         Map<String,String> data = new HashMap<>();
         data.put("crop_name", view.getTitle());
         data.put("type", view.getTipo());
         data.put("seed_date", view.getSeedDate());
         data.put("harvest_date", view.getHarvestDate());
         data.put("location", view.getUbicacion());

         if(validCompleteness(data) > 0){
             
             throw new EmptyException();
             
         }else if(view.getRecosecha().before(view.getSembrado())){
            
             throw new DateBeforeException();
             
         }else if(!validName(data)){
             
             throw new NameRegisteredException();          
                     
         }
         else{
                
             try{
                 
                 user = userModel.getUserByEmail(EMAIL);
                 crop.setCrop_name(data.get("crop_name"));
                 crop.setType(data.get("type"));
                 crop.setSeed_date(view.getSembrado());
                 crop.setHarvest_date(view.getRecosecha());
                 crop.setLocation(data.get("location"));
                 crop.setUser(user);
                 crop.setHarvest_status(false);
                 
                 cropModel.addCrop(crop);
             }
             catch(Exception ex){
                 ex.printStackTrace();
             }
             
         }
     }
     
     
     /**
      * Method to valid there is no empty values in a Map
      * @param data
      * @return 
      */
     public int validCompleteness(Map<String,String> data){
            int isComplete = 0;
            Set<String> keys = data.keySet();
            for(String key: keys){
                if(data.get(key).isBlank()){ //Checks that there is no empty information
                    isComplete++;
                }
            }

            return isComplete;
        }
     
     /**
      * Method to valid if the crop new is already registered
      * @param data
      * @return 
      */
     public boolean validName(Map<String,String> data){
         boolean flag;
         Crop crop;
         
         try{
            crop = cropModel.getCrop(data.get("crop_name"));
            flag = false;
         }
         catch(NoResultException ex){
            flag = true;
         }
         
         return flag;
     }
}
