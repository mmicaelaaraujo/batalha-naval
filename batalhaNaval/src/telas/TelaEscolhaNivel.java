package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class TelaEscolhaNivel extends JFrame {
    
    // Cores gerais:
    /* Para definir as cores, utilize o recurso RGB */
    Color azulFundo = new Color(177, 165, 252);
    Color azulTexto = new Color(75, 61, 168);
    Color azulBotao = new Color(92, 75, 205);

    // Fontes gerais:
    Font fonteTitulo = new Font("SansSerif", Font.BOLD, 48);
    Font fonteBotao = new Font("SansSerif", Font.PLAIN, 16);
    Font fonteTexto = new Font("SansSerif", Font.PLAIN, 32);

    //Componentes: 
    JLabel lblTitulo = new JLabel("Batalha Naval");
    JLabel lblEscolha = new JLabel("Escolha um nível: ");
    JButton btnFacil = new JButton("Fácil");
    JButton btnIntermediario = new JButton("Intermediário");
    JButton btnDificil = new JButton("Díficil");
    JButton btnVoltar = new JButton("Voltar");

    public TelaEscolhaNivel() {
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints regras = new GridBagConstraints();
        painel.setBackground(azulFundo);
        regras.fill = GridBagConstraints.NONE;
        regras.insets = new Insets (10, 10, 10, 10);

        //Adição dos componentes da janela:
        regras.gridx = 0;
        regras.gridy = 0;
        painel.add(lblTitulo, regras);

        regras.gridx = 0;
        regras.gridy = 1;
        painel.add(lblEscolha, regras);

        btnFacil.setPreferredSize(new Dimension(150, 50));
        regras.gridx = 0;
        regras.gridy = 2;
        painel.add(btnFacil, regras);

        btnIntermediario.setPreferredSize(new Dimension(150, 50));
        regras.gridx = 0;
        regras.gridy = 3;
        painel.add(btnIntermediario, regras);

        btnDificil.setPreferredSize(new Dimension(150, 50));
        regras.gridx = 0;
        regras.gridy = 4;
        painel.add(btnDificil, regras);

        btnVoltar.setPreferredSize(new Dimension(150, 50));
        regras.gridx = 0;
        regras.gridy = 5;
        painel.add(btnVoltar, regras);

        setTitle("Batalha Naval");
        setSize(800, 900);
        setLocationRelativeTo(null);

        //Personalização dos componentes
        lblTitulo.setFont(fonteTitulo);
        lblTitulo.setForeground(azulTexto);
        lblEscolha.setFont(fonteTexto);
        lblEscolha.setForeground(azulTexto);
        btnFacil.setBackground(azulBotao);
        btnFacil.setFont(fonteBotao);
        btnFacil.setForeground(Color.WHITE);
        btnIntermediario.setBackground(azulBotao);
        btnIntermediario.setFont(fonteBotao);
        btnIntermediario.setForeground(Color.WHITE);
        btnDificil.setBackground(azulBotao);
        btnDificil.setFont(fonteBotao);
        btnDificil.setForeground(Color.WHITE);
        btnVoltar.setBackground(azulBotao);
        btnVoltar.setFont(fonteBotao);
        btnVoltar.setForeground(Color.WHITE);
        
        btnFacil.setFocusPainted(false);
        btnIntermediario.setFocusPainted(false);
        btnDificil.setFocusPainted(false);
        btnVoltar.setFocusPainted(false);

        // Componente que adiciona e estiliza a borda do botão
        btnFacil.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        btnIntermediario.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        btnDificil.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        btnVoltar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

        btnFacil.addActionListener(e -> {
        new TelaJogo(1);
        dispose();
        });
        btnIntermediario.addActionListener(e -> {
        new TelaJogo(2);
        dispose();
        });
        btnDificil.addActionListener(e -> {
        new TelaJogo(3);
        dispose();
        });
        btnVoltar.addActionListener(e -> {
        new TelaRegras();
        dispose();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(painel);
        setVisible(true);
    }
}
