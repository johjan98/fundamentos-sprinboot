package com.fundamentos.springboot.fundamentos.repository;

import com.fundamentos.springboot.fundamentos.dto.UserDto;
import com.fundamentos.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
  List<User> findByNameLike(String name);
  List<User> findByNameOrEmail(String name, String email);
  List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);
  List<User> findByNameLikeOrderByIdDesc(String name);
  List<User> findByNameContainingOrderByIdAsc(String name);
  @Query("SELECT new com.fundamentos.springboot.fundamentos.dto.UserDto(u.id, u.name, u.birthDate)"
          + " FROM User u"
          + " WHERE u.birthDate=:parametroFecha "
          + " AND u.email=:parametroEmail")
  Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date, @Param("parametroEmail") String email);
}
