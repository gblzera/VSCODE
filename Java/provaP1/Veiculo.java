package Java.provaP1;

public class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    private String quilometragemTotal;
    private String nomeProprietario;
    private String cpfProprietario;

    public Veiculo(String marca, String modelo, String placa, int ano, String quilometragemTotal, String nomeProprietario, String cpfProprietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.quilometragemTotal = quilometragemTotal;
        this.nomeProprietario = nomeProprietario;
        this.cpfProprietario = cpfProprietario;
    }

    public String getInformacoesCompletas() {
        return "Marca: " + marca + "\nModelo: " + modelo + "\nPlaca: " + placa + 
               "\nAno: " + ano + "\nQuilometragem Total: " + quilometragemTotal + 
               "\nNome do Proprietário: " + nomeProprietario + 
               "\nCPF do Proprietário: " + cpfProprietario;
    }
    
    public String getPlaca() {
        return placa;
    }
}
