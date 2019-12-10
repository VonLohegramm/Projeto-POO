
package fatec.poo.control;

import fatec.poo.model.Instrutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DaoInstrutor {
    private Connection con;

    public DaoInstrutor(Connection con) {
        this.con = con;
    }
    
    public void inserir(Instrutor i){
        PreparedStatement stm = null;
        
        try {
            stm = con.prepareStatement("insert into tbInstrutor(CPF_ins, nome_ins, data_Nasc_ins, endereco_ins, numero_ins,"
                    + " bairro_ins, cidade_ins, CEP_ins, estado_ins, telefone_ins, celular_ins, "
                    + "sexo_ins, estado_Civil_ins, RG_ins, email_ins,"
                    + " formacao_ins, area_Atuacao_ins) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stm.setString(1, i.getCpf());
            stm.setString(2, i.getNome());
            stm.setString(3, i.getDataNasc());
            stm.setString(4, i.getEndereco());
            stm.setInt(5, i.getNumero());
            stm.setString(6, i.getBairro());
            stm.setString(7, i.getCidade());
            stm.setString(9, i.getEstado());
            stm.setString(8, i.getCep());
            stm.setString(10, i.getTelefone());
            stm.setString(11, i.getCelular());
            stm.setString(12, i.getSexo());
            stm.setString(13, i.getEstadoCivil());
            stm.setString(14, i.getRg());
            stm.setString(15, i.getEmail());
            stm.setString(16, i.getFormacao());
            stm.setString(17, i.getAreaAtuacao());
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void excluir(String cpf){
        PreparedStatement stm = null;
        
        try {
            stm = con.prepareStatement("delete from tbInstrutor where CPF_ins = ?");
            stm.setString(1, cpf);
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void alterar(Instrutor i){
        PreparedStatement stm = null;
        
        try {
            stm = con.prepareStatement("update tbInstrutor set nome_ins = ?, data_Nasc_ins = ?, endereco_ins = ?, numero_ins = ?, bairro_ins = ?, cidade_ins = ?, CEP_ins, estado_ins = ?, telefone_ins = ?, celular_ins = ?, sexo_ins = ?, estado_Civil_ins = ?, RG_ins = ?, email_ins = ?, formacao_ins = ?, area_Atuacao_ins = ? where CPF_ins = ?");
            stm.setString(1, i.getNome());
            stm.setString(2, i.getDataNasc());
            stm.setString(3, i.getEndereco());
            stm.setInt(4, i.getNumero());
            stm.setString(5, i.getBairro());
            stm.setString(6, i.getCidade());
            stm.setString(7, i.getEstado());
            stm.setString(8, i.getCep());
            stm.setString(9, i.getTelefone());
            stm.setString(10, i.getCelular());
            stm.setString(11, i.getSexo());
            stm.setString(12, i.getEstadoCivil());
            stm.setString(13, i.getRg());
            stm.setString(14, i.getEmail());
            stm.setString(15, i.getFormacao());
            stm.setString(16, i.getAreaAtuacao());
            stm.setString(17, i.getCpf());
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public Instrutor consultar(String cpf){
        PreparedStatement stm = null;
        Instrutor i = null;
        
        try {
            stm = con.prepareStatement("select * from tbInstrutor where CPF_ins = ?");
            stm.setString(1, cpf);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                i = new Instrutor(rs.getString("CPF_ins"), rs.getString("nome_ins"));
                i.setDataNasc(rs.getString("data_Nasc_ins"));
                i.setEndereco(rs.getString("endereco_ins"));
                i.setNumero(rs.getInt("numero_ins"));
                i.setBairro(rs.getString("bairro_ins"));
                i.setCidade(rs.getString("cidade_ins"));
                i.setCep(rs.getString("CEP_ins"));
                i.setTelefone(rs.getString("telefone_ins"));
                i.setCelular(rs.getString("celular_ins"));
                i.setSexo(rs.getString("sexo_ins"));
                i.setEstadoCivil(rs.getString("estado_Civil_ins"));
                i.setEstado("estado_ins");
                i.setRg(rs.getString("RG_ins"));
                i.setEmail(rs.getString("email_ins"));
                i.setFormacao(rs.getString("formacao_ins"));
                i.setAreaAtuacao(rs.getString("area_Atuacao_ins"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return i;
    }
    
     public ArrayList<Instrutor> listarSiglas(){
        PreparedStatement ps = null;
        Instrutor instrutor = null;
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        
        try {
            ps = con.prepareStatement("SELECT * FROM tbInstrutor");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                instrutor = new Instrutor(rs.getString("CPF_ins"), rs.getString("nome_ins"));
                instrutores.add(instrutor);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return instrutores;
    }
     
    
    
}
