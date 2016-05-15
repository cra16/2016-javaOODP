
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
	
		
			DBHelper.getInstance(this.loginID,this.loginPassword,userType);
			if(userType==1)
			{
				new HomeView_audience();
			}
			else if(userType==2)
			{
				new HomeView();
			}
			
		
	}
	
	
	
	
}
