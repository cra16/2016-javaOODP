import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPerform1_View extends JFrame //implements ActionListener
{
    Container contentPane;
    String[] monthstamp = {"January","February","March","April","May","June","July","August","September","October","November","Desember"};
    String[] placestamp = {"학관 101호", "학관 104호", "채플"};
    String[] daystamp = new String[31];
    String[] periodstamp = new String[7];
    int i = 0;

    AddPerform1_View()
    {
        contentPane=this.getContentPane();
        JPanel add1panel = new JPanel();
        setBounds(0,0,350,600);
        this.setVisible(true);
        this.setLayout( null);

        JLabel title = new JLabel("공연 등록 - [1/2]");
        JLabel label1 = new JLabel("공연 이름 :");
        JLabel label2 = new JLabel("장소 :");
        JLabel label3 = new JLabel("날짜 :");
        JLabel label4 = new JLabel("기간 :");
        JLabel label5 = new JLabel("공연 설명 :");
        JLabel label6 = new JLabel("가격:");

        JTextArea area1 = new JTextArea();  //공연설명
        JTextField field1 = new JTextField(15); //공연이름
        JTextField field2 = new JTextField(15); //가격
        JButton btn1 = new JButton("다음");
        for(i=0;i<31;i++)                       // Dropdown
        {
            daystamp[i] = String.valueOf(i+1);
        }
        for(i=0;i<7;i++)
        {
            periodstamp[i] = String.valueOf(i+1);
        }
        JComboBox monthList = new JComboBox(monthstamp);
        JComboBox dayList = new JComboBox(daystamp);
        JComboBox periodList = new JComboBox(periodstamp);
        JComboBox placeList = new JComboBox(placestamp);

        title.setBounds(30, 20, 200, 40);
        label1.setBounds(30,70,80,40);  //공연이름
        label2.setBounds(30,110,80,40); //장소
        label3.setBounds(30,150,80,40); //날짜
        label4.setBounds(30,190,80,40); //기간
        label6.setBounds(30,230,80,40); //가격
        label5.setBounds(30,270,80,40); //공연 설명
        btn1.setBounds(160,460,70,50);
        field1.setBounds(110,270, 120, 30);
        area1.setBounds(30,310,200,130);
        field2.setBounds(110,70, 120, 30);
        monthList.setBounds(110, 150, 60, 30);
        dayList.setBounds(180,150, 50,30);
        periodList.setBounds(110, 190, 70, 30);
        placeList.setBounds(110,110,120,30);

        title.setFont(new Font("Gulim", Font.BOLD, 15));
        label1.setFont(new java.awt.Font("Gulim", 0, 14));
        label2.setFont(new java.awt.Font("Gulim", 0, 14));
        label3.setFont(new java.awt.Font("Gulim", 0, 14));
        label4.setFont(new java.awt.Font("Gulim", 0, 14));
        label5.setFont(new java.awt.Font("Gulim", 0, 14));
        btn1.setFont(new java.awt.Font("Gulim", 0, 14));
        area1.setFont(new java.awt.Font("Gulim", 0, 14));
        field1.setFont(new java.awt.Font("Gulim", 0, 14));
        field2.setFont(new java.awt.Font("Gulim", 0, 14));
        monthList.setFont(new java.awt.Font("Gulim", 0, 14));
        dayList.setFont(new java.awt.Font("Gulim", 0, 14));
        periodList.setFont(new java.awt.Font("Gulim", 0, 14));
        placeList.setFont(new java.awt.Font("Gulim", 0, 14));

        add1panel.add(title);
        add1panel.add(label1);
        add1panel.add(label2);
        add1panel.add(label3);
        add1panel.add(label4);
        add1panel.add(label5);
        add1panel.add(field1);
        add1panel.add(field2);
        add1panel.add(btn1);
        add1panel.add(area1);
        add1panel.add(monthList);
        add1panel.add(dayList);
        add1panel.add(periodList);
        add1panel.add(placeList);

        btn1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
            	
                new AddPerform2_View(field1.getText(),placeList.getSelectedIndex(),
                		monthList.getSelectedIndex(),dayList.getSelectedIndex(),
                		periodList.getSelectedIndex(),field2.getText(),area1.getText()).setVisible(true); // Main Form to show after the Login Form.
                dispose();
            }
        });

        // frame setting
        add1panel.setVisible(true);
        add1panel.setLayout(null);
        setSize(350,600);
        this.setContentPane(add1panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}