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
import javax.swing.*;
import logica.Partida;
import logica.ResultadoTiro;

public class TelaJogo extends JFrame {

    // Cores gerais
    Color azulFundo = new Color(177, 165, 252);
    Color azulTexto = new Color(75, 61, 168);
    Color azulBotao = new Color(92, 75, 205);
    Color azulAgua = new Color(120, 190, 240);

    // Fontes
    Font fonteTitulo = new Font("SansSerif", Font.BOLD, 32);
    Font fonteTexto = new Font("SansSerif", Font.PLAIN, 18);
    Font fonteBotao = new Font("SansSerif", Font.PLAIN, 16);

    // Componentes
    JLabel lblTitulo = new JLabel("Batalha Naval");
    JLabel lblTiros = new JLabel();
    JLabel lblMensagem = new JLabel(" ");
    JButton[][] botoes;
    
    Partida partida;
    int tamanho;

    // Construtor

    public TelaJogo() {
        this (1);
    }

    public TelaJogo(int nivel) {

        // Criação da partida junto dos tabuleiros e atribuição dos navios

        partida = new Partida(nivel);
        tamanho = partida.getTabuleiro().getTamanho();


        // Criação da matriz de botões

        botoes = new JButton[tamanho][tamanho];
        

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

        // Configurações da janela

        setTitle("Batalha Naval");
        setSize(900, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(painel);

        setVisible(true);

    }

    // Método para realizar os tiros

    public void realizarJogada(int linha, int coluna) {

        ResultadoTiro resultado = partida.atirar(linha, coluna);

        if (resultado == ResultadoTiro.REPETIDA) {
            return;
        }

        JButton botao = botoes[linhas][colunas];
            botao.setEnabled(false);

        if (resultado == ResultadoTiro.AGUA) {

        botao.setText("~");
        botao.setBackground(Color.GRAY);
        lblMensagem.setText("Tiro na água!");

    } else {

        String nome = partida.getTabuleiro().getEmbarcacaoEm(linha, coluna).getNome();

        botao.setText("X");
        botao.setBackground(Color.RED);

        if (resultado == ResultadoTiro.AFUNDOU) {
            lblMensagem.setText("Você afundou o " + nome + "!");
        } else {
            lblMensagem.setText("Acertou um " + nome + "!");
        }
    }

    atualizarTiros();

    if (partida.getEstado() == Partida.Estado.VITORIA) {

        JOptionPane.showMessageDialog(
            this,
            "Parabéns! Você encontrou todas as embarcações!",
            "Vitória",
            JOptionPane.INFORMATION_MESSAGE
        );

        bloquearTabuleiro();

    } else if (partida.getEstado() == Partida.Estado.DERROTA) {

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
            "Tiros restantes: " + partida.getTirosRestantes()
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
