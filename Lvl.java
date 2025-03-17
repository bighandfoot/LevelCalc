public class Lvl {
    public enum Rarity {
        COMMON,
        UNCOMMON,
        RARE,
        EPIC,
        LEGENDARY
    }

    public static int calcExpDiffBetweenLvlsByRarity(int fromLevel, int currentXP, int toLevel, Rarity rarity) {
        int total = 0;

        for (int i = fromLevel - 1; i <= toLevel - 1; i++) {
            total += combined[rarity.ordinal()][i];
        }
        if (currentXP > combined[rarity.ordinal()][fromLevel - 1]) {
            System.out.println("\u001b[31mError: Out of Bounds Level XP.");
            System.out.println("\u001b[31mYou Have Entered an XP Amount Above your Current Level's Max!");
            return -1;
        }
        return total - currentXP;
    }


    private final static int[] COMMON = {
            0, 100, 110, 120, 130, 145, 160, 175, 190, 210,
            230, 250, 275, 300, 330, 360, 400, 440, 490, 540,
            600, 660, 730, 800, 880, 960, 1050, 1150, 1260, 1380,
            1510, 1650, 1800, 1960, 2130, 2310, 2500, 2700, 2920, 3160,
            3420, 3700, 4000, 4350, 4750, 5200, 5700, 6300, 7000, 7800,
            8700, 9700, 10800, 12000, 13300, 14700, 16200, 17800, 19500, 21300,
            23200, 25200, 27400, 29800, 32400, 35200, 38200, 41400, 44800, 48400,
            52200, 56200, 60400, 64800, 69400, 74200, 79200, 84700, 90700, 97200,
            104200, 111700, 119700, 128200, 137200, 146700, 156700, 167700, 179700, 192700,
            206700, 221700, 237700, 254700, 272700, 291700, 311700, 333700, 357700, 383700
    };

     private final static int[] UNCOMMON = {
             0, 175, 190, 210, 230, 250, 275, 300, 330, 360,
             400, 440, 490, 540, 600, 660, 730, 800, 880, 960,
             1050, 1150, 1260, 1380, 1510, 1650, 1800, 1960, 2130, 2310,
             2500, 2700, 2920, 3160, 3420, 3700, 4000, 4350, 4750, 5200,
             5700, 6300, 7000, 7800, 8700, 9700, 10800, 12000, 13300, 14700,
             16200, 17800, 19500, 21300, 23200, 25200, 27400, 29800, 32400, 35200,
             38200, 41400, 44800, 48400, 52200, 56200, 60400, 64800, 69400, 74200,
             79200, 84700, 90700, 97200, 104200, 111700, 119700, 128200, 137200, 146700,
             156700, 167700, 179700, 192700, 206700, 221700, 237700, 254700, 272700, 291700,
             311700, 333700, 357700, 383700, 411700, 441700, 476700, 516700, 561700, 611700
     };

     private final static int[] RARE = {
             0, 275, 300, 330, 360, 400, 440, 490, 540, 600,
             660, 730, 800, 880, 960, 1050, 1150, 1260, 1380, 1510,
             1650, 1800, 1960, 2130, 2310, 2500, 2700, 2920, 3160, 3420,
             3700, 4000, 4350, 4750, 5200, 5700, 6300, 7000, 7800, 8700,
             9700, 10800, 12000, 13300, 14700, 16200, 17800, 19500, 21300, 23200,
             25200, 27400, 29800, 32400, 35200, 38200, 41400, 44800, 48400, 52200,
             56200, 60400, 64800, 69400, 74200, 79200, 84700, 90700, 97200, 104200,
             111700, 119700, 128200, 137200, 146700, 156700, 167700, 179700, 192700, 206700,
             221700, 237700, 254700, 272700, 291700, 311700, 333700, 357700, 383700, 411700,
             441700, 476700, 516700, 561700, 611700, 666700, 726700, 791700, 861700, 936700
     };

     private final static int[] EPIC = {
             0, 440, 490, 540, 600, 660, 730, 800, 880, 960,
             1050, 1150, 1260, 1380, 1510, 1650, 1800, 1960, 2130, 2310,
             2500, 2700, 2920, 3160, 3420, 3700, 4000, 4350, 4750, 5200,
             5700, 6300, 7000, 7800, 8700, 9700, 10800, 12000, 13300, 14700,
             16200, 17800, 19500, 21300, 23200, 25200, 27400, 29800, 32400, 35200,
             38200, 41400, 44800, 48400, 52200, 56200, 60400, 64800, 69400, 74200,
             79200, 84700, 90700, 97200, 104200, 111700, 119700, 128200, 137200, 146700,
             156700, 167700, 179700, 192700, 206700, 221700, 237700, 254700, 272700, 291700,
             311700, 333700, 357700, 383700, 411700, 441700, 476700, 516700, 561700, 611700,
             666700, 726700, 791700, 861700, 936700, 1016700, 1101700, 1191700, 1286700, 1386700
     };

     private final static int[] LEGENDARY = {
             0, 660, 730, 800, 880, 960, 1050, 1150, 1260, 1380,
             1510, 1650, 1800, 1960, 2130, 2310, 2500, 2700, 2920, 3160,
             3420, 3700, 4000, 4350, 4750, 5200, 5700, 6300, 7000, 7800,
             8700, 9700, 10800, 12000, 13300, 14700, 16200, 17800, 19500, 21300,
             23200, 25200, 27400, 29800, 32400, 35200, 38200, 41400, 44800, 48400,
             52200, 56200, 60400, 64800, 69400, 74200, 79200, 84700, 90700, 97200,
             104200, 111700, 119700, 128200, 137200, 146700, 156700, 167700, 179700, 192700,
             206700, 221700, 237700, 254700, 272700, 291700, 311700, 333700, 357700, 383700,
             411700, 441700, 476700, 516700, 561700, 611700, 666700, 726700, 791700, 861700,
             936700, 1016700, 1101700, 1191700, 1286700, 1386700, 1496700, 1616700, 1746700, 1886700,
             0, 5555, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700,
             1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700,
             1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700,
             1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700,
             1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700,
             1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700,
             1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700,
             1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700,
             1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700,
             1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700, 1886700
     };
     private final static int[][] combined = {COMMON, UNCOMMON, RARE, EPIC, LEGENDARY};
}

