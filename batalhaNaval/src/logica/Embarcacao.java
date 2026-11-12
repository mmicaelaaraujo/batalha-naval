//	Nome, tamanho, partes atingidas e verificacao de afundamento.
package logica;

// classe que armazena os atributos que cada embarcação terá
public class Embarcacao {
    private String nome;
    private int tamanho;
    private int acertos;
    private boolean resultado;

    // essa etapa representa o construtor, que será "importado" quando construirmos a lógica
    public Embarcacao (String nome, int tamanho) {
        this.nome = nome;           // o termos this é utilizado para apontar o objeto que será criado, diferenciando o atributo do parametro do construtor
        this.tamanho = tamanho;     
        this.acertos = 0;           // toda embarcação começará com os acertos em zero
        this.resultado = false;     // enquanto as embarcações não forem encontradas em sua totalidade, o resultado será falso
        
    }
    // Os metodos abaixo são os getters e os settters. Em resumo, os getters pegam o nome aplicado na váriavel para identificar o objeto. Já os setters atualização o valor do objeto atribuído na variável
    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getAcertos() {
        return acertos;
    }

    public boolean getResultado() {
        return resultado;
    }

    public void setAcertos(int novosAcertos) {
        this.acertos = novosAcertos;
    } 

    public void setResultado(boolean novoResultado) {
        this.resultado = novoResultado;
    }

}

