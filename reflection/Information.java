import java.util.*;   
import java.lang.reflect.*;   
       

public class Information   {   
	public static void main(String[] args) {   
    // read class name from command line args and if args is empty prompt user input   
	String name;
	if (args.length > 0)
		name = args[0];   
	else  {   
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your project prefix ");
		name = in.next();   
	}   
       
	try  {   
		// print class name and superclass name (if != Object)   
		Class cl = Class.forName(name);   
		System.out.println("The project prefix: " + name);
		printMethods(cl);   
   
	}   
	catch (ClassNotFoundException e)  {   
		e.printStackTrace();   
	} 
	catch (Exception e) {
		e.printStackTrace();  
	}  
	System.exit(0);   
}//end of main   
	public static void printMethods(Class cl)   {   
		Method[] methods = cl.getDeclaredMethods();   
		for (Method m : methods)   {   
			Class retType = m.getReturnType();   
            String name = m.getDeclaredMethods();   
			System.out.println("The name of the method " + name);
  
       
            // print parameter types   
            Class[] paramTypes = m.getParameterTypes();   
            for (int j = 0; j < paramTypes.length; j++)   {    
                System.out.println(paramTypes[j].getName());   
            }   
            
		}   
	}//end of method   
  }
/*
javac "Information.java" (in directory: /home/mr-fool/Documents)
Information.java:36: error: cannot find symbol
            String name = m.getDeclaredMethods();
                           ^
  symbol:   method getDeclaredMethods()
  location: variable m of type Method
1 error
Compilation failed.

*/
