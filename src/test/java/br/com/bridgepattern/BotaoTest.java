package br.com.bridgepattern;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BotaoTest {

    static class AlarmeFake implements Alarme {
        final List<String> mensagens = new ArrayList<>();

        @Override
        public void alertar(String mensagem) {
            mensagens.add(mensagem);
        }
    }

    @Test
    void normalDeveAlertarUmaVez() {
        AlarmeFake alarme = new AlarmeFake();

        new Normal(alarme).acionar();

        assertEquals(List.of("Chamado"), alarme.mensagens);
    }

    @Test
    void emergenciaDeveAlertarRepetidamente() {
        AlarmeFake alarme = new AlarmeFake();

        new Emergencia(alarme).acionar();

        assertEquals(List.of("EMERGÊNCIA!", "EMERGÊNCIA!", "EMERGÊNCIA!"), alarme.mensagens);
    }

    @Test
    void botaoExigeAlarme() {
        assertThrows(NullPointerException.class, () -> new Normal(null));
        assertThrows(NullPointerException.class, () -> new Emergencia(null));
    }

    @Test
    void qualquerBotaoFuncionaComQualquerAlarme() {
        Botao normalSonoro = new Normal(new AlertaSonoro());
        Botao normalVisual = new Normal(new AlertaVisual());
        Botao emergenciaSonora = new Emergencia(new AlertaSonoro());
        Botao emergenciaVisual = new Emergencia(new AlertaVisual());

        assertDoesNotThrow(normalSonoro::acionar);
        assertDoesNotThrow(normalVisual::acionar);
        assertDoesNotThrow(emergenciaSonora::acionar);
        assertDoesNotThrow(emergenciaVisual::acionar);
    }
}
