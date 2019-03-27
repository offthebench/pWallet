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
3. Navigate to bPwallet folder and run ./gradlew bootRun(mac/linux) or gradlew.bat bootRun(Windows)
4. Create 1st user with endpoint.
    http://localhost:8080/user?name=AnyUsername
5. The Server is up and running.


## Run Integration Tests :

Once you have started the server and created a user, you can run the integration test.

1. Navigate to bPwallet folder and run ./gradlew integrationTest(mac/linux) and gradlew.bat integrationTest(Windows)
2. After the test is executed, report will be generated.
Go to bPwallet/build/reports/tests/integrationTest/index.html to see results.


## Run Client :

Once you have started the server, start a new terminal/cmd and navigate to bWallet folder.

Run ./gradlew startClient(mac/linux) and gradlew.bat startClient(windows)

Follow the on-screen instructions.


## Wallet Server API :

### Deposit API - 

/betpawa/wallet/deposit?userId=1&amount=100&currency=USD

### Withdraw API - 

/betpawa/wallet/withdraw?userId=1&amount=100&currency=USD

### Balance API - 

/betpawa/wallet/balance?userId=1

#*Server starts up at port 8080*#
