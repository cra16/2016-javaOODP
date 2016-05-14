import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyPerformView extends JFrame {

    Container contentPane;
    String [] header = {"공연", "날짜"};
    Object[][] data =               // SAMPLE입니다!!
            {
                    {"공연", "날짜"},
                    {"곡성", "5/23"},
                    {"하이루", "1/2"},
                    {"즉새두", "2/3"},
            };


    MyPerformView(){

        contentPane=this.getContentPane();
        setBounds(0,0,700,700);
        this.setVisible(true);
        this.setLayout( null);

        JPanel mypanel = new JPanel();
        JButton updateBtn = new JButton("수정");
        JButton delBtn = new JButton("삭제");
        JLabel label1 = new JLabel("곡성");



        JPanel performpanel = new JPanel(); // SAMPLE
        FlowLayout fl = new FlowLayout(3,50,5);
        performpanel.setLayout(fl);
        performpanel.add(label1);           // mypanel 하나에 공연/삭제버튼/수정버튼 포함.
        performpanel.add(updateBtn);
        performpanel.add(delBtn);
        delBtn.setHorizontalAlignment(SwingConstants.CENTER);

        delBtn.setFont(new java.awt.Font("Gulim", 0, 14));
        updateBtn.setFont(new java.awt.Font("Gulim", 0, 14));
        label1.setFont(new java.awt.Font("Gulim", 0, 14));

        delBtn.setBounds(0,100,100,40);
        updateBtn.setBounds(0,0,100,40);
        label1.setBounds(0,0,150,40);

        updateBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                new UpdatePerform1_View().setVisible(true); // Main Form to show after the Login Form.
                dispose();
            }
        });



        mypanel.add(performpanel);





        // frame setting
        mypanel.setVisible(true);
        mypanel.setLayout(null);
        setSize(350,600);

        this.setContentPane(performpanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        new MyPerformView();
    }

}
