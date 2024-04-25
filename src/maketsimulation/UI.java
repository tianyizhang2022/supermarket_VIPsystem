package maketsimulation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JFrameDemo1.java
import javax.swing.*;

public class UI {
	LoginClient1 client;
	JTextArea show_reply = new JTextArea(); 
	public UI(LoginClient1 c) {
		client = c;
	}
	
	public void UI0() {
		JFrame f = new JFrame("market simulation");
		//JPanel p0=new JPanel();
		JPanel p1=new JPanel();    //面板1
		JPanel p2=new JPanel();    //面板2
		JLabel L1 = new JLabel("market simulation client"); 
		/*设置窗体左上角与显示屏左上角的坐标，
离显示屏上边缘300像素，离显示屏左边缘300像素   */
		JButton b1 = new JButton("Log in");
		JButton b2 = new JButton("register");
		
		b1.addActionListener(new ActionListener() {//添加按钮事件监听		

			public void actionPerformed(ActionEvent e) {
				JFrame f0 = new JFrame("log in");//登录界面
				UI1(f0);
			};
		});
		b2.addActionListener(new ActionListener() {//添加按钮事件监听		

			public void actionPerformed(ActionEvent e) {
				JFrame f1 = new JFrame("register");
				UI2(f1);
			};
		});
		

		p1.add(L1);
		p2.add(b1);
	    p2.add(b2);
	    
	    p1.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
	    p2.setLayout(new FlowLayout(FlowLayout.CENTER,40,20));
	    f.setLayout(new BorderLayout());
	    f.add(p1,BorderLayout.NORTH);
	    f.add(p2,BorderLayout.CENTER);
	    //f.add(p0);
        f.setLocation(200, 200);
		//f.setLocationRelativeTo(null);本语句实现窗口居屏幕中央
		f.setSize(400,300);
		//设置窗体的大小为300*200像素大小
		f.setResizable(false);
		//设置窗体是否可以调整大小，参数为布尔值
		//设置窗体可见，没有该语句，窗体将不可见，此语句必须有，否则没有界面就没有如何意义了
		f.setVisible( true);
		//用户单击窗口的关闭按钮时程序执行的操作
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

	}
	
	public void UI1(JFrame f1) {//登录界面
		//JPanel p0=new JPanel();
		JPanel p0=new JPanel();
		JPanel p1=new JPanel();    //面板1
		JPanel p2=new JPanel();    //面板2
		JPanel p3=new JPanel();    //面板3
		JLabel L11 = new JLabel("please input ID"); 
		JLabel L12 = new JLabel("please input password");
		JButton b1 = new JButton("Log in");
		JTextField Textfield = new JTextField(10);
		JPasswordField pass = new JPasswordField(10);
		p1.add(L11);
	    p1.add(Textfield);
	    
	    p2.add(L12);
        p2.add(pass);
        p3.add(b1);
        b1.addActionListener(new ActionListener() {//添加按钮事件监听		

			public void actionPerformed(ActionEvent e) {
				
				String user = Textfield.getText();
				int username = Integer.parseInt(user);
				String pwd;
				pwd = new String(pass.getPassword());
				System.out.println("191"+pwd);
				member m1 = new member(username,pwd);
				client.ObjecttoServer(m1,2);
			};
		});
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
	    p2.setLayout(new FlowLayout(FlowLayout.CENTER,40,20));
	    p3.setLayout(new FlowLayout(FlowLayout.CENTER,40,20));
	    
	    p0.add(p1);
	    p0.add(p2);
	    p0.add(p3);
	    f1.add(p0);
	    f1.setLocation(200, 200);
		//f.setLocationRelativeTo(null);本语句实现窗口居屏幕中央
	    f1.setSize(400,300);
		//设置窗体的大小为300*200像素大小
	    f1.setResizable(true);
		//设置窗体是否可以调整大小，参数为布尔值
		//设置窗体可见，没有该语句，窗体将不可见，此语句必须有，否则没有界面就没有如何意义了
	    f1.setVisible(true);
		//用户单击窗口的关闭按钮时程序执行的操作
	    f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
		
	}
	
	public void UI2(JFrame f1) {//注册界面
		
		//JPanel p0=new JPanel();
		JPanel p0=new JPanel();
		JPanel p1=new JPanel();    //面板1
		JPanel p2=new JPanel();    //面板2
		JPanel p3=new JPanel();    //面板3
		JLabel L11 = new JLabel("please input ID"); 
		JLabel L12 = new JLabel("please input password");
		JTextField Textfield = new JTextField(10);
		JPasswordField pass = new JPasswordField(10);
		
		JButton b1 = new JButton("register");
		p1.add(L11);
	    p1.add(Textfield);
	    
	    p2.add(L12);
        p2.add(pass);
        p3.add(b1);
        b1.addActionListener(new ActionListener() {//添加按钮事件监听，注册		

			public void actionPerformed(ActionEvent e) {
				String user = Textfield.getText();
				int username = Integer.parseInt(user);
				String pwd;
				pwd = new String(pass.getPassword());
				
				member m1 = new member(username,pwd);
				System.out.println("12345"+m1.getPassword());
				client.ObjecttoServer(m1,1);
				
				
			};
		});
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
	    p2.setLayout(new FlowLayout(FlowLayout.CENTER,40,20));
	    p3.setLayout(new FlowLayout(FlowLayout.CENTER,40,20));
	   
	    p0.add(p1);
	    p0.add(p2);
	    p0.add(p3);
	    f1.add(p0);
		f1.setLocation(200, 200);
			//f.setLocationRelativeTo(null);本语句实现窗口居屏幕中央
		f1.setSize(400,300);
			//设置窗体的大小为300*200像素大小
		f1.setResizable(true);
			//设置窗体是否可以调整大小，参数为布尔值
			//设置窗体可见，没有该语句，窗体将不可见，此语句必须有，否则没有界面就没有如何意义了
		f1.setVisible(true);
			//用户单击窗口的关闭按钮时程序执行的操作
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
	}
	
	public void UI3(JFrame f1,String reply) {//登录后的用户界面
		
		
		//JPanel p0=new JPanel();
		JPanel p0=new JPanel();
		JPanel p1=new JPanel();    //面板1
		JPanel p2=new JPanel();    //面板2
		JPanel p3=new JPanel();    //面板3
		JPanel p4=new JPanel();    //面板4
		JButton b1 = new JButton("change password");
		JPasswordField pass = new JPasswordField(10);	
		
		JButton b2 = new JButton("plus points");
		JButton b22 = new JButton("minus points");
		JTextField pointtext = new JTextField(10);
		JLabel L11 = new JLabel("  "); 
		JButton b3 = new JButton("inquire points");
		
		show_reply.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(show_reply);
		p1.add(b1);
	    p1.add(pass);
        p1.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
        
        p2.add(b2);
        p2.add(b22);
        p2.add(pointtext);
        p2.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
        p3.add(b3);
        p3.add(L11);
        p4.add(scrollPane);
        p0.add(p1);
        p0.add(p2);
        p0.add(p3);
        p0.add(p4);
        p0.setLayout(new BoxLayout(p0, BoxLayout.Y_AXIS));
        f1.add(p0);
        
    
		b1.addActionListener(new ActionListener() {//添加按钮事件监听，修改密码		

			public void actionPerformed(ActionEvent e) {
				String pwd = "";
				pwd = new String(pass.getPassword());
				if (pwd.length()>=6)
				{
					client.ObjecttoServer(pwd);
				}else {
					show_reply.setText("");
					show_reply.append("the password must bigger than 6");
				}
				
			};
		});
		
		b2.addActionListener(new ActionListener() {//添加按钮事件监听	增加积分	

			public void actionPerformed(ActionEvent e) {
				String points = pointtext.getText();
				int p = Integer.parseInt(points);
				client.ObjecttoServer(p);
			};
		});
		
		b22.addActionListener(new ActionListener() {//添加按钮事件监听	减少积分	

			public void actionPerformed(ActionEvent e) {
				String points = pointtext.getText();
				int p = Integer.parseInt(points);
				int p1 =0-p; 
				System.out.println("p1 is");
				System.out.println(p1);
				client.ObjecttoServer(p1);
				
			};
		});
		
		 ActionListener listener = new ActionListener() {
	         
	         public void actionPerformed(ActionEvent e) {
	        	    client.ObjecttoServer();
					
	     };	
	};
		b3.addActionListener(listener);
		f1.setLocation(200, 200);
		
		f1.setSize(400,600);
	
		f1.setResizable(true);
		
		f1.setVisible(true);
		//用户单击窗口的关闭按钮时程序执行的操作
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
	}
	
	


	 public void updateDisplay(int point) {
		    String String_point = String.valueOf(point);
	        // 清空展示框的文本内容并更新为新的文本内容
		    show_reply.setText("");
			show_reply.append(String_point);
	        }
	 public void updateDisplay(String reply) {
		    
		    show_reply.setText("");
			show_reply.append(reply);
	        }
}