package com.sh.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.sh.member.model.dtto.Member;

/**
 * DAO : db담당
 * - Database
 * - Access
 * - Object
 */
public class MemberDao {

	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "student";
	String password = "student";
	
	/**
	 * DQL
	 * 여러건 조회하는 경우
	 * - n행이 조회된 경우, ArrayList에 요소추가후 반환
	 * - 0행이 조횓된 경우, 빈 ArrayList를 반환
	 * 
	 * 전체 회원 조회
	 * @return
	 */
	public List<Member> findAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member order by reg_date desc";
		List<Member> members = new ArrayList<>(); // 0행이 리턴되어도 빈 list 객체를 반환
		
		try {
			// 1. 클래스 등록
			Class.forName(driverClass);
	
			// 2. Connection 생성
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. PreparedStatement 생성 - 미완성쿼리 값대입
			pstmt = conn.prepareStatement(sql);
			
			// 4. 실행 - ResultSet 반환
			rset = pstmt.executeQuery();
			
			// 5. ResultSet -> List<Member> - 행별로 접근
			while(rset.next()) {
				String id = rset.getString("id"); // 컬럼명 대소문자 구분안함.
				String name = rset.getString("name");
				String gender = rset.getString("gender");
				Date birthday = rset.getDate("birthday");
				String email = rset.getString("email");
				int point = rset.getInt("point");
				Timestamp regDate = rset.getTimestamp("reg_date");
				Member member = new Member(id, name, gender, birthday, email, point, regDate);
				members.add(member);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			// 6. 자원반납
			try {
				rset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return members;
	}

	/**
	 * 한건 조회인 경우
	 * - 1행 조회되면, member객체 반환
	 * - 0행 조회되면, null 반환
	 * 
	 * 사용자로부터 입력받은 아이디의 정보 조회
	 * @param id
	 * @return
	 */
	public Member findById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where id = ?";
		Member member = null;
		
		try {
			// 1. 클래스등록
			Class.forName(driverClass);
			
			// 2. Connection 생성
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. PreparedStatement 반환
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, id);
			
			// 4. 실행 - ResultSet 반환
			rset = pstmt.executeQuery();
			
			// 5. ResultSet -> Member
			while(rset.next()) {
				member = new Member();
				member.setId(rset.getString("id"));
				member.setName(rset.getString("name"));
				member.setGender(rset.getString("gender"));
				member.setBirthday(rset.getDate("birthday"));
				member.setEmail(rset.getString("email"));
				member.setPoint(rset.getInt("point"));
				member.setRegDate(rset.getTimestamp("reg_date"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원반납
			try {
				rset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	/**
	 * 사용자로부터 입력받은 이름으로 회원 조회
	 * @return
	 */
	public List<Member> findByName(String names) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where name like ?";
		List<Member> members = new ArrayList<>();
		
		try {
			// 1. 클래스등록
			Class.forName(driverClass);
			
			// 2. Connection 생성
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. PreparedStatement 반환
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + names + "%");
			
			// 4. 실행 - ResultSet 반환
			rset = pstmt.executeQuery();
			
			// 5. ResultSet -> Member
			while(rset.next()) {
				String id = rset.getString("id"); // 컬럼명 대소문자 구분안함.
				String name = rset.getString("name");
				String gender = rset.getString("gender");
				Date birthday = rset.getDate("birthday");
				String email = rset.getString("email");
				int point = rset.getInt("point");
				Timestamp regDate = rset.getTimestamp("reg_date");
				Member member = new Member(id, name, gender, birthday, email, point, regDate);
				members.add(member);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원반납
			try {
				rset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return members;
	}

	/**
	 * DML
	 * 
	 * 사용자로부터 입력받은 member 정보 등록(회원가입)
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into member values (?, ?, ?, ?, ?, default, default)";
		
		try {
			// 1. 클래스등록
			Class.forName(driverClass);
			
			// 2. Connection 생성 (autocommit - false설정)
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
	
			// 3. PreparedStatement 생성 - 미완성쿼리 값대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getGender());
			pstmt.setDate(4, member.getBirthday());
			pstmt.setString(5, member.getEmail());
			
			// 4. 실행 - int 반환 (처리된 행의 수)
			result = pstmt.executeUpdate();
		
			// 5. 트랜잭션처리
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.err.println("이미 존재하는 회원입니다.");
		} catch (SQLException e) {
			 e.printStackTrace();
		} finally {
			// 6. 자원반납
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 사용자로부터 입력받은 아이디로 회원 삭제
	 * @param id
	 * @return
	 */
	public int deleteMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete from member where id = ?";
		
		try {
			// 1. 클래스 등록
			Class.forName(driverClass);
			
			// 2. Connection 생성 (autocommit - false설정)
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
			// 3. PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// 4. 실행
			result = pstmt.executeUpdate();
			
			// 5. 트랜잭션 처리
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 반납
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 사용자로부터 입력받은 아이디 정보의 이름 변경
	 * @param id
	 * @param name
	 * @return
	 */
	public int updateName(String id, String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set name = ? where id = ?";
		int result = 0;
		
		try {
			// 1. 클래스 등록
			Class.forName(driverClass);
			
			// 2. Connection 생성
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
			// 3. PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			
			// 4. 실행
			result = pstmt.executeUpdate();
			
			// 5. 트랜잭션 처리
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 반납
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return result;
	}

	/**
	 * 사용자로부터 입력받은 아이디 정보의 생일 변경
	 * @param id
	 * @param birth
	 * @return
	 */
	public int updateBirth(String id, Date birth) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set birthday = ? where id = ?";
		int result = 0;
		
		try {
			// 1. 클래스 등록
			Class.forName(driverClass);
			
			// 2. Connection 생성
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
			// 3. PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, birth);
			pstmt.setString(2, id);
			
			// 4. 실행
			result = pstmt.executeUpdate();
			
			// 5. 트랜잭션 처리
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 반납
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 사용자로부터 입력받은 아이디 정보의 이메일 변경
	 * @param id
	 * @param email
	 * @return
	 */
	public int updateEmail(String id, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set email = ? where id = ?";
		int result = 0;
		
		try {
			// 1. 클래스 등록
			Class.forName(driverClass);
			
			// 2. Connection 생성
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
			// 3. PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, id);
			
			// 4. 실행
			result = pstmt.executeUpdate();
			
			// 5. 트랜잭션 처리
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 반납
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return result;
	}
}