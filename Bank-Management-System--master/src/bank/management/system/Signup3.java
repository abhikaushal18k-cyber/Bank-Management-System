package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    Signup3(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        // --- SCREEN SETUP ---
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screen.width;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(215, 252, 252));

        int centerX = (width - 600) / 2; // Adjusted for better alignment
        int startY = 150;

        // --- LOGO ---
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
            Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            JLabel image = new JLabel(new ImageIcon(i2));
            image.setBounds(centerX - 150, 20, 100, 100);
            add(image);
        } catch (Exception e) {
            System.out.println("Logo not found");
        }

        // --- HEADINGS ---
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(centerX + 50, 40, 400, 40);
        add(l1);

        JLabel l3 = new JLabel("Account Type:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(centerX, startY, 200, 30);
        add(l3);

        // --- RADIO BUTTONS (Account Type) ---
        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");

        JRadioButton[] radios = {r1, r2, r3, r4};
        for (JRadioButton r : radios) {
            r.setFont(new Font("Raleway", Font.PLAIN, 16));
            r.setBackground(new Color(215, 252, 252));
        }

        r1.setBounds(centerX, startY + 40, 250, 30);
        r2.setBounds(centerX + 300, startY + 40, 250, 30);
        r3.setBounds(centerX, startY + 80, 250, 30);
        r4.setBounds(centerX + 300, startY + 80, 250, 30);

        add(r1); add(r2); add(r3); add(r4);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1); bg.add(r2); bg.add(r3); bg.add(r4);

        // --- CHECKBOXES (Services) ---
        JLabel l11 = new JLabel("Services Required:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(centerX, startY + 150, 200, 30);
        add(l11);

        c1 = new JCheckBox("ATM CARD");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("EMAIL Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");

        JCheckBox[] checks = {c1, c2, c3, c4, c5, c6};
        for (JCheckBox c : checks) {
            c.setFont(new Font("Raleway", Font.PLAIN, 14));
            c.setBackground(new Color(215, 252, 252));
        }

        c1.setBounds(centerX, startY + 190, 200, 30);
        c2.setBounds(centerX + 300, startY + 190, 200, 30);
        c3.setBounds(centerX, startY + 230, 200, 30);
        c4.setBounds(centerX + 300, startY + 230, 200, 30);
        c5.setBounds(centerX, startY + 270, 200, 30);
        c6.setBounds(centerX + 300, startY + 270, 200, 30);

        add(c1); add(c2); add(c3); add(c4); add(c5); add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge", true);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(new Color(215, 252, 252));
        c7.setBounds(centerX, startY + 330, 600, 30);
        add(c7);

        // --- BUTTONS ---
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(centerX + 100, startY + 400, 120, 35);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(centerX + 280, startY + 400, 120, 35);
        add(cancel);

        submit.addActionListener(this);
        cancel.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) accountType = "Saving Account";
            else if (r2.isSelected()) accountType = "Fixed Deposit Account";
            else if (r3.isSelected()) accountType = "Current Account";
            else if (r4.isSelected()) accountType = "Recurring Deposit Account";

            // Validation
            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Please select an Account Type");
            } else if (!c7.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please accept the declaration");
            } else {
                // Logic to save to database would go here
                JOptionPane.showMessageDialog(null, "Account Created Successfully!");
                setVisible(false);
                // new NextPage().setVisible(true);
            }
            
        } else if (ae.getSource() == cancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}