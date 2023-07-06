package component;

import app.MessageType;
import event.PublicEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.ModelSendMessage;
import model.ModelUserAccount;
import service.Service;

public class ItemPeople extends javax.swing.JPanel {
    
    public ModelUserAccount getUser() {
        return user;
    }
    
    private boolean mouseOver;
    private final ModelUserAccount user;
    
    public ItemPeople(ModelUserAccount user) {
        this.user = user;
        initComponents();
        nameLabel.setText(user.getUsername());
        activeStatus.setActive(user.isStatus());
        init();
    }
    
    public void updateStatus() {
        activeStatus.setActive(user.isStatus());
    }
    
    private void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(Color.decode("#3b3f77"));
                mouseOver = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(Color.decode("#5a61b7"));
                mouseOver = false;
            }
            
            @Override
            public void mouseReleased(MouseEvent me) {
                if (mouseOver) {
                    if (user.isStatus()) {
                        PublicEvent.getInstance().getEventMain().selectUser(user);
                        ModelSendMessage message = new ModelSendMessage(MessageType.TEXT, Service.getInstance().getUser().getUserID(), user.getUserID(), Service.getInstance().getUser().getUsername());
                        sendRequest(message);
                    }
                }
            }
        });
    }
    
    private void sendRequest(ModelSendMessage data) {
        Service.getInstance().getClient().emit("send_request_to_user", data.toJsonObject());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new swing.ImageAvatar();
        nameLabel = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        activeStatus = new swing.ActiveStatus();

        setBackground(new java.awt.Color(90, 97, 183));

        imageAvatar1.setBorderSize(0);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N

        nameLabel.setBackground(new java.awt.Color(90, 97, 183));
        nameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("Name");

        lbStatus.setBackground(new java.awt.Color(90, 97, 183));
        lbStatus.setFont(new java.awt.Font("Comic Sans MS", 2, 12)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(204, 204, 204));
        lbStatus.setText("New User");

        activeStatus.setActive(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbStatus)
                        .addGap(3, 3, 3)
                        .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(activeStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ActiveStatus activeStatus;
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
