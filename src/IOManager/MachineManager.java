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
	//�����Ա����
		private File file;
		private String fileName="D:\\filedemo\\student.data";
		private ObjectInputStream ois=null;
		private ObjectOutputStream oos=null;
		//���幹�췽��
		public MachineManager() throws EOFException {
			file=new File(fileName);
			if(!file.exists()) {//��������ڸ��ļ����򴴽�
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//����������
			try {
				this.ois=new ObjectInputStream(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//���������
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
		//���巽��save(ArrayList<Account> list>)��list�е������˻���Ϣ�������ļ���               
		public  void save(ArrayList<Machine> list) throws IOException {
			if(file.length()>=0) {
				this.oos=new ObjectOutputStream(new FileOutputStream(file,true));
				Iterator it=list.iterator();
				while(it.hasNext()) {
					Machine account=(Machine)it.next();
					this.oos.writeObject(account);//���˻�����д�����������
				}
				this.oos.writeObject(null);
				oos.close();
			}
			
		}
		//���巽��get(String name)���ļ���ȡ���˻���Ϊid���˻���Ϣ��
		public  Machine  get(String id) throws Exception {
			this.ois=new ObjectInputStream(new FileInputStream(file));
			Machine account=(Machine) ois.readObject();//�Ӷ�����������ȡһ������
			while(account!=null) {//�����������ж���
				if(account.getId().equalsIgnoreCase(id)) {
					this.ois.close();
					return account;
				}
				account=(Machine)ois.readObject();//��������һ���˻�
			}
			this.ois.close();
			return null;
		}
		//���巽��showAll()��ʾ�����˻���Ϣ��
		public void showAll(){
			try {
				this.ois=new ObjectInputStream(new FileInputStream(file));
				Machine account=(Machine) ois.readObject();//�Ӷ�����������ȡһ������
				while(account!=null) {//�����������ж���
					System.out.println(account);//���һ���˻�
					account=(Machine)ois.readObject();//��������һ���˻�
				}
				this.ois.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//���巽��add(Account acount)���˻���Ϣ׷�ӵ��ļ�����
		public void add(Machine account) throws Exception {
			this.ois=new ObjectInputStream(new FileInputStream(file));
			ArrayList<Machine> list =new ArrayList<>();
			Machine accountTemp=(Machine) this.ois.readObject();//�Ӷ�����������ȡһ������
			while(accountTemp!=null) {//�����������ж���
				list.add(accountTemp);//���˻�������list��
				accountTemp=(Machine)ois.readObject();//��������һ���˻�
			}
			list.add(account);//list���һ�����������˻�
			this.save(list);//����save������list�����˻��������ļ���
			this.ois.close();
		}
}
