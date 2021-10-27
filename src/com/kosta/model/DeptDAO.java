package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kosta.util.DBUtil;

public class DeptDAO {

	static final String SQL_SELECT_ALL = "select * from departments";
	static final String SQL_SELECT_BYID = "select * from departments where department_id=?";
	static final String SQL_SELECT_BYNAME = "select * from departments where department_name like ?";
	static final String SQL_SELECT_BYLOC = "select * from departments where location_id = ?";
	static final String SQL_UPDATE_DEPT = "update departments set department_name=?,manager_id=?,location_id=? where department_id=?";
	static final String SQL_INSERT_DEPT = "insert into departments values(?,?,?,?)";
	static final String SQL_DELETE_DEPT = "delete departments where department_id=?";
	String path;
	public DeptDAO(String path) {
		this.path = path;
	}
	
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = new ArrayList<>();
		Connection conn = DBUtil.dbConnect(path);
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(SQL_SELECT_ALL);
			rs = st.executeQuery();
			while (rs.next()) {
				DeptDTO dept = new DeptDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}

		return deptlist;
	}
	
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = null;
		Connection conn = DBUtil.dbConnect(path);
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(SQL_SELECT_BYID);
			st.setInt(1, deptid);
			rs = st.executeQuery();
			while (rs.next()) {
				dept = new DeptDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}

		return dept;
	}
	public List<DeptDTO> selectByName(String dname) {
		List<DeptDTO> deptlist = new ArrayList<>();
		Connection conn = DBUtil.dbConnect(path);
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(SQL_SELECT_BYNAME);
			st.setString(1, "%"+dname+"%");
			rs = st.executeQuery();
			while (rs.next()) {
				DeptDTO dept = new DeptDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}

		return deptlist;
	}
	
	public List<DeptDTO> selectByLoc(int locid) {
		List<DeptDTO> deptlist = new ArrayList<>();
		Connection conn = DBUtil.dbConnect(path);
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(SQL_SELECT_BYLOC);
			st.setInt(1, locid);
			rs = st.executeQuery();
			while (rs.next()) {
				DeptDTO dept = new DeptDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}

		return deptlist;
	}

	public int updateDept(DeptDTO dept) {
		Connection conn = DBUtil.dbConnect(path);
		PreparedStatement st = null;
		int result = 0;
		try {
			st = conn.prepareStatement(SQL_UPDATE_DEPT);
			st.setString(1, dept.getDepartment_name());
			
			if(dept.getManager_id()==0) {
				st.setNull(2, java.sql.Types.INTEGER);
				//타입은 integer인데 값은 null
			}else {
				st.setInt(2, dept.getManager_id());
			}
			st.setInt(3, dept.getLocation_id());
			st.setInt(4, dept.getDepartment_id());
			result = st.executeUpdate(); //성공:1 실패:0 에러:-1
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
	public int insertDept(DeptDTO dept) {
		Connection conn = DBUtil.dbConnect(path);
		PreparedStatement st = null;
		int result = 0;
		try {
			st = conn.prepareStatement(SQL_INSERT_DEPT);
			st.setString(2, dept.getDepartment_name());
			System.out.println(dept.getDepartment_name());
			st.setInt(3, dept.getManager_id());
			System.out.println(dept.getManager_id());
			st.setInt(4, dept.getLocation_id());
			System.out.println(dept.getLocation_id());
			st.setInt(1, dept.getDepartment_id());
			System.out.println(dept.getDepartment_id());
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
	public int deleteDept(int deptid) {
		Connection conn = DBUtil.dbConnect(path);
		PreparedStatement st = null;
		int result = 0;
		try {
			st = conn.prepareStatement(SQL_DELETE_DEPT);
			st.setInt(1, deptid);
			System.out.println(deptid);
			result = st.executeUpdate(); //성공:1 실패:0 에러:-1
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, null);
		}
		return result;
	}
	
}
