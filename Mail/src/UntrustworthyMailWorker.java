/**
 * Created by dmitr on 08.05.2016.
 */


/*UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать почтовый объект непосредственно в сервис почты,
последовательно передает этот объект набору третьих лиц,
 а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
 У UntrustworthyMailWorker должен быть конструктор от массива MailService
 ( результат вызова processMail первого элемента массива передается на вход processMail второго элемента, и т. д.)
 и метод getRealMailService, который возвращает ссылку на внутренний экземпляр RealMailService.*/

public class UntrustworthyMailWorker implements MailService {
    MailService [] thirdFaces;
    RealMailService realMailService;
    UntrustworthyMailWorker (MailService[] thirdFaces){
        this.thirdFaces = new MailService[thirdFaces.length];
        System.arraycopy(thirdFaces,0,this.thirdFaces,0,thirdFaces.length);
        realMailService = new RealMailService();
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable thirdFaceResult = this.thirdFaces[0].processMail(mail);
        for (int i = 1; i < this.thirdFaces.length; i++){
            thirdFaceResult = this.thirdFaces[i].processMail(thirdFaceResult);
        }
        return this.realMailService.processMail(thirdFaceResult);
    }
}
