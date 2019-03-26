package betPawa;

import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientExecutorService {

    private final int THREADS = 10;

    private final String REGISTER_USER_API = "http://localhost:8080/users/";

    private int users;
    private int userRequests;
    private int roundsPerRequest;

    public ClientExecutorService(int users, int userRequests, int roundsPerRequest) {
        this.users = users;
        this.userRequests = userRequests;
        this.roundsPerRequest = roundsPerRequest;
    }

    public void startClient() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        for (int i = 0; i < users; i++) {
            int id = registerUser();
            Runnable worker = new ClientRunnable(id, userRequests, roundsPerRequest);
            executor.execute(worker);
        }

        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()) {

        }
        System.out.println("\nFinished all Client threads");
    }

    private int registerUser() {

        int code = 1;
        try {
            URL siteURL = new URL(REGISTER_USER_API);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(3000);
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");
//            connection.connect();

            JsonObject payload = new JsonObject();
            payload.addProperty("name","adm");

            OutputStream os = connection.getOutputStream();
            os.write(payload.toString().getBytes("UTF-8"));
            os.close();

            InputStream in = new BufferedInputStream(connection.getInputStream());

            StringBuilder textBuilder = new StringBuilder();
            try (Reader reader = new BufferedReader(new InputStreamReader
                    (in, Charset.forName(StandardCharsets.UTF_8.name())))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    textBuilder.append((char) c);
                }
            }

            JSONObject jsonObject = new JSONObject(textBuilder.toString());


            in.close();
            connection.disconnect();

            code = Integer.parseInt(jsonObject.get("id").toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

}
