import java.io.*;
import java.util.Date;

public class issueBook extends Book implements Serializable {

    private String name;
    private java.util.Date DateIssue;

    public issueBook() {
        super();
       DateIssue = new Date();
       name = "haider";
    }


    public void setDateIssue(java.util.Date dateIssue) {
        DateIssue = dateIssue;
    }
  
    public java.util.Date getDateIssue() {
        return DateIssue;
    }

    public void setName(String name) {
    this.name = name;
    }

    public String getName() {
    return name;
    }
    
}
