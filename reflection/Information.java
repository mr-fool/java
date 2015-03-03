import java.util.*;
import java.lang.reflect.*;

public class Information {
	public static void main(String[] args) {
		// read class name from command line args and if args is empty prompt
		// user input
		String name;
		if (args.length > 0)
			name = args[0];
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter your project prefix ");
			name = in.next();
		}

		try {
			// print class name and superclass name (if != Object)
			Class cl = Class.forName(name);
			System.out.println("The project prefix: " + name);
			ArrayList<String> methodList = new ArrayList<String>();
			methodList = methods(cl);
			/*for(String tmp: methodList) { 
				System.out.println("method list " + tmp); 
			}*/
			methodReturnType("equal");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	} // end of main

	public static ArrayList<String> methods(Class cl) {
		ArrayList<String> methodList = new ArrayList<String>();
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods) {
			Class retType = m.getReturnType();
			String name = m.getName();
			// System.out.println("The name of the method " + name);
			methodList.add(name);
			// print parameter types
			/*Class[] paramTypes = m.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++)
				System.out.println(paramTypes[j].getName()); */
		}
	return methodList;
	}// end of method
	public static void methodReturnType(Method type) {
		Class retType = type.getReturnType();
		System.out.println("The return type is " + retType.getName());
	}
}
/*javac "Information.java" (in directory: /home/mr-fool/Documents)
Information.java:26: error: incompatible types: String cannot be converted to Method
			methodReturnType("equal");
			                 ^
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
1 error
Compilation failed.
*/
