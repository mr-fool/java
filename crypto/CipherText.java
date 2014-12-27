

public class Ciphertext {

	/* stores the encrypted message */
	private String ctxt;
	
	/*default constructor */
	public Ciphertext()
	{
		ctxt = "";
	}

    /* set ctxt to the string ctxt */
    public Ciphertext(String ctxt)
    {
		this.ctxt= ctxt;
	}

	/* sets ctxt, to ciphertext string of c */
	public Ciphertext(Ciphertext c)
	{
		this.ctxt = c.getCtxt();
	}
	
	/* return the ctxt string as output.
	 * To be used by println 	
     */
	public String toString()
	{
		return (ctxt);
	}
	public void setCtxt(String c)
	{
		this.ctxt = c;
	}

	/*
	 * return the message stored in Plaintext instance;
	 */
	public String getCtxt()
	{
		return (this.ctxt);
	}
	public int length()
	{
		return ctxt.length();
	}
	public char charAt(int length)
	{
		return (this.ctxt.charAt(length));
	}
}


