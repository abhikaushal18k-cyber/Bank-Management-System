package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {

    JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textPan, textAadhar;
    JRadioButton r1, r2, e1, e2;
    JButton next;
    String formno;

    Signup2(String formno) {
        this.formno = formno;

        setLayout(null);

        // ✅ FULL SCREEN
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screen.width;
        int height = screen.height;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);

        getContentPane().setBackground(new Color(252, 208, 76));

        // ✅ CENTER
        int formWidth = 900;
        int centerX = (width - formWidth) / 2;
        int startY = 150;

        // LOGO
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(centerX - 120, 20, 100, 100);
        add(image);

        // HEADINGS
        JLabel l1 = new JLabel("Page 2 :-");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(centerX + 200, 30, 300, 40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(centerX + 200, 60, 400, 40);
        add(l2);

        // FORM NO
        JLabel l12 = new JLabel("Form No:");
        l12.setBounds(width - 180, 10, 100, 30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setBounds(width - 100, 10, 80, 30);
        add(l13);

        // FIELDS
        JLabel l3 = new JLabel("Religion:");
        l3.setBounds(centerX, startY, 150, 30);
        add(l3);

        comboBox = new JComboBox(new String[]{"Hindu","Muslim","Sikh","Christian","Other"});
        comboBox.setBounds(centerX + 250, startY, 350, 30);
        add(comboBox);

        JLabel l4 = new JLabel("Category:");
        l4.setBounds(centerX, startY + 60, 150, 30);
        add(l4);

        comboBox2 = new JComboBox(new String[]{"General","OBC","SC","ST","Other"});
        comboBox2.setBounds(centerX + 250, startY + 60, 350, 30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income:");
        l5.setBounds(centerX, startY + 120, 150, 30);
        add(l5);

        comboBox3 = new JComboBox(new String[]{"<1,50,000","<2,50,000","5,00,000","Up to 10,00,000","Above 10,00,000"});
        comboBox3.setBounds(centerX + 250, startY + 120, 350, 30);
        add(comboBox3);

        JLabel l6 = new JLabel("Education:");
        l6.setBounds(centerX, startY + 180, 150, 30);
        add(l6);

        comboBox4 = new JComboBox(new String[]{"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"});
        comboBox4.setBounds(centerX + 250, startY + 180, 350, 30);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation:");
        l7.setBounds(centerX, startY + 240, 150, 30);
        add(l7);

        comboBox5 = new JComboBox(new String[]{"Salaried","Self-Employed","Business","Student","Retired","Other"});
        comboBox5.setBounds(centerX + 250, startY + 240, 350, 30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN Number:");
        l8.setBounds(centerX, startY + 300, 150, 30);
        add(l8);

        textPan = new JTextField();
        textPan.setBounds(centerX + 250, startY + 300, 350, 30);
        add(textPan);

        JLabel l9 = new JLabel("Aadhar Number:");
        l9.setBounds(centerX, startY + 360, 200, 30);
        add(l9);

        textAadhar = new JTextField();
        textAadhar.setBounds(centerX + 250, startY + 360, 350, 30);
        add(textAadhar);

        JLabel l10 = new JLabel("Senior Citizen:");
        l10.setBounds(centerX, startY + 420, 200, 30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r2 = new JRadioButton("No");
        r1.setBounds(centerX + 250, startY + 420, 80, 30);
        r2.setBounds(centerX + 350, startY + 420, 80, 30);
        r1.setBackground(new Color(252,208,76));
        r2.setBackground(new Color(252,208,76));
        add(r1); add(r2);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r1); bg1.add(r2);

        JLabel l11 = new JLabel("Existing Account:");
        l11.setBounds(centerX, startY + 480, 200, 30);
        add(l11);

        e1 = new JRadioButton("Yes");
        e2 = new JRadioButton("No");
        e1.setBounds(centerX + 250, startY + 480, 80, 30);
        e2.setBounds(centerX + 350, startY + 480, 80, 30);
        e1.setBackground(new Color(252,208,76));
        e2.setBackground(new Color(252,208,76));
        add(e1); add(e2);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(e1); bg2.add(e2);

        // BUTTON
        next = new JButton("Next");
        next.setBounds(centerX + 480, startY + 550, 120, 40);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        new Signup3(formno);
        setVisible(false);
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}