package main;

import java.util.ArrayList;

public class ContactList {
    private ArrayList<Contact> contacts;

    public ContactList() {
        this.contacts = new ArrayList<Contact>();
    }

    //methods
    public void getAll(){
        Contact temp;
        if (this.getSize()>0){
            for(int i=0; i<this.getSize(); i++){
                temp = this.contacts.get(i);

                //display info
                System.out.println(temp.getName()+" "+temp.getPhoneNo());
            }
        }else{
            System.out.println("Contact list is empty!");
        }
    }
    public int getSize(){
        return this.contacts.size();
    }

    public void addContact(String name, String phoneNo){
        Contact temp = new Contact(name, phoneNo);
        this.contacts.add(temp);
    }
}
