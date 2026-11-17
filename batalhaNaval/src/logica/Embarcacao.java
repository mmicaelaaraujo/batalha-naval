package logica;

// Representa uma embarcação do jogo.
public class Embarcacao {

    // Atributos
    private String nome;
    private int tamanho;
    private int acertos;

    // Construtor
    public Embarcacao(String nome, int tamanho) {

        if (nome == null || nome.isBlank()) { //verifica se uma variável de texto (String) está vazia ou contém apenas espaços em branco.
            throw new IllegalArgumentException(
                    "O nome da embarcação é obrigatório."
            );
        }

        if (tamanho <= 0) {
            throw new IllegalArgumentException( //Constroi uma excessão que nao esta nas regras do jogo com uma mensagem especifica
                    "O tamanho deve ser maior que zero."
            );
        }

        this.nome = nome;
        this.tamanho = tamanho;
        this.acertos = 0;
    }

    // Retorna o nome da embarcação
    public String getNome() {
        return nome;
    }

    // Retorna o tamanho da embarcação
    public int getTamanho() {
        return tamanho;
    }

    // Retorna a quantidade de acertos
    public int getAcertos() {
        return acertos;
    }

    // Registra um acerto na embarcação
    public void registrarAcerto() {

        if (acertos < tamanho) {
            acertos++; // continua contando e acumulando ate acertos ser igual a tamanho
        }
    }

    // Verifica se todas as partes foram atingidas
    public boolean estaAfundada() {
        return acertos == tamanho;
    }
}
