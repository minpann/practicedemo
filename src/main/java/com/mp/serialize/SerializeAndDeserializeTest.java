package com.mp.serialize;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeTest {
	@Test
	public static void serializePerson(List<Person> listPerson) throws FileNotFoundException, IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/data.txt"));
		for (Person p : listPerson) {
			oos.writeObject(p);
		}
		oos.close();
	}

	public static List<Person> deserializePerson() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		List<Person> list = new ArrayList<Person>();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/data.txt"));
		Person person = (Person)ois.readObject();
		Person person1 = (Person)ois.readObject();
		Person person2 = (Person)ois.readObject();
		Person person3 = (Person)ois.readObject();
			list.add(person);
			list.add(person1);
			list.add(person2);
			list.add(person3);
		ois.close();
		return list;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Person> listPerson = new ArrayList<Person>();
		listPerson.add(new Person(1, "张明", "北京市朝阳区"));
		listPerson.add(new Person(2, "李清", "四川省成都市"));
		serializePerson(listPerson);
		listPerson.add(new Person(3, "王水", "北京市朝阳区"));
		listPerson.add(new Person(4, "赵明", "四川省成都市"));
		serializePerson(listPerson);
		List<Person> list =  deserializePerson();
		for (Person p : list) {
			System.out.println(p);
		}
	}
}
