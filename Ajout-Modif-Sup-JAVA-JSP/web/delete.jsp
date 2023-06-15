<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import = "java.sql.*" %>


        <%
            int m=Integer.parseInt(request.getParameter("matricule"));
          
            
            
            try
            {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection co ;
            co=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveurj","root","");
            Statement s1 =co.createStatement();
            String req="delete from user where matricule="+m+" ";
            int res= s1.executeUpdate(req);
            
            ServletContext ct=request.getServletContext();
        RequestDispatcher dis=ct.getRequestDispatcher("/jsp1.jsp");
        dis.forward(request, response);
      
                
        }
                    
            
catch(ClassNotFoundException ee1)
{
out.println("err : pilote");
}
catch(SQLException ee2)
{
out.println("err : connexion");
}
        %>
    
