package form;

import event.EventLogin;
import event.EventMessage;
import event.PublicEvent;
import io.socket.client.Ack;
import model.ModelLogin;
import model.ModelMessage;
import model.ModelRegister;
import model.ModelUserAccount;
import service.Service;

public class Login extends javax.swing.JPanel {

    public Login() {
        initComponents();
        init();
    }
    
    private void init() {
        PublicEvent.getInstance().addEventLogin(new EventLogin() {
            @Override
            public void login(ModelLogin data) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        PublicEvent.getInstance().getEventMain().showLoading(true);
                        Service.getInstance().getClient().emit("login", data.toJsonObject(), new Ack() {
                            @Override
                            public void call(Object... os) {
                                if (os.length > 0) {
                                    boolean action = (Boolean) os[0];
                                    if (action) {
                                        Service.getInstance().setUser(new ModelUserAccount(os[1]));
                                        PublicEvent.getInstance().getEventMain().showLoading(false);
                                        PublicEvent.getInstance().getEventMain().initChat();
                                    } else {
                                        //  password wrong
                                        PublicEvent.getInstance().getEventMain().showLoading(false);
                                    }
                                } else {
                                    PublicEvent.getInstance().getEventMain().showLoading(false);
                                }
                            }
                        });

                    }
                }).start();
            }

            @Override
            public void register(ModelRegister data, EventMessage message) {
                Service.getInstance().getClient().emit("register", data.toJsonObject(), new Ack() {
                    @Override
                    public void call(Object... os) {
                        if (os.length > 0) {
                            ModelMessage ms = new ModelMessage((boolean) os[0], os[1].toString());
                            if (ms.isAction()) {
                                ModelUserAccount user = new ModelUserAccount(os[2]);
                                Service.getInstance().setUser(user);
                            }
                            //  call message back when done register
                        }
                    }
                });
            }

            @Override
            public void goRegister() {
                slide.show(1);
            }

            @Override
            public void goLogin() {
                slide.show(0);
            }
        });
        PLogin login = new PLogin();
        PRegister register = new PRegister();
        slide.init(login, register);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new swing.PictureBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        slide = new swing.PanelSlide();

        setBackground(new java.awt.Color(255, 255, 255));

        pic.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/img/login.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(90, 97, 183));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        slide.setBackground(new java.awt.Color(255, 255, 255));
        slide.setPreferredSize(new java.awt.Dimension(270, 1000));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                        .addGap(108, 108, 108))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private swing.PictureBox pic;
    private swing.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
