package com.seago.loltrack;

import android.util.Log;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

class Utils {

    // Id's for certain actions
    public static final String API_KEY = "OznRfLFTUfZf9Mt3eOCR";
    private static final int ROLE_ALL = 0;
    private static final int ROLE_TOP = 1;
    private static final int ROLE_JUN = 2;
    private static final int ROLE_MID = 3;
    private static final int ROLE_ADC = 4;
    private static final int ROLE_SUP = 5;

    // List of all champions and their role
    private static final RoleMap[] CHAMPION_ROLE_COLLECTION = new RoleMap[]{
            new RoleMap(1, "Annie", Utils.ROLE_MID),
            new RoleMap(2, "Olaf", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(3, "Galio", Utils.ROLE_TOP, Utils.ROLE_MID),
            new RoleMap(4, "Twisted Fate", Utils.ROLE_MID),
            new RoleMap(5, "Xin Zhao", Utils.ROLE_JUN, Utils.ROLE_TOP),
            new RoleMap(6, "Urgot", Utils.ROLE_ADC),
            new RoleMap(7, "LeBlanc", Utils.ROLE_MID),
            new RoleMap(8, "Vladimir", Utils.ROLE_TOP, Utils.ROLE_MID),
            new RoleMap(9, "Fiddlesticks", Utils.ROLE_JUN, Utils.ROLE_MID),
            new RoleMap(10, "Kayle", Utils.ROLE_TOP, Utils.ROLE_MID),
            new RoleMap(11, "Master Yi", Utils.ROLE_JUN, Utils.ROLE_MID),
            new RoleMap(12, "Alistar", Utils.ROLE_SUP, Utils.ROLE_JUN),
            new RoleMap(13, "Ryze", Utils.ROLE_MID),
            new RoleMap(14, "Sion", Utils.ROLE_MID, Utils.ROLE_TOP),
            new RoleMap(15, "Sivir", Utils.ROLE_ADC),
            new RoleMap(16, "Soraka", Utils.ROLE_SUP),
            new RoleMap(17, "Teemo", Utils.ROLE_TOP, Utils.ROLE_MID),
            new RoleMap(18, "Tristana", Utils.ROLE_ADC),
            new RoleMap(19, "Warwick", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(20, "Nunu", Utils.ROLE_SUP, Utils.ROLE_JUN),
            new RoleMap(21, "Miss Fortune", Utils.ROLE_ADC),
            new RoleMap(22, "Ashe", Utils.ROLE_ADC),
            new RoleMap(23, "Tryndamere", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(24, "Jax", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(25, "Morgana", Utils.ROLE_MID),
            new RoleMap(26, "Zilean", Utils.ROLE_MID, Utils.ROLE_SUP),
            new RoleMap(27, "Singed", Utils.ROLE_TOP),
            new RoleMap(28, "Evelynn", Utils.ROLE_MID, Utils.ROLE_JUN),
            new RoleMap(29, "Twitch", Utils.ROLE_ADC),
            new RoleMap(30, "Karthus", Utils.ROLE_MID),
            new RoleMap(31, "Cho'Gath", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(32, "Amumu", Utils.ROLE_JUN),
            new RoleMap(33, "Rammus", Utils.ROLE_JUN),
            new RoleMap(34, "Anivia", Utils.ROLE_MID),
            new RoleMap(35, "Shaco", Utils.ROLE_JUN),
            new RoleMap(36, "Dr. Mundo", Utils.ROLE_JUN),
            new RoleMap(37, "Sona", Utils.ROLE_SUP),
            new RoleMap(38, "Kassadin", Utils.ROLE_MID),
            new RoleMap(39, "Irelia", Utils.ROLE_TOP),
            new RoleMap(40, "Janna", Utils.ROLE_SUP),
            new RoleMap(41, "Gangplank", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(42, "Corki", Utils.ROLE_ADC),
            new RoleMap(43, "Karma", Utils.ROLE_MID, Utils.ROLE_SUP),
            new RoleMap(44, "Taric", Utils.ROLE_SUP),
            new RoleMap(45, "Veigar", Utils.ROLE_MID),
            new RoleMap(48, "Trundle", Utils.ROLE_JUN),
            new RoleMap(50, "Swain", Utils.ROLE_MID),
            new RoleMap(51, "Caitlyn", Utils.ROLE_ADC),
            new RoleMap(53, "Blitzcrank", Utils.ROLE_SUP),
            new RoleMap(54, "Malphite", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(55, "Katarina", Utils.ROLE_MID),
            new RoleMap(56, "Nocturne", Utils.ROLE_JUN),
            new RoleMap(57, "Maokai", Utils.ROLE_JUN),
            new RoleMap(58, "Renekton", Utils.ROLE_TOP),
            new RoleMap(59, "Jarvan IV", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(60, "Elise", Utils.ROLE_TOP, Utils.ROLE_MID),
            new RoleMap(61, "Orianna", Utils.ROLE_MID),
            new RoleMap(62, "Wukong", Utils.ROLE_TOP),
            new RoleMap(63, "Brand", Utils.ROLE_MID),
            new RoleMap(64, "Lee Sin", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(67, "Vayne", Utils.ROLE_ADC),
            new RoleMap(68, "Rumble", Utils.ROLE_TOP),
            new RoleMap(69, "Cassiopeia", Utils.ROLE_MID),
            new RoleMap(72, "Skarner", Utils.ROLE_JUN),
            new RoleMap(74, "Heimerdinger", Utils.ROLE_MID),
            new RoleMap(75, "Nasus", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(76, "Nidalee", Utils.ROLE_TOP, Utils.ROLE_MID),
            new RoleMap(77, "Udyr", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(78, "Poppy", Utils.ROLE_TOP),
            new RoleMap(79, "Gragas", Utils.ROLE_MID),
            new RoleMap(80, "Pantheon", Utils.ROLE_TOP, Utils.ROLE_MID, Utils.ROLE_JUN),
            new RoleMap(81, "Ezreal", Utils.ROLE_ADC),
            new RoleMap(82, "Mordekaiser", Utils.ROLE_MID),
            new RoleMap(83, "Yorick", Utils.ROLE_TOP),
            new RoleMap(84, "Akali", Utils.ROLE_TOP, Utils.ROLE_MID),
            new RoleMap(85, "Kennen", Utils.ROLE_TOP, Utils.ROLE_MID),
            new RoleMap(86, "Garen", Utils.ROLE_TOP),
            new RoleMap(89, "Leona", Utils.ROLE_SUP),
            new RoleMap(90, "Malzahar", Utils.ROLE_MID),
            new RoleMap(91, "Talon", Utils.ROLE_MID),
            new RoleMap(92, "Riven", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(96, "Kog'Maw", Utils.ROLE_ADC),
            new RoleMap(98, "Shen", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(99, "Lux", Utils.ROLE_MID, Utils.ROLE_SUP),
            new RoleMap(101, "Xerath", Utils.ROLE_MID),
            new RoleMap(102, "Shyvana", Utils.ROLE_JUN),
            new RoleMap(103, "Ahri", Utils.ROLE_MID),
            new RoleMap(104, "Graves", Utils.ROLE_ADC),
            new RoleMap(105, "Fizz", Utils.ROLE_MID),
            new RoleMap(106, "Volibear", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(107, "Rengar", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(110, "Varus", Utils.ROLE_ADC),
            new RoleMap(111, "Nautilus", Utils.ROLE_JUN),
            new RoleMap(112, "Viktor", Utils.ROLE_MID),
            new RoleMap(113, "Sejuani", Utils.ROLE_JUN),
            new RoleMap(114, "Fiora", Utils.ROLE_TOP),
            new RoleMap(115, "Ziggs", Utils.ROLE_MID),
            new RoleMap(117, "Lulu", Utils.ROLE_SUP),
            new RoleMap(119, "Draven", Utils.ROLE_ADC),
            new RoleMap(120, "Hecarim", Utils.ROLE_JUN),
            new RoleMap(121, "Kha'Zix", Utils.ROLE_MID, Utils.ROLE_JUN, Utils.ROLE_TOP),
            new RoleMap(122, "Darius", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(126, "Jayce", Utils.ROLE_TOP, Utils.ROLE_MID),
            new RoleMap(131, "Diana", Utils.ROLE_JUN, Utils.ROLE_MID),
            new RoleMap(133, "Quinn", Utils.ROLE_ADC),
            new RoleMap(134, "Syndra", Utils.ROLE_MID),
            new RoleMap(143, "Zyra", Utils.ROLE_MID, Utils.ROLE_SUP),
            new RoleMap(154, "Zac", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(238, "Zed", Utils.ROLE_MID, Utils.ROLE_TOP),
            new RoleMap(254, "Vi", Utils.ROLE_TOP, Utils.ROLE_JUN),
            new RoleMap(267, "Nami", Utils.ROLE_SUP),
            new RoleMap(412, "Thresh", Utils.ROLE_SUP)};

    // Returns the index in championRoles array of specified champion name
    private static RoleMap getChampionRoleMap(String championName) {
        for (int i = 0; i < Utils.CHAMPION_ROLE_COLLECTION.length; i++) {
            if (getSimplifiedString(Utils.CHAMPION_ROLE_COLLECTION[i].getChampionName()).equals(getSimplifiedString(championName)))
                return Utils.CHAMPION_ROLE_COLLECTION[i];
        }
        return null;
    }

    // Filters out a mapChampionStats array by a specified role
    public static ArrayList<MapChampionStats> filterByRole(ArrayList<MapChampionStats> mapChampionStats, int roleId) {
        // The array to store champions that fulfill the specified role
        ArrayList<MapChampionStats> result = new ArrayList<MapChampionStats>();

        // Go through all the champions in the list
        for (MapChampionStats aMapChampionStats : mapChampionStats) {
            // Get the champions roles
            String championName = aMapChampionStats.get("name");
            int[] roles = getChampionRoleMap(championName).getRoles();
            // Check if they fulfill the required role
            boolean valid = false;
            for (int role : roles) {
                if (role == roleId) {
                    valid = true;
                    break;
                }
            }
            // If the champion has the required role then add them to the results
            if (valid)
                result.add(aMapChampionStats);
        }
        return result;
    }

    // Calculates KDA ratio
    public static double getKDA(double kills, double deaths, double assists) {
        return ((kills + assists) / deaths);
    }

    // Calculates a champion score or skill rating for given stats
    public static double getChampionScore(double games, double kills, double deaths, double assists) {
        return games * Math.sqrt(getKDA(kills, deaths, assists));
    }

    // Converts the given string into a simplified string (all lowercase, no spaces
    private static String getSimplifiedString(String in) {
        in = in.replaceAll("\\s", "");
        in = in.replaceAll("'", "");
        in = in.replaceAll("\\.", "");
        in = in.toLowerCase(Locale.US);
        return in;
    }

    // Converts the resource given to a valid format then returns resource integer
    public static Integer getDrawableResource(String res) {
        try {
            // If the resource is not a champion (replaces all spaces with underscores)
            if (!res.substring(0, 8).equals("champion")) {
                res = res.replaceAll("\\s", "_");
            }
            res = getSimplifiedString(res);
            return (Integer) R.drawable.class.getField(res).get(null);
        } catch (Exception e) {
            Log.e("CardSummoner", "getDrawableResource(" + res + ") Exception", e);
            return null;
        }
    }

    // Formats a double to two decimal places and returns as a string
    public static String formatDouble(double in) {
        return new DecimalFormat("#,###.00").format(in);
    }

    // Adds commas to an integer and returns as a string
    public static String formatInteger(int in) {
        return new DecimalFormat("#,###").format(in);
    }

    public static String getChampionName(int champId) {
        return "Champion" + champId;
        /*
        // Determines the name of the top champion
        for (int i = 0; i < Utils.championList.length; i++) {
            if (Utils.championList[i].getId() == champId) {
                return Utils.championList[i].getName();
            }
        }
        */
    }
}
