/** 
 * Class: EncryptionTest
 * @author payman
 *
 * This class is a test for classes PrivateEncryption, Ciphertext, Plaintext
 * This is just some sample tests. You should add more test if you need to. 
 */


public class EncryptionTest {

	
	public static void main(String[] args) {
		
		/* Test the two constrcuctors for PrivateEncryption */
		PrivateEncryption schemeOne, schemeTwo;
		schemeOne = new PrivateEncryption();
		schemeTwo = new PrivateEncryption(0,4);
		
		/* Test methods for changing keys */
		schemeOne.changeShiftKey(3);
		schemeTwo.changeRowLength(5);
		
		/* Test the three constructors for Plaintext */
		Plaintext ptxt0, ptxt1, ptxt2, ptxt3, ptxt4;
		ptxt1 = new Plaintext("ships are sinking abort the mission, and pull the troops out");
		ptxt2 = new Plaintext();
        ptxt2.setMessage("Oops i fired the missles");
	    ptxt0 = new Plaintext(ptxt2);
	    
	    /* test setMessage */
	    ptxt2.setMessage("No the missles were not fired");
	    
        Ciphertext ctxt1, ctxt2;
       
        /* test ciphertext copy constructor */
        /* also test the two encryption methods */
        ctxt1 = new Ciphertext(schemeOne.encryptShift(ptxt1));
        ctxt2 = new Ciphertext(schemeTwo.encryptRow(ptxt1));
        
        /* test toString for Plaintext and Ciphertext */
        System.out.println("Shift Encryption of " + ptxt1 + " is " + ctxt1);
        System.out.println("Password Encryption of " + ptxt1.getMessage() + " is " + ctxt2);
        
        
        /* test the two decryption methods */
        ptxt3 = new Plaintext(schemeOne.decryptShift(ctxt1));
        ptxt4 = new Plaintext(schemeTwo.decryptRow(ctxt2));
        System.out.println("Shift decryption of " + ctxt1 + " is " + ptxt3);
        System.out.println("Password Encryption of " + ctxt2 + " is " + ptxt4);
       
	}


}
