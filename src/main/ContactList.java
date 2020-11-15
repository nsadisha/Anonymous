package main;

import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Contact> contacts;
    private int currentIndex;

    public ContactList() {
        this.contacts = new ArrayList<Contact>();
    }

    //methods

    //display all contacts
    public String displayContacts(){
        Contact temp;
        StringBuilder s = new StringBuilder("Contact list is empty");
        try {
            if (this.getSize()>0){
                s = new StringBuilder();
                for(int i=0; i<this.getSize(); i++){
                    temp = this.contacts.get(i);

//                    System.out.println(temp.getName()+" "+temp.getPhoneNo());
                    s.append(temp.getName()).append(" ").append(temp.getPhoneNo()).append("\n");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return s.toString();
    }
    //return the current size
    public int getSize(){
        return this.contacts.size();
    }

    //add a new contact
    public void addContact(String name, String phoneNo){
        boolean isOk = false;
        try {
            if(Long.parseLong(phoneNo)>0 && phoneNo.length()==10){
                Contact temp = new Contact(name, phoneNo);
                this.contacts.add(temp);
                isOk = true;
            }else{
                throw new Exception("Phone number contains 10 digits.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (isOk){
            System.out.println("Contact successfully added!");
        }
    }

    //edit a contact
    public void editContact(String name, String newPhoneNo){
        boolean isOk = true;
        try {
            if (Long.parseLong(newPhoneNo)>0 && newPhoneNo.length()==10){
                this.getIndexOf(name);
                this.contacts.get(this.currentIndex).setPhoneNo(newPhoneNo);
            }else{
                throw new Exception("Phone number contains 10 digits.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            isOk = false;
        }
        if (isOk){
            System.out.println("Changes saved!");
        }
    }

    //delete a contact
    public void deleteContact(String name){
        boolean isOk = true;
        try{
            this.getIndexOf(name);
            this.contacts.remove(this.currentIndex);
        }catch (Exception e){
            System.out.println(e.getMessage()+"mm");
            isOk = false;
        }
        if(isOk){
            System.out.println("Contact successfully deleted!");
        }
    }
    //set the currentIndex to a particular contact's index
    private void getIndexOf(String name){
        try {
            for(int i=0; i<this.contacts.size(); i++){
                if(name.equalsIgnoreCase(this.contacts.get(i).getName())){
                    this.currentIndex = i;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //load contacts from a text file
    public void loadContacts(){
        try {
            File myData = new File("src/contacts.txt");
            Scanner myScanner = new Scanner(myData);
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                String name = data.split(" ")[0];
                String phoneNo = data.split(" ")[1];
                this.addContact(name, phoneNo);
            }
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            System.out.println(e.getMessage());
        }
    }

    //save all contacts to a text file
    public void saveContacts(){
        boolean isOk = true;
        try {
            File objFile = new File("src/output.txt");
            if(!objFile.exists()) {
                if (objFile.createNewFile()) {
                    System.out.println("File created");
                } else {
                    System.out.println("File not created");
                    System.exit(0);
                }
            }
            FileOutputStream fileOut =new FileOutputStream(objFile,false);
            String text = this.displayContacts();
                fileOut.write(text.getBytes());

            fileOut.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            isOk = false;
        }
        if (isOk){
            System.out.println("Contacts saved!");
        }
    }
}
