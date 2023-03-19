package resources;

import java.util.List;

public class ExpectReceipt {
    public String buildExpectReceipt(List<String> testIngrs, float price) {
        String expectReceipt = String.format("(==== %s ====)%n", testIngrs.get(0)) + String.format("= %s %s =%n", "sauce",
                testIngrs.get(1)) +
                String.format("(==== %s ====)%n", testIngrs.get(0)) +
                String.format("%nPrice: %f%n", (price * 4));
        return expectReceipt;
    }
}
