import java.io.Serializable;
import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;
public class Book implements Serializable {
    private int bookID;
    private String bookName;
    private float bookPrice;
    private String bookAuthor;
    static int count=0;
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Book> issuebook = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    File file = new File("Books.ser");
    File issue = new File("issueBook.ser");
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;


    public Book() {
        bookID = 26;
        bookName = "java";
        bookPrice = 70;
        bookAuthor = "Haider";
    }

    public Book(int bookID, String bookName, float bookPrice, String bookAuthor) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
    }

    public int getBookID() {
        return this.bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getBookPrice() {
        return this.bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return this.bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    // overloading
    public void ViewBook(String name){
        if(file.isFile()){

            boolean found = false;
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
    
                books = (ArrayList<Book>)ois.readObject();
                ois.close();

                for(int i = 0; i < books.size(); i++){
                    if(books.get(i).getBookName().equals(name)){
                        found = true;
                        System.out.println("\n---------------------------------------\n");
                        System.out.println("Book Name: " + books.get(i).getBookName());
                        System.out.println("Book Id: " + books.get(i).getBookID());
                        System.out.println("Book Price: "+ books.get(i).getBookPrice());
                        System.out.println("Book Author: " + books.get(i).getBookAuthor());
                        System.out.println("\n---------------------------------------\n");
                    }
                }
                if(found == false){
                    // System.out.println("\nBook Not Found!!!\n");
                    JOptionPane.showMessageDialog(null, "Book Not Found!!!");
                }

                
            } 
            catch (IOException e) {
                System.out.println("\nCant read from Book File\n");
              } 
              catch (ClassNotFoundException e) {
                  System.out.println("Class not found");
                } 
        }


    }

      // overloading
    public void ViewBook(int BOOKID){

        if(file.isFile()){
            boolean found = false;
            try {
               
                ois = new ObjectInputStream(new FileInputStream(file));
    
                books = (ArrayList<Book>)ois.readObject();
                ois.close();
                
                for(int i = 0; i < books.size(); i++){
                     int Bid = books.get(i).getBookID();
                     String Bokid = String.valueOf(Bid);
                     String uid = String.valueOf(BOOKID);

                    if(Bokid.equals(uid)){

                        found = true;
                        System.out.println("\n---------------------------------------\n");
                        System.out.println("Book Name: " + books.get(i).getBookName());
                        System.out.println("Book Id: " + books.get(i).getBookID());
                        System.out.println("Book Price: "+ books.get(i).getBookPrice());
                        System.out.println("Book Author: " + books.get(i).getBookAuthor());
                        System.out.println("\n---------------------------------------\n");
                    }
                }
                if(found == false) {
                    // System.out.println("\nBook Not Found!!!\n");
                    JOptionPane.showMessageDialog(null, "Book Not Found!!!");
                }

                
            }
             catch (IOException e) {
              System.out.println("Cant read from Book File");
            } 
            catch (ClassNotFoundException e) {
                System.out.println("Class not found");
              } 
        }
    }

    // public boolean isAvailable(String name){
    //     boolean found = false;
    //     if(file.isFile()){
            
    //         try {
               
    //             ois = new ObjectInputStream(new FileInputStream(file));
    
    //             books = (ArrayList<Book>)ois.readObject();
    //             ois.close();

    //             for(int i = 0; i < books.size(); i++){
    //                 if( books.get(i).getBookName() == name){
    //                     found = true;
    //                 }
    //             }
    //         }
    //          catch (IOException e) {
    //           System.out.println("Cant read from Book File");
    //         } 
    //         catch (ClassNotFoundException e) {
    //             System.out.println("Class not found");
    //           } 
    //     }
    //     return found;

    // }

    public void returnBook(){

        Scanner sc = new Scanner(System.in);
        System.out.println("\n        Returning Book");
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine().toUpperCase();

        if(issue.isFile()){
            boolean found = false;
            try {
                ois = new ObjectInputStream(new FileInputStream(issue));
    
                issuebook = (ArrayList<Book>)ois.readObject();
                ois.close();

                for(int i = 0; i < issuebook.size(); i++){
                    if(issuebook.get(i).getBookName().equals(name)){
                        found = true;
                        issuebook.remove(i);
                    }
                }

                if(!found){
                    // System.out.println("\nBook Not Found\n");
                    JOptionPane.showMessageDialog(null, "Book Not Found");
                }
                else{
                    oos = new ObjectOutputStream(new FileOutputStream(issue));
                    oos.writeObject(issuebook);
                    oos.close();
                    // System.out.println("\nBook Returned Successfully\n");
                    JOptionPane.showMessageDialog(null, "Book Returned Successfully");
                }

                
            } catch (Exception e) {
             System.out.println(" ");
            } 
        }



    }

    public void viewIssueBook(){
        if(file.isFile()){
         
            try {
                ois = new ObjectInputStream(new FileInputStream(issue));
    
                issuebook = (ArrayList<Book>)ois.readObject();
                ois.close();

                for(int i = 0; i < issuebook.size(); i++){
                    issueBook ib = (issueBook)issuebook.get(i);
                    System.out.println("\n-------------------------------------");
                    System.out.println("Book Name: "+ib.getBookName());
                    System.out.println("Issued By: "+ib.getName());
                    System.out.println("Issued on: "+ib.getDateIssue());
                    System.out.println("-------------------------------------\n");
                        
                    }
                }
             catch (IOException e) {
             
            } 
            catch (ClassNotFoundException e) {
             
            } 
        }

    }

    public void issueBook(){


        Scanner sc = new Scanner(System.in);
        System.out.println("\n        Issuing Book");
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine().toUpperCase();
            if(file.isFile()){
                boolean found = false;
                try {
                    ois = new ObjectInputStream(new FileInputStream(file));
        
                    books = (ArrayList<Book>)ois.readObject();
                    ois.close();
    
                    for(int i = 0; i < books.size(); i++){
                        if(books.get(i).getBookName().equals(name)){
                            System.out.print("Enter Your Name: ");
                            String Name = sc.nextLine();
                            issueBook ib = new issueBook();
                            ib.setName(Name);
                            ib.setBookName(books.get(i).getBookName());
                            ois = new ObjectInputStream(new FileInputStream(issue));
    
                            issuebook = (ArrayList<Book>)ois.readObject();
                            issuebook.add(ib);
                            ois.close();

                            oos = new ObjectOutputStream(new FileOutputStream(issue));
                            oos.writeObject(issuebook);
                            oos.close();
                            // System.out.println("\nBook Issued Successfully\n");
                            JOptionPane.showMessageDialog(null, "Book Issued Successfully");
                            found = true;
                            
                        }
                    }

                    if(!found){
                        // System.out.println("\nBook Not Found\n");
                        JOptionPane.showMessageDialog(null, "Book Not Found");
                    }
                    
                } catch (Exception e) {
                 
                } 
            }

        }


    public void RemoveBook(){
        boolean found = false;
        int option = -1;
       
        while (found == false) {
            try {
                System.out.println("\n\nRemove Book by");
                System.out.println("1 --> Name:");
                System.out.println("2 --> Id:");
                System.out.print("Enter Option Here: ");
                option = sc.nextInt();
                found = true;
            } catch (InputMismatchException e) {
                sc.nextLine();
                JOptionPane.showMessageDialog(null, "Enter Correct Option\nEnter 1 or 2");
            }
        }
      
        if(option == 1){
           System.out.print("Enter Name of Book: ");
           sc.nextLine();
           String name = sc.nextLine().toUpperCase();
            if(file.isFile()){
                found = false;
                try {
                    ois = new ObjectInputStream(new FileInputStream(file));
        
                    books = (ArrayList<Book>)ois.readObject();
                    ois.close();
    
                    for(int i = 0; i < books.size(); i++){
                        if(books.get(i).getBookName().equals(name)){
                            found = true;
                            books.remove(i);
                        }
                    }

                    if(!found){
                        // System.out.println("Record Not Found");
                        JOptionPane.showMessageDialog(null, "Record Not Found");
                    }
                    else{
                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(books);
                        oos.close();
                        // System.out.println("\nRecord deleted successfully\n");
                        JOptionPane.showMessageDialog(null, "Record deleted successfully");
                    }

                } catch (Exception e) {
                 
                } 
            }
        }

        else if(option == 2){

            System.out.print("Enter Book ID : ");
           sc.nextLine();
           int id = sc.nextInt();
            if(file.isFile()){
                found = false;
                try {
                    ois = new ObjectInputStream(new FileInputStream(file));
        
                    books = (ArrayList<Book>)ois.readObject();
                    ois.close();
    
                   
                for(int i = 0; i < books.size(); i++){
                    int Bid =books.get(i).getBookID();
                    if( Bid == id){
                        found = true;
                        books.remove(i);
                    }
                }

                    if(!found){
                        System.out.println("Record Not Found");
                    }
                    else{
                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(books);
                        oos.close();
                        // System.out.println("\nRecord deleted successfully\n");
                        JOptionPane.showMessageDialog(null, "Record deleted successfully");
                    }
                    
                } catch (Exception e) {
                } 
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Enter Correct Option");
        }
    }

    public void AddBooks(){
       boolean done = false;
       String BookName = "";
       while (done == false) {
        boolean bookfound = false;
        sc.nextLine();
        System.out.print("\nEnter Name of Book: ");
        BookName = sc.nextLine().toUpperCase();

        if(file.isFile()){   
            try {
    
                ois = new ObjectInputStream(new FileInputStream(file));
        
                books = (ArrayList<Book>)ois.readObject();
                ois.close();

                for(int i = 0; i < books.size(); i++){
                    if(books.get(i).getBookName().equals(BookName)){
                     bookfound = true;
                    break;
                    }
                }
                
                // System.out.println("\nBook added successfully\n");

            } catch (Exception e) {
             System.out.print("Something Wrong with Book File");
            }
        }
        if(bookfound == false){
            done = true;
        }
        else{
            done =false;
            JOptionPane.showMessageDialog(null, "Book Already Exist !!");
        }
       }
        


        done = false;
        int BOOKID = 0;
        while (done == false) {
            try {
                System.out.print("Enter Book ID: ");
                BOOKID = sc.nextInt();


                boolean bookfound = false;
        
                if(file.isFile()){   
                    try {
            
                        ois = new ObjectInputStream(new FileInputStream(file));
                
                        books = (ArrayList<Book>)ois.readObject();
                        ois.close();
        
                        for(int i = 0; i < books.size(); i++){
                            if(books.get(i).getBookID() == BOOKID){
                             bookfound = true;
                            break;
                            }
                        }
                        
                        // System.out.println("\nBook added successfully\n");
        
                    } catch (Exception e) {
                     System.out.print("Something Wrong with Book File");
                    }
                }
                if(bookfound == false){
                    done = true;
                }
                else{
                    done =false;
                    JOptionPane.showMessageDialog(null, "Book ID Exist !!");
                }


            } catch (InputMismatchException e) {
            //   System.out.println("\n Please Enter Valid Book ID !!\n");
              JOptionPane.showMessageDialog(null, "Please Enter Valid Book ID !!");
              sc.nextLine();
            }
        }





        
        done = false;
        float BOOKPrice = 0;
        while (done == false) {
            try {
                System.out.print("Enter Book Price: ");
                BOOKPrice = sc.nextFloat();
                done = true;
            } catch (InputMismatchException e) {
            //   System.out.println("\n Please Enter Valid Book Price !!\n");
              JOptionPane.showMessageDialog(null, "Please Enter Valid Book Price !!");
              sc.nextLine();
            }
        }

   
        sc.nextLine();
        System.out.print("Enter Book Author: ");
        String BookAuthor = sc.nextLine();
        Book b = new Book(BOOKID, BookName, BOOKPrice, BookAuthor);
        if(file.isFile()){   
        try {

            ois = new ObjectInputStream(new FileInputStream(file));
    
            books = (ArrayList<Book>)ois.readObject();
            books.add(b);
            ois.close();

            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(books);
            oos.close();
            
            // System.out.println("\nBook added successfully\n");
            JOptionPane.showMessageDialog(null, "Book added successfully");
        } catch (Exception e) {
         System.out.print("Something Wrong with Book File");
        }
    }
     

    }

    
    public void ShowAllBooks(){

        if(file.isFile()){
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
    
                books = (ArrayList<Book>)ois.readObject();
                ois.close();

                for(int i = 0; i < books.size(); i++){
                    if(books.get(i)instanceof Book){
                        count++;
                        System.out.println("\n           Book No "+ count);
                        System.out.println("Book Name: " + books.get(i).getBookName());
                        System.out.println("Book Id: " + books.get(i).getBookID());
                        System.out.println("Book Price: "+ books.get(i).getBookPrice()+" Rs");
                        System.out.println("Book Author: " + books.get(i).getBookAuthor());
                        System.out.println("-------------------------------------------------\n");

                    }
                }

                
            } catch (Exception e) {
             
            } 
        }

        
    }


}
