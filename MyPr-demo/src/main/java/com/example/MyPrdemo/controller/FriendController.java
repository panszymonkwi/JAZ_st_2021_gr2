package com.example.MyPrdemo.controller;

import com.example.MyPrdemo.Friend;
import com.example.MyPrdemo.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FriendController {
    FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }
    //   public Friend get(@PathVariable String id) {return friendService.getFriendFromRepo(id);}

    @GetMapping("friend/{id}")
    public ResponseEntity<Friend> getFriend(@PathVariable long id) {
        Friend friend = friendService.getFriendFromRepo(id);

        return new ResponseEntity<>(friend, HttpStatus.OK);
    }

    @PostMapping("friend/add")
    public ResponseEntity<Long> createFriend(@RequestBody Friend friend) {
        long createId = friendService.insertFriendIntoRepo(friend);
     return new ResponseEntity<>(createId, HttpStatus.CREATED);
    }
    @DeleteMapping("friend/del")
    public ResponseEntity<Long> deleteFriend(@RequestBody Friend friend) {
        long deleteId = friendService.removeFriendFromRepo(friend.getId());
        return new ResponseEntity<>(deleteId, HttpStatus.OK);
    }
}
