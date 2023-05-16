// Loading required libraries
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.Date;

public class ViewTicketServlet2 extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/mini_project";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "Kanna128#";
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;

            sql = "Select id,ticket_date from ticket where status='Applied'";
            ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement st, sto;

            int i = 0;
            // Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                Date date = rs.getDate("ticket_date");

                String pa = request.getParameter("id" + i);

                st = conn.prepareStatement("UPDATE attendance SET present = ? WHERE id = ? AND curr_date = ?");
                st.setString(1, pa);
                st.setInt(2, id);
                st.setDate(3, date);

                st.executeUpdate();


                sto = conn.prepareStatement("UPDATE ticket SET status = ? WHERE id = ? AND ticket_date = ?");

                // String to=request.getParameter("to");
                // String subject=request.getParameter("subject");
                // String msg=request.getParameter("msg");

                if (pa.equals("Yes") == true) {
                    sto.setString(1, "Accepted");
//                    Mailer.send("padmapooja2010291@ssn.edu.in", "Regarding OD", "Accepted");
                }

                else {
                    sto.setString(1, "Rejected");
//                    Mailer.send("padmapooja2010291@ssn.edu.in", "Regarding OD", "Rejected");
                }

                sto.setInt(2, id);
                sto.setDate(3, date);

                sto.executeUpdate();

                i = i + 1;
            }
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            out.println("<!DOCTYPE html><html lang=\"en\"><head><title>Attendance Updated</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\"></head><body><div class=\"limiter\"><div class=\"container-login100\"><div class=\"wrap-login100\"><div class=\"login100-pic js-tilt\" data-tilt><img src=\"img/portfolio-3.jpg\" alt=\"IMG\"></div><form class=\"login100-form validate-form\" action=\"\"><span class=\"login100-form-title\" style=\"font-size: 50px\">Attendance Updated!</span><div class=\"container-login100-form-btn\"><button class=\"login100-form-btn\" onclick=\"location.href='Teacher_home.html'\" type=\"button\">Go Home</button></div><br><br><br><br><br><br><br></form></div></div></div><script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script><script src=\"vendor/bootstrap/js/popper.js\"></script><script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script><script src=\"vendor/select2/select2.min.js\"></script><script src=\"vendor/tilt/tilt.jquery.min.js\"></script><script >$('.js-tilt').tilt({scale: 1.1})</script><script src=\"js/main1.js\"></script>");

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }

        catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}