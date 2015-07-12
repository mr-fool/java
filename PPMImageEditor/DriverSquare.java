import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DriverSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PPMSquare(int width, int height, String color, int rectangleHeight, int rectangleWidth, int thickness, int startRow, int startColumn)
		PPMSquare square=new PPMSquare(400, 300, "red", 80, 80, 1, 20, 20);
		square.writeImage("square.ppm");
		
		if(comparePixelArray(square.getPixelArray(),readImage("rSquare.ppm")))
			;
		else
			System.out.println("Square is not successfully created");
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
