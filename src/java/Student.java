
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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


public class Student extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         
         int roll=Integer.parseInt(request.getParameter("roll"));
         String name=request.getParameter("name");
         String fname=request.getParameter("fname");
         int age=Integer.parseInt(request.getParameter("age"));
         int sclass=Integer.parseInt(request.getParameter("class"));
         
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver has found");
            
            Connection con;
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","9759447161");
            System.out.println("connection establish");
            
            Statement stmt=con.createStatement();
            //insertion
            stmt.executeUpdate("insert into studata (roll_no, name, father_name, age, class) values ("+roll+", '"+name+"','"+fname+"',"+age+","+sclass+")");
            System.out.println("result has sucessfully"); 
            try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<td>Roll No.</td>");
            out.println("<td>Name</td>");
            out.println("<td>Father Name</td>");
            out.println("<td>Age</td>");
            out.println("<td>Class</td>");
            out.println("</tr>");
             while (rs.next()) { 
                    out.println("<tr>");
                    out.println("<td>" + Integer.parseInt(request.getParameter("roll_no")) + "</td>");  
                    out.println("<td>" + request.getParameter("name") + "</td>");
                    out.println("<td>" + request.getParameter("father_name") + "</td>"); 
                    out.println("<td>" + Integer.parseInt(request.getParameter("age")) + "</td>");
                    out.println("<td>" + Integer.parseInt(request.getParameter("class")) + "</td>");
                    out.println("<td><a href='./DeleteStuData?Roll>Delete </a></form></td>");
                    out.println("</tr>");    
                }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            
            con.close();
       
        } catch (SQLException ex) {
             Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         
        
    }    catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    private static class rs {

        private static boolean next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public rs() {
        }
    }
 
}