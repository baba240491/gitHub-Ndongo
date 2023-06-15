/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
@WebServlet(urlPatterns = {"/serve1"})
public class serve1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //on recupere le choix de utilisateur 
            String ch = request.getParameter("choix");
            
        try (PrintWriter out = response.getWriter()) {
            //on repond utilisateur 
             if(ch.equals("Liste"))  {
                 
            try
            {
             //chargement de pilote
               
                //url
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection co;
                co=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveurj","root",""); 
                //espace memoire
                Statement s1=co.createStatement();
                //declaration requete
                String req="select* from user";
                //execution de la requete
            ResultSet res =s1.executeQuery(req);
                
             //on creer un tableau employer        
            out.println("<html>");
            out.println("<head>");
            out.println("<title>liste</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Liste des employes</h1>");
            out.println("<table border='2'>");
            out.println("<tr>");
            out.println("<td>");
            out.println("Matricule");
            out.println("</td>");
            
            out.println("<td>");
            out.println("Nom");
            out.println("</td>");
            
            out.println("<td>");
            out.println("Adresse");
            out.println("</td>");
            out.println("</tr>");
            
            while(res.next())
            {
            out.println("<tr>");
            out.println("<td>");
            out.println(""+res.getInt("matricule"));
            out.println("</td>");
            
            out.println("<td>");
            out.println(""+res.getString("nom"));
            out.println("</td>");
            
            out.println("<td>");
            out.println(""+res.getString("address"));
            out.println("</td>");
            out.println("</tr>"); 
            }
            out.println("</table>");
            
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
               
            }
            catch(SQLException e1)
            {
                out.println("err de requete ou connexion");
            }
            catch(ClassNotFoundException ee)
            {
                out.println("err de pilote");
            }
              
              
         }else{
                 
                  out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<head>");
            out.println("<h1>Formulaire</h1>");
            out.println("<form action='serve2' methode='Post' >");
            
            out.println("<label>Saisir votre matricule </label>");       
            out.println("<input type='number' name='ma'><br/>");
            
            out.println("<label>Saisir votre nom </label>");
            out.println("<input type='text' name='no'><br/>");

            out.println("<label>Saisir votre adress </label>");
            out.println("<input type='text' name='add'><br/>");

            out.println("<input type='submit' value ='Ajout'>");
            out.println("</form >");

            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
                 
                 
                 
                 
                 
             }
                 
         
             
        }    
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
