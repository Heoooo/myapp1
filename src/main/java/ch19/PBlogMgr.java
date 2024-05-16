package ch19;

import java.io.File;
import java.sql.*;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ch19.UtilMgr;
import ch19.PMemberBean;
import ch19.PBlogBean;

public class PBlogMgr {
	private DBConnectionMgr pool;
	private static final String SAVEFOLDER = "C:\\Users\\jinhy\\OneDrive\\바탕 화면\\myapp1\\src\\main\\webapp\\ch19\\photo";
	private static final String ENCTYPE = "UTF-8";
	private static int MAXSIZE = 20*1024*1024;
	
	public PBlogMgr() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원 로그인 메소드
	public boolean loginPMember(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "select id from tblPMember where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			flag = rs.next();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	
	//회원 정보 가져오는 메소드
	public PMemberBean getPMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		PMemberBean bean = new PMemberBean();
		
		try {
			con = pool.getConnection();
			sql = "select name, profile from tblPMember where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setId(id);
				bean.setName(rs.getString(1));
				bean.setProfile(rs.getString(2));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	//본인 제외 5명 회원 정보 리스트 가져오는 메소드
	public Vector<PMemberBean> listPMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<PMemberBean> vlist = new Vector<PMemberBean>();
		
		try {
			con = pool.getConnection();
			sql = "select id, name, profile from tblPMember where id !=? order by rand() limit 5";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PMemberBean bean = new PMemberBean();
				bean.setId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setProfile(rs.getString(3));
				vlist.addElement(bean);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//포토포스트 저장 메소드
	public void insertPBlog(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		MultipartRequest multi = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			multi = new MultipartRequest(req, SAVEFOLDER, MAXSIZE, ENCTYPE, new DefaultFileRenamePolicy());
			String photo = null;
			if(multi.getFilesystemName("photo")!=null) {
				photo = multi.getFilesystemName("photo");
			}
			sql = "insert tblPBlog(message, id, pdate, photo) values(?,?,now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, multi.getParameter("message"));
			pstmt.setString(2, multi.getParameter("id"));
			pstmt.setString(3, photo);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	
	//포토포스트 삭제 메소드
	public void deletePBlog(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			String photo = getPhoto(num);
			if(photo!=null) {
				File file = new File(SAVEFOLDER + "/" + photo);
				if(file.exists())
					UtilMgr.delete(SAVEFOLDER + "/" + photo);
			}
			con = pool.getConnection();
			sql = "delete from tblPBlog where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			if(pstmt.executeUpdate()>0) {
				PReplyMgr pMgr = new PReplyMgr();
				pMgr.deleteAllPReply(num);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	
	//포토포스트 포토 파일명 가져오는 메소드
	public String getPhoto(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String photo = null;
		
		try {
			con = pool.getConnection();
			sql = "select photo from tblPBlog where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				photo = rs.getString(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return photo;
	}
	
	//포토포스트 리스트 가져오는 메소드
	public Vector<PBlogBean> listPBlog(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<PBlogBean> vlist = new Vector<PBlogBean>();
		
		try {
			con = pool.getConnection();
			sql = "select * from tblPBlog where id=? order by num desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PBlogBean bean = new PBlogBean();
				bean.setNum(rs.getInt(1));
				bean.setMessage(rs.getString(2));
				bean.setId(rs.getString(3));
				bean.setPdate(rs.getString(4));
				bean.setPhoto(rs.getString(5));
				bean.setHcnt(rs.getInt(6));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//'좋아요' 카운트 개수 증가 메소드
	public void upHCnt(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "update tblPBlog set hCnt=hCnt+1 where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
}
