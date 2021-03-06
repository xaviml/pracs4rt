package view;

import view.dialog.filter.HSBFilterDialog;
import view.dialog.filter.CustomFilterDialog;
import view.dialog.filter.BinaryFilterDialog;
import controller.disk.IDisk;
import controller.player.IPlayer;
import controller.player.OnImageListener;
import controller.MainController;
import controller.compressor.IFXParameters;
import controller.filter.IFilter;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.config.FileType;
import view.dialog.AboutDialog;
import view.dialog.FXOptionsDialog;
import view.dialog.HelpDialog;
import view.dialog.OptionsDialog;
import view.dialog.loading.IGuiLoading;
import view.dialog.loading.LoadingDialog;
import view.dialog.loading.LoadingImplements;

/**
 * This is the main JFrame that shows the player where it plays the videos or images.
 * 
 * @author zenbook
 */
public class MainFrame extends javax.swing.JFrame implements IGuiLoading {
    private State currentstate;
    private boolean isEmpty;

    private enum State {OPEN_ZIP_PLAY, OPEN_ZIP, OPEN_ZIP_PAUSE, OPEN_IMAGE, LOADING, FINISH_LOADING, EMPTY};
    private enum FilterState {CUSTOM, HSB, NEGATIVE, BINARY, ORIGINAL};
    
    private IDisk saver;
    private IPlayer player;
    private IFilter filter;
    private IFXParameters fxparameters;
    
    private FilterState currentFilterState;
    
    private JFileChooser fc;
    private JFileChooser fc_folder;
    
    private LoadingImplements limpl;
    private boolean isLoading;
    private boolean opener;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        currentstate = State.EMPTY;
        changeState(State.EMPTY);
        currentFilterState = FilterState.ORIGINAL;
        
        fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        fc_folder = new JFileChooser(); 
        fc_folder.setCurrentDirectory(new java.io.File("."));
        fc_folder.setDialogTitle("Choose folder");
        fc_folder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc_folder.setAcceptAllFileFilterUsed(false);
        
        //((VideoPanel)imagepanel).loading(true);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        this.setBounds( width/2-this.getWidth()/2, height/2-this.getHeight()/2, this.getWidth(), this.getHeight());
        
        limpl = new LoadingImplements();
        isLoading = false;
        
        MainController controller;
        if (player == null || saver == null || filter == null || fxparameters == null) {
            controller = new MainController((OnImageListener)imagepanel, limpl);//modificar
            player = controller;
            saver = controller;
            filter = controller;
            fxparameters = controller;
        }
    }

    /**
     * This method shows a windows where you can choose the file
     * @param fileType
     * @return 
     */
    
    public String showFileChooser(FileType fileType) {
        fc.setDialogTitle("Open");
        if (fileType == FileType.ZIP) {
            fc.setFileFilter(new FileNameExtensionFilter("Zip", "zip"));
        } else if (fileType == FileType.IMAGE) {
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
     * Shows the file chooser to save a file.
     * 
     * @return 
     */
    
    public String showSaveFileChooser() {
        fc.setDialogTitle("Save");   
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    
    public String selectFolderChooser(){ 
        if (fc_folder.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
            return fc_folder.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    
    @Override
    public void loading(LoadingImplements l) {
        LoadingImplements.updateLoading(loadingbar, loadingstat, l);
    }
    
    @Override
    public void finishLoading() {
        changeState(State.FINISH_LOADING);
        if(opener){
            changeState(State.OPEN_ZIP);
            changeState(State.OPEN_ZIP_PAUSE);  
        }
        player.first();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prevbtn = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();
        playbtn = new javax.swing.JButton();
        imagepanel = new VideoPanel();
        loadingbar = new javax.swing.JProgressBar();
        loadingstat = new javax.swing.JLabel();
        loadingcancelbtn = new javax.swing.JButton();
        menubar = new javax.swing.JMenuBar();
        filebar = new javax.swing.JMenu();
        openzipmenu = new javax.swing.JMenuItem();
        openimagemenu = new javax.swing.JMenuItem();
        saveimagemenu = new javax.swing.JMenuItem();
        savezipmenu = new javax.swing.JMenuItem();
        openfx = new javax.swing.JMenuItem();
        savefx = new javax.swing.JMenuItem();
        fxoptions = new javax.swing.JMenuItem();
        exitmenu = new javax.swing.JMenuItem();
        playerbar = new javax.swing.JMenu();
        optionsmenu = new javax.swing.JMenuItem();
        fullscreenmenu = new javax.swing.JCheckBoxMenuItem();
        filterbar = new javax.swing.JMenu();
        customfiltermenu = new javax.swing.JMenuItem();
        hsbmenu = new javax.swing.JMenuItem();
        negativemenu = new javax.swing.JMenuItem();
        binarymenu = new javax.swing.JMenuItem();
        separatonfiltermenu = new javax.swing.JPopupMenu.Separator();
        originalmenu = new javax.swing.JMenuItem();
        helpbar = new javax.swing.JMenu();
        helpmenu = new javax.swing.JMenuItem();
        aboutmenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ProPlayer");
        setIconImage(Toolkit.getDefaultToolkit().getImage("/view/resource/logo.png"));
        setMinimumSize(new java.awt.Dimension(512, 372));

        prevbtn.setForeground(new java.awt.Color(74, 62, 254));
        prevbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/resource/Rewind24.gif"))); // NOI18N
        prevbtn.setEnabled(false);
        prevbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevbtnActionPerformed(evt);
            }
        });

        nextbtn.setForeground(new java.awt.Color(74, 62, 254));
        nextbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/resource/FastForward24.gif"))); // NOI18N
        nextbtn.setEnabled(false);
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });

        playbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/resource/Play24.gif"))); // NOI18N
        playbtn.setEnabled(false);
        playbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbtnActionPerformed(evt);
            }
        });

        imagepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(156, 156, 156)));

        javax.swing.GroupLayout imagepanelLayout = new javax.swing.GroupLayout(imagepanel);
        imagepanel.setLayout(imagepanelLayout);
        imagepanelLayout.setHorizontalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagepanelLayout.setVerticalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        loadingstat.setText("time");

        loadingcancelbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/resource/Stop16.gif"))); // NOI18N
        loadingcancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadingloadingcancelbtnActionPerformed(evt);
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
        openimagemenu.setText("Open image ...");
        openimagemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openimagemenuActionPerformed(evt);
            }
        });
        filebar.add(openimagemenu);

        saveimagemenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveimagemenu.setText("Save Image (jpg) ...");
        saveimagemenu.setEnabled(false);
        saveimagemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveimagemenuActionPerformed(evt);
            }
        });
        filebar.add(saveimagemenu);

        savezipmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        savezipmenu.setText("Save Zip ...");
        savezipmenu.setEnabled(false);
        savezipmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savezipmenuActionPerformed(evt);
            }
        });
        filebar.add(savezipmenu);

        openfx.setText("Open FX ...");
        openfx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openfxActionPerformed(evt);
            }
        });
        filebar.add(openfx);

        savefx.setText("Save FX ...");
        savefx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savefxActionPerformed(evt);
            }
        });
        filebar.add(savefx);

        fxoptions.setText("FX Options");
        fxoptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fxoptionsActionPerformed(evt);
            }
        });
        filebar.add(fxoptions);

        exitmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitmenu.setText("Exit");
        exitmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitmenuActionPerformed(evt);
            }
        });
        filebar.add(exitmenu);

        menubar.add(filebar);

        playerbar.setText("Player");

        optionsmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        optionsmenu.setText("Options");
        optionsmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsmenuActionPerformed(evt);
            }
        });
        playerbar.add(optionsmenu);

        fullscreenmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        fullscreenmenu.setText("Full screen");
        fullscreenmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullscreenmenuActionPerformed(evt);
            }
        });
        playerbar.add(fullscreenmenu);

        menubar.add(playerbar);

        filterbar.setText("Filter");

        customfiltermenu.setText("Custom Filter");
        customfiltermenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customfiltermenuActionPerformed(evt);
            }
        });
        filterbar.add(customfiltermenu);

        hsbmenu.setText("HSB");
        hsbmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hsbmenuActionPerformed(evt);
            }
        });
        filterbar.add(hsbmenu);

        negativemenu.setText("Negative");
        negativemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativemenuActionPerformed(evt);
            }
        });
        filterbar.add(negativemenu);

        binarymenu.setText("Binary");
        binarymenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binarymenuActionPerformed(evt);
            }
        });
        filterbar.add(binarymenu);

        separatonfiltermenu.setBackground(new java.awt.Color(68, 68, 68));
        filterbar.add(separatonfiltermenu);

        originalmenu.setText("Original");
        originalmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originalmenuActionPerformed(evt);
            }
        });
        filterbar.add(originalmenu);

        menubar.add(filterbar);

        helpbar.setText("Help");

        helpmenu.setText("Help");
        helpmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpmenuActionPerformed(evt);
            }
        });
        helpbar.add(helpmenu);

        aboutmenu.setText("About");
        aboutmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutmenuActionPerformed(evt);
            }
        });
        helpbar.add(aboutmenu);

        menubar.add(helpbar);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagepanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(prevbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(playbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(nextbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loadingbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadingstat, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadingcancelbtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nextbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(playbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prevbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loadingcancelbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadingstat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadingbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevbtnActionPerformed
        if (player != null) {
            player.previous();
        }
    }//GEN-LAST:event_prevbtnActionPerformed

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
        if (player != null) {
            player.next();
        }
    }//GEN-LAST:event_nextbtnActionPerformed

    private void openzipmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openzipmenuActionPerformed
        openFile(FileType.ZIP);
    }//GEN-LAST:event_openzipmenuActionPerformed

    private void openimagemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openimagemenuActionPerformed
        openFile(FileType.IMAGE);
    }//GEN-LAST:event_openimagemenuActionPerformed

    private void saveimagemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveimagemenuActionPerformed
        String path = showSaveFileChooser();
        if(path != null)
            saver.saveImage(path);
    }//GEN-LAST:event_saveimagemenuActionPerformed

    private void playbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playbtnActionPerformed
         if (player != null) {
            if (!player.isPlaying()) {
                //Si està pressionat serà auto
                changeState(State.OPEN_ZIP_PLAY);
                player.play();
            } else {
                changeState(State.OPEN_ZIP_PAUSE);
                player.pause();
            }
        }
    }//GEN-LAST:event_playbtnActionPerformed

    private void savezipmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savezipmenuActionPerformed
        String path = showSaveFileChooser();
        if(path != null)
            saver.saveZip(path);
    }//GEN-LAST:event_savezipmenuActionPerformed

    private void exitmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitmenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitmenuActionPerformed

    private void fullscreenmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullscreenmenuActionPerformed
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
        device.setFullScreenWindow(fullscreenmenu.isSelected() ? this : null);
    }//GEN-LAST:event_fullscreenmenuActionPerformed

    private void optionsmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsmenuActionPerformed
        if(player != null) {
            OptionsDialog dialog = new OptionsDialog(this, false, player);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_optionsmenuActionPerformed

    private void customfiltermenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customfiltermenuActionPerformed
        CustomFilterDialog dialog = new CustomFilterDialog(this, true, filter);
        dialog.setVisible(true);
    }//GEN-LAST:event_customfiltermenuActionPerformed

    private void hsbmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hsbmenuActionPerformed
        HSBFilterDialog dialog = new HSBFilterDialog(this, true, filter);
        dialog.setVisible(true);
    }//GEN-LAST:event_hsbmenuActionPerformed

    private void negativemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativemenuActionPerformed
        filter.negativeFilter();
    }//GEN-LAST:event_negativemenuActionPerformed

    private void binarymenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binarymenuActionPerformed
        BinaryFilterDialog dialog = new BinaryFilterDialog(this, true, filter);
        dialog.setVisible(true);
    }//GEN-LAST:event_binarymenuActionPerformed

    private void originalmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originalmenuActionPerformed
        filter.removeFilter();
    }//GEN-LAST:event_originalmenuActionPerformed

    private void aboutmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutmenuActionPerformed
        AboutDialog dialog = new AboutDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_aboutmenuActionPerformed

    private void helpmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpmenuActionPerformed
        HelpDialog dialog = new HelpDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_helpmenuActionPerformed

    private void openfxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openfxActionPerformed
        String path = selectFolderChooser();
        if(path == null)
            return;
        
        //LoadingDialog dialog = new LoadingDialog(this, true, "Open FX");
        opener = true;
        changeState(State.LOADING);
        limpl.setIGuiLoading(this);
        if(!saver.openFX(path)) {
            /*Never enter here*/
            JOptionPane.showMessageDialog(this,
                "Files not found",
                "File Error",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        /*dialog.setVisible(true);
        switch (dialog.getState()) {
            case BACKGROUND:
                opener = true;
                changeState(State.LOADING);
                LoadingImplements.updateLoading(loadingbar, loadingstat, limpl);
                limpl.setIGuiLoading(this);
                break;
            case CANCEL:
                player.cancelLoading();
                break;
            case DONE:
                changeState(State.OPEN_ZIP);
                changeState(State.OPEN_ZIP_PAUSE);
                player.first();
                break;
        }*/
    }//GEN-LAST:event_openfxActionPerformed

    private void savefxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savefxActionPerformed
        String path = selectFolderChooser();
        if(path == null)
            return;
        
        LoadingDialog dialog = new LoadingDialog(this, true, "Save FX");
        
        limpl.setIGuiLoading(dialog);
        saver.saveFX(path);
        
        dialog.setVisible(true);
        
        switch (dialog.getState()) {
            case BACKGROUND:
                opener = false;
                changeState(State.LOADING);
                LoadingImplements.updateLoading(loadingbar, loadingstat, limpl);
                limpl.setIGuiLoading(this);
                break;
            case CANCEL:
                player.cancelLoading();
                break;
        }
    }//GEN-LAST:event_savefxActionPerformed

    private void fxoptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fxoptionsActionPerformed
        FXOptionsDialog dialog = new FXOptionsDialog(this, true, fxparameters);
        dialog.setVisible(true);
    }//GEN-LAST:event_fxoptionsActionPerformed

    private void loadingloadingcancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadingloadingcancelbtnActionPerformed
        if(isLoading) {
            player.cancelLoading();
            changeState(State.FINISH_LOADING);
        }
    }//GEN-LAST:event_loadingloadingcancelbtnActionPerformed

    /**
     * This method instatiates a MainController to load a video or image.
     * 
     * @param fileType 
     */
    
    public void openFile(FileType fileType) {
        

        String path = showFileChooser(fileType);
        if (path == null) {
            return;
        }
        
        if(fileType == FileType.IMAGE) {
            if(saver.openImage(path)) {
                changeState(State.OPEN_IMAGE);
                player.first();
            } else{
                JOptionPane.showMessageDialog(this,
                "The following file "+path+" doesn't exist.",
                "File Not Found",
                JOptionPane.WARNING_MESSAGE);
            }
        } else if(fileType == FileType.ZIP) {
            
            LoadingDialog dialog = new LoadingDialog(this, true, "Open Zip");
            limpl.setIGuiLoading(dialog);
            
            if(player.isPlaying())
                    playbtnActionPerformed(null);
            
            if(saver.openZip(path)) {
                dialog.setVisible(true);
                switch (dialog.getState()) {
                    case BACKGROUND:
                        opener = true;
                        changeState(State.LOADING);
                        LoadingImplements.updateLoading(loadingbar, loadingstat, limpl);
                        limpl.setIGuiLoading(this);
                        break;
                    case CANCEL:
                        player.cancelLoading();
                        break;
                    case DONE:
                        changeState(State.OPEN_ZIP);
                        changeState(State.OPEN_ZIP_PAUSE);
                        player.first();
                        break;
                }
            } else
                JOptionPane.showMessageDialog(this,
                "The following file "+path+" doesn't exist.",
                "File Not Found",
                JOptionPane.WARNING_MESSAGE);
        }   
        
    }

    private void changeState(State state) {
        
        switch (state) {
            case OPEN_IMAGE:
                isEmpty = false;
                //menu item
                savezipmenu.setEnabled(false);
                saveimagemenu.setEnabled(true);
                savefx.setEnabled(false);
                //player items
                optionsmenu.setEnabled(false);
                prevbtn.setEnabled(false);
                nextbtn.setEnabled(false);
                playbtn.setEnabled(false);
                //filter items
                customfiltermenu.setEnabled(true);
                hsbmenu.setEnabled(true);
                negativemenu.setEnabled(true);
                binarymenu.setEnabled(true);
                originalmenu.setEnabled(true);
                break;
            case OPEN_ZIP:
                isEmpty = false;
                //menu item
                savezipmenu.setEnabled(true);
                saveimagemenu.setEnabled(false);
                savefx.setEnabled(true);
                //filter items
                customfiltermenu.setEnabled(true);
                hsbmenu.setEnabled(true);
                negativemenu.setEnabled(true);
                binarymenu.setEnabled(true);
                originalmenu.setEnabled(true);
                break;
            case OPEN_ZIP_PLAY:
                isEmpty = false;
                //player items
                optionsmenu.setEnabled(true);
                prevbtn.setEnabled(false);
                nextbtn.setEnabled(false);
                playbtn.setEnabled(true);
                playbtn.setIcon(new ImageIcon(getClass().getResource("/view/resource/Pause24.gif")));
                break;
            case OPEN_ZIP_PAUSE:
                isEmpty = false;
                //player items
                optionsmenu.setEnabled(true);
                prevbtn.setEnabled(true);
                nextbtn.setEnabled(true);
                playbtn.setEnabled(true);
                playbtn.setIcon(new ImageIcon(getClass().getResource("/view/resource/Play24.gif")));
                break;
            case LOADING:
                this.isLoading = true;
                //menu item
                savezipmenu.setEnabled(false);
                savefx.setEnabled(false);
                openfx.setEnabled(false);
                openimagemenu.setEnabled(false);
                openzipmenu.setEnabled(false);
                //loading
                loadingbar.setValue(0);
                loadingstat.setText("Calculating...");
                loadingbar.setVisible(true);
                loadingstat.setVisible(true);
                loadingcancelbtn.setVisible(true);
                break;
            case FINISH_LOADING:
                this.isLoading = false;
                //menu item
                if(!isEmpty) {
                    savezipmenu.setEnabled(true);
                    savefx.setEnabled(true);
                }
                openfx.setEnabled(true);
                openimagemenu.setEnabled(true);
                openzipmenu.setEnabled(true);
                //loading
                loadingbar.setVisible(false);
                loadingstat.setVisible(false);
                loadingcancelbtn.setVisible(false);
                break;
            case EMPTY:
                isEmpty = true;
                //menu item
                savezipmenu.setEnabled(false);
                saveimagemenu.setEnabled(false);
                savefx.setEnabled(false);
                //player items
                optionsmenu.setEnabled(false);
                prevbtn.setEnabled(false);
                nextbtn.setEnabled(false);
                playbtn.setEnabled(false);
                //filter items
                customfiltermenu.setEnabled(false);
                hsbmenu.setEnabled(false);
                negativemenu.setEnabled(false);
                binarymenu.setEnabled(false);
                originalmenu.setEnabled(false);
                //loading
                loadingbar.setVisible(false);
                loadingstat.setVisible(false);
                loadingcancelbtn.setVisible(false);
                break;
        }
        this.currentstate = state;
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
    private javax.swing.JMenuItem aboutmenu;
    private javax.swing.JMenuItem binarymenu;
    private javax.swing.JMenuItem customfiltermenu;
    private javax.swing.JMenuItem exitmenu;
    private javax.swing.JMenu filebar;
    private javax.swing.JMenu filterbar;
    private javax.swing.JCheckBoxMenuItem fullscreenmenu;
    private javax.swing.JMenuItem fxoptions;
    private javax.swing.JMenu helpbar;
    private javax.swing.JMenuItem helpmenu;
    private javax.swing.JMenuItem hsbmenu;
    private javax.swing.JPanel imagepanel;
    private javax.swing.JProgressBar loadingbar;
    private javax.swing.JButton loadingcancelbtn;
    private javax.swing.JLabel loadingstat;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenuItem negativemenu;
    private javax.swing.JButton nextbtn;
    private javax.swing.JMenuItem openfx;
    private javax.swing.JMenuItem openimagemenu;
    private javax.swing.JMenuItem openzipmenu;
    private javax.swing.JMenuItem optionsmenu;
    private javax.swing.JMenuItem originalmenu;
    private javax.swing.JButton playbtn;
    private javax.swing.JMenu playerbar;
    private javax.swing.JButton prevbtn;
    private javax.swing.JMenuItem savefx;
    private javax.swing.JMenuItem saveimagemenu;
    private javax.swing.JMenuItem savezipmenu;
    private javax.swing.JPopupMenu.Separator separatonfiltermenu;
    // End of variables declaration//GEN-END:variables

}
