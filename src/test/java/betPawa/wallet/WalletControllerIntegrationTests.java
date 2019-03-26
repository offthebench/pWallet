package betPawa.wallet;

import betPawa.wallet.user.DepositRequest;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WalletControllerIntegrationTests {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testCase1() throws JSONException {

        DepositRequest depositRequest = new DepositRequest(1L, 200.00, "USD");

        HttpEntity<DepositRequest> entity = new HttpEntity<DepositRequest>(depositRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/withdraw"),
                HttpMethod.POST, entity, String.class);

        String expected = "{\n" +
                "  \"message\": \"Insufficient funds\"\n" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testCase2() throws JSONException {

        DepositRequest depositRequest = new DepositRequest(1L, 100.00, "USD");

        HttpEntity<DepositRequest> entity = new HttpEntity<DepositRequest>(depositRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/deposit"),
                HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.CONTENT_LENGTH).get(0);

        assertTrue(actual.contains("0"));
    }

    @Test
    public void testCase3() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/balance?userId=1"),
                HttpMethod.GET, entity, String.class);

        String expected = "[\n" +
                "  {\n" +
                "    \"amount\": 0,\n" +
                "    \"currency\": \"GBP\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"amount\": 0,\n" +
                "    \"currency\": \"EUR\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"amount\": 100,\n" +
                "    \"currency\": \"USD\"\n" +
                "  }\n" +
                "]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testCase4() throws JSONException {

        DepositRequest depositRequest = new DepositRequest(1L, 200.00, "USD");

        HttpEntity<DepositRequest> entity = new HttpEntity<DepositRequest>(depositRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/withdraw"),
                HttpMethod.POST, entity, String.class);

        String expected = "{\n" +
                "  \"message\": \"Insufficient funds\"\n" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testCase5() throws JSONException {

        DepositRequest depositRequest = new DepositRequest(1L, 100.00, "EUR");

        HttpEntity<DepositRequest> entity = new HttpEntity<DepositRequest>(depositRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/deposit"),
                HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.CONTENT_LENGTH).get(0);

        assertTrue(actual.contains("0"));
    }

    @Test
    public void testCase6() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/balance?userId=1"),
                HttpMethod.GET, entity, String.class);

        String expected = "[\n" +
                "  {\n" +
                "    \"amount\": 0,\n" +
                "    \"currency\": \"GBP\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"amount\": 100,\n" +
                "    \"currency\": \"EUR\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"amount\": 100,\n" +
                "    \"currency\": \"USD\"\n" +
                "  }\n" +
                "]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testCase7() throws JSONException {

        DepositRequest depositRequest = new DepositRequest(1L, 200.00, "USD");

        HttpEntity<DepositRequest> entity = new HttpEntity<DepositRequest>(depositRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/withdraw"),
                HttpMethod.POST, entity, String.class);

        String expected = "{\n" +
                "  \"message\": \"Insufficient funds\"\n" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testCase8() throws JSONException {

        DepositRequest depositRequest = new DepositRequest(1L, 100.00, "USD");

        HttpEntity<DepositRequest> entity = new HttpEntity<DepositRequest>(depositRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/deposit"),
                HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.CONTENT_LENGTH).get(0);

        assertTrue(actual.contains("0"));
    }

    @Test
    public void testCase9() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/balance?userId=1"),
                HttpMethod.GET, entity, String.class);

        String expected = "[{\"amount\":0.0,\"currency\":\"GBP\"},{\"amount\":100.0,\"currency\":\"EUR\"},{\"amount\":200.0,\"currency\":\"USD\"}]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testCase10() throws JSONException {

        DepositRequest depositRequest = new DepositRequest(1L, 200.00, "USD");

        HttpEntity<DepositRequest> entity = new HttpEntity<DepositRequest>(depositRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/withdraw"),
                HttpMethod.POST, entity, String.class);

        String expected = "{\n" +
                "  \"message\": \"Ok\"\n" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testCase11() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/balance?userId=1"),
                HttpMethod.GET, entity, String.class);

        String expected = "[\n" +
                "  {\n" +
                "    \"amount\": 0,\n" +
                "    \"currency\": \"GBP\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"amount\": 100,\n" +
                "    \"currency\": \"EUR\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"amount\": 0,\n" +
                "    \"currency\": \"USD\"\n" +
                "  }\n" +
                "]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testCase12() throws JSONException {

        DepositRequest depositRequest = new DepositRequest(1L, 200.00, "USD");

        HttpEntity<DepositRequest> entity = new HttpEntity<DepositRequest>(depositRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/betpawa/wallet/withdraw"),
                HttpMethod.POST, entity, String.class);

        String expected = "{\n" +
                "  \"message\": \"Insufficient funds\"\n" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

//    @Test
//    public void ResetTests() throws JSONException {
//
//        DepositRequest depositRequest = new DepositRequest(1L, 100.00, "EUR");
//
//        HttpEntity<DepositRequest> entity = new HttpEntity<DepositRequest>(depositRequest, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/betpawa/wallet/withdraw"),
//                HttpMethod.POST, entity, String.class);
//
//        String expected = "{\n" +
//                "  \"message\": \"Ok\"\n" +
//                "}";
//
//        JSONAssert.assertEquals(expected, response.getBody(), false);
//    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
