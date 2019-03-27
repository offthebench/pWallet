package betPawa.wallet.service.impl;

import betPawa.wallet.constant.Currency;
import betPawa.wallet.model.Funds;
import betPawa.wallet.model.Wallet;
import betPawa.wallet.repository.UserRepository;
import betPawa.wallet.service.UserService;
import betPawa.wallet.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {

        LOGGER.info("Initialising empty wallet for the user..");

        initializeWallet(user);

        LOGGER.info("Creating user.");

        return userRepository.save(user);
    }

    private void initializeWallet(User user) {
        Wallet wallet = new Wallet();
        user.setUserWallet(wallet);
        wallet.setUser(user);

        LOGGER.info("Initialising available currencies..");

        Funds EURFunds = new Funds();
        EURFunds.setAmount(0.00);
        EURFunds.setCurrency(Currency.EUR);
        EURFunds.setWallet(wallet);

        Funds USDFunds = new Funds();
        USDFunds.setAmount(0.00);
        USDFunds.setCurrency(Currency.USD);
        USDFunds.setWallet(wallet);

        Funds GBPFunds = new Funds();
        GBPFunds.setAmount(0.00);
        GBPFunds.setCurrency(Currency.GBP);
        GBPFunds.setWallet(wallet);

        wallet.getFunds().add(EURFunds);
        wallet.getFunds().add(USDFunds);
        wallet.getFunds().add(GBPFunds);

        LOGGER.info("Initialised empty wallet for the user.");
    }

}
