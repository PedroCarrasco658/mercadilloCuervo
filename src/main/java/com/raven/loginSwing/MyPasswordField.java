/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.loginSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 *
 * @author pedro
 */
public class MyPasswordField extends JPasswordField{
    
    private ImageIcon prefixIcon;
    private JLabel prefixIconLabel;
    private String hintText;  // Atributo para almacenar el hint
     private boolean showingHint = true;

    public MyPasswordField() {
        super();
        prefixIconLabel = new JLabel();
        setLayout(new BorderLayout());
        add(prefixIconLabel, BorderLayout.EAST);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Elimina bordes negros
        setOpaque(true); // Permite que el fondo sea visible
    }
    public void setBackgroundColor(Color color) {
        setBackground(color);
    }

    public void setPrefixIcon(ImageIcon icon) {
        prefixIconLabel.setIcon(icon);  // Establecer el ícono
        prefixIconLabel.setVisible(true);    // Hacer visible el ícono
    }

    public void setIconTextGap(int gap) {
        // Ajusta el margen solo en el lado izquierdo (entre el icono y el texto)
        setMargin(new Insets(5, gap, 5, 5));  
    }

    // Establecer el hint
    public void setHint(String hint) {
        this.hintText = hint;
        setForeground(Color.GRAY);
        setText(hintText);
        setEchoChar((char) 0); // No ocultar caracteres cuando se muestra el hint
        showingHint = true;

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                if (showingHint) {
                    setText("");
                    setForeground(Color.BLACK);
                    setEchoChar('*'); // Activar ocultación cuando el usuario escribe
                    showingHint = false;
                }
            }

            @Override
            public void focusLost(FocusEvent evt) {
                if (getPassword().length == 0) {
                    setText(hintText);
                    setForeground(Color.GRAY);
                    setEchoChar((char) 0); // Volver a desactivar la ocultación para mostrar el hint
                    showingHint = true;
                }
            }
        });
    }

    // Obtener el hint
    public String getHint() {
        return hintText;
    }
    
    
    
    
}
