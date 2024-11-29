public class SistemaNotificacao {
    

    private Notificacao notificacao;

    //O construtor recebe a abstração, não o detalhe
    public SistemaNotificacao(Notificacao notificacao){
        this.notificacao = notificacao;
    }

    public void enviarNotificacao(String mensagem){
        notificacao.enviar(mensagem);
    }
}
