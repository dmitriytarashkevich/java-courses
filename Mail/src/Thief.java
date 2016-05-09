/**
 * Created by dmitr on 08.05.2016.
 */

/*Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал.
Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую,
такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".*/


public class Thief implements MailService{
    int minValue;
    int stolenValue;

    Thief (int minValue){
        this.minValue = minValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage && ((MailPackage) mail).getContent().getPrice()>=this.minValue){
            MailPackage mailPackage = (MailPackage) mail;
            this.stolenValue+=mailPackage.getContent().getPrice();
            MailPackage stones = new MailPackage(mail.getFrom(),mail.getTo(), new Package("stones instead of " + mailPackage.getContent().getContent(),0));
            return stones;
        } else {
            return mail;
        }
    }
    public int getStolenValue(){
        return stolenValue;
    }
}
