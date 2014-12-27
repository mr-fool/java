
public class PrivateEncryption 
{
	/* shiftKey is used for encryptShift
	 * It is an intger between 1 and 26
	 **/
	public int shiftKey;
	
	/* 
	 * rowLength is used in encryptRow
	 * It is an integer between 2 an 10
	 **/
	public int rowLength;
	
    /* default constructor
     * initializes shiftKey to a random integer between 1 and 26.
     * initializes rowLength to a random integer between 2 and 10. 
    **/
	
    public PrivateEncryption()
    {
		int shiftKey = 1 +(int) (Math.random() * 26);
		int rowLength = 2 +(int) (Math.random() * 10);
    }
    
    /* initializes shiftKey to key. 
     * Initializes rowLegnth to row
     */ 
    public PrivateEncryption(int key, int row)
		{
			this.shiftKey = key;
   
			this.rowLength = row;
		}
    public String toString()
		{
			String str = ("shiftkey=" +shiftKey+ "rowLength =" + rowLength);
			return str;
		}
		
	   /* change shiftKey to key. Check to make sure key is in valid range */ 
    public void changeShiftKey(int key)
		{
			if ( (key >= 1 ) && (key <= 26) )
				{
					this.shiftKey = key;
				}
			else 
				{
					System.out.print("System Failure");
				}
			
		}
    /* change rowLength to row. Check that row is in valid range  */
    public void changeRowLength(int row)
    {
    if ( (row >= 2 ) && (row <= 10) )
				{
					this.rowLength = row;
				}
			else 
				{
					System.out.print("System Failure");
				}	
    } 
 
 
    
    /** encrypt plaintext p using the shiftKey
     * It shift each character of p to the right using shiftKey;
     * e.g. if shiftKey=3, "abc" should encrypt to "def".
     * the shift should be cyclic, so if you run out of letters, you need to go back to the beginning.
     * e.g. if shiftKey = 3, "xyz" should encrypt to "abc".
     * the result should be stored in an object of type Ciphertext and returned.
     * */
    public Ciphertext encryptShift(Plaintext p)
    {
		char finalShift = 'a';
		String encrpytion = "";
		Ciphertext encrpytText = new Ciphertext();
		if (shiftKey ==0)
		{
			System.out.println("Error 101");
			System.exit(0);
		}
		for (int length = 0; length < p.length(); length++)
		{
			char letter =  p.charAt(length);
			//System.out.println(letter); 
			 
			int ascii = (int) letter;
	
			//System.out.println("ascii value: "+ascii);
			if ( (ascii >= 97 ) && (ascii <= 122) )
			{
			int	encrpytFinalShift = ascii + shiftKey;
			
			if (encrpytFinalShift > 122)
				{
					encrpytFinalShift = encrpytFinalShift - 26;
				}
			finalShift = (char) encrpytFinalShift;
			//System.out.println(encrpytFinalShift); //for debugging
		
			}
			else if ( (ascii >=65) && (ascii <= 90) )
			{
				finalShift=(char) ascii;
				
			}
			
			else 
			{
				finalShift=(char) ascii;
			}
			
		encrpytion = encrpytion + finalShift;	
		//System.out.println(letter); //for debugging
		encrpytText = new Ciphertext(encrpytion);
		}
	return (encrpytText);
    } 
    /* performs the opposite of the encryptShift
    * The result sould be stored in object of type Plaintext and returned.
    *  */ 
   public Plaintext decryptShift(Ciphertext c)
   {
	  char finalShift = 'a';
		String decryption = "";
		Plaintext decryptText = new Plaintext();
		if (shiftKey ==0)
		{
			System.out.println("Error 101");
			System.exit(0);
		}
		for (int length = 0; length < c.length(); length++)
		{
			char letter =  c.charAt(length);
			//System.out.println(letter); 
			 
			int ascii = (int) letter;
	
			//System.out.println("ascii value: "+ascii);
			if ( (ascii >= 97 ) && (ascii <= 122) )
			{
			int	encrpytFinalShift = ascii - shiftKey;
			
				if (encrpytFinalShift < 97)
				{
					encrpytFinalShift = encrpytFinalShift + 26;
				}
			finalShift = (char) encrpytFinalShift;
			//System.out.println(encrpytFinalShift); //for debugging
		
			}
			else if ( (ascii >=65) && (ascii <= 90) )
			{
				finalShift=(char) ascii;
				
			}
			
			else 
			{
				finalShift=(char) ascii;
			}
			
		decryption = decryption + finalShift;	
		//System.out.println(letter); //for debugging
		decryptText = new Plaintext(decryption);
		}
	return (decryptText);
  }
 /** 
     * First the message is written out in rows of fixed length where the 
     * length is read from rowLength. Then, the columns are read out, one by one
     * starting from the "last column" all the way to the first column. If a column is not
     * completely filled, dont leave spaces in between.
     * For example: if rowLength = 3, we encrypt p = "abcdefgh", by first writing it out
     * abc
     * def
     * gh-
     * 
     * then reading again
     * "cfbehadg"
     * */
	public Ciphertext encryptRow(Plaintext p)
    {
		Ciphertext cipherText = new Ciphertext();
		String block = "";
		if (rowLength == 0)
		{
			System.out.println("rowLength underflow");
			System.exit(0);
		}
	 
		
		for (int control = rowLength -1 ; control >= 0; control--)
		{
			for (int secondControl = 0; secondControl < (p.length() - control + (rowLength -1) )/rowLength; secondControl++)
			{
				//String message = p.getMessage();
				//System.out.println("p length"+p.length());
				//System.out.println((control + rowLength) * secondControl);
				block = block + (p.getMessage().charAt(control + rowLength *secondControl));
				 cipherText = new Ciphertext(block);
			}
		}
		return (cipherText); //runtime error
    }
	public Plaintext decryptRow(Ciphertext p)
	// the only way I can solve it is by array so...
      {
                Plaintext decipherText = new Plaintext();
                String block = "";
				int numRows = (p.length() + this.rowLength - 1) / this.rowLength ;
                int padding = (this.rowLength  * numRows) - p.length(); //in case of space
                int index = 0;
                      char[][] resultArray = new char[numRows][rowLength]; //creating array
               
               
                for (int col = rowLength - 1 ; col >= 0  ; col --)
                        for(int row = 0 ; row < numRows ; row++)
                        {
                                if (row == numRows-1 && padding > 0)
                                {
                                        padding--;
                                        continue;
                                }
                                resultArray[row][col] = p.charAt(index);
                                index++;
                        }
                        StringBuilder result = new StringBuilder();
                for(int i = 0 ; i < numRows ; i++)
                {
                        result.append(resultArray[i]); //adding on my array
                }
               decipherText = new Plaintext(result.toString());
                return (decipherText);
               
	  }
}
