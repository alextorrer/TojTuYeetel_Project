package controller;

//model
import model.CRUD.CropCRUD;
import model.schemas.Crop;
import model.CRUD.ReportCRUD;
import model.schemas.Report;
import model.CRUD.UserCRUD;
import model.schemas.User;

//views
import view.AddCrop_UI;
import view.ReportPlague_UI;

import javax.swing.JOptionPane;

public class AddCrop_Controller
{
 public void add_crop(AddCrop_UI view)
 {
  CropCRUD crud = new CropCRUD();

  //Aqui las cosas a validar. Tienen que estar todas en 1 para continuar.
  int campos = 0; //campos llenos
  int veracidad = 0; //fecha de sembrado antes fecha de cosecha
  int unicaYdiferente = 0; //cosecha con el mismo nombre

  int debounce = 0; //por favor solo muestrame un mensaje de error a la vez

  //Verificar que no haya informacion vacia
  if (view.titulo.getText().isEmpty() == false && //Nombre de cosecha
      view.cosecha.getSelectedItem().toString().isEmpty() == false && //Tipo de cosecha
      view.sembrado.getDate().toString().isEmpty() == false && //Sembrado
      view.recosecha.getDate().toString().isEmpty() == false && //Inicio de cosecha
      view.ubicacion.getText().isEmpty() == false //Ubicacion
     )
  {
   campos = 1;
  }

  //Validar que la fecha de sembrado sea antes de la fecha de cosecha
  if (view.sembrado.getDate().before(view.recosecha.getDate()))
  {
   veracidad = 1;
  }

  //Validar que no haya una cosecha con el mismo nombre
  if (crud.getCrop(view.titulo.getText()) == null)
  {
   unicaYdiferente = 1;
  }

  //Enviar cosas al model si todo esta en orden
  if (campos == 1 && veracidad == 1 && unicaYdiferente == 1)
  {
   Crop seedy = new Crop();
   seedy.setCrop_name(view.titulo.getText());
   seedy.setType(view.cosecha.getSelectedItem().toString());
   seedy.setSeed_date(view.sembrado.getDate());
   seedy.setHarvest_date(view.recosecha.getDate());
   seedy.setLocation(view.ubicacion.getText());

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

 public void report_crop(ReportPlague_UI view)
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
   UserCRUD crud2 = new UserCRUD();
   Report reporte = new Report();
   reporte.setUser(crud2.getUserByEmail("alextorre@correo.com"));
   reporte.setTitle(view.titulo.getText());
   reporte.setPlague(view.tipoplaga.getSelectedItem().toString());
   reporte.setDescription(view.descripcao.getText());
   
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
