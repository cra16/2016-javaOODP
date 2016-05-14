import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView_audience extends JFrame //implements ActionListener
{
    Container contentPane;

    HomeView_audience()
    {
        contentPane=this.getContentPane();
        JPanel homepanel = new JPanel();
        setBounds(80,80,700,700);
        this.setVisible(true);
        this.setLayout( null);

        JButton performOrder = new JButton("구매 내역");
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
        performOrder.setBounds(0,450,250,50);

        homepanel.add(performOrder);
        homepanel.add(table);

        performOrder.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                new HomeView_audience().setVisible(true); // Main Form to show after the Login Form.
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
        new HomeView_audience();
    }



}