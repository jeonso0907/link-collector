/*
 * Created by JFormDesigner on Fri Jun 11 21:06:14 EDT 2021
 */

package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.jgoodies.forms.layout.*;

/**
 * @author unknown
 */
public class MainFrame2 extends JFrame {

    public Login login = new Login();

    public MainFrame2() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        contentPane.add(login);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
