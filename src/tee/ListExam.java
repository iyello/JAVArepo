package tee;
import java.util.ArrayList;
import java.io.*;

public class ListExam {

	static ArrayList<Student> list;
	
	//构造函数，list初始化。
	ListExam()
	{
		list=new ArrayList<Student>();
	}
	
	//方法，从键盘输入学生信息；
	static String input()
	 {
		 InputStreamReader ir=new InputStreamReader(System.in);
		 BufferedReader in=new BufferedReader(ir);
		 String str=null;
		 try
		 {
			 str=in.readLine();
		 }catch(IOException e)
		 {
			 System.out.println("输入异常");
		 }
		 return str;
		 
	 }
	 
	 //输出学生信息；
	void  print(Student stu)
	{
		System.out.println("学生的姓名，学号，班级分别为："+stu.name + "  "+stu.id + "  "+stu.clas +"  "+ stu.major);		
		
	}
	
	//添加学生
    static void addStudent(){
		Student stu=new Student();
		System.out.println("请输入添加的学生的姓名");		
		stu.name=input();
		System.out.println("请输入添加的学生的学号");
		stu.id=input();
		System.out.println("请输入添加的学生的班级");
		stu.clas=input();
		System.out.println("请输入添加的学生的专业");
		stu.major=input();
		list.add(stu);
	}	
	//查询学生
	Student searchStudent(String id)
	{
		for(int i=0;i<list.size();i++){
			if(id.equals(list.get(i).id))
			{
				return list.get(i);
			}
		}
		System.out.println("没有该学生");
		return null;
		
	}
	
	//删除学生
	boolean delStudent(String id)
	{
		for(int i=0;i<list.size();i++){
			if(id.equals(list.get(i).id))
			{
				list.remove(i);
				return true;
				
			}
		}
		return false;
	
	}
	
	//修改学生信息 
	boolean updateStudent(String id)
	{		
		for(int i=0;i<list.size();i++){
			if(id.equals(list.get(i).id))
			{
				System.out.println("输入要修改的信息");
				list.get(i).clas=input();
				return true;
				
			}
		}
		return false;
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListExam exam=new ListExam();
		//输入三个学生的信息，添加到ArrayList中;
		for(int i=0;i<3;i++) {
			ListExam.addStudent();
		}
		//查询是否有001号学生，如果有，输出学生的所有信息；
		exam.print(exam.searchStudent("001"));
		//修改第二个学生的信息，将班级更改为8班;
		exam.updateStudent(list.get(1).id);
		//删除第三个学生；
		exam.delStudent(list.get(2).id);
		for(int j=0;j<list.size();j++) {
			exam.print(list.get(j));
		}
		
	}

}
