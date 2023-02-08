package com.example.lab4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BuddyInfoTest{

    @Autowired
    BuddyInfoRepository buddyrepo;
    BuddyInfo buddy1 = new BuddyInfo("Tom", "Carleton", "613");
    BuddyInfo buddy2 = new BuddyInfo("Robell", "Carleton", "613");

    @Test
    public void getName(){
        buddy1.setID(1);
        buddy2.setID(2);

        buddyrepo.save(buddy1);
        buddyrepo.save(buddy2);

        assertEquals("Tom", buddyrepo.findByID(1).getName());
        assertEquals("Robell", buddyrepo.findByID(2).getName());
    }

    @Test
    public void setName(){
        buddy1.setID(1);
        buddy2.setID(2);

        buddy1.setName("Matt");
        buddy2.setName("Kevin");

        buddyrepo.save(buddy1);
        buddyrepo.save(buddy2);

        assertEquals("Matt", buddyrepo.findByID(1).getName());
        assertEquals("Kevin", buddyrepo.findByID(2).getName());
    }
}