package br.com.contas.exercicio_02.classes;

public class ContaBancaria {

    private String nome;
    private double saldo;
    private String numeroConta;
    
    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void show() {
        System.out.println( "Olá, " + nome + ", seu saldo é R$ " + saldo + " reais.");
    }
    
    public String showSaldo(){
             return "Olá, " + nome + ", seu saldo é R$ " + saldo + " reais.";
    }

    public void crediditar(double credito) {
        saldo += credito;

    }
    
    public void debitar(double debito) {
        saldo -= debito; // verificar se saldo é maior que 0
    }

}
