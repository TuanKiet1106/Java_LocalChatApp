package component;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import model.ModelReceiveImage;

public class ChatLeft extends javax.swing.JLayeredPane {

    public ChatLeft() {
        initComponents();
        txt.setBackground(new Color(242, 242, 242));
    }
    
    public void setText(String text) {
        if (text.equals("")) {
            txt.hideText();
        } else {
            txt.setText(text);
        }
        txt.setColor(Color.BLACK);
    }
    
    public void setImage(Icon... image) {
        //txt.setImage(false, image);
    }
    
    public void setImage(ModelReceiveImage dataImage) {
        txt.setImage(false, dataImage);
    }
    
    public void setFile(String fileName, String fileSize) {
        txt.setFile(fileName, fileSize);
    }
    
    public void setEmoji(Icon icon) {
        txt.hideText();
        txt.setEmoji(false, icon);
    }
    
    public void setTime() {
        Date currentDateTime = new Date();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        String formatterDateTime = dateFormat.format(currentDateTime);
        txt.setTime(formatterDateTime); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new component.ChatItem();

        setOpaque(true);

        txt.setOpaque(false);

        setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.ChatItem txt;
    // End of variables declaration//GEN-END:variables
}
