package Test;

import java.io.EOFException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import IOManager.Machine;
import IOManager.MachineManager;
import MyJFrame.AddInformationFrame;
import MyJFrame.IOFrame;
import MyJFrame.LoginFrame;
import MyJFrame.MainFrame;
import MySQLManager.MySQLManager;

public class Codingtest {
	 public static int Num() {
	        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	        Random rand = new Random();
	        for (int i = 10; i > 1; i--) {
	            int index = rand.nextInt(i);
	            int tmp = array[index];
	            array[index] = array[i - 1];
	            array[i - 1] = tmp;
	        }
	        int result = 0;
	        for (int i = 0; i < 8; i++) {
	            result = result * 10 + array[i];
	        }
	        if (String.valueOf(result).length() <=8) {
	            return result;
	        } else {
	            return Num();
	        }
	    }
	public static void main(String[] args) throws SQLException {
		
		//测试IO流
		//new LoginFrame();
		//生成10000条数据
		
		StringBuffer id = new StringBuffer();
		StringBuffer name = new StringBuffer();
		StringBuffer type = new StringBuffer();
		StringBuffer weight = new StringBuffer();
		StringBuffer height = new StringBuffer();
		StringBuffer num = new StringBuffer();
		StringBuffer numname = new StringBuffer();
		String id1;
		String name1;
		String type1;
		String weight1;
		String height1;
		String num1;
		String numname1;
		
		String a[]={"铺路","推土","木材","挖掘","塔式","塔式起重","塔式压桩","静力起重","静力压桩","施工",
				"静力","振动沉","高压","拔桩","焊接","土石方及筑路","静压振","搅拌","拔桩","拔桩",
				"凝土","振动沉","焊接","喷桩","柴油","喷桩","水平","水平运输","水平运输","搅拌站",
				"混凝土","土石方","水平运输","喷桩","旋转","筑路","高压旋转喷桩","转盘","水平","水平运输",
				"履带式","焊接","石油","高压旋转","垂直","高速卷扬","水平","垂直运输","焊接","拔桩",
				"履带","加工","挖","煤油","卷扬","塔式","加工","转盘","运输","运输",
				"喷桩","焊接","土石","振动沉","履带式推土","喷桩","油","拔桩","转盘钻孔","压桩",
				"喷桩","喷桩","履带式起重","转盘","柴油打桩","加工","水平运输","地下工程","转盘钻孔","运输",
				"振动沉","履带式起重","土石方及","高速","压路","水平","履带式重","转盘钻孔","拔桩","地下工程",
				"振动沉","地下工程","加工","混凝土及砂浆","地下工程","混凝土","砂浆","混凝土及砂浆","焊接","地下工程"};
		String b[]= {"起重机","运输机械","钻孔机"," 焊接机","工机","","","","","机械",
				"起重机","运输机械","机",""," 焊接机","钻孔机","工机","","机械","",
				"","运输机械","","机","起重机"," 焊接机","","机械","","",
				"","","运输机械","钻孔机","机"," 焊接机","工机","机械","","",
				"","","焊接机","钻孔机","工机","机","机械","运输机械","起重机","",
				"","","焊接机","","钻孔机","机械","机","","运输机械","起重机",
				"","焊接机","工机","","钻孔机","机械","运输机械","机","起重机","",
				"","焊接机","","工机","机械","","","运输机械","机","",
				"","","","机械","工机","钻孔机","","运输机械","起重机","机",
				"","焊接机","机械","钻孔机","工机","起重机","","运输机械","","机"};
		
		
		//for(int i=0;i<100;i++)
		//	System.out.println(Num());
		//id
		/*id.append(Integer.toString(Num()));
		System.out.println(id);
		id.delete(0, id.length());   */
		//System.out.println(name[0]+"");
		//name
		//插入10000条数据
		/*for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				id.append(Integer.toString(Num()));
				name.append(a[i]).append(b[j]);
				long l = System.currentTimeMillis();
				int random = (int)l%10;
				if(j%5==0) {
					//System.out.println("机械");
					type.append("机械");
				}else if(j%5==1) {
					type.append("建造");
				}else if(j%5==2) {
					type.append("打桩");
				}else if(j%5==3) {
					type.append("搅拌");
				}else if(j%5==4){
					type.append("履带式");
				}
				Random rand =new Random();
				weight.append(rand.nextInt(1000));
				height.append(rand.nextInt(30));
				num.append(Integer.toString(Num()));
				if(j%5==0) {
					//System.out.println("机械");
					numname.append("火车");
				}else if(j%5==1) {
					numname.append("汽车");
				}else if(j%5==2) {
					numname.append("飞机");
				}else if(j%5==3) {
					numname.append("轮船");
				}else if(j%5==4){
					numname.append("汽艇");
				}
				//System.out.println(id+" "+name+" "+type+" "+weight+" "+height+" "+num+" "+numname);
				
				//ArrayList<Machine> list=new ArrayList<>();
				//list.add(new Machine(id, name, type, weight, height, num, numname));
				id1=id.toString();
				name1=name.toString();
				type1=type.toString();
				weight1=weight.toString();
				height1=height.toString();
				num1=num.toString();
				numname1=numname.toString();
				try {
					MachineManager am=new MachineManager();
					am.add(new Machine(id1, name1, type1, weight1, height1, num1, numname1));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//保存账户信息
				
				id1="";
				name1="";
				type1="";
				weight1="";
				height1="";
				num1="";
				numname1="";
				id.delete(0, id.length());
				name.delete(0,name.length());
				type.delete(0, type.length());
				weight.delete(0, weight.length());
				height.delete(0, height.length());
				num.delete(0, num.length());
				numname.delete(0, numname.length());
			}
		}*/
		
		
		//type
		/*for(int i=0;i<100;i++) {
			long l = System.currentTimeMillis();
			int random = (int)l%10;
			System.out.println(random);
			if(i%5==0) {
				System.out.println("机械");
				//type.append("重工业");
				//type.delete(0, type.length());   
			}else if(i%5==1) {
				System.out.println("火车");
			}else if(i%5==2) {
				System.out.println("机车");
			}
		}*/
		//weight
		/*for(int i=0;i<10000;i++) {
			Random rand =new Random();
			System.out.println(rand.nextInt(1000));
			
		}*/
		//height

		
		
		/*System.out.println("insert into machine values("+words[0]+",'"+words[1]+"','"+words[2]+"',"+words[3]+","+words[4]+","+words[5]+",'"+words[6]+"')");
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=MySQLManager.getConn();
			ps=conn.prepareStatement("insert into machine values("+words[0]+",'"+words[1]+"','"+words[2]+"',"+words[3]+","+words[4]+","+words[5]+",'"+words[6]+"')");
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "已增加信息");
			
			
			new MainFrame("select * from machine");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}*/
		
		//new MainFrame("select * from machine");
//		Connection conn=MySQLManager.getConn();
//		Statement stmt=conn.createStatement();
//		String sql="select * from human";
//		ResultSet rs=stmt.executeQuery(sql);
//		String n = null,k = null;
//		while(rs.next()) {
//			System.out.println(rs.getString(1)+":"+rs.getString(2));
//			n=rs.getString(1);
//			k=rs.getString(2);
//			
//		}
//		System.out.println(n+":"+k);
//		
		
	}  
}

        