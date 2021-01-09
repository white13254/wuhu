package IOManager;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MachineManager {
	//定义成员变量
		private File file;
		private String fileName="D:\\filedemo\\student.data";
		private ObjectInputStream ois=null;
		private ObjectOutputStream oos=null;
		//定义构造方法
		public MachineManager() throws EOFException {
			file=new File(fileName);
			if(!file.exists()) {//如果不存在该文件，则创建
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//对象输入流
			try {
				this.ois=new ObjectInputStream(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//对象输出流
			try {
				this.oos=new ObjectOutputStream(new FileOutputStream(file,true));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//定义方法save(ArrayList<Account> list>)把list中的所有账户信息保存在文件中               
		public  void save(ArrayList<Machine> list) throws IOException {
			if(file.length()>=0) {
				this.oos=new ObjectOutputStream(new FileOutputStream(file,true));
				Iterator it=list.iterator();
				while(it.hasNext()) {
					Machine account=(Machine)it.next();
					this.oos.writeObject(account);//把账户对象写到对象输出流
				}
				this.oos.writeObject(null);
				oos.close();
			}
			
		}
		//定义方法get(String name)从文件中取得账户名为id的账户信息，
		public  Machine  get(String id) throws Exception {
			this.ois=new ObjectInputStream(new FileInputStream(file));
			Machine account=(Machine) ois.readObject();//从对象输入流读取一个对象
			while(account!=null) {//当输入流还有对象
				if(account.getId().equalsIgnoreCase(id)) {
					this.ois.close();
					return account;
				}
				account=(Machine)ois.readObject();//继续读下一个账户
			}
			this.ois.close();
			return null;
		}
		//定义方法showAll()显示所有账户信息，
		public void showAll(){
			try {
				this.ois=new ObjectInputStream(new FileInputStream(file));
				Machine account=(Machine) ois.readObject();//从对象输入流读取一个对象
				while(account!=null) {//当输入流还有对象
					System.out.println(account);//输出一个账户
					account=(Machine)ois.readObject();//继续读下一个账户
				}
				this.ois.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//定义方法add(Account acount)把账户信息追加到文件后面
		public void add(Machine account) throws Exception {
			this.ois=new ObjectInputStream(new FileInputStream(file));
			ArrayList<Machine> list =new ArrayList<>();
			Machine accountTemp=(Machine) this.ois.readObject();//从对象输入流读取一个对象
			while(accountTemp!=null) {//当输入流还有对象
				list.add(accountTemp);//把账户保存在list中
				accountTemp=(Machine)ois.readObject();//继续读下一个账户
			}
			list.add(account);//list最后一个保存新增账户
			this.save(list);//调用save方法把list所有账户保存在文件中
			this.ois.close();
		}
}
