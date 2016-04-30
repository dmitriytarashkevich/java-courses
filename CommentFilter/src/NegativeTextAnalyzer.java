/**
 * Created by dmitr on 29.04.2016.
 */
public class NegativeTextAnalyzer extends KeywordAnalyzer{
    @Override
    String[] getKeywords() {
        return new String[]{":(", ":|", "=("};
    }

    @Override
    Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
