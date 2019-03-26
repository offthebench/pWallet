package betPawa.wallet.repository;

import betPawa.wallet.constant.Currency;
import betPawa.wallet.model.Funds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FundsRepository extends JpaRepository<Funds, Long> {

    List<Funds> findByWalletId(Long walletId);
    Optional<Funds> findByCurrencyAndWalletId(Currency currency, Long walletId);

}
