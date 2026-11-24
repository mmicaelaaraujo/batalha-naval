//	Nivel escolhido, quantidade de tiros, registro de jogadas e condicoes de vitoria e derrota.
package logica;

public class Partida {
    
    public enum Estado {EM_ANDAMENTO, VITORIA, DERROTA}

    private Tabuleiro tabuleiro;
    private int tirosRestantes;
    private Estado estado = Estado.EM_ANDAMENTO;

    public Partida(int Nivel) {
        tabuleiro = new Tabuleiro(nivel);
        tabuleiro.posicionarNavios();

        if (nivel == 1) {
            tirosRestantes = 30;
        } else if (nivel == 2) {
            tirosRestantes = 35;
        } else {
            tirosRestantes = 40;    
        }
        
    }
    public ResultadoTiro atirar(int linha, int coluna) {
        if (estado != Estado.EM_ANDAMENTO) {
            return ResultadoTiro.REPETIDO;
        }

        ResultadoTiro resultado = tabuleiro.atirar(linha, coluna);

        if (resultado == ResultadoTiro.REPETIDO) {
            return resultado;
        }

        tirosRestantes--;

        if (tabuleiro.todosAfundados()) {
            estado = Estado.VITORIA;
        } else if (tirosRestantes == 0) {
            estado = Estado.DERROTA;
        }

        return resultado;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public int getTirosRestantes() {
        return tirosRestantes;
    }

    public Estado getEstado() {
        return estado;
    }
}

