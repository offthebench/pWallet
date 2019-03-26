package betPawa.wallet.repository;

import betPawa.wallet.model.Wallet;
import betPawa.wallet.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
