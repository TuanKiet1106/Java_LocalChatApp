package main;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import event.EventImageView;
import event.EventMain;
import event.PublicEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.ModelUserAccount;
import service.Service;
import swing.ComponentResizer;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        init();
    }
    
    private void init() {
        setIconImage(new ImageIcon(getClass().getResource("/icon/icon.png")).getImage());  
        ComponentResizer com = new ComponentResizer();
        com.registerComponent(this);
        setMinimumSize(new Dimension(800, 500));
        setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        com.setSnapSize(new Dimension(10, 10));
        login.setVisible(true);
        loading.setVisible(false);
        view_image.setVisible(false);
        home.setVisible(true);
        initEvent();
        Service.getInstance().startServer();
    }
    
    private void initEvent() {
        PublicEvent.getInstance().addEventMain(new EventMain() {
            @Override
            public void showLoading(boolean show) {
                loading.setVisible(show);
            }

            @Override
            public void initChat() {
                home.setVisible(true);
                login.setVisible(false);
                Service.getInstance().getClient().emit("list_user", Service.getInstance().getUser().getUserID());
            }
            
            @Override
            public void selectUser(ModelUserAccount user) {
                home.setUser(user);
            }

            @Override
            public void updateUser(ModelUserAccount user) {
                home.updateUser(user);
            }
        });
        
        PublicEvent.getInstance().addEventImageView(new EventImageView() {
            @Override
            public void viewImage(Icon image) {
                view_image.viewImage(image);
            }

            @Override
            public void saveImage(Icon image) {
                System.out.println("Save Image next update");
            }

        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        loading = new form.Loading();
        login = new form.Login();
        view_image = new form.ViewImage();
        home = new form.Home();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setLayout(new java.awt.CardLayout());
        jLayeredPane1.add(loading, "card5");
        jLayeredPane1.add(login, "card4");

        view_image.setOpaque(false);
        jLayeredPane1.setLayer(view_image, javax.swing.JLayeredPane.POPUP_LAYER);
        jLayeredPane1.add(view_image, "card3");
        jLayeredPane1.add(home, "card2");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatArcIJTheme.setup();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private form.Home home;
    private javax.swing.JLayeredPane jLayeredPane1;
    private form.Loading loading;
    private form.Login login;
    private form.ViewImage view_image;
    // End of variables declaration//GEN-END:variables
}
