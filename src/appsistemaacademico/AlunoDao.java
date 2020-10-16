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

    public List<Aluno> getLista() {
        try {
            PreparedStatement stmt = this.connection
                    .prepareStatement("select * from ALUNO");
            ResultSet rs = stmt.executeQuery();

            List<Aluno> alunos = new ArrayList<Aluno>();

            while (rs.next()) {
                
                // criando o objeto aluno
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("ID_ALUNO"));
                aluno.setNome(rs.getString("NOME"));
                aluno.setNota(rs.getBigDecimal("NOTA"));
                
                // adicionando o objeto à lista
                alunos.add(aluno);

            }
            
            rs.close();
            stmt.close();

            return alunos;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
