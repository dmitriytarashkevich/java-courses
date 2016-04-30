/**
 * Created by dmitr on 29.04.2016.
 */
public class NegativeTextAnalyzer extends KeywordAnalyzer{
    @Override
    protected String[] getKeywords() {
        return new String[]{":(", ":|", "=("};
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
