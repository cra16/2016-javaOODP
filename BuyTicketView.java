/*
Audience가 홈페이지에서 공연예매를 위해 원하는 공연을 클릭했을 때 display해주는 view
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BuyTicketView extends JFrame //implements ActionListener
{
    Container contentPane;
    String[] datestamp = {"5/2","5/3","5/4"};
    String[] timestamp = {"15:00", "16:00", "17:00", "18:00","19:00","20:00","21:00","22:00"} ;



    BuyTicketView()
    {
        contentPane=this.getContentPane();
        JPanel buypanel = new JPanel();
        setBounds(0,0,350,600);
        this.setVisible(true);
        this.setLayout( null);

        JLabel title = new JLabel("공연 예매");
        JLabel nameLabel = new JLabel("공연 이름 :");
        JLabel providerLabel = new JLabel("주최측 :");
        JLabel priceLabel = new JLabel("가격 :");
        JLabel placeLabel = new JLabel("장소 :");
        JLabel dateLabel = new JLabel("날짜 :");
        JLabel timeLabel = new JLabel("시간 :");
        JLabel detailLabel = new JLabel("공연 설명 :");

        JLabel name = new JLabel("SAMPLE_이름"); // Data 채워주세용
        JLabel provider = new JLabel("SAMPLE_주최측");
        JLabel price = new JLabel("SAMPLE_가격");
        JLabel place = new JLabel("SAMPLE_장소");
        JTextArea detail = new JTextArea("설명설명설명");  // 우선 disabled 상태로 표시될 것.
        detail.setEditable(false);   // disabled
        JComboBox dateList = new JComboBox(datestamp);  // 날짜 1~7개로 제한하기 : 예) 5/5, 4/5 등
        JComboBox timeList = new JComboBox(timestamp);

        JButton btn1 = new JButton("예매하기");
        JButton btn2 = new JButton("뒤로가기");

        title.setBounds(50, 20, 200, 40);
        nameLabel.setBounds(50,70,100,40);  //공연이름
        providerLabel.setBounds(50,110,100,40); //주최측
        dateLabel.setBounds(50,150,100,40); //날짜
        placeLabel.setBounds(50,230,100,40); //장소
        priceLabel.setBounds(50,270,100,40); //가격
        detailLabel.setBounds(50,310,100,40); //공연 설명

        name.setBounds(150,70,130,40);
        provider.setBounds(150,110,130,40);
        place.setBounds(150,230,130,40);
        price.setBounds(150,270,130,40);
        dateList.setBounds(150,150,100,30);
        timeList.setBounds(150,190,100, 30);
        btn1.setBounds(110,520,100,50);
        btn2.setBounds(230,520,100,50);
        detail.setBounds(50,350,270,130);

        title.setFont(new Font("Gulim", Font.BOLD, 15));
        nameLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        providerLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        placeLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        priceLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        dateLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        timeLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        detailLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));

        name.setFont(new java.awt.Font("Gulim", 0, 14));
        provider.setFont(new java.awt.Font("Gulim", 0, 14));
        place.setFont(new java.awt.Font("Gulim", 0, 14));
        price.setFont(new java.awt.Font("Gulim", 0, 14));
        dateList.setFont(new java.awt.Font("Gulim", 0, 14));
        timeList.setFont(new java.awt.Font("Gulim", 0, 14));
        detail.setFont(new java.awt.Font("Gulim", 0, 14));
        btn1.setFont(new java.awt.Font("Gulim", 0, 14));
        btn2.setFont(new java.awt.Font("Gulim", 0, 14));

        buypanel.add(title);
        buypanel.add(name);
        buypanel.add(provider);
        buypanel.add(place);
        buypanel.add(price);
        buypanel.add(dateList);
        buypanel.add(timeList);
        buypanel.add(detail);
        buypanel.add(detailLabel);
        buypanel.add(nameLabel);
        buypanel.add(providerLabel);
        buypanel.add(placeLabel);
        buypanel.add(priceLabel);
        buypanel.add(dateLabel);
        buypanel.add(timeLabel);
        buypanel.add(btn1);
        buypanel.add(btn2);

        btn1.addActionListener(new ActionListener() //예매하기
        {
            public void actionPerformed(ActionEvent e) {
                // 정보 저장하기
                dispose();
            }
        });
        btn2.addActionListener(new ActionListener() //뒤로가기
        {
            public void actionPerformed(ActionEvent e) {
                new HomeView_audience();
                dispose();
            }
        });


        // frame setting
        buypanel.setVisible(true);
        buypanel.setLayout(null);
        setSize(350,600);
        this.setContentPane(buypanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String arr[])
    {
        new BuyTicketView();
    }

}