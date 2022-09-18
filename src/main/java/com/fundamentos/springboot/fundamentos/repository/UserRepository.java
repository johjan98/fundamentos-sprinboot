package com.fundamentos.springboot.fundamentos.repository;

import com.fundamentos.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { //User: Entidad que se quiere mapear, Long: Tipo del Id de la entudad
  @Query(value = "SELECT * FROM users u WHERE u.email=?1", nativeQuery = true)
  Optional<User>  findByUserEmail(String email);

  @Query("SELECT u FROM User u WHERE u.name like ?1%")
  List<User> findAndSort(String name, Sort sort);

  List<User> findByName(String name);

  Optional<User> findByEmailAndName(String email, String name);
}
