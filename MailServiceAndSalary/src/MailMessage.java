/**
 * Created by Dmitry Tarashkevich on 28.05.2016.
 */
public class MailMessage extends Sendable<String>{

    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}
