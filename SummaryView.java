import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eunbee on 2016-05-15.
 * Audience가 예매 내역에서 한 공연을 클릭했을 때 뜨는 View
 */
public class SummaryView extends JFrame {
    Container contentPane;
    String[] datestamp = {"5/2","5/3","5/4"};  // 이 중 하나로 표시되고 disabled 할 것
    String[] timestamp = {"15:00", "16:00", "17:00", "18:00","19:00","20:00","21:00","22:00"} ; // 위와 동일
    OrderView order;
    SummaryView()
    {
        contentPane=this.getContentPane();
        JPanel sumpane = new JPanel();
        setBounds(0,0,350,600);
        this.setVisible(true);
        this.setLayout( null);

        JLabel title = new JLabel("공연 정보");
        JLabel nameLabel = new JLabel("공연 이름 :");
        JLabel providerLabel = new JLabel("주최측 :");
        JLabel placeLabel = new JLabel("장소 :");
        JLabel dateLabel = new JLabel("날짜 :");
        JLabel timeLabel = new JLabel("시간 :");

        JLabel name = new JLabel("SAMPLE_이름"); // Data 채워주세용
        JLabel provider = new JLabel("SAMPLE_주최측");
        JLabel place = new JLabel("SAMPLE_장소");

        JComboBox dateList = new JComboBox(datestamp);  // 날짜 1~7개로 제한하기 : 예) 5/5, 4/5 등
        JComboBox timeList = new JComboBox(timestamp);

        JButton btn1 = new JButton("확인");
        title.setBounds(50, 20, 200, 40);
        nameLabel.setBounds(50,70,100,40);  //공연이름
        providerLabel.setBounds(50,110,100,40); //주최측
        dateLabel.setBounds(50,150,100,40); //날짜
        timeLabel.setBounds(50,190,100,40); //날짜
        placeLabel.setBounds(50,230,100,40); //장소

        name.setBounds(150,70,130,40);
        provider.setBounds(150,110,130,40);
        place.setBounds(150,230,130,40);
        dateList.setBounds(150,150,100,30);
        timeList.setBounds(150,190,100, 30);
        btn1.setBounds(110,420,100,50);
        dateList.setEnabled(false); // disabled. 색은 바꿀 예정
        timeList.setEnabled(false);

        title.setFont(new Font("Gulim", Font.BOLD, 15));
        nameLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        providerLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        placeLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        dateLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        timeLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));

        name.setFont(new java.awt.Font("Gulim", 0, 14));
        provider.setFont(new java.awt.Font("Gulim", 0, 14));
        place.setFont(new java.awt.Font("Gulim", 0, 14));
        dateList.setFont(new java.awt.Font("Gulim", 0, 14));
        timeList.setFont(new java.awt.Font("Gulim", 0, 14));
        btn1.setFont(new java.awt.Font("Gulim", 0, 14));

        sumpane.add(title);
        sumpane.add(name);
        sumpane.add(provider);
        sumpane.add(place);
        sumpane.add(dateList);
        sumpane.add(timeList);
        sumpane.add(nameLabel);
        sumpane.add(providerLabel);
        sumpane.add(placeLabel);
        sumpane.add(dateLabel);
        sumpane.add(timeLabel);
        sumpane.add(btn1);

        btn1.addActionListener(new ActionListener() //예매하기
        {
            public void actionPerformed(ActionEvent e) {
                order=new OrderView();
                dispose();
            }
        });

        // frame setting
        sumpane.setVisible(true);
        sumpane.setLayout(null);
        setSize(350,600);
        this.setContentPane(sumpane);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String arr[])
    {
        new SummaryView();
    }




}
