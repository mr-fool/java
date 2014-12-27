public class Rational
{
	//declaring variables 
	
	private int numerator = 0; //initialization in case of weird error
	private int denominator = 0; //initialization in case of weird error
	
	public Rational (int num, int denomin)
	{
		this.numerator = num;
		this.denominator = denomin;
		//System.out.println(this.numerator +"/"+this.denominator);
	}
	
	public Rational (int wholeNumber)
	{
		this.denominator = 1;
		this.numerator = wholeNumber;
		//System.out.println(this.numerator +"/"+this.denominator);

	}
	
	public Rational ()
	{
		this.numerator = 0;
		this.denominator = 1;
		//System.out.println(this.numerator +"/"+this.denominator);

	}
	
	public int getNumerator()
	{
		return (this.numerator);
	}
	
	public int getDenominator()
	{
		return (this.denominator);
	}
	
	public void setNumerator(int numerator)
	{
		this.numerator = numerator;
	}
	
	public void setDenominator(int denominator)
	{
		this.denominator = denominator;
	}
	
	public boolean equals (Rational rationalNumber2)
	{
		int firstStep = this.getNumerator() * rationalNumber2.getDenominator();
		int secondStep = this.getDenominator() * rationalNumber2.getNumerator();
		if ( firstStep == secondStep )
			{
			//System.out.print("input 1 equals to input 2\n");
			return true; // no idea why we need it
			}
		else 
		{
			//System.out.print("input 1 does not equal to input 2\n");
			return false;
		}
	} 
	
	public String toString()
	{
		String number = String.valueOf(getNumerator() )+ "/ "+ String.valueOf(getDenominator() ); 
		return (number); //no idea why we need it
	}
	
	public static Rational add(Rational rationalNumber1, Rational rationalNumber2)
	{
		if (rationalNumber1.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		if (rationalNumber2.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		int finalDenominator = (rationalNumber1.getDenominator() * rationalNumber2.getDenominator() );
		int rationalNumber1Numerator =  (rationalNumber1.getNumerator() * rationalNumber2.getDenominator() );
		
		int rationalNumber2Numerator =  (rationalNumber2.getNumerator() * rationalNumber1.getDenominator() );
		
		int sum =   rationalNumber1Numerator + rationalNumber2Numerator;
		Rational additionResult = new Rational(sum, finalDenominator);
		return (additionResult);
	}
	
	public static Rational subtraction(Rational rationalNumber1, Rational rationalNumber2)
	{
		if (rationalNumber1.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		if (rationalNumber2.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		int finalDenominator = (rationalNumber1.getDenominator() * rationalNumber2.getDenominator() );
		int rationalNumber1Numerator =  (rationalNumber1.getNumerator() * rationalNumber2.getDenominator() );
		
		int rationalNumber2Numerator =  (rationalNumber2.getNumerator() * rationalNumber1.getDenominator() );
		
		int subtraction =   rationalNumber1Numerator - rationalNumber2Numerator;
		Rational subtractionResult = new Rational(subtraction, finalDenominator);
		return (subtractionResult);
	}
	
	public static Rational multiplication(Rational rationalNumber1, Rational rationalNumber2)
	{
		if (rationalNumber1.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		if (rationalNumber2.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		int finalDenominator = rationalNumber1.getDenominator() * rationalNumber2.getDenominator() ;
		int finalNumerator  =  rationalNumber1.getNumerator() * rationalNumber2.getNumerator();
		Rational multiplicationResult = new Rational(finalNumerator, finalDenominator);
		return (multiplicationResult);
	}
	
	public static Rational division(Rational rationalNumber1, Rational rationalNumber2)
	{
		if (rationalNumber1.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		if (rationalNumber2.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		int finalDenominator = rationalNumber1.getDenominator() * rationalNumber2.getNumerator() ;
		int finalNumerator  =  rationalNumber1.getNumerator() * rationalNumber2.getDenominator();
		Rational divisionResult = new Rational(finalNumerator, finalDenominator);
		return (divisionResult);
	}
	
	public Rational add(Rational rationalNumber)
	{
		if (this.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		if (rationalNumber.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		int finalDenominator = (this.getDenominator() * rationalNumber.getDenominator() );
		int rationalNumber1Numerator =  (this.getNumerator() * rationalNumber.getDenominator() );
		
		int rationalNumber2Numerator =  (rationalNumber.getNumerator() * this.getDenominator() );
		
		int sum =   rationalNumber1Numerator + rationalNumber2Numerator;
		Rational additionResult2 = new Rational(sum, finalDenominator);
		return (additionResult2);
	}
	
	public Rational subtraction(Rational rationalNumber)
	{
		if (this.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		if (rationalNumber.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		int finalDenominator = (this.getDenominator() * rationalNumber.getDenominator() );
		int rationalNumber1Numerator =  (this.getNumerator() * rationalNumber.getDenominator() );
		
		int rationalNumber2Numerator =  (rationalNumber.getNumerator() * this.getDenominator() );
		
		int subtraction =   rationalNumber1Numerator - rationalNumber2Numerator;
		Rational subtractionResult2 = new Rational(subtraction, finalDenominator);
		return (subtractionResult2);
	}
	
	public Rational multiplication(Rational rationalNumber) 
	{
		if (this.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		if (rationalNumber.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		int finalDenominator = this.getDenominator() * rationalNumber.getDenominator() ;
		int finalNumerator  =  this.getNumerator() * rationalNumber.getNumerator();
		Rational multiplicationResult2 = new Rational(finalNumerator, finalDenominator);
		return (multiplicationResult2);
		}
	
	public Rational division(Rational rationalNumber)
	{
		if (this.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		if (rationalNumber.getDenominator() == 0)
		{
			System.out.print("Invalid Denominator Input");
			System.exit(0);
		}
		
		int finalDenominator = this.getDenominator() * rationalNumber.getNumerator() ;
		int finalNumerator  =  this.getNumerator() * rationalNumber.getDenominator();
		Rational divisionResult2 = new Rational(finalNumerator, finalDenominator);
		return (divisionResult2);
	}
	public void normalize(){
		// If the denominator is negative
		if (denominator < 0){
			// Multiple both numerator and denominator by -1
			numerator *= -1;
			denominator *= -1;
		}
	}
	public void reduce() {
	
	//Creating a copy of numerator and denominator to work with
	int num = this.numerator;
	int denom = this.denominator; 
	
	//Calculating gcd
	while (denom != 0) {
	int times = denom;
	denom = num % denom;
	num = times;
	} 
	
	int gcd = num;
	//Setting the result
	this.numerator = this.numerator/ gcd;
	this.denominator = this.denominator/ gcd;
	}
	
	public void reduce(Rational rationalNumber) {
	
	//Creating a copy of numerator and denominator to work with
	int num = rationalNumber.numerator;
	int denom = rationalNumber.denominator; 
	
	//Calculating gcd
	while (denom != 0) {
	int times = denom;
	denom = num % denom;
	num = times;
	} 
	
	int gcd = num;
	//Setting the result
	rationalNumber.numerator = rationalNumber.numerator/ gcd;
	rationalNumber.denominator = rationalNumber.denominator/ gcd;
	}
}
