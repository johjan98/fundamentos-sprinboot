package com.fundamentos.springboot.fundamentos.service;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  private final Log logger = LogFactory.getLog(UserService.class);
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public void saveTransactional(List<User> users) {
    users.forEach(userRepository::save);
  }

  public List<User> getAllUsers(){
    return userRepository.findAll();
  }

  public User save(User newUser) {
    return userRepository.save(newUser);
  }

  public void delete(Long id){
    userRepository.delete(new User(id));
  }

  public User update(User newUser, Long id) {
    Optional<User> opt = userRepository.findById(id)
            .map(
                    user -> {
                      user.setEmail(newUser.getEmail());
                      user.setBirthDate(newUser.getBirthDate());
                      user.setName(newUser.getName());
                      return userRepository.save(user);
                    }
            );
    return opt.orElse(null);
  }
}
