package tee;
import java.util.ArrayList;
import java.io.*;

public class ListExam {

	static ArrayList<Student> list;
	
	//���캯����list��ʼ����
	ListExam()
	{
		list=new ArrayList<Student>();
	}
	
	//�������Ӽ�������ѧ����Ϣ��
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
			 System.out.println("�����쳣");
		 }
		 return str;
		 
	 }
	 
	 //���ѧ����Ϣ��
	void  print(Student stu)
	{
		System.out.println("ѧ����������ѧ�ţ��༶�ֱ�Ϊ��"+stu.name + "  "+stu.id + "  "+stu.clas +"  "+ stu.major);		
		
	}
	
	//���ѧ��
    static void addStudent(){
		Student stu=new Student();
		System.out.println("��������ӵ�ѧ��������");		
		stu.name=input();
		System.out.println("��������ӵ�ѧ����ѧ��");
		stu.id=input();
		System.out.println("��������ӵ�ѧ���İ༶");
		stu.clas=input();
		System.out.println("��������ӵ�ѧ����רҵ");
		stu.major=input();
		list.add(stu);
	}	
	//��ѯѧ��
	Student searchStudent(String id)
	{
		for(int i=0;i<list.size();i++){
			if(id.equals(list.get(i).id))
			{
				return list.get(i);
			}
		}
		System.out.println("û�и�ѧ��");
		return null;
		
	}
	
	//ɾ��ѧ��
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
	
	//�޸�ѧ����Ϣ 
	boolean updateStudent(String id)
	{		
		for(int i=0;i<list.size();i++){
			if(id.equals(list.get(i).id))
			{
				System.out.println("����Ҫ�޸ĵ���Ϣ");
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
		//��������ѧ������Ϣ����ӵ�ArrayList��;
		for(int i=0;i<3;i++) {
			ListExam.addStudent();
		}
		//��ѯ�Ƿ���001��ѧ��������У����ѧ����������Ϣ��
		exam.print(exam.searchStudent("001"));
		//�޸ĵڶ���ѧ������Ϣ�����༶����Ϊ8��;
		exam.updateStudent(list.get(1).id);
		//ɾ��������ѧ����
		exam.delStudent(list.get(2).id);
		for(int j=0;j<list.size();j++) {
			exam.print(list.get(j));
		}
		
	}

}
