package com.example.MyPrdemo.service;

import com.example.MyPrdemo.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    Friend findById(long id);
    List<Friend> findAll();
     Friend deleteById(long id);
     Friend save(Friend friend);
     long count();
}
