/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *Exception if the crop name is already on the DB
 */
public class NameRegisteredException extends MyException {
    @Override
   public void showException(JPanel view){
       JOptionPane.showMessageDialog(view, "Ese nombre ya existe" , "ERROR", JOptionPane.ERROR_MESSAGE);
   }
}
