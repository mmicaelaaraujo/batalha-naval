package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;


public class TelaRegras extends JFrame {

    // Cores gerais:

    /* Para definir as cores, utilize o recurso RGB */

    Color azulFundo = new Color(177, 165, 252);
    Color azulTexto = new Color(75, 61, 168);
    Color azulBotao = new Color(92, 75, 205);

    // Fontes gerais:

    /* A númeração dentro do parentese diz respeito a um estilo de texto, como normal ou negrito.
    0 = normal (Plain)
    1 = Negrito (bold)
    2 = Itálico (Italic)
    */

    Font fonteTitulo = new Font("SansSerif", 1, 38);
    Font fonteDescricao = new Font("SansSerif", 0, 16);
    Font fonteBotao = new Font("SanSerif", 0, 16);

    JLabel lblRegras = new JLabel("Regras do Jogo:");
    JLabel lblTopico1 = new JLabel("O objetivo do jogo é encontrar todas as embarcações antes que seus tiros acabem."); 
    JLabel lblTopico2 = new JLabel("As embarcações estarão espalhadas pelo tabuleiro de forma aleatória, na horizontal.");
    JLabel lblTopico3 = new JLabel("Para atirar, clique no botão do tiro para ativa-lo, e clique no quadrado do tabuleiro que desejar.");
    JLabel lblTopico4 = new JLabel("Mas atenção: cada nível possui um limite de tiros, então, se você utilizar todos eles antes de encontrar todas as embarcações, você perderá.");
    JButton btnContinuar = new JButton("Continuar");


    public TelaRegras() {

        setTitle("Batalha Naval");
        setSize(800, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints regras = new GridBagConstraints();

        painel.setBackground(azulFundo);

        regras.fill = GridBagConstraints.NONE;
        regras.insets = new Insets(10, 10, 10, 10);

        // Adição dos componentes da janela:

        regras.gridx = 0; 
        regras.gridy = 1;
        painel.add(lblRegras, regras);

        regras.gridx = 0;
        regras.gridy = 2;
        painel.add(lblTopico1, regras);

        regras.gridx = 0;
        regras.gridy = 3;
        painel.add(lblTopico2, regras);

        regras.gridx = 0;
        regras.gridy = 4;
        painel.add(lblTopico3, regras);

        regras.gridx = 0;
        regras.gridy = 5;
        painel.add(lblTopico4, regras);
         
        btnContinuar.setPreferredSize(new Dimension(150, 50));
        regras.gridx = 0; 
        regras.gridy = 6;
        painel.add(btnContinuar, regras);


        getContentPane().add(painel);

        // Personalização dos componentes:

        lblRegras.setFont(fonteTitulo);
        lblTopico1.setFont(fonteDescricao);
        lblTopico2.setFont(fonteDescricao);
        lblTopico3.setFont(fonteDescricao);
        lblTopico4.setFont(fonteDescricao);

        btnContinuar.setBackground(azulBotao);
        btnContinuar.setFont(fonteBotao);
        btnContinuar.setForeground(Color.WHITE);
        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        

        setVisible(true); 
    
}

    public JTextArea getTxtRegras() {
        return txtRegras;
    }
}

