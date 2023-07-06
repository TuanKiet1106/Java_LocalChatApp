package component;

import event.EventFileReceiver;
import event.EventFileSender;
import swing.blurHash.BlurHash;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.ModelFileSender;
import model.ModelReceiveImage;
import service.Service;

public class ImageItem extends javax.swing.JLayeredPane  {

    public ImageItem() {
        initComponents();
    }
    
    public void setImage(Icon image, ModelFileSender fileSender) {
        fileSender.addEvent(new EventFileSender() {
            @Override
            public void onSending(double percentage) {
                progress.setValue((int) percentage);
            }

            @Override
            public void onStartSending() {
            }

            @Override
            public void onFinish() {
                progress.setVisible(false);
            }
        });
        pic.setImage(image);
    }

    public void setImage(ModelReceiveImage dataImage) {
        int width = dataImage.getWidth();
        int height = dataImage.getHeight();
        int[] data = BlurHash.decode(dataImage.getImage(), width, height, 1);
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        img.setRGB(0, 0, width, height, data, 0, width);
        Icon icon = new ImageIcon(img);
        pic.setImage(icon);
        try {
            Service.getInstance().addFileReceiver(dataImage.getFileID(), new EventFileReceiver() {
                @Override
                public void onReceiving(double percentage) {
                    progress.setValue((int) percentage);
                }

                @Override
                public void onStartReceiving() {

                }

                @Override
                public void onFinish(File file) {
                    progress.setVisible(false);
                    System.out.println("Hello");
                    pic.setImage(new ImageIcon(file.getAbsolutePath()));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new swing.PictureBox();
        progress = new swing.Progress();

        progress.setBorder(null);
        progress.setForeground(new java.awt.Color(255, 255, 255));
        progress.setProgressType(swing.Progress.ProgressType.CANCEL);

        pic.setLayer(progress, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout picLayout = new javax.swing.GroupLayout(pic);
        pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );
        picLayout.setVerticalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );

        setLayer(pic, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.PictureBox pic;
    private swing.Progress progress;
    // End of variables declaration//GEN-END:variables
}
