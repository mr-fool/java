public class Test {
	public static void main(String[] args) throws Exception{
		Information information = new Information("/home/mr-fool/Documents/JFLAP.jar","org.apache.batik.bridge.PaintBridge");
		information.printAllFunction(Information.cls);
	}//end main
}
