package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserializer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tempFile = "c:/a.txt";
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(tempFile);
			ObjectInputStream ois;
			ois = new ObjectInputStream(fis);
			Serializer object = (Serializer) ois.readObject();// java.io.WriteAbortedException
															// comes from here.
			ois.close();
			System.out.println("Deserialize object success: " + object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new File(tempFile).delete();
		}
	}

}
