import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class Menu extends JFrame implements ActionListener{
    //declarer les varaiables
       Container con = null  ;
    //menu bar
     JMenuBar m = new JMenuBar();
     //les menu
     JMenu m1 = new JMenu("EMPLOYE");
     JMenu m2 = new JMenu("SERVICE");
     JMenu m3 = new JMenu("LISTE");
     JMenu m4 = new JMenu("EXIT");
     //sous menu de employe
     JMenuItem m1a = new JMenuItem("Ajouter");
     JMenuItem m1m = new JMenuItem("Modifier");
     JMenuItem m1s = new JMenuItem("Supprimer");
    
    //sous menu de service
     JMenuItem m2a = new JMenuItem("Ajouter");
     JMenuItem m2m = new JMenuItem("Modifier");
     JMenuItem m2s = new JMenuItem("Supprimer");
        
        // sous menu de liste 
     JMenuItem m3s = new JMenuItem("Service");
     JMenuItem m3e = new JMenuItem("Employe");
     
     //sous menu de exit
      JMenuItem m4s = new JMenuItem("Sortir");
  
 public Menu(){
     
        //contenaire = panel 
        con =getContentPane();
        //disposition du conteneur 
        con.setLayout(new FlowLayout());
        con.setBackground(Color.cyan);
        setTitle("MENU");
        setSize(900,700);
        setLocationRelativeTo(null);
         m.setBounds(0, 0, 900, 30);
        
        //ajouter le menu sur le menu du bar et les sou menu sur le menu
        setJMenuBar(m);
        m.add(m1);
        m1.add(m1a);
        m1.add(m1m);
        m1.add(m1s);
        
        m.add(m2);
        m2.add(m2a);
        m2.add(m2m);
        m2.add(m2s);
        
        m.add(m3);
        m3.add(m3s);
        m3.add(m3e);
       
        m.add(m4);
        m4.add(m4s);
        
    m2a.addActionListener(this);
    m2m.addActionListener(this);
    m2s.addActionListener(this);
    m1a.addActionListener(this);
    m1m.addActionListener(this);
    m1s.addActionListener(this);    
    m4s.addActionListener(this);    
    m3s.addActionListener(this);    
    m3e.addActionListener(this);    
         
        
     
 }   
    
       @Override
 public void actionPerformed(ActionEvent e1){
        //service button retour 
         if(e1.getSource()==m2a){
             AjouterService se = new AjouterService(); 
             se.setVisible(true);
             dispose();
         }
         else if(e1.getSource()==m2m){
              ModifierService see =new ModifierService();
              see.setVisible(true);
              dispose();
         }
         
          else if(e1.getSource()==m2s){
            SupprimerService see =new SupprimerService();
              see.setVisible(true);
              dispose();
         }
          
          //employe  boutton retour 
          else if(e1.getSource()==m1a){
               AjouterEmploye see =new AjouterEmploye();
              see.setVisible(true);
              dispose();
              
         }else if(e1.getSource()==m1m){
              ModifierEmploye sae =new ModifierEmploye();
              sae.setVisible(true);
              dispose();
         }else if(e1.getSource()==m1s){
              SupprimerService see =new SupprimerService();
              see.setVisible(true);
              dispose();
              
              //pour la liste service
         }else if(e1.getSource()==m3s){
              ListeService ses =new ListeService();
              ses.setVisible(true);
              dispose();
           
              
              //pour liste  l'employe 
         }else if(e1.getSource()==m3e){
              ListeEmploye sel =new ListeEmploye();
              sel.setVisible(true);
              dispose();
         }
           //liste button retour 
         else if(e1.getSource()==m4s){
            JOptionPane.showMessageDialog(null,"by by by");
             System.exit(0);
         }
         
 }   
 
 public static void main(String[] args){
     
     new Menu().setVisible(true);
     
 }

    private void ListeService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
    
    
    
    
}