package fatec.poo.model;

/**
 *
 * @author Gabriel & Eduardo
 */
public class APrazo {

    private int cod;
    private double valor;
    private String dtVencimento;
    private double taxaJuros;
    private int qtdeMensalidade;
    private Matricula matricula;
    
    public APrazo(int cod){
        this.cod = cod;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros / 100;
    }

    public void setQtdeMensalidade(int qtdeMensalidade) {
        this.qtdeMensalidade = qtdeMensalidade;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public int getCod() {
        return cod;
    }

    public double getValor() {
        return valor;
    }

    public String getDtVencimento() {
        return dtVencimento;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public int getQtdeMensalidade() {
        return qtdeMensalidade;
    }

    public Matricula getMatricula() {
        return matricula;
    }
    
    

}
