/*
* 홈페이지에서 (Audience가) '예매내역' 접속 시 뜨는 예매내역 페이지.
 */

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OrderView extends JFrame //implements ActionListener
{
    Container contentPane;
    String [] header = {"공연", "날짜"};
    Object[][] data =               // SAMPLE입니다!!
            {
                    {"공연", "날짜"},
                    {"곡성", "5/23"},
                    {"하이루", "1/2"},
                    {"즉새우", "2/3"},
            };

    OrderView()
    {
        contentPane=this.getContentPane();
        JPanel orderpanel = new JPanel();
        setBounds(0,0,350,600);
        this.setVisible(true);
        this.setLayout( null);

        JButton btn1  = new JButton("뒤로가기");
        JLabel label1 = new JLabel("예매 확인");
        DefaultTableModel model = new DefaultTableModel(data, header);

        JTable table = new JTable(model){       // Disable editing table cells.
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };
        Border border = new javax.swing.border.LineBorder(Color.LIGHT_GRAY, 3);
        table.setRowHeight(35);
        table.setBackground(Color.getColor("#E0FFFF"));
        table.setBorder(border);
        table.setBounds(0,50,300,490);
        btn1.setBounds(200,550,100,50);
        label1.setBounds(10, 0, 100, 40);

        label1.setFont(new Font("Gulim", Font.BOLD, 15));
        btn1.setFont(new java.awt.Font("Gulim", 0, 14));
        table.setFont(new java.awt.Font("Gulim", 0, 14));

        orderpanel.add(label1);
        orderpanel.add(btn1);
        orderpanel.add(table);
        btn1.addActionListener(new ActionListener()  // 닫기 -> 홈페이지로
        {
            public void actionPerformed(ActionEvent e) {
                new HomeView_audience().setVisible(true); // Main Form to show after the Login Form.
                dispose();
            }
        });



        // frame setting
        orderpanel.setVisible(true);
        orderpanel.setLayout(null);
        setSize(350,600);
        this.setContentPane(orderpanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String arr[])
    {
        new OrderView();
    }



}