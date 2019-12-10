package fatec.poo.control;

import fatec.poo.model.APrazo;
import fatec.poo.model.AVista;
import fatec.poo.model.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoMatricula {
    private Connection conn;
    
    public DaoMatricula(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Matricula matricula){
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("INSERT INTO tbMatricula(data_mat, qtdFaltas_mat, nota_mat,"
                    + " fk_Aluno_mat, fk_Turma_mat, fk_AVista_mat, fk_APrazo_mat)"
                    + " VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, matricula.getData());
            ps.setInt(2, matricula.getQtdeFaltas());
            ps.setDouble(3, matricula.getNota());
            ps.setString(4, matricula.getAluno().getCpf());
            ps.setString(5, matricula.getTurma().getSiglaTurma());
            ps.setInt(6, matricula.getaVista().getCode());
            ps.setInt(7, matricula.getaPrazo().getCod());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void excluir(int cod){
        PreparedStatement stm = null;
        
        try {
            stm = conn.prepareStatement("delete from tbMatricula where cod_mat = ?");
            stm.setInt(1, cod);
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void alterar(Matricula m){
        PreparedStatement stm = null;
        
        try {
            stm = conn.prepareStatement("update tbInstrutor set data_mat = ?, qtdFaltas_mat = ?, nota_mat = ?, fk_Aluno_mat= ?, fk_Turma_mat= ?, fk_AVista_mat = ?, fk_APrazo_mat = where cod_mat = ?");
            stm.setString(1, m.getData());
            stm.setInt(2, m.getQtdeFaltas());
            stm.setDouble(3, m.getNota());
            stm.setString(4, m.getAluno().getCpf());  
            stm.setString(5, m.getTurma().getSiglaTurma());
            stm.setInt(6, m.getaVista().getCode());
            stm.setInt(7, m.getaPrazo().getCod());
            stm.setInt(8, m.getCod());
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public Matricula verificarMatricula(String sigla, String aluno){
        PreparedStatement ps = null;
        Matricula m = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tbMatricula WHERE fk_Turma_mat = ? and fk_Aluno_mat = ?");
            ps.setString(1, sigla);
            ps.setString(2, aluno);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                m = new Matricula(rs.getString("data_mat"));
                m.setCod(rs.getInt("cod_mat"));
            }
            
            if(rs.getInt("fk_APrazo_mat") != 0){
                APrazo aprazo = new APrazo(rs.getInt("fk_APrazo_mat"));
                m.setaPrazo(aprazo);
            }else{
                AVista avista = new AVista(rs.getInt("fk_AVista_mat"));
                m.setaVista(avista);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return m;
    }
}
