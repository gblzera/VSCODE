public class Main {
    public static void main(String[] args) {
        // Utilizando a injeção de dependência (construtor) para fornecer a implementação
        Notificacao notificacaoEmail = new NotificacaoEmail();
        SistemaNotificacao sistemaEmail = new SistemaNotificacao(notificacaoEmail);
        sistemaEmail.enviarNotificacao("Olá, sua compra foi realizada com sucesso!");

        Notificacao notificacaoSMS = new NotificacaoSMS();
        SistemaNotificacao sistemaSMS = new SistemaNotificacao(notificacaoSMS);
        sistemaSMS.enviarNotificacao("Envie 12345 para esse SMS e tenha os melhores sons no seu celular!");
    }
}
