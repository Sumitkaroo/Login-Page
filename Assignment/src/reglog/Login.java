package reglog;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String uname=request.getParameter("uname");  
		String upass=request.getParameter("password");
/**		String type=request.getParameter("type"); */
        Connection con=null;
		     
		try
		{  
		Class.forName("oracle.jdbc.OracleDriver");  
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","Root1234");
		  
		PreparedStatement ps=con.prepareStatement("select * from details where uname=? and password=?");  
		ResultSet rs=null;  
		
		ps.setString(1,uname);  
		ps.setString(2,upass);
/**		ps.setString(3,type);   */
		
/**		ResultSet rs=ps.executeQuery(); 
		
		while(rs.next())
		{
			if(type.equals("A"))
			{
			RequestDispatcher dis=request.getRequestDispatcher("index.jsp");          
	        dis.forward(request, response); 
			}
			
			else if(type.equals("B"))
			{
			RequestDispatcher dis=request.getRequestDispatcher("index.jsp");          
	        dis.forward(request, response); 
			}
			else if(type.equals("C"))
			{
			RequestDispatcher dis=request.getRequestDispatcher("index.jsp");          
	        dis.forward(request, response); 
			}
		}	*/
		          
		rs=ps.executeQuery();  
		if(rs.next())  
		{
			
			  RequestDispatcher dis=request.getRequestDispatcher("index.jsp");          
	          dis.forward(request, response);     
		
		} 
	   
		out.print("Invalid Credentials !!!	");  
		      
		          
	  }catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		}  
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
