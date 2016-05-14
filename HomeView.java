import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeView extends JFrame //implements ActionListener
{
    Container contentPane;


    HomeView()
    {
        contentPane=this.getContentPane();
        JPanel homepanel = new JPanel();
        setBounds(0,0,250,500);
        this.setVisible(true);
        this.setLayout( null);

        JButton addPerform = new JButton("공연 등록");
        JButton myPerform = new JButton("내 공연");

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] {
                "공연", "날짜"});

        JTable table = new JTable(model);
        model.insertRow(0, new Object[] {"공연", "날짜"});
        for (int count = 1; count < 2; count++){ //SAMPLE
            model.insertRow(count, new Object[] {"곡성", "1/2"});
        }
        table.setRowHeight(1, 30);

        table.setBackground(Color.getColor("#E0FFFF"));
        table.setBounds(0,0,250,450);
        addPerform.setBounds(0,450,125,50);
        myPerform.setBounds(125,450,125,50);

        homepanel.add(table);
        homepanel.add(addPerform);
        homepanel.add(myPerform);

        addPerform.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
                new AddPerform1_View().setVisible(true); // Main Form to show after the Login Form.
                dispose();
            }
        });


        // frame setting
        homepanel.setVisible(true);
        homepanel.setLayout(null);
        setSize(250,500);
        this.setContentPane(homepanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String arr[])
    {
        new HomeView();
    }



}