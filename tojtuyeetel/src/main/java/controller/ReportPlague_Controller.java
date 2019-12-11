
package controller;

import exceptions.MyException;
import javax.swing.JOptionPane;
import model.CRUD.ReportCRUD;
import model.CRUD.UserCRUD;
import model.schemas.Report;
import view.ReportPlague_UI;

/**
 * Controller class to manage the corresponding view to report a plague
 * 
 */
public class ReportPlague_Controller {
    
    /**
     * Method to create a new plague report
     * @param view 
     * @throws exceptions.MyException 
     */
    public void report_crop(ReportPlague_UI view) throws MyException
 {
  ReportCRUD crud = new ReportCRUD();

  //Aqui las cosas a validar. Tienen que estar todas en 1 para continuar.
  int campos = 0; //campos llenos

  //Verificar que no haya informacion vacia
  if (view.titulo.getText().isEmpty() == false && //Titulo de reporte
      view.tipoplaga.getSelectedItem().toString().isEmpty() == false && //Tipo de plaga
      view.descripcao.getText().isEmpty () == false
     )
  {
   campos = 1;
  }

  //Enviar cosas al model si todo esta en orden
  if (campos == 1)
  {
      try{
          UserCRUD crud2 = new UserCRUD();
            Report reporte = new Report();
            reporte.setUser(crud2.getUserByEmail("alextorre@correo.com"));
            reporte.setTitle(view.titulo.getText());
            reporte.setPlague(view.tipoplaga.getSelectedItem().toString());
            reporte.setDescription(view.descripcao.getText());

            crud.createReport(reporte);
      }
      catch(Exception ex){
          ex.printStackTrace();
      }
   
  }
  else //EXCEPCIONES
  {
   if (campos == 0)
   {
    JOptionPane.showMessageDialog(null, "POR FAVOR, LLENE TODOS LOS CAMPOS.\n");
   }
  }
 }
}
