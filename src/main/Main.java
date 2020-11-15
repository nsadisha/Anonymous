package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactList contactList = new ContactList();
        int input;
        while(true){
            System.out.println("Enter 1 to display all contacts");
            System.out.println("Enter 2 to add contact");
            System.out.println("Enter 3 to remove contact");
            System.out.println("Enter 4 to edit a contact");
            System.out.println("Enter 5 to load contacts from a text file");
            System.out.println("Enter 6 to save contacts to the text file");
            System.out.println("Enter 7 to exit from the program");

            try{
                //getting user input
                System.out.print(": ");
                input = sc.nextInt();
                System.out.println();

                if(input==1){
                    //display all
                    String result = contactList.displayContacts();
                    System.out.println(result);
                }else if(input==2){
                    //add contact
                    String name;
                    String phoneNo;

                    System.out.print("Please enter name(first name): ");
                    name = sc.next();
                    System.out.print("Please add phone number: ");
                    phoneNo = sc.next();

                    //adding the contact to the contact list
                    contactList.addContact(name, phoneNo);
                }else if(input==3){
                    //remove contact
                    if (contactList.getSize()>0){
                        String name;

                        System.out.print("Please enter name of the contact that you want to delete: ");
                        name = sc.next();

                        contactList.deleteContact(name);
                    }else{
                        System.out.println("Contact list is empty! Nothing to delete.");
                    }
                }else if(input==4){
                    //edit contact
                    if (contactList.getSize()>0){
                        String name;
                        String newPhoneNum;

                        System.out.print("Please enter name of the contact that you want to change: ");
                        name = sc.next();
                        System.out.print("Please enter the new phone number: ");
                        newPhoneNum = sc.next();

                        contactList.editContact(name, newPhoneNum);
                    }else{
                        System.out.println("Contact list is empty! Nothing to edit.");
                    }
                }else if(input==5){
                    //load contacts
                    contactList.loadContacts();

                }else if(input==6){
                    //save contacts
                    contactList.saveContacts();

                }else if(input==7){
                    //exit
                    System.out.println("Exit from the system...");
                    System.exit(1);
                }else{
                    System.out.println("Try 1,2,3,4,5,6 or 7");
                }
            }catch (InputMismatchException e){
                System.out.println("Enter a valid input");
                //to fix the infinite looping bug
                sc.next();
            }catch (Exception e){
                System.out.println("Oops! Something went wrong!");
                //to fix the infinite looping bug
                sc.next();
            }
            System.out.println();
        }
    }
}
