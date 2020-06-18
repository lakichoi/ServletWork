package Listener;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import Controls.MemberAddController;
import Controls.MemberDeleteController;
import Controls.MemberListController;
import Controls.MemberLoginController;
import Controls.MemberLogoutController;
import Controls.MemberUpdateController;
import Controls.MemberDao;
import DAO.MysqlMemberDao;

public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext sc = sce.getServletContext();

			InitialContext init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/test");

//		Class.forName(sc.getInitParameter("driver"));
//	
//		conn = DriverManager.getConnection(sc.getInitParameter("url"),
//											sc.getInitParameter("username"),
//											sc.getInitParameter("password")	);
			MemberDao dao = new MysqlMemberDao();
			dao.setDataSource(ds);
			
			sc.setAttribute("/member/list.do", new MemberListController().setDao(dao));
			sc.setAttribute("/member/add.do", new MemberAddController().setDao(dao));
			sc.setAttribute("/member/update.do", new MemberUpdateController().setDao(dao));
			sc.setAttribute("/member/delete.do", new MemberDeleteController().setDao(dao));
			sc.setAttribute("/auth/login.do", new MemberLoginController().setDao(dao));
			sc.setAttribute("/auth/logout.do", new MemberLogoutController());
			
			System.out.println("초기화 완료");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
