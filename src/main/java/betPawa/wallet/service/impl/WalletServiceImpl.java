package betPawa.wallet.service.impl;

import betPawa.wallet.constant.Currency;
import betPawa.wallet.controller.UserController;
import betPawa.wallet.exception.CurrencyNotFoundException;
import betPawa.wallet.exception.InsufficientFundsException;
import betPawa.wallet.model.Funds;
import betPawa.wallet.repository.FundsRepository;
import betPawa.wallet.repository.UserRepository;
import betPawa.wallet.response.SuccessResponse;
import betPawa.wallet.service.WalletService;
import betPawa.wallet.user.DepositRequest;
import betPawa.wallet.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FundsRepository fundsRepository;

    @Override
    public void depositService(DepositRequest request) {
        LOGGER.info("depositService started");
        if(!Currency.contains(request.getCurrency())) {
            throw new CurrencyNotFoundException("Unknown Currency.");
        }
        User user = userRepository.getOne(request.getUserId());
        Optional<Funds> fundsOptional = fundsRepository.findByCurrencyAndWalletId(Currency.valueOf(request.getCurrency()), user.getUserWallet().getId());
        boolean isCurrencyPresent = fundsOptional.isPresent();
        if(isCurrencyPresent) {
            Funds newFunds = fundsOptional.get();
            newFunds.setAmount(newFunds.getAmount() + request.getAmount());
            fundsRepository.save(newFunds);
        }
        LOGGER.info("depositService completed");
    }

    @Override
    public SuccessResponse withdrawlService(DepositRequest request) {
        LOGGER.info("withdrawlService started");
        SuccessResponse successResponse = new SuccessResponse();
        if(!Currency.contains(request.getCurrency())) {
            throw new CurrencyNotFoundException("Unknown Currency.");
        }
        User user = userRepository.getOne(request.getUserId());
        Optional<Funds> fundsOptional = fundsRepository.findByCurrencyAndWalletId(Currency.valueOf(request.getCurrency()), user.getUserWallet().getId());
        boolean isCurrencyPresent = fundsOptional.isPresent();
        if(isCurrencyPresent) {
            Funds newFunds = fundsOptional.get();
            if(request.getAmount() < newFunds.getAmount() || request.getAmount().equals(newFunds.getAmount())) {
                Double newAmt = newFunds.getAmount() - request.getAmount();
                newFunds.setAmount(newAmt);
                fundsRepository.save(newFunds);
                successResponse.setMessage("Ok");
            } else {
                throw new InsufficientFundsException("Insufficient funds");
            }
        }
        LOGGER.info("withdrawlService completed");
        return successResponse ;
    }

    @Override
    public List<Funds> balanceService(Long userId) {
        LOGGER.info("balanceService started");
        User user = userRepository.getOne(userId);
        LOGGER.info("fetching Wallet for userID: " + user.getId());

        LOGGER.info("balanceService completed");
        return fundsRepository.findByWalletId(user.getUserWallet().getId());
    }
}
