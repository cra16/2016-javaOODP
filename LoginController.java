
public class LoginController {
	
	
	private String loginID;
	private String loginPassword;
	private int userType;
	private boolean checking;
	
	
	public LoginController(String loginid, String pw,int userType)
	{
		
		this.loginID=loginid;
		this.loginPassword = pw;
		this.userType = userType;
		
		
	}
	
	public void checkLogin()
	{
		//call db model.
		DBHelper helper = DBHelper.getInstance(this.loginID,this.loginPassword,userType);
		if((userType == 1)&&(helper.isUser_validator())){
			new HomeView_audience();
		}else if((userType == 2)&&(helper.isUser_validator())){
			new HomeView();
		}else{
			System.out.println("로그인 실패");
		}
	}
	
	
	
	
}
