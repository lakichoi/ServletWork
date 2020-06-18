package Controls;

import java.util.Map;


public class MemberListController implements Controller{
	MemberDao dao;
	
	
	public MemberListController setDao(MemberDao dao) {
		this.dao = dao;
		return this;
	}


	@Override
	public String execute(Map<String, Object> model) {
		// TODO Auto-generated method stub
		//MemberDao dao = (MemberDao) model.get("dao");
		model.put("member", dao.selectList());
		
		return "/member/MemberList.jsp";
	}
	
}//
