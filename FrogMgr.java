package frogM;

import java.io.Console;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class FrogMgr {

	static DBConnectionMgr pool;

	public FrogMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	public boolean loginChk(String id, String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select COUNT(ID) from KHG1894.\"member\" "
					+ "where id = ? and pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()&&rs.getInt(1)==1) {
				flag = true;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	System.out.println(flag);
		return flag;
	
	}
	public void selectData() {
		
	}
}
/*
 * Classpath 설정 jdk or jre -> 기본클래스가 필요 현재 실행중인 class jvm인식 외부 클래스들 -> .jar 형식으로
 * 압축
 */
