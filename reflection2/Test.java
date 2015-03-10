public class Test {
	public static void main(String[] args) throws Exception{
		Information information = new Information("/home/mr-fool/Documents/JFLAP.jar","org/apache/batik/bridge/PaintBridge.class");
		information.printAllFunction("org/apache/batik/bridge/PaintBridge.class");
	}//end main
}
/*
java Test
java.lang.ClassNotFoundException: org/apache/batik/bridge/PaintBridge.class
	at java.net.URLClassLoader$1.run(URLClassLoader.java:372)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:361)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.net.URLClassLoader.findClass(URLClassLoader.java:360)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at Information.<init>(Information.java:17)
	at Test.main(Test.java:3)
Exception in thread "main" java.lang.ClassNotFoundException: org/apache/batik/bridge/PaintBridge.class
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:260)
	at Information.printAllFunction(Information.java:38)
	at Test.main(Test.java:4)

*/
