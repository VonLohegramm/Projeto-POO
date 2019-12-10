
package fatec.poo.control;

import fatec.poo.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoAluno {
   private Connection con;

    public DaoAluno(Connection con) {
        this.con = con;
    }
   
   public void inserir(Aluno a){
       PreparedStatement stm = null;
       
       try {
           stm = con.prepareStatement("insert into tbAluno(CPF_alu, nome_alu, data_Nasc_alu, endereco_alu, numero_alu, bairro_alu, "
                   + "cidade_alu, estado_alu, CEP_alu, telefone_alu, celular_alu, "
                   + "sexo_alu, estado_Civil_alu, RG_alu, email_alu, escolaridade_alu) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           stm.setString(1, a.getCpf());
            stm.setString(2, a.getNome());
            stm.setString(3, a.getDataNasc());
            stm.setString(4, a.getEndereco());
            stm.setInt(5, a.getNumero());
            stm.setString(6, a.getBairro());
            stm.setString(7, a.getCidade());
            stm.setString(8, a.getEstado());
            stm.setString(9, a.getCep());
            stm.setString(10, a.getTelefone());
            stm.setString(11, a.getCelular());
            stm.setString(12, a.getSexo());
            stm.setString(13, a.getEstadoCivil());
            stm.setString(14, a.getRg());
            stm.setString(15, a.getEmail());
            stm.setString(16, a.getEscolaridade());
            stm.execute();
            stm.close();
       } catch (Exception e) {
           System.out.println(e);
       }
   }
   
   public void excluir(String cpf){
        PreparedStatement stm = null;
        
        try {
            stm = con.prepareStatement("delete from tbAluno where CPF_alu = ?");
            stm.setString(1, cpf);
            stm.execute();
            stm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   
   public void alterar(Aluno a){
        PreparedStatement stm = null;
        
        try {
            stm = con.prepareStatement("update tbAluno set nome_alu = ?, data_Nasc_alu = ?, endereco_alu = ?, numero_alu = ?, bairro_alu = ?,"
                    + " cidade_alu = ?, estado_alu = ?, CEP_alu = ?, telefone_alu = ?, celular_alu = ?, sexo_alu = ?,"
                    + " estado_Civil_alu = ?, RG_alu = ?, email_alu = ?, escolaridade_alu = ? where CPF_alu = ?");
            stm.setString(1, a.getNome());
            stm.setString(2, a.getDataNasc());
            stm.setString(3, a.getEndereco());
            stm.setInt(4, a.getNumero());
            stm.setString(5, a.getBairro());
            stm.setString(6, a.getCidade());
            stm.setString(7, a.getEstado());
            stm.setString(8, a.getCep());
            stm.setString(9, a.getTelefone());
            stm.setString(10, a.getCelular());
            stm.setString(11, a.getSexo());
            stm.setString(12, a.getEstadoCivil());
            stm.setString(13, a.getRg());
            stm.setString(14, a.getEmail());
            stm.setString(15, a.getEscolaridade());
            stm.setString(16, a.getCpf());
            stm.execute();
            stm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Aluno consultar(String cpf){
        PreparedStatement stm = null;
        Aluno a = null;
        
        try {
            stm = con.prepareStatement("select * from tbAluno where CPF_alu = ?");
            stm.setString(1, cpf);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                a = new Aluno(rs.getString("CPF_alu"), rs.getString("nome_alu"));
                a.setDataNasc(rs.getString("data_Nasc_alu"));
                a.setEndereco(rs.getString("endereco_alu"));
                a.setNumero(rs.getInt("numero_alu"));
                a.setBairro(rs.getString("bairro_alu"));
                a.setCidade(rs.getString("cidade_alu"));
                a.setCep(rs.getString("CEP_alu"));
                a.setTelefone(rs.getString("telefone_alu"));
                a.setCelular(rs.getString("celular_alu"));
                a.setSexo(rs.getString("sexo_alu"));
                a.setEstadoCivil(rs.getString("estado_Civil_alu"));
                a.setEstado("estado_ins");
                a.setRg(rs.getString("RG_alu"));
                a.setEmail(rs.getString("email_alu"));
                a.setEscolaridade(rs.getString("escolaridade_alu"));
            }
            
            return a;
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }









}