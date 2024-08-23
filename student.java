
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
class student implements ActionListener{
    JFrame f;
    JTextField t1,t2,t3,t4;
    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3,b4;
    JPanel p1;
    JTextArea ta;
    student(){
        f=new JFrame("studnet");
        p1=new JPanel();
        t1=new JTextField();
        ta=new JTextArea();
        ta.setBounds(30,300,430,200);
        t1.setBounds(150,30,200,25);
        
        t2=new JTextField();
        t2.setBounds(150,70,200,25);
        
        t3=new JTextField();
        t3.setBounds(150,110,200,25);
        
        t4=new JTextField();
        t4.setBounds(150,150,200,25);
       
        l1=new JLabel("roll no");
        l1.setBounds(30,30,100,25);
       
        l2=new JLabel("name");

        l2.setBounds(30,70,100,25);
       
        l3=new JLabel("Age:");
        l3.setBounds(30,110,100,25);
       
        l4=new JLabel("CGPA:");
        l4.setBounds(30,150,100,25);
       
        b1=new JButton("ADD");
        b1.setBounds(30,200,80,25); 
       
        b2=new JButton("Delete");
        b2.setBounds(120,200,80,25);
       
        b3=new JButton("Search");
        b3.setBounds(210,200,80,25);
        
    
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(l3);
        f.add(t3);
        f.add(l4);
        f.add(t4);
        f.add(b1);
        f.add(p1);
        f.add(b2);
        f.add(p1);
        f.add(b3);
        f.add(p1);
        f.add(ta);
        f.add(p1);
        b1.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
        f.setSize(400,400);
        f.setVisible(true);
        f.setLayout(null);

    }
    public void actionPerformed(ActionEvent e){
        FileReader f;
          FileWriter f1;  
          //BufferedReader br;
          //BufferedWriter bw;
          //byte b[];
            if(e.getSource()==b1){
                String s1=t1.getText();
                String s2=t2.getText();
                String s3=t3.getText();
                String s4=t4.getText();
                String s=s1+","+s2+","+s3+","+s4;
                //b=s.getBytes();
            try( BufferedWriter bw=new BufferedWriter(new FileWriter("sample.txt",true))){
                //f=new FileReader("sample.txt");
                
                  bw.write(s);
                  bw.newLine();
                  /*t1.setText("");
                  t2.setText("");
                  t3.setText("");
                  t4.setText("");*/
                  ta.setText("Added successfully");
                  
                //int i;
                


            }
            catch(Exception obj){
                System.out.println(obj);

            }
        }
        if(e.getSource()==b3){
            
            String s1=t1.getText();
            String s2=t2.getText();
            String s3=t3.getText();
            String s4=t4.getText();
            //String line;
            boolean found=false;
            try(BufferedReader br=new BufferedReader(new FileReader("sample.txt"))){
                String line;
            while((line=br.readLine())!=null){
                if(line.startsWith(s1+",")){
                  // ta.setText("student found");
                   ta.setText(line.replace(",", " |"));
                   found=true;
                   break;
                }
            }
                if(!found){
                    ta.setText("Not Found");
                }
            }
        catch(Exception obj){
            System.out.println(obj);
        }
    }
    if(e.getSource()==b2){
        String s1=t1.getText();
        StringBuffer sb=new StringBuffer();
        boolean found=false;
        try(BufferedReader br=new BufferedReader(new FileReader("sample.txt"))){
            String line;
            while((line=br.readLine())!=null){
                if(line.startsWith(s1+",")){
                    found=true;
                    ta.setText("Record is deleted");

                }
                else{
                    sb.append(line).append("\n");
                }

            }
            if(found){
                try(BufferedWriter bw=new BufferedWriter(new FileWriter("sample.txt"))){
                    bw.write(sb.toString());

                }
                catch(Exception ob){
                    System.out.println(ob);
                }
            }

        }
        catch(Exception obj){
            System.out.println(obj);

        }



    }
}



        
        
    

    public static void main(String[] args) {
        new student();
    }
}
