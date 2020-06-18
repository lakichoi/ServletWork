package Controls;

import java.util.Map;

import VO.Member;

public class MemberLoginController implements Controller {
	MemberDao dao;
	
	public MemberLoginController setDao(MemberDao dao) {
		this.dao = dao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) {
		// TODO Auto-generated method stub
	//	MemberDao dao = (MemberDao) model.get("dao");
		Member member = (Member) model.get("member");
		Member login = dao.login(member);
		if(login.getName()!=null) {
			model.put("login", login);
			return "redirect:../member/list.do";
		} else {
			return "/auth/LoginFail.jsp";
		}

	}

}
