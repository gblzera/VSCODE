public class Consulta {
    private String data;
    private String sintomas;
    private String diagnostico;
    private String[] exames;
    private int totalExames;

    public Consulta() {
        this.exames = new String[10];
        this.totalExames = 0;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void marcarExame(String exame) {
        if (totalExames < exames.length) {
            exames[totalExames++] = exame;
            System.out.println("Exame " + exame + " marcado.");
        } else {
            System.out.println("Não é possível adicionar mais exames.");
        }
    }

    public String getData() {
        return data;
    }

    public String getSintomas() {
        return sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }
}
