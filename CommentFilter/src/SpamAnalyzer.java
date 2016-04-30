/**
 * Created by dmitr on 29.04.2016.
 */
public class SpamAnalyzer extends KeywordAnalyzer{
    String [] keywords;
    SpamAnalyzer(String[] keywords){
        this.keywords =keywords;
    }
    @Override
    String[] getKeywords() {
        return this.keywords;
    }

    @Override
    Label getLabel() {
        return Label.SPAM;
    }
}
