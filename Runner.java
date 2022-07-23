import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import java.awt.Color;
import java.awt.Font;


public class Runner implements Serializable {

    static Librarian lib[] = new Librarian[1];
    public static void main(String[] args) throws IOException {

        JFrame f = new JFrame("Library Management System");
        ImageIcon img = new ImageIcon("library.jpg");
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 426);
        JLabel l = new JLabel("Welcome to library");
        l.setFont(new Font("Lucida Sans Typewriter", Font.BOLD,25));
        l.setForeground(Color.WHITE);
        l.setBackground(Color.gray);
        l.setOpaque(true);
        l.setBounds(50, 50, 380, 40);
        f.setLayout(null);
        JLabel l2 = new JLabel();
        l2.setBounds(0, 0,500,426);
        l2.setIcon(img);
       
        JButton login = new JButton("Login");
        JButton signup = new JButton("Signup");
        JButton logout = new JButton("Exit");

        login.setOpaque(true);
        login.setBackground(Color.GRAY);
        login.setBorderPainted(false);
        signup.setOpaque(true);
        signup.setBackground(Color.GRAY);
        signup.setBorderPainted(false);
        logout.setOpaque(true);
        logout.setBackground(Color.GRAY);
        logout.setBorderPainted(false);

        login.setFont(new Font("Lucida Calligraphy", Font.BOLD, 18));
        signup.setFont(new Font("Lucida Calligraphy", Font.BOLD, 14));
        logout.setFont(new Font("Lucida Calligraphy", Font.BOLD, 18));
        login.setFocusable(false);
        signup.setFocusable(false);
        logout.setFocusable(false);
       
        f.add(login);
        f.add(signup);
        f.add(l);
        f.add(logout);
        login.setBounds(200, 150, 90, 40);
        signup.setBounds(200, 200, 90, 40);
        logout.setBounds(200, 300, 90, 40);
        f.add(l2);
        f.setVisible(true);


        Scanner sc = new Scanner(System.in);
        // int option = -1;
//
//        do {
//
//            System.out.println("\nWelcome to Libaray Managment System\n");
//            System.out.println("1 --> Login");
//            System.out.println("2 --> SignUp");
//            System.out.println("0 --> Logout\n");
//            System.out.print("Enter option Here: ");
//            try {
//                option = sc.nextInt();
//            } catch (InputMismatchException e) {
//                sc.nextLine();
//                System.out.println("");
//            }
//
//            switch (option) {

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
               
                int loginOption = -1;
                do {
                    System.out.println("\nLogin As ");
                    System.out.println("1 --> Librarian");
                    System.out.println("2 --> Student");
                    System.out.println("0 --> Back to Main Menu ");
                    System.out.print("Enter option here: ");
                    try {
                        loginOption = sc.nextInt();
                    } catch (InputMismatchException ge) {
                        sc.nextLine();
                        System.out.println("");
                    }


                    if (loginOption == 1) {
                        sc.nextLine();
                        System.out.println("\nLogin as Librarian");
                        Librarian l1 = new Librarian();

                        System.out.print("Enter Id: ");
                        String lib_id = sc.nextLine();
                        System.out.print("Enter Password: ");
                        String lib_Pass = sc.nextLine();
                        if (l1.login(lib_id, lib_Pass)) {
                            // System.out.println("\nLogin Successfully\n");
                            JOptionPane.showMessageDialog(null, "Login Successfully");
                            l1.Menu();
                            // admin methods goes here

                        } else {
                            // System.out.println("\nInvalid id or Password!!");
                            JOptionPane.showMessageDialog(null, "Invalid id or Password!!");
                        }

                    } else if (loginOption == 2) {
                        System.out.println("\nLogin as Student");
                        sc.nextLine();
                        Student s = new Student();

                        System.out.print("Enter ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Password: ");
                        String Pass = sc.nextLine();

                        s.StudentLogin(id, Pass);

                    } else if (loginOption == 0) {
                        f.setVisible(true);
                    } else {
                        // System.out.println("\nEnter Correct Option!!\n");
                        JOptionPane.showMessageDialog(null, "Enter Correct Option!!");
                    }

                } while (loginOption != 0);
            }
        });

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                int userOption = -1;
                do {
                    System.out.println("\nSignUp");
                    System.out.println("1 --> Registration");
                    System.out.println("0 --> Back to Main Menu");
                    System.out.print("Enter option here: ");
                    try {
                        userOption = sc.nextInt();
                    } catch (InputMismatchException ge) {
                        sc.nextLine();
                        System.out.println("");
                    }

                    if (userOption == 1) {
                        System.out.println("\nStudent Registration\n");


                        Student s = new Student();
                        s.Registration();

                    } else if (userOption == 0) {
                      f.setVisible(true);
                    } else {
                        // System.out.println("\nEnter Correct Option!!\n");
                        JOptionPane.showMessageDialog(null, "Enter Correct Option!!");
                    }
                } while (userOption != 0);

            }
        });

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(8);
            }
        });
    }}
