package fatec.poo.model;

/**
 *
 * @author Gabriel & Eduardo
 */
public class Matricula {

    private String data;
    private int Cod;
    private int qtdeFaltas;
    private double nota;
    private Aluno aluno;
    private Turma turma;
    private AVista aVista;
    private APrazo aPrazo;

    public Matricula(String data) {
        this.data = data;
    }

    public void setCod(int Cod) {
        this.Cod = Cod;
    }
    
    
    
    public void setQtdeFaltas(int qtdeFaltas) {
        this.qtdeFaltas = qtdeFaltas;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void EmitirCarne() {
    }

    public int getQtdeFaltas() {
        return qtdeFaltas;
    }

    public double getNota() {
        return nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public AVista getaVista() {
        return aVista;
    }

    public APrazo getaPrazo() {
        return aPrazo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
        turma.addMatricula(this);
    }

    public void setaVista(AVista aVista) {
        this.aVista = aVista;
        aVista.setMatricula(this);
    }

    public void setaPrazo(APrazo aPrazo) {
        this.aPrazo = aPrazo;
        aPrazo.setMatricula(this);
    }

    public int getCod() {
        return Cod;
    }
    
    
   
}
