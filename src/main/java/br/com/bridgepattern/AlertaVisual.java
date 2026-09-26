package br.com.bridgepattern;

public class AlertaVisual implements Alarme {
    @Override
    public void alertar(String mensagem) {
        System.out.println("Acender luz: " + mensagem);
    }
}
