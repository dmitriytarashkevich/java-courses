/**
 * Created by dmitr on 29.04.2016.
 */
public class Comment {
    public static void main(String[] args) {
        TextAnalyzer b = new SpamAnalyzer(new String[] {"first","second"});
        TextAnalyzer a = new NegativeTextAnalyzer();
        TextAnalyzer c = new TooLongTextAnalyzer(40);
        System.out.println(checkLabels(new TextAnalyzer[]{a, b, c}, "this is =( first test, and it is spam"));
    }
    //order of result SIGNS depends on order of incoming analyzers
    /*
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
     */
    // order of result SIGNS: SPAM->NEGATIVE_TEXT->TOO_LONG
    public static String checkLabels(TextAnalyzer[] analyzers, String text){
        Label returnable = Label.OK;
        for (TextAnalyzer a: analyzers
             ) {
            if (a.processText(text)!=Label.OK) {
                if (a.processText(text) == Label.SPAM) {
                    returnable = a.processText(text);
                    break;
                } else {
                    if (a.processText(text) == Label.NEGATIVE_TEXT && returnable != Label.SPAM) {
                        returnable = a.processText(text);
                    } else {
                        if (a.processText(text) == Label.TOO_LONG && returnable != Label.SPAM && returnable != Label.NEGATIVE_TEXT) {
                            returnable = a.processText(text);
                        }
                    }
                }
            }
        }
        return returnable.toString();
    }
}
