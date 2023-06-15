/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plateformeservice;

import java.util.Random;

/**
 *
 * @author LENOVO
 */
public class Aleatoire {
      int nAleatoire  ;
     Random  r = new Random() ;
     
      public Aleatoire(){
    
     nAleatoire = r.nextInt(10000000);
    
}
      public void Afficher(){
          System.out.println("le nombre aleatoire"  + nAleatoire);
           
      }
     
      
      public static void main(String[] args){
          Aleatoire n = new Aleatoire();
          n.Afficher();
      }
}
