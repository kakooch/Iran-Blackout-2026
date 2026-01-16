package ir.eitaa.messenger.voip;

import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VoIPServerConfig {
    private static JSONObject config = new JSONObject();

    private static native void nativeSetConfig(String json);

    public static void setConfig(String json) throws IOException {
        try {
            config = new JSONObject(json);
            nativeSetConfig(json);
        } catch (JSONException e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Error parsing VoIP config", e);
            }
        }
    }

    public static int getInt(String key, int fallback) {
        return config.optInt(key, fallback);
    }

    public static double getDouble(String key, double fallback) {
        return config.optDouble(key, fallback);
    }

    public static String getString(String key, String fallback) {
        return config.optString(key, fallback);
    }

    public static boolean getBoolean(String key, boolean fallback) {
        return config.optBoolean(key, fallback);
    }
}
