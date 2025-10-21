package br.com.contas.exercicio_02.classes;

public class ContaCorrente extends ContaBancaria {

    private  double LIMITE_CREDITO = 100;

      public double getLimiteCredito() {
        return LIMITE_CREDITO;
    }

    @Override
    public void show() {
        System.out.println("Olá, " + getNome() + ", seu saldo é R$ " + (getSaldo() + LIMITE_CREDITO) + " reais.");
    }
    
    @Override
    public String showSaldo(){
        return "Olá, " + getNome() + ", seu saldo total é R$ " + getSaldo() + " reais.";
    }

    public double mostraSaldoTotal() {
        return getSaldo() + LIMITE_CREDITO;
    }

    }
