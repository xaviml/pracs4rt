/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipmediaplayer;

import Controller.OnImageListener;
import Controller.ZipController;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author zenbook
 */
public class MainFrame extends javax.swing.JFrame implements OnImageListener{

    private ZipController controller;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }
    
    public String showFileChooser(ZipController.FileType fileType) {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(fileType == ZipController.FileType.ZIP)
            fc.setFileFilter(new FileNameExtensionFilter("Zip", "zip"));
        else if(fileType == ZipController.FileType.IMAGE)
            fc.setFileFilter(new FileNameExtensionFilter("Images", new String[]{"png","jpeg", "jpg"}));
        
        int result = fc.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
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
        prevbtn = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();
        automanual = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileField = new javax.swing.JMenu();
        openzipmenu = new javax.swing.JMenuItem();
        openimagemenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imagepanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 62, 254), 2, true));

        javax.swing.GroupLayout imagepanelLayout = new javax.swing.GroupLayout(imagepanel);
        imagepanel.setLayout(imagepanelLayout);
        imagepanelLayout.setHorizontalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagepanelLayout.setVerticalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        prevbtn.setForeground(new java.awt.Color(74, 62, 254));
        prevbtn.setText("<<");
        prevbtn.setEnabled(false);
        prevbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevbtnActionPerformed(evt);
            }
        });

        nextbtn.setForeground(new java.awt.Color(74, 62, 254));
        nextbtn.setText(">>");
        nextbtn.setEnabled(false);
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });

        automanual.setForeground(new java.awt.Color(74, 62, 254));
        automanual.setText("Auto");
        automanual.setEnabled(false);
        automanual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                automanualActionPerformed(evt);
            }
        });

        fileField.setText("File");

        openzipmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        openzipmenu.setText("Open zip...");
        openzipmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openzipmenuActionPerformed(evt);
            }
        });
        fileField.add(openzipmenu);

        openimagemenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        openimagemenu.setText("Open image(s)...");
        openimagemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openimagemenuActionPerformed(evt);
            }
        });
        fileField.add(openimagemenu);

        jMenuBar1.add(fileField);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prevbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(automanual, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prevbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(automanual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevbtnActionPerformed
        if(controller != null) controller.previous();
    }//GEN-LAST:event_prevbtnActionPerformed

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
        if(controller != null) controller.next();
    }//GEN-LAST:event_nextbtnActionPerformed

    private void automanualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_automanualActionPerformed
        if(controller != null) {
            if(automanual.isSelected()) {
                //Si està pressionat serà auto
                automanual.setText("Manual");
                controller.auto(3000);
            }else{
                automanual.setText("Auto");
                controller.manual();
            }
        }
    }//GEN-LAST:event_automanualActionPerformed

    private void openzipmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openzipmenuActionPerformed
        createZipController(ZipController.FileType.ZIP);
    }//GEN-LAST:event_openzipmenuActionPerformed

    private void openimagemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openimagemenuActionPerformed
        createZipController(ZipController.FileType.IMAGE);
    }//GEN-LAST:event_openimagemenuActionPerformed
    
    @Override
    public void onImage(BufferedImage image) {
        JLabel picLabel = new JLabel(new ImageIcon(image));
        add(picLabel);
        imagepanel.add(picLabel);
    }
    
    public void createZipController(ZipController.FileType fileType) {
        prevbtn.enable();
        nextbtn.enable();
        automanual.enable();
        automanual.setSelected(false);
        
        String path = showFileChooser(fileType);
        if(path == null) return;
        controller = new ZipController(path, fileType, this);
        controller.first();
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
    private javax.swing.JToggleButton automanual;
    private javax.swing.JMenu fileField;
    private javax.swing.JPanel imagepanel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton nextbtn;
    private javax.swing.JMenuItem openimagemenu;
    private javax.swing.JMenuItem openzipmenu;
    private javax.swing.JButton prevbtn;
    // End of variables declaration//GEN-END:variables

    
}
