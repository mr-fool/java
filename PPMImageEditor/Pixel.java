public class Pixel {
	//Declaring instance variable
	private int red;
	private int green;
	private int blue;
	private String color = " ";

		
	//Default constructor that sets red, green and blue to 0
	public Pixel(){
		this.red = 0;
		this.green = 0;
		this.blue = 0;
	}

	//Constructor that takes three color number of type int as argument
	public Pixel(int red, int green, int blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	//A copy constructor that does deep copying
	public Pixel (Pixel pixel){
		//Initlize instance variables, perform deep copy
		red = pixel.getRed();
		green = pixel.getGreen();
		blue = pixel.getBlue();
	}

	//Accessor for green
	public int getGreen(){
		return green;
	}
	
	//Accessor for red
	public int getRed(){
		return red;
	}
	//Accessor for blue
	public int getBlue(){
		return blue;
	}
	//Mutator for green
	public void setGreen(int green){
		this.green = green;
	}

	//Mutator for red
	public void setRed(int red){
		this.red = red;
	}

	//Mutator for blue
	public void setBlue(int blue){
		this.blue = blue;
	}
	
	//Mutator set RGB all at once
	public void setColor(int red, int green, int blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	//toString method
	public String toString(){
		// all 3 instance varaibles, separated by spaces
		String str = red + " " + green + " " + blue;
		return str;
	}
	
}
