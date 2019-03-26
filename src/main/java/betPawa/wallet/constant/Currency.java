package betPawa.wallet.constant;

public enum Currency {

    EUR,
    USD,
    GBP;

    Currency() {
    }

    public static boolean contains(String test) {

        for (Currency c : Currency.values()) {
            if (c.toString().equals(test)) {
                return true;
            }
        }

        return false;
    }

}
