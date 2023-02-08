package com.example.Lab5;

import org.springframework.data.repository.CrudRepository;
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer>{
    BuddyInfo findByID(int id);

}
