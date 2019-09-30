

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class login extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
          String uname=request.getParameter("uname");
          String password=request.getParameter("password");
              try {
                  
                  Class.forName("com.mysql.jdbc.Driver");
                  System.out.println("driver has found");
                   
                  Connection con;
                  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","9759447161");
                  
                  System.out.println("connection establish");
                  
                  PreparedStatement ps = con.prepareStatement("select username,password from login where username=? and password=?");
                  ps.setString(1, uname);
                  ps.setString(2,password);
                  
                  ResultSet rs = ps.executeQuery();
                  
                  while (rs.next()){
                      response.sendRedirect("./Student1");
                      return;
                  }
                  response.sendRedirect("./index.html");
                  
                  
    }   catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
