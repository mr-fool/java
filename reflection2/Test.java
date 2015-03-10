public class Test {
	public static void main(String[] args) throws Exception{
		Information information = new Information("/home/mr-fool/Documents/JFLAP.jar","JFLAP.class");
		information.printAllFunction("JFLAP.class");
	}//end main
}
/*
java Test.java
Error: Could not find or load main class Test.java
*/
