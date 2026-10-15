
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/atm.jpg")
        );
        Image i2 = i1.getImage().getScaledInstance(
                900, 900, Image.SCALE_SMOOTH
        );
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(210, 320, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        b1 = new JButton("RS 100");
        b1.setBounds(170, 415, 150, 30);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("RS 500");
        b2.setBounds(355, 415, 150, 30);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("RS 1000");
        b3.setBounds(170, 450, 150, 30);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("RS 2000");
        b4.setBounds(355, 450, 150, 30);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("RS 5000");
        b5.setBounds(170, 485, 150, 30);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("RS 10000");
        b6.setBounds(355, 485, 150, 30);
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("Back");
        b7.setBounds(355, 520, 150, 30);
        b7.addActionListener(this);
        image.add(b7);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // Back button
        if (ae.getSource() == b7) {
            setVisible(false);
            new Transactions(pinnumber);
            return;
        }

        // Get withdrawal amount
        String amount = ((JButton) ae.getSource())
                .getText().substring(3);

        Conn c = new Conn();

        try {
            // Calculate current balance
            ResultSet rs = c.s.executeQuery(
                    "SELECT * FROM bank WHERE pin = '" + pinnumber + "'"
            );

            int balance = 0;

            while (rs.next()) {
                int transactionAmount =
                        Integer.parseInt(rs.getString("amount"));

                if (rs.getString("type").equalsIgnoreCase("Deposit")) {
                    balance += transactionAmount;
                } else if (rs.getString("type").equalsIgnoreCase("Withdrawal")
                        || rs.getString("type").equalsIgnoreCase("Withdrawl")) {
                    balance -= transactionAmount;
                }
            }

            rs.close();

            int withdrawAmount = Integer.parseInt(amount);

            // Check balance
            if (balance < withdrawAmount) {
                JOptionPane.showMessageDialog(
                        this, "Insufficient Balance"
                );
                return;
            }

            // Save withdrawal transaction
            Date date = new Date();

            String query = "INSERT INTO bank VALUES('"
                    + pinnumber + "','"
                    + date + "','Withdrawal','"
                    + amount + "')";

            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(
                    this,
                    "Rs. " + amount + " debited successfully"
            );

            setVisible(false);
            new Transactions(pinnumber);

        } catch (Exception e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Transaction failed. Please check your database."
            );
        }
    }

    public static void main(String args[]) {
        new FastCash("");
    }
}


