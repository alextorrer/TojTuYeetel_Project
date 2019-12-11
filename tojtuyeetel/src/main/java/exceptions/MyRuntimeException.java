
package exceptions;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * PersistenceException child 
 * @author alext
 */
public class MyRuntimeException extends RuntimeException{
    
    /**
     * Method to show an error on the view
     * @param view 
     */

    public void showException(){
        JOptionPane.showMessageDialog(null, "There was an error, try again" , "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
