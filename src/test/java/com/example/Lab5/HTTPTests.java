package com.example.Lab5;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HTTPTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Test
    public void createAddressBookTest(){
        ResponseEntity<AddressBook> response = restTemplate.getForEntity("/createAddressBook?id=1", AddressBook.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getID());
    }

    @Test
    public void getAddressBookTest(){
        AddressBook a = new AddressBook();
        a.setID(1);
        addressBookRepository.save(a);

        ResponseEntity<AddressBook> response = restTemplate.getForEntity("/getAddressBook?id=1", AddressBook.class);
        AddressBook addressBook = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(addressBook);
        assertEquals(1, addressBook.getID());
    }

    @Test
    public void addBuddyTest(){
        AddressBook a = new AddressBook();
        a.setID(1);
        addressBookRepository.save(a);

        ResponseEntity<AddressBook> response = restTemplate.getForEntity("/addBuddy?addressId=1&buddyId=1&name=Matt&phoneNum=7777", AddressBook.class);
        AddressBook addressBook = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(addressBook);
        assertEquals(1, addressBook.getID());
        assertEquals(1, addressBook.getBuddyInfo(0).getID());
        assertEquals("Matt", addressBook.getBuddyInfo(0).getName());
        assertEquals("7777", addressBook.getBuddyInfo(0).getPhoneNumber());
    }

    @Test
    public void removeBuddyTest(){
        AddressBook a = new AddressBook();
        a.setID(1);
        addressBookRepository.save(a);

        ResponseEntity<AddressBook> response = restTemplate.getForEntity("/addBuddy?addressId=1&buddyId=1&name=Matt&phoneNum=7777", AddressBook.class);
        AddressBook addressBook = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(addressBook);
        assertEquals(1, addressBook.getID());
        assertEquals(1, addressBook.getBuddyInfo(0).getID());
        assertEquals("Matt", addressBook.getBuddyInfo(0).getName());
        assertEquals("7777", addressBook.getBuddyInfo(0).getPhoneNumber());
    }






}
