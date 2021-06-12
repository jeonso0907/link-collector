/*
 * Created by JFormDesigner on Fri Jun 11 18:52:09 EDT 2021
 */

package View;

import javax.swing.*;

/**
 * @author unknown
 */
public class MainFrame extends JFrame {

    public Login login = new Login();

    public MainFrame() {
        this.setTitle("Link Collector");
        this.add(login);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 700);
        this.setVisible(true);
    }

}
