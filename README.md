# betPawa Wallet

This consists of a wallet server and a wallet client. The wallet server will keeps track
of a users monetary balance in the system. The client emulates users depositing and
withdrawing funds.

## Run Wallet Server :

Steps to run Wallet Server on your local machine.
(*Make sure you have MySQL installed on your system.*)

1. Create a database in MySQL with name betPawa
2. Make following changes in application.properties
    spring.datasource.username={Your MySQL user}
    spring.datasource.password={Your MySQL Password}

## Wallet Server API :

### Deposit API - 

/betpawa/wallet/deposit?userId=1&amount=100&currency=USD

### Withdraw API - 

/betpawa/wallet/withdraw?userId=1&amount=100&currency=USD

### Balance API - 

/betpawa/wallet/balance?userId=1
