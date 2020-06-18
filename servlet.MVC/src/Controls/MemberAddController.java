package Controls;

import java.util.Map;

import VO.Member;

public class MemberAddController implements Controller{
	MemberDao dao;
	
	
	public MemberAddController setDao(MemberDao dao) {
		this.dao = dao;
		return this;
	}


	@Override
	public String execute(Map<String, Object> model) {
		if(model.get("member") == null) { 
			return "/member/MemberAdd.jsp";
		}else {
		//	MemberDao dao=(MemberDao) model.get("dao");
			Member member = (Member) model.get("member");
			dao.memberAdd(member);
			return "redirect:list.do";
		}
	}
	
}
