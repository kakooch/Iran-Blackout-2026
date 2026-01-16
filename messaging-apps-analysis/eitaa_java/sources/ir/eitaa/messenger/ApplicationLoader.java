package ir.eitaa.messenger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.multidex.MultiDex;
import com.google.android.gms.common.GooglePlayServicesUtil;
import ir.eitaa.messenger.voip.VideoCapturerDevice;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$TL_AppInfo;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.Components.ForegroundDetector;
import ir.eitaa.ui.CrashReportDialog;
import java.io.File;
import org.acra.ACRA;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.config.DialogConfigurationBuilder;
import org.acra.config.HttpSenderConfigurationBuilder;
import org.acra.data.StringFormat;
import org.acra.sender.HttpSender;

/* loaded from: classes.dex */
public class ApplicationLoader extends Application {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context applicationContext = null;
    public static volatile Handler applicationHandler = null;
    private static volatile boolean applicationInited = false;
    public static boolean canDrawOverlays = false;
    private static ConnectivityManager connectivityManager = null;
    public static volatile NetworkInfo currentNetworkInfo = null;
    public static volatile boolean externalInterfacePaused = true;
    public static boolean hasPlayServices = false;
    public static volatile boolean isScreenOn = false;
    public static volatile boolean mainInterfacePaused = true;
    public static volatile boolean mainInterfacePausedStageQueue = true;
    public static volatile long mainInterfacePausedStageQueueTime = 0;
    public static volatile boolean mainInterfaceStopped = true;
    public static long startTime;

    private void initPlayServices() {
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        CoreConfigurationBuilder coreConfigurationBuilder = new CoreConfigurationBuilder(this);
        coreConfigurationBuilder.setBuildConfigClass(BuildConfig.class).setReportFormat(StringFormat.JSON);
        ((HttpSenderConfigurationBuilder) coreConfigurationBuilder.getPluginConfigurationBuilder(HttpSenderConfigurationBuilder.class)).setUri("https://dev3.eitaa.com/eitaa/Log/Crash_Reports.php").setHttpMethod(HttpSender.Method.POST).setEnabled(true);
        ((DialogConfigurationBuilder) coreConfigurationBuilder.getPluginConfigurationBuilder(DialogConfigurationBuilder.class)).setReportDialogClass(CrashReportDialog.class).setEnabled(true).setResIcon(R.mipmap.ic_launcher);
        try {
            ACRA.init(this, coreConfigurationBuilder);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static File getFilesDirFixed() {
        for (int i = 0; i < 10; i++) {
            File filesDir = applicationContext.getFilesDir();
            if (filesDir != null) {
                return filesDir;
            }
        }
        try {
            File file = new File(applicationContext.getApplicationInfo().dataDir, "files");
            file.mkdirs();
            return file;
        } catch (Exception e) {
            FileLog.e(e);
            return new File("/data/data/ir.eitaa.messenger/files");
        }
    }

    public static void postInitApplication() {
        if (applicationInited) {
            return;
        }
        applicationInited = true;
        try {
            LocaleController.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            applicationContext.registerReceiver(new BroadcastReceiver() { // from class: ir.eitaa.messenger.ApplicationLoader.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    try {
                        ApplicationLoader.currentNetworkInfo = ApplicationLoader.connectivityManager.getActiveNetworkInfo();
                    } catch (Throwable unused) {
                    }
                    boolean zIsConnectionSlow = ApplicationLoader.isConnectionSlow();
                    for (int i = 0; i < 3; i++) {
                        ConnectionsManager.getInstance(i).checkConnection();
                        FileLoader.getInstance(i).onNetworkChanged(zIsConnectionSlow);
                    }
                }
            }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            applicationContext.registerReceiver(new ScreenReceiver(), intentFilter);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            isScreenOn = ((PowerManager) applicationContext.getSystemService("power")).isScreenOn();
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("screen state = " + isScreenOn);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        SharedConfig.loadConfig();
        for (int i = 0; i < 3; i++) {
            UserConfig.getInstance(i).loadConfig();
            MessagesController.getInstance(i);
            if (i != 0) {
                ConnectionsManager.getInstance(i);
            }
            TLRPC$User currentUser = UserConfig.getInstance(i).getCurrentUser();
            if (currentUser != null) {
                MessagesController.getInstance(i).putUser(currentUser, true);
                SendMessagesHelper.getInstance(i).checkUnsentMessages();
                UserConfig.getInstance(UserConfig.selectedAccount).setMxbState(currentUser.MXB_REGISTERED_USER);
            }
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("app initied");
        }
        MediaController.getInstance();
        for (int i2 = 0; i2 < 3; i2++) {
            ContactsController.getInstance(i2).checkAppAccount();
            DownloadController.getInstance(i2);
        }
        ChatThemeController.init();
        try {
            String str = UserConfig.getInstance(UserConfig.selectedAccount).imei;
            if (str != null && str.length() > 0) {
                ACRA.getErrorReporter().putCustomData("imei", str);
            }
            long clientUserId = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
            if (clientUserId != 0) {
                ACRA.getErrorReporter().putCustomData("userId", String.valueOf(clientUserId));
            }
        } catch (Exception e5) {
            FileLog.e(e5);
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        try {
            applicationContext = getApplicationContext();
        } catch (Throwable unused) {
        }
        super.onCreate();
        if (BuildVars.LOGS_ENABLED) {
            StringBuilder sb = new StringBuilder();
            sb.append("app start time = ");
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            startTime = jElapsedRealtime;
            sb.append(jElapsedRealtime);
            FileLog.d(sb.toString());
        }
        if (applicationContext == null) {
            applicationContext = getApplicationContext();
        }
        NativeLoader.initNativeLibs(applicationContext);
        ConnectionsManager.native_setJava(false);
        new ForegroundDetector(this) { // from class: ir.eitaa.messenger.ApplicationLoader.2
            @Override // ir.eitaa.ui.Components.ForegroundDetector, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                boolean zIsBackground = isBackground();
                super.onActivityStarted(activity);
                if (zIsBackground) {
                    ApplicationLoader.ensureCurrentNetworkGet(true);
                }
            }
        };
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("load libs time = " + (SystemClock.elapsedRealtime() - startTime));
        }
        applicationHandler = new Handler(applicationContext.getMainLooper());
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$4u01ciawILBuf53vTHjms3VA1ow
            @Override // java.lang.Runnable
            public final void run() {
                ApplicationLoader.startPushService();
            }
        });
    }

    public static void startPushService() {
        boolean z;
        SharedPreferences globalNotificationsSettings = MessagesController.getGlobalNotificationsSettings();
        if (globalNotificationsSettings.contains("pushService")) {
            z = globalNotificationsSettings.getBoolean("pushService", true);
        } else {
            z = MessagesController.getMainSettings(UserConfig.selectedAccount).getBoolean("keepAliveService", true);
        }
        if (z) {
            try {
                applicationContext.startService(new Intent(applicationContext, (Class<?>) NotificationsService.class));
            } catch (Throwable unused) {
            }
        } else {
            applicationContext.stopService(new Intent(applicationContext, (Class<?>) NotificationsService.class));
            ((AlarmManager) applicationContext.getSystemService("alarm")).cancel(PendingIntent.getService(applicationContext, 0, new Intent(applicationContext, (Class<?>) NotificationsService.class), 0));
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        try {
            LocaleController.getInstance().onDeviceConfigurationChange(newConfig);
            AndroidUtilities.checkDisplaySize(applicationContext, newConfig);
            VideoCapturerDevice.checkScreenCapturerSize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkPlayServices() {
        try {
            return GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == 0;
        } catch (Exception e) {
            FileLog.e(e);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ensureCurrentNetworkGet(boolean force) {
        if (force || currentNetworkInfo == null) {
            try {
                if (connectivityManager == null) {
                    connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
                }
                currentNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean isRoaming() {
        try {
            ensureCurrentNetworkGet(false);
            if (currentNetworkInfo != null) {
                return currentNetworkInfo.isRoaming();
            }
            return false;
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    public static boolean isConnectedOrConnectingToWiFi() {
        try {
            ensureCurrentNetworkGet(false);
            if (currentNetworkInfo != null && (currentNetworkInfo.getType() == 1 || currentNetworkInfo.getType() == 9)) {
                NetworkInfo.State state = currentNetworkInfo.getState();
                if (state != NetworkInfo.State.CONNECTED && state != NetworkInfo.State.CONNECTING) {
                    if (state == NetworkInfo.State.SUSPENDED) {
                    }
                }
                return true;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        return false;
    }

    public static boolean isConnectedToWiFi() {
        try {
            ensureCurrentNetworkGet(false);
            if (currentNetworkInfo != null && (currentNetworkInfo.getType() == 1 || currentNetworkInfo.getType() == 9)) {
                if (currentNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        return false;
    }

    public static boolean isConnectionSlow() {
        try {
            ensureCurrentNetworkGet(false);
            if (currentNetworkInfo != null && currentNetworkInfo.getType() == 0) {
                int subtype = currentNetworkInfo.getSubtype();
                if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int getAutodownloadNetworkType() {
        try {
            ensureCurrentNetworkGet(false);
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (currentNetworkInfo == null) {
            return 0;
        }
        if (currentNetworkInfo.getType() != 1 && currentNetworkInfo.getType() != 9) {
            return currentNetworkInfo.isRoaming() ? 2 : 0;
        }
        return connectivityManager.isActiveNetworkMetered() ? 0 : 1;
    }

    public static int getCurrentNetworkType() {
        if (isConnectedOrConnectingToWiFi()) {
            return 1;
        }
        return isRoaming() ? 2 : 0;
    }

    public static boolean isNetworkOnlineFast() {
        try {
            ensureCurrentNetworkGet(false);
            if (currentNetworkInfo != null && !currentNetworkInfo.isConnectedOrConnecting() && !currentNetworkInfo.isAvailable()) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                if (networkInfo2 != null) {
                    if (networkInfo2.isConnectedOrConnecting()) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            FileLog.e(e);
            return true;
        }
    }

    public static boolean isNetworkOnlineRealtime() {
        try {
            ConnectivityManager connectivityManager2 = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager2.getActiveNetworkInfo();
            if (activeNetworkInfo != null && (activeNetworkInfo.isConnectedOrConnecting() || activeNetworkInfo.isAvailable())) {
                return true;
            }
            NetworkInfo networkInfo = connectivityManager2.getNetworkInfo(0);
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return true;
            }
            NetworkInfo networkInfo2 = connectivityManager2.getNetworkInfo(1);
            if (networkInfo2 != null) {
                if (networkInfo2.isConnectedOrConnecting()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            FileLog.e(e);
            return true;
        }
    }

    public static boolean isNetworkOnline() {
        boolean zIsNetworkOnlineRealtime = isNetworkOnlineRealtime();
        if (BuildVars.DEBUG_PRIVATE_VERSION && zIsNetworkOnlineRealtime != isNetworkOnlineFast()) {
            FileLog.d("network online mismatch");
        }
        return zIsNetworkOnlineRealtime;
    }

    public static TLRPC$TL_AppInfo getAppInfo() throws PackageManager.NameNotFoundException {
        TLRPC$TL_AppInfo tLRPC$TL_AppInfo = new TLRPC$TL_AppInfo();
        tLRPC$TL_AppInfo.build_version = BuildVars.BUILD_VERSION;
        try {
            String localeString = LocaleController.getInstance().getLocaleString(LocaleController.getInstance().getSystemDefaultLocale());
            tLRPC$TL_AppInfo.lang_code = localeString;
            if (localeString.length() == 0) {
                tLRPC$TL_AppInfo.lang_code = "en";
            }
            tLRPC$TL_AppInfo.device_model = Build.MANUFACTURER + Build.MODEL;
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            tLRPC$TL_AppInfo.app_version = packageInfo.versionName + " (" + packageInfo.versionCode + ")";
            StringBuilder sb = new StringBuilder();
            sb.append("SDK ");
            sb.append(Build.VERSION.SDK_INT);
            tLRPC$TL_AppInfo.system_version = sb.toString();
        } catch (Exception e) {
            FileLog.e(e);
            tLRPC$TL_AppInfo.lang_code = "en";
            tLRPC$TL_AppInfo.device_model = "Android unknown";
            tLRPC$TL_AppInfo.app_version = "App version unknown";
            tLRPC$TL_AppInfo.system_version = "SDK " + Build.VERSION.SDK_INT;
        }
        String str = tLRPC$TL_AppInfo.lang_code;
        if (str == null || str.length() == 0) {
            tLRPC$TL_AppInfo.lang_code = "en";
        }
        String str2 = tLRPC$TL_AppInfo.device_model;
        if (str2 == null || str2.length() == 0) {
            tLRPC$TL_AppInfo.device_model = "Android unknown";
        }
        String str3 = tLRPC$TL_AppInfo.app_version;
        if (str3 == null || str3.length() == 0) {
            tLRPC$TL_AppInfo.app_version = "App version unknown";
        }
        String str4 = tLRPC$TL_AppInfo.system_version;
        if (str4 == null || str4.length() == 0) {
            tLRPC$TL_AppInfo.system_version = "SDK Unknown";
        }
        try {
            for (Signature signature : applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 64).signatures) {
                tLRPC$TL_AppInfo.sign = signature.toCharsString();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            tLRPC$TL_AppInfo.sign = "unknown";
        }
        String str5 = tLRPC$TL_AppInfo.sign;
        if (str5 == null || str5.length() == 0) {
            tLRPC$TL_AppInfo.sign = "unknown";
        }
        return tLRPC$TL_AppInfo;
    }
}
