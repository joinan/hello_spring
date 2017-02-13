package spring;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService registerService;
	private ChangePasswordService passwordService;
	
	public Assembler(){
		memberDao = new MemberDao();
		registerService = new MemberRegisterService(memberDao);
		passwordService = new ChangePasswordService(memberDao);
	}
	
	public MemberDao getmemberDao(){
		return this.memberDao;
	}
	
	public MemberRegisterService getMemberRegisterService(){
		return this.registerService;
	}
	
	public ChangePasswordService getChangePasswordService(){
		return this.passwordService;
	}
}
