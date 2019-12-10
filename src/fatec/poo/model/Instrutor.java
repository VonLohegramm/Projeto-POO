package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Gabriel & Eduardo
 */
public class Instrutor extends Pessoa {

    private String formacao;
    private String areaAtuacao;
    private ArrayList<Turma> turmas;

    public Instrutor(String cpf, String nome) {
        super(cpf, nome);
        turmas = new ArrayList<Turma>();
    }
    
    

    public String getFormacao() {
        return formacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
    
    public void addTurma(Turma t){
        turmas.add(t);
        t.setInstrutor(this);
    }

}
