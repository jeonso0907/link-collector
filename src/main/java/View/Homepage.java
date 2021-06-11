/*
 * Created by JFormDesigner on Wed Jun 09 22:21:59 EDT 2021
 */

package View;

import Model.Link;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.util.List;

/**
 * @author unknown
 */
public class Homepage extends JFrame {

    private static DefaultListModel model = new DefaultListModel();

    public Homepage() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        list1 = new JList(model);
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- button1 ----
        button1.setText("Launch");

        //---- button2 ----
        button2.setText("Edit");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(117, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addGap(23, 23, 23))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(183, 183, 183)
                    .addComponent(button2)
                    .addContainerGap(187, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addComponent(button1)
                    .addContainerGap(410, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(83, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button2)
                    .addGap(119, 119, 119))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void setJList(List<Link> linkList) {
        for (Link link : linkList) {
            model.addElement(link.getTitle());
        }
    }

}
