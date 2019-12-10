package controller;

//model
import model.CRUD.CropCRUD;
import model.schemas.Crop;
import model.CRUD.ReportCRUD;
import model.schemas.Report;
import model.CRUD.UserCRUD;
import model.schemas.User;

//views
import view.agregar_cultivo;
import view.report_plaga;

import javax.swing.JOptionPane;

public class Controller
{
 public void add_crop(agregar_cultivo view)
 {
  CropCRUD crud = new CropCRUD();
  //Nombre = jTextField2
  //Tipo de Cosecha = cosecha
  //Sembrado = jDateChooser1
  //Inicio de Cosecha = jDateChooser2
  //Ubicacion = jTextField1

  //Aqui las cosas a validar. Tienen que estar todas en 1 para continuar.
  int campos = 0; //campos llenos
  int veracidad = 0; //fecha de sembrado antes fecha de cosecha
  int unicaYdiferente = 0; //cosecha con el mismo nombre

  int debounce = 0; //por favor solo muestrame un mensaje de error a la vez

  //Verificar que no haya informacion vacia
  if (view.jTextField2.getText().isEmpty() == false && //Nombre de cosecha
      view.cosecha.getSelectedItem().toString().isEmpty() == false && //Tipo de cosecha
      view.jDateChooser1.getDate().toString().isEmpty() == false && //Sembrado
      view.jDateChooser2.getDate().toString().isEmpty() == false && //Inicio de cosecha
      view.jTextField2.getText().isEmpty() == false //Ubicacion
     )
  {
   campos = 1;
  }

  //Validar que la fecha de sembrado sea antes de la fecha de cosecha
  if (view.jDateChooser1.getDate().before(view.jDateChooser2.getDate()))
  {
   veracidad = 1;
  }

  //Validar que no haya una cosecha con el mismo nombre
  if (crud.getCrop(view.jTextField2.getText()) == null)
  {
   unicaYdiferente = 1;
  }

  //Enviar cosas al model si todo esta en orden
  if (campos == 1 && veracidad == 1 && unicaYdiferente == 1)
  {
   Crop seedy = new Crop();
   seedy.setCrop_name(view.jTextField2.getText());
   seedy.setType(view.cosecha.getSelectedItem().toString());
   seedy.setSeed_date(view.jDateChooser1.getDate());
   seedy.setHarvest_date(view.jDateChooser2.getDate());
   seedy.setLocation(view.jTextField2.getText());

   crud.addCrop(seedy);
  }
  else //EXCEPCIONES
  {
   if (campos == 0 && debounce == 0)
   {
    JOptionPane.showMessageDialog(null, "POR FAVOR, LLENE TODOS LOS CAMPOS.\n");
    debounce = 1;
   }
   if (veracidad == 0  && debounce == 0)
   {
    JOptionPane.showMessageDialog(null, "LA FECHA DE SEMBRADO DEBE SER ANTES DE LA FECHA DE COSECHA.\n");
    debounce = 1;
   }
   if (unicaYdiferente == 0 && debounce == 0)
   {
    JOptionPane.showMessageDialog(null, "YA HAY UNA COSECHA CON EL MISMO NOMBRE.\n");
    debounce = 1;
   }
  }
 }

 public void report_crop(report_plaga view)
 {
  ReportCRUD crud = new ReportCRUD();
  //Titulo = jTextField1
  //Tipo de Plaga = jComboBox1
  //Descripcion = jTextArea1

  //Aqui las cosas a validar. Tienen que estar todas en 1 para continuar.
  int campos = 0; //campos llenos

  //Verificar que no haya informacion vacia
  if (view.jTextField1.getText().isEmpty() == false && //Titulo de reporte
      view.jComboBox1.getSelectedItem().toString().isEmpty() == false && //Tipo de plaga
      view.jTextArea1.getText().isEmpty () == false
     )
  {
   campos = 1;
  }

  //Enviar cosas al model si todo esta en orden
  if (campos == 1)
  {
   UserCRUD crud2 = new UserCRUD();
   Report reporte = new Report();
   reporte.setUser(crud2.getUserByEmail("alextorre@correo.com"));
   reporte.setTitle(view.jTextField1.getText());
   reporte.setPlague(view.jComboBox1.getSelectedItem().toString());
   reporte.setDescription(view.jTextArea1.getText());
   
   crud.createReport(reporte);
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
