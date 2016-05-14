
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
	
	public Object checkLogin()
	{
		//call db model.
		String dbID="darkzero";
		String dbPw = "1";
		int dbType=1;
		
		if(dbID.equals(this.loginID)&&dbPw.equals(this.loginPassword)&& userType == dbType)
		{
			ProgramSession.getInstance(this.loginID,this.loginPassword,userType);//Session Start

			if(userType==1)
				return new HomeView(); // Main Form to show after the Login Form.;
			else if(userType==2)
				return new HomeView_audience();
			else
				return null;
			
		}
		else
		{
			return null;
		}
	}
	
	
	
	
}
