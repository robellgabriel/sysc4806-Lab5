package com.example.Lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddressBookControllerTL {
    @Autowired
    private AddressBookRepository addressBookRepository;

    public AddressBookControllerTL(AddressBookRepository addressBookRepository){
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addAddressBook")
    public String viewAddressBook(){
        return "addAddressBook";
    }

    @PostMapping("/viewAddressBook")
    public String buildAddressBook(@RequestParam("id") int id, Model model){
        AddressBook addressBook = new AddressBook();
        addressBook.setID(id);
        addressBookRepository.save(addressBook);
        List<AddressBook> listAB = (List<AddressBook>) addressBookRepository.findAll();
        model.addAttribute("listAB", listAB);
        return "viewAddressBook";
    }

    @GetMapping("/addBuddyInfoView")
    public String viewBuddyInfo(){
        return "addBuddy";
    }

    @PostMapping("/viewBuddyInfo")
    public String addBuddyInfoView(@RequestParam("addressId") int addressId,
                               @RequestParam("buddyId") int buddyId,
                               @RequestParam("name") String name,
                               @RequestParam("phoneNum") String phoneNum,
                                   Model model){
        BuddyInfo buddyInfo = new BuddyInfo();
        buddyInfo.setID(buddyId);
        buddyInfo.setName(name);
        buddyInfo.setPhoneNumber(phoneNum);
        AddressBook addressBook = addressBookRepository.findByID(addressId);
        addressBook.addBuddy(buddyInfo);
        addressBookRepository.save(addressBook);
        model.addAttribute("addressBook", addressBook);
        return "viewBuddyInfo";
    }


}
