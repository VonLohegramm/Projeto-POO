package fatec.poo.control;

import fatec.poo.model.Curso;
import fatec.poo.model.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoTurma {
    private Connection conn;
    
    public DaoTurma(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Turma turma, String sigla_curso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbTurma(sigla_tur, descricao_tur, data_Inicio_tur, data_Termino_tur,"
                    + " periodo_tur, qtd_vagas_tur, fk_curso_tur)"
                    + " VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, turma.getSiglaTurma());
            ps.setString(2, turma.getDescricao());
            ps.setString(3, turma.getDataInicio());
            ps.setString(4, turma.getDataTermino());
            ps.setString(5, turma.getPeriodo());
            ps.setInt(6, turma.getQtdVagas());
            ps.setString(7, sigla_curso);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Turma consultar(String sigla) {
        PreparedStatement ps = null;
        Turma turma = null;
        Curso curso = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tbTurma where sigla_tur = ?");
            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                turma = new Turma(sigla, rs.getString("descricao_tur"));
                curso = new Curso(rs.getString("fk_curso_tur"), "");
                turma.setCurso(curso);
                turma.setDataInicio(rs.getString("data_Inicio_tur"));
                turma.setDataTermino(rs.getString("data_Termino_tur"));
                turma.setPeriodo(rs.getString("periodo_tur"));
                turma.setQtdVagas(rs.getInt("qtd_vagas_tur"));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return turma;
    }
    
    public void alterar(Turma turma) {
        PreparedStatement ps = null;
        try {
            
            ps = conn.prepareStatement("UPDATE tbTurma SET descricao_tur = ?, data_Inicio_tur = ?, "
                    + "data_Termino_tur = ? , periodo_tur = ?, qtd_vagas_tur = ?, fk_curso_tur = ? where sigla_tur = ?");
            ps.setString(1, turma.getDescricao());
            ps.setString(2, turma.getDataInicio());
            ps.setString(3, turma.getDataTermino());
            ps.setString(4, turma.getPeriodo());
            ps.setInt(5, turma.getQtdVagas());
            ps.setString(6, turma.getCurso().getSigla());
            ps.setString(7, turma.getSiglaTurma());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void excluir(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbTurma where sigla_tur = ?");
            ps.setString(1, turma.getSiglaTurma());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public ArrayList<Turma> listarTurmas(String curso){
        PreparedStatement ps = null;
        Turma turma = null;
        ArrayList<Turma> turmas = new ArrayList<Turma>();
        
        try {
            ps = conn.prepareStatement("SELECT t.sigla_tur, t.descricao_tur FROM tbTurma t, tbCurso c where t.fk_curso_tur = ? and t.fk_curso_tur = c.sigla_cur");
            ps.setString(1, curso);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                turma = new Turma(rs.getString(1), rs.getString(2));
                turmas.add(turma);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return turmas;
    }
    
    public boolean situacao(String sigla){
         PreparedStatement ps = null;;
        
        try {
            ps = conn.prepareStatement("SELECT fk_instrutor_tur FROM tbTurma where sigla_tur = ?");
            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();
            String aux = null;
            
            while(rs.next()){
                
                aux = rs.getString(1);
            }
            
            if(aux == null)
                return false;
            else
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return false;
    }
    
    public void alocar(String cpf_instrutor, String sigla){
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("update tbTurma set fk_instrutor_tur = ? where sigla_tur = ?");
            ps.setString(1, cpf_instrutor);
            ps.setString(2, sigla);

            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void liberar(String sigla){
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("update tbTurma set fk_instrutor_tur = NULL where sigla_tur = ?");
            ps.setString(1, sigla);
             ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
