package com.example.lab4;

import org.springframework.data.repository.CrudRepository;
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer>{
    BuddyInfo findByID(int id);

}
