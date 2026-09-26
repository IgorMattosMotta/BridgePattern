package br.com.bridgepattern;

public class AlertaSonoro implements Alarme {
    @Override
    public void alertar(String mensagem) {
        System.out.println("Tocar chamado: " + mensagem);
    }
}
