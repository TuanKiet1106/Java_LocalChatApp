package component;

import java.awt.Color;
import model.ModelUserAccount;

public class ChatTitle extends javax.swing.JPanel {
    
    public ModelUserAccount getUser() {
        return user;
    }

    private ModelUserAccount user;
    
    public ChatTitle() {
        initComponents();
    }
    
    public void setUserName(ModelUserAccount user) {
        this.user = user;
        lbName.setText(user.getUsername());
        if (user.isStatus()) {
            statusActive();
        } else {
            setStatusText("Offline");
        }
    }

    public void updateUser(ModelUserAccount user) {
        if (this.user == user) {
            lbName.setText(user.getUsername());
            if (user.isStatus()) {
                statusActive();
            } else {
                setStatusText("Offline");
            }
        }
    }

    public void statusActive() {
        lbStatus.setText("Active now");
        lbStatus.setForeground(new java.awt.Color(0, 153, 0));
    }

    public void setStatusText(String text) {
        lbStatus.setText(text);
        lbStatus.setForeground(new java.awt.Color(160, 160, 160));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer = new javax.swing.JLayeredPane();
        lbName = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        layer.setLayout(new java.awt.GridLayout(2, 1));

        lbName.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbName.setText("Name");
        layer.add(lbName);

        lbStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(153, 153, 153));
        lbStatus.setText("Active now");
        layer.add(lbStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(585, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}
