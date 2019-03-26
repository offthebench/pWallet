package betPawa.wallet.controller;

import betPawa.wallet.model.Funds;
import betPawa.wallet.response.SuccessResponse;
import betPawa.wallet.service.WalletService;
import betPawa.wallet.user.DepositRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("betpawa/wallet")
public class WalletController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletController.class);

    @Autowired
    WalletService walletService;


    @GetMapping("/deposit")
    public void depositUserWallet(@RequestParam Long userId, @RequestParam Double amount, @RequestParam String currency) {

        LOGGER.info("/deposit API executing...");

        DepositRequest request = new DepositRequest(userId, amount, currency);
        try
        {
            walletService.depositService(request);
        } catch (Exception e) {
            LOGGER.error("/deposit interrupted with error", e);
            throw e;
        }
        LOGGER.info("/deposit API executed.");

    }

    @PostMapping("/deposit")
    public void depositUserWallet(@RequestBody DepositRequest request) {

        LOGGER.info("/deposit API executing...");

        try
        {
            walletService.depositService(request);
        } catch (Exception e) {
            LOGGER.error("/deposit interrupted with error", e);
            throw e;
        }
        LOGGER.info("/deposit API executed.");
    }

    @GetMapping("/withdraw")
    public SuccessResponse withdrawUserWallet(@RequestParam Long userId, @RequestParam Double amount, @RequestParam String currency) {

        LOGGER.info("/withdraw API executing...");

        DepositRequest request = new DepositRequest(userId, amount, currency);
        return walletService.withdrawlService(request);
    }

    @PostMapping("/withdraw")
    public SuccessResponse withdrawUserWallet(@RequestBody DepositRequest request) {

        LOGGER.info("/withdraw API executing...");

        return walletService.withdrawlService(request);
    }

    @GetMapping("/balance")
    public List<Funds> getFundsByUserId(@RequestParam(name = "userId") Long userId) {

        LOGGER.info("/balance API executing...");

        return walletService.balanceService(userId);
    }
}
