import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView extends JFrame //implements ActionListener
{
    Container contentPane;
    LoginController controller;
    
    LoginView()
    {
        contentPane=this.getContentPane();
        JPanel loginpanel = new JPanel();
        setBounds(0,0,350,600);
        this.setVisible(true);
        this.setLayout( null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel label1 = new JLabel("ID : ");
        JLabel label2 = new JLabel("PW : ");
        JTextField text1 = new JTextField(10);
        JPasswordField text2 = new JPasswordField(10);
        JRadioButton checkAudience = new JRadioButton("Audience",false);
        JRadioButton checkHost = new JRadioButton("Host",false);
        ButtonGroup btngroup = new ButtonGroup();

        JButton login = new JButton("로그인");
        btngroup.add(checkAudience);
        btngroup.add(checkHost);

        label1.setBounds(50, 170, 50, 30);
        label2.setBounds(50, 200, 50, 30);
        text1.setBounds(110, 170, 150, 30);
        text2.setBounds(110, 200, 150, 30);
        checkAudience.setBounds(50, 250,90, 30);
        checkHost.setBounds(180, 250,90, 30);
        login.setBounds(100, 280, 80, 30);
        label1.setFont(new java.awt.Font("Gulim", 0, 14));
        label2.setFont(new java.awt.Font("Gulim", 0, 14));
        text1.setFont(new java.awt.Font("Gulim", 0, 14));
        text2.setFont(new java.awt.Font("Gulim", 0, 14));
        checkAudience.setFont(new java.awt.Font("Gulim", 0, 14));
        checkHost.setFont(new java.awt.Font("Gulim", 0, 14));
        login.setFont(new java.awt.Font("Gulim", 0, 14));


        loginpanel.add(label1);
        loginpanel.add(label2);
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
            	controller = new LoginController(text1.getText(),text2.getText(),checknumber);//input user information.

            	controller.checkLogin();
            		dispose();

            }
        });

        // frame setting
        loginpanel.setVisible(true);
        loginpanel.setLayout(null);
        setSize(350,600);
        this.setContentPane(loginpanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String arr[])
    {
      new LoginView();
    }
}