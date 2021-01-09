package IOManager;

import java.io.Serializable;

public class Machine implements Serializable{
	private  String id;
	private String name;
	private String type;
	private String weight;
	private String height;
	private String num;
	private String numname;
	
	
	//2. 定义构造方法
	public Machine(String id1, String name1, String type1,String weight1,String height1,String num1,String numname1) {
		this.id = id1;
		this.name = name1;
		this.type=type1;
		this.weight=weight1;
		this.height=height1;
		this.num=num1;
		this.numname=numname1;
	}
	//3. 必要的setter和getter方法
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getWeight() {
		return weight;
	}



	public void setWeight(String weight) {
		this.weight = weight;
	}



	public String getHeight() {
		return height;
	}



	public void setHeight(String height) {
		this.height = height;
	}



	public String getNum() {
		return num;
	}



	public void setNum(String num) {
		this.num = num;
	}



	public String getNumname() {
		return numname;
	}



	public void setNumname(String numname) {
		this.numname = numname;
	}



	//4. 定义功能方法	
	public String toString() {
		return this.id+"  "+this.name+"  "+this.type+" "+this.weight+" "+this.height+" "+this.num+" "+this.numname;
	}
}
