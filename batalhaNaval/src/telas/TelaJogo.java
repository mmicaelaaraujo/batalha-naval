
package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class TelaJogo extends JFrame {

    // Cores gerais

    Color azulFundo = new Color(177, 165, 252);
    Color azulTexto = new Color(75, 61, 168);
    Color azulBotao = new Color(92, 75, 205);
    Color azulAgua = new Color(120, 190, 240);

    // Fontes

    Font fonteTitulo = new Font("SansSerif", 1, 32);
    Font fonteTexto = new Font("SansSerif", 1, 18);
    Font fonteBotao = new Font("SansSerif", 1, 16);

    // Componentes

    JLabel lblTitulo = new JLabel("Batalha Naval");
    JLabel lblTiros = new JLabel();
    JLabel lblMensagem = new JLabel("Escolha uma posição para atirar!");

    JButton[][] botoes;
    String[][] embarcacoes;
    boolean[][] jogadas;

    int tamanho;
    int tirosRestantes;
    int totalPartes = 0;
    int partesAcertadas = 0;

    Random sorteio = new Random();

    // Construtor

    public TelaJogo() {
        this("facil");
    }

    public TelaJogo(String nivel) {

        // Definindo o tamanho do tabuleiro e os tiros

        if (nivel.equalsIgnoreCase("dificil")) {

            tamanho = 8;
            tirosRestantes = 40;

        } else if (nivel.equalsIgnoreCase("intermediario")) {

            tamanho = 7;
            tirosRestantes = 35;

        } else {

            tamanho = 6;
            tirosRestantes = 30;

        }

        // Criando as matrizes

        botoes = new JButton[tamanho][tamanho];
        embarcacoes = new String[tamanho][tamanho];
        jogadas = new boolean[tamanho][tamanho];

        // Painel principal

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(azulFundo);

        GridBagConstraints regras = new GridBagConstraints();

        regras.insets = new Insets(8, 8, 8, 8);
        regras.gridx = 0;
        regras.fill = GridBagConstraints.NONE;

        // Título

        lblTitulo.setFont(fonteTitulo);
        lblTitulo.setForeground(azulTexto);

        regras.gridy = 0;
        painel.add(lblTitulo, regras);

        // Quantidade de tiros

        lblTiros.setFont(fonteTexto);
        lblTiros.setForeground(azulTexto);

        atualizarTiros();

        regras.gridy = 1;
        painel.add(lblTiros, regras);

        // Mensagem do jogo

        lblMensagem.setFont(new Font("SansSerif", 0, 16));
        lblMensagem.setForeground(azulTexto);

        regras.gridy = 2;
        painel.add(lblMensagem, regras);

        // Criando o tabuleiro

        JPanel tabuleiro = new JPanel(
            new GridLayout(tamanho, tamanho, 4, 4)
        );

        tabuleiro.setBackground(azulFundo);

        for (int linha = 0; linha < tamanho; linha++) {

            for (int coluna = 0; coluna < tamanho; coluna++) {

                final int l = linha;
                final int c = coluna;

                JButton botao = new JButton();

                botao.setPreferredSize(new Dimension(65, 65));
                botao.setBackground(azulAgua);
                botao.setForeground(Color.WHITE);
                botao.setFont(fonteBotao);
                botao.setFocusPainted(false);

                botao.setBorder(
                    BorderFactory.createLineBorder(Color.WHITE, 2)
                );

                // Ação de cada casa do tabuleiro

                botao.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        realizarJogada(l, c);

                    }

                });

                botoes[linha][coluna] = botao;
                tabuleiro.add(botao);

            }
        }

        regras.gridy = 3;
        painel.add(tabuleiro, regras);

        // Botão para sair

        JButton btnSair = new JButton("Sair");

        btnSair.setPreferredSize(new Dimension(130, 45));
        btnSair.setBackground(azulBotao);
        btnSair.setForeground(Color.WHITE);
        btnSair.setFont(fonteBotao);
        btnSair.setFocusPainted(false);

        regras.gridy = 4;
        painel.add(btnSair, regras);

        btnSair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }

        });

        // Sorteando as posições das embarcações

        posicionarEmbarcacoes();

        // Configurações da janela

        setTitle("Batalha Naval");
        setSize(800, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(painel);

        setVisible(true);

    }

    // Método para posicionar as embarcações

    public void posicionarEmbarcacoes() {

        int[] tamanhos;
        int[] quantidades;

        if (tamanho == 6) {

            tamanhos = new int[]{1, 2, 3, 4, 5};
            quantidades = new int[]{4, 2, 1, 1, 1};

        } else if (tamanho == 7) {

            tamanhos = new int[]{1, 2, 3, 4, 5};
            quantidades = new int[]{4, 3, 1, 1, 1};

        } else {

            tamanhos = new int[]{1, 2, 3, 4, 5};
            quantidades = new int[]{6, 2, 2, 2, 1};

        }

        String[] nomes = {
            "Submarino",
            "Destroier",
            "Cruzador",
            "Encouraçado",
            "Porta-aviões"
        };

        for (int i = 0; i < nomes.length; i++) {

            for (int j = 0; j < quantidades[i]; j++) {

                boolean posicionado = false;

                while (!posicionado) {

                    int linha = sorteio.nextInt(tamanho);
                    int coluna = sorteio.nextInt(tamanho);

                    boolean horizontal = sorteio.nextBoolean();

                    int fimLinha = linha;
                    int fimColuna = coluna;

                    if (horizontal) {

                        fimColuna = coluna + tamanhos[i] - 1;

                    } else {

                        fimLinha = linha + tamanhos[i] - 1;

                    }

                    // Verifica se a embarcação cabe no tabuleiro

                    if (fimLinha >= tamanho || fimColuna >= tamanho) {
                        continue;
                    }

                    boolean livre = true;

                    // Verifica se as casas estão livres

                    for (int k = 0; k < tamanhos[i]; k++) {

                        int l;
                        int c;

                        if (horizontal) {

                            l = linha;
                            c = coluna + k;

                        } else {

                            l = linha + k;
                            c = coluna;

                        }

                        if (embarcacoes[l][c] != null) {

                            livre = false;
                            break;

                        }

                    }

                    // Guarda a embarcação na matriz

                    if (livre) {

                        for (int k = 0; k < tamanhos[i]; k++) {

                            int l;
                            int c;

                            if (horizontal) {

                                l = linha;
                                c = coluna + k;

                            } else {

                                l = linha + k;
                                c = coluna;

                            }

                            embarcacoes[l][c] = nomes[i];

                            totalPartes++;

                        }

                        posicionado = true;

                    }

                }

            }

        }

    }

    // Método para realizar os tiros

    public void realizarJogada(int linha, int coluna) {

        if (jogadas[linha][coluna]) {
            return;
        }

        jogadas[linha][coluna] = true;

        tirosRestantes--;

        if (embarcacoes[linha][coluna] != null) {

            // Quando o jogador acerta uma embarcação

            partesAcertadas++;

            botoes[linha][coluna].setText("X");
            botoes[linha][coluna].setBackground(Color.RED);

            lblMensagem.setText(
                "Acertou! " + embarcacoes[linha][coluna]
            );

        } else {

            // Quando o jogador acerta a água

            botoes[linha][coluna].setText("~");
            botoes[linha][coluna].setBackground(Color.GRAY);

            lblMensagem.setText("Tiro na água!");

        }

        botoes[linha][coluna].setEnabled(false);

        atualizarTiros();

        // Verifica se o jogador ganhou

        if (partesAcertadas == totalPartes) {

            JOptionPane.showMessageDialog(
                this,
                "Parabéns! Você encontrou todas as embarcações!",
                "Vitória",
                JOptionPane.INFORMATION_MESSAGE
            );

            bloquearTabuleiro();

        } else if (tirosRestantes == 0) {

            JOptionPane.showMessageDialog(
                this,
                "Seus tiros acabaram! Você perdeu!",
                "Fim de jogo",
                JOptionPane.INFORMATION_MESSAGE
            );

            bloquearTabuleiro();

        }

    }

    // Atualiza a quantidade de tiros

    public void atualizarTiros() {

        lblTiros.setText(
            "Tiros restantes: " + tirosRestantes
        );

    }

    // Desativa os botões quando o jogo termina

    public void bloquearTabuleiro() {

        for (int linha = 0; linha < tamanho; linha++) {

            for (int coluna = 0; coluna < tamanho; coluna++) {

                botoes[linha][coluna].setEnabled(false);

            }

        }

    }

}
