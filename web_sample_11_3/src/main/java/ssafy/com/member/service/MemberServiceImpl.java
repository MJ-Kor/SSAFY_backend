package ssafy.com.member.service;

import ssafy.com.member.model.MemberDto;
import ssafy.com.member.model.dao.MemberDao;
import ssafy.com.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	private static MemberService memberService = new MemberServiceImpl();
	private MemberDao memberDao;
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}
	public static MemberService getMemberService() {
		return memberService;
	}
	
	@Override
	public MemberDto login(String user_id, String user_password) throws Exception {
		return memberDao.login(user_id, user_password);
	}
	
}
