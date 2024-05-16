package ch11;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class RegisterMgrPool {
	private DBConnectionMgr pool=null;
	
	public RegisterMgrPool() {
		try {
			pool=DBConnectionMgr.getInstance();
		} catch(Exception e) {
			System.out.println("Error : 커넥션 불러오기 실패");
		}
	}
	
	public Vector<RegisterBean> getRegisterList() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		Vector<RegisterBean> vlist = new Vector<RegisterBean>();
		try {
			conn=pool.getConnection();
			String strQuery="select * from tblRegister";
			stmt = conn.createStatement();
			rs=stmt.executeQuery(strQuery);
			while(rs.next()) {
				RegisterBean regBean = new RegisterBean();
				regBean.setId (rs.getString("id"));
				regBean.setPwd (rs.getString("pwd"));
				regBean.setName (rs.getString("name"));
	 			regBean.setNum1 (rs.getString("num1"));
	 			regBean.setNum2 (rs.getString("num2"));
	 			regBean.setEmail (rs.getString("email"));
	 			regBean.setPhone (rs.getString("phone"));
	 			regBean.setZipcode (rs.getString("zipcode"));
	 			regBean.setAddress (rs.getString("address"));
	 			regBean.setJob (rs.getString("job"));
	 			vlist.add(regBean);
			}
		}catch(Exception ex) {
			System.out.println("Exception"+ex);
		}finally {
			pool.freeConnection(conn);
		}
		return vlist;
	}
}
