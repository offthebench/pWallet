package betPawa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Client {

    private static Logger LOGGER = LoggerFactory.getLogger(Client.class.getName());

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting Client Emulator..");
        System.out.println(".");
        Thread.sleep(500);
        System.out.println("..");
        Thread.sleep(500);
        System.out.println("...");
        Thread.sleep(500);
        System.out.println(".....");
        Thread.sleep(500);

        System.out.println("Enter the total number of users to emulate : ");
        int users = scanner.nextInt();

        System.out.println("Enter the total number of requests per user : ");
        int userThreads = scanner.nextInt();

        System.out.println("Enter number of rounds each thread is executing : ");
        int roundsPerThreads = scanner.nextInt();

        ClientExecutorService executorService = new ClientExecutorService(users, userThreads, roundsPerThreads);
        try {
            LOGGER.debug("ClientExecutorService started");
            executorService.startClient();
        } catch (Exception e) {
            LOGGER.error("Client Emulator interrupted with exception", e.getMessage());
            e.printStackTrace();
        }
    }
}
