/*По историческим причинам на разных платформах принят разный способ обозначения конца строки в текстовом файле.
На Unix-системах конец строки обозначается символом с кодом 10 ('\n'),
на Windows — двумя последовательными символами с кодами 13 и 10 ('\r' '\n').

Напишите программу, которая будет преобразовывать переводы строк из формата Windows в формат Unix.
Данные в формате Windows подаются программе в System.in, преобразованные данные должны выводиться в System.out.

Требуется заменить все вхождения пары символов '\r' и '\n' на один символ '\n'.
Если на входе встречается одиночный символ '\r', за которым не следует '\n', то символ '\r' выводится без изменения.

Кодировка входных данных такова, что символ '\n' представляется байтом 10, а символ '\r' — байтом 13.
Поэтому программа может осуществлять фильтрацию на уровне двоичных данных, не преобразуя байты в символы.

Из-за буферизации данных в System.out в конце вашей программы надо явно вызвать System.out.flush().
Иначе часть выведенных вами данных не будет видна проверяющей системе.*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        InputStream stream = new ByteArrayInputStream( new byte[] {13,10,13});
        boolean r = false;
        int read = stream.read();
        while (read!=(-1)) {
            if ((read == 13) && (r == false)) {
                r = true;
                read = stream.read();
            } else {
                if ((read == 10) && (r == true)) {
                    System.out.println(10);
                    r = false;
                    read = stream.read();
                } else {
                    if ((r == true) && (read != 13)) {
                        r = false;
                        System.out.println(13);
                        System.out.println(read);
                        read = stream.read();
                    } else {
                        System.out.println(read);
                        read = stream.read();
                    }
                }
            }
        }
        if (r == true){System.out.println(13);}
        System.out.flush();
    }
}

/*class Main {
    public static void main(String[] args) throws IOException{
        boolean r = false;
        int read = System.in.read();
        while (read!=(-1)) {
            if ((read == 13) && (r == false)) {
                r = true;
                read = System.in.read();
            } else {
                if ((read == 10) && (r == true)) {
                    System.out.write(10);
                    r = false;
                    read = System.in.read();
                } else {
                    if ((r == true) && (read != 13)) {
                        r = false;
                        System.out.write(13);
                        System.out.write(read);
                        read = System.in.read();
                    } else {
                        System.out.write(read);
                        read = System.in.read();
                    }
                }
            }
        }
        if (r == true){System.out.write(13);}
        System.out.flush();
    }
} */
