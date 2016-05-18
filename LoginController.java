import java.util.ArrayList;

public class LoginController {
		
	private String loginID;
	private String loginPassword;
	private int userType;
	private HomeView_audience newAudience;
	private HomeView_host newHost;
	public LoginController(String loginid, String pw,int userType){
		this.loginID=loginid;
		this.loginPassword = pw;
		this.userType = userType;
	}
	
	public void checkLogin()
	{
		//call db model.
		DBHelper helper = DBHelper.getInstance(this.loginID,this.loginPassword,userType);
		if((userType == 1)&&(helper.isUser_validator())){
			newAudience = new HomeView_audience();
		}else if((userType == 2)&&(helper.isUser_validator())){
			newHost = new HomeView_host();
		}else{
			System.out.println("로그인 실패");
		}
	}
}
