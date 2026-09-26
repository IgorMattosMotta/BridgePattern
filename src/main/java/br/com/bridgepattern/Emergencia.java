package br.com.bridgepattern;

public class Emergencia extends Botao {
    static final int REPETICOES = 3;

    public Emergencia(Alarme alarme) {
        super(alarme);
    }

    @Override
    public void acionar() {
        for (int i = 0; i < REPETICOES; i++) {
            alarme.alertar("EMERGÊNCIA!");
        }
    }
}
