import java.time.LocalDate;

public abstract class ContaDeposito {

    private int numeroConta;
    private double saldo;
    private double taxaDeJuro;
    private LocalDate dataInicio;

    public ContaDeposito(int numeroConta, double saldo, double taxaDeJuro, LocalDate dataInicio) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.taxaDeJuro = taxaDeJuro;
        this.dataInicio = dataInicio;
    }

    public void depositar(double valor) throws InvalidDepositException {
        if (valor <= 0) {
            throw new InvalidDepositException("Valor do depósito deve ser positivo.");
        }
        saldo += valor;
    }

    public void sacar(double valor) throws InvalidWithdrawalException {
        if (valor <= 0) {
            throw new InvalidWithdrawalException("Valor do saque deve ser positivo.");
        }
        if (valor > saldo) {
            throw new InvalidWithdrawalException("Saldo insuficiente para saque.");
        }
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public abstract void atualizarSaldo();

    @Override
    public boolean equals(Object outraConta) {
        if (this == outraConta) return true;
        if (outraConta == null || getClass() != outraConta.getClass()) return false;
 ContaDeposito conta = (ContaDeposito) outraConta;
        return numeroConta == conta.numeroConta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroConta);
    }
}
