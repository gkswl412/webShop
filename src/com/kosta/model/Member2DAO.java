package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kosta.util.DBUtil2;

public class Member2DAO {
	public Member2VO loginCheck(int mid, String mpassword) {
		Member2VO member = null;
		String sql = "select * from member2 where mid=? and mpassword=?";
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1,mid);
			st.setString(2, mpassword);
			rs = st.executeQuery();
			if (rs.next()) {
				member = new Member2VO(mid,mpassword,rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, rs);
		}
		return member;
	}
}
