
public class Plaintext {

	private String message;	
	
	/* 
	 * set the message to empty string
	 */
	public Plaintext()
	{
		this.message = "";
	}
	
	/* 
	 * initialize the message to string m.
	 */
	public Plaintext(String m)
	{
		message = m ;
	}
	
	
	/*
	 * another constructor: copy the String from p to the message
	 */
	public Plaintext (Plaintext p)
	{
		message  = p.getMessage();
	}
	
	
	/* 
	 * it returns the message as a String. to be used by println
	 *
	 */
	public String toString()
	{
		return (message);
	}
	
	/* set message to m. note that m is of type String not StringBuffer */
	public void setMessage(String m)
	{
		message = m;
	}

	/*
	 * return the message stored in Plaintext instance;
	 */
	public String getMessage()
	{
		return (this.message);
	}
	
	public int length()
	{
		return message.length();
	}
	public char charAt(int length)
	{
		return (this.message.charAt(length));
	}
}

