import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class InformationForm {

public static void main(String [] args){
JFrame f = new JFrame("Activity # 4");
JTable table = new JTable();


Object [] columns ={"ID","NAME","ADDRESS","AGE"};
DefaultTableModel model = new DefaultTableModel();
//table.setTableHeader(null);
  table.getTableHeader().setFont(new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 20));
  table.getTableHeader().setBackground(Color.lightGray);
  table.getTableHeader().setForeground(Color.decode("#4b5320"));
table.setShowHorizontalLines(false);
table.setShowVerticalLines(false);
model.setColumnIdentifiers(columns);
table.setModel(model);
table.setForeground(Color.black);
Font font = new Font("",1,15);
table.setFont(font);
table.setRowHeight(30);



 //LABELS
JLabel l1 = new JLabel("ID");
JLabel l2 = new JLabel("NAME");
JLabel l3 = new JLabel("ADDRESS");
JLabel l4 = new JLabel("AGE");
JLabel l5 = new JLabel("REGISTRATION FORM");

//TEXTFIELDS
JTextField t1 = new JTextField();
JTextField t2 = new JTextField();
JTextField t3 = new JTextField();
JTextField t4 = new JTextField();

//Buttons
JButton b1 = new JButton("SAVE");
JButton b2 = new JButton("EDIT"); 
JButton b3 = new JButton("DELETE");
JButton b4 = new JButton("EXIT");

l1.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 30));
l2.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 30));
l3.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 30));
l4.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 30));
l5.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 40));
l5.setForeground(Color.lightGray);
l4.setForeground(Color.lightGray);
l3.setForeground(Color.lightGray);
l2.setForeground(Color.lightGray);
l1.setForeground(Color.lightGray);

t1.setBackground(Color.lightGray);
t1.setForeground(Color.decode("#4b5320"));
t2.setBackground(Color.lightGray);
t2.setForeground(Color.decode("#4b5320"));
t3.setBackground(Color.lightGray);
t3.setForeground(Color.decode("#4b5320"));
t4.setBackground(Color.lightGray);
t4.setForeground(Color.decode("#4b5320"));

b1.setBackground(Color.lightGray);
b2.setBackground(Color.lightGray);
b3.setBackground(Color.lightGray);
b4.setBackground(Color.lightGray);

b1.setForeground(Color.decode("#4b5320"));
b2.setForeground(Color.decode("#4b5320"));
b3.setForeground(Color.decode("#4b5320"));
b4.setForeground(Color.decode("#4b5320"));

t1.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 20));
t2.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 20));
t3.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 20));
t4.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 20));

b1.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 20));
b2.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 20));
b3.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 20));
b4.setFont (new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 20));
//table.setBounds(110,450,400,200);

l1.setBounds(200,150,110,30);
l2.setBounds(200,210,110,30);
l3.setBounds(200,270,210,30);
l4.setBounds(200,330,110,30);
l5.setBounds(200,50,500,40);


t1.setBounds(400,150,210,50);
t2.setBounds(400,210,210,50);
t3.setBounds(400,270,210,50);
t4.setBounds(400,330,210,50);

b1.setBounds(150,400,110,40);
b2.setBounds(300,400,110,40);
b3.setBounds(450,400,130,40);
b4.setBounds(620,400,110,40);

JScrollPane pane = new JScrollPane(table);
pane.setBounds(150,450,580,200);


f.setLayout(null);
f.setSize(900,700);
f.setLocation(0,0);
f.setResizable(true);
f.getContentPane().setBackground(Color.decode("#4b5320"));
f.add(pane);


//f.add(table);
f.add(l1);
f.add(l2);
f.add(l3);
f.add(l4);
f.add(l5);
f.add(t1);
f.add(t2);
f.add(t3);
f.add(t4);
f.add(b1);
f.add(b2);
f.add(b3);
f.add(b4);

Object [] row = new Object[4];
b1.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e){
   row[0] = t1.getText();
   row[1] = t2.getText();
   row[2] = t3.getText();
   row[3] = t4.getText();
   
   model.addRow(row);
   t1.setText("");
   t2.setText("");
   t3.setText("");
   t4.setText("");
   }
});

b2.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e){
  int i = table.getSelectedRow();
  if(i>=0){
   model.setValueAt(t1.getText(),i,0);
   model.setValueAt(t2.getText(),i,1);
   model.setValueAt(t3.getText(),i,2);     
   model.setValueAt(t4.getText(),i,3);
   }
   else
   System.out.println("Error ");
   }
});

table.addMouseListener(new MouseAdapter(){

   @Override
   public void mouseClicked(MouseEvent e){
   
   int i = table.getSelectedRow();
   t1.setText(model.getValueAt(i,0).toString());
   t2.setText(model.getValueAt(i,1).toString());
   t3.setText(model.getValueAt(i,2).toString());
   t4.setText(model.getValueAt(i,3).toString());
   }
});

b3.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e){
  int i = table.getSelectedRow();
  if(i>=0){
   model.removeRow(i);
   t1.setText("");
   t2.setText("");
   t3.setText("");
   t4.setText("");
   }
   else{
   System.out.println("Nothing to delete");
   }
 
 }
   
});
b4.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e){
  System.exit(0);
 
 }
   
});
//f.setSize(900,400);
f.setLocationRelativeTo(null);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

}


