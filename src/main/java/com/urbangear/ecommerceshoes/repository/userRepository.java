// com/urbangear/ecommerceshoes/repository/UserRepository.java

package com.urbangear.ecommerceshoes.repository;

import com.urbangear.ecommerceshoes.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<user, Long> {

    Optional<user> findByUsernameAndPassword(String username, String password);
}
