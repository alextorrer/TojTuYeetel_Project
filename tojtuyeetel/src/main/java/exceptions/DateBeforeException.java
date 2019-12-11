/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *Exception if the harvest date is before the seed date
 */
public class DateBeforeException extends MyException{
    
    @Override
   public void showException(JPanel view){
       JOptionPane.showMessageDialog(view, "La fecha de cosecha no puede ser antes de la fecha de sembrado" , "ERROR", JOptionPane.ERROR_MESSAGE);
   }
}
