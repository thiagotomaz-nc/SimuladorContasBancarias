package br.com.contas.exercicio_02.classes;

import javax.swing.JOptionPane;

public class OperacoesBancarias {

    public void creditarContaCorrente(ContaCorrente contaCorrente, double novoValor) {
        if (novoValor >= 0) {
            contaCorrente.crediditar(novoValor);
            JOptionPane.showMessageDialog(null, "Depósito na conta corrente realizado com sucesso\n\nTitular da conta: [ "+contaCorrente.getNome()+" ] \nNúmero da conta: [ "+contaCorrente.getNumeroConta()+" ]");     
        } else {
            JOptionPane.showMessageDialog(null,"O valor não pode ser negativo");
        }

    }

    public void creditarContaPoupanca(ContaPoupanca contaPoupanca, double novoValor) {
        if (novoValor >= 0) {
            contaPoupanca.crediditar(novoValor);
            JOptionPane.showMessageDialog(null, "Depósito na conta poupança realizado com sucesso!\n\nTitular da conta: [ "+contaPoupanca.getNome()+" ]\nNúmero da conta: ["+contaPoupanca.getNumeroConta()+" ]");
        } else {
           // System.out.println("O valor não pode ser negativo");
            JOptionPane.showMessageDialog(null, "O valor não pode ser negativo");

        }

    }

    public void creditarEmPoupanca(ContaPoupanca contaPoupanca, double novoValor) {
        if (verificarSaldoSuficiente(contaPoupanca, novoValor)) {
            contaPoupanca.debitar(novoValor);
            contaPoupanca.setSaldoPoupanca(contaPoupanca.getSaldoPoupanca() + novoValor); // verificar depois
            JOptionPane.showMessageDialog(null, "Operação de débito do saldo da conta para crédito saldo da poupança realizada com sucesso!\nTitular da conta: [ "+contaPoupanca.getNome()+" ] \nNúmero da conta: ["+contaPoupanca.getNumeroConta()+" ]");

        } else {
            JOptionPane.showMessageDialog(null,"Saldo da conta insuficiente!\n\nNúmero da conta: ["+contaPoupanca.getNumeroConta()+" ]\nSaldo nesta conta na poupança: "+contaPoupanca.getSaldo());

        }
    }

    public boolean verificarSaldoSuficiente(ContaCorrente contaCorrente, double valor) {
        
        if (contaCorrente.mostraSaldoTotal()>= valor) {
            return true;
        } else {
            return false;
        }

    }

    public boolean verificarSaldoSuficiente(ContaPoupanca contaPoupanca, double valor) {
        if (contaPoupanca.getSaldo() >= valor) {
            return true;
        } else {
            return false;
        }

    }

    public void debitarContaCorrente(ContaCorrente contaCorrente, double valorDebito) {
        if (verificarSaldoSuficiente(contaCorrente, valorDebito)) {
            contaCorrente.debitar(valorDebito);
            JOptionPane.showMessageDialog(null, "Débito realizado com sucesso\nTitular: "+contaCorrente.getNome()+"\nNúmero da conta: [ "+contaCorrente.getSaldo()+" ]");  

        } else {
           JOptionPane.showMessageDialog(null,"Saldo insificiente para debitar na conta corrente.");
        }
    }

    public void debitarContaPoupanca(ContaPoupanca contaPoupanca, double valorDebito) {

        if (verificarSaldoSuficiente(contaPoupanca, valorDebito)) {
            contaPoupanca.debitar(valorDebito);
            JOptionPane.showMessageDialog(null, "Débito realizado na conta poupança com sucesso\nTitular: "+contaPoupanca.getNome()+"\nNúmero da conta: ["+contaPoupanca.getNumeroConta()+" ]");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insificiente para debitar conta poupança.");
        }

    }

    public void debitarDaPoupanca(ContaPoupanca contaPoupanca, double valorDebito) {
        if (vericarSaldoPoupancaSuficiente(contaPoupanca.getSaldoPoupanca(), valorDebito)) {
            double somaDebito = contaPoupanca.getSaldoPoupanca() - valorDebito;

            contaPoupanca.setSaldoPoupanca(somaDebito);
            contaPoupanca.crediditar(valorDebito);
            JOptionPane.showMessageDialog(null, "Operação de débito saldo da poupança  para crédito saldo da conta realizada com sucesso!\nTitular da conta: [ "+contaPoupanca.getNome()+" ] \nNúmero da conta: ["+contaPoupanca.getNumeroConta()+" ]");

        }else{
           JOptionPane.showMessageDialog(null, "Saldo da poupança insificiente para debitar conta poupança!\nSaldo poupança: "+contaPoupanca.getSaldoPoupanca());

        }

    }

    public boolean vericarSaldoPoupancaSuficiente(double saldPoupanca, double valor) {
        if (saldPoupanca >= valor) {
            return true;
        } else {
            return false;
        }

    }

    public void transferenciaBancaria(ContaCorrente contaOrigem, ContaCorrente contaDestino, double valor) {
        if (verificarSaldoSuficiente(contaOrigem, valor)) {
            contaOrigem.debitar(valor);
            contaDestino.crediditar(valor);
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso\n\nConta Origem: [ "+contaOrigem.getNumeroConta()+" ]\nConta Destino: [ "+contaDestino.getNumeroConta()+" ]\nValor Transferido: "+valor);

        }else{
          JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar a transferência!\n\nConta Origem: [ "+contaOrigem.getNumeroConta()+" ]\nSaldo total: "+contaOrigem.getSaldo());

        }

    }

}
