/**
 * Created by dmitr on 29.04.2016.
 */
public class TooLongTextAnalyzer implements TextAnalyzer {

    TooLongTextAnalyzer(int maxLength){
        this.maxLength=maxLength;
    }

    int maxLength;

    @Override
    public Label processText(String text) {
        Label returnable = Label.OK;
        if (text.length()>maxLength){
            returnable = Label.TOO_LONG;
        }
        return returnable;
    }
}
