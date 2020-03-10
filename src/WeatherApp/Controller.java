package WeatherApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sierra.AsyncTask;

public class Controller
{
    @FXML Button searchButton;
    @FXML TextField keywordsField;
    @FXML TextField locationField;
    @FXML TextField temp0Field;
    @FXML TextField cond0Field;
    @FXML ImageView icon0View;
    @FXML TextField day0Field;
    @FXML Button convertButton;
    @FXML TextField temp1HighField;
    @FXML TextField temp1LowField;
    @FXML TextField cond1Field;
    @FXML ImageView icon1View;
    @FXML TextField day1Field;
    @FXML TextField temp2HighField;
    @FXML TextField temp2LowField;
    @FXML TextField cond2Field;
    @FXML ImageView icon2View;
    @FXML TextField day2Field;
    @FXML TextField temp3HighField;
    @FXML TextField temp3LowField;
    @FXML TextField cond3Field;
    @FXML ImageView icon3View;
    @FXML TextField day3Field;
    @FXML TextField temp4HighField;
    @FXML TextField temp4LowField;
    @FXML TextField cond4Field;
    @FXML ImageView icon4View;
    @FXML TextField day4Field;
    @FXML ImageView radarView;
    @FXML ImageView backgroundPane;
    @FXML Label highLabel1;
    @FXML Label lowLabel1;
    @FXML Label conditions1;
    @FXML Label highLabel2;
    @FXML Label lowLabel2;
    @FXML Label conditions2;
    @FXML Label highLabel3;
    @FXML Label lowLabel3;
    @FXML Label conditions3;
    @FXML Label highLabel4;
    @FXML Label lowLabel4;
    @FXML Label conditions4;
    @FXML
    javafx.scene.layout.Pane Pane;


    private class GetDataInBackground extends AsyncTask<String, WeatherApp.Weather> {
        @Override
        protected WeatherApp.Weather doInBackground(String keywords) throws ErrorCatch {
            // Fetch weather
            try {
                WeatherApp.Weather w = new WeatherApp.Weather(keywords);
                w.checkKeywordsW(keywords);
                w.fetch();
                w.getTrueW();
                if (w.getTrueW() == true) {
                    return w;
                } else
                    throw new ErrorCatch();
                //keywordsField.setText("Error");
            } catch(Exception e) {
                throw new ErrorCatch();
                //keywordsField.setText("Error");
            }
        }

        @Override
        protected void onPostExecute(WeatherApp.Weather w) throws Exception
        {
            try {
                // Display Location
                if (w.getTrueW() == true) {
                    String city = w.getCity();
                    String state = w.getState();
                    locationField.setText("" + city + ", " + state);
                    locationField.setVisible(true);

                    // Display Temperature
                    Double temp = w.getCurrentTemp();
                    temp0Field.setText("" + temp + "F");
                    temp0Field.setVisible(true);

                    // Display Conditions
                    String conditions = w.getCurrentConditions();
                    cond0Field.setText("" + conditions);
                    cond0Field.setVisible(true);

                    // Display Icon
                    //System.out.println("bigImages/" + w.getIcon());
                    Image icon = new Image("file:bigImages/" + w.getIcon());
                    icon0View.setImage(icon);
                    icon0View.setVisible(true);

                    Image background = new Image("file:images/WeatherBackground.jpg");
                    backgroundPane.setImage(background);
                } else {
                    //throw new ErrorCatch();
                    keywordsField.setText("Error");
                }
            } catch (Exception e){
                throw new ErrorCatch();
            }


        }
    }

    public void handleSearchButton(ActionEvent e) throws Exception
    {
        try {
            //String keywordsField = ":auto";
            String keywords = keywordsField.getText();
            AsyncTask t = new GetDataInBackground();
            t.execute(keywords);


            // Display Convert Button
            convertButton.setText("C");
            convertButton.setVisible(true);

            String kw01 = keywordsField.getText();
            Forecast fc = new Forecast(kw01);
            fc.checkKeywordsF(keywords);
            fc.fetch1();
            fc.getTrueF();
            if (fc.getTrueF() == true) {
                long[] times = fc.getDates();
                Timezone tz = new Timezone();

                day0Field.setText(tz.getDay(times[0]));
                day0Field.setVisible(true);

                temp1HighField.setText(fc.getDay1HighTemp() + "F");
                temp1HighField.setVisible(true);
                temp1LowField.setText(fc.getDay1LowTemp() + "F");
                temp1LowField.setVisible(true);
                cond1Field.setText(fc.getDay1Cond());
                cond1Field.setVisible(true);
                Image icon1 = new Image("file:bigImages/" + fc.getIcon1());
                icon1View.setImage(icon1);
                day1Field.setText(tz.getDay(times[1]));
                day1Field.setVisible(true);
                highLabel1.setVisible(true);
                lowLabel1.setVisible(true);
                conditions1.setVisible(true);

                temp2HighField.setText(fc.getDay2HighTemp() + "F");
                temp2HighField.setVisible(true);
                temp2LowField.setText(fc.getDay2LowTemp() + "F");
                temp2LowField.setVisible(true);
                cond2Field.setText(fc.getDay2Cond());
                cond2Field.setVisible(true);
                Image icon2 = new Image("file:bigImages/" + fc.getIcon2());
                icon2View.setImage(icon2);
                day2Field.setText(tz.getDay(times[2]));
                day2Field.setVisible(true);
                highLabel2.setVisible(true);
                lowLabel2.setVisible(true);
                conditions2.setVisible(true);

                temp3HighField.setText(fc.getDay3HighTemp() + "F");
                temp3HighField.setVisible(true);
                temp3LowField.setText(fc.getDay3LowTemp() + "F");
                temp3LowField.setVisible(true);
                cond3Field.setText(fc.getDay3Cond());
                cond3Field.setVisible(true);
                Image icon3 = new Image("file:bigImages/" + fc.getIcon3());
                icon3View.setImage(icon3);
                day3Field.setText(tz.getDay(times[3]));
                day3Field.setVisible(true);
                highLabel3.setVisible(true);
                lowLabel3.setVisible(true);
                conditions3.setVisible(true);

                temp4HighField.setText(fc.getDay4HighTemp() + "F");
                temp4HighField.setVisible(true);
                temp4LowField.setText(fc.getDay4LowTemp() + "F");
                temp4LowField.setVisible(true);
                cond4Field.setText(fc.getDay4Cond());
                cond4Field.setVisible(true);
                Image icon4 = new Image("file:bigImages/" + fc.getIcon4());
                icon4View.setImage(icon4);
                day4Field.setText(tz.getDay(times[4]));
                day4Field.setVisible(true);
                highLabel4.setVisible(true);
                lowLabel4.setVisible(true);
                conditions4.setVisible(true);
            } else {
                throw new ErrorCatch();
            }
        } catch (Exception ex){
            throw new ErrorCatch();
        }

    }

    public void handleConvertButton(ActionEvent e) throws Exception {
        try {
            String temp = temp0Field.getText();
            String temp2 = Character.toString(temp.charAt(temp.length() - 1));// gets the last character of the string

            if (temp2.equals("C")) {
            /*String kw = keywordsField.getText();

            Weather wa = new Weather(kw);
            wa.fetch();
            convertButton.setText("F");
            temp0Field.setText(Double.toString(wa.getCelcius()) + "C");*/
                String kw = keywordsField.getText();

                Weather wa = new Weather(kw);
                wa.fetch();
                convertButton.setText("C");
                temp0Field.setText(Double.toString(wa.getCurrentTemp()) + "F");
            } else {
           /* String kw = keywordsField.getText();

            Weather wa = new Weather(kw);
            wa.fetch();
            convertButton.setText("C");
            temp0Field.setText(Double.toString(wa.getCurrentTemp()) + "F");*/
                String kw = keywordsField.getText();

                Weather wa = new Weather(kw);
                wa.fetch();
                convertButton.setText("F");
                temp0Field.setText(Double.toString(wa.getCelcius()) + "C");
            }
        } catch (Exception ex){
            //throw new ErrorCatch();
            keywordsField.setText("Error");
        }

    }

    //Radar Window
    @FXML
    public void handleRadarButton(ActionEvent event) throws Exception
    {
        /*Parent radarViewer = FXMLLoader.load(getClass().getResource("Radar.fxml"));
        Scene radarViewScene = new Scene(radarViewer);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(radarViewScene);
        window.show();*/


        String keywords = keywordsField.getText();
        System.out.println("Keywords in the keywords field: " +keywords);
        String urlString = "https://maps.aerisapi.com/" +
                "wQhXMMnxoRV4HNKoRLZrL_kKe5vfOM4RWAA8j8fCcfycyJwVUWTPzbLGVuQUBW/" +
                "flat,radar,counties,interstates,admin-cities/256x256/" +
                keywords + ",8/current.png";
        Image radar = new Image(urlString);
        icon0View.setImage(radar);
        /*try {
            Parent radarViewer = FXMLLoader.load(getClass().getResource("Radar.fxml"));
            Scene radarViewScene = new Scene(radarViewer);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(radarViewScene);
            window.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

        String keywords = keywordsField.getText();
        String urlString = "https://maps.aerisapi.com/" +
                    "wQhXMMnxoRV4HNKoRLZrL_kKe5vfOM4RWAA8j8fCcfycyJwVUWTPzbLGVuQUBW/" +
                    "flat,radar,counties,interstates,admin-cities/256x256/" +
                    keywords + ",8/current.png";
        Image radar = new Image(urlString);
        radarView.setImage(radar);
        //radarView.setImage(radar);*/
    }

}