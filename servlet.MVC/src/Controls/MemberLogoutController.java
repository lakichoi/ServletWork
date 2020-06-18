package Controls;

import java.util.Map;


public class MemberLogoutController implements Controller {


	@Override
	public String execute(Map<String, Object> model) {
		// TODO Auto-generated method stub
		return "redirect:../member/list.do";
	}

}
