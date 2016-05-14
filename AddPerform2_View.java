import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPerform2_View extends JFrame //implements ActionListener
{
    Container contentPane;

    AddPerform2_View()
    {
        contentPane=this.getContentPane();
        JPanel add1panel = new JPanel();
        setBounds(80,80,250,500);
        this.setVisible(true);
        this.setLayout( null);

        JLabel label1 = new JLabel("공연 이름 :");
        JLabel label2 = new JLabel("장소 :");
        JLabel label3 = new JLabel("날짜 :");
        JLabel label4 = new JLabel("기간 :");
        JLabel label5 = new JLabel("공연 설명 :");

        JTextArea area1 = new JTextArea();  //공연설명
        JTextField field1 = new JTextField(15); //공연이름
        JButton btn1 = new JButton("다음");

        label1.setBounds(30,70,80,40);
        label2.setBounds(30,110,80,40);
        label3.setBounds(30,150,80,40);
        label4.setBounds(30,190,80,40);
        label5.setBounds(30,230,80,40);
        field1.setBounds(110,70, 120, 40);
        btn1.setBounds(160,420,70,50);

        add1panel.add(label1);
        add1panel.add(label2);
        add1panel.add(label3);
        add1panel.add(label4);
        add1panel.add(label5);
        add1panel.add(field1);
        add1panel.add(btn1);

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


    public static void main(String arr[])

    {
        new AddPerform2_View();
    }



}