package betPawa;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoundExecutorService {

    private final int THREADS = 10;

    private String[] roundA = { "http://localhost:8080/betpawa/wallet/deposit?userId=1&amount=100&currency=USD",
            "http://localhost:8080/betpawa/wallet/withdraw?userId=1&amount=200&currency=USD",
            "http://localhost:8080/betpawa/wallet/deposit?userId=1&amount=100&currency=EUR",
            "http://localhost:8080/betpawa/wallet/balance?userId=1",
            "http://localhost:8080/betpawa/wallet/withdraw?userId=1&amount=100&currency=USD",
            "http://localhost:8080/betpawa/wallet/balance?userId=1",
            "http://localhost:8080/betpawa/wallet/withdraw?userId=1&amount=100&currency=USD" };

    private String[] roundB = { "http://localhost:8080/betpawa/wallet/withdraw?userId=1&amount=100&currency=GBP",
            "http://localhost:8080/betpawa/wallet/deposit?userId=1&amount=300&currency=GBP",
            "http://localhost:8080/betpawa/wallet/withdraw?userId=1&amount=100&currency=GBP",
            "http://localhost:8080/betpawa/wallet/withdraw?userId=1&amount=100&currency=GBP",
            "http://localhost:8080/betpawa/wallet/withdraw?userId=1&amount=100&currency=GBP" };

    private String[] roundC = { "http://localhost:8080/betpawa/wallet/balance?userId=1",
            "http://localhost:8080/betpawa/wallet/deposit?userId=1&amount=100&currency=USD",
            "http://localhost:8080/betpawa/wallet/deposit?userId=1&amount=100&currency=USD",
            "http://localhost:8080/betpawa/wallet/withdraw?userId=1&amount=100&currency=USD",
            "http://localhost:8080/betpawa/wallet/deposit?userId=1&amount=100&currency=USD",
            "http://localhost:8080/betpawa/wallet/balance?userId=1",
            "http://localhost:8080/betpawa/wallet/withdraw?userId=1&amount=100&currency=USD",
            "http://localhost:8080/betpawa/wallet/balance?userId=1" };

    private int t;

    RoundExecutorService(int t) {
        this.t = t;
    }

    public void execute(int id) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        for (int j = 0; j < t; j++) {
            String[] currentRound = getRandomRound();
            for (String aCurrentRound : currentRound) {

                String url = aCurrentRound;
                url = url.replace("userId=1", "userId=" + id);
                Runnable worker = new RoundRunnable(url);
                executor.execute(worker);
            }
        }
        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()) {

        }
        System.out.println("\nFinished all threads");
    }

    private String[] getRandomRound() {
        Random r = new Random();

        int i = r.nextInt()%3;

        System.out.println(i);

        switch (i) {
            case 0:
                System.out.println("\nExecuting Round A");
                return roundA;
            case 1:
                System.out.println("\nExecuting Round B");
                return roundB;
            case 2:
                System.out.println("\nExecuting Round C");
                return roundC;
            default:
                break;
        }
        return getRandomRound();
    }
}
