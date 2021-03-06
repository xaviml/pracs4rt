package view.dialog.filter;

import controller.filter.IFilter;
import java.text.DecimalFormat;
import view.dialog.BaseDialog;

/**
 * Dialog to show HSB filter.
 * 
 * @author zenbook
 */
public class HSBFilterDialog extends BaseDialog {

    private IFilter filter;
    
    /**
     * Creates new form OptionsDialog
     * @param parent
     * @param modal
     * @param filter
     */
    public HSBFilterDialog(java.awt.Frame parent, boolean modal, IFilter filter) {
        super(parent, modal);
        this.filter =  filter;
        
        float h = filter.getHue();
        float s = filter.getSaturation();
        float b = filter.getBrightness();
        
        hueslider.setValue(valueToSlider(h));
        saturationslider.setValue(valueToSlider(s));
        brightnessslider.setValue(valueToSlider(b));
    }
    
    private String changeValue(float v) {
        DecimalFormat df = new DecimalFormat("0.00");
        if(v >= 0)
            return " "+df.format(v);
        else
            return df.format(v);
    }
    
    private int valueToSlider(float v) {
        return (int) (50 * v + 50);
    }
    
    private float sliderToValue(int v) {
        return (v/50.0f)-1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        saturationslider = new javax.swing.JSlider();
        hueslider = new javax.swing.JSlider();
        brightnessslider = new javax.swing.JSlider();
        cancelbtn = new javax.swing.JButton();
        applybtn = new javax.swing.JButton();
        lblhue = new javax.swing.JLabel();
        lblsaturation = new javax.swing.JLabel();
        lblbrightness = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("HSB Filter");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel1.setText("Hue");

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel2.setText("Saturation");

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel3.setText("Brightness");

        saturationslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                saturationsliderStateChanged(evt);
            }
        });

        hueslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                huesliderStateChanged(evt);
            }
        });

        brightnessslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                brightnesssliderStateChanged(evt);
            }
        });

        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        applybtn.setText("Apply");
        applybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applybtnActionPerformed(evt);
            }
        });

        lblhue.setText(" 0.00");

        lblsaturation.setText(" 0.00");

        lblbrightness.setText(" 0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saturationslider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(brightnessslider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hueslider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblhue, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblsaturation, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblbrightness, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(applybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(hueslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblhue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(saturationslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsaturation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(brightnessslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbrightness))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applybtn)
                    .addComponent(cancelbtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void huesliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_huesliderStateChanged
        lblhue.setText(changeValue(sliderToValue(hueslider.getValue())));
    }//GEN-LAST:event_huesliderStateChanged

    private void saturationsliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_saturationsliderStateChanged
        lblsaturation.setText(changeValue(sliderToValue(saturationslider.getValue())));
    }//GEN-LAST:event_saturationsliderStateChanged

    private void brightnesssliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_brightnesssliderStateChanged
        lblbrightness.setText(changeValue(sliderToValue(brightnessslider.getValue())));
    }//GEN-LAST:event_brightnesssliderStateChanged

    private void applybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applybtnActionPerformed
        float h = sliderToValue(hueslider.getValue());
        float s = sliderToValue(saturationslider.getValue());
        float b = sliderToValue(brightnessslider.getValue());
        filter.changeHSB(h, s, b);
    }//GEN-LAST:event_applybtnActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applybtn;
    private javax.swing.JSlider brightnessslider;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JSlider hueslider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblbrightness;
    private javax.swing.JLabel lblhue;
    private javax.swing.JLabel lblsaturation;
    private javax.swing.JSlider saturationslider;
    // End of variables declaration//GEN-END:variables
}
