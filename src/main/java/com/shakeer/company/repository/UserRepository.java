package com.shakeer.company.repository;

import com.shakeer.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByOrderByUserNameAsc();
    List<User> findAllByOrderByUserIdAsc();
}
