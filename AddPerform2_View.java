import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPerform2_View extends JFrame //implements ActionListener
{
    Container contentPane;
    String[] timestamp = {"15:00", "16:00", "17:00", "18:00","19:00","20:00","21:00","22:00"} ;

    AddPerform2_View()
    {
        contentPane=this.getContentPane();
        JPanel add1panel = new JPanel();
        setBounds(80,80,250,500);
        this.setVisible(true);
        this.setLayout( null);


        JLabel title = new JLabel("공연 등록 - [2/2]");
        JLabel subtitle = new JLabel("<날짜별 시간 선택>");
        JButton btn1 = new JButton("완료");

        // 선택한 기간에 따라 label 갯수 생성
        JLabel label1 = new JLabel("날짜1 :"); //SAMPLE 1
        JLabel label2 = new JLabel("날짜2 :"); //SAMPLE 2
        JLabel label3 = new JLabel("날짜3 :"); //SAMPLE 3
        JComboBox drop1 = new JComboBox(timestamp);
        JComboBox drop2 = new JComboBox(timestamp);
        JComboBox drop3 = new JComboBox(timestamp);

        title.setBounds(30, 20, 200, 40);
        subtitle.setBounds(30, 70, 170, 40);
        label1.setBounds(30, 110, 70, 40); //SAMPLE 1
        drop1.setBounds(110, 110, 100, 30);
        label2.setBounds(30, 150, 70, 40); //SAMPLE 2
        drop2.setBounds(110, 150, 100, 30);
        label3.setBounds(30, 190, 70, 40); //SAMPLE 3
        drop3.setBounds(110, 190, 100, 30);


        btn1.setBounds(160,420,70,50);
        title.setFont(new Font("Gulim", Font.BOLD, 15));

        add1panel.add(title);
        add1panel.add(subtitle);
        add1panel.add(btn1);
        add1panel.add(label1); //SAMPLE 1
        add1panel.add(drop1);
        add1panel.add(label2); //SAMPLE 2
        add1panel.add(drop2);
        add1panel.add(label3); //SAMPLE 3
        add1panel.add(drop3);

        btn1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                // 제출 처리 해주세요
            }
        });

        // frame setting
        add1panel.setVisible(true);
        add1panel.setLayout(null);
        setSize(250,500);
        this.setContentPane(add1panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}