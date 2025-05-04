import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MainLVL {

    public static void main(String[] args) {
        int rarity = 4;
        double sellPrice = 0;
        double buyPrice = 0;
        Scanner reader = new Scanner(System.in);
        DecimalFormat f = new DecimalFormat("##,###,###");
        try {
            System.out.println("Is Pet a Golden Dragon? (Yes/No)");
            String gDrag = reader.next();
            if (!gDrag.equalsIgnoreCase("yes")) {
                System.out.println("Enter Rarity: ");
                for (int i = 0; i < Lvl.Rarity.values().length; i++) {
                    System.out.println(i + ": " + Lvl.Rarity.values()[i].toString());
                }
                rarity = reader.nextInt();
                if (rarity < 0 || rarity > 4)
                    throw new Exception("Rarity range between 0-4");
            }

            try {
                String[] carrotIds = {
                        "ULTIMATE_CARROT_CANDY"
                };

                URL url = new URL("https://api.hypixel.net/skyblock/bazaar");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                StringBuilder content = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    content.append(line);
                }

                in.close();
                conn.disconnect();

                String json = content.toString();
                JSONObject root = new JSONObject(json);  // Parse the JSON using org.json
                JSONObject products = root.getJSONObject("products");

                for (String productId : carrotIds) {
                    if (!products.has(productId)) {
                        System.out.println(productId + " not found.");
                        continue;
                    }

                    JSONObject product = products.getJSONObject(productId);

                    // Parse sell_summary and buy_summary arrays
                    JSONArray sellSummary = product.getJSONArray("sell_summary");
                    JSONArray buySummary = product.getJSONArray("buy_summary");

                    if (sellSummary.length() > 0 && buySummary.length() > 0) {
                        // Get the pricePerUnit from the first entry in the arrays
                        sellPrice = sellSummary.getJSONObject(0).getDouble("pricePerUnit");
                        buyPrice = buySummary.getJSONObject(0).getDouble("pricePerUnit");

                    } else {
                        System.out.println(productId + ": No buy/sell info found.");
                    }
                }


                System.out.println("Enter Starting Level: ");
                int fromLevel = reader.nextInt();
                if (!(fromLevel >= 1 && fromLevel <= 200))
                    throw new Exception("Starting level out of bounds");
                System.out.println("Enter Current XP: ");

                int currentXP = reader.nextInt();
                if (currentXP > Lvl.combined[rarity][fromLevel])
                    throw new Exception("Out of Bounds Level XP");
                System.out.println("Enter Last Level: ");
                int toLevel = reader.nextInt();
                if (!(toLevel > fromLevel && toLevel <= 200))
                    throw new Exception("Last level out of bounds");
                int req = (Lvl.calcExpDiffBetweenLvlsByRarity(fromLevel, currentXP, toLevel, Lvl.Rarity.values()[rarity]) / 1500000 + 1);
                DecimalFormat format = new DecimalFormat("#,###.#");
                System.out.println("\u001b[36mXP Required: " + f.format(Lvl.calcExpDiffBetweenLvlsByRarity(fromLevel, currentXP, toLevel, Lvl.Rarity.values()[rarity])));
                System.out.println("\u001b[36mUltimate Carrot Candies Required: " + req);
                System.out.println("\u001b[36mCandy Buy Price: " + format.format(buyPrice * (double) req));
                System.out.println("\u001b[36mCandy Sell Price: " + format.format(sellPrice * (double) req));
            } catch (Exception e) {
                System.out.println("\u001b[31mError: " + e.getMessage() + ", try again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}