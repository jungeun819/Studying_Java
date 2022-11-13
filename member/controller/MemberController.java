package com.sh.member.controller;

import java.sql.Date;
import java.util.List;

import com.sh.member.model.dao.MemberDao;
import com.sh.member.model.dto.Member;

public class MemberController {
	private MemberDao dao = new MemberDao();

	public int insertMember(Member member) {
		int result = dao.insertMember(member);
		return result;
	}

	public List<Member> findAll() {
		List<Member> members = dao.findAll();
		return members;
	}

	public Member findById(String id) {
		Member member = dao.findById(id);
		return member;
	}

	public List<Member> findByName(String name) {
		List<Member> members = dao.findByName(name);
		return members;
	}

	public int deleteMember(String id) {
		int result = dao.deleteMember(id);
		return result;
	}

	public int updateName(String id, String name) {
		int result = dao.updateName(id, name);
		return result;
	}

	public int updateBirth(String id,Date birth) {
		int result = dao.updateBirth(id, birth);
		return result;
	}

	public int updateEmail(String id, String email) {
		int result = dao.updateEmail(id, email);
		return result;
	}
}
