package maketsimulation;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class LoginClient1 {
	Socket socket; 
	OutputStream os; 
	ObjectOutputStream oos; 
	InputStream is;
	BufferedReader br; 
	ObjectInputStream ois;
	public LoginClient1() {
		
		try {
			this.socket = new Socket("localhost",5000);
			this.os = socket.getOutputStream();
			this.oos = new ObjectOutputStream(os);
            this.is = socket.getInputStream();
            this.br = new BufferedReader(new InputStreamReader(is));
			//ois = new ObjectInputStream(is);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void ObjecttoServer(member m1,int a) {//登录或者注册
		try {
			if (a==1) {
				System.out.println("19"+m1.getIDcard());
				os.write(1);
				oos.writeObject(m1);
				
			}else if(a==2){
				System.out.println("mnb"+m1.getIDcard());
				os.write(2);
				oos.writeObject(m1);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ObjecttoServer(String pwd) {
		try {
			//修改密码
			    System.out.println(pwd);
			    os.write(3);
				os.write(pwd.getBytes());
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ObjecttoServer(int point) {
		try {
			//修改积分
			System.out.println("the point is");
			System.out.println(point);
			    os.write(4);
				os.write(point);
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ObjecttoServer() {
		try {
			//查询积分
			    os.write(5);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void CloseConnect() {
		try {
			
			br.close();
			is.close();
			oos.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] arg) {
		
		LoginClient1 client = new LoginClient1();
		
		UI ui = new UI(client);
		ui.UI0();
		JFrame f3 = new JFrame("market simulation client");//登录后的界面
		JFrame f0 = new JFrame("market simulation client");//登录界面
		int reply;
		
		try {
			//client.socket.shutdownOutput();
			while(true) {
				System.out.println("1111");
				
				reply = client.br.read();
				
				System.out.println("133311");
				System.out.println("Received reply: " +reply);
				switch(reply) {
				case 2: //log in
					
					ui.UI3(f3,null);
					
				    break;
				case 1:  //register
					System.out.println("1111");
					System.out.println("1111");
					ui.UI1(f0);
					
				    break;
				case 3: //change the password
					System.out.println(reply);
					ui.updateDisplay("success to change the password");
				    break;
				case 4: //change the point
					System.out.println(reply);
					ui.updateDisplay("success to change the points");
				    break;
				case 9:
					System.out.println("the username is wrong");
					break;
				case 5:
					int po = client.br.read();
					System.out.println("123qwe"+po);
					ui.updateDisplay(po);
				    break;
				default:
					break;
				
	            
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		client.CloseConnect();
			
			
			//接收来自服务器的反馈信息
			
			
			
			
	
		
		
	}

}
