import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JOptionPane;

import java.awt.event.*;

public class Sample extends Frame implements ActionListener{
        
        Label name, username, password, confrimpassword, resultLabel;
        TextField tname, tusername, tpassword, tconfrimpassword;
        Button btn;

    Sample(){
        
        Frame f = new Frame();
        f.setSize(300, 300);
        f.setVisible(true);
        f.setLayout(new GridLayout(6, 2));
        
        // name, username, password, confrim password

        name = new Label("Name ");
        username = new Label("Username ");
        password = new Label("Password ");
        confrimpassword = new Label("Confrim Password ");

        tname = new TextField();
        tusername = new TextField();
        tpassword = new TextField();
        tconfrimpassword = new TextField();
        
        resultLabel = new Label();

        btn = new Button("Submit");
        btn.addActionListener(this);
    
        f.add(name);
        f.add(tname);

        f.add(username);
        f.add(tusername);

        f.add(password);
        f.add(tpassword);

        f.add(confrimpassword);
        f.add(tconfrimpassword);
        
        f.add(resultLabel);
        f.add(btn);

    }

    public void actionPerformed(ActionEvent ae){

        String checkname = tname.getText();
        String checkusername = tusername.getText();
        String checkpassword = tpassword.getText();
        String checkconfrimpassword = tconfrimpassword.getText();

        if(checkpassword.equals(checkconfrimpassword)){
            resultLabel.setText("Password Match");

            try{

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gui", "root", "");
                Statement sat = con.createStatement();
                String query = "INSERT INTO password(name, username, password, confirmpassword VALUES('"+checkname+"','"+checkusername+"','"+checkpassword+"','"+checkconfrimpassword+"')";
                sat.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Insert Sccessfully");

            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Insert Unsccessfully");
            }

        }
        else{
            resultLabel.setText("Password not Match");
        }

    }



    public static void main(String []agrs){
        Password_Vaildation ps = new Password_Vaildation();
    }
}