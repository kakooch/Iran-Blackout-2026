package org.rbmain.messenger;

import android.os.Build;
import androidMessenger.utilites.MyLog;

/* loaded from: classes.dex */
public class BuildVars {
    public static String APPCENTER_HASH;
    public static String APPCENTER_HASH_DEBUG;
    public static String APP_HASH;
    public static int APP_ID;
    public static int BUILD_VERSION;
    public static String BUILD_VERSION_STRING;
    public static boolean CHECK_UPDATES;
    public static boolean DEBUG_PRIVATE_VERSION;
    public static boolean DEBUG_VERSION;
    public static boolean LOGS_ENABLED;
    public static boolean NO_SCOPED_STORAGE;
    public static String SMS_HASH;
    public static boolean USE_CLOUD_STRINGS;

    static {
        NO_SCOPED_STORAGE = Build.VERSION.SDK_INT <= 29;
        boolean z = MyLog.isDebugAble;
        DEBUG_VERSION = z;
        DEBUG_PRIVATE_VERSION = false;
        LOGS_ENABLED = z;
        USE_CLOUD_STRINGS = false;
        CHECK_UPDATES = false;
        BUILD_VERSION = 0;
        BUILD_VERSION_STRING = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        APP_ID = 0;
        APP_HASH = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        APPCENTER_HASH = "a5b5c4f5-51da-dedc-9918-d9766a22ca7c";
        APPCENTER_HASH_DEBUG = "f9726602-67c9-48d2-b5d0-4761f1c1a8f3";
        SMS_HASH = z ? "O2P2z+/jBpJ" : "oLeq9AcOZkT";
        if (ApplicationLoader.applicationContext != null) {
            LOGS_ENABLED = ApplicationLoader.applicationContext.getSharedPreferences("systemConfig", 0).getBoolean("logsEnabled", DEBUG_VERSION);
        }
    }
}
