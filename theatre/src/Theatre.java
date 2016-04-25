/**
 * Created by dmitr on 25.04.2016.
 */
public class Theatre {

    public static void main(String[] args) {

        String [] roles= {
                "Городничий","Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textLines={"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        String s = printTextPerRole(roles,textLines);

        System.out.println(s);
    }
    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder printTextPerRole = new StringBuilder();
        for (String role: roles) {
            printTextPerRole.append(role+":"+System.lineSeparator());
            for (int i=0;i<textLines.length; i++) {
                if (textLines[i].startsWith(role + ":")) {
                    printTextPerRole.append((i + 1) + ") " + textLines[i].substring(role.length() + 2) + System.lineSeparator());
                }
            }
            printTextPerRole.append(System.lineSeparator());
        }
        return printTextPerRole.toString();
    }
}
