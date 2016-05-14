import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView extends JFrame //implements ActionListener
{
    Container contentPane;

    LoginView()
    {
        contentPane=this.getContentPane();
        JPanel loginpanel = new JPanel();
        setBounds(0,0,250,500);
        this.setVisible(true);
        this.setLayout( null);

        JLabel label1 = new JLabel("ID");
        JLabel label2 = new JLabel("Password");
        JTextField text1 = new JTextField(10);
        JPasswordField text2 = new JPasswordField(10);
        JRadioButton checkAudience = new JRadioButton("Audience",false);
        JRadioButton checkHost = new JRadioButton("Host",false);
        ButtonGroup btngroup = new ButtonGroup();
        JButton login = new JButton("Login");
        btngroup.add(checkAudience);
        btngroup.add(checkHost);

        label1.setBounds(50, 170, 50, 30);
        label2.setBounds(50, 200, 50, 30);
        text1.setBounds(110, 170, 150, 30);
        text2.setBounds(110, 200, 150, 30);
        checkAudience.setBounds(80, 250,60, 30);
        checkHost.setBounds(180, 250, 60, 30);
        login.setBounds(130, 280, 60, 30);

        loginpanel.add(label1);
        loginpanel. add(label2);
        loginpanel.add(text1);
        loginpanel.add(text2);
        loginpanel.add(checkAudience);
        loginpanel.add(checkHost);
        loginpanel.add(login);

        login.addActionListener(new ActionListener()
        {
        	
            public void actionPerformed(ActionEvent e) {
            	int checknumber;
            	if(checkAudience.isSelected())
            		checknumber=1;
            	else if(checkHost.isSelected())
            		checknumber=2;
            	else
            		checknumber=0;
            	LoginController controller = new LoginController(text1.getText(),text2.getText(),checknumber);//input user information.
            	System.out.println();
            	if(controller.checkLogin()!=null)
            		dispose();
            }
        });

        // frame setting
        loginpanel.setVisible(true);
        loginpanel.setLayout(null);
        setSize(250,500);
        this.setContentPane(loginpanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


 


    public static void main(String arr[])
    {
        new LoginView();
    }



}