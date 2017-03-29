package buttons;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lessons extends JFrame {

    private JPanel Myform;
    private JButton doneButton;
    private JTextField password;
    private JTextField login;
    private String originLogin;
    private String originPassword;

    public Lessons(){

        originLogin = "kyky";
        originPassword= "1111";
        setContentPane(Myform);
        setSize(200, 300);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        doneButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
              System.out.println("mouseClicked");
                if(originLogin.equals(login.getText()) && originPassword.equals(password.getText())){
                    System.out.println("You are login");
                }else {
                    System.out.println("Incorrect info");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited");
            }
        });

    }
}
