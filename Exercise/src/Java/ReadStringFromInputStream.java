package Java;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by dmitr on 14.05.2016.
 */

// метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

public class ReadStringFromInputStream {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 48,49,50,51});
        Charset charset = StandardCharsets.US_ASCII;
        System.out.println(readAsString(inputStream,charset));

    }
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        char symbol;
        int readedInt;
        StringBuilder aimString = new StringBuilder();
        Reader reader = new InputStreamReader(inputStream, charset);
        while ((readedInt = reader.read())!=(-1)){
            symbol = (char) readedInt;
            System.out.println(symbol);
            aimString.append(symbol);
        }
        return aimString.toString();
    }
}

