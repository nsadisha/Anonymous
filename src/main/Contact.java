package main;

public class Contact {
    private String name;
    private String phoneNo;

    //constructor
    public Contact(String name, String phoneNo){
        this.name = name;
        this.phoneNo = phoneNo;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
