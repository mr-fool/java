//jar tvf JFLAP.jar
import java.util.*;

public class Test {
	public static void main(String[] args) throws Exception{
		Information information = new Information("/home/mr-fool/Documents/JFLAP.jar","org.apache.batik.transcoder.TranscoderInput");
		information.printFunctions();
		//information.checkForFunction("attributeIsFalse");
		List<List<Integer>> methodList = new ArrayList<List<Integer>>(); 
		methodList = information.properArguments("getURI");
		for(Integer tmp: methodList) { 
			System.out.println(tmp);
		}//end-for
	}//end main
}
/*javac Test.java
Test.java:11: error: incompatible types: List<Integer> cannot be converted to Integer
		for(Integer tmp: methodList) { 
		                 ^
1 error
*/
