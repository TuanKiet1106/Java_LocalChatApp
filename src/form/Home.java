package form;

import java.awt.Color;
import model.ModelUserAccount;
import net.miginfocom.swing.MigLayout;


public class Home extends javax.swing.JLayeredPane {
    
    private Chat chat;
    private MenuLeft menuLeft;
    
    public Home() {
        initComponents();
        init();
    }
    
    private void init() {
        setLayout(new MigLayout("fillx, filly, insets 0", "[25%][75%]"));
        chat = new Chat();
        menuLeft = new MenuLeft();
        this.add(menuLeft, "grow");
        this.add(chat, "grow");
        chat.setVisible(false);
    }
    
    public void setUser(ModelUserAccount user) {
        chat.setUser(user);
        chat.setVisible(true);
        menuLeft.setUser(user);
    }

    public void updateUser(ModelUserAccount user) {
        chat.updateUser(user);
        menuLeft.setUser(user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(true);
        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
