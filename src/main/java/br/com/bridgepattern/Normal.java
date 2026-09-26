package br.com.bridgepattern;

public class Normal extends Botao {
    public Normal(Alarme alarme) {
        super(alarme);
    }

    @Override
    public void acionar() {
        alarme.alertar("Chamado");
    }
}
