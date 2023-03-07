package resources;

import java.util.List;

public class ExpectReceipt {
    public String buildExpectReceipt(List<String> testIngrs, float price) {
        StringBuilder expectReceipt = new StringBuilder(String.format("(==== %s ====)%n", testIngrs.get(0)));
        expectReceipt.append(String.format("= %s %s =%n", "sauce",
                testIngrs.get(1)));
        expectReceipt.append(String.format("(==== %s ====)%n", testIngrs.get(0)));
        expectReceipt.append(String.format("%nPrice: %f%n", (price * 4)));
        return expectReceipt.toString();
    }
}
