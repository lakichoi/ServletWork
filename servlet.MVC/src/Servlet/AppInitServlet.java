package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppInitServlet
 */
//@WebServlet("/AppInitServlet")
public class AppInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("AppInit 접속");
		super.init(config);
		
		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			Connection conn = DriverManager.getConnection(sc.getInitParameter("url"),sc.getInitParameter("username"),sc.getInitParameter("password"));
			sc.setAttribute("conn", conn);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

    @Override
	public void destroy() {
    	System.out.println("AppInitServlet 접속..");
		Connection conn = (Connection) this.getServletContext().getAttribute("conn");
		super.destroy();
		
		try {
			if (conn!=null && conn.isClosed()==false)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	/**
     * @see HttpServlet#HttpServlet()
     */
    public AppInitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
