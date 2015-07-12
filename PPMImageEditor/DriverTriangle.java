import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DriverTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PPMTriangle(int width, int height, String color, int altitude, int vertexRow, int vertexColumn)
				PPMTriangle t1=new PPMTriangle(600,800,"red",80,300,300);
				t1.rotate90();
				t1.writeImage("triangle1.ppm");
				
				if(comparePixelArray(t1.getPixelArray(),readImage("rTriangle1.ppm")))
					;
				else
					System.out.println("Triangle is not successfully rotated");
				
				PPMTriangle t2=new PPMTriangle(600,800,"red",80,200,300);
				t2.doubleIt();
				t2.writeImage("triangle2.ppm");
				
				if(comparePixelArray(t2.getPixelArray(),readImage("rTriangle2.ppm")))
					;
				else
					System.out.println("Triangle is not successfully doubled");
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
