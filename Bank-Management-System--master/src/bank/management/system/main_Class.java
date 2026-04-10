package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main_Class extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

main_Class(String pin) {
        this.pin = pin;

        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screen.width;
        int height = screen.height;

        // ✅ BACKGROUND
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(i2));
        background.setBounds(0, 0, width, height);
        background.setLayout(null);
        add(background);

        // ✅ PANEL DIMENSIONS (WIDER + BETTER FIT)
int panelWidth = 600;
int panelHeight = 420;

// ✅ POSITION (SHIFTED MORE UP)
int panelX = (width / 2) - 430;
int panelY = (height / 2) - 320;

// ✅ TITLE (adjusted accordingly)
JLabel label = new JLabel("Please Select Your Transaction");
label.setBounds(panelX, panelY - 50, panelWidth, 40);
label.setForeground(Color.WHITE);
label.setHorizontalAlignment(SwingConstants.CENTER);
label.setFont(new Font("Segoe UI", Font.BOLD, 26));
background.add(label);

// ✅ PANEL
JPanel panel = new JPanel();
panel.setLayout(null);
panel.setBackground(new Color(0, 0, 0, 210));
panel.setBounds(panelX, panelY, panelWidth, panelHeight);
panel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 80), 2));
background.add(panel);

Font btnFont = new Font("Segoe UI", Font.BOLD, 15);

// ✅ BUTTONS (WIDER + BETTER SPACING)
b1 = createButton("DEPOSIT", 50, 40, btnFont);
b2 = createButton("CASH WITHDRAWAL", 320, 40, btnFont);

b3 = createButton("FAST CASH", 50, 130, btnFont);
b4 = createButton("MINI STATEMENT", 320, 130, btnFont);

b5 = createButton("PIN CHANGE", 50, 220, btnFont);
b6 = createButton("BALANCE ENQUIRY", 320, 220, btnFont);

// EXIT centered
b7 = createButton("EXIT", 200, 330, btnFont);

panel.add(b1); panel.add(b2); panel.add(b3);
panel.add(b4); panel.add(b5); panel.add(b6);
panel.add(b7);

        setVisible(true);
    }

    // ✅ REUSABLE BUTTON STYLING METHOD
    JButton createButton(String text, int x, int y, Font font) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 190, 45); // Height 45 looks more modern
        btn.setFont(font);
        btn.setBackground(new Color(0, 128, 128)); // Deep Teal
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 40), 1));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(0, 160, 160)); // Highlight
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(0, 128, 128)); // Normal
            }
        });

        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b7) {
                System.exit(0);
            } else if (e.getSource() == b1) {
                new Deposit(pin);
                setVisible(false);
            } else if (e.getSource() == b2) {
                new Withdrawl(pin);
                setVisible(false);
            } else if (e.getSource() == b3) {
                new FastCash(pin);
                setVisible(false);
            } else if (e.getSource() == b4) {
                new mini(pin);
                // Mini statement usually opens a small popup, so we don't always hide main
            } else if (e.getSource() == b5) {
                new Pin(pin);
                setVisible(false);
            } else if (e.getSource() == b6) {
                new BalanceEnquriy(pin);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new main_Class("");
    }
}