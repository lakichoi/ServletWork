package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Controls.MemberDao;
import VO.Member;

public class MysqlMemberDao implements MemberDao {
	private DataSource ds;
	String sql;
	PreparedStatement pstmt;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public List<Member> selectList() {
		sql = "SELECT MNO,MNAME,EMAIL,CRE_DATE FROM member ORDER BY MNO asc";
		ArrayList<Member> members = new ArrayList<Member>();
		try {
			Connection conn = ds.getConnection();
			Statement stmt =  conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				members.add(new Member()
						.setNo(rs.getInt("MNO"))
						.setName(rs.getString("MNAME"))
						.setEmail(rs.getString("EMAIL"))
						.setCreatedDate(rs.getDate("CRE_DATE"))	);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;


	}

	public int memberAdd(Member member) {
		sql = "INSERT INTO member(EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE) VALUES(?,?,?,now(),now())";
		try {
			Connection conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public Member selectOne(Member member) {
		sql = "SELECT MNO,MNAME,EMAIL,CRE_DATE FROM member WHERE MNO=?";

		try {
			Connection conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getNo());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			member.setNo(rs.getInt("MNO")).setName(rs.getString("MNAME")).setEmail(rs.getString("EMAIL"))
					.setCreatedDate(rs.getDate("CRE_DATE"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;

	}

	public int update(Member member) {
		sql = "UPDATE member SET EMAIL=?,MNAME=?,MOD_DATE=now() WHERE MNO=?";
		// String sql = "UPDATE member SET EMAIL=?, MNAME=?, MOD_DATE=now() WHERE
		// MNO=?";
		try {
			Connection conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getName());
			pstmt.setInt(3, member.getNo());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int delete(Member member) {
		sql = "DELETE FROM member WHERE MNO=?";
		try {
			Connection conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getNo());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public Member login(Member member) {
		sql = "SELECT* FROM member WHERE EMAIL=? AND PWD=?";
		try {
			Connection conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			member.setName(rs.getString("MNAME")).setEmail(rs.getString("EMAIL"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;

	}

}