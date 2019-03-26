package betPawa;


public class ClientRunnable implements Runnable {

    private final int id;
    private final int userThreads;
    private final int roundsPerThreads;

    ClientRunnable(int id, int userThreads, int roundsPerThreads) {
        this.id = id;
        this.userThreads = userThreads;
        this.roundsPerThreads = roundsPerThreads;
    }

    @Override
    public void run() {
        RoundExecutorService service = new RoundExecutorService(roundsPerThreads);
        try {
            for (int i = 0; i < userThreads; i++) {
                service.execute(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
