public class NotificacaoSMS implements Notificacao {
    @Override
    public void enviar(String mensagem){
        System.out.println("Mensagem enviada via SMS: " + mensagem);
    }
}
