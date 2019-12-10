package fatec.poo.model;

/**
 *
 * @author Gabriel & Eduardo
 */
public class Aluno extends Pessoa {

    private String escolaridade;
    private Matricula matricula;

    public Aluno(String cpf, String nome) {
        super(cpf, nome);
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
        matricula.setAluno(this);
    }

}
