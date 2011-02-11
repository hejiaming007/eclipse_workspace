package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author hejiaming
 *
 */
public class MyClass implements Serializable {
	
	/**
	 *  If the generated class content no change, then this id won't change.
	 */
	private static final long serialVersionUID = -3695317321016752585L;

	private String name;

	private MyClass internalClass;
	
	transient private MySimpleClass mySimpleClass;  //Labled as transient means when serial the object, will ignore it.
	
	public MySimpleClass getMySimpleClass() {
		return mySimpleClass;
	}

	public void setMySimpleClass(MySimpleClass mySimpleClass) {
		this.mySimpleClass = mySimpleClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public MyClass getInternalClass() {
		return internalClass;
	}

	public void setInternalClass(MyClass internalClass) {
		this.internalClass = internalClass;
	}

	public static void main(String args[]){
		
		String tempFile = "c:/a.txt";
		
		MyClass object1 = new MyClass();
		object1.setName("jimmy");
		
		MyClass internalObject = new MyClass();
		internalObject.setName("jimmy2");
		object1.setInternalClass(internalObject);
	
		/*
		 * MySimpleClass is not a Serializable object, so add to MyClass for Serialize will throw 
		 * java.io.WriteAbortedException: writing aborted; java.io.NotSerializableException: serialization.MySimpleClass
		 * 
		 * */
		object1.setMySimpleClass(new MySimpleClass("my simple class name.")); //Comment this line for run correctly.
		
		
		try {
			FileOutputStream fos = new FileOutputStream(tempFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object1);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Deserialize the object.
		
			FileInputStream fis;
			try {
				fis = new FileInputStream(tempFile);
				ObjectInputStream ois;
				ois = new ObjectInputStream(fis);
				MyClass object2 = (MyClass)ois.readObject();//java.io.WriteAbortedException comes from here.
				ois.close();
				System.out.println(object2.getName());
				System.out.println(object2.getInternalClass().getName());
				System.out.println(object2.getMySimpleClass().getName()); //For transit case, MySimpleClass will be null.
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				new File(tempFile).delete();
			}	
	}
	
}


class MySimpleClass {
	
	String name;
	
	public MySimpleClass(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
