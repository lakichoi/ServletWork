package Servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controls.Controller;
import Controls.MemberAddController;
import VO.Member;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HashMap<String, Object> model = new HashMap<String, Object>();
			ServletContext sc = this.getServletContext();
			model.put("dao", sc.getAttribute("dao"));

			String servletPath = request.getServletPath();
			Controller pageController = (Controller) sc.getAttribute(servletPath);

			if ("/member/add.do".equals(servletPath)) {
				//pageController = new MemberAddController();
				if (request.getParameter("email") != null) {
					model.put("member", new Member().setName(request.getParameter("name"))
							.setEmail(request.getParameter("email")).setPassword(request.getParameter("password")));
				}
			} else if ("/member/update.do".equals(servletPath)) {
				if (request.getParameter("email") != null) {
					model.put("member", new Member().setNo(Integer.parseInt(request.getParameter("no")))
							.setName(request.getParameter("name")).setEmail(request.getParameter("email")));
				} else {
					model.put("member", new Member().setNo(Integer.parseInt(request.getParameter("no"))));
				}
			} else if ("/member/delete.do".equals(servletPath)) {
				model.put("member", new Member().setNo(Integer.parseInt(request.getParameter("no"))));
				
			} else if ("/auth/login.do".equals(servletPath)) {
				model.put("member", new Member().setEmail(request.getParameter("email")).setPassword(request.getParameter("password")));
				
			} else if ("/auth/logout.do".equals(servletPath)) {
				HttpSession session = request.getSession();
				session.invalidate();
			}

//			RequestDispatcher rd = request.getRequestDispatcher(pageController);
//			rd.include(request, response);

			// String viewUrl = (String) request.getAttribute("viewUrl");
			String viewUrl = pageController.execute(model);
				
			for (String key : model.keySet())
				request.setAttribute(key, model.get(key));

			if(model.get("login") != null) {
				HttpSession session = request.getSession();
				session.setAttribute("login", model.get("login"));
			}
			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
	}// service end
}// end
