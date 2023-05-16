// Loading required libraries
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class MarkAttendanceServlet1 extends HttpServlet {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/mini_project";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "Kanna128#";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!doctype html>\n" +
                    "<html>\n" +
                    "<head><title>MarkAttendance</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">" +
                    "</head>\n<body>\n" +
                    "<div class=\"limiter\"><div class=\"container-login100\"><div class=\"card\" align=\"center;\" >" +
                    "<form align=\"center\" style = \"width:80%;margin:auto;\" class=\"login100-form validate-form\" action=\"http://localhost:2525/Mini_Project/MarkAttendanceServlet2\" method=\"post\">" +
                    "<!--<label for=\"date\">Date:</label>-->" +
                    "<input class=\"input100\" type=\"date\" id=\"atddate\" name=\"atddate\"><br>\n" +
                    "<span class=\"login100-form-title\" style=\"font-size: 30px;text-align:center;\">Mark Attendance:</span>\n" +
                    "<table border = \"1\">\n" +
                    "<tr>\n" +
                    "<th style=\"width:50%;padding:10px 10px 10px 10px;\">Student ID</th>" +
                    "<th style=\"width:50%;padding:10px 10px 10px 10px;\">Name</th>" +
                    "<th style=\"width:50%;padding:10px 10px 10px 10px;\">Present or Absent</th>\n" +
                    "</tr>"
                   );

        // JDBC driver name and database URL


        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;

            sql = "Select id,name from login where role='Student'";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;
            // Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");

                //Display values
                out.println("<tr>\n" +
                            "<td style=\"padding:10px 10px 10px 10px;\">" + id + "</td>" +
                            "<td style=\"padding:10px 10px 10px 10px;\">" + name + "</td>" +
                            "<td style=\"padding10px 10px 10px 10px;\">" +
                            "<label><input type=\"radio\" name=\"id" + i + "\" value=\"yes\" required> Yes </label><br>" +
                            "<label><input type=\"radio\" name=\"id" + i + "\"value=\"no\"> No </label>" +
                            "</td>\n" +
                            "</tr>"
                           );
                i = i + 1;
            }
            out.println("</table>\n");
            out.println("<div class=\"container-login100-form-btn\"><input class=\"login100-form-btn\" type=\"submit\" value=\"Submit\"></div>");
            out.println("</form></div></div></div><script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script><script src=\"vendor/bootstrap/js/popper.js\"></script><script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script><script src=\"vendor/select2/select2.min.js\"></script><script src=\"vendor/tilt/tilt.jquery.min.js\"></script><script >$('.js-tilt').tilt({scale: 1.1})</script><script src=\"js/main1.js\"></script></body></html>");

            // Clean-up environment
            out.close();
            rs.close();
            stmt.close();
            conn.close();
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