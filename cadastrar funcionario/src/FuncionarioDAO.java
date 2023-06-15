import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FuncionarioDAO {

    ArrayList<FuncionarioDTO> lista = new ArrayList<>();

    PreparedStatement ps;
    ResultSet rs;

    
    public void cadastrarFuncionario(FuncionarioDTO funcionario) {
        String sql = "INSERT INTO tabela (NOME, EMAIL, TELL, CPF) VALUES (?, ?, ?, ?)";

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getEmail());
            ps.setString(3, funcionario.getTell());
            ps.setString(4, funcionario.getCpf());

            ps.execute();
            ps.close();

        } catch (SQLException erro) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "FuncionarioDAO:" + erro.getMessage());
        }
    }



    public ArrayList<FuncionarioDTO> pesquisarFuncionarios() {
        String sql = "SELECT * FROM tabela";

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                FuncionarioDTO funcionario = new FuncionarioDTO();
                funcionario.setCodigo(rs.getInt("idtabela"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTell(rs.getString("tell"));
                funcionario.setCpf(rs.getString("cpf"));

                lista.add(funcionario);
            }
            ps.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO:" + erro.getMessage());
        }
        return lista;
    }




    public void excluirFunvionario(FuncionarioDTO funcionario) {
        String sql = "DELETE FROM tabela WHERE idtabela = ?";

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, funcionario.getCodigo());

            ps.execute();
            ps.close();

        } catch (SQLException erro) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "FuncionarioDAO:" + erro.getMessage());
        }
    }
}
