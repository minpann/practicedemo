package com.mp.clone;

class Course implements Cloneable
{
	private int cno;
	
	private String cname;

	public Course(int cno, String cname)
	{
		this.cno = cno;
		this.cname = cname;
	}
	
	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		return "Course [cno=" + cno + ", cname=" + cname + "]";
	}
}

class Person implements Cloneable
{

	private int sno;
	
	private String sname;
	
	private Course course;

	public Person(int sno, String sname, Course course) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.course = course;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Person p = (Person)super.clone();
		p.course = course;
		return p;
	}

	@Override
	public String toString() {
		return "Person [sno=" + sno + ", sname=" + sname + ", course=" + course.toString()
				+ "]";
	}
}

public class DeepCloneTest {

	public static void main(String[] args) {
		Course c = new Course(1001,"English");
		Person person = new Person(1,"王磊",c);
		
		System.out.println(person);
		Person personClone = null;
		try {
			personClone = (Person) person.clone();
			System.out.println(personClone);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personClone.setSno(2);
		personClone.setSname("张琼");
		personClone.setCourse(new Course(1002,"高等数学"));
		System.out.println(personClone);
		
	}
	
}
