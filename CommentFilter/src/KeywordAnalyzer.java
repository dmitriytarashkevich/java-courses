/**
 * Created by dmitr on 29.04.2016.
 */
public abstract class KeywordAnalyzer implements TextAnalyzer {

    abstract String[] getKeywords();

    abstract Label getLabel();

    @Override
    public Label processText(String text) {
        Label returnable = Label.OK;
        for (String s: this.getKeywords()){
            if (text.contains(s)) {
                returnable = this.getLabel();
                break;
            }
        }
        return returnable;
    }
}
