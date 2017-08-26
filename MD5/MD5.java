import java.security.*;
import java.math.*;
import java.io.BufferedReader;
import java.io.InputStreamReader; 

public class MD5 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());
        //System.out.println("String s = " + s);
        System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
    }
}
