
package controller;

import exceptions.MyException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.CRUD.CropCRUD;
import model.CRUD.UserCRUD;
import model.schemas.Crop;
import model.schemas.User;
import static view.starter.EMAIL;

/**
 * Controller class to manage the view corresponding to the app´s home
 * 
 */
public class MainHome_Controller {
    
    CropCRUD cropModel = new CropCRUD();
    UserCRUD userModel = new UserCRUD();
    
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
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return cropNames;
    }
}
