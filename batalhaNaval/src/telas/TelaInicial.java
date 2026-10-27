package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaInicial extends JFrame {

    JLabel lblTitulo = new JLabel("Batalha Naval");
    JLabel lblDescricao = new JLabel("Encontre todas as embarcações...");

    JButton btnIniciar = new JButton("Iniciar");
    JButton btnSair = new JButton("Sair");

    public TelaInicial() {
        setTitle("Batalha Naval");
        setSize(800, 900);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1));

        getContentPane().add(lblTitulo);
        getContentPane().add(lblDescricao);
        getContentPane().add(btnIniciar);
        getContentPane().add(btnSair);

        btnIniciar.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                new TelaJogo(); // Instancia a classe TelaJogo
                    dispose();      // Fecha a TelaInicial
    }
});
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        
    }
}
