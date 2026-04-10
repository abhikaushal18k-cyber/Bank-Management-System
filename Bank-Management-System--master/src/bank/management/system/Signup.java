package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    JRadioButton r1, r2, m1, m2, m3;
    JButton next;

    JTextField textName, textFname, textEmail, textAdd, textcity, textState, textPin;
    JDateChooser dateChooser;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    Signup() {
        super("APPLICATION FORM");

        setLayout(null);

        // ✅ FULL SCREEN
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screen.width;
        int height = screen.height;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);

        getContentPane().setBackground(new Color(222, 255, 228));

        // ✅ CENTER ALIGNMENT
        int formWidth = 800;
        int centerX = (width - formWidth) / 2;
        int startY = 150;

        // ✅ LOGO
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(centerX - 120, 20, 100, 100);
        add(image);

        // ✅ TITLE
        JLabel label1 = new JLabel("APPLICATION FORM NO. " + first);
        label1.setFont(new Font("Raleway", Font.BOLD, 36));
        label1.setBounds(centerX, 30, 700, 40);
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        label2.setBounds(centerX + 250, 80, 200, 30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        label3.setBounds(centerX + 200, 110, 300, 30);
        add(label3);

        // ✅ NAME
        JLabel labelName = new JLabel("Name:");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(centerX, startY, 150, 30);
        add(labelName);

        textName = new JTextField();
        textName.setBounds(centerX + 200, startY, 400, 30);
        add(textName);

        // ✅ FATHER NAME
        JLabel labelfName = new JLabel("Father's Name:");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelfName.setBounds(centerX, startY + 50, 200, 30);
        add(labelfName);

        textFname = new JTextField();
        textFname.setBounds(centerX + 200, startY + 50, 400, 30);
        add(textFname);

        // ✅ GENDER
        JLabel labelG = new JLabel("Gender:");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(centerX, startY + 100, 200, 30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setBounds(centerX + 200, startY + 100, 80, 30);
        r1.setBackground(new Color(222, 255, 228));
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(centerX + 300, startY + 100, 100, 30);
        r2.setBackground(new Color(222, 255, 228));
        add(r2);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        // ✅ DOB
        JLabel DOB = new JLabel("Date of Birth:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(centerX, startY + 150, 200, 30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(centerX + 200, startY + 150, 400, 30);
        add(dateChooser);

        // ✅ EMAIL
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(centerX, startY + 200, 200, 30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(centerX + 200, startY + 200, 400, 30);
        add(textEmail);

        // ✅ MARITAL STATUS
        JLabel labelMs = new JLabel("Marital Status:");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(centerX, startY + 250, 200, 30);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setBounds(centerX + 200, startY + 250, 100, 30);
        m1.setBackground(new Color(222, 255, 228));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBounds(centerX + 320, startY + 250, 120, 30);
        m2.setBackground(new Color(222, 255, 228));
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBounds(centerX + 460, startY + 250, 100, 30);
        m3.setBackground(new Color(222, 255, 228));
        add(m3);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(m1);
        maritalGroup.add(m2);
        maritalGroup.add(m3);

        // ✅ ADDRESS
        JLabel labelAdd = new JLabel("Address:");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(centerX, startY + 300, 200, 30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setBounds(centerX + 200, startY + 300, 400, 30);
        add(textAdd);

        // ✅ CITY
        JLabel labelCity = new JLabel("City:");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(centerX, startY + 350, 200, 30);
        add(labelCity);

        textcity = new JTextField();
        textcity.setBounds(centerX + 200, startY + 350, 400, 30);
        add(textcity);

        // ✅ PIN
        JLabel labelPin = new JLabel("Pin Code:");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(centerX, startY + 400, 200, 30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setBounds(centerX + 200, startY + 400, 400, 30);
        add(textPin);

        // ✅ STATE
        JLabel labelState = new JLabel("State:");
        labelState.setFont(new Font("Raleway", Font.BOLD, 20));
        labelState.setBounds(centerX, startY + 450, 200, 30);
        add(labelState);

        textState = new JTextField();
        textState.setBounds(centerX + 200, startY + 450, 400, 30);
        add(textState);

        // ✅ BUTTON
        next = new JButton("Next");
        next.setBounds(centerX + 500, startY + 520, 120, 40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (r1.isSelected()) gender = "Male";
        else if (r2.isSelected()) gender = "Female";

        String email = textEmail.getText();

        String marital = null;
        if (m1.isSelected()) marital = "Married";
        else if (m2.isSelected()) marital = "Unmarried";
        else if (m3.isSelected()) marital = "Other";

        String address = textAdd.getText();
        String city = textcity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {
                Connn c = new Connn();
                String q = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                c.statement.executeUpdate(q);

                new Signup2(formno);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}