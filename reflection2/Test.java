public class Test {
	public static void main(String[] args) throws Exception{
		Information information = new Information("/home/mr-fool/Documents/JFLAP.jar","org/apache/batik/bridge/PaintBridge");
		information.printAllFunction("org/apache/batik/bridge/PaintBridge");
	}//end main
}
/*
java.lang.NoClassDefFoundError: IllegalName: org/apache/batik/bridge/PaintBridge
	at java.lang.ClassLoader.preDefineClass(ClassLoader.java:654)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:758)
	at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
	at java.net.URLClassLoader.defineClass(URLClassLoader.java:455)
	at java.net.URLClassLoader.access$100(URLClassLoader.java:73)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:367)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:361)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.net.URLClassLoader.findClass(URLClassLoader.java:360)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at Information.<init>(Information.java:17)
	at Test.main(Test.java:3)
*/
