public class  PPMSquare extends PPMRectangle{
	//Default constructor
	public PPMSquare(){
		super();
	}
	
	//Copy constructor
	public PPMSquare(PPMSquare image ){
		super(image);
	}
	
	//Drawing the square
	public PPMSquare(int width, int height, String color, int rectangleHeight, int rectangleWidth, int thickness, int startRow, int startColumn) {
        super(width, height, color, rectangleHeight, rectangleWidth, thickness, startRow, startColumn);
        if(rectangleHeight!=rectangleWidth){
			System.exit(-1);
        }

                
   }
	
	
	
}
