import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>>{

    private Map<String, List<T>> mailBox = new HashMap<String, List<T>>(){

        @Override
        public List<T> get(Object key) {
            if(this.containsKey(key)){
                return super.get(key);
            } else {
                return Collections.<T>emptyList();
            }
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Sendable<T> sendable) {
        List<T> listOfContent = mailBox.get(sendable.getTo());
        if (listOfContent.isEmpty()) {
            listOfContent = new ArrayList<T>();
        }
        listOfContent.add(sendable.getContent());
        mailBox.put(sendable.getTo(), listOfContent);
    }
}
