
package exceptions;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * PersistenceException child 
 * @author alext
 */
public class MyPersistenceException extends MyException{
    
    /**
     * Method to show an error on the view
     * @param view 
     */
    @Override
    public void showException(JPanel view){
        JOptionPane.showMessageDialog(view, "Persistence error" , "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
