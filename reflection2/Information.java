/*References
 * https://www.youtube.com/watch?v=agnblS47F18
 * http://stackoverflow.com/questions/194698/how-to-load-a-jar-file-at-runtime
 * Core Java Volume I Fundamentals Eigth Edition page 222-224*/
import java.util.*;
import java.lang.reflect.*;
import java.io.*;
import java.net.*;

public class Information {
	public Information (String jar, String methodsClass){
		try {
			File file = new File(jar);
			URL url = file.toURL();
			URL[] urls = new URL[] {url};
			ClassLoader cl = new URLClassLoader(urls);
			Class cls = cl.loadClass(methodsClass);
		}
		catch (NoClassDefFoundError e) {
			e.printStackTrace();
			System  .exit(-6);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkForFunction(String className, String methodName) throws Exception{
		List<Method> ms = Arrays.asList(Class.forName(className).getMethods());
		for (Method m : ms) {
			if (m.getName().equals(methodName)) {
				System.out.println("The method exists");
				return true;
			}
		}
		return false;
	}//end method
}
