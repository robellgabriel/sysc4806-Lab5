package com.example.Lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookControllerTL {
    @Autowired
    private AddressBookRepository addressBookRepository;

    public AddressBookControllerTL(AddressBookRepository addressBookRepository){
        this.addressBookRepository = addressBookRepository;
    }

    @RequestMapping("/viewAddressBook")
    public String viewAddressBook(@RequestParam("id") int id, Model model){
        AddressBook addressBook = addressBookRepository.findByID(id);
        model.addAttribute("addressBook", addressBook);
        return "index";
    }
}
