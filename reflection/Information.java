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
			methodReturnType("getName",cl);

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
	public static void methodReturnType(String type, Class cl) throws Exception{
		Class retType = cl.getMethod(type,Object.class).getReturnType();
		System.out.println("The return type is " + retType.getName());
	}
}
/*
java Information
Enter your project prefix 


    java.lang.reflect.Method

The project prefix: java.lang.reflect.Method
java.lang.NoSuchMethodException: java.lang.reflect.Method.getName(java.lang.Object)
	at java.lang.Class.getMethod(Class.java:1778)
	at Information.methodReturnType(Information.java:52)
	at Information.main(Information.java:26)
*/
