
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton b1,b2;
    String pinnumber;
    Deposit( String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        b1 = new JButton("Deposit");
        b1.setBounds(355, 470, 150, 30);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(355, 510, 150, 30);
        b2.addActionListener(this);
        image.add(b2);
        
        
        
        
       
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b1){
           String deposit=amount.getText();
           Date date=new Date();
           if(deposit.equals("")){
               JOptionPane.showMessageDialog(null,"please Enter the amount you want to deposit");
           }else{
               try{
           Conn conn=new Conn();
           String query="insert into  bank values('"+pinnumber+"','"+date+"','Deposit','"+deposit+"')";
           conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Rs"+deposit+" Deposited Sucessfully ");
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
               }catch(Exception e){
                   System.out.print(e);
               }
       }
       }else if(ae.getSource()==b2){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }
    }
    public static void main(String args[]) {
        new Deposit("");
    }
}
