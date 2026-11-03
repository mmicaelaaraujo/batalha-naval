package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TelaInicial extends JFrame {

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

    Font fonteTitulo = new Font("SansSerif", 1, 48);
    Font fonteDescricao = new Font("SansSerif", 0, 24);
    Font fonteBotao = new Font("SanSerif", 0, 16);
    
    // Componentes:

    JLabel lblTitulo = new JLabel("Batalha Naval");
    JLabel lblDescricao = new JLabel("Encontre todas as embarcações antes que seus tiros acabem!");

    JButton btnIniciar = new JButton("Iniciar");
    JButton btnSair = new JButton("Sair");

    public TelaInicial() {

        // Adição de painel para a utilização do GridBagLayout. 
        // Essa funcionalidade permite a configuração geral dos elementos da janela, de forma simples e mantendo a responsividade.
        
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints regras = new GridBagConstraints();

        painel.setBackground(azulFundo);

        regras.fill = GridBagConstraints.NONE;
        regras.insets = new Insets(10, 10, 10, 10);

        // Adição dos componentes da janela:

        regras.gridx = 0; 
        regras.gridy = 0;
        painel.add(lblTitulo, regras);

        regras.gridx = 0; 
        regras.gridy = 1;
        painel.add(lblDescricao, regras);

        btnIniciar.setPreferredSize(new Dimension(150, 50));
        regras.gridx = 0; 
        regras.gridy = 2;
        painel.add(btnIniciar, regras);  
        
        btnSair.setPreferredSize(new Dimension(150, 50));
        regras.gridx = 0; 
        regras.gridy = 3;
        painel.add(btnSair, regras);

        setTitle("Batalha Naval");
        setSize(800, 900);
        setLocationRelativeTo(null);
        

        getContentPane().add(painel);

        // Personalização dos componentes:

        lblTitulo.setFont(fonteTitulo);
        lblTitulo.setForeground(azulTexto);

        lblDescricao.setFont(fonteDescricao);
        lblDescricao.setForeground(azulTexto);

        btnIniciar.setBackground(azulBotao);
        btnIniciar.setFont(fonteBotao);
        btnIniciar.setForeground(Color.WHITE);
        
        btnSair.setBackground(azulBotao);
        btnSair.setFont(fonteBotao);
        btnSair.setForeground(Color.WHITE);

        btnIniciar.setFocusPainted(false);
        btnSair.setFocusPainted(false);

        // Componente que adiciona e estiliza a borda do botão
        btnIniciar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        btnSair.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        

        btnIniciar.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                new TelaRegras(); 
                dispose();      
    }
});
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
        
    }
}
