/**
 * Created by dmitr on 12.05.2016.
 */
import java.io.*;

public class CheckSumInputStream {

    public static void main(String[] args) throws IOException {
        InputStream stream;
        int result;
        stream = getStream( new byte[] { 0x33, 0x45, 0x01});

        result = checkSumOfStream(stream);
        System.out.print(result);
    }

    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream (data);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int checkSum = 0;
        while (read>0){
            checkSum = Integer.rotateLeft(checkSum,1)^read;
            read = inputStream.read();
        }
        return checkSum;
    }

}
