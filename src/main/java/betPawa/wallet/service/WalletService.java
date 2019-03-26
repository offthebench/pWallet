package betPawa.wallet.service;

import betPawa.wallet.model.Funds;
import betPawa.wallet.response.SuccessResponse;
import betPawa.wallet.user.DepositRequest;

import java.util.List;

public interface WalletService {

    void depositService(DepositRequest request);

    SuccessResponse withdrawlService(DepositRequest request);

    List<Funds> balanceService(Long userId);
}
