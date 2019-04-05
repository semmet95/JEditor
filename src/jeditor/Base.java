/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeditor;

import java.awt.Desktop;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.StyledEditorKit;

public class Base extends javax.swing.JFrame {
    String lastSavedString = "";
    boolean fileCreated;
    File currentFile;
    Writer writer;
    char choice = 'C';
    boolean triedToClose;
    private JFileChooser fc;
    private final FileFilter ff;

    public Base() {
        try {
            super.setIconImage(ImageIO.read(getClass().getResource("icon2.png")));
        } catch (IOException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        fc = new JFileChooser();
        ff = new FileFilter() {
            @Override
            public boolean accept(File f) {
                return (f.isDirectory() || f.getAbsolutePath().toLowerCase().endsWith(".txt"));
            }

            @Override
            public String getDescription() {
                return "txt and rtf files";
            }

        };
        fc.addChoosableFileFilter(ff);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        maintext = new javax.swing.JTextPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenu = new javax.swing.JMenuItem();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        boldMenu = new javax.swing.JMenuItem(new StyledEditorKit.BoldAction());
        italicMenu = new javax.swing.JMenuItem(new StyledEditorKit.ItalicAction());
        underlineMenu = new javax.swing.JMenuItem(new StyledEditorKit.UnderlineAction());
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cutMenu = new javax.swing.JMenuItem(new StyledEditorKit.CutAction());
        copyMenu = new javax.swing.JMenuItem(new StyledEditorKit.CopyAction());
        pasteMenu = new javax.swing.JMenuItem(new StyledEditorKit.PasteAction());
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        selectallMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenuItem();
        codeMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JEditor 1.0");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(500, 650));

        maintext.setMinimumSize(new java.awt.Dimension(500, 20));
        jScrollPane2.setViewportView(maintext);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");

        newMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenu.setText("New");
        newMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuActionPerformed(evt);
            }
        });
        fileMenu.add(newMenu);

        openMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenu.setText("Open");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        fileMenu.add(openMenu);

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenu.setText("Save");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenu);

        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenu);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        boldMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        boldMenu.setText("Bold");
        editMenu.add(boldMenu);

        italicMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        italicMenu.setText("Italic");
        editMenu.add(italicMenu);

        underlineMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        underlineMenu.setText("Underline");
        editMenu.add(underlineMenu);
        editMenu.add(jSeparator1);

        cutMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutMenu.setText("Cut");
        editMenu.add(cutMenu);

        copyMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copyMenu.setText("Copy");
        editMenu.add(copyMenu);

        pasteMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pasteMenu.setText("Paste");
        editMenu.add(pasteMenu);
        editMenu.add(jSeparator2);

        selectallMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        selectallMenu.setText("Select All");
        selectallMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectallMenuActionPerformed(evt);
            }
        });
        editMenu.add(selectallMenu);

        menuBar.add(editMenu);

        helpMenu.setText("Help");

        aboutMenu.setText("About");
        aboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenu);

        codeMenu.setText("Download Source Code");
        codeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeMenuActionPerformed(evt);
            }
        });
        helpMenu.add(codeMenu);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuActionPerformed
        new About(this, true).setVisible(true);
    }//GEN-LAST:event_aboutMenuActionPerformed

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        if (!fileCreated) {
            int ret = fc.showSaveDialog(this);
            if (ret == JFileChooser.APPROVE_OPTION) {
                String fileName = fc.getSelectedFile().getAbsolutePath();
                if (!fileName.endsWith(".txt")) {
                    fileName += ".txt";
                }
                currentFile = new File(fileName);
                try {
                    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(currentFile)));
                    writer.write(maintext.getText());
                    writer.flush();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
                }
                fileCreated = true;
                lastSavedString = maintext.getText();
                if (triedToClose) {
                    dispose();
                }
            }
        } else if (!lastSavedString.equals(maintext.getText())) {
            try {
                System.out.println(maintext.getText());
                writer.write(maintext.getText());
                writer.flush();
                lastSavedString = maintext.getText();
            } catch (IOException ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (triedToClose) {
                dispose();
            }
        }
    }//GEN-LAST:event_saveMenuActionPerformed

    private void newMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new Base().setVisible(true);
        });
    }//GEN-LAST:event_newMenuActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitMenuActionPerformed

    private void codeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeMenuActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/singh-95/JEditor"));
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_codeMenuActionPerformed

    private void selectallMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectallMenuActionPerformed
        maintext.selectAll();
    }//GEN-LAST:event_selectallMenuActionPerformed

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                Base openedFile = new Base();
                String fileName = fc.getSelectedFile().getAbsolutePath();
                openedFile.currentFile = new File(fileName);
                List<String> lines = Files.readAllLines(openedFile.currentFile.toPath(), StandardCharsets.UTF_8);
                String text = "";
                text = lines.stream().map((x) -> x + "\r\n").reduce(text, String::concat);
                openedFile.maintext.setText(text);
                openedFile.lastSavedString = text;
                openedFile.fileCreated = true;
                openedFile.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(openedFile.currentFile, true)));
                openedFile.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_openMenuActionPerformed

    @Override
    public void dispose() {
        if (!"".equals(maintext.getText()) && !lastSavedString.equals(maintext.getText())) {
            new NotSavedWarning(this, true).setVisible(true);
            switch (choice) {
                case 'Y':
                    triedToClose = true;
                    saveMenuActionPerformed(null);
                    return;
                case 'N':
                    break;
                case 'C':
                    return;
            }
            try {
                if (this.writer != null) {
                    this.writer.flush();
                    this.writer.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JMenuItem boldMenu;
    private javax.swing.JMenuItem codeMenu;
    private javax.swing.JMenuItem copyMenu;
    private javax.swing.JMenuItem cutMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem italicMenu;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    public javax.swing.JTextPane maintext;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newMenu;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JMenuItem pasteMenu;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JMenuItem selectallMenu;
    private javax.swing.JMenuItem underlineMenu;
    // End of variables declaration//GEN-END:variables
}