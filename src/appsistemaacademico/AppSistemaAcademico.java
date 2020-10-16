package appsistemaacademico;

import java.math.*;
import java.util.Scanner;

public class AppSistemaAcademico {

    public static void main(String[] args) {
        Scanner digID = new Scanner(System.in);
        Scanner digNM = new Scanner(System.in);
        Scanner digNota = new Scanner(System.in);

        System.out.println("\nDigite o ID do Aluno: ");
        int idAluno = digID.nextInt();
        System.out.println("Digite o Nome do Aluno: ");
        String nomeAluno = digNM.nextLine();
        System.out.println("Digite a Nota do Aluno: ");
        BigDecimal notaAluno = digNota.nextBigDecimal();

        Aluno aluno = new Aluno();
        aluno.setId(idAluno);
        aluno.setNome(nomeAluno);
        aluno.setNota(notaAluno);

        AlunoDao dao = new AlunoDao();
        dao.adiciona(aluno);
    }
}
