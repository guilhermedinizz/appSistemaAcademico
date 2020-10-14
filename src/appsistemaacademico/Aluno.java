package appsistemaacademico;

import java.math.*;

/**
 *
 * @author guilhermedinizdesousa
 */
public class Aluno {
    private int id;
    private String nome;
    private BigDecimal nota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }
    
}
