
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton b1, b2;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;

        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(100, 110, 200, 30);
        add(l2);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBounds(100, 150, 180, 30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBounds(350, 150, 250, 30);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBounds(100, 190, 180, 30);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBounds(350, 190, 280, 30);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);

        JLabel l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(100, 250, 200, 30);
        add(l3);

        JLabel l4 = new JLabel("Your card number will be generated");
        l4.setFont(new Font("Raleway", Font.BOLD, 16));
        l4.setBounds(330, 250, 350, 30);
        add(l4);

        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.PLAIN, 12));
        cardDetail.setBounds(330, 280, 250, 20);
        add(cardDetail);

        JLabel l5 = new JLabel("PIN Number:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        l5.setBounds(100, 320, 200, 30);
        add(l5);

        JLabel l6 = new JLabel("XXXX");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setBounds(330, 320, 300, 30);
        add(l6);

        JLabel pinDetail = new JLabel("Your 4 Digit PIN");
        pinDetail.setFont(new Font("Raleway", Font.PLAIN, 12));
        pinDetail.setBounds(330, 350, 250, 20);
        add(pinDetail);

        JLabel l7 = new JLabel("Services Required:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        l7.setBounds(100, 400, 250, 30);
        add(l7);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 15));
        c1.setBounds(100, 440, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 15));
        c2.setBounds(350, 440, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 15));
        c3.setBounds(100, 480, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 15));
        c4.setBounds(350, 480, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 15));
        c5.setBounds(100, 520, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 15));
        c6.setBounds(350, 520, 200, 30);
        add(c6);

        c7 = new JCheckBox(
                "I hereby declare that the above entered details are correct"
        );
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.PLAIN, 12));
        c7.setBounds(100, 570, 600, 30);
        add(c7);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBounds(250, 620, 100, 35);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBounds(420, 620, 100, 35);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 720);
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String accountType = "";

            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            if (accountType.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "Please select an account type"
                );
                return;
            }

            if (!c7.isSelected()) {
                JOptionPane.showMessageDialog(
                        this, "Please accept the declaration"
                );
                return;
            }

            Random random = new Random();

            String cardNumber = String.valueOf(
                    1000000000000000L
                    + random.nextInt(900000000)
                    * 10000000L
                    + random.nextInt(10000000)
            );

            String pinNumber = String.valueOf(
                    1000 + random.nextInt(9000)
            );

            StringBuilder facility = new StringBuilder();

            if (c1.isSelected()) facility.append(" ATM Card");
            if (c2.isSelected()) facility.append(" Internet Banking");
            if (c3.isSelected()) facility.append(" Mobile Banking");
            if (c4.isSelected()) facility.append(" Email & SMS Alerts");
            if (c5.isSelected()) facility.append(" Cheque Book");
            if (c6.isSelected()) facility.append(" E-Statement");

            try {
                Conn conn = new Conn();

                String query1 = "INSERT INTO signupThree "
                        + "(formno, accountType, cardNumber, pinNumber, facility) "
                        + "VALUES ('" + formno + "', '"
                        + accountType + "', '"
                        + cardNumber + "', '"
                        + pinNumber + "', '"
                        + facility.toString().trim() + "')";

                String query2 = "INSERT INTO login "
                        + "(formno, cardnumber, pin) "
                        + "VALUES ('" + formno + "', '"
                        + cardNumber + "', '"
                        + pinNumber + "')";



                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(
                        this,
                        "Account created successfully!\n"
                        + "Card Number: " + cardNumber
                        + "\nPIN: " + pinNumber
                );

                setVisible(false);
                new Login();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(
                        this,
                        "Error creating account. Check your database."
                );
            }

        } else if (ae.getSource() == b2) {

            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new SignupThree("12345");
    }
}

