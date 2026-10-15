
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 150, 20);
        bank.setFont(new Font("System", Font.BOLD, 16));
        add(bank);

        JLabel card = new JLabel("Card Number:");
        card.setBounds(20, 60, 350, 20);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20, 100, 360, 280);
        mini.setVerticalAlignment(SwingConstants.TOP);
        add(mini);

        try {
            Conn conn = new Conn();

            // Get card number
            String query1 = "SELECT cardnumber FROM login WHERE pin = ?";

            try (PreparedStatement ps = conn.c.prepareStatement(query1)) {
                ps.setString(1, pinnumber);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String cardNumber = rs.getString("cardnumber");

                        if (cardNumber != null && cardNumber.length() >= 16) {
                            card.setText("Card Number: "
                                    + cardNumber.substring(0, 4)
                                    + "XXXXXXXX"
                                    + cardNumber.substring(12));
                        } else {
                            card.setText("Card Number: " + cardNumber);
                        }
                    }
                }
            }

            // Get transaction history and calculate balance
            StringBuilder statement = new StringBuilder(
                    "<html><b>Mini Statement:</b><br><br>");

            int balance = 0;

            String query2 =
                    "SELECT date, type, amount FROM bank WHERE pin = ?";

            try (PreparedStatement ps = conn.c.prepareStatement(query2)) {
                ps.setString(1, pinnumber);

                try (ResultSet rs = ps.executeQuery()) {
                    boolean found = false;

                    while (rs.next()) {
                        found = true;

                        String date = rs.getString("date");
                        String type = rs.getString("type");
                        int amount = Integer.parseInt(rs.getString("amount"));

                        statement.append(date)
                                .append("&nbsp;&nbsp;")
                                .append(type)
                                .append("&nbsp;&nbsp;Rs. ")
                                .append(amount)
                                .append("<br><br>");

                        if ("Deposit".equalsIgnoreCase(type)) {
                            balance += amount;
                        } else if ("Withdrawal".equalsIgnoreCase(type)
                                || "Withdraw".equalsIgnoreCase(type)
                                || "Cash Withdrawal".equalsIgnoreCase(type)) {
                            balance -= amount;
                        } else if ("Fast Cash".equalsIgnoreCase(type)) {
                            balance -= amount;
                        }
                    }

                    if (!found) {
                        statement.append("No transactions found.<br><br>");
                    }
                }
            }

            statement.append("<br><b>Available Balance: Rs. ")
                    .append(balance)
                    .append("</b></html>");

            mini.setText(statement.toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading mini statement: " + e.getMessage());
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBounds(150, 410, 100, 30);
        back.addActionListener(this);
        add(back);

        setSize(400, 500);
        setLocation(500, 100);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber);
        }
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}

