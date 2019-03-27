package betPawa.wallet.controller;

import betPawa.wallet.constant.Currency;
import betPawa.wallet.model.Funds;
import betPawa.wallet.model.Wallet;
import betPawa.wallet.repository.FundsRepository;
import betPawa.wallet.repository.UserRepository;
import betPawa.wallet.service.UserService;
import betPawa.wallet.user.DepositRequest;
import betPawa.wallet.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FundsRepository fundsRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user")
    public User createUser(@RequestParam String name) {
        LOGGER.info("/user API executing...");
        User user = new User(name);
        return userService.createUser(user);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        LOGGER.info("/user API executing...");
        return userService.createUser(user);
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }
}
