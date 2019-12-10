package fatec.poo.control;

import fatec.poo.model.AVista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAVista {

    private final Connection conexao;

    public DaoAVista(Connection conexao) {
        this.conexao = conexao;
    }

    public int inserir(AVista aVista) {
        PreparedStatement ps = null;
        int lId = 0;
        try {
            ps = this.conexao.prepareStatement("INSET INTO tbAVista(valor_avi, agencia_avi, cheque_avi, data_avi) VALUES(?, ?, ?, ?)");
            ps.setDouble(1, aVista.getValor());
            ps.setInt(2, aVista.getAgencia());
            ps.setInt(3, aVista.getnCheque());
            ps.setString(4, aVista.getPreData());
            ps = this.conexao.prepareStatement("select @@IDENTITY from tbAVista");
            ResultSet rs = ps.executeQuery();
            lId = rs.getInt(0);
            return lId;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return lId;

    }

    public void alterar(AVista aVista) {
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("UPDATE tbAVista SET valor_avi = ?, agencia_avi = ?, cheque_avi = ?, data_avi = ? WHERE cod_avi = ?");
            ps.setDouble(1, aVista.getValor());
            ps.setInt(2, aVista.getAgencia());
            ps.setInt(3, aVista.getnCheque());
            ps.setString(4, aVista.getPreData());
            ps.setLong(5, aVista.getCode());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public AVista consultar(int codigo) {
        AVista d = null;
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("SELECT * FROM tbAVista WHERE cod_avi = ?");
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                d = new AVista(rs.getInt("cod_avi"));
                d.setAgencia(rs.getInt("agencia_avi"));
                d.setValor(rs.getDouble("valor_avi"));
                d.setnCheque(rs.getInt("cheque_avi"));
                d.setPreData(rs.getString("data_avi"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (d);
    }

    public void excluir(long codigo) {
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("DELETE FROM tbAVista WHERE cod_avi = ?");
            ps.setLong(1, codigo);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
