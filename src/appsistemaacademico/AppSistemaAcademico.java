package appsistemaacademico;
import java.math.BigDecimal;
import java.util.Scanner;
import java.sql.*;

public class AppSistemaAcademico {

    public static void main(String[] args) throws SQLException {
        Scanner digID = new Scanner(System.in);
        Scanner digNM = new Scanner(System.in);
        Scanner digNota = new Scanner(System.in);
        Scanner numeroAlunos = new Scanner(System.in);
        int x = 0;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            /** Conexão com a base de dados **/
            String url = "jdbc:derby://localhost:1527/servico";
            
            String usuario = "app";
            String senha = "app";
            Connection conexao;
            
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            /** Comandos **/
            
            //Numero de Alunos
            
            
            System.out.println("Quantos alunos serão inseridos no banco dados?");
            x = numeroAlunos.nextInt();
            
            PreparedStatement ps = conexao.prepareStatement(
            "INSERT INTO ALUNO VALUES(?,?,?)");
            
            
            //Entrada de Dados
            while (x>0){
            x = x-1;
                
            System.out.println("\nDigite o ID do Aluno: ");
            long idAluno = digID.nextLong();
            System.out.println("Digite o Nome do Aluno: ");
            String nomeAluno = digNM.nextLine();
            System.out.println("Digite a Nota do Aluno: ");
            BigDecimal notaAluno = digNota.nextBigDecimal();
            
            System.out.println("ID do Aluno: " + idAluno);
            
            
            
          
            ps.setLong(1, idAluno);
            ps.setString(2, nomeAluno);
            ps.setBigDecimal(3, notaAluno);
            
            ps.executeUpdate();
            }
            ps.close();
            
            PreparedStatement stm = conexao.prepareStatement(
            "SELECT * FROM ALUNO");
            
            ResultSet rs = stm.executeQuery();
            
            //Exibição da lista
            
            System.out.println("\nLista de alunos");
            while (rs.next()) {
                
                
                String nome = rs.getString("nome");
                BigDecimal nota = rs.getBigDecimal("nota");
                
                
                System.out.println("nome:" + nome + " nota:" + nota);
            }
            stm.close();
            rs.close();
            conexao.close();
            
            
    
        } catch (ClassNotFoundException ex) {
            System.out.println("Falha" + ex);
            ex.printStackTrace();
        }
    }
    
}
