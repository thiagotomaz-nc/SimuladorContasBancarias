package br.com.contas.exercicio_02.classes;

import br.com.contas.exercicio_02.classes.ContaBancaria;

public class ContaPoupanca extends ContaBancaria {

    private double saldoPoupanca = 0;

    public double getSaldoPoupanca() {
        return saldoPoupanca;
    }

    public void setSaldoPoupanca(double saldoPoupanca) {
        this.saldoPoupanca = saldoPoupanca;
    }

}
