

import java.io.IOException;
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver has found");
             
            Connection con;
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","9759447161");
            System.out.println("connection establish");
            
             try {
                      Statement stmt = con.createStatement();
                      String sql =("insert into studata(roll, name, age, sclass) values("+ request.getParameter("roll") +",'"+ request.getParameter("name") +"',"+ request.getParameter("age") +","+ request.getParameter("sclass")+")");
                      log(sql);
                      stmt.executeUpdate(sql);
                     
                      con.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect("./Student1");
    }   catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}