package random;

import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;

public class RandomHelloworld {
	public static void main(String args[]) {

		long seed = 1L;
		
		Random rd = new Random(4);
		rd.setSeed(seed);
		int[] frequence = new int[4];
		int rdGet;
		for (int i = 0; i < 100; i++) {
			rdGet = Math.abs(rd.nextInt()) % 4 + 1;

			switch (rdGet) {
			case 1:
				frequence[0]++;/* System.out.print(1+" "); */
				break;
			case 2:
				frequence[1]++;/* System.out.print(2+" "); */
				break;
			case 3:
				frequence[2]++;/* System.out.print(3+" "); */
				break;
			case 4:
				frequence[3]++;/* System.out.print(4+" "); */
				break;
			}
		}
		System.out.println();
		for (int i = 0; i < frequence.length; i++) {
			System.out.println((i + 1) + "����" + frequence[i] + "�Σ����ֵ�Ƶ���ǣ�"
					+ frequence[i] / 100.0);
		}
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i+":"+getRandomValue());
		}
		

	}
	
	
	public static int getRandomValue() {
		
		return RandomUtils.nextInt(100);
		
	}
	
	
}
