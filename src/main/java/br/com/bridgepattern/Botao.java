package br.com.bridgepattern;

import java.util.Objects;

public abstract class Botao {
    protected final Alarme alarme;

    protected Botao(Alarme alarme) {
        this.alarme = Objects.requireNonNull(alarme, "alarme");
    }

    public abstract void acionar();
}
