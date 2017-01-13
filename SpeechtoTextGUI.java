/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speachtotext;

/**
 *
 * @author Naitik
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.Container;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import sun.tools.jar.resources.jar;

public class SpeechtoTextGUI extends JFrame {

    JLabel data  = new JLabel("");
    public void setData(String value)
    {
        data.setText(value);
    }       
    public void simplegui(){

        JFrame f=new JFrame();
        f.setTitle("Speech to Text");
        JButton exit=new JButton("exit");
        JLabel defult = new JLabel();
        defult.setText("<html>Start Speeking <br> like... open word, start access</html>");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });
        
        defult.setBounds(0,0,200, 100);
        data.setBounds(0,10, 200, 150);
        exit.setBounds(100, 200, 80,40);
        f.add(exit);
        f.add(defult);
        f.add(data);
        f.setSize(300,300);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

