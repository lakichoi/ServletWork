package Controls;

import java.util.Map;

import VO.Member;

public class MemberUpdateController implements Controller{
	MemberDao dao;
	
	public MemberUpdateController setDao(MemberDao dao) {
		this.dao = dao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) {
		// TODO Auto-generated method stub
		//MemberDao dao = (MemberDao) model.get("dao");
		Member member = (Member) model.get("member");
		
		if(member.getEmail() != null) {
			dao.update(member);
			return "redirect:list.do";
		}else {
			dao.selectOne(member);
			return "/member/MemberUpdate.jsp";
		}
	}
	
}
