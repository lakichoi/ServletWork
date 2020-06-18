package Controls;

import java.util.Map;

import VO.Member;

public class MemberDeleteController implements Controller {
	MemberDao dao;
	
	public MemberDeleteController setDao(MemberDao dao) {
		this.dao = dao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) {
		// TODO Auto-generated method stub
		///MemberDao dao = (MemberDao) model.get("dao");
		Member member=(Member) model.get("member");
		dao.delete(member);
		return "redirect:list.do";
	}

}
