package custom_entity;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import entities.DonDatTour;
import net.miginfocom.swing.MigLayout;
import scrollbar.ScrollBarCustom;

public class CustomScollPane extends javax.swing.JPanel {

    public CustomScollPane() {
        initComponents();
        setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        panel.setLayout(new MigLayout("center,filly,wrap,gapy 100"));
        JLabel lblTieuDe = new JLabel("Danh Sách Vé Của Bạn");
        lblTieuDe.setFont(new Font("times new roman", 1, 30));
        panel.add(lblTieuDe,"center");
        
    }

    public void themVe(DonDatTour donDatTour) {
    	JPanel ticket = new JPanel();
    	ticket.setPreferredSize(new Dimension(800,150));
    	//labelBackground.setIcon(new ImageIcon("src\\images\\"));
    	ticket.setLayout(new MigLayout("wrap 3", "grow", "grow"));
    	
    	ticket.setBorder(new RoundedCornerBorder());
    	JLabel logo = new JLabel("");
    	logo.setIcon(new ImageIcon("src\\images\\logo.png"));
    	ticket.add(logo,"align left top");
    	
        JLabel lblTenTour = new JLabel(donDatTour.getTour().getTenTour());
        lblTenTour.setFont(new Font("sansserif", 1, 30));
        lblTenTour.setForeground(ChonMau.blue_4B70F5);
        ticket.add(lblTenTour, "align center");
        
        JLabel lblNgayDat = new JLabel(donDatTour.getNgayDat().toString());
        lblNgayDat.setFont(new Font("sansserif", 0, 20));
        ticket.add(lblNgayDat, "align right top");
        
        JLabel lblmaTour = new JLabel(donDatTour.getTour().getMaTour());
        lblmaTour.setFont(new Font("sansserif", 0, 20));
        ticket.add(lblmaTour,"align left bot");
        
        JLabel nulllbl = new JLabel();
        ticket.add(nulllbl);
        
        JLabel lblSoVe = new JLabel("Số lượng vé :"+donDatTour.getSoVeDat());
        lblSoVe.setFont(new Font("sansserif", 0, 30));
        lblSoVe.setForeground(ChonMau.blue_4B70F5);
        ticket.add(lblSoVe,"align right bot");
        panel.add(ticket);
        
        
        
        /*JLabel ngayDat = new JLabel(donDatTour.getTour().getTenTour());
        ngayDat.setForeground(new Color(180, 180, 180));
        panel.add(ngayDat, "center, wrap");*/
		/*
		 * JTextPane txt = new JTextPane(); txt.setBackground(new Color(0, 0, 0, 0));
		 * txt.setForeground(new Color(120, 120, 120)); txt.setSelectionColor(new
		 * Color(150, 150, 150)); txt.setBorder(null); txt.setOpaque(false);
		 * txt.setEditable(false); txt.setText(donDatTour.toString()); panel.add(txt,
		 * "w 100::90%, wrap");
		 */
        panel.setBorder(new RoundedCornerBorder());
    }

    public void scrollToTop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jScrollPane1.getVerticalScrollBar().setValue(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(Color.white); // HUY

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
