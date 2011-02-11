/**
 * 
 */
package corejava.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.SequenceInputStream;
import java.io.StringReader;

import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author hejiaming
 * 
 */
public class InputStreamHelloworld {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		byte b = 127;
		Byte bb = new Byte(b);
		Byte bb2 = Byte.decode("00000011");
		// System.out.println(Integer.toBinaryString(135121351));

		File file = new File("c:/a.txt");
		FileInputStream fis = new FileInputStream(file);

		PropertiesConfiguration pc = new PropertiesConfiguration();

		// fis.rea

		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		pis.connect(pos);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		bos.toByteArray();

		BufferedInputStream bis = new BufferedInputStream(fis);
		try {

			byte[] buffer = new byte[1];
			for (int i = 0; i < 100; i++) {
				// while(true){
				int result = bis.read(buffer);
				if (result != -1) {
					pos.write(buffer);
					pis.read(buffer);
					System.out.println(new String(buffer));
					if ((new String(buffer)).equals("1")) {
						System.out.println("marked.");
						bis.mark(0);
					}

					if ((new String(buffer)).equals("9")) {
						System.out.println("reset to marker.");
						bis.reset();
					}

				} else {
					continue;
				}
			}
		} finally {
			fis.close(); // If no close fileInputStream, system resource link to
							// this file won't release
			// and this file can't be delete or modified.
		}

		// ByteArrayInputStream is constructed by a byte array, so it's
		// independent with outside resource.
		
		/*
		 * byte[] bytes = null; String str = ""; bytes = str.getBytes(); str =
		 * new String(bytes);
		 */
		ByteArrayInputStream bais = new ByteArrayInputStream("abcd".getBytes());
		System.out.println(bais.read());
		bais.close();// close a ByteArrayInputStream is insignificant.
		
		// It usually use for construct a inputStream from a String / byte array
		// Byte array and String can be transform to each other.
		StringReader sr = new StringReader("abcdefg");
		char[] cbuf = new char[3];
		sr.read(cbuf);
		System.out.println(cbuf);
		
		/*
		 * FileReader just use default encoding(current java file's encoding), 
		 * if you need special encoding,
		 * construct an InputStreamReader on a FileInputStream.
		 */
		FileReader fr = new FileReader(file);
		System.out.println("FileReader default encoding:" + fr.getEncoding());
		
		InputStreamReader isr = new InputStreamReader(
				new FileInputStream(file), "GBK");
		System.out.println("InputStreamReader on FileInputStream encoding:"
				+ isr.getEncoding());

		char[] chars = new char[100];
		fr.read(chars);
		System.out.println(chars);
		isr.read(chars);
		System.out.println(chars);
		System.out.println(chars.getClass());
		
		int[] is = {1,1,1,1,1};
		System.out.println(is.getClass());
		
	}

}
