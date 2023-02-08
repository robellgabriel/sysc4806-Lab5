package com.example.Lab5;

import org.springframework.data.repository.CrudRepository;
public interface AddressBookRepository extends CrudRepository<AddressBook, Integer> {
    AddressBook findByID(int id);

}
