public class Person {

    private String Name;
    private int Age;
    private String Email;
    private String PhoneNumber;
    private String Address;
    private String id;
    private String Password;

    public Person(){

    }

  public Person(String name, int age, String email, String phone, String address, String id, String password){
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
    
    

}
