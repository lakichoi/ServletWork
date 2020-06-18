package Controls;

import java.util.List;

import javax.sql.DataSource;

import VO.Member;

public interface MemberDao {
	
	public void setDataSource(DataSource ds);
	public List<Member> selectList();
	public int memberAdd(Member member);
	public Member selectOne(Member member);
	public int update(Member member);
	public int delete(Member member);
	public Member login(Member member);
}
