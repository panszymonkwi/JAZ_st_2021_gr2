package com.example.MyPrdemo.controller;

import com.example.MyPrdemo.Friend;
import com.example.MyPrdemo.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class FriendsController {
    FriendService friendService;

    @Autowired
    public FriendsController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("friends")
    public String showFriends(Model model) {
      model.addAttribute("friends", friendService.getFriendFromRepo());
      return "friend";
    }
    @GetMapping("friends/add")
    public String showFriendsAddForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "addForm";
    }
    @PostMapping("friends/add")
    public String submitFriendAddForm (@ModelAttribute Friend friend, Model model) {
        friendService.insertFriendIntoRepo(friend);
        model.addAttribute( "friend", new Friend());
        return "addForm";
    }
      @GetMapping("friends/del")
      public String deleteFriends( @ModelAttribute Friend friend,Model model) {
          model.addAttribute( "friend", new Friend());
          showFriendsAddForm(model);
          model.addAttribute("friend", friendService.getFriendFromRepo(friend.getId()));
          showFriends(model);
        friendService.removeFriendFromRepo(friend.getId());
        model.addAttribute( "friend", new Friend());
        return "addForm";
    }
     /*   @DeleteMapping("friend/del")
        public String submitFriendDelForm (@ModelAttribute Friend friend, Model model) {
            friendService.removeFriendFromRepo(friend.getId());
            model.addAttribute( "friend", new Friend());
            return "addForm";
        }*/
  }


