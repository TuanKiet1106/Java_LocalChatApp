package component;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;

public class ChatLeftWithProfile extends javax.swing.JLayeredPane {

    public ChatLeftWithProfile() {
        initComponents();
        txt.setBackground(new Color(242, 242, 242));
    }
    
    public void setUserProfile(String user) {
        txt.setUserProfile(user);
    }

    public void setImageProfile(Icon image) {
        IaImage.setImage(image);
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
    
    public void setImage(String... image) {
        //txt.setImage(false, image);
    }
    
    public void setFile(String fileName, String fileSize) {
        txt.setFile(fileName, fileSize);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        IaImage = new swing.ImageAvatar();
        txt = new component.ChatItem();

        setOpaque(true);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        IaImage.setBorderSize(0);
        IaImage.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/img/profile1.jpg"))); // NOI18N

        jLayeredPane1.setLayer(IaImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IaImage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(IaImage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        add(jLayeredPane1);

        txt.setOpaque(false);
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvatar IaImage;
    private javax.swing.JLayeredPane jLayeredPane1;
    private component.ChatItem txt;
    // End of variables declaration//GEN-END:variables
}
