package ch16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class PollMgr {
	private DBConnectionMgr pool;
	
	public PollMgr() {
		try {
			pool = DBConnectionMgr.getInstance();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int maxNum = 0;
		
		try {
			con = pool.getConnection();
			sql = "select max(num) from tblPollList";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				maxNum = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return maxNum;
	}
	
	public boolean insertPoll(PollListBean plBean, PollItemBean piBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "insert tblPollList(question,sdate,edate,wdate,type)"
					+"values(?,?,?,now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, plBean.getQuestion());
			pstmt.setString(2, plBean.getSdate());
			pstmt.setString(3, plBean.getEdate());
			pstmt.setInt(4, plBean.getType());
			int result = pstmt.executeUpdate();
			if(result == 1) {
				sql = "insert tblPollItem values (?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				String[] item = piBean.getItem();
				int itemnum = getMaxNum();
				int j = 0;
				for(int i=0;i<item.length;i++) {
					if(item[i] == null || item[i].equals(""))
						break;
					pstmt.setInt(1, itemnum);
					pstmt.setInt(2, i);
					pstmt.setString(3, item[i]);
					pstmt.setInt(4, 0);
					j = pstmt.executeUpdate();
				}
				if (j > 0) {
					flag = true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	public Vector<PollListBean> getAllList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<PollListBean> vlist = new Vector<PollListBean>();
		
		try {
			con = pool.getConnection();
			sql = "select * from tblPollList order by num desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PollListBean plBean = new PollListBean();
				plBean.setNum(rs.getInt("num"));
				plBean.setQuestion(rs.getString("question"));
				plBean.setSdate(rs.getString("sdate"));
				plBean.setEdate(rs.getString("edate"));
				vlist.add(plBean);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	public PollListBean getList(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		PollListBean plBean = new PollListBean();
		
		try {
			con = pool.getConnection();
			if(num==0)
				sql = "select * from tblPollList order by num desc";
			else
				sql = "select * from tblPollList where num="+num;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				plBean.setQuestion(rs.getString("question"));
				plBean.setType(rs.getInt("type"));
				plBean.setActive(rs.getInt("active"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return plBean;
	}
	
	public Vector<String> getItem(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<String> vlist = new Vector<String>();
		
		try {
			con = pool.getConnection();
			if(num == 0)
				num = getMaxNum();
			sql = "select item from tblPollItem where listnum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vlist.add(rs.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	public boolean updatePoll(int num, String[] itemnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "update tblPollItem set count = count+1 where listnum=? and itemnum=?";
			pstmt = con.prepareStatement(sql);
			if (num==0)
				num = getMaxNum();
			for(int i=0;i<itemnum.length;i++) {
				if(itemnum[i]==null || itemnum[i].equals(""))
					break;
				pstmt.setInt(1, num);
				pstmt.setInt(2, Integer.parseInt(itemnum[i]));
				int j = pstmt.executeUpdate();
				if(j>0)
					flag = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	public Vector<PollItemBean> getView(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<PollItemBean> vlist = new Vector<PollItemBean>();
		
		try {
			con = pool.getConnection();
			sql = "select item, count from tblPollItem where listnum=?";
			pstmt = con.prepareStatement(sql);
			if(num==0)
				pstmt.setInt(1, getMaxNum());
			else
				pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PollItemBean piBean = new PollItemBean();
				String item[] = new String[1];
				item[0] = rs.getString(1);
				piBean.setItem(item);
				piBean.setCount(rs.getInt(2));
				vlist.add(piBean);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	public int sumCount(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			con = pool.getConnection();
			sql = "select sum(count) from tblPollItem where listnum=?";
			pstmt = con.prepareStatement(sql);
			if(num==0)
				pstmt.setInt(1, getMaxNum());
			else
				pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return count;
	}
}
