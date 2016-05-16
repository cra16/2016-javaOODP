/*
Audience가 홈페이지에서 공연예매를 위해 원하는 공연을 클릭했을 때 display해주는 view
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class BuyTicketView extends JFrame //implements ActionListener
{
    Container contentPane;
    DBHelper dBHelper = DBHelper.getInstance();
    Performance perform;

    BuyTicketView(Performance perform)
    {
    	this.perform = perform;
    	
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
        
        JLabel name = new JLabel(perform.getName()); // Data 채워주세용
        JLabel provider = new JLabel(perform.getHost().getName());
        JLabel price = new JLabel(perform.getCost()+"");
        JLabel place = new JLabel(perform.getPlace().getPlaceName());
        JTextArea detail = new JTextArea(perform.getDescription());  // 우선 disabled 상태로 표시될 것.
        detail.setEditable(false);   // disabled
        
        
        String[] splitString =perform.getSchedule().getFirstDay().toString().split("-");
        String mergeString="";
        String[] userDateStamp = new String[perform.getSchedule().getDuration()];
        for(int i=1; i<splitString.length;i++)
        {
        	mergeString+=splitString[i];
        	if(i<splitString.length-1)
        	{
        		mergeString+="/";
        	}
        	
        }
        for(int i=0; i<userDateStamp.length; i++)
        {
        	if(i==0)
        		userDateStamp[i]=mergeString;
        	else
        	{
        		int changeday=Integer.parseInt(splitString[splitString.length-1])+i; //아직 예외처리 안만듬
        		
        		mergeString = splitString[1]+"/" ;
        		if(changeday<10)
        		{
        			mergeString += "0"+changeday;
                	
        		}
        		else
        		mergeString +=changeday;
            	
        		userDateStamp[i]=mergeString;
        	}
        }
        
        int count=0;
        while(perform.getSchedule().getTime()[count] != null){
        	count++;
        }
        String[] userTimeStamp = new String[count];
        for(int i=0;i<count;i++){
        	splitString = perform.getSchedule().getTime()[i].toString().split(":");
        	mergeString = splitString[0]+":"+splitString[1];
        	userDateStamp[i] += " -- "+mergeString;
        }
                
        JComboBox dateList = new JComboBox(userDateStamp);  // 날짜 1~7개로 제한하기 : 예) 5/5, 4/5 등
        
        JButton btn1 = new JButton("예매하기");
        JButton btn2 = new JButton("뒤로가기");

        title.setBounds(50, 20, 200, 40);
        nameLabel.setBounds(50,70,100,40);  //공연이름
        providerLabel.setBounds(50,110,100,40); //주최측
        dateLabel.setBounds(50,150,100,40); //날짜 및 시간
        placeLabel.setBounds(50,190,100,40); //장소
        priceLabel.setBounds(50,230,100,40); //가격
        detailLabel.setBounds(50,270,100,40); //공연 설명

        name.setBounds(150,70,130,40);
        provider.setBounds(150,110,130,40);
        place.setBounds(150,190,130,40);
        price.setBounds(150,230,130,40);
        dateList.setBounds(150,155,140,30);
        btn1.setBounds(110,470,100,50);
        btn2.setBounds(230,470,100,50);
        detail.setBounds(50,310,270,130);

        title.setFont(new Font("Gulim", Font.BOLD, 15));
        nameLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        providerLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        placeLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        priceLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        dateLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));
        detailLabel.setFont(new java.awt.Font("Gulim", Font.BOLD, 14));

        name.setFont(new java.awt.Font("Gulim", 0, 14));
        provider.setFont(new java.awt.Font("Gulim", 0, 14));
        place.setFont(new java.awt.Font("Gulim", 0, 14));
        price.setFont(new java.awt.Font("Gulim", 0, 14));
        dateList.setFont(new java.awt.Font("Gulim", 0, 14));
        detail.setFont(new java.awt.Font("Gulim", 0, 14));
        btn1.setFont(new java.awt.Font("Gulim", 0, 14));
        btn2.setFont(new java.awt.Font("Gulim", 0, 14));

        buypanel.add(title);
        buypanel.add(name);
        buypanel.add(provider);
        buypanel.add(place);
        buypanel.add(price);
        buypanel.add(dateList);
        buypanel.add(detail);
        buypanel.add(detailLabel);
        buypanel.add(nameLabel);
        buypanel.add(providerLabel);
        buypanel.add(placeLabel);
        buypanel.add(priceLabel);
        buypanel.add(dateLabel);
        buypanel.add(btn1);
        buypanel.add(btn2);

        btn1.addActionListener(new ActionListener() //예매하기
        {
            public void actionPerformed(ActionEvent e) {
            	Calendar cal = Calendar.getInstance();
            	cal.setTime(perform.getSchedule().getFirstDay());
            	cal.add(Calendar.DATE, dateList.getSelectedIndex());
            	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            	Date date=null;
            	Time time=perform.getSchedule().getTime()[dateList.getSelectedIndex()];
				try {
					date = new Date(df.parse(df.format(cal.getTime())).getTime());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
            	if(dBHelper.getCurrentNum(perform.getName(), date, time)<perform.getPlace().getMaxSeat()){
            		dBHelper.reserveTicket(perform.getName(), date, time, dBHelper.getAudience().getName());
            	}else {
            		System.out.println("예매 실패");
            	}
            	if(DBHelper.getInstance().getHost()!=null)
            		new HomeView();
            	else if(DBHelper.getInstance().getAudience()!=null)
            		new HomeView_audience();
            	dispose();
            }
        });
        btn2.addActionListener(new ActionListener() //뒤로가기
        {
            public void actionPerformed(ActionEvent e) {
            	if(DBHelper.getInstance().getHost()!=null)
            		new HomeView();
            	else if(DBHelper.getInstance().getAudience()!=null)
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
}