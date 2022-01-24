package com.example.MyPrdemo.Mapper;

import com.example.MyPrdemo.Friend;
import org.springframework.jdbc.core.RowMapper;;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendMapper implements RowMapper<Friend> {
    @Override
    public Friend mapRow(ResultSet rs, int rowNum) throws SQLException {
        Friend friend = new Friend();
        friend.setId(rs.getLong("ID"));
        friend.setName(rs.getString("Name"));
        friend.setSurname(rs.getString("Surname"));
        friend.setCity(rs.getString("City"));
        friend.setPhone(rs.getString("Phone"));
        friend.setMail(rs.getString("Mail"));
        return friend;
    }
}
