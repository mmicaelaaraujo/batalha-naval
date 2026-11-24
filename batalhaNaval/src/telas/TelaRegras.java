package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class TelaRegras extends JFrame {

    Color azulFundo = new Color(177, 165, 252);
    Color azulTexto = new Color(75, 61, 168);
    Color azulBotao = new Color(92, 75, 205);

    Font fonteTitulo = new Font("SansSerif", Font.BOLD, 38);
    Font fonteDescricao = new Font("SansSerif", Font.PLAIN, 16);
    Font fonteBotao = new Font("SansSerif", Font.PLAIN, 16);

    JLabel lblRegras = new JLabel("Regras do Jogo:");
    JLabel lblTopico1 = criarTopico("O objetivo do jogo é encontrar todas as embarcações antes que seus tiros acabem.");
    JLabel lblTopico2 = criarTopico("As embarcações estarão espalhadas pelo tabuleiro de forma aleatória, na horizontal.");
    JLabel lblTopico3 = criarTopico("Para atirar, clique no botão do tiro para ativá-lo, e clique no quadrado do tabuleiro que desejar.");
    JLabel lblTopico4 = criarTopico("Mas atenção: cada nível possui um limite de tiros, então, se você utilizar todos eles antes de encontrar todas as embarcações, você perderá.");
    JButton btnContinuar = new JButton("Continuar");

    public TelaRegras() {
        setTitle("Batalha Naval");
        setSize(900, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(azulFundo);

        GridBagConstraints regras = new GridBagConstraints();
        regras.fill = GridBagConstraints.NONE;
        regras.insets = new Insets(10, 10, 10, 10);
        regras.gridx = 0;

        lblRegras.setFont(fonteTitulo);
        lblRegras.setForeground(azulTexto);

        btnContinuar.setPreferredSize(new Dimension(150, 50));
        btnContinuar.setBackground(azulBotao);
        btnContinuar.setFont(fonteBotao);
        btnContinuar.setForeground(Color.WHITE);
        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

        regras.gridy = 0; painel.add(lblRegras, regras);
        regras.gridy = 1; painel.add(lblTopico1, regras);
        regras.gridy = 2; painel.add(lblTopico2, regras);
        regras.gridy = 3; painel.add(lblTopico3, regras);
        regras.gridy = 4; painel.add(lblTopico4, regras);
        regras.gridy = 5; painel.add(btnContinuar, regras);

        btnContinuar.addActionListener(e -> {
            new TelaEscolhaNivel();
            dispose();
        });

        getContentPane().add(painel);
        setVisible(true);
    }

    // Inserção do HTML dentro da Label para organizar a quebra de linha e o espaçamento do texto dentro da janela
    private JLabel criarTopico(String texto) {
        JLabel lbl = new JLabel("<html><body style='width:650px; text-align:center'>"
                + texto + "</body></html>");
        lbl.setFont(fonteDescricao);
        lbl.setForeground(azulTexto);
        return lbl;
    }
}



 
 


