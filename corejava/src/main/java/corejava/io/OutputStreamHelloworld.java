/**
 * 
 */
package corejava.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author hejiaming
 *
 */
public class OutputStreamHelloworld {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ByteArrayOutputStream baOs = new ByteArrayOutputStream();
		baOs.write("hejiaming007".getBytes());
		System.out.println(baOs.size());
		System.out.println(baOs.toString("UTF-8"));
		baOs.reset(); //clear the ByteArrayOutputStream content.
		System.out.println(baOs.size());
		
		baOs.write("hejiaming007".getBytes());
		System.out.println(baOs.size());
		baOs.flush();
		System.out.println(baOs.size());
		
		
		File file = new File("C:/a.txt");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write("hejiaming007".getBytes());
		fos.flush();
		
		FileWriter fw = new FileWriter(file);
		
		
		
		Exception e = new Exception("asdf");
		
//		PrintWriter pw = new PrintWriter(System.out);
		e.printStackTrace(new PrintWriter(fw));
		fw.flush();
		
		
//		fos.
		
		
	}

}
