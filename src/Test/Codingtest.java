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
		
		//����IO��
		//new LoginFrame();
		//����10000������
		
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
		
		String a[]={"��·","����","ľ��","�ھ�","��ʽ","��ʽ����","��ʽѹ׮","��������","����ѹ׮","ʩ��",
				"����","�񶯳�","��ѹ","��׮","����","��ʯ������·","��ѹ��","����","��׮","��׮",
				"����","�񶯳�","����","��׮","����","��׮","ˮƽ","ˮƽ����","ˮƽ����","����վ",
				"������","��ʯ��","ˮƽ����","��׮","��ת","��·","��ѹ��ת��׮","ת��","ˮƽ","ˮƽ����",
				"�Ĵ�ʽ","����","ʯ��","��ѹ��ת","��ֱ","���پ���","ˮƽ","��ֱ����","����","��׮",
				"�Ĵ�","�ӹ�","��","ú��","����","��ʽ","�ӹ�","ת��","����","����",
				"��׮","����","��ʯ","�񶯳�","�Ĵ�ʽ����","��׮","��","��׮","ת�����","ѹ׮",
				"��׮","��׮","�Ĵ�ʽ����","ת��","���ʹ�׮","�ӹ�","ˮƽ����","���¹���","ת�����","����",
				"�񶯳�","�Ĵ�ʽ����","��ʯ����","����","ѹ·","ˮƽ","�Ĵ�ʽ��","ת�����","��׮","���¹���",
				"�񶯳�","���¹���","�ӹ�","��������ɰ��","���¹���","������","ɰ��","��������ɰ��","����","���¹���"};
		String b[]= {"���ػ�","�����е","��׻�"," ���ӻ�","����","","","","","��е",
				"���ػ�","�����е","��",""," ���ӻ�","��׻�","����","","��е","",
				"","�����е","","��","���ػ�"," ���ӻ�","","��е","","",
				"","","�����е","��׻�","��"," ���ӻ�","����","��е","","",
				"","","���ӻ�","��׻�","����","��","��е","�����е","���ػ�","",
				"","","���ӻ�","","��׻�","��е","��","","�����е","���ػ�",
				"","���ӻ�","����","","��׻�","��е","�����е","��","���ػ�","",
				"","���ӻ�","","����","��е","","","�����е","��","",
				"","","","��е","����","��׻�","","�����е","���ػ�","��",
				"","���ӻ�","��е","��׻�","����","���ػ�","","�����е","","��"};
		
		
		//for(int i=0;i<100;i++)
		//	System.out.println(Num());
		//id
		/*id.append(Integer.toString(Num()));
		System.out.println(id);
		id.delete(0, id.length());   */
		//System.out.println(name[0]+"");
		//name
		//����10000������
		/*for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				id.append(Integer.toString(Num()));
				name.append(a[i]).append(b[j]);
				long l = System.currentTimeMillis();
				int random = (int)l%10;
				if(j%5==0) {
					//System.out.println("��е");
					type.append("��е");
				}else if(j%5==1) {
					type.append("����");
				}else if(j%5==2) {
					type.append("��׮");
				}else if(j%5==3) {
					type.append("����");
				}else if(j%5==4){
					type.append("�Ĵ�ʽ");
				}
				Random rand =new Random();
				weight.append(rand.nextInt(1000));
				height.append(rand.nextInt(30));
				num.append(Integer.toString(Num()));
				if(j%5==0) {
					//System.out.println("��е");
					numname.append("��");
				}else if(j%5==1) {
					numname.append("����");
				}else if(j%5==2) {
					numname.append("�ɻ�");
				}else if(j%5==3) {
					numname.append("�ִ�");
				}else if(j%5==4){
					numname.append("��ͧ");
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
				}//�����˻���Ϣ
				
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
				System.out.println("��е");
				//type.append("�ع�ҵ");
				//type.delete(0, type.length());   
			}else if(i%5==1) {
				System.out.println("��");
			}else if(i%5==2) {
				System.out.println("����");
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
			JOptionPane.showMessageDialog(null, "��������Ϣ");
			
			
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

        