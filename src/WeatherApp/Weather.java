package WeatherApp;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Weather {
    private String keywords;
    private JsonElement results;

    public void setKeywords(String keywords){
        checkKeywordsW();
        this.keywords = keywords;
    }

    public String getKeywords(){
        return keywords;
    }

    public Weather(String w) {
        try {
            keywords = URLEncoder.encode(w, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void fetch() {
        String urlString = "https://api.aerisapi.com/observations/" + keywords
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

    public String getCurrentConditions() {
        String temp = results.getAsJsonObject()
                .get("response").getAsJsonObject()
                .get("ob").getAsJsonObject()
                .get("weather").getAsString();
        return temp;
    }

    public String getIcon() {
        String icon = results.getAsJsonObject()
                .get("response").getAsJsonObject()
                .get("ob").getAsJsonObject()
                .get("icon").getAsString();
        return icon;
    }

    public Double getCurrentTemp() {
        String temp = results.getAsJsonObject()
                .get("response").getAsJsonObject()
                .get("ob").getAsJsonObject()
                .get("tempF").getAsString();
        return Double.parseDouble(temp);
    }

    public Double getCelcius() {
        String celcius = results.getAsJsonObject()
                .get("response").getAsJsonObject()
                .get("ob").getAsJsonObject()
                .get("tempC").getAsString();
        return Double.parseDouble(celcius);
    }

    public String getState() {
        String title = results.getAsJsonObject()
                .get("response").getAsJsonObject()
                .get("place").getAsJsonObject()
                .get("state").getAsString();
        return title;
    }

    public String getCity() {

        String title = results.getAsJsonObject()
                    .get("response").getAsJsonObject()
                    .get("place").getAsJsonObject()
                    .get("name").getAsString();
            return title;
    }
    public boolean getTrueW()
    {
        return results.getAsJsonObject().get("success").getAsBoolean();
    }

    public long[] getDatesw()
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
    public String checkKeywordsW(String keywords) {
        if (keywords.isEmpty()) {
            return ":auto";
        } else {
            String check = keywords;
            check = check.replace("+", "");
            check = check.replace(",", " ");
            check = check.toUpperCase();
            check = check.replace("the moon", "MOON SD");
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
            check = check.replace("the moon", "MOON,SD");
            return check;
        }
    }

    public String checkKeywordsW() {
        String check = getKeywords();
        check = check.toUpperCase();
        check = check.replace(","," ");
        check = check.replace("the moon", "MOON,SD");
        check = check.replace("ALABAMA", "AL");
        check = check.replace("ALASKA", "AK");
        check = check.replace("ARIZONA", "AZ");
        check = check.replace("ARKANSAS","AR");
        check = check.replace("CALIFORNIA", "CA");
        check = check.replace("Colorado","CO");
        check = check.replace("Connecticut","CT");
        check = check.replace("Delaware","DE");
        check = check.replace("District Of Columbia","DC");
        check = check.replace("Florida","FL");
        check = check.replace("Georgia","GA");
        check = check.replace("Hawaii","HI");
        check = check.replace("Idaho","ID");
        check = check.replace("Illinois","IL");
        check = check.replace("Indiana","IN");
        check = check.replace("Iowa","IA");
        check = check.replace("Kansas","KS");
        check = check.replace("Kentucky","KY");
        check = check.replace("Louisiana","LA");
        check = check.replace("Maine","ME");
        check = check.replace("Maryland","MD");
        check = check.replace("Massachusetts","MA");
        check = check.replace("Michigan","MI");
        check = check.replace("Minnesota","MN");
        check = check.replace("Mississippi","MS");
        check = check.replace("Missouri","MO");
        check = check.replace("Montana","MT");
        check = check.replace("Nebraska","NE");
        check = check.replace("Nevada","NV");
        check = check.replace("New Hampshire","NH");
        check = check.replace("New Jersey","NJ");
        check = check.replace("New Mexico","NM");
        check = check.replace("New York","NY");
        check = check.replace("North Carolina","NC");
        check = check.replace("North Dakota","ND");
        check = check.replace("Ohio","OH");
        check = check.replace("Oklahoma","OK");
        check = check.replace("Oregon","OR");
        check = check.replace("Pennsylvania","PA");
        check = check.replace("Rhode Island","RI");
        check = check.replace("South Carolina","SC");
        check = check.replace("South Dakota","SD");
        check = check.replace("Tennessee","TN");
        check = check.replace("Texas","TX");
        check = check.replace("Utah","UT");
        check = check.replace("Vermont","VT");
        check = check.replace("Virginia","VA");
        check = check.replace("Washington","WA");
        check = check.replace("West Virginia","WV");
        check = check.replace("Wisconsin","WI");
        check = check.replace("Wyoming","WY");
        check = check.replace("Guam", "GU");
        check = check.replace("Puerto Rico","PR");
        check = check.replace("Virgin Islands","VI");
        check = check.replace("Armed Forces (AE)","AE");
        check = check.replace("Armed Forces Americas","AA");
        check = check.replace("Armed Forces Pacific","AP");
        check = check.replace("AL",",AL");
        check = check.replace("AK",",AK");
        check = check.replace("AZ",",AZ");
        check = check.replace("AR",",AR");
        check = check.replace("CA",",CA");
        check = check.replace("CO",",CO");
        check = check.replace("CT",",CT");
        check = check.replace("DE",",DE");
        check = check.replace("DC",",DC");
        check = check.replace("FL",",FL");
        check = check.replace("GA",",GA");
        check = check.replace("HI",",HI");
        check = check.replace("ID",",ID");
        check = check.replace("IL",",IN");
        check = check.replace("IA",",IA");
        check = check.replace("KS",",KS");
        check = check.replace("KY",",KY");
        check = check.replace("LA",",LA");
        check = check.replace("ME",",ME");
        check = check.replace("MD",",MD");
        check = check.replace("MA",",MA");
        check = check.replace("MI",",MI");
        check = check.replace("MN",",MN");
        check = check.replace("MS",",MS");
        check = check.replace("MO",",MO");
        check = check.replace("MT",",MT");
        check = check.replace("NE",",NE");
        check = check.replace("NV",",NV");
        check = check.replace("NH",",NH");
        check = check.replace("NJ",",NJ");
        check = check.replace("NM",",NM");
        check = check.replace("NY",",NY");
        check = check.replace("NC",",NC");
        check = check.replace("ND",",ND");
        check = check.replace("OH",",OH");
        check = check.replace("OK",",OK");
        check = check.replace("OR",",OR");
        check = check.replace("PA",",PA");
        check = check.replace("RI",",RI");
        check = check.replace("SC",",SC");
        check = check.replace("SD",",SD");
        check = check.replace("TN",",TN");
        check = check.replace("TX",",TX");
        check = check.replace("UT",",UT");
        check = check.replace("VT",",VT");
        check = check.replace("VA",",VA");
        check = check.replace("WA",",WA");
        check = check.replace("WV",",WV");
        check = check.replace("WI",",WI");
        check = check.replace("WY",",WY");
        check = check.replace("GU",",GU");
        check = check.replace("PR",",PR");
        check = check.replace("VI",",VI");
        check = check.replace(" ","");
        check = check.replace("%2C+","");
        check = check.replace("%2C","");
        check = check.replace("+","");
        return check;
    }
    public static void main (String[] args) {
        String key = "auburn, ca";
        Weather w = new Weather(key);
        System.out.println(w.checkKeywordsW());
        w.checkKeywordsW();
        w.fetch();
        w.getTrueW();
        System.out.println(w.getTrueW());
    }
}
