package com.example.product.repository;

import com.example.product.models.User;
import com.example.product.repository.results.UserResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select u.username, u.position, u.phone_number\n" +
            "from product_management.users u\n" +
            "where u.username = :username \n" +
            "and u.password = :password", nativeQuery = true)
    UserResult getUserByLogin(String username, String password);

    User findByUsername(String username);
}
