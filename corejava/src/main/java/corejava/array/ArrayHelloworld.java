/**
 * 
 */
package corejava.array;

/**
 * @author hejiaming
 *
 */
public class ArrayHelloworld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		primitiveTypeTest();
		
	}
	
	
	public static void primitiveTypeTest(){
		// TODO Auto-generated method stub
		boolean[] booleanArray = {true,false,true,false,true};
		byte[] byteArray = {1,2,3,4,5};
		int[] intArray = {1,2,3,4,5};
		char[] charArray = {'a','b','c','d','e'};
		float[] floatArray = {1,2,3,4,5};
		
		System.out.println(booleanArray+" "+ booleanArray.getClass());//[Z@6bbc4459
		System.out.println(byteArray+" "+ byteArray.getClass());//[B@152b6651
		System.out.println(intArray+" "+ intArray.getClass());//[I@544a5ab2
		System.out.println(charArray);
		System.out.println(charArray.toString()+" "+ charArray.getClass());//abcde
		System.out.println(floatArray+" "+ floatArray.getClass());//[F@5d888759
	}

}
