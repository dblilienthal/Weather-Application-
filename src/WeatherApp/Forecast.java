package WeatherApp;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Forecast {
    private String keywords;
    private JsonElement results;

    public Forecast(String f) {
        try {
            keywords = URLEncoder.encode(f, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void fetch1() {
        String urlString = "https://api.aerisapi.com/forecasts/" + keywords
                + "?client_id=wQhXMMnxoRV4HNKoRLZrL&client_secret=kKe5vfOM4RWAA8j8fCcfycyJwVUWTPzbLGVuQUBW";

        try {
            URL url = new URL(urlString);

            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            JsonParser parser = new JsonParser();
            results = parser.parse(br);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getDay1HighTemp() {
        String title = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(0).getAsJsonObject()
                .get("maxTempF").getAsString();
        return title;
    }

    public String getDay1LowTemp() {
        String title = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(0).getAsJsonObject()
                .get("minTempF").getAsString();
        return title;
    }

    public String getDay1Cond() {
        String cond = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(0).getAsJsonObject()
                .get("weatherPrimary").getAsString();
        return cond;
    }

    public String getIcon1() {
        String icon = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(0).getAsJsonObject()
                .get("icon").getAsString();
        return icon;
    }

    public String getDay2HighTemp() {
        String title = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(1).getAsJsonObject()
                .get("maxTempF").getAsString();
        return title;
    }

    public String getDay2LowTemp() {
        String title = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(1).getAsJsonObject()
                .get("minTempF").getAsString();
        return title;
    }

    public String getDay2Cond() {
        String cond = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(1).getAsJsonObject()
                .get("weatherPrimary").getAsString();
        return cond;
    }

    public String getIcon2() {
        String icon = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(1).getAsJsonObject()
                .get("icon").getAsString();
        return icon;
    }

    public String getDay3HighTemp() {
        String title = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(2).getAsJsonObject()
                .get("maxTempF").getAsString();
        return title;
    }

    public String getDay3LowTemp() {
        String title = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(2).getAsJsonObject()
                .get("minTempF").getAsString();
        return title;
    }

    public String getDay3Cond() {
        String cond = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(2).getAsJsonObject()
                .get("weatherPrimary").getAsString();
        return cond;
    }

    public String getIcon3() {
        String icon = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(2).getAsJsonObject()
                .get("icon").getAsString();
        return icon;
    }

    public String getDay4HighTemp() {
        String title = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(3).getAsJsonObject()
                .get("maxTempF").getAsString();
        return title;
    }

    public String getDay4LowTemp() {
        String title = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(3).getAsJsonObject()
                .get("minTempF").getAsString();
        return title;
    }

    public String getDay4Cond() {
        String cond = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(3).getAsJsonObject()
                .get("weatherPrimary").getAsString();
        return cond;
    }

    public String getIcon4() {
        String icon = results.getAsJsonObject()
                .get("response").getAsJsonArray().get(0).getAsJsonObject()
                .get("periods").getAsJsonArray().get(3).getAsJsonObject()
                .get("icon").getAsString();
        return icon;
    }

    public boolean getTrueF()
    {
        return results.getAsJsonObject().get("success").getAsBoolean();
    }

    public long[] getDates()
    {
        long[] dates = new long[5];
        for(int i = 0; i < dates.length; i++)
        {
            dates[i] = results.getAsJsonObject()
                    .get("response").getAsJsonArray()
                    .get(0).getAsJsonObject()
                    .get("periods").getAsJsonArray()
                    .get(i).getAsJsonObject()
                    .get("timestamp").getAsLong();
        }
        return dates;
    }

    public String checkKeywordsF(String keywords) {
        if (keywords.isEmpty()) {
            return ":auto";
        } else {
            String check = keywords;
            check = check.replace("+", "");
            check = check.replace(",", " ");
            check = check.replace("the moon", "MOON SD");
            check = check.toUpperCase();
            check = check.replace("ALASKA", "AK");
            check = check.replace("ARIZONA", "AZ");
            check = check.replace("ARKANSAS", "AR");
            check = check.replace("CALIFORNIA", "CA");
            check = check.replace("COLORADO", "CO");
            check = check.replace("CONNECTICUT", "CT");
            check = check.replace("DELAWARE", "DE");
            check = check.replace("DISTRICT OF COLUMBIA", "DC");
            check = check.replace("FLORIDA", "FL");
            check = check.replace("GEORGIA", "GA");
            check = check.replace("HAWAII", "HI");
            check = check.replace("IDAHO", "ID");
            check = check.replace("ILLINOIS", "IL");
            check = check.replace("INDIANA", "IN");
            check = check.replace("IOWA", "IA");
            check = check.replace("KANSAS", "KS");
            check = check.replace("KENTUCKY", "KY");
            check = check.replace("LOUISIANA", "LA");
            check = check.replace("MAINE", "ME");
            check = check.replace("MARYLAND", "MD");
            check = check.replace("MASSACHUSETTS", "MA");
            check = check.replace("MICHIGAN", "MI");
            check = check.replace("MINNESOTA", "MN");
            check = check.replace("MISSISSIPPI", "MS");
            check = check.replace("MISSOURI", "MO");
            check = check.replace("MONTANA", "MT");
            check = check.replace("NEBRASKA", "NE");
            check = check.replace("NEVADA", "NV");
            check = check.replace("NEW HAMPSHIRE", "NH");
            check = check.replace("NEW JERSEY", "NJ");
            check = check.replace("NEW MEXICO", "NM");
            check = check.replace("NEW YORK", "NY");
            check = check.replace("NORTH CAROLINA", "NC");
            check = check.replace("NORTH DAKOTA", "ND");
            check = check.replace("OHIO", "OH");
            check = check.replace("OKLAHOMA", "OK");
            check = check.replace("OREGON", "OR");
            check = check.replace("PENNSYLVANIA", "PA");
            check = check.replace("RHODE ISLAND", "RI");
            check = check.replace("SOUTH CAROLINA", "SC");
            check = check.replace("SOUTH DAKOTA", "SD");
            check = check.replace("TENNESSEE", "TN");
            check = check.replace("TEXAS", "TX");
            check = check.replace("UTAH", "UT");
            check = check.replace("VERMONT", "VT");
            check = check.replace("VIRGINIA", "VA");
            check = check.replace("WASHINGTON", "WA");
            check = check.replace("WEST VIRGINIA", "WV");
            check = check.replace("WISCONSIN", "WI");
            check = check.replace("WYOMING", "WY");
            check = check.replace("GUAM", "GU");
            check = check.replace("PUERTO RICO", "PR");
            check = check.replace("VIRGIN ISLANDS", "VI");
            check = check.replace("ARMED FORCES (AE)", "AE");
            check = check.replace("ARMED FORCES AMERICAS", "AA");
            check = check.replace("ARMED FORCES PACIFIC", "AP");
            check = check.replace("AL", ",AL");
            check = check.replace("AK", ",AK");
            check = check.replace("AZ", ",AZ");
            check = check.replace("AR", ",AR");
            check = check.replace("CA", ",CA");
            check = check.replace("CO", ",CO");
            check = check.replace("CT", ",CT");
            check = check.replace("DE", ",DE");
            check = check.replace("DC", ",DC");
            check = check.replace("FL", ",FL");
            check = check.replace("GA", ",GA");
            check = check.replace("HI", ",HI");
            check = check.replace("ID", ",ID");
            check = check.replace("IL", ",IN");
            check = check.replace("IA", ",IA");
            check = check.replace("KS", ",KS");
            check = check.replace("KY", ",KY");
            check = check.replace("LA", ",LA");
            check = check.replace("ME", ",ME");
            check = check.replace("MD", ",MD");
            check = check.replace("MA", ",MA");
            check = check.replace("MI", ",MI");
            check = check.replace("MN", ",MN");
            check = check.replace("MS", ",MS");
            check = check.replace("MO", ",MO");
            check = check.replace("MT", ",MT");
            check = check.replace("NE", ",NE");
            check = check.replace("NV", ",NV");
            check = check.replace("NH", ",NH");
            check = check.replace("NJ", ",NJ");
            check = check.replace("NM", ",NM");
            check = check.replace("NY", ",NY");
            check = check.replace("NC", ",NC");
            check = check.replace("ND", ",ND");
            check = check.replace("OH", ",OH");
            check = check.replace("OK", ",OK");
            check = check.replace("OR", ",OR");
            check = check.replace("PA", ",PA");
            check = check.replace("RI", ",RI");
            check = check.replace("SC", ",SC");
            check = check.replace("SD", ",SD");
            check = check.replace("TN", ",TN");
            check = check.replace("TX", ",TX");
            check = check.replace("UT", ",UT");
            check = check.replace("VT", ",VT");
            check = check.replace("VA", ",VA");
            check = check.replace("WA", ",WA");
            check = check.replace("WV", ",WV");
            check = check.replace("WI", ",WI");
            check = check.replace("WY", ",WY");
            check = check.replace("GU", ",GU");
            check = check.replace("PR", ",PR");
            check = check.replace("VI", ",VI");
            check = check.replace(" ", "");
            check = check.replace("%2C+", "");
            check = check.replace("%2C", "");
            check = check.replace("+", "");
            //String check3 = check;
            //check3 = new StringBuilder(check3).insert(check.length()-2, ",").toString();
            return check;
        }
    }

}


















