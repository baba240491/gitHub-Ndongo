/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plateformeservice;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 *
 * @author LENOVO
 */
public class RecupheureDate {
    RapportRetrait re = new RapportRetrait();
     
 

  public  void recdate () {
    SimpleDateFormat formater = null;

    Date aujourdhui = new Date();

    formater = new SimpleDateFormat("dd-MM-yy");
    String forma =  formater.format(aujourdhui);
      re.getjLabel10().setText(forma);

}
   

}