//현황

package frogM;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Scrollbar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import DBtest.MemberBean;

public class Tab4 extends JPanel {
	
	static DBConnectionMgr pool;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
	JLabel text_monday, text_sunday,wave;
	JPanel p1,p2,p3;
	Scrollbar bar;
	Button yearBtn1,yearBtn2,monthBtn1,monthBtn2,weekBtn1,weekBtn2;
	
	public Tab4() {
		
		//날짜 생성  및선택 부분-----------------------------------------------------------------------------------------------------------------
		
		
		createColum();
		createTable();
		selectDate();
		setLayout(null);		
		setBackground(new Color(255,255,255,0));
		setOpaque(false);
		revalidate();
		repaint();
		setVisible(false); //이거 남겨놔주세요
	
	}
	//표 칼럼 생성부분----------------------------------------------------------------------------------------------------------------
			//x시작 좌표 구하는 식 (getWidth()-(l18.getX() + l18.getWidth()-l1.getX()))/2
			public void createColum() {
				p1 = new newPanel(null, 170, 150, 960, 400);		
				l1 = new newLabel("이름",0,0,100,50,13,Color.black,"");
				l2 = new newLabel("직급",l1.getX() + l1.getWidth(),0,100,50,13,Color.black,"");
				l3 = new newLabel("시급",l2.getX() + l2.getWidth(),0,100,50,13,Color.black,"");
				l4 = new newLabel("근무일수",l3.getX() + l3.getWidth(),0,100,25,13,Color.black,"");
				l5 = new newLabel("희망",l3.getX() + l3.getWidth(),25,50,25,13,Color.black,"");
				l6 = new newLabel("실제",l5.getX() + l5.getWidth(),25,50,25,13,Color.black,"");
				l7 = new newLabel("실제근무시간",l6.getX() + l6.getWidth(),0,310,25,13,Color.black,"");
				l8 = new newLabel("월",l6.getX() + l6.getWidth(),25,30,25,13,Color.black,"");
				l9 = new newLabel("화",l8.getX() + l8.getWidth(),25,30,25,13,Color.black,"");
				l10 = new newLabel("수",l9.getX() + l9.getWidth(),25,30,25,13,Color.black,"");
				l11 = new newLabel("목",l10.getX() + l10.getWidth(),25,30,25,13,Color.black,"");
				l12 = new newLabel("금",l11.getX() + l11.getWidth(),25,30,25,13,Color.black,"");
				l13 = new newLabel("토",l12.getX() + l12.getWidth(),25,30,25,13,Color.black,"");
				l14 = new newLabel("일",l13.getX() + l13.getWidth(),25,30,25,13,Color.black,"");
				l15 = new newLabel("주 계",l14.getX() + l14.getWidth(),25,50,25,13,Color.black,"");
				l16 = new newLabel("월 계",l15.getX() + l15.getWidth(),25,50,25,13,Color.black,"");
				l17 = new newLabel("예상 월급",l16.getX() + l16.getWidth(),0,100,50,13,Color.black,"");
				l18 = new newLabel("보건증 만료일",l17.getX() + l17.getWidth(),0,150,50,13,Color.black,"");
				
				p1.setBorder(new LineBorder(Color.black,1));
				
				l1.setHorizontalAlignment(JLabel.CENTER);
				l1.setBorder(new LineBorder(Color.black,1));
				l2.setHorizontalAlignment(JLabel.CENTER);
				l2.setBorder(new LineBorder(Color.black,1));
				l3.setHorizontalAlignment(JLabel.CENTER);
				l3.setBorder(new LineBorder(Color.black,1));
				l4.setHorizontalAlignment(JLabel.CENTER);
				l4.setBorder(new LineBorder(Color.black,1));
				l5.setHorizontalAlignment(JLabel.CENTER);
				l5.setBorder(new LineBorder(Color.black,1));
				l6.setHorizontalAlignment(JLabel.CENTER);
				l6.setBorder(new LineBorder(Color.black,1));
				l7.setHorizontalAlignment(JLabel.CENTER);
				l7.setBorder(new LineBorder(Color.black,1));
				l8.setHorizontalAlignment(JLabel.CENTER);
				l8.setBorder(new LineBorder(Color.black,1));
				l9.setHorizontalAlignment(JLabel.CENTER);
				l9.setBorder(new LineBorder(Color.black,1));
				l10.setHorizontalAlignment(JLabel.CENTER);
				l10.setBorder(new LineBorder(Color.black,1));
				l11.setHorizontalAlignment(JLabel.CENTER);
				l11.setBorder(new LineBorder(Color.black,1));
				l12.setHorizontalAlignment(JLabel.CENTER);
				l12.setBorder(new LineBorder(Color.black,1));
				l13.setHorizontalAlignment(JLabel.CENTER);
				l13.setBorder(new LineBorder(Color.black,1));
				l14.setHorizontalAlignment(JLabel.CENTER);
				l14.setBorder(new LineBorder(Color.black,1));
				l15.setHorizontalAlignment(JLabel.CENTER);
				l15.setBorder(new LineBorder(Color.black,1));
				l16.setHorizontalAlignment(JLabel.CENTER);
				l16.setBorder(new LineBorder(Color.black,1));
				l17.setHorizontalAlignment(JLabel.CENTER);
				l17.setBorder(new LineBorder(Color.black,1));
				l18.setHorizontalAlignment(JLabel.CENTER);
				l18.setBorder(new LineBorder(Color.black,1));
				
				p1.add(l1);
				p1.add(l2);
				p1.add(l3);
				p1.add(l4);
				p1.add(l5);
				p1.add(l6);
				p1.add(l7);
				p1.add(l8);
				p1.add(l9);
				p1.add(l10);
				p1.add(l11);
				p1.add(l12);
				p1.add(l13);
				p1.add(l14);
				p1.add(l15);
				p1.add(l16);
				p1.add(l17);
				p1.add(l18);
				
				validate();
				
			}
		
	
		
		//테이블 생성부분-------------------------------------------------------------------------------------------------------------------
public void createTable() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		pool = DBConnectionMgr.getInstance();
		int y = 50;
		int j = 0;
		int arrLength = 0;
		String columnNames[] = {"이름","직급","시급","희망","실제"
				,"월","화","수","목","금","토","일","주 계","월 계"
				,"예상 월급","보건증 만료일"};
		JScrollPane jscroll ;
//		JFrame f1 = new JFrame();
		JPanel p2 = new newPanel(null, 170,200, 960, 400);
//		JPanel p1 = new JPanel();
		

		try {
			con = pool.getConnection();
			sql =  "select * from KHG1894.\"member\" "; // 쿼리문 삽입 공간
			pstmt = con.prepareStatement(sql);// 쿼리문에 넣을 명령문을 가져옴
			rs = pstmt.executeQuery();// 실행한 결과를 에 저장한다.
			
			while (rs.next()) {
				arrLength++;
			}
			String rowData[][] = new String[arrLength][16];
			rs = pstmt.executeQuery();// 실행한 결과를 에 저장한다.
			while (rs.next()) {
				MemberBean bean = new MemberBean();				
				rowData[j][0] = rs.getString("id");
				rowData[j][1] = rs.getString("pw");
				rowData[j][2] = rs.getString("phone_no");
				rowData[j][3] = rs.getString("name");
				j++;
				
			}
		
			JTable jt = new JTable(rowData, columnNames);
			jscroll = new JScrollPane(jt);
			
			
			jt.getColumnModel().getColumn(0).setMaxWidth(100);
	        jt.getColumnModel().getColumn(0).setMinWidth(100);
	        jt.getColumnModel().getColumn(0).setWidth(100);
			jt.getColumnModel().getColumn(1).setMaxWidth(100);
	        jt.getColumnModel().getColumn(1).setMinWidth(100);
	        jt.getColumnModel().getColumn(1).setWidth(100);
			jt.getColumnModel().getColumn(2).setMaxWidth(100);
	        jt.getColumnModel().getColumn(2).setMinWidth(100);
	        jt.getColumnModel().getColumn(2).setWidth(100);
			jt.getColumnModel().getColumn(3).setMaxWidth(50);
	        jt.getColumnModel().getColumn(3).setMinWidth(50);
	        jt.getColumnModel().getColumn(3).setWidth(50);
			jt.getColumnModel().getColumn(4).setMaxWidth(50);
	        jt.getColumnModel().getColumn(4).setMinWidth(50);
	        jt.getColumnModel().getColumn(4).setWidth(50);
			jt.getColumnModel().getColumn(5).setMaxWidth(30);
	        jt.getColumnModel().getColumn(5).setMinWidth(30);
	        jt.getColumnModel().getColumn(5).setWidth(30);
			jt.getColumnModel().getColumn(6).setMaxWidth(30);
	        jt.getColumnModel().getColumn(6).setMinWidth(30);
	        jt.getColumnModel().getColumn(6).setWidth(30);
			jt.getColumnModel().getColumn(7).setMaxWidth(30);
	        jt.getColumnModel().getColumn(7).setMinWidth(30);
	        jt.getColumnModel().getColumn(7).setWidth(30);
			jt.getColumnModel().getColumn(8).setMaxWidth(30);
	        jt.getColumnModel().getColumn(8).setMinWidth(30);
	        jt.getColumnModel().getColumn(8).setWidth(30);
			jt.getColumnModel().getColumn(9).setMaxWidth(30);
	        jt.getColumnModel().getColumn(9).setMinWidth(30);
	        jt.getColumnModel().getColumn(9).setWidth(30);
			jt.getColumnModel().getColumn(10).setMaxWidth(30);
	        jt.getColumnModel().getColumn(10).setMinWidth(30);
	        jt.getColumnModel().getColumn(10).setWidth(30);
			jt.getColumnModel().getColumn(11).setMaxWidth(30);
	        jt.getColumnModel().getColumn(11).setMinWidth(30);
	        jt.getColumnModel().getColumn(11).setWidth(30);
			jt.getColumnModel().getColumn(12).setMaxWidth(50);
	        jt.getColumnModel().getColumn(12).setMinWidth(50);
	        jt.getColumnModel().getColumn(12).setWidth(50);
			jt.getColumnModel().getColumn(13).setMaxWidth(50);
	        jt.getColumnModel().getColumn(13).setMinWidth(50);
	        jt.getColumnModel().getColumn(13).setWidth(50);
	        jt.getColumnModel().getColumn(14).setMaxWidth(100);
	        jt.getColumnModel().getColumn(14).setMinWidth(100);
	        jt.getColumnModel().getColumn(14).setWidth(100);
	        jt.getColumnModel().getColumn(15).setMaxWidth(150);
	        jt.getColumnModel().getColumn(15).setMinWidth(150);
	        jt.getColumnModel().getColumn(15).setWidth(150);

	        
		
	        add(p1);

			jt.setBounds(0, 0, 960, 400);
			p2.add(jt);
			add(p2);
			setVisible(true);
			p2.setBorder(new LineBorder(Color.black,1));

			validate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}	
public void selectDate() {
	Calendar now = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String monday ,sunday;
		now.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
	monday = df.format(now.getTime()).toString();
	now.add(Calendar.DATE, 6);
	sunday = df.format(now.getTime()).toString();
	System.out.println(monday);
	System.out.println(sunday);
	
	p3 = new newPanel(null, (getWidth()/2) - 200, 75, 400, 50);
	p3.setBorder(new LineBorder(Color.black));
	text_monday = new newLabel(monday, 10, 0, 150, 50, 20, Color.black, null);
	text_sunday = new newLabel(sunday, 290, 0, 150, 50, 20, Color.black, null);
	String part = "~";
	wave = new newLabel(part, 190, 0, 20, 50, 20, Color.black, null);
	p3.add(text_sunday);
	p3.add(text_monday);
	p3.add(wave);
}


}