package form;

import component.ChatBody;
import component.ChatBottom;
import component.ChatTitle;
import event.EventChat;
import event.PublicEvent;
import model.ModelReceiveMessage;
import model.ModelSendMessage;
import model.ModelUserAccount;
import net.miginfocom.swing.MigLayout;

public class Chat extends javax.swing.JPanel {

    private ChatTitle chatTitle;
    private ChatBody chatBody;
    private ChatBottom chatBottom;
    
    public Chat() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx", "5[fill]8", "5[]5[100%, bottom]5[shrink 0]5"));
        chatTitle = new ChatTitle();
        chatBody = new ChatBody();
        chatBottom = new ChatBottom();
        PublicEvent.getInstance().addEventChat(new EventChat() {
            @Override
            public void sendMessage(ModelSendMessage data) {
                chatBody.addItemRight(data);
            }
            
            @Override
            public void receiveMessage(ModelReceiveMessage data) {
                if (chatTitle.getUser().getUserID() == data.getFromUserID()) {
                    chatBody.addItemLeft(data);
                }
            }
        });
        
        add(chatTitle, "wrap");
        add(chatBody, "wrap");
        add(chatBottom, "h ::50%");
    }
    
    public void setUser(ModelUserAccount user) {
        chatTitle.setUserName(user);
        chatBottom.setUser(user);
        chatBody.clearChat();
    }

    public void updateUser(ModelUserAccount user) {
        chatTitle.updateUser(user);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
