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
        InputStream stream = new ByteArrayInputStream( new byte[] {13,10,10,13,10,13});
        replaceLineSeparator(stream);
    }

    private static void replaceLineSeparator(InputStream stream) throws IOException {
        int prev = stream.read();
        if (prev == -1) return; //empty stream -> exit
        int curr = stream.read();
        while (curr != -1) {
//            if (prev == 13 && curr == 10) {
//                prev = 10; //"previous" becomes 10 and is going to be written in else-block
//                curr = stream.read();
//            } else {
//                System.out.write(prev);
//                prev = curr;
//                curr = stream.read();
//            }
            // this part of code may be simplified
            // because if-block differs from else-block only in writing prev in else-block
            if (prev != 13 || curr != 10) System.out.write(prev);
            prev = curr;
            curr = stream.read();
        }
        System.out.write(prev); // write last
        System.out.flush();
    }
}