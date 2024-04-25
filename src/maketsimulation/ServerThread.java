package maketsimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread{
    Socket socket = null;
	member nowLogin_m1 =null;
	InputStream is;
	BufferedReader br;
	ObjectInputStream ois;
	OutputStream ops;
	membercontrol mc;
	public ServerThread(Socket socket) {
		
		try {
			this.socket = socket;
			this.is = socket.getInputStream();
			this.br = new BufferedReader(new InputStreamReader(is));
			this.ois = new ObjectInputStream(is);
			this.ops = socket.getOutputStream();
			this.mc = new membercontrol();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void run() {
		try {//���������ܿͻ��˴����Ķ���
			member m0 = null;
			while(true) {
				
				int info = is.read();
				boolean q = false; 
				int reply;
				System.out.println(info);
				switch(info) {
				case 1://ע��	
					m0 = (member)ois.readObject();
					if(m0 !=null) {
						q = true; 
					}
					
					System.out.println(q);
					mc.register(m0);
					reply = 1;
					System.out.println(reply);
					ops.write(reply);
					break;
				case 2://��¼
					
					 m0 = (member)ois.readObject();	
					 if(m0 !=null) {
							q = true; 
						}
					 System.out.println(q);
					 System.out.println(m0);
					 m0 = mc.hasmember(m0);
					 if(m0 !=null)
						{
							nowLogin_m1 = m0;
							System.out.println("success to log in");
							reply = 2;
						}
					 else {
						System.out.println("the username is wrong");
						reply = 9;
						System.out.println(reply);
					}
					 System.out.println(reply);
						ops.write(reply);
					 break;
				case 3://�޸�����
					System.out.println(nowLogin_m1.getPassword());
					if(nowLogin_m1 !=null)
					{
						String pwd = null;
						char[] buffer = new char[1024]; // �������ݲ����� 1024 �ֽ�
						int bytesRead = br.read(buffer); // ��ȡ���ݵ�������
						if (bytesRead != -1) {
						    // ����ȡ��������ת��Ϊ�ַ���
						    pwd = new String(buffer, 0, bytesRead);
						    System.out.println("Received reply: " + pwd);
						}
						boolean flag = mc.changepwd(nowLogin_m1,pwd);
						System.out.println("Received reply: " + pwd);
						if(flag) {
					    	 reply = 3;
					     }else {
					    	 reply = 8;
					     }
						System.out.println(reply);
						ops.write(reply);
					}
					
					break;
			
				case 4://�޸Ļ���
					int point = is.read();
					System.out.println("the point is");
					System.out.println(point);
					boolean flag = mc.changescore(nowLogin_m1,point);
					if(flag) {
				    	 reply = 4;
				     }else {
				    	 reply = 7;
				     }
					System.out.println(reply);
					ops.write(reply);
					break;
					
				 case 5://��ѯ����
					
					int point1 = mc.showscore(nowLogin_m1);
					System.out.println(point1);
					reply = 5;
					
					ops.write(reply);
					ops.write(point1);
					
					break;
				}

				
				
			   
			}
				
			
			
			
//			ops.close();
//			ois.close();
//			is.close();
//			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
