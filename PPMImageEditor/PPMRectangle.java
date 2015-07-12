/*Limition is the thickness Everything is correct with the exception of thickness
 * Instead of using one method to set color, I just do it in every methods to minimize the risk 
 *of murply's law
 * Basically it is redesign to minimize to murply's law*/
public class PPMRectangle extends PPMFigure{
	
	//Declaring instance variable and initializing it in case of errors
	private int rectangleHeight = 0;
	private int rectangleWidth = 0;
	private int thickness = 0;
	private int startRow = 0;
	private int startColumn = 0;
	
	//Accessor
	public int getRectangleHeight(){
		return rectangleHeight;
	}
	
	public int getRectangleWidth(){
		return rectangleWidth;
	}
	
	public int getThickness(){
		return thickness;
	}	
	
	public int getStartRow(){
		return startRow;
	}
	
	public int getStartColumn(){
		return startColumn;
	}
	
	//Mutator
	public void setRectangleHeight(int height) {
		this.rectangleHeight = height;
	}
	
	public void setRectangleWidth(int width) {
		this.rectangleWidth = width;
	}
	
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	
	public void setStartColumn(int startColumn) {
		this.startColumn = startColumn;
	}
	
	//Default constructor
	public PPMRectangle(){
		super();
        this.rectangleHeight = 1;
		this.rectangleWidth = 1;
        this.thickness = 1;
        this.startRow = 0;
        this.startColumn = 0;
	}
	
	//Copy constructors
	public PPMRectangle(PPMRectangle image) {
        super(image);
        this.rectangleHeight = image.getRectangleHeight();
        this.rectangleWidth = image.getRectangleWidth();
		this.thickness = image.getThickness();
        this.startRow = image.getStartRow();
        this.startColumn = image.getStartColumn();
   }
	
	/* Initializes all the instance variables to the values passed as parameter and draws a rectangle*/
	public PPMRectangle(int width, int height, String color,int rectangleHeight, int rectangleWidth, int thickness, int startRow, int startColumn) {
        super(width,height,"white");
        
        this.rectangleHeight = rectangleHeight;
        this.rectangleWidth = rectangleWidth;
        this.thickness = thickness;
		this.startRow = startRow;
        this.startColumn = startColumn;	
		
		Pixel [][] rectangle = getPixelArray();
		//Removing white space
		color = color.trim();
		
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
			
		
		//Writing those changes
		for (int column = startColumn; column < startColumn+rectangleWidth+1; column++){	
			for(int row = startRow; row < startRow+thickness+1 ; row++)
				rectangle[column][row]= new Pixel(red,green,blue);
		}
		for (int column = startColumn; column < startColumn + rectangleWidth+1;column++){	
			for(int row = startRow+rectangleHeight-thickness; row < startRow+rectangleHeight+1 ; row++)
				rectangle[column][row]= new Pixel(red,green,blue);
		}	
		
		//Setting my 
		for (int column = startColumn; column < startColumn + thickness+1;column++){	
			for(int row = startRow; row < startRow+rectangleHeight+1 ; row++)
				rectangle[column][row]= new Pixel(red,green,blue);
		}
		for (int column = startColumn + rectangleWidth-thickness; column < startColumn+rectangleWidth+1; column++){	
			for(int row = startRow; row < startRow+rectangleHeight+1 ; row++)
				rectangle[column][row]= new Pixel(red,green,blue);
		}
	}
	
	//Methods that shift right
	public boolean shiftRight(int dist){
		Pixel [][] rectangle = getPixelArray();
		if ((this.startColumn + this.rectangleWidth + dist)> getWidth()){
			System.err.println("Out of range");
			return false;
		}
		else {
			startColumn = startColumn + dist;
			String color = getColor();
			color = color.trim(); //Removing space
			
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
		
			//Writing the changes
			for (int height = 0; height < getHeight(); height++){		
				for (int  width = 0;width < getWidth();width++){	
					rectangle[width][height]= new Pixel(255,255,255);
				}
			}
			for (int column = startColumn; column < startColumn+rectangleWidth+1;column++)
				for(int row = startRow; row < startRow + thickness+1 ; row++)
					rectangle[column][row]= new Pixel(red,green,blue);
			}
			for (int column = startColumn; column < startColumn + rectangleWidth+1; column++){
				for(int row = startRow+rectangleHeight-thickness; row < startRow+rectangleHeight+1 ; row++)
					rectangle[column][row]= new Pixel(red,green,blue);
			}	
			
			for (int column = startColumn; column < startColumn + thickness+1;column++){	
				for(int row = startRow; row < startRow+rectangleHeight+1 ; row++)
					rectangle[column][row]= new Pixel(red,green,blue);
			}
			for (int column = startColumn + rectangleWidth-thickness; column < startColumn+rectangleWidth+1;column++){	
				for(int row = startRow; row < startRow+rectangleHeight+1 ; row++)
					rectangle[column][row]= new Pixel(red,green,blue);
			}
			return true;					
		
	}
	//Methods that shift down
	public boolean shiftDown(int dist){
		Pixel [][] rectangle = getPixelArray();
		if ((startRow + rectangleHeight + dist)> getHeight()){
			System.out.println("input out of range");
			return false;
		}
		else {
			this.startRow  = startRow + dist;
			String color = getColor();
			//remove whitespace
			color = color.trim();
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
		
		//Writing the changes
		for (int height = 0; height < getHeight(); height++){		
			for (int  width = 0;width < getWidth();width++){	
				rectangle[width][height]= new Pixel(255,255,255);
			}
		}

		for (int column = startColumn; column < startColumn+rectangleWidth+1;column++) {
			for(int row = startRow; row < startRow + thickness+1 ; row++){
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}
		for (int column = startColumn; column < startColumn + rectangleWidth+1; column++){
			for(int row = startRow+rectangleHeight-thickness; row < startRow+rectangleHeight+1 ; row++) {
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}	
			
		for (int column = startColumn; column < startColumn + thickness+1;column++){	
			for(int row = startRow; row < startRow+rectangleHeight+1 ; row++) {
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}
		for (int column = startColumn + rectangleWidth-thickness; column < startColumn+rectangleWidth+1;column++){	
			for(int row = startRow; row < startRow+rectangleHeight+1 ; row++) {
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}
			return true;					
		}
	}
	
	//Fill in the rectangle
	public void fillIn(String color){
		Pixel [][] rectangle = getPixelArray();
		//remove whitespace
		color = color.trim();
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
		
		//Writing changes
		Pixel innerRectangle = new Pixel(red,green,blue);
		for (int row = startRow+thickness+1; row < startRow + rectangleHeight-thickness; row++){		
			for (int column = startColumn + thickness+1; column < startColumn+rectangleWidth-thickness;column++){
				rectangle[column][row] = innerRectangle;
			}
		}	
		
	}
	
	//Redraws the rectangle by doubling its rectangleWidth and rectangleHeight
	public boolean doubleIt(){
		Pixel [][] rectangle = getPixelArray();
		if ( (((2 * rectangleWidth)+startColumn)>getWidth())|(((2 * rectangleHeight)+startRow)>getHeight())){
			System.out.println("Out of boundary");
			return false;
		}
		else{
			this.rectangleWidth = this.rectangleWidth *2;
			this.rectangleHeight= this.rectangleHeight *2;
			String color = getColor();
			//Removing whitespace
			color = color.trim();
			
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
				
		//Writing the changes
		for (int height = 0; height < getHeight(); height++){		
			for (int  width = 0;width < getWidth();width++){	
				rectangle[width][height]= new Pixel(255,255,255);
			}
		}

		for (int column = startColumn; column < startColumn+rectangleWidth+1;column++) {
			for(int row = startRow; row < startRow + thickness+1 ; row++){
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}
		for (int column = startColumn; column < startColumn + rectangleWidth+1; column++){
			for(int row = startRow+rectangleHeight-thickness; row < startRow+rectangleHeight+1 ; row++) {
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}	
			
		for (int column = startColumn; column < startColumn + thickness+1;column++){	
			for(int row = startRow; row < startRow+rectangleHeight+1 ; row++) {
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}
		for (int column = startColumn + rectangleWidth-thickness; column < startColumn+rectangleWidth+1;column++){	
			for(int row = startRow; row < startRow+rectangleHeight+1 ; row++) {
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}
			return true;
		}
	}
	
	//Rotate the rectangle 90 degrees clockwise around the upper-left corner
	public boolean rotate90(){
		Pixel [][] rectangle = getPixelArray();
		int newStartColumn = startColumn-rectangleHeight;
		if ((newStartColumn < 0)|((startRow + rectangleWidth)>getHeight())){
			System.err.println("rotation error");
			return false;
		}
		
		// replace value of height and width and declare all the variables
		else{
			int newWidth = this.rectangleHeight;
			int newHeight = this.rectangleWidth;
			rectangleWidth = newWidth;
			rectangleHeight= newHeight;
			startColumn = newStartColumn;
			for (int i=0;i < this.getHeight();i++){		//counter of the rows of pixels in the pic
				for (int j=0;j < this.getWidth();j++){	//counter of the column of pixels in the pic
					this.getPixelArray()[j][i]= new Pixel(255,255,255);
				}
			}		
		String color = getColor();
		//Removing whitespace
		color = color.trim();
			
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
					
		for (int column = startColumn; column < startColumn+rectangleWidth+1;column++) {
			for(int row = startRow; row < startRow + thickness+1 ; row++){
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}
		for (int column = startColumn; column < startColumn + rectangleWidth+1; column++){
			for(int row = startRow+rectangleHeight-thickness; row < startRow+rectangleHeight+1 ; row++) {
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}	
			
		for (int column = startColumn; column < startColumn + thickness+1;column++){	
			for(int row = startRow; row < startRow+rectangleHeight+1 ; row++) {
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}
		for (int column = startColumn + rectangleWidth-thickness; column < startColumn+rectangleWidth+1;column++){	
			for(int row = startRow; row < startRow+rectangleHeight+1 ; row++) {
				rectangle[column][row]= new Pixel(red,green,blue);
			}
		}
			return true;
		}	
	}

	
}
