/*
 * Created by JFormDesigner on Fri Jun 11 21:30:48 EDT 2021
 */

package View;

import Controller.LinkController;
import Firebase.Firebase;
import Model.User;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.GroupLayout;

import static Controller.LinkController.getMainFrame;

/**
 * @author unknown
 */
public class Login extends JPanel {
    public Login() {
        initComponents();
    }

    private void loginBtnMouseClicked(MouseEvent e) throws IOException {
        // TODO add your code here
        User user = new User(idText.getText(), pwText.getText());
        Firebase fireBase = LinkController.getFirebase();
        Boolean isAuth = fireBase.isAuth(user);
        System.out.println(isAuth);
    }

    private void signupBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        Signup signUp = new Signup();
        MainFrame2 mainFrame = getMainFrame();
        mainFrame.setPanel(signUp);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        idText = new JTextField();
        pwText = new JTextField();
        idLabel = new JLabel();
        pwLabel = new JLabel();
        loginBtn = new JButton();
        signupBtn = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
        .EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax
        .swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,
        12),java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans
        .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.
        getPropertyName()))throw new RuntimeException();}});

        //---- idLabel ----
        idLabel.setText("ID");

        //---- pwLabel ----
        pwLabel.setText("PW");

        //---- loginBtn ----
        loginBtn.setText("Login");
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    loginBtnMouseClicked(e);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        //---- signupBtn ----
        signupBtn.setText("Signup");
        signupBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                signupBtnMouseClicked(e);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(idLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(pwLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(40, 40, 40)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(pwText)
                            .addComponent(idText, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                        .addComponent(signupBtn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                    .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(idText)
                        .addComponent(idLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(pwLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pwText))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(loginBtn)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(signupBtn)
                    .addGap(55, 55, 55))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField idText;
    private JTextField pwText;
    private JLabel idLabel;
    private JLabel pwLabel;
    private JButton loginBtn;
    private JButton signupBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    


}
