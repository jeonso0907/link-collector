/*
 * Created by JFormDesigner on Sat Jun 12 12:44:53 EDT 2021
 */

package View;

import Controller.LinkController;
import Firebase.Firebase;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import static Controller.LinkController.getMainFrame;

/**
 * @author unknown
 */
public class Signup extends JPanel {
    public Signup() {
        initComponents();
    }

    private void backBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        Login login = new Login();
        MainFrame2 mainFrame = getMainFrame();
        mainFrame.setPanel(login);
    }

    private void submitBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        Firebase fireBase = LinkController.getFirebase();


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        textField1 = new JTextField();
        label1 = new JLabel();
        pwText = new JTextField();
        pwLabel = new JLabel();
        backBtn = new JButton();
        submitBtn = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
        . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax
        . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,
        12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
        . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .
        getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("Email");

        //---- pwLabel ----
        pwLabel.setText("PW");

        //---- backBtn ----
        backBtn.setText("Back");
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backBtnMouseClicked(e);
            }
        });

        //---- submitBtn ----
        submitBtn.setText("Submit");
        submitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                submitBtnMouseClicked(e);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pwLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createParallelGroup()
                            .addComponent(textField1)
                            .addComponent(pwText, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(backBtn)
                                .addComponent(submitBtn))
                            .addGap(57, 57, 57)))
                    .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(pwLabel, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(pwText, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                    .addGap(12, 12, 12)
                    .addComponent(submitBtn)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(backBtn)
                    .addGap(51, 51, 51))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField textField1;
    private JLabel label1;
    private JTextField pwText;
    private JLabel pwLabel;
    private JButton backBtn;
    private JButton submitBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
