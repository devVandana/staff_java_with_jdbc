package assign_4;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.*;

public class staff extends javax.swing.JFrame {  
	
		JFrame frame01 = new JFrame ("Staff Information");

		JPanel one = new JPanel();
		JPanel two = new JPanel();
		JPanel three = new JPanel();
		JPanel four = new JPanel();
		JPanel five = new JPanel();
		JPanel six = new JPanel();
		JPanel seven = new JPanel();
		JPanel eight = new JPanel();
		
		JButton view = new JButton("View");
	    JButton insert = new JButton("Insert");
	    JButton update = new JButton("Update");
	    JButton clear = new JButton("Clear");
	    
	    JLabel staffinfo = new JLabel("STAFF INFORMATION");
	    JLabel id = new JLabel("ID");
	    JLabel lastname = new JLabel("Last Name");
	    JLabel firstname = new JLabel("First Name");
	    JLabel mi = new JLabel("MI");
	    JLabel address = new JLabel("Address");
	    JLabel city = new JLabel("City");
	    JLabel state = new JLabel("State");
	    JLabel Telephone = new JLabel("Telephone");
	    JLabel label = new JLabel("Database_status");
	    JLabel email = new JLabel("Email");
	    
	    JTextField Id = new JTextField(20);
	    JTextField Lastname = new JTextField(20);
	    JTextField Firstname = new JTextField(20);
	    JTextField Mi = new JTextField(20);
	    JTextField Address = new JTextField(20);
	    JTextField City = new JTextField(20);
	    JTextField State = new JTextField(20);
	    JTextField telephone = new JTextField(20);
	    JTextField mail = new JTextField(20);
	    JTextField ll = new JTextField(20);
	    
	    public staff() {
	    frame01.setSize(800,300);
	    
		two.setLayout (new GridLayout(5,2));
	    four.setLayout(new GridLayout(5,2));
	    six.setLayout (new GridLayout(5,2));
	    seven.setLayout(new GridLayout(5,2));
	    
	    five.setBackground(Color.yellow);
	    eight.setBackground(Color.yellow);
	    three.setBackground(Color.pink);
	    one.setBackground(Color.pink);
	    
	    staffinfo.setFont(new Font("Tahoma", Font.BOLD, 20));
	    id.setFont(new Font("Arial", Font.BOLD, 15));
	    lastname.setFont(new Font("Arial", Font.BOLD, 15));
	    firstname.setFont(new Font("Arial", Font.BOLD, 15));
	    mi.setFont(new Font("Arial", Font.BOLD, 15));
	    address.setFont(new Font("Arial", Font.BOLD, 15));
	    city.setFont(new Font("Arial", Font.BOLD, 15));
	    state.setFont(new Font("Arial", Font.BOLD, 15));
	    Telephone.setFont(new Font("Arial", Font.BOLD, 15));
	    label.setFont(new Font("Arial", Font.BOLD, 15));
	    email.setFont(new Font("Arial", Font.BOLD, 15));
	    	
	    one.add(view);
	    one.add(insert);
	    one.add(update);
	    one.add(clear);
	    three.add(staffinfo);
	    two.add(id);
	    four.add(Id);
	    six.add(lastname);
	    seven.add(Lastname);
	    two.add(firstname);
	    four.add(Firstname);
	    six.add(mi);
	    seven.add(Mi);
	    two.add(address);
	    four.add(Address);
	    six.add(city);
	    seven.add(City);
	    two.add(state);
	    four.add(State);
	    six.add(Telephone);
	    seven.add(telephone);
	    two.add(email);
	    four.add(mail);
	    six.add(label);
	    seven.add(ll);
	    
	    eight.add(six);
	    eight.add(seven);
	    five.add(two);
	    five.add(four);
	    frame01.add(five, BorderLayout.LINE_START);
	    frame01.add(one, BorderLayout.SOUTH); 
	    frame01.add(three, BorderLayout.NORTH);
	    frame01.add(eight, BorderLayout.CENTER);
	    frame01.setVisible(true);
	    frame01.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    database_connection();
        }
	    public boolean isEmailValid(String email) {
		    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
		    return EMAIL_REGEX.matcher(email).matches();
	    }
	    public void database_connection() {
	    	System.out.println("hello");
	    try {
	    	
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","n01476677","oracle");
	    	if(con.isValid(EXIT_ON_CLOSE)) 
	    	{
				ll.setText("Database Connected sucessfully");
			}
	    	else 
	    	{
				ll.setText("Database is not connected");
			}
	    	Statement drop = con.createStatement();
			String q1 = "Drop table Staff";
			Statement create = con.createStatement();
			String q2 = "create table Staff "
					+ "  (id char(9) not null,"
					+ "  lastName varchar(15),"
					+ "  firstName varchar(15),"
					+ "  mi char(1),"
					+ "  address varchar(20),"
					+ "  city varchar(20),"
					+ "  state char(2),"
					+ "  telephone char(10),"
					+ "  mail varchar(40),"
					+ "  primary key (id))"
					;
			Statement bb = con.createStatement();
			String q3 = "select * from dual";
			try {
				System.out.println("hel");
				DatabaseMetaData dbms = con.getMetaData();
				//ResultSet rs = dbms.getTables(null, null, "STAFF", null);
				//System.out.println(rs);
				//if(rs.next()) {
					System.out.println("h");
					System.out.println("Table already exists");
     				drop.executeUpdate(q1);
					System.out.println("Droping the existing table");
					create.executeUpdate(q2);
					System.out.println("Table created successfully");
					//bb.executeUpdate(q3);
					
				//}
			}catch(SQLException ex) {
				System.out.println(ex);
			}
			    
			
			ActionListener insert_b = new ActionListener() {

				public void actionPerformed(ActionEvent e) { 
					 String id=Id.getText();
					 String tele=telephone.getText();
					 String maill = mail.getText();
				        int idInt=0;
				        int teleInt=0;
				        boolean flag = false;
				        if(id!=null && tele!=null){
				            try {
				                idInt = Integer.parseInt(id);
				                teleInt = Integer.parseInt(tele);
				                if(!isEmailValid(maill)) {
				                	throw new NumberFormatException();
				             
				                }
				                if(tele.length()!= 10) {
				                	throw new NumberFormatException();
				                }
				                 flag=true;
				            } catch (NumberFormatException e1) {
				 
				                JOptionPane.showMessageDialog(rootPane, "Format is not correct","Alert", JOptionPane.WARNING_MESSAGE);
				            }
				        }
						try {
							if(flag==true) {
							Statement statement = con.createStatement();
							System.out.println("heee");
							int resultSet = statement.executeUpdate("INSERT INTO STAFF(id,lastname,firstname,mi,city,state,telephone,mail,address) "+"VALUES('"+Id.getText()+"','"+Lastname.getText()+"','"+Firstname.getText()+"','"+Mi.getText()+"','"+City.getText()+"','"+State.getText()+"','"+telephone.getText()+"','"+mail.getText()+"','"+Address.getText()+"')");
							if(resultSet != 0) {
								JOptionPane.showMessageDialog(null, "Row Inserted Succesfully", "Insertion" , JOptionPane.INFORMATION_MESSAGE);
							}
							}
						}
						catch(SQLException ex) {
							JOptionPane.showMessageDialog(null, "An exception has occured for insert button", "Exception" , JOptionPane.INFORMATION_MESSAGE);
							System.out.println(ex);
						}
						
					}
				
			};
			insert.addActionListener(insert_b);
			
			ActionListener clear_b = new ActionListener() {

				public void actionPerformed(ActionEvent e) { 
					Id.setText("");
					Lastname.setText("");
					Firstname.setText("");
					Mi.setText("");
					Address.setText("");
					City.setText("");
					State.setText("");
					telephone.setText("");
					mail.setText("");
					
				}
			};
			clear.addActionListener(clear_b);
			
			ActionListener update_b = new ActionListener() {

				public void actionPerformed(ActionEvent e) { 
					 String id=Id.getText();
				        int idInt=0;
				        boolean flag=false;
				        if(id!=null){
				            try {
				                idInt = Integer.parseInt(id);
				            flag=true;
				            } catch (NumberFormatException e1) {
				 
				                JOptionPane.showMessageDialog(rootPane, "Format is not correct","Alert", JOptionPane.WARNING_MESSAGE);
				            }
				            
				
					try {
						if(flag==true) {
						Statement statement = con.createStatement();
						int resultSet = statement.executeUpdate("update Staff set lastname = '"+Lastname.getText()+"'"
					+ ", firstname = '"+Firstname.getText()+"' , mi = '"+Mi.getText()+"'  , city = '"+City.getText()+"' , state = '"+State.getText()+"' , telephone = '"
					+telephone.getText()+"' , mail = '"+mail.getText()+"', address = '"+Address.getText()+"' where id = "+Id.getText());
						
						System.out.println(resultSet+" row updated");
					}
					}
					catch(SQLException ex) {
						JOptionPane.showMessageDialog(null, "An exception has occured for update button", "Exception" , JOptionPane.INFORMATION_MESSAGE);
						System.out.println(ex);
					}
					
				}
				}
			};
			update.addActionListener(update_b);
			
			ActionListener view_b = new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					 String id=Id.getText();
				        int idInt=0;
				        if(id!=null){
				            try {
				                idInt = Integer.parseInt(id);
				            } catch (NumberFormatException e1) {
				 
				                JOptionPane.showMessageDialog(rootPane, "Format is not correct","Alert", JOptionPane.WARNING_MESSAGE);
				            }
				        
				
					try {
						Statement statement = con.createStatement();
						ResultSet resultSet = statement.executeQuery("SELECT * FROM STAFF WHERE id ="+Id.getText());
						System.out.println(resultSet);
							while(resultSet.next()) {
								Lastname.setText(resultSet.getString("lastname"));
								Firstname.setText(resultSet.getString("firstname"));
							    Mi.setText(resultSet.getString("mi"));
								Address.setText(resultSet.getString("address"));
								City.setText(resultSet.getString("city"));
								State.setText(resultSet.getString("state"));
								telephone.setText(resultSet.getString("telephone"));
								mail.setText(resultSet.getString("mail"));
							}
					}
					catch(SQLException ex) {
						JOptionPane.showMessageDialog(null, "An exception has occured for view button", "Exception" , JOptionPane.INFORMATION_MESSAGE);
						System.out.println(ex);
					}
					
				}
				}
			};
			view.addActionListener(view_b);
	    }
	    catch(ClassNotFoundException ex) {
			System.out.println(ex);	
		}catch(Exception ex) {
			System.out.println(ex);
		}
		  
		}
	    public static void main(String[] args) {
	    	// TODO Auto-generated method stub
	      new staff();
	    }
}

//  Course_Name – Assignment 4                                                                                                                               *

// I declare that this assignment is my own work in accordance with Humber Academic Policy.        *

//  No part of this assignment has been copied manually or electronically from any other source       *

// (including web sites) or distributed to other students/social media.                                                       *
                                                                                                                                                                             
// Name: _______vandana_______________ Student ID: _________n01476677_________ Date: ________11-11-2022____________  
//Name: _______Hanish Kaprani_______________ Student ID: ____n01519824_________ Date: ________11-11-2022____________ 


			

