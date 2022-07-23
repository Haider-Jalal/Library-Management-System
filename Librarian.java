

import java.util.*;

import javax.swing.JOptionPane;

public class Librarian extends Person implements Login {

    public Librarian() {

        this.setName("Hairan");
        this.setAge(20);
        this.setEmail("Hairan2635@gmail.com");
        this.setAddress("Comsats University");
        this.setPhoneNumber("+923496969699");
        this.setId("admin");
        this.setPassword("123");

    }

    @Override
    public boolean login(String id, String pass) {
        if ((this.getId().equals(id)) && (this.getPassword().equals(pass))) {
            return true;
        } else {
            return false;
        }
    }

    // public void display(){
    //     System.out.println("Name: "+this.getName());
    //     System.out.println("Age: "+this.getAge());
    //     System.out.println("Email: "+this.getAddress());
    //     System.out.println("Address: "+this.getAddress());
    //     System.out.println("Phone Number: "+ this.getPhoneNumber());
    //     System.out.println("Id : "+this.getId());
    //     System.out.println("Password: "+this.getPassword());

    // }

    public void Menu(){
        Scanner sc = new Scanner(System.in);
        int option= -1;
        Book b = new Book();
        Student s = new Student();

        do {
            System.out.println("\n\n1 --> Add Books");
            System.out.println("2 --> Remove Books");
            System.out.println("3 --> View Books");
            System.out.println("4 --> View issued Books");
            System.out.println("5 --> View Registered Students");
            System.out.println("6 --> Remove Student");
            System.out.println("0 --> Exit");
            System.out.print("Enter Option Here: ");

            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("");
            }

            switch (option) {
                case 1:
               
                System.out.println("\nEnter Detials of BOOK\n");
                b.AddBooks();
              
                        System.out.println("Book Name: " + b.getBookName());
                        System.out.println("Book Id: " + b.getBookID());
                        System.out.println("Book Price: "+ b.getBookPrice()+" Rs");
                        System.out.println("Book Author: " + b.getBookAuthor());
                        System.out.println("-------------------------------------------------\n");
                    break;
                case 2:
                    b.RemoveBook();
                    break;
                case 3:
                    System.out.println("\nShowing all Available Books\n");
                    b.ShowAllBooks();
                    break;
                case 4:
                    b.viewIssueBook();
                    break;
                case 5:
                   
                    s.ViewStudent();
                    break;
                case 6:
                  
                    s.RemoveStudent();
                    break;
                case 0:
                    // System.out.println("Exit Successfully!!");
                    JOptionPane.showMessageDialog(null, "Exit Successfully!!");

                    break;
            
                default:
                // System.out.println("\nEnter Correct Option!!\n");
                JOptionPane.showMessageDialog(null, "Enter Correct Option!!");
                    break;
            }
            
        } while (option!=0);
        
    }

    

}
