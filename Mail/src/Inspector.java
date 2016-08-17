/**
 * Created by dmitr on 08.05.2016.
 */
public class Inspector implements MailService {


/*Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения, если была обнаружена подобная посылка.
 Если он заметил запрещенную посылку с одним из запрещенных содержимым ("weapons" и "banned substance"), то он бросает IllegalPackageException.
 Если он находит посылку, состаящую из камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException.
 Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.*/


    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage){
            MailPackage mailP = ((MailPackage) mail);
            if (mailP.getContent().getContent().contains("weapons") || mailP.getContent().getContent().contains("banned substance")){
                throw new IllegalPackageException() ;
            } else {
                if (mailP.getContent().getContent().contains("stones")){
                    throw new StolenPackageException();
                }
            }
        }
        return mail;
    }
    class IllegalPackageException extends RuntimeException {
        IllegalPackageException(){}
    }
    class StolenPackageException extends RuntimeException {
        StolenPackageException(){}
    }
}
