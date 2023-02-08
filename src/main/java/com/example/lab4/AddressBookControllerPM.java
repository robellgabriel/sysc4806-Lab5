package com.example.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookControllerPM {
    @Autowired
    private AddressBookRepository addressBookRepository;

    public AddressBookControllerPM(AddressBookRepository addressBookRepository){
        this.addressBookRepository = addressBookRepository;
    }

    @RequestMapping("/createAddressBook")
    public AddressBook createAddressBook(@RequestParam("id") int id){
        AddressBook addressBook = new AddressBook();
        addressBook.setID(id);
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @GetMapping("/getAddressBook")
    public AddressBook getAddressBook(@RequestParam("id") int id){
        return addressBookRepository.findByID(id);
    }

    @RequestMapping("/addBuddy")
    public AddressBook addBuddyInfo(@RequestParam("addressId") int addressId,
                                    @RequestParam("buddyId") int buddyId,
                                    @RequestParam("name") String name,
                                    @RequestParam("phoneNum") String phoneNum){
        BuddyInfo buddyInfo = new BuddyInfo();
        buddyInfo.setName(name);
        buddyInfo.setID(buddyId);
        buddyInfo.setPhoneNumber(phoneNum);
        AddressBook addressBook = addressBookRepository.findByID(addressId);
        addressBook.addBuddy(buddyInfo);
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @RequestMapping("/removeBuddy")
    public AddressBook removeBuddyInfo(@RequestParam("addressId") int addressId,
                                       @RequestParam("buddyId") int buddyId){
        AddressBook addressBook = addressBookRepository.findByID(addressId);
        addressBook.removeBuddy(buddyId);
        addressBookRepository.save(addressBook);
        return addressBook;
    }

}
