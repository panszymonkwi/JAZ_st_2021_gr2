package com.example.MyPrdemo.service;

import com.example.MyPrdemo.Friend;
import com.example.MyPrdemo.exception.ExceptionFriendNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FriendService {
    FriendRepository friendRepository;

    @Autowired
    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
        friendRepository.save(new Friend(1, "Robert", "Wysoki", "Gdansk", "33344455", "@6666"));
        friendRepository.save(new Friend(2, "Olaf", "Gryka", "Gdynia", "44335566", "@yyyy"));
        friendRepository.save(new Friend(3, "Ewa", "Skiba", "Olsztyn", "876567", "@hhhiii"));
        friendRepository.save(new Friend(4, "Adam", "Nowak", "Sopot", "123456", "@1234"));
    }

    public Friend getFriendFromRepo(long id) {
        Friend friend = friendRepository.findById(id);
     //   if (friend == null) {
        //    throw new ExceptionFriendNotFound();
     //   }
        return friend;

    }

    public List<Friend> getFriendFromRepo() {
        return friendRepository.findAll();
    }

    public long insertFriendIntoRepo(Friend friend) {
        if (friendRepository.existsById(friend.getId())) {
            return 0;
        }
        return friendRepository.save(friend).getId();
    }

    public long updateFriendInRepo(Friend friend) {
        Friend friendRepo = friendRepository.findById(friend.getId());
        if (friendRepo != null) {
            friendRepo.setName(friend.getName());
            friendRepo.setSurname(friend.getSurname());
            friendRepo.setCity(friend.getCity());
            friendRepo.setPhone(friend.getPhone());
            friendRepo.setMail(friend.getMail());
            return friendRepository.save(friendRepo).getId();
           } else {  return 0;}
        }


    public long removeFriendFromRepo(long id) {
        if (friendRepository.existsById(id) ) {
            friendRepository.deleteById(id);
            return id;
         } else {
            return 0;
        }
    }
}