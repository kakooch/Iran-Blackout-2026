package ir.eitaa.messenger;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class BuildVars {
    public static String APP_HASH = "0d870902a3e09e7cdc57e5d7bd68da6b";
    public static int APP_ID = 1782360;
    public static int BUILD_VERSION = 2457;
    public static String BUILD_VERSION_STRING = "6.3.7";
    public static boolean CHECK_UPDATES = true;
    public static boolean DEBUG_PRIVATE_VERSION = false;
    public static boolean DEBUG_VERSION = false;
    public static boolean LOGS_ENABLED = false;
    public static boolean NO_SCOPED_STORAGE = true;
    public static String PLAYSTORE_APP_URL = null;
    public static String SMS_HASH = null;
    public static boolean USE_CLOUD_STRINGS = true;
    private static Boolean betaApp;
    private static Boolean standaloneApp;

    static {
        SMS_HASH = isStandaloneApp() ? "w0lkcmTZkKh" : DEBUG_VERSION ? "O2P2z+/jBpJ" : "oLeq9AcOZkT";
        PLAYSTORE_APP_URL = "https://cafebazaar.ir/app/ir.eitaa.messenger";
        if (ApplicationLoader.applicationContext != null) {
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("systemConfig", 0);
            boolean z = DEBUG_VERSION;
            LOGS_ENABLED = z || sharedPreferences.getBoolean("logsEnabled", z);
        }
    }

    public static boolean isStandaloneApp() {
        if (standaloneApp == null) {
            standaloneApp = Boolean.valueOf(ApplicationLoader.applicationContext != null && "ir.eitaa.messenger.web".equals(ApplicationLoader.applicationContext.getPackageName()));
        }
        return standaloneApp.booleanValue();
    }

    public static boolean isBetaApp() {
        if (betaApp == null) {
            betaApp = Boolean.valueOf(ApplicationLoader.applicationContext != null && "ir.eitaa.messenger.beta".equals(ApplicationLoader.applicationContext.getPackageName()));
        }
        return betaApp.booleanValue();
    }
}
