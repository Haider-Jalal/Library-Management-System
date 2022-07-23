
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Student implements Login, Serializable {

    private String Name;
    private int Age;
    private String Email;
    private String PhoneNumber;
    private String Address;
    private String id;
    private String Password;

    //already registerd student
    //id = haider 
    //pass = 123

    private static final long serialVersionUID=7317700635876953858L;

    // static ArrayList<Person> student = new ArrayList<>();
   static ArrayList<Student> student = new ArrayList<>();
    File studentfile = new File("Students.ser");
    ObjectOutputStream os = null;
    ObjectInputStream oin = null;

    public Student() {

    }
    // public Student(String name, int age, String email, String phone, String address, String id, String password){
    //     super(name, age, email, phone, address, id, password);
    // }
    public Student(String name, int age, String email, String phone, String address, String id, String password){
        this.Name = name;
        this.Age = age;
        this.Email = email;
        this.PhoneNumber = phone;
        this.Address =address;
        this.id = id;
        this.Password = password;
    }

    //    Setters
    public void setAddress(String Address) {
        this.Address = Address;
    }
   
    public void setAge(int Age) {
        this.Age = Age;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public void setId(String id) {
        this.id = id;
    }
   
    public void setName(String Name) {
        this.Name = Name;
    }
   
    public void setPassword(String Password) {
        this.Password = Password;
    }
   
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
// Getters
    public String getAddress() {
        return Address;
    }
  
    public int getAge() {
        return Age;
    }
   
    public String getEmail() {
        return Email;
    }
   
    public String getId() {
        return id;
    }
    public String getName() {
        return Name;
    }
   
    public String getPassword() {
        return Password;
    }
   
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    

    @Override
    public boolean login(String ID, String pass) {
        if ((this.getId().equals(ID)) && (this.getPassword().equals(pass))) {
            return true;
        } else {
            return false;
        }
    }

    public void StudentLogin(String id , String Pass ){
       

        if(studentfile.isFile()){
            boolean found = false;
            try {
                oin = new ObjectInputStream(new FileInputStream(studentfile));
    
                student = (ArrayList<Student>)oin.readObject();
                oin.close();
                for (int i = 0; i < student.size(); i++) {

                    if (student.get(i) instanceof Student) {

                        Student st = (Student) student.get(i);
                        if(st.login(id, Pass)){
                            found = true;
                            // System.out.println("\nLogin Successfully\n");
                            JOptionPane.showMessageDialog(null, "Login Successfully");

                            StudentMenu();
                            
                        }
                        
                    }
                }
                if(!found){
                    // System.out.println("\nInvalid ID or Password!!\n");
                    JOptionPane.showMessageDialog(null, "Invalid ID or Password!!");
                }
                
            } catch (IOException e) {
             System.out.println("\nSomething wrong in Student file reading\n");
            } 

            catch (ClassNotFoundException e) {
                System.out.println("\nStudent Class not found\n");
               } 
        }
    }

    public void  ViewStudent(){

    
        if(studentfile.isFile()){

            try {
                oin = new ObjectInputStream(new FileInputStream(studentfile));
    
                student = (ArrayList<Student>)oin.readObject();
                oin.close();
                for (int i = 0; i < student.size(); i++) {

                    if (student.get(i) instanceof Student) {
                        Student stu = (Student) student.get(i);
                        System.out.println("\n----------------------\n");
                        System.out.println("Name: "+ stu.getName());
                        System.out.println("Age: "+ stu.getAge());
                        System.out.println("Phone Number: "+ stu.getPhoneNumber());
                        System.out.println("Email: "+ stu.getEmail());
                        System.out.println("Address: "+ stu.getAddress());
                        System.out.println("\n----------------------\n");
                        
                        
                    }
                }
                
            } catch (IOException e) {
             System.out.println("\nSomething wrong in Student file reading\n");
            System.out.println("erorr = "+e);
            } 


            catch (ClassNotFoundException e) {
                System.out.println("\nStudent Class not found\n");
               } 
        }


    }

    public void Registration() {
        int age = 0;
        String email = "";
        String name = "";
        boolean done = false;
        Scanner sc = new Scanner(System.in);
        while (done == false) {
            System.out.print("Enter Name: ");
             name = sc.nextLine();

             boolean containsDigit = false;

             if (name != null && !name.isEmpty()) {
                 for (char c : name.toCharArray()) {
                     if (containsDigit = Character.isDigit(c)) {
                        JOptionPane.showMessageDialog(null, "Name Should Contain Alphabets Only!");
                         break;
                     }
                     else{ 
                        containsDigit = false;
                     }
                 }
             }
             if(containsDigit == false){
                 done = true;
             }
             else{
                done = false;
             }
            // if(!name.contains("[0-9]")){
            //     done = true;
            // }
            // else{
            //     JOptionPane.showMessageDialog(null, "Name Should Contain Alphabets Only!");
            // }
        }
      done = false;

        while (done == false) {
            try {
                System.out.print("Enter Age: ");
                age = sc.nextInt();
                if(age > 13 && age < 90){
                    done = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Enter Correct Age!!");
                }
            } catch (InputMismatchException e) {
             sc.nextLine();
            //  System.out.println("\nEnter Correct Age!!\n");
             JOptionPane.showMessageDialog(null, "Enter Correct Age!!\n Age Must be (14 - 90)");
            }
        }
        done= false;
        sc.nextLine();
        String phoneNumber =" ";
      while (done == false) {
        System.out.print("Enter Mobile Number: ");
        phoneNumber = sc.nextLine();
        if((phoneNumber.length() == 11) ) {
            if (((phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '3'))) {
           
                if(phoneNumber.charAt(2) =='1' || phoneNumber.charAt(2) == '3' || phoneNumber.charAt(2) == '4' || phoneNumber.charAt(2) == '0'){
                   done = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Phone Number !!\nNumber Should be (030xxxxxxx) \nNumber Should be (031xxxxxxxx)\nNumber Should be (033xxxxxxxx)\nNumber Should be (034xxxxxxxx)");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Phone Number !!\n Number Should be (03xxxxxxxxx)");
            }
          
        }
        else{
                // System.out.println("\nInvalid Phone Number !!\n");
                JOptionPane.showMessageDialog(null, "Invalid Phone Number !!\n Number must be 11 digits");
        }
      }
        done = false;
        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        while (done == false) {
                System.out.print("Enter Email: ");
                email = sc.nextLine();
                if(email.contains("@gmail.com") || email.contains("@yahoo.com") || email.contains("@hotmail.com") || email.contains("@icloud.com")) {
                    done = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Enter Valid Email!!\n xxx@gmail.com \n xxx@yahoo.com\n xxx@hotmail.com");
                } 
        }
      
        System.out.print("Enter Id: ");
        String id = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Student stu = new Student(name, age, email, phoneNumber, address, id, password);
        
        if(studentfile.isFile()){
        try {
            oin = new ObjectInputStream(new FileInputStream(studentfile));
    
            student = (ArrayList<Student>)oin.readObject();
            student.add(stu);
            oin.close();
            os = new ObjectOutputStream(new FileOutputStream(studentfile));
            os.writeObject(student);
            os.close();
            // System.out.println("\nRegistration Done Successfully!!\n");
            JOptionPane.showMessageDialog(null, "Registration Done Successfully!!");
            
        } catch (Exception e) {
         System.out.print("\nSomething Wrong with Student File\n");
        }
    }

    }

    public void StudentMenu(){
        Scanner sc = new Scanner(System.in);
        int option= -1;
        Book b = new Book();
        do {
            System.out.println("\n\n1 --> Issue Book");
            System.out.println("2 --> Return Book");
            System.out.println("3 --> Search Book");
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
                  b.issueBook();
                    break;
                case 2:
                  b.returnBook();
                    break;
                case 3:
                 boolean done = false;
                 int search = -1;
                 int ID = -1;
                 while (done == false) {
                     try {
                        System.out.println("\n   Searching Book");
                        System.out.println("1 --> By Name");
                        System.out.println("2 --> By ID");
                        System.out.print("Enter Option Here: ");
                         search = sc.nextInt();
                         done = true;
                         
                     } catch (InputMismatchException im) {
                        //  System.out.println("\nEnter Correct Option!!\n");
                         JOptionPane.showMessageDialog(null, "Enter Correct Option!!");
                         sc.nextLine();
                     }
                    
                 }
                  done = false;
                    if (search == 1) {
                       System.out.print("\nEnter Book Name: ");
                       sc.nextLine();
                       String name = sc.nextLine().toUpperCase();
                       b.ViewBook(name);

                     }
                     else if (search == 2) {
                         while ( done == false) {
                             try {
                                System.out.print("\nEnter Book ID: ");
                                ID = sc.nextInt();
                                done = true;
                             } catch (InputMismatchException e) {
                                 sc.nextLine();
                              JOptionPane.showMessageDialog(null, "Enter Valid Book ID");
                             }
                         }
                       
                        b.ViewBook(ID);
                     }
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

    public void RemoveStudent(){
        boolean found = false;
        Scanner sc = new Scanner(System.in);
           System.out.print("Enter Name of Student: ");
         //  sc.nextLine();
           String name = sc.nextLine();
            if(studentfile.isFile()){
               
                try {
                    oin = new ObjectInputStream(new FileInputStream(studentfile));
        
                    student = (ArrayList<Student>)oin.readObject();
                    oin.close();
    
                    for(int i = 0; i < student.size(); i++){
                        if(student.get(i).getName().equals(name)){
                            found = true;
                            student.remove(i);
                        }
                    }

                    if(!found){
                        // System.out.println("Record Not Found");
                        JOptionPane.showMessageDialog(null, "Record Not Found");
                    }
                    else{
                        os = new ObjectOutputStream(new FileOutputStream(studentfile));
                        os.writeObject(student);
                        os.close();
                        // System.out.println("\nRecord deleted successfully\n");
                        JOptionPane.showMessageDialog(null, "Record deleted successfully");
                    }

                } catch (Exception e) {
                 System.out.println(e);
                } 
            }
    }

}
