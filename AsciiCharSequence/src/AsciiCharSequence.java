/**
 * Created by dmitr on 29.04.2016.
 */
//Create new class which will describe sequence of chars as array of bytes
    // Each byte represents char as ASCII code
    //Class override methods of CharSequence
public class AsciiCharSequence implements java.lang.CharSequence {
    byte [] arrayOfChars;
    AsciiCharSequence(byte[] arrayOfChars){
        this.arrayOfChars=arrayOfChars;
    };

    @Override
    public int length() {
        return arrayOfChars.length;
    }

    @Override
    public char charAt(int index) {
        return (char) arrayOfChars[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        byte[] subSeq = new byte[end-start];
        for (int i=0;i<end-start; i++){
            subSeq[i] = arrayOfChars[start+i];
        }
        AsciiCharSequence sub = new AsciiCharSequence(subSeq);
        return sub;
    }

    @Override
    public String toString() {
        char[] charSequence = new char[arrayOfChars.length];
        for (int i=0;i<arrayOfChars.length; i++){
            charSequence[i] = (char) arrayOfChars[i];
        }
        StringBuilder stringSequence = new StringBuilder();
        stringSequence.append(charSequence);
        return stringSequence.toString();

    }
}
