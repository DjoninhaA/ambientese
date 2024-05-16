package com.Integrador.ambientese.model.enums;

public enum Porte {
    Microempresa(0),
    PequenoPorte(1),
    IVMedioPorte(2),
    IIIMedioPorte(3),
    IIGrandePorte(4),
    IGrandePorte(5);
    private final int valor;

    private Porte(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
