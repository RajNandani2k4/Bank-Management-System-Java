
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(
                900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(230, 250, 300, 35);
        image.add(text);

        JLabel newPin = new JLabel("New PIN:");
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("System", Font.BOLD, 16));
        newPin.setBounds(165, 300, 150, 25);
        image.add(newPin);

        pin = new JPasswordField();
        pin.setBounds(330, 300, 180, 25);
        image.add(pin);

        JLabel rePin = new JLabel("Re-enter New PIN:");
        rePin.setForeground(Color.WHITE);
        rePin.setFont(new Font("System", Font.BOLD, 16));
        rePin.setBounds(165, 340, 170, 25);
        image.add(rePin);

        repin = new JPasswordField();
        repin.setBounds(330, 340, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 400, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 445, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber);
            return;
        }

        String newPin = new String(pin.getPassword());
        String rePin = new String(repin.getPassword());

        if (newPin.isEmpty() || rePin.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your PIN");
            return;
        }

        if (!newPin.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(null,
                    "PIN must contain exactly 4 digits");
            return;
        }

        if (!newPin.equals(rePin)) {
            JOptionPane.showMessageDialog(null,
                    "Entered PINs do not match");
            return;
        }

        try {
            Conn conn = new Conn();

            conn.c.setAutoCommit(false);

            String query1 = "UPDATE bank SET pin = ? WHERE pin = ?";
            String query2 = "UPDATE login SET pin = ? WHERE pin = ?";
            String query3 = "UPDATE signupThree SET pinNumber = ? WHERE pinNumber = ?";

            try (PreparedStatement ps1 = conn.c.prepareStatement(query1);
                 PreparedStatement ps2 = conn.c.prepareStatement(query2);
                 PreparedStatement ps3 = conn.c.prepareStatement(query3)) {

                ps1.setString(1, newPin);
                ps1.setString(2, pinnumber);
                ps1.executeUpdate();

                ps2.setString(1, newPin);
                ps2.setString(2, pinnumber);
                ps2.executeUpdate();

                ps3.setString(1, newPin);
                ps3.setString(2, pinnumber);
                ps3.executeUpdate();

                conn.c.commit();
            } catch (SQLException e) {
                conn.c.rollback();
                throw e;
            } finally {
                conn.c.setAutoCommit(true);
            }

            JOptionPane.showMessageDialog(null,
                    "PIN changed successfully");

            setVisible(false);
            new Transactions(newPin);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to change PIN: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
