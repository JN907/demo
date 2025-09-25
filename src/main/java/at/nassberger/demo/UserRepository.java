package at.nassberger.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // findAll() ist bereits von JpaRepository enthalten
    User findByUsername(String username);
}