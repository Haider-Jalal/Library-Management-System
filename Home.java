import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class to implement home menu
public class Home implements ActionListener
{
    JFrame home = new JFrame();
    JButton librarianJButton = new JButton("Librarian");
    JButton studentJButton = new JButton("Student");
    JButton exit = new JButton("Exit");

    Home()
    {
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setLayout(null);
        home.setSize(500,426);
        home.setLocationRelativeTo(null);

        librarianJButton.setFocusable(false);
        librarianJButton.setBounds(170,90,150,40);
        librarianJButton.addActionListener(this);
        home.add(librarianJButton);
        home.setResizable(false);

        studentJButton.setFocusable(false);
        studentJButton.setBounds(170,150,150,40);
        studentJButton.addActionListener(this);
        home.add(studentJButton);

        exit.setFocusable(false);
        exit.setBounds(400,220,70,30);
        exit.addActionListener(this);
        home.add(exit);
        home.setResizable(false);
        home.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        if (e.getSource() == librarianJButton)
        {
            home.dispose();
        }

        else if (e.getSource() == studentJButton)
        {
            home.dispose();
          
        }
  
        else if (e.getSource() == exit)
        {
            home.dispose();
        }
    }
}