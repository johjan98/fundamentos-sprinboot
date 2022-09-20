package com.fundamentos.springboot.fundamentos.controller;

import com.fundamentos.springboot.fundamentos.caseuse.CreateUser;
import com.fundamentos.springboot.fundamentos.caseuse.DeleteUser;
import com.fundamentos.springboot.fundamentos.caseuse.GetUser;
import com.fundamentos.springboot.fundamentos.caseuse.UpdateUser;
import com.fundamentos.springboot.fundamentos.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
  private final GetUser getUser;
  private final CreateUser createUser;
  private final DeleteUser deleteUser;
  private final UpdateUser updateUser;

  public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser) {
    this.getUser = getUser;
    this.createUser = createUser;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
  }

  @GetMapping("/")
  List<User> get(){
    return getUser.getAll();
  }

  @PostMapping("/")
  ResponseEntity<User> newUser(@RequestBody User newUser){
    return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<HttpStatus> deleteUser (@PathVariable Long id){
    deleteUser.remove(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  ResponseEntity<User> replaceUser(@RequestBody User user, @PathVariable Long id){
    return new ResponseEntity<>(updateUser.update(user, id), HttpStatus.OK);
  }
}
