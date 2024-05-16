package com.Integrador.ambientese.model.enums;

public enum Ramo {
    Alimenticio(0),
    Tecnologico(1),
    Varejo(2),
    Saude(3),
    ContrucaoCivil(4);
    private final int valor;

    private Ramo(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
