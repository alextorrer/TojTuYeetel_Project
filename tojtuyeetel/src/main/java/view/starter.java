/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author black
 */
public class starter 
{
    public static base_frame window;
    public static MainHome entrar;
    public static final String EMAIL = "alextorre@correo.com";
    
    public static void main (String args[])
    {
        window= new base_frame();
        entrar = new MainHome();
        
        entrar.setSize(1000,626);
        
        window.add(entrar);
        window.setVisible(true);

                        
    }
}
