/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.CRUD.ReportCRUD;
import model.schemas.Report;
import view.MainHome;
import static view.starter.EMAIL;
import static view.starter.entrar;

/**
 *
 * @author black
 */
public class FeedController 
{
    /*public void noticia(List<Report> lista)
         {
   
        int a;
        a = lista.size();
        Report reporte = null;
        String nombre,titulo,plaga,descripcion;
        
        for (int i=0;i<a+1;i++)
        {           
            reporte = lista.get(i);
            titulo = reporte.getTitle();
            plaga = reporte.getPlague();
            descripcion = reporte.getDescription();
            nombre = reporte.getUser().getUsername();
            entrar.noticia(nombre, titulo, plaga, plaga);
        }
    }      */
    public void noticias()
    {
        List<Report> reportes = new ReportCRUD().getReports();
        for (int i=0;i<reportes.size();i++)
        {           
            //entrar.noticia(reportes.get(i).getUser().getUsername(), reportes.get(i).getTitle(), reportes.get(i).getPlague(), reportes.get(i).getDescription());
        }
        new MainHome().noticia(EMAIL, EMAIL, EMAIL, EMAIL);
    }
    
}
