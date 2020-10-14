package appsistemaacademico;

import java.math.BigDecimal;
import java.sql.*;

/**
 *
 * @author guilhermedinizdesousa
 */
public class AlunoDao {

    // Conexão com o Banco de Dados
    private Connection connection;

    public AlunoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Aluno aluno) {
        String sql = "INSERT INTO aluno VALUES (?, ?, ?)";
        try {
            // prepared statement para inserção
            PreparedStatement stm = this.connection.prepareStatement(sql);
            // seta os valores
            stm.setLong(1, aluno.getId());
            stm.setString(2, aluno.getNome());
            stm.setBigDecimal(3, aluno.getNota());

            // executa o comando
            stm.execute();
            stm.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void consulta() {
        String sql = "SELECT * FROM ALUNO";
        try {
            // prepared statement para consulta
            PreparedStatement stm = this.connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            // consulta
            System.out.println("\nLista de alunos");
            while (rs.next()) {

                String nome = rs.getString("nome");
                BigDecimal nota = rs.getBigDecimal("nota");

                System.out.println("nome:" + nome + " nota:" + nota);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
