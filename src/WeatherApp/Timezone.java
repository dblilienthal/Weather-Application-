package WeatherApp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Timezone {

    String getDay(long ts)
    {
            SimpleDateFormat formatter = new SimpleDateFormat("EEEE", Locale.US);
            String strDate= formatter.format(ts * 1000L);
            return strDate;
        }
    }

