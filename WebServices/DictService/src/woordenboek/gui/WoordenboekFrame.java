/*
 * MainFrame.java
 *
 * Created on 21 november 2007, 21:10
 */
package woordenboek.gui;

import woordenboek.data.Woordenboek;
import woordenboek.data.WoordenboekDAO;
import woordenboek.impl.*;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Wijnand
 */
public class WoordenboekFrame extends javax.swing.JFrame {

    WoordenboekDAO woordenboekDAO;
    List<Woordenboek> woordenboeken;

    /**
     * Creates new form MainFrame
     */
    public WoordenboekFrame() {
        initComponents();
        try {
            woordenboekDAO = new WoordenBoekDAOReal();
           // woordenboekDAO = new WoordenboekDAODummy();
            woordenboeken = woordenboekDAO.getWoordenboeken();
            woordenboekLijst.setListData(new Vector(woordenboeken));
            if (woordenboeken.size() > 0) {
                woordenboekLijst.setSelectedIndex(0);
            }
            woordenLijst.setListData(new Vector<String>());
            definitieLijst.setListData(new Vector<String>());
        } catch (Exception e) {
            System.out.println("Applicatie kan niet opstraten:" + e.getMessage());
            throw new RuntimeException();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        woordenboekLijst = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        woordVeld = new javax.swing.JTextField();
        zoekKnop = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        woordenLijst = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        definitieLijst = new javax.swing.JList();
        definitieKnop = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        woordenboekLijst.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(woordenboekLijst);

        jLabel1.setText("woord:");

        zoekKnop.setText("zoek op prefix:");
        zoekKnop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoekKnopActionPerformed(evt);
            }
        });

        woordenLijst.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(woordenLijst);

        definitieLijst.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        definitieLijst.setEnabled(false);
        jScrollPane3.setViewportView(definitieLijst);

        definitieKnop.setText("definitie:");
        definitieKnop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                definitieKnopActionPerformed(evt);
            }
        });

        jLabel2.setText("woordenboeken:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(zoekKnop)
                        .addComponent(woordVeld, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addComponent(definitieKnop, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(woordVeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(zoekKnop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(definitieKnop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void zoekKnopActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_zoekKnopActionPerformed
	{//GEN-HEADEREND:event_zoekKnopActionPerformed
            String woord = woordVeld.getText();
            if (woord.equals("")) {
                return;
            }
            Vector<String> woorden = new Vector<>();
            int[] indices = woordenboekLijst.getSelectedIndices();
            for (int i : indices) {
                String id = woordenboeken.get(i).getID();
                try {
                    woorden.addAll(woordenboekDAO.zoekWoorden(woord, id));
                } catch (Exception e) {
                    System.out.println("Probleem met zoeken woorden "+ e.getMessage());
                }
                woordenLijst.setListData(woorden);
                if (!woorden.isEmpty()) {
                    woordenLijst.setSelectedIndex(0);
                }
            }

}//GEN-LAST:event_zoekKnopActionPerformed

	private void definitieKnopActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_definitieKnopActionPerformed
	{//GEN-HEADEREND:event_definitieKnopActionPerformed
            int[] indices = (int[]) woordenLijst.getSelectedIndices();
            Vector<String> definities = new Vector<String>();
            for (int i : indices) {
                String woord = (String) woordenLijst.getModel().getElementAt(i);
                int[] indices2 = woordenboekLijst.getSelectedIndices();
                for (int j : indices2) {
                    String id = woordenboeken.get(j).getID();
                    definities.addAll(woordenboekDAO.getDefinities(woord, id));
                }
            }
            definitieLijst.setListData(definities);
	}//GEN-LAST:event_definitieKnopActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WoordenboekFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton definitieKnop;
    private javax.swing.JList definitieLijst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField woordVeld;
    private javax.swing.JList woordenLijst;
    private javax.swing.JList woordenboekLijst;
    private javax.swing.JButton zoekKnop;
    // End of variables declaration//GEN-END:variables
}