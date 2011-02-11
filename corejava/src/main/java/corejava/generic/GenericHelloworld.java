package corejava.generic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericHelloworld extends Date {

	private static final long serialVersionUID = 1L;

	public void sayHello() {
		System.out.println("hello");
	}

	public static void main(String[] args) throws Exception {
		GenericHelloworld tester = new GenericHelloworld();
		tester.test();
	}

	@SuppressWarnings("unused")
	public void test() {

		java.util.Date utilDate;
		java.sql.Date sqlDate;
		String str;
		GenericHelloworld genericTest;

		// Without generic, you can see the warning.
		List list1 = new ArrayList();
		list1.add(new GenericHelloworld());
		((GenericHelloworld) list1.get(0)).sayHello();

		// simple with generic
		// List<java.sql.Date> read a List of java.sql.Date
		List<java.sql.Date> list2 = new ArrayList<java.sql.Date>();
		list2.add(new java.sql.Date(0));
		sqlDate = list2.get(0);
		System.out.println("generic class:"+list2.getClass());
		// list2.add(new java.util.Date()); //compile error. You can't add
		// java.util.Date to List of java.sql.Date

		List<java.util.Date> list3 = new ArrayList<java.util.Date>();
		list3.add(new java.sql.Date(0));
		utilDate = list3.get(0);
		System.out.println(utilDate.getClass());// class java.sql.Date

		// Self define Raw type (without wildcard) class :
		ObjecChecker<String> checker11 = new ObjecChecker<String>();
		str = checker11.getObject();
		ObjecChecker<Date> checker12 = new ObjecChecker<Date>();
		utilDate = checker12.getObject();

		// Self define Raw type (with extend restriction) class :
		ObjecCheckerWihtExtend<GenericHelloworld> checker21 = new ObjecCheckerWihtExtend<GenericHelloworld>();
		genericTest = checker21.getObject();
		// new ObjecCheckerWildcard<String>();//Compile error: String is not
		// subclass of java.util.Date

		// Wildcard can't be used when new object:
		// new ArrayList<? extends Date>(); //Compile error: Cannot instantiate
		// the type ArrayList<? extends Date>

		// While Cage<Lion> and Cage<Butterfly> are not subtypes of
		// Cage<Animal>, they are in fact subtypes of Cage<? extends Animal>:

		// simple with generic
		List<? extends java.util.Date> list4 = new ArrayList<java.sql.Date>();
		// Why can't put element into list4, just can get element from it?
		// Because List<? extends java.util.Date>
		// ��˵װ��java.util.Date�����List�����Կ�����װjava.sql.Date��List��
		// ����ʵ�������List<? extends
		// java.util.Date>��һ��װjava.sql.Date��List��ʱ���Ҽ�����java.util.Date�����࣬��java.sql.Timestamp�����ȥ�Ͳ�����
		// ��֮get�ǿ��Եģ���Ϊ����get�������඼��supper cast�ɸ���
		// ���ԣ���ʽͨ��wildcard�����parameterized type�������Ե��ò��������в������Ͳ���ķ�������ǲ�����null
		//? extends T ---> T's subclass exclude T
		try {
			utilDate = list4.get(0);
		} catch (RuntimeException e) {
		}
		list4.add(null);
		
		
		////? super T ---> T's super class include T
		List<? super java.util.Date> list5 = new ArrayList<java.util.Date>();
		list5.add(utilDate);
		list5.add(sqlDate);
		Object o = list5.get(0);//o is null
		System.out.println(o);//null
		
		// Why is Java's Class<T> generic?
		// so you can use generic typed methods
		try {
			Class<String> klass = null;
			str = klass.newInstance();
			str = klass.cast(new Date());
		} catch (RuntimeException e) {
		} catch (Exception e) {
		}

		// For the list of java.util.Class situation. (Because java.util.Class
		// is also a Raw type)
		List<Class<?>> list6 = new ArrayList<Class<?>>();
		list6.add(String.class);
		list6.get(0).getName();
		
		

	}

	class ObjecChecker<T> {
		T object;

		public void setObject(T object) {
			this.object = object;
		}

		public T getObject() {
			return object;
		}
	}
	

	class ObjecCheckerWihtExtend<T extends Date> {
		T object;

		public void setObject(T object) {
			this.object = object;
		}

		public T getObject() {
			return object;
		}
	}

}
