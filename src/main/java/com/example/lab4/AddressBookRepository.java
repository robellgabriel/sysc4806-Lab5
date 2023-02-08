package com.example.lab4;

import org.springframework.data.repository.CrudRepository;
public interface AddressBookRepository extends CrudRepository<AddressBook, Integer> {
    AddressBook findByID(int id);

}
