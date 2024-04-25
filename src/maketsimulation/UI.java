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
		JPanel p1=new JPanel();    //���1
		JPanel p2=new JPanel();    //���2
		JLabel L1 = new JLabel("market simulation client"); 
		/*���ô������Ͻ�����ʾ�����Ͻǵ����꣬
����ʾ���ϱ�Ե300���أ�����ʾ�����Ե300����   */
		JButton b1 = new JButton("Log in");
		JButton b2 = new JButton("register");
		
		b1.addActionListener(new ActionListener() {//��Ӱ�ť�¼�����		

			public void actionPerformed(ActionEvent e) {
				JFrame f0 = new JFrame("log in");//��¼����
				UI1(f0);
			};
		});
		b2.addActionListener(new ActionListener() {//��Ӱ�ť�¼�����		

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
		//f.setLocationRelativeTo(null);�����ʵ�ִ��ھ���Ļ����
		f.setSize(400,300);
		//���ô���Ĵ�СΪ300*200���ش�С
		f.setResizable(false);
		//���ô����Ƿ���Ե�����С������Ϊ����ֵ
		//���ô���ɼ���û�и���䣬���彫���ɼ������������У�����û�н����û�����������
		f.setVisible( true);
		//�û��������ڵĹرհ�ťʱ����ִ�еĲ���
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

	}
	
	public void UI1(JFrame f1) {//��¼����
		//JPanel p0=new JPanel();
		JPanel p0=new JPanel();
		JPanel p1=new JPanel();    //���1
		JPanel p2=new JPanel();    //���2
		JPanel p3=new JPanel();    //���3
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
        b1.addActionListener(new ActionListener() {//��Ӱ�ť�¼�����		

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
		//f.setLocationRelativeTo(null);�����ʵ�ִ��ھ���Ļ����
	    f1.setSize(400,300);
		//���ô���Ĵ�СΪ300*200���ش�С
	    f1.setResizable(true);
		//���ô����Ƿ���Ե�����С������Ϊ����ֵ
		//���ô���ɼ���û�и���䣬���彫���ɼ������������У�����û�н����û�����������
	    f1.setVisible(true);
		//�û��������ڵĹرհ�ťʱ����ִ�еĲ���
	    f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
		
	}
	
	public void UI2(JFrame f1) {//ע�����
		
		//JPanel p0=new JPanel();
		JPanel p0=new JPanel();
		JPanel p1=new JPanel();    //���1
		JPanel p2=new JPanel();    //���2
		JPanel p3=new JPanel();    //���3
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
        b1.addActionListener(new ActionListener() {//��Ӱ�ť�¼�������ע��		

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
			//f.setLocationRelativeTo(null);�����ʵ�ִ��ھ���Ļ����
		f1.setSize(400,300);
			//���ô���Ĵ�СΪ300*200���ش�С
		f1.setResizable(true);
			//���ô����Ƿ���Ե�����С������Ϊ����ֵ
			//���ô���ɼ���û�и���䣬���彫���ɼ������������У�����û�н����û�����������
		f1.setVisible(true);
			//�û��������ڵĹرհ�ťʱ����ִ�еĲ���
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
	}
	
	public void UI3(JFrame f1,String reply) {//��¼����û�����
		
		
		//JPanel p0=new JPanel();
		JPanel p0=new JPanel();
		JPanel p1=new JPanel();    //���1
		JPanel p2=new JPanel();    //���2
		JPanel p3=new JPanel();    //���3
		JPanel p4=new JPanel();    //���4
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
        
    
		b1.addActionListener(new ActionListener() {//��Ӱ�ť�¼��������޸�����		

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
		
		b2.addActionListener(new ActionListener() {//��Ӱ�ť�¼�����	���ӻ���	

			public void actionPerformed(ActionEvent e) {
				String points = pointtext.getText();
				int p = Integer.parseInt(points);
				client.ObjecttoServer(p);
			};
		});
		
		b22.addActionListener(new ActionListener() {//��Ӱ�ť�¼�����	���ٻ���	

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
		//�û��������ڵĹرհ�ťʱ����ִ�еĲ���
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
	}
	
	


	 public void updateDisplay(int point) {
		    String String_point = String.valueOf(point);
	        // ���չʾ����ı����ݲ�����Ϊ�µ��ı�����
		    show_reply.setText("");
			show_reply.append(String_point);
	        }
	 public void updateDisplay(String reply) {
		    
		    show_reply.setText("");
			show_reply.append(reply);
	        }
}