package com.dharmendra.userManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
@Autowired
List<UserDetails> userList;

    // Adding User
@PostMapping("addUser")
public String addingUser(@RequestBody UserDetails input){
    userList.add(input);
    return "Details added";
    }

    // Getting User by userId
    @GetMapping("user/{userid}")
    public UserDetails details(@PathVariable Integer userid) {
        for (UserDetails U : userList) {

            if (U.getUserId().equals(userid)) {
                return U;
            }
        }
        return null;
    }

    // Get All Users
    @GetMapping("allUsers")
    public List<UserDetails> allUsers(){

    return userList;
    }

    // Updating User Info by userId
    @PutMapping("updateUser/{userId}/details")
 public String updateInfo(@PathVariable Integer userId, @RequestBody UserDetails update){

    for(int i = 0; i < userList.size(); i++){
        UserDetails U = userList.get(i);
        Integer id = U.getUserId();
        if(id == (userId)){
         U.setAddress(update.getAddress());
         U.setUserName(update.getUserName());
         U.setName(update.getName());
         U.setPhoneNumber(update.getPhoneNumber());
         U.setUserId(update.getUserId());
            return userId + " details updated";
        }
    }
   return "Invalid userId";
 }

 // Delete User by userId
@DeleteMapping("deleteUser/{userId}")
    public String deleteUser(@PathVariable Integer userId){

    for(UserDetails U : userList){
       if(U.getUserId().equals(userId)){
           userList.remove(U);
           return "user "+ userId + " deleted successfully";
       }
    }
    return "Invalid UserId";
    }

}
