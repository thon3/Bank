public class Titular {

    private String nome;
    private int numeroCliente;

    public Titular(String nome, int numeroCliente) {
        this.nome = nome;
        this.numeroCliente = numeroCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    @Override
    public boolean equals(Object outroTitular) {
        if (this == outroTitular) return true;
        if (outroTitular == null || getClass() != outroTitular.getClass()) return false;
        Titular titular = (Titular) outroTitular;
        return numeroCliente == titular.numeroCliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCliente);
    }
}
