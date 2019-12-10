package fatec.poo.control;

import fatec.poo.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoCurso {

    private Connection conn;

    public DaoCurso(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Curso curso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbCurso(sigla_cur, nome_cur, carga_Horaria_cur, valor_cur,"
                    + " data_Vigencia_cur, valor_Hora_Instrutor_cur, programa_cur)"
                    + " VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, curso.getSigla());
            ps.setString(2, curso.getNome());
            ps.setInt(3, curso.getCargaHoraria());
            ps.setDouble(4, curso.getValor());
            ps.setString(5, curso.getDataVigencia());
            ps.setDouble(6, curso.getValorHoraInstrutor());
            ps.setString(7, curso.getPrograma());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Curso curso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbCurso SET nome_cur = ?, carga_Horaria_cur = ?, valor_cur = ?, "
                    + "data_Vigencia_cur = ? , valor_Hora_Instrutor_cur = ?, programa_cur = ? where sigla_cur = ?");
            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getCargaHoraria());
            ps.setDouble(3, curso.getValor());
            ps.setString(4, curso.getDataVigencia());
            ps.setDouble(5, curso.getValorHoraInstrutor());
            ps.setString(6, curso.getPrograma());
            ps.setString(7, curso.getSigla());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void excluir(Curso curso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbCurso where sigla_cur = ?");
            ps.setString(1, curso.getSigla());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Curso consultar(String sigla) {
        PreparedStatement ps = null;
        Curso c = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tbCurso where sigla_cur = ?");
            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Curso(sigla, rs.getString("nome_cur"));
                c.setCargaHoraria(rs.getInt("carga_horaria_cur"));
                c.setDataVigencia(rs.getString("data_Vigencia_cur"));
                c.setPrograma(rs.getString("programa_cur"));
                c.setValorHoraInstrutor(rs.getDouble("valor_Hora_Instrutor_cur"));
                c.setValor(rs.getDouble("valor_Hora_Instrutor_cur"));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return c;
    }
    
    public ArrayList<Curso> listarSiglas(){
        PreparedStatement ps = null;
        Curso curso = null;
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM tbCurso");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                curso = new Curso(rs.getString("sigla_cur"), rs.getString("nome_cur"));
                curso.setCargaHoraria(rs.getInt("carga_horaria_cur"));
                curso.setPrograma(rs.getString("programa_cur"));
                curso.setValor(rs.getDouble("valor_cur"));
                curso.setDataVigencia(rs.getString("data_Vigencia_cur"));
                curso.setValorHoraInstrutor(rs.getDouble("valor_Hora_Instrutor_cur"));
                cursos.add(curso);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return cursos;
    }
}
