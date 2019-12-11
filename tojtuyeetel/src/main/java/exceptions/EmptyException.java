/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *Exception for empty user inputs
 */
public class EmptyException extends MyException {
    
   @Override
   public void showException(JPanel view){
       JOptionPane.showMessageDialog(view, "Debes completar toda la informacion" , "ERROR", JOptionPane.ERROR_MESSAGE);
   }
}
