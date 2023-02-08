package com.example.Lab5;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AddressBookTest {

    @Autowired
    AddressBookRepository addrepo;
    BuddyInfo buddy1 = new BuddyInfo("Tom", "Carleton", "613");
    BuddyInfo buddy2 = new BuddyInfo("Robell", "Carleton", "613");
    AddressBook addressBook = new AddressBook();

    @Test
    public void getBuddyInfo() {
        buddy1.setID(1);
        buddy2.setID(2);
        addressBook.setID(1);
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        addrepo.save(addressBook);

        assertEquals(addressBook.getBuddyInfo(0).getName(), addrepo.findByID(1).getBuddyInfo(0).getName());
        assertEquals(addressBook.getBuddyInfo(1).getName(), addrepo.findByID(1).getBuddyInfo(1).getName());
    }
}