package corejava.cast;

import java.util.ArrayList;
import java.util.List;

public class UpCast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o1 = (Object)"";
		List list = new ArrayList();
		list.add("");
		Object o2 = list.get(0);
		
		/*
		 * 得到的是Object引用，但是该引用指向String对象。
		 * 
		 * */
		System.out.println("Object1:"+o1.getClass());
		System.out.println("Object2:"+o2.getClass());
	}

}
