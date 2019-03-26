package betPawa.wallet.repository;

import betPawa.wallet.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
