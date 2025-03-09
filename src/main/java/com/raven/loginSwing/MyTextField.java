/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.loginSwing;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author 1dam
 */
public class MyTextField extends JTextField{

    private JLabel prefixIconLabel;
    private String hintText;


    public MyTextField() {
        super();
        prefixIconLabel = new JLabel();
        setLayout(new BorderLayout());
        add(prefixIconLabel, BorderLayout.EAST);  // Agregar ícono al lado izquierdo
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Elimina bordes negros
        setOpaque(true); // Permite que el fondo sea visible
    }
    
    public void setBackgroundColor(Color color) {
        setBackground(color);
    }

    // Implementar el setPrefixIcon
    public void setPrefixIcon(ImageIcon imageIcon) {
        
        prefixIconLabel.setIcon(imageIcon);  // Establecer el ícono
        prefixIconLabel.setVisible(true);   // Hacer visible el ícono
    }

    // Implementar el setHint
    public void setHint(String nombre) {
        hintText = nombre;
        setForeground(Color.GRAY);
        setText(hintText);
        addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (getText().equals(hintText)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (getText().isEmpty()) {
                    setText(hintText);
                    setForeground(Color.GRAY);
                }
            }
        });
    }

    public void setIconTextGap(int gap) {
        Insets margin = getMargin();
        setMargin(new Insets(5, gap, 5, 5));
    }
    
    
    
    
    
}
