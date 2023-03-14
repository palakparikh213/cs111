/*************************************************************************
 *  Compilation:  javac RunLengthEncoding.java
 *  Execution:    java RunLengthEncoding
 *
 *  @author:
 *
 *************************************************************************/

public class RunLengthEncoding {

    /* 
     * Encode the original string by finding sequences in the string
     * where the same character repeats. Replace each such sequence
     * by a token consisting of: the number of characters in the sequence
     * followed by the repeating character.
     * Return the encoded string.
     */
    public static String encode (String original)  {
    int n=0;
    int countChars=1;
    StringBuilder encodedString = new StringBuilder();
    char[]x=original.toCharArray();
    while (true){
        if (n == x.length - 1) {
            if (countChars == 1) {
                encodedString.append(x[n]);
            }
            else{
                encodedString.append(Integer.toString(countChars) + x[n]);
            }
            break;
        }
        if (x[n] == x[n+1]){
            countChars++;
        }
        else{
            if (countChars == 1){
                encodedString.append(x[n]);
            } else{
                encodedString.append(Integer.toString(countChars) + x[n]);
                countChars = 1;
            }
        }
        n++;
    }
    return (encodedString.toString());
}


    public static String decode (String original)  {
    
        {
            StringBuilder decoderString = new StringBuilder();
            char[] y = original.toCharArray();
            decoder(y, 0, decoderString);
            //return the decoded string
            return decoderString.toString();
        }
    }
    public static void decoder(char[] strData, int n, StringBuilder decoderString)
    {
        // base case
        if (n >= strData.length)
            return;
        if (strData[n] == '0'){
            n += 2;
            if (n >= strData.length)
                return;
        }
        if (!Character.isDigit(strData[n])){
            if (n >= strData.length)
                return;
            decoderString.append(strData[n]);
            n++;
            // call recursion
            decoder(strData, n, decoderString);
        } else{
            if (n >= strData.length)
                return;
            decoderString.append(strData[n + 1]);
            strData[n]--;
            // call recursion
            decoder(strData, n, decoderString);
        }
    }
    public static void main (String[] args) {
       String test = "qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT";
       System.out.println("Original string: " + test);
       System.out.println("Encoded string : " + encode(test));
       System.out.println("Decoded string : " + decode(encode(test)));
    }
}
