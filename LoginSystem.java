import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginSystem implements ActionListener {
    JFrame frame= new JFrame();
    JButton login= new JButton("Login");
    JButton reset= new JButton("Reset");
    JTextField userId= new JTextField();
    JPasswordField passwordField =new JPasswordField();
    JLabel userLabel= new JLabel("User Id: ");
    JLabel passwordLabel= new JLabel("Password: ");
    JLabel messageLabel= new JLabel();
    HashMap<String, String> loginInfo= new HashMap<>();
    public LoginSystem(HashMap<String, String> loginInfo) {
        this.loginInfo = loginInfo;

        userLabel.setBounds(50,75,175,25);
        passwordLabel.setBounds(50,125,175,25);
        messageLabel.setBounds(100,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));
        userId.setBounds(115,80,200,25);
        passwordField.setBounds(115,125,200,25);

        login.setBounds(115,175,100,25);
        login.setFocusable(false);
        login.addActionListener(this);

        reset.setBounds(215,175,100,25);
        reset.setFocusable(false);
        reset.addActionListener(this);

        frame.add(login);
        frame.add(reset);
        frame.add(userId);
        frame.add(passwordField);
        frame.add(messageLabel);
        frame.add(userLabel);
        frame.add(passwordLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==reset){
            userId.setText("");
            passwordField.setText("");
        }
        if (e.getSource()==login){
            String userID=userId.getText();
            String password=String.valueOf(passwordField.getPassword());

            if(loginInfo.containsKey(userID)){
                if (loginInfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("login successful");
                    WelcomePage welcome= new WelcomePage();
                    frame.dispose();
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("User name not found");
            }
        }
    }
}
