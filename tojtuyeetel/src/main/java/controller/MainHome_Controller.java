
package controller;

import exceptions.MyException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.PersistenceException;
import model.CRUD.CropCRUD;
import model.CRUD.ReportCRUD;
import model.CRUD.UserCRUD;
import model.schemas.Crop;
import model.schemas.Report;
import model.schemas.User;
import org.hibernate.HibernateException;
import view.MainHome;
import view.TrackCrops_UI;
import static view.starter.EMAIL;
import static view.starter.entrar;

/**
 * Controller class to manage the view corresponding to the app´s home
 * 
 */
public class MainHome_Controller {
    
    CropCRUD cropModel = new CropCRUD();
    UserCRUD userModel = new UserCRUD();
    ReportCRUD reportModel = new ReportCRUD();
    
    /**
     * Method to return the names of the current crops
     * @return crop name list
     * @throws exceptions.MyException
     */
    public HashMap<String,String> getCropsNames() throws MyException{
        List<Crop> cropsList;
        HashMap<String,String> cropNames = new HashMap<>();
        User user;
        
        try{
            user = userModel.getUserByEmail(EMAIL);
            cropsList = cropModel.getCrops(user.getUser_id());
    
            for(int i=0; i<cropsList.size(); i++){
                cropNames.put(String.valueOf(i), cropsList.get(i).getCrop_name());
            }
        }
        catch(PersistenceException ex){
            new MainHome().showPersistenceExceptions(ex);
        }
        
        return cropNames;
    }
    
    
    /**
     * Method to get the Crop object from de DB and place the date in a map
     * @param name
     * @return 
     * @throws exceptions.MyException 
     */
    public HashMap<String,String> getCropData(String name) throws MyException{
        HashMap<String,String> data = new HashMap<>();
        Crop crop;
        
        try{
            crop = cropModel.getCrop(name);
            data.put("seed_date", crop.getSeed_date().toString());
            data.put("harvest_date", crop.getHarvest_date().toString());
            data.put("bar", String.valueOf(progressBar(crop)));
            data.put("location",crop.getLocation());
        }
            catch(PersistenceException ex){
                new MainHome().showPersistenceExceptions(ex);
             }
        
        return data;
    }
    
    public List<Report> getReports()
    {
        return new ReportCRUD().getReports();
    }
    
    
    public long progressBar(Crop crop){
        long value = 0;
        Date seed = crop.getSeed_date();
        Date harv = crop.getHarvest_date();
        Date aux = new Date();
        
        long time = harv.getTime() - seed.getTime();
        long now = aux.getTime();
        
        value = now * (new TrackCrops_UI().getBarWidth())/time;
        return value;
    }  
}
