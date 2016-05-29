import java.util.ArrayList;

public class LoginController{
	GreenBackgroundDecorator host;
	OrangeBackgroundDecorator audience;
	private String loginID;
	private String loginPassword;
	private int userType;
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
			audience = new OrangeBackgroundDecorator(new HomeView_audience());
		}else if((userType == 2)&&(helper.isUser_validator())){
			host = new GreenBackgroundDecorator(new HomeView_host());
		}else{
			System.out.println("로그인 실패");
		}
	}
}
