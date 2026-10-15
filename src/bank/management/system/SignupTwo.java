package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField aadharTextField, panTextField;

    JComboBox<String> religion, category, income, qualification, occupation;

    JRadioButton syes, sNo, existingYes, existingNo;

    JButton next;
    String formno;

    SignupTwo(String formno) {

        this.formno = formno;

        setLayout(null);

        // Page Title
        JLabel personDetails = new JLabel("Page 2: Additional Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 50, 400, 30);
        add(personDetails);


        // Religion
        JLabel religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 110, 200, 30);
        add(religionLabel);

        String r[] = {
            "Hinduism", "Buddhism", "Jainism",
            "Sikhism", "Islam", "Christianity"
        };

        religion = new JComboBox<>(r);
        religion.setBounds(300, 110, 400, 30);
        add(religion);


        // Category
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100, 160, 200, 30);
        add(categoryLabel);

        String c[] = {
            "General", "OBC", "SC", "ST", "Others"
        };

        category = new JComboBox<>(c);
        category.setBounds(300, 160, 400, 30);
        add(category);


        // Income
        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 210, 200, 30);
        add(incomeLabel);

        String i[] = {
            "NULL", "<1,50,000", "<2,50,000",
            "<5,00,000", "Upto 10,00,000"
        };

        income = new JComboBox<>(i);
        income.setBounds(300, 210, 400, 30);
        add(income);


        // Qualification
        JLabel qualificationLabel = new JLabel("Qualification:");
        qualificationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        qualificationLabel.setBounds(100, 260, 200, 30);
        add(qualificationLabel);

        String q[] = {
            "Under Graduate", "Graduate",
            "Post Graduate", "Others"
        };

        qualification = new JComboBox<>(q);
        qualification.setBounds(300, 260, 400, 30);
        add(qualification);


        // Occupation
        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 310, 200, 30);
        add(occupationLabel);

        String o[] = {
            "Salaried", "Self Employed", "Business",
            "Student", "Retired", "Unemployed", "Others"
        };

        occupation = new JComboBox<>(o);
        occupation.setBounds(300, 310, 400, 30);
        add(occupation);


        // Aadhar Number
        JLabel aadharLabel = new JLabel("Aadhar Number:");
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 360, 200, 30);
        add(aadharLabel);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 360, 400, 30);
        add(aadharTextField);


        // PAN Number
        JLabel panLabel = new JLabel("PAN Number:");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panLabel.setBounds(100, 410, 200, 30);
        add(panLabel);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 410, 400, 30);
        add(panTextField);


        // Senior Citizen
        JLabel seniorCitizenLabel = new JLabel("Senior Citizen:");
        seniorCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizenLabel.setBounds(100, 460, 200, 30);
        add(seniorCitizenLabel);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 460, 80, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sNo = new JRadioButton("No");
        sNo.setBounds(400, 460, 80, 30);
        sNo.setBackground(Color.WHITE);
        add(sNo);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sNo);


        // Existing Account
        JLabel existingAccountLabel = new JLabel("Existing Account:");
        existingAccountLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccountLabel.setBounds(100, 510, 200, 30);
        add(existingAccountLabel);

        existingYes = new JRadioButton("Yes");
        existingYes.setBounds(300, 510, 80, 30);
        existingYes.setBackground(Color.WHITE);
        add(existingYes);

        existingNo = new JRadioButton("No");
        existingNo.setBounds(400, 510, 80, 30);
        existingNo.setBackground(Color.WHITE);
        add(existingNo);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(existingYes);
        existingAccountGroup.add(existingNo);


        // Next Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 630, 80, 30);
        next.addActionListener(this);
        add(next);


        // Frame
        getContentPane().setBackground(Color.WHITE);

        setSize(850, 700);
        setLocation(350, 10);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == next) {

            // Get values from ComboBoxes
            String religionValue = (String) religion.getSelectedItem();
            String categoryValue = (String) category.getSelectedItem();
            String incomeValue = (String) income.getSelectedItem();
            String qualificationValue = (String) qualification.getSelectedItem();
            String occupationValue = (String) occupation.getSelectedItem();

            // Get values from TextFields
            String aadhar = aadharTextField.getText();
            String pan = panTextField.getText();
           


            // Get Senior Citizen value
            String seniorCitizenValue = "";

            if (syes.isSelected()) {
                seniorCitizenValue = "Yes";
            } else if (sNo.isSelected()) {
                seniorCitizenValue = "No";
            }


            // Get Existing Account value
            String existingAccountValue = "";

            if (existingYes.isSelected()) {
                existingAccountValue = "Yes";
            } else if (existingNo.isSelected()) {
                existingAccountValue = "No";
            }


            // Database insertion
            try {

                Conn c = new Conn();

                String query = "insert into signupTwo values('"
                        + formno + "','"
                        + religionValue + "','"
                        + categoryValue + "','"
                        + incomeValue + "','"
                        + qualificationValue + "','"
                        + occupationValue + "','"
                        + aadhar + "','"
                        + pan + "','"
                        + seniorCitizenValue + "','"
                        + existingAccountValue+"')";

                c.s.executeUpdate(query);
                //signup3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);

                JOptionPane.showMessageDialog(
                        null,
                        "Details Saved Successfully"
                );

            } catch (Exception ex) {

                System.out.println(ex);

                JOptionPane.showMessageDialog(
                        null,
                        "Error: " + ex.getMessage()
                );
            }
        }
    }


    public static void main(String args[]) {
        new SignupTwo("");
    }
}