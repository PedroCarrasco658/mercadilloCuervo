
package com.raven.component;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TrayIcon.MessageType;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import static javax.swing.SwingConstants.TOP;


public class Message extends javax.swing.JPanel {
    private MessageType messageType = MessageType.SUCCESS;
    private boolean show;

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
    
    public Message() {
        initComponents();
        setOpaque(false);
        setVisible(false);
    }
    public void showMessage(MessageType messageType, String message){
        this.messageType = messageType;
        lbMessage.setText(message);
        if(messageType == MessageType.SUCCESS){
            lbMessage.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/success.png")));
        }else{
            lbMessage.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/error.png")));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMessage = new javax.swing.JLabel();

        setAlignmentX(300);

        lbMessage.setBackground(new java.awt.Color(255, 255, 255));
        lbMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("Message");
        lbMessage.setAlignmentX(0.5F);
        lbMessage.setAutoscrolls(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(299, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs;
        if(messageType == MessageType.SUCCESS){
            lbMessage.setOpaque(true);
            lbMessage.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            g2.setColor(new Color(0,0,0,0));
            lbMessage.setBackground(new java.awt.Color(54, 250, 81,128));
            
        }else{
            lbMessage.setOpaque(true);
            lbMessage.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            g2.setColor(new Color(0,0,0,0));
            lbMessage.setBackground(new java.awt.Color(240,52,53,128));
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.SrcOver);
        g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        
        super.paintComponent(grphcs); 
    }

public static enum MessageType{
    SUCCESS, ERROR
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbMessage;
    // End of variables declaration//GEN-END:variables
}
