public class PPMTriangle extends PPMFigure{
	//Declaring instance variable and initializing it in case of errors
	private int altitude = 0;
	private int vertexRow = 0;
	private int vertexColumn = 0;
	int red,green,blue;
	
	//Default Constructor
	public PPMTriangle(){
		super();
        this.altitude = 1;
        this.vertexRow = 1;
        this.vertexColumn = 1;
	}
	
	//Copy Constructor
	public PPMTriangle(PPMFigure image) {
        super(image);
        this.altitude = 1;
        this.vertexRow = 1;
        this.vertexColumn = 1;
     }
	//Initializes all the instance variables and draws a right isosceles triangle
	PPMTriangle(int width, int height, String color, int altitude, int vertexRow, int vertexColumn){
		super(width, height, color);
		this.altitude = altitude;
		this.vertexRow = vertexRow;
		this.vertexColumn = vertexColumn;
		Pixel [][] triangle = getPixelArray();
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
		int xAxis = this.vertexColumn;
		int yAxis = this.getHeight()- this.vertexRow;
		
		//Writing changes
		for (int newWidth = 0; newWidth < getWidth(); newWidth++){
			for (int newHeight = 0; newHeight < getHeight(); newHeight++){
				if(((getHeight()-newHeight)== -newWidth + xAxis + yAxis)&&(xAxis <= newWidth) &( newWidth <= xAxis + altitude)){
					triangle[newWidth][newHeight]=new Pixel(red,green,blue);
				}
				else if(((getHeight()-newHeight)== newWidth + yAxis -xAxis)&&(xAxis -altitude <= newWidth)&(newWidth <= xAxis)){
					triangle[newWidth][newHeight]=new Pixel(red,green,blue);
				}	
				else if(((getHeight()-newHeight)== yAxis -altitude)&&(newWidth <= xAxis + altitude)& (newWidth >= xAxis-altitude)){
					triangle[newWidth][newHeight]=new Pixel(red,green,blue);
				}	
			}
		}
	}
	
	public boolean shiftRight(int dist){
		Pixel [][] triangle = getPixelArray();
		if ((altitude + vertexColumn + dist)> getWidth()){
			System.err.println("input out of range");
			return false;
		}
		else {
			this.vertexColumn = vertexColumn + dist;
			String color = getColor();
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
			int xAxis = this.vertexColumn;
			int yAxis = this.getHeight()- this.vertexRow;
			
			//Creating a white page
			for (int height = 0; height < getHeight(); height++){		
				for (int width = 0; width < getWidth();width++){	
					triangle[width][height]= new Pixel(255,255,255);
				}
			}
			
			//Writing changes
			for (int newWidth=0; newWidth < getWidth();newWidth++){
				for (int newHeight = 0; newHeight < getHeight(); newHeight++){
					if(((getHeight()-newHeight)== -newWidth + xAxis +yAxis)&(xAxis <= newWidth)&(newWidth <= xAxis + altitude)){
						triangle[newWidth][newHeight]= new Pixel(red,green,blue);
					}
					else if(((getHeight()-newHeight)== newWidth + yAxis-xAxis)&(xAxis-altitude <= newWidth)&(newWidth <= xAxis)){
						triangle[newWidth][newHeight]= new Pixel(red,green,blue);
					}	
					else if(((getHeight()-newHeight)== yAxis -altitude)&(newWidth<= xAxis + altitude)&(newWidth >= xAxis-altitude)){
						triangle[newWidth][newHeight]= new Pixel(red,green,blue);
					}	
				}
			}
			return true;					
		}
	}
	
	//Method that shift down
	public boolean shiftDown(int dist){
		Pixel [][] triangle = getPixelArray();
		if ((this.altitude + this.vertexRow + dist)> getHeight()){
			System.err.println("out of boundary");
			return false;
		}
		else {
			this.vertexRow = vertexRow + dist;
			String color = getColor();
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
		int xAxis = this.vertexColumn;
		int yAxis = this.getHeight()- this.vertexRow;
			
		//Creating a white page
		for (int height = 0; height < getHeight(); height++){		
			for (int width = 0; width < getWidth();width++){	
				triangle[width][height]= new Pixel(255,255,255);
			}
		}
			
		//Writing changes
		for (int newWidth=0; newWidth < getWidth();newWidth++){
			for (int newHeight = 0; newHeight < getHeight(); newHeight++){
				if(((getHeight()-newHeight)== -newWidth + xAxis +yAxis)&(xAxis <= newWidth)&(newWidth <= xAxis + altitude)){
					triangle[newWidth][newHeight]= new Pixel(red,green,blue);
				}
				else if(((getHeight()-newHeight)== newWidth + yAxis-xAxis)&(xAxis-altitude <= newWidth)&(newWidth <= xAxis)){
					triangle[newWidth][newHeight]= new Pixel(red,green,blue);
				}	
				else if(((getHeight()-newHeight)== yAxis -altitude)&(newWidth<= xAxis + altitude)&(newWidth >= xAxis-altitude)){
					triangle[newWidth][newHeight]= new Pixel(red,green,blue);
				}	
				}
			}
			
			return true;					
		}
	}
	
	//Fill in the triangle
	public void fillIn(String color){
		Pixel [][] triangle = getPixelArray();
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
		int xAxis = this.vertexColumn;
		int yAxis = this.getHeight()- this.vertexRow;
			
		//Creating a white page
		for (int height = 0; height < getHeight(); height++){		
			for (int width = 0; width < getWidth();width++){	
				triangle[width][height]= new Pixel(255,255,255);
			}
		}
		//Drawing the actual thing
		for (int newWidth = 0; newWidth < getWidth();newWidth++){
			for (int newHeight = 0; newHeight < getHeight(); newHeight++){
				if(((getHeight()-newHeight)< -newWidth + xAxis + yAxis -1)&(newWidth < xAxis + altitude-1)&((getHeight()-newHeight)< newWidth + yAxis - xAxis -1)&(xAxis - altitude + 1 < newWidth)&((getHeight()-newHeight)> yAxis-altitude)){
					triangle[newWidth][newHeight]=new Pixel(red,green,blue);
				}
			}
		}		
	}
	//Redraws the triangle by doubling its altitude
	public boolean doubleIt(){
		Pixel [][] triangle = getPixelArray();
		String color = getColor();
		
		//Testing whether or not it can be double or not
		if (((this.altitude * 2) + this.vertexRow)> getHeight()|(this.vertexColumn-(this.altitude * 2)< 0)|(this.vertexColumn +(this.altitude * 2) > getWidth())){
			System.out.println("out of boundary");
			return false;
		}
		else{
			this.altitude = altitude *2;
			
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
		int xAxis = this.vertexColumn;
		int yAxis = this.getHeight()- this.vertexRow;
		
		//Creating a white page
		for (int height = 0; height < getHeight(); height++){		
			for (int width = 0; width < getWidth();width++){	
				triangle[width][height]= new Pixel(255,255,255);
			}
		}
		for (int newWidth = 0; newWidth < getWidth(); newWidth++){
			for (int newHeight = 0; newHeight < getHeight(); newHeight++){
				if(((getHeight()-newHeight)== -newWidth + xAxis + yAxis)& (xAxis <= newWidth)&(newWidth <= xAxis + this.altitude)){
					triangle[newWidth][newHeight]=new Pixel(red,green,blue);
				}
				else if(((getHeight()-newHeight) == newWidth + yAxis-xAxis)& (xAxis - this.altitude <= newWidth)&(newWidth <= xAxis)){
					triangle[newWidth][newHeight]=new Pixel(red,green,blue);
				}	
				else if(((getHeight()-newHeight)== yAxis-altitude)&(newWidth <= xAxis + this.altitude)&(newWidth >= xAxis -this.altitude)){
					triangle[newWidth][newHeight]=new Pixel(red,green,blue);
				}	
			}
		}
			return true;
		}
	}
	//Rotates the triangle 90 degrees clockwise around topmost vertex
	public boolean rotate90(){
		Pixel [][] triangle = getPixelArray();
		if ((this.vertexRow - this.altitude)<0){
			System.err.println("out of boundary");
			return false;
		}
		//change the height and width for the new array 
		String color=getColor();
		//Remove white space
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
		//Creating a white page
		for (int height = 0; height < getHeight(); height++){		
			for (int width = 0; width < getWidth();width++){	
				triangle[width][height]= new Pixel(255,255,255);
			}
		}
		int xAxis = this.vertexColumn;
		int yAxis = this.getHeight()- this.vertexRow;
		for (int newWidth = 0; newWidth < getWidth();newWidth++){
			for (int newHeight = 0; newHeight < getHeight(); newHeight++){
				if(((getHeight()-newHeight)== -newWidth + xAxis + yAxis)&(xAxis >= newWidth)&(newWidth >= xAxis-this.altitude)){
					triangle[newWidth][newHeight]=new Pixel(red,green,blue);
				}
				else if(((getHeight()-newHeight)== newWidth + yAxis -xAxis)&(xAxis >= newWidth)&(newWidth >= xAxis-this.altitude)){
					triangle[newWidth][newHeight]=new Pixel(red,green,blue);
				}	
				else if(((getHeight()-newHeight) >= yAxis-this.altitude)&(newWidth == xAxis-this.altitude)&((getHeight()-newHeight)<= yAxis + this.altitude)){
					triangle[newWidth][newHeight]=new Pixel(red,green,blue);
				}	
			}
		}
		return true;
	}
	
	//Accessor
	public int getAltitude(){
		return this.altitude;
	}
	
	public int getVertexRow(){
		return this.vertexRow;
	}
	
	public int getVertexColumn(){
		return this.vertexColumn;
	}	
	
	//Mutator
	public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
	
	public void setVertexRow(int vertexRow) {
        this.vertexRow = vertexRow;
    }
    
    public void setVertexColumn(int vertexColumn) {
        this.vertexColumn = vertexColumn;
    }
}
