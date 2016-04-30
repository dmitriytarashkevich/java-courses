/**
 * Created by dmitr on 29.04.2016.
 */
public class Comment {
    public static void main(String[] args) {
        TextAnalyzer a = new SpamAnalyzer(new String[] {"кака","попа"});
        TextAnalyzer b = new NegativeTextAnalyzer();
        TextAnalyzer c = new TooLongTextAnalyzer(40);
        System.out.println(checkLabels(new TextAnalyzer[]{a, b, c}, "попа =( " +
                "ак далуокмгйшпзкгйшьрмп сшумущшкгзмыгlacl;iuer;lquri;quc;oucg;qeou;rcqour;ou;cqur;qeuc"));
    }
    public static String checkLabels(TextAnalyzer[] analyzers, String text){
        String returnable = Label.OK.name();
        for (TextAnalyzer a: analyzers
             ) {
            if (a.processText(text)!=(Label.OK)){
                returnable = a.processText(text).name();
                break;
            }
        }
        return returnable;
    }
}
