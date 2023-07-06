package form;

import component.ItemPeople;
import event.EventMenuLeft;
import event.EventRequest;
import event.PublicEvent;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelReceiveMessage;
import model.ModelSendMessage;
import model.ModelUserAccount;
import net.miginfocom.swing.MigLayout;
import service.Service;
import swing.ScrollBar;

public class MenuLeft extends javax.swing.JPanel {
    
    public ModelUserAccount getUser() {
        return user;
    }

    public void setUser(ModelUserAccount user) {
        this.user = user;
    }

    private ModelUserAccount user;

    private List<ModelUserAccount> userAccount;
    
    public MenuLeft() {
        initComponents();
        init();
    }
    
    private void init() {
        scroll.getViewport().setBackground(Color.decode("#5A61B7"));
        scroll.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        userAccount = new ArrayList<>();
        
        PublicEvent.getInstance().addEventRequest(new EventRequest() {
            @Override
            public void sendRequest(ModelSendMessage data) {
                
            }
            
            @Override
            public void receiveRequest(ModelReceiveMessage data) {
                String message = "User " + data.getText() + " wants to connect to you";
                int dialogResult = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    ModelUserAccount u = null;
                    for(ModelUserAccount i : userAccount) {
                        if (i.getUsername().equals(data.getText())) {
                            u = i;
                        }
                    }
                    PublicEvent.getInstance().getEventMain().selectUser(u);
                }
            }
        });
        
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void newUser(List<ModelUserAccount> users) {
                for (ModelUserAccount d : users) {
                    userAccount.add(d);
                    menuList.add(new ItemPeople(d), "wrap");
                    refreshMenuList();
                }
            }
            @Override
            public void userConnect(int userID) {
                for (ModelUserAccount u : userAccount) {
                    System.out.println(u.getUserID());
                    if (u.getUserID() == userID) {
                        u.setStatus(true);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        ItemPeople item = (ItemPeople) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }
            @Override
            public void userDisconnect(int userID) {
                for (ModelUserAccount u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(false);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        ItemPeople item = (ItemPeople) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }
        });
        showMessage();
    }
    
    
    
    private void showMessage() {
        //  test data
        menuList.removeAll();
        for (ModelUserAccount d : userAccount) {
            menuList.add(new ItemPeople(null), "wrap");
        }
        refreshMenuList();
    }
    
    private void showGroup() {
        //  test data
        menuList.removeAll();
        for (int i = 0; i < 5; i++) {
            menuList.add(new ItemPeople(null), "wrap");
        }
        refreshMenuList();
    }
    
    private void refreshMenuList() {
        menuList.repaint();
        menuList.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JLayeredPane();
        menuMessage = new component.MenuButton();
        menuGroup = new component.MenuButton();
        scroll = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(90, 97, 183));

        welcomeLabel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome Kiet:  ");
        jLabel1.setMaximumSize(new java.awt.Dimension(103, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(103, 50));
        welcomeLabel.add(jLabel1);

        menu.setLayout(new java.awt.GridLayout(1, 0));

        menuMessage.setBackground(new java.awt.Color(59, 63, 119));
        menuMessage.setBorder(null);
        menuMessage.setHideActionText(true);
        menuMessage.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/icon/messageMenu_selected.png"))); // NOI18N
        menuMessage.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/icon/messageMenu.png"))); // NOI18N
        menuMessage.setMaximumSize(new java.awt.Dimension(96, 32));
        menuMessage.setMinimumSize(new java.awt.Dimension(96, 32));
        menuMessage.setPreferredSize(new java.awt.Dimension(96, 32));
        menuMessage.setSelected(true);
        menuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessageActionPerformed(evt);
            }
        });
        menu.add(menuMessage);

        menuGroup.setBorder(null);
        menuGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/groupMenu.png"))); // NOI18N
        menuGroup.setHideActionText(true);
        menuGroup.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/icon/groupMenu_selected.png"))); // NOI18N
        menuGroup.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/icon/groupMenu.png"))); // NOI18N
        menuGroup.setMaximumSize(new java.awt.Dimension(96, 32));
        menuGroup.setMinimumSize(new java.awt.Dimension(96, 32));
        menuGroup.setPreferredSize(new java.awt.Dimension(96, 32));
        menuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupActionPerformed(evt);
            }
        });
        menu.add(menuGroup);

        scroll.setBackground(new java.awt.Color(90, 97, 183));
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scroll.setOpaque(false);

        menuList.setLayout(new java.awt.FlowLayout());
        scroll.setViewportView(menuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(welcomeLabel)
                    .addComponent(scroll))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMessageActionPerformed
        if (!menuMessage.isSelected()) {
            menuMessage.setSelected(true);
            showMessage();
        }
    }//GEN-LAST:event_menuMessageActionPerformed

    private void menuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupActionPerformed
        if (!menuGroup.isSelected()) {
            menuMessage.setSelected(false);
            menuGroup.setSelected(true);
            showGroup();
        }
    }//GEN-LAST:event_menuGroupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane menu;
    private component.MenuButton menuGroup;
    private javax.swing.JLayeredPane menuList;
    private component.MenuButton menuMessage;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLayeredPane welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
