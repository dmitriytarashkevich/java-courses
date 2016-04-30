/**
 * Created by dmitr on 29.04.2016.
 */
public class SpamAnalyzer extends KeywordAnalyzer{
    private String [] keywords;
    SpamAnalyzer(String[] keywords){
        this.keywords = keywords;
    }
    @Override
    protected String[] getKeywords() {
        return this.keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}
