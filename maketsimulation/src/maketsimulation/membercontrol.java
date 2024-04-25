package maketsimulation;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class membercontrol {
	//所有会员的列表
	static List<member> MemberList = new ArrayList<member>(); 
	static private int present_number = 100;
	boolean flag_present = false; //礼品还没有送完
	//输入scanner对象
	Scanner input = new Scanner(System.in);
	//输出操作提示菜单

//	public void Start() {
//		do {
//		    
//			
//			switch(choose) {
//			case 1:
//				System.out.println("注册会员卡");
//				register();
//				continue;
//			case 2:
//				System.out.println("修改密码");
//				if(changepwd()) {
//					System.out.println("..........success to change the pwd..........");
//				}
//				continue;
//			case 3:
//				System.out.println("累积积分");
//				if(plusscore()) {
//					System.out.println("..........success to change the score..........");
//				}
//				continue;
//			case 4:
//				System.out.println("使用积分");
//				if(minussorce()) {
//					System.out.println("..........success to minus the score..........");
//				}
//				continue;
//			case 5:
//				System.out.println("查询积分");
//				showscore();
//				continue;
//			case 6:
//				System.out.println("退出");
//				break;
//			default:
//				System.out.println("错误操作");
//				continue;
//			}
//		break;	
//		}while(true);
//	}
	
	
	public void register(member m) {
		
		MemberList.add(m);
	}

	public member hasmember(member m) {
		member m1 = null;
		for(member m2:MemberList) {
			if(m.getIDcard()==m2.getIDcard() && m.getPassword().equals(m2.getPassword())){//equals严格区分大小写
				m1 = m2;
				break;
			}
		}
		return m1;
		
	}
    
	public boolean changepwd(member m1,String pwd) {
		boolean flag = true;
		member m = m1;

		if(m!=null) {
			m.setPassword(pwd);
						
		}else {
			System.out.println("..........the username is wrong..........");
			flag = false;
		}
		return flag;
		
	}

	public boolean changescore(member m1,int point) {
		boolean flag = true;
		member m = m1;
		if(m!=null) {
			System.out.println(point);
			m.setScore(m.getScore()+point);
			flag = true;
		}
		return flag;
		
	}

	public int showscore(member m1) {
		
		member m = m1;
		int score;
		if(m!=null) {
			System.out.println("..........現在のポイントカード点数..........");
			score = m.getScore();
			
			
		}else {
			System.out.println("..........输入的会员密码错误..........");
			score = 0;
			
		}
		return score;
		
	}



  
}
