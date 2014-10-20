/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipmediaplayer;

import Controller.OnImageListener;
import Controller.ZipController;
import Model.Imatge;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author zenbook
 */
public class MainFrame extends javax.swing.JFrame implements OnImageListener {

    private ZipController controller;
    private BufferedImage currentImage;
    private AffineTransform at;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        imagepanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                paintImage();
            }
        });
       /* getLayeredPane().add(imagepanel, 0);
        getLayeredPane().add(menubar, 1);
        getLayeredPane().add(filebar, 2);*/
        
        
    }

    public String showFileChooser(ZipController.FileType fileType) {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fileType == ZipController.FileType.ZIP) {
            fc.setFileFilter(new FileNameExtensionFilter("Zip", "zip"));
        } else if (fileType == ZipController.FileType.IMAGE) {
            fc.setFileFilter(new FileNameExtensionFilter("Images", new String[]{"png", "jpeg", "jpg"}));
        }

        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagepanel = new javax.swing.JPanel();
        playbtn = new javax.swing.JToggleButton();
        nextbtn = new javax.swing.JButton();
        prevbtn = new javax.swing.JButton();
        menubar = new javax.swing.JMenuBar();
        filebar = new javax.swing.JMenu();
        openzipmenu = new javax.swing.JMenuItem();
        openimagemenu = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(512, 372));
        setPreferredSize(new java.awt.Dimension(513, 373));

        imagepanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 62, 254), 2, true));

        javax.swing.GroupLayout imagepanelLayout = new javax.swing.GroupLayout(imagepanel);
        imagepanel.setLayout(imagepanelLayout);
        imagepanelLayout.setHorizontalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagepanelLayout.setVerticalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        playbtn.setForeground(new java.awt.Color(74, 62, 254));
        playbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zipmediaplayer/Play24.gif"))); // NOI18N
        playbtn.setEnabled(false);
        playbtn.setMinimumSize(new java.awt.Dimension(38, 36));
        playbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbtnActionPerformed(evt);
            }
        });

        nextbtn.setForeground(new java.awt.Color(74, 62, 254));
        nextbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zipmediaplayer/FastForward24.gif"))); // NOI18N
        nextbtn.setEnabled(false);
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });

        prevbtn.setForeground(new java.awt.Color(74, 62, 254));
        prevbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zipmediaplayer/Rewind24.gif"))); // NOI18N
        prevbtn.setEnabled(false);
        prevbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevbtnActionPerformed(evt);
            }
        });

        filebar.setText("File");

        openzipmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        openzipmenu.setText("Open zip...");
        openzipmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openzipmenuActionPerformed(evt);
            }
        });
        filebar.add(openzipmenu);

        openimagemenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        openimagemenu.setText("Open image(s)...");
        openimagemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openimagemenuActionPerformed(evt);
            }
        });
        filebar.add(openimagemenu);

        menubar.add(filebar);

        jMenu1.setText("About");
        menubar.add(jMenu1);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prevbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(playbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prevbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(playbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nextbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevbtnActionPerformed
        if (controller != null) {
            controller.previous();
        }
    }//GEN-LAST:event_prevbtnActionPerformed

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
        if (controller != null) {
            controller.next();
        }
    }//GEN-LAST:event_nextbtnActionPerformed

    private void playbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playbtnActionPerformed
        if (controller != null) {
            if (playbtn.isSelected()) {
                //Si està pressionat serà auto
                playbtn.setIcon(new ImageIcon(getClass().getResource("/zipmediaplayer/Pause24.gif")));
                prevbtn.setEnabled(false);
                nextbtn.setEnabled(false);
                controller.play();
            } else {
                playbtn.setIcon(new ImageIcon(getClass().getResource("/zipmediaplayer/Play24.gif")));
                prevbtn.setEnabled(true);
                nextbtn.setEnabled(true);
                controller.pause();
            }
        }
    }//GEN-LAST:event_playbtnActionPerformed

    private void openzipmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openzipmenuActionPerformed
        createZipController(ZipController.FileType.ZIP);
    }//GEN-LAST:event_openzipmenuActionPerformed

    private void openimagemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openimagemenuActionPerformed
        createZipController(ZipController.FileType.IMAGE);
    }//GEN-LAST:event_openimagemenuActionPerformed

    
    @Override
    public void onImage(Imatge imatge) {
        //update(getGraphics());
        /* TODO : fer update quan es canvia de fitxer*/
        currentImage = imatge.getImage();
        paintImage();
    }
    
    public void paintImage() {
        if(currentImage != null) {
            Graphics2D g = (Graphics2D) imagepanel.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

            double scaleX = GetScaleX(imagepanel.getWidth(), currentImage.getWidth());
            double scaleY = GetScaleY(imagepanel.getHeight(), currentImage.getHeight());

            double xPos = ((imagepanel.getWidth() - scaleX * currentImage.getWidth())/2.);
            double yPos = ((imagepanel.getHeight() - scaleY * currentImage.getHeight())/2.);

            at = AffineTransform.getTranslateInstance(xPos, yPos);

            at.scale(scaleX, scaleY);
            g.drawRenderedImage(currentImage, at);
        }
    }
    
    

    private double GetScaleY(int panelHeight, int imageHeight) {
        double yScale = 1;
        
        if (imageHeight > panelHeight) {
            yScale = (double)imageHeight / panelHeight;
        } else if (imageHeight < panelHeight) {
            yScale = (double)panelHeight / imageHeight;
        }
        return yScale;
    }
    
    private double GetScaleX(int panelWidth, int imageWidth) {
        double xScale = 1;
        if (imageWidth > panelWidth) {
            xScale = (double)imageWidth  / panelWidth;
        } else if (imageWidth < panelWidth) {
            xScale = (double)panelWidth / imageWidth;
        }
        return xScale;
    }
    
    public void createZipController(ZipController.FileType fileType) {
        String path = showFileChooser(fileType);
        if (path == null) {
            return;
        }
        if (controller == null) {
            controller = new ZipController(path, fileType, this);
        } else {
            if(fileType == ZipController.FileType.IMAGE) {
                controller.openImage(path);
            } else if(fileType == ZipController.FileType.ZIP) {
                controller.openZip(path);
            }
        }
        controller.first();
        prevbtn.setEnabled(true);
        nextbtn.setEnabled(true);
        playbtn.setEnabled(true);
        playbtn.setSelected(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame m = new MainFrame();
                m.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu filebar;
    private javax.swing.JPanel imagepanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JButton nextbtn;
    private javax.swing.JMenuItem openimagemenu;
    private javax.swing.JMenuItem openzipmenu;
    private javax.swing.JToggleButton playbtn;
    private javax.swing.JButton prevbtn;
    // End of variables declaration//GEN-END:variables

}
