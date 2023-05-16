import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Insert_createlogin extends HttpServlet {
	// JDBC driver name and database URL

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/mini_project";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "Kanna128#";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("<!DOCTYPE html><html lang='en'><head><title>Inserted!</title><meta charset='UTF - 8'><meta name='viewport' content='width = device - width, initial - scale = 1'><link rel='icon' type='image / png' href='images / icons / favicon.ico'/><link rel='stylesheet' type='text / css' href='vendor / bootstrap / css / bootstrap.min.css'><link rel='stylesheet' type='text / css' href='fonts / font - awesome - 4.7.0 / css / font - awesome.min.css'><link rel='stylesheet' type='text / css' href='vendor / animate / animate.css'><link rel='stylesheet' type='text / css' href='vendor / css - hamburgers / hamburgers.min.css'><link rel='stylesheet' type='text / css' href='vendor / select2 / select2.min.css'><link rel='stylesheet' type='text / css' href='css / util.css'><link rel='stylesheet' type='text / css' href='css / main.css'></head><body>");
		//out.println("<!DOCTYPE html><html lang='en'><head><title>Inserted!</title><meta charset='UTF - 8'><meta name='viewport' content='width = device - width, initial - scale = 1'><!--===============================================================================================-->	<link rel='icon' type='image / png' href='images / icons / favicon.ico'/><!--===============================================================================================--><link rel='stylesheet' type='text / css' href='vendor / bootstrap / css / bootstrap.min.css'><!--===============================================================================================--><link rel='stylesheet' type='text / css' href='fonts / font - awesome - 4.7.0 / css / font - awesome.min.css'><!--===============================================================================================--><link rel='stylesheet' type='text / css' href='vendor / animate / animate.css'><!--===============================================================================================-->	<link rel='stylesheet' type='text / css' href='vendor / css - hamburgers / hamburgers.min.css'><!--===============================================================================================--><link rel='stylesheet' type='text / css' href='vendor / select2 / select2.min.css'><!--===============================================================================================--><link rel='stylesheet' type='text / css' href='css / util.css'><link rel='stylesheet' type='text / css' href='css / main.css'><!--===============================================================================================--></head><body>");
		try {
			// Register JDBC driver
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName(JDBC_DRIVER);

			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//out.println(Integer.valueOf(request.getParameter("id")) + request.getParameter("name") + Integer.valueOf(request.getParameter("age")));
			//out.println(request.getParameter("phone-no") + request.getParameter("address") + request.getParameter("gender") + request.getParameter("marit-stat") + request.getParameter("dov"));
			// Execute SQL query
			PreparedStatement st = conn
			                       .prepareStatement("insert into login values(?, ?, ?, ?, ?)");

			st.setString(1, request.getParameter("role"));
			st.setInt(2, Integer.valueOf(request.getParameter("id")));
			st.setString(3, request.getParameter("name"));
			st.setString(4, request.getParameter("username"));
			st.setString(5, request.getParameter("password"));
			st.executeUpdate();

			// Close all the connections
			st.close();
			conn.close();

			// Get a writer pointer
			// to display the successful result

			//out.println(
			//  "<div class='limiter'><div class='container - login100'><div class='wrap - login100'><div class='login100 - pic js - tilt' data-tilt><img src='img / portfolio - 3.jpg' alt='IMG'></div><form class='login100 - form validate - form' action=''><span class='login100 - form - title' style='font - size: 50px;'>Login Created!</span><div class='container - login100 - form - btn'><button class='login100 - form - btn' onclick='location.href = 'index.html'' type='button'>Go Home</button></div><br><br><br><br><br><br><br></form></div></div></div><script src='vendor / jquery / jquery - 3.2.1.min.js'></script> <script src='vendor / bootstrap / js / popper.js'></script><script src='vendor / bootstrap / js / bootstrap.min.js'></script><script src='vendor / select2 / select2.min.js'></script><script src='vendor/tilt/tilt.jquery.min.js'></script><script >$('.js-tilt').tilt({scale: 1.1})</script><script src='js/main1.js'></script>");
			//out.println("<div class='limiter'><div class='container - login100'><div class='wrap - login100'><div class='login100 - pic js - tilt' data-tilt><img src='img / portfolio - 3.jpg' alt='IMG'></div><form class='login100 - form validate - form' action=''><span class='login100 - form - title' style='font - size: 50px'>Login Created!</span><div class='container - login100 - form - btn'><button class='login100 - form - btn' onclick='location.href = 'index.html'' type='button'>Go Home</button></div><br><br><br><br><br><br><br></form></div></div></div><!--===============================================================================================-->	<script src='vendor / jquery / jquery - 3.2.1.min.js'></script><!--===============================================================================================--><script src='vendor / bootstrap / js / popper.js'></script><script src='vendor / bootstrap / js / bootstrap.min.js'></script><!--===============================================================================================--><script src='vendor / select2 / select2.min.js'></script><!--===============================================================================================--><script src='vendor / tilt / tilt.jquery.min.js'></script><script >$('.js-tilt').tilt({scale: 1.1})</script><!--===============================================================================================--><script src='js / main1.js'></script>");
			out.println("<!DOCTYPE html><html lang=\"en\"><head><title>Inserted!</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\"></head><body><div class=\"limiter\"><div class=\"container-login100\"><div class=\"wrap-login100\"><div class=\"login100-pic js-tilt\" data-tilt><img src=\"img/portfolio-3.jpg\" alt=\"IMG\"></div><form class=\"login100-form validate-form\" action=\"\"><span class=\"login100-form-title\" style=\"font-size: 50px\">Login Created!</span><div class=\"container-login100-form-btn\"><button class=\"login100-form-btn\" onclick=\"location.href='index.html'\" type=\"button\">Go Home</button></div><br><br><br><br><br><br><br></form></div></div></div><script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script><script src=\"vendor/bootstrap/js/popper.js\"></script><script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script><script src=\"vendor/select2/select2.min.js\"></script><script src=\"vendor/tilt/tilt.jquery.min.js\"></script><script >$('.js-tilt').tilt({scale: 1.1})</script><script src=\"js/main1.js\"></script>");
		} catch (Exception e) {
			out.print("<p>Error</p>");
			e.printStackTrace();
		} finally {
			//out.println("<form action='http://localhost:8080/PMS/ID' method='get'><button type='submit'>View</button>");
			out.println("</body></html>");
		}
	}
}