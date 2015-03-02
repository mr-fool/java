import java.lang.reflect.*; //contains Java Reflection Model API
import java.awt.*;

class SampleModifier {
	public static void main (String[] args) {
		String s = new String();
		printModifiers(s);
	}
	
	public static void printModifiers(Object o) {
		Class c = o.getClass(); //returns the Class object of o
		int m = c.getModifiers(); //return the class modifiers
		if (Modifier.isPublic(m) ) {// checks if it is public
			System.out.println("public");
		}
		if (Modifier.isAbstract(m) ) {// checks if it is abstract
			System.out.println("abstract");
		}
		if (Modifier.isFinal(m) ) {// checks if it is final
			System.out.println("final");
		}
	}
}
