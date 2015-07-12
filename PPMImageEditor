import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DriverRectangle{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PPMRectangle(int width, int height, String color, int rectangleHeight, int rectangleWidth, int thickness, int startRow, int startColumn)
		PPMRectangle rect1=new PPMRectangle(400, 300, "red", 80, 200, 1, 20, 20);
		rect1.shiftDown(30);
		rect1.shiftRight(80);
		rect1.fillIn("blue");
		rect1.writeImage("rectangle1.ppm");
		
		if(comparePixelArray(rect1.getPixelArray(),readImage("rRectangle1.ppm")))
			;
		else
			System.out.println("Rectangle is not successfully shifted down/right/filledin");
		
		//this test case doesn't change the figure as manipulation takes it outside the range
		PPMRectangle rect2=new PPMRectangle(400, 300, "black", 80, 200, 1, 100, 60);
		rect2.doubleIt();
		rect2.writeImage("rectangle2.ppm");
	
		if(comparePixelArray(rect2.getPixelArray(),readImage("rRectangle2.ppm")))
			;
		else
			System.out.println("case that rectangle can go outside the image is not handled properly");
		
		
		PPMRectangle rect3=new PPMRectangle(400, 300, "black", 40, 60, 1, 100, 200);
		rect3.doubleIt();
		rect3.writeImage("rectangle3.ppm");
		
		if(comparePixelArray(rect3.getPixelArray(),readImage("rRectangle3.ppm")))
			;
		else
			System.out.println("Rectangle is not successfully doubled");
		
		
		PPMRectangle rect4=new PPMRectangle(400, 300, "black", 40, 60, 1, 100, 200);
		rect4.rotate90();
		rect4.writeImage("rectangle4.ppm");
	
		if(comparePixelArray(rect4.getPixelArray(),readImage("rRectangle4.ppm")))
			;
		else
			System.out.println("Rectangle is not successfully rotated");
	}
	
	public static boolean comparePixelArray(Pixel [][]a,Pixel[][] b){
		if(a.length!=b.length ||a[0].length!=b[0].length)
			return false;
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[0].length;j++){
				Pixel ap=a[i][j];
				Pixel bp=b[i][j];
				if (!(ap.getRed()==bp.getRed()&&ap.getGreen()==bp.getGreen()&&ap.getBlue()==bp.getBlue()))
					return false;
			}
		
		return true;
	}
	public static Pixel[][] readImage(String fname){
		Pixel[][] content;
		Scanner fileIn = null ; // initializes fileIn to empty
		try
		{
			// Attempt to open the file
			fileIn = new Scanner( new FileInputStream(fname));
		}
		catch (FileNotFoundException e)
		{
			// If the file could not be found, this code is executed
			// and then the program exits
			System.out.println("Input File not found.");
			System.exit(0);
		}
		//System.out.println("hello");	
		String magicNumber=fileIn.next();
		int width = fileIn.nextInt();//width
		int height = fileIn.nextInt();//height
	
		int maxColour=fileIn.nextInt();//reading max colour value 255
		content = new Pixel[height][width];
		for(int i = 0; i < height; i++){
			for (int j = 0; j < width; j++)
			{
				int r = fileIn.nextInt();
				
				//image[i][j][0] = 0;
				//fileOut.print(image[i][j][0] + " ");
				int g = fileIn.nextInt();
				//image[i][j][1] = 0;
				//fileOut.print(image[i][j][1] + " ");
				int b = fileIn.nextInt();
				content[i][j]=new Pixel(r,g,b);
				//fileOut.print(image[i][j][2] + " ");
				//int average = (image[i][j][0] + image[i][j][1] +image[i][j][2])/3;
				//image[i][j][0] = 255 - image[i][j][0];
				//image[i][j][1] = average;
				//image[i][j][2] = average;
			}
		}
		fileIn.close();

		
		
		return content;
	}

}
