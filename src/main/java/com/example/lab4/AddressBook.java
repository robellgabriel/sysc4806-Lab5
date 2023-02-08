package com.example.lab4;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class AddressBook {

    @Id
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddyAddressBook;

    public AddressBook(){
        buddyAddressBook = new ArrayList<BuddyInfo>();
    }

    public void setBuddyAddressBook(ArrayList<BuddyInfo> buddyAddressBook) {
        this.buddyAddressBook = buddyAddressBook;
    }

    public List<BuddyInfo> getBuddyAddressBook() {
        return buddyAddressBook;
    }

    public BuddyInfo getBuddyInfo(int x) {
        return buddyAddressBook.get(x);
    }

    public void addBuddy(BuddyInfo aBuddyInfo){
        if (buddyAddressBook != null){
            buddyAddressBook.add(aBuddyInfo);
        }
    }

    public void removeBuddy(int id) {
        buddyAddressBook.removeIf(buddy -> buddy.getID() == id);
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return "AddressBook{" + buddyAddressBook + '}';
    }

    public static void main(String[] args) {
        BuddyInfo buddy1 = new BuddyInfo("Tom", "Carleton", "613");
        BuddyInfo buddy2 = new BuddyInfo("Robell", "Carleton", "613");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        System.out.println(addressBook.toString());
    }
}


