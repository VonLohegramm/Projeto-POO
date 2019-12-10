package fatec.poo.control;

import fatec.poo.model.APrazo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAPrazo {

    private final Connection conexao;

    public DaoAPrazo(Connection conexao) {
        this.conexao = conexao;
    }

    public int inserir(APrazo aPrazo) {
        PreparedStatement ps = null;
        int lId = 0;
        try {
            ps = this.conexao.prepareStatement("INSET INTO tbAPrazo(valor_pr, dtVencimento_pr, taxaJuros_pr, qtdeMensalidade_pr) VALUES(?, ?, ?, ?)");
            ps.setDouble(1, aPrazo.getValor());
            ps.setString(2, aPrazo.getDtVencimento());
            ps.setDouble(3, aPrazo.getTaxaJuros());
            ps.setInt(4, aPrazo.getQtdeMensalidade());
            ps = this.conexao.prepareStatement("select @@IDENTITY from tbAPrazo");
            ResultSet rs = ps.executeQuery();
            lId = rs.getInt(0);
            return lId;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return lId;
    }

    public void alterar(APrazo aPrazo) {
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("UPDATE tbAPrazo SET valor_pr = ?, dtVencimento_pr = ?, taxaJuros_pr = ?, qtdeMensalidade_pr = ? WHERE cod_pr = ?");
            ps.setDouble(1, aPrazo.getValor());
            ps.setString(2, aPrazo.getDtVencimento());
            ps.setDouble(3, aPrazo.getTaxaJuros());
            ps.setInt(4, aPrazo.getQtdeMensalidade());
            ps.setInt(5, aPrazo.getCod());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public APrazo consultar(int codigo) {
        APrazo d = null;
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("SELECT * FROM tbAPrazo WHERE cod_pr = ?");
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                d = new APrazo(rs.getInt("cod_pr"));
                d.setDtVencimento(rs.getString("dtVencimento_pr"));
                d.setQtdeMensalidade(rs.getInt("qtdeMensalidade_pr"));
                d.setTaxaJuros(rs.getDouble("taxaJuros_pr"));
                d.setValor(rs.getDouble("valor_pr"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (d);
    }

    public void excluir(int codigo) {
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("DELETE FROM tbAPrazo WHERE cod_pr = ?");
            ps.setLong(1, codigo);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
