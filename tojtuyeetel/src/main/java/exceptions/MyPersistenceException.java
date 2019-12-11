
package exceptions;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * PersistenceException child 
 * @author alext
 */
public class MyPersistenceException extends PersistenceException{
    
    /**
     * Method to show an error on the view
     * @param view 
     */

    public void showException(JPanel view){
        JOptionPane.showMessageDialog(view, "Persistence error" , "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
