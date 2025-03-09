/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.loginSwing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author 1dam
 */
public class ButtonOutLine extends JButton {
    private int arcWidth = 20;  // Radio de las esquinas
    private int arcHeight = 20;
    private Color originalColor;
    private Timer animationTimer;
    private float alpha = 1.0f; // Transparencia para la animación

    public ButtonOutLine() {
        setContentAreaFilled(false); // Para que el fondo personalizado funcione
        setFocusPainted(false); // Quita el borde feo cuando el botón está seleccionado
        setBorderPainted(false); // Elimina el borde predeterminado

        originalColor = new Color(32, 255, 184); // Color predeterminado
        setBackground(originalColor); // Aplicar color base

        // Agregar evento de clic para la animación
        addActionListener(e -> startClickAnimation());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Aplicar transparencia en la animación
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        // Dibujar fondo redondeado
        g2.setColor(originalColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        this.originalColor = color; // Guardar el color original una sola vez
        repaint();
    }

    public void setForeground(int r, int g, int b) {
        super.setForeground(new Color(r, g, b));
    }

    // Permitir cambiar el radio de las esquinas
    public void setCornerRadius(int arc) {
        this.arcWidth = arc;
        this.arcHeight = arc;
        repaint();
    }

    // Animación de clic sin oscurecer el botón
    private void startClickAnimation() {
        if (animationTimer != null && animationTimer.isRunning()) {
            animationTimer.stop();
        }

        alpha = 0.7f; // Reducimos la opacidad un poco

        animationTimer = new Timer(10, new ActionListener() {
            private float step = 0.03f; // Velocidad de la animación

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += step;
                if (alpha >= 1.0f) {
                    alpha = 1.0f;
                    animationTimer.stop();
                }
                repaint();
            }
        });

        animationTimer.start();
    }
    
}
