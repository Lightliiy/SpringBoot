package com.example.MyApp.Services;

import com.example.MyApp.Model.User;
import com.example.MyApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void updateUserPassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.save(user);
    }
}









//package com.example.MyApp.Services;
//
//import com.example.MyApp.Repository.UserRepo;
//import com.example.MyApp.Model.User;
//import com.example.MyApp.Repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserServices {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    public User findByUsername(String email) {
//        return userRepo.findByEmail(email);
//    }
//
//    public User findByRole(String role) {
//        return userRepo.findByRole(role);
//    }
//
//    public void saveUser(User user) {
//        userRepo.save(user);
//    }
//
////    public void hashPassword(String password) {
////        return BCrypt.hashpw(password, BCrypt.gensalt());
////    }
////
////    public boolean checkPassword(String plaintextPassword, String hashedPassword) {
////        return  BCrypt.checkpw(plaintextPassword, hashedPassword);
////    }
//
//}
////    @Autowired
////    private UserRepo userRepo;
////
////    public User postUser(User user){
////        return userRepo.save(user);
////    }
////    public List<User> userList(){
////        return userRepo.findAll();
////    }
////    public Optional<User> findByUserId(Integer id){
////        return userRepo.findById(id);
////    }
////    public User updateUser(User user) {
////        User user1 =userRepo.findById(user.getId())
////                .orElseThrow(() -> new RuntimeException("User not found"));
////        user1.setUserName(user.getUserName());
////        user1.setLastName(user.getLastName());
////        user1.setFirstName(user.getFirstName());
////        user1.setPassword(user.getPassword());
////        user1.setEmail(user.getEmail());
////        return userRepo.save(user);
////    }
////    public void deleteUser(int id){
////        userRepo.deleteById(id);
////    }
//
//
