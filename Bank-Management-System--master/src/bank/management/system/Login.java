package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;

    // ✅ HOVER EFFECT METHOD
    void addHoverEffect(JButton button, Color normal, Color hover) {
        button.setBackground(normal);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusable(false);

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hover);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(normal);
            }
        });
    }

    Login() {
        super("Bank Management System");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        // ✅ BACKGROUND
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.jpg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, width, height);
        background.setLayout(null);
        add(background);

        // ✅ LOGO
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image logoImg = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(logoImg));
        logo.setBounds(width / 2 - 50, 40, 100, 100);
        background.add(logo);

        // ✅ GLASS PANEL
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(10, 25, 50, 180));
        panel.setBounds(width / 2 - 200, height / 2 - 180, 400, 350);
        panel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 60), 1));
        background.add(panel);

        // ✅ TITLE
        
        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBounds(50, 20, 300, 30);
        panel.add(label1);

        // ✅ CARD NUMBER
        label2 = new JLabel("Card Number");
        label2.setForeground(Color.WHITE);
        label2.setBounds(50, 80, 200, 20);
        panel.add(label2);

        textField2 = new JTextField();
        textField2.setBounds(50, 100, 300, 35);
        textField2.setBackground(new Color(240,240,240));
        textField2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField2.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        panel.add(textField2);

        // ✅ PIN
        label3 = new JLabel("PIN");
        label3.setForeground(Color.WHITE);
        label3.setBounds(50, 150, 200, 20);
        panel.add(label3);

        passwordField3 = new JPasswordField();
        passwordField3.setBounds(50, 170, 300, 35);
        passwordField3.setBackground(new Color(240,240,240));
        passwordField3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField3.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        panel.add(passwordField3);

        Font btnFont = new Font("Segoe UI", Font.BOLD, 14);

        // ✅ BUTTONS
        button1 = new JButton("SIGN IN");
        button1.setBounds(50, 230, 140, 35);
        button1.setFont(btnFont);
        button1.addActionListener(this);
        panel.add(button1);

        button2 = new JButton("CLEAR");
        button2.setBounds(210, 230, 140, 35);
        button2.setFont(btnFont);
        button2.addActionListener(this);
        panel.add(button2);

        button3 = new JButton("SIGN UP");
        button3.setBounds(50, 280, 300, 35);
        button3.setFont(btnFont);
        button3.addActionListener(this);
        panel.add(button3);

        // ✅ APPLY HOVER EFFECT
        addHoverEffect(button1, new Color(0,153,255), new Color(0,180,255));
        addHoverEffect(button2, new Color(120,120,120), new Color(150,150,150));
        addHoverEffect(button3, new Color(0,200,150), new Color(0,230,180));

        // ✅ CARD IMAGE
        ImageIcon cardIcon = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image cardImg = cardIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel card = new JLabel(new ImageIcon(cardImg));
        card.setBounds(width - 150, height - 150, 100, 100);
        background.add(card);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
                Connn c = new Connn();
                String cardno = textField2.getText();
                String pin = new String(passwordField3.getPassword());

                String q = "select * from login where card_number = '" + cardno + "' and pin = '" + pin + "'";
                ResultSet rs = c.statement.executeQuery(q);

                if (rs.next()) {
                    setVisible(false);
                    new main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

            } else if (e.getSource() == button2) {
                textField2.setText("");
                passwordField3.setText("");

            } else if (e.getSource() == button3) {
                new Signup();
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}