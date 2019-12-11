package controller;

//model
import exceptions.MyPersistenceException;
import model.CRUD.CropCRUD;
import model.schemas.Crop;


//views
import view.AddCrop_UI;
import javax.swing.JOptionPane;


/**
 * Class to manage the corresponding view to add a new crop
 * 
 */
public class AddCrop_Controller
{
    
    /**
     * Method to add/register a new crop
     * @param view 
     */
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
      try{
        Crop seedy = new Crop();
        seedy.setCrop_name(view.titulo.getText());
        seedy.setType(view.cosecha.getSelectedItem().toString());
        seedy.setSeed_date(view.sembrado.getDate());
        seedy.setHarvest_date(view.recosecha.getDate());
        seedy.setLocation(view.ubicacion.getText());

        crud.addCrop(seedy);
        
      }catch(MyPersistenceException ex){
          ex.showError(view);
      }
   
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

 
}
