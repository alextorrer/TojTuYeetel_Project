
package exceptions;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *Exception child
 */
public class MyException extends Exception{
    
    /**
     * Method to show the exception on the view
     * @param view
     */
    public void showException(JPanel view){
        JOptionPane.showMessageDialog(view, "Error" , "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
