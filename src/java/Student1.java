

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Student1 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
              try {
                  
                  Class.forName("com.mysql.jdbc.Driver");
                  System.out.println("driver has found");
                  
                  Connection con;
                  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","9759447161");
                  
                  System.out.println("connection establish");
                  try {
                      Statement stmt = con.createStatement();
                      String sql =("Select * from studata");
                      log(sql);
                      ResultSet rs = stmt.executeQuery(sql);
                      response.setContentType("text/html;charset=UTF-8");
                      try (PrintWriter out = response.getWriter()) {
                          out.println("<!DOCTYPE html>");
                          out.println("<html>");
                          out.println("<head>");
                          out.println("<title>Welcome</title>");
                          out.println("</head>");
                          out.println("<body bgcolor=aqua>");
                          out.println("<center><h1>Student Details</h1></center>");
                          out.println("<center><table border='1'>");
                          out.println("<tr style=color:blue>");
                          out.println("<td>Roll No</td>");
                          out.println("<td>Name</td>");
                          out.println("<td>Age</td>");
                          out.println("<td>Class</td>");
                          out.println("<td>Delete</td>");
                          out.println("<td>Update</td>");
                          out.println("</tr>");
                          while (rs.next()) {
                              out.println("<tr style=color:red>");
                              out.println("<td>" + rs.getString("roll") + "</td>");
                              out.println("<td>" + rs.getString("name") + "</td>"); 
                              out.println("<td>" + rs.getString("age") + "</td>");
                              out.println("<td>" + rs.getString("sclass") + "</td>");
                              out.println("<td><a href='./DeleteStuData?Roll=" + rs.getString("roll") + "'>Delete </a></form></td>");
                              out.println("<td><a href='./Register.html'>Update </a></form></td>");
                              out.println("</tr>");
                              
                          }
                          out.println("</table></center>");
                          out.println("</body>");
                          out.println("</html>");
                      }
                      con.close();
                  } catch (SQLException ex) {
                      Logger.getLogger(Student1.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
              } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Student1.class.getName()).log(Level.SEVERE, null, ex);
        }
              
          }

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class con {

        private static Statement createStatement() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void close() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public con() {
        }
    }

    private static class uname {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public uname() {
        }
    }

    private static class password {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public password() {
        }
    }
}

   
    
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Student1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Student1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        }
    }*/