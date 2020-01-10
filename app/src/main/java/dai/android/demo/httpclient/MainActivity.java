package dai.android.demo.httpclient;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String userAgent = System.getProperty("http.agent");
        Log.d(TAG, "userAgent0=" + userAgent);

        Log.d(TAG, "userAgent1=" + getUserAgent());

        Log.d(TAG, "userAgent2=" + WebSettings.getDefaultUserAgent(this));
    }


    //
    //原生UA，样式如下：
    //User-Agent:"Mozilla/5.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; Build/" + Build.ID + ")"
    //示例：User-Agent: Mozilla/5.0（Linux；U；Android4.4.4；Build/PPTV_CVTE32C2）
    private String mUserAgent = null;

    private String getUserAgent() {
        if (TextUtils.isEmpty(mUserAgent)) {
            mUserAgent = String.format(Locale.CHINA, "Mozilla/5.0 (Linux; U; Android %s; %s Build/%s)",
                    Build.VERSION.RELEASE, Build.MODEL, Build.ID);
        }


        return mUserAgent;
    }


}
