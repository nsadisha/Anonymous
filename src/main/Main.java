package main;

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

            //getting user input
            System.out.print(": ");
            input = sc.nextInt();
            System.out.println();

            if(input==1){
                contactList.getAll();
            }else if(input==2){
                String name;
                String phoneNo;
                System.out.println("Please enter name: ");
                name = sc.nextLine();
                System.out.println("Please add phone number: ");
                phoneNo = sc.nextLine();

                //adding the contact to the contact list
                contactList.addContact(name, phoneNo);
            }else if(input==3){

            }else if(input==4){

            }else if(input==5){

            }else if(input==6){

            }else if(input==7){
                System.out.println("Exit from the system...");
                System.exit(1);
            }else{
                System.out.println("Invalid input! Try again.");
            }
            System.out.println();

        }
    }
}
