import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ModifierService extends JFrame implements ActionListener{
        //variable pour table 
           JTable table ; 
       //variable mofifer service
            Container con = null ;
          JComboBox com =new JComboBox();  
          JLabel l1 =new JLabel("CodeService");
          JLabel l2 =new JLabel("libelle");
          JTextField t2 =new JTextField(15);
          JButton b1 =new JButton("Modification");
          JButton b2 =new JButton("Retour");
    
          
          
    
public ModifierService(){
        
   
        //charger le combox
       try           
            {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root",""); 
                //espace memoire piur execution de la requete
                Statement s1 = co.createStatement();
                //declaration de la requete  
                String req="select * from service";
                //execution de la requet
                
                ResultSet res=s1.executeQuery(req);
                
                while(res.next())
                {
                    com.addItem(res.getInt("codeS"));
                }
                
              
            }
            catch(ClassNotFoundException e11)
            {
            JOptionPane.showMessageDialog(null,"err : chargement pilote");    
            }
            catch(SQLException e2)
            {
              JOptionPane.showMessageDialog(null,"erreur de conn ou requete");  
            }
        
            //contanire = panel
        con=getContentPane();
        con.setLayout(new FlowLayout());
        con.setBackground(Color.LIGHT_GRAY);
        setTitle("MODIFIER_SERVICE");
        setSize(900,700);
        
        //mettre les variables dans le contenaire
        con.add(l1);
        con.add(com);
        con.add(l2);
        con.add(t2);
        con.add(b1);
        con.add(b2); 
        
      b1.addActionListener(this);
      b2.addActionListener(this);
      com.addActionListener(this);
      
      
      
             //variable pour le tableau  et creer un tableau et ajouter les donner 
         String col[]={"codeS","lib"};
         String cont[][]= new String[30][2];
          //connection et insertion des donner dans une table 
       try           
            {
                //connexion
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root",""); 
                //espace memoire piur execution de la requete
               Statement s1 = co.createStatement();
                //declaration de la requete  
               String req="select* from service";
                //execution de la requet  
               ResultSet res=s1.executeQuery(req);
                
                int i=0 ;
                //parcoure le tabeau et inserer les donner 
                while(res.next()){
                   cont[i][0]=res.getString(1);
                   cont[i][1]=res.getString(2);
                  
                   i=i+1 ;
               }
               //creer un tableau par defaut
               DefaultTableModel mod = new DefaultTableModel(cont, col);
               table =new JTable(mod);
               //on creer un curseur 
               JScrollPane pane = new JScrollPane(table);
             
                    //ajouter sur curseur dans le contenaire 
               con.add(pane);
            }
            catch(ClassNotFoundException e11)
            {
            JOptionPane.showMessageDialog(null,"err : chargement pilote");    
            }
            catch(SQLException e2)
            {
              JOptionPane.showMessageDialog(null,"erreur de conn ou requete");  
            }
      
        
        
    }
    
    
    
public void actionPerformed(ActionEvent e2){
        if(e2.getSource()==b2){
            Menu mse = new Menu();
            mse.setVisible(true);
            dispose();
            
            
            
            
        }else if(e2.getSource()==com){
            
           //afficher le libelle 
           try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection co = null ;
                co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root","");     
                Statement s1 = co.createStatement();
                String req1 ="select *from service where codeS="+com.getSelectedItem()+" ";
                ResultSet res = s1.executeQuery(req1);
                
                while(res.next()){
                    t2.setText(res.getString("lib"));
                }
                  
                
            }catch(ClassNotFoundException ee1){
               JOptionPane.showMessageDialog(null,"err:chargement de pilote");
                
            }catch(SQLException  ee2){
                 JOptionPane.showMessageDialog(null,"err: erreur de connection ou requette");
            }
       
        } 
        
        
         
         
        else{
                          //modification 
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection co = null ;
                co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root","");     
                Statement s1 = co.createStatement();
                String req1 ="update service set lib='"+t2.getText()+"'where codeS="+com.getSelectedItem()+" ";
                int res = s1.executeUpdate(req1);
                JOptionPane.showMessageDialog(null,"Modification avec succées !!!");
                  
                
            }catch(ClassNotFoundException ee1){
               JOptionPane.showMessageDialog(null,"err:chargement de pilote");
                
            }catch(SQLException  ee2){
                 JOptionPane.showMessageDialog(null,"err: erreur de connection ou requette");
            }
                   
        }    
        
        
    }
    

    
    public static void main(String[] args){
        
        new ModifierService().setVisible(true);
      
    }

    private void AjouterService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
} 
