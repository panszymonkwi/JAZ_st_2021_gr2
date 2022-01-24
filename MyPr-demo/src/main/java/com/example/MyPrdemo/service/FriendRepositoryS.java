package com.example.MyPrdemo.service;

import com.example.MyPrdemo.Friend;
import com.example.MyPrdemo.Mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FriendRepositoryS {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public FriendRepositoryS(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Friend findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FOR FRIEND WHERE CITY = GDANSK", new FriendMapper(), id);
    }
    public long addFriend(long id, String name, String surname, String city, String phone, String mail) {
        return jdbcTemplate.update("INSERT INTO FRIEND VALUES (?,?,?,?,?,?)", id, name, surname, city, phone, mail);
    }
     public long delFriend(long id) {
            return jdbcTemplate.update("DELETE FROM FRIEND WHERE id= ?", id);
    }
}
