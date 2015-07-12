//Importing
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public abstract class PPMFigure {
	// Constants
	private static final int DEFAULT_MAX_VAL = 255;
	private static final String DEFAULT_HEADER = "P3";
	
	
	//Declaring instance variable and initializing it in case of errors
	private int width = 0;			
	private int height = 0;	
	private String color = " ";
	private int maxVal;
	private Pixel[][] image = new Pixel[0][0];
	
	//RGB color 
	int red = 0;
	int green = 0;
	int blue = 0;
	
	//Accessors 
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public Pixel[][] getPixelArray(){
		return image;
	}
	
	public String getColor(){
		return color;
	}
	
	//Mutator
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	//Initializes all the instance variable to their zero
	public PPMFigure(){
		
		this.width = 0;
		this.height = 0;
		//Setting color to white
		this.color = ("255 255 255 ");
		this.maxVal = DEFAULT_MAX_VAL;
		//Setting the dimension of the array
		image = new Pixel[width][height];	
	}
	
	//Copy constructor which needs to copy one image to another
	public PPMFigure(PPMFigure i){
		this.width = i.width; 
		this.height = i.height;
		this.maxVal = i.maxVal;
		image=i.getPixelArray(); 
	}	
	
	//Initializes the dimensions using width and height, and the color of the figure using the parameter
	//color. It initializes all the pixels to white
	public PPMFigure (int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
		this.maxVal = DEFAULT_MAX_VAL;
		image=new Pixel[this.width][this.height];
		
		//Creating a white page
		for (int row =0; row < this.height; row++){		
			for (int column = 0; column < width; column++){	
				image[column][row]= new Pixel(255,255,255);
			}
		}
	}
	
	//Outputs the image in the PPM format into a file called outputfile
	public void writeImage( String filename){
		PrintWriter file = null; 
		// initialize print writer
		try{
			file = new PrintWriter(new FileOutputStream(filename,true));
			// write meta data
			file.println(DEFAULT_HEADER);													
			file.println(width +" "+ height);	
			file.println(DEFAULT_MAX_VAL);
			// Loop through pixels
			for (int row = 0; row < this.height; row++){				
				for (int column = 0; column < this.width; column++){			
					// get current pixel, and write to the print writer
					file.print(image[column][row].getRed()+" "+image[column][row].getGreen()+" "+image[column][row].getBlue()+" ");
				}
				// next line
				file.println();
			}
			file.close();
		}
		//Handle Exception
		catch(FileNotFoundException e){
			System.err.println("File Not Found");
			System.exit(0);
		}
		catch(Exception e){
			System.err.println("Murply's Law");
			System.exit(0);
		}

	}
	
	//Takes a color as parameter and changes the color of the figure
	//The color of the figure is only the color of the pixels
	public void changeColor(String color){
		
		Pixel [][] rectangle = getPixelArray();
		this.color=color.trim();
		
		//Seting RGB
		if (color.equalsIgnoreCase("red") ){
			red = 255;
			green = 0;
			blue = 0;
		}
		else if (color.equalsIgnoreCase("green") ){
			red = 0;
			green = 255;
			blue = 0;
		}
		else if (color.equalsIgnoreCase("blue") ){
			red = 0;
			green = 0;
			blue = 255;
		}
		else if (color.equalsIgnoreCase("black") ){
			red = 0;
			green = 0;
			blue = 0;
		}	
		else {
			System.err.println("Wrong color or Murply's Law");
		}
		
		// Loop through pixels
		for (int row = 0;row < height; row++){		
			for (int column = 0; column < width; column++){	
				
				//create a white page
				if ((rectangle[column][row].getRed()==255)&&(rectangle[column][row].getGreen()==255)&&(rectangle[column][row].getBlue()==255)){
					rectangle[column][row]=new Pixel(red,green,blue);
				}
			}
		}	
	} 
	
	//Declaring abstract methods
	
	/*This method fills in the figure in the image using the color passed as parameter. 
	 * In other words, it changes the color for all the pixels inside the figure*/
	public abstract void fillIn(String color);
	
	/*This method doubles the size of the figure. It returns false if doubling the figure will
	 * make the figure go beyond the boundaries of the image. */
	public abstract boolean doubleIt();
	
	//Rotate 90
	public abstract boolean rotate90();
	
	/*This method will try to shift the figure inside the image dist pixels to the right.
	 * If this forces the figure to go beyond the boundaries of the image, the method does not excute the shift
	 * and instead returns false. If the shift is successful, it returns true.*/
	public abstract boolean shiftRight(int dist);
	
	/*This method will try to shift the figure inside the image dist pixels to the down.
	 * If this forces the figure to go beyond the boundaries of the image, the method does not excute the shift
	 * and instead returns false. If the shift is successful, it returns true.*/
	public abstract boolean shiftDown(int dist);
}
