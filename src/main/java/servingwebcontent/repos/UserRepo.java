package servingwebcontent.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import servingwebcontent.db.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
