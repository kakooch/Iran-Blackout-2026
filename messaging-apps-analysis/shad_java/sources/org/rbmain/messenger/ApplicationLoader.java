package org.rbmain.messenger;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import androidMessenger.ServiceLocator;
import androidMessenger.helper.AppPreferences;
import androidMessenger.proxy.IdStorageDatabaseHelper;
import androidMessenger.utilites.AppFavorUtils;
import androidMessenger.utilites.MyLog;
import androidMessenger.utilites.PendingIntentUtils;
import androidx.multidex.MultiDex;
import androidx.work.ExistingWorkPolicy;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import ir.aaap.messengercore.CoreUtilities;
import ir.resaneh1.iptv.helper.FlavorHelper;
import ir.resaneh1.iptv.helper.StorageHelper;
import ir.resaneh1.iptv.workers.RegisterDeviceWorker;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.Components.ForegroundDetector;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes.dex */
public class ApplicationLoader extends Application {
    public static volatile LaunchActivity applicationActivity = null;
    public static volatile Context applicationContext = null;
    public static volatile Handler applicationHandler = null;
    private static volatile boolean applicationInited = false;
    private static ApplicationLoader applicationLoaderInstance = null;
    public static boolean canDrawOverlays = false;
    private static ConnectivityManager connectivityManager = null;
    public static volatile NetworkInfo currentNetworkInfo = null;
    public static volatile boolean externalInterfacePaused = true;
    private static Gson gsonInctance = null;
    public static boolean hasPlayServices = false;
    public static volatile boolean isScreenOn = false;
    public static volatile boolean mainInterfacePaused = true;
    public static volatile boolean mainInterfacePausedStageQueue = true;
    public static volatile long mainInterfacePausedStageQueueTime = 0;
    public static volatile boolean mainInterfaceStopped = true;
    public static long startTime;
    private String API_KEY = "5e16ee81-80d6-4d13-80cf-15f20e7d355e";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initPlayServices$0() {
    }

    private String onGetApplicationId() {
        return BuildConfig.APPLICATION_ID;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public static String getApplicationId() {
        return applicationLoaderInstance.onGetApplicationId();
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
            return new File("/data/data/app.rbmain.a/files");
        }
    }

    public static File getFilesDirFixed2() {
        StorageHelper.makeDownloadDirs();
        return StorageHelper.getTempDirectoryFile(applicationContext);
    }

    public static Gson getGson() {
        if (gsonInctance == null) {
            gsonInctance = new Gson();
        }
        return gsonInctance;
    }

    private static void checkOldAppAuthIfNeeded() {
        try {
            if (AppPreferences.getOldAppAuthChecked()) {
                return;
            }
            AppPreferences.setOldAppAuthChecked(true);
            for (int i = 0; i < 3; i++) {
                Context context = applicationContext;
                StringBuilder sb = new StringBuilder();
                sb.append("app");
                String str = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
                if (i != 0) {
                    str = i + io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
                }
                sb.append(str);
                String string = context.getSharedPreferences(sb.toString(), 0).getString("auth1", null);
                if (CoreUtilities.isNotEmpty(string)) {
                    ServiceLocator.setLastAuth(i, string);
                }
            }
            clearLastPref();
            clearLastDB("Rubika");
        } catch (Exception unused) {
            MyLog.e("applicationLoader", "checkOldAppAuthIfNeeded exception !!!");
        }
    }

    private static void checkOldRubxAppAuthIfNeeded() {
        if (FlavorHelper.isRubx()) {
            try {
                if (AppPreferences.getOldRubxAppAuthChecked()) {
                    return;
                }
                AppPreferences.setOldRubxAppAuthChecked(true);
                for (int i = 0; i < 3; i++) {
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("messengerCorePreferences_" + i, 0);
                    String string = sharedPreferences.getString("auth1", null);
                    int i2 = sharedPreferences.getInt("currentApiVersion", 5);
                    String string2 = sharedPreferences.getString("privateKey", null);
                    if (CoreUtilities.isNotEmpty(string)) {
                        MyLog.e("applicationLoader", "shared pref version " + i2 + " " + string);
                        if (i2 == 6 && string2 != null && !string2.isEmpty()) {
                            ServiceLocator.setLastAuthV6(i, string, string2);
                        } else {
                            ServiceLocator.setLastAuth(i, string);
                        }
                    }
                    sharedPreferences.edit().clear().apply();
                }
                clearLastDB("RubxMessenger");
            } catch (Exception unused) {
                MyLog.e("applicationLoader", "checkOldAppAuthIfNeeded exception !!!");
            }
        }
    }

    private static void clearLastPref() {
        String[] list;
        File file = new File(applicationContext.getFilesDir().getParent(), "shared_prefs");
        if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!str.contains("messengerCorePreferences") && !str.contains(AppFavorUtils.SHARED_PREF_NAME_APP)) {
                    applicationContext.getSharedPreferences(str.replace(".xml", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR), 0).edit().clear().apply();
                    new File(file, str).delete();
                }
            }
        }
    }

    private static void clearLastDB(String str) {
        String[] list;
        File file = new File(applicationContext.getFilesDir().getParent(), "databases");
        if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
            for (String str2 : list) {
                if (str2.contains(str)) {
                    MyLog.e("ApplicationLoader", "clearLastDB " + str2);
                    applicationContext.deleteDatabase(str2);
                    new File(file, str2).delete();
                }
            }
        }
    }

    public static void postInitApplication() {
        if (applicationInited) {
            return;
        }
        applicationInited = true;
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ApplicationLoader.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LocaleController.getInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            applicationContext.registerReceiver(new BroadcastReceiver() { // from class: org.rbmain.messenger.ApplicationLoader.2
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            applicationContext.registerReceiver(new ScreenReceiver(), intentFilter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            isScreenOn = ((PowerManager) applicationContext.getSystemService("power")).isScreenOn();
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("screen state = " + isScreenOn);
            }
        } catch (Exception e3) {
            FileLog.e(e3);
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ApplicationLoader.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ApplicationLoader.getFilesDirFixed2();
                } catch (Exception unused) {
                }
            }
        });
        checkAndinitHandler();
        SharedConfig.loadConfig();
        checkOldAppAuthIfNeeded();
        checkOldRubxAppAuthIfNeeded();
        for (int i = 0; i < 3; i++) {
            UserConfig.getInstance(i).loadConfig();
            MessagesController.getInstance(i);
            if (i == 0) {
                SharedConfig.pushStringStatus = "__FIREBASE_GENERATING_SINCE_" + ConnectionsManager.getInstance(i).getCurrentTime() + "__";
            } else {
                ConnectionsManager.getInstance(i);
            }
            TLRPC$User currentUser = UserConfig.getInstance(i).getCurrentUser();
            if (currentUser != null) {
                MessagesController.getInstance(i).putUser(currentUser, true);
                AccountInstance.getInstance(i).getMessageProxy().loadAllNotification();
            }
        }
        ((ApplicationLoader) applicationContext).initPlayServices();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("app initied");
        }
        MediaController.getInstance();
        for (int i2 = 0; i2 < 3; i2++) {
            ContactsController.getInstance(i2).checkAppAccount();
            DownloadController.getInstance(i2);
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ApplicationLoader$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                WearDataLayerListenerService.updateWatchConnectionState();
            }
        });
    }

    public static void checkAndinitHandler() {
        try {
            if (applicationHandler == null) {
                applicationHandler = new Handler(applicationContext.getMainLooper());
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        applicationLoaderInstance = this;
        try {
            applicationContext = getApplicationContext();
        } catch (Throwable unused) {
        }
        super.onCreate();
        FirebaseApp.initializeApp(this);
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
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ApplicationLoader.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    RxJavaPlugins.setErrorHandler(new Consumer() { // from class: org.rbmain.messenger.ApplicationLoader$4$$ExternalSyntheticLambda0
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            MyLog.handleException((Throwable) obj);
                        }
                    });
                } catch (Exception unused2) {
                }
            }
        }, 200L);
        new ForegroundDetector(this) { // from class: org.rbmain.messenger.ApplicationLoader.5
            @Override // org.rbmain.ui.Components.ForegroundDetector, android.app.Application.ActivityLifecycleCallbacks
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
        IdStorageDatabaseHelper.getInstance(UserConfig.selectedAccount);
        applicationHandler = new Handler(applicationContext.getMainLooper());
        setRubinoApiUrl();
        setHomeApiUrl();
        setDCApiUrl();
        setGatewayApiUrl();
        ViewPump.init(ViewPump.builder().addInterceptor(new CalligraphyInterceptor(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/iranyekanwebregular.ttf").setFontAttrId(ir.medu.shad.R.attr.fontPath).build())).build());
        scheduleGetTokenWorker();
    }

    private void setDCApiUrl() {
        if (ir.resaneh1.iptv.logger.MyLog.isDebugAble) {
            return;
        }
        SecureRandom secureRandom = Utilities.random;
        ArrayList<String> arrayList = AppFavorUtils.GET_DC_MESS_URL_ARRAY;
        AppFavorUtils.GET_DC_MESS_URL = arrayList.get(secureRandom.nextInt(arrayList.size()));
    }

    private void setGatewayApiUrl() {
        if (ir.resaneh1.iptv.logger.MyLog.isDebugAble) {
            return;
        }
        SecureRandom secureRandom = Utilities.random;
        ArrayList<String> arrayList = AppFavorUtils.GATEWAY_URL_ARRAY;
        AppFavorUtils.GATEWAY_URL = arrayList.get(secureRandom.nextInt(arrayList.size()));
    }

    private void setRubinoApiUrl() {
        SecureRandom secureRandom = Utilities.random;
        ArrayList<String> arrayList = AppFavorUtils.rubinoUrlArray;
        AppFavorUtils.rubinoUrl = arrayList.get(secureRandom.nextInt(arrayList.size()));
    }

    private void setHomeApiUrl() {
        if (MyLog.isDebugAble) {
            return;
        }
        AppFavorUtils.SERVICE_EXTERNAL_URL = AppFavorUtils.SERVICE_EXTERNAL_URL_Array.get(Utilities.random.nextInt(AppFavorUtils.SERVICE_EXTERNAL_URL_Array.size()));
    }

    public static void startPushService() {
        boolean z;
        SharedPreferences globalNotificationsSettings = MessagesController.getGlobalNotificationsSettings();
        if (globalNotificationsSettings.contains("pushService")) {
            z = globalNotificationsSettings.getBoolean("pushService", true);
        } else {
            z = MessagesController.getMainSettings(UserConfig.selectedAccount).getBoolean("keepAliveService", false);
        }
        if (z) {
            try {
                applicationContext.startService(new Intent(applicationContext, (Class<?>) NotificationsService.class));
            } catch (Throwable unused) {
            }
        } else {
            applicationContext.stopService(new Intent(applicationContext, (Class<?>) NotificationsService.class));
            ((AlarmManager) applicationContext.getSystemService("alarm")).cancel(PendingIntentUtils.getPendingIntentService(applicationContext, 0, new Intent(applicationContext, (Class<?>) NotificationsService.class), 0));
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            LocaleController.getInstance().onDeviceConfigurationChange(configuration);
            AndroidUtilities.checkDisplaySize(applicationContext, configuration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initPlayServices() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ApplicationLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initPlayServices$1();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPlayServices$1() {
        boolean zCheckPlayServices = checkPlayServices();
        hasPlayServices = zCheckPlayServices;
        if (zCheckPlayServices) {
            String str = SharedConfig.pushString;
            if (!TextUtils.isEmpty(str)) {
                if (BuildVars.DEBUG_PRIVATE_VERSION && BuildVars.LOGS_ENABLED) {
                    FileLog.d("GCM regId = " + str);
                }
            } else if (BuildVars.LOGS_ENABLED) {
                FileLog.d("GCM Registration not found.");
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ApplicationLoader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ApplicationLoader.lambda$initPlayServices$0();
                }
            });
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("No valid Google Play Services APK found.");
        }
        SharedConfig.pushStringStatus = "__NO_GOOGLE_PLAY_SERVICES__";
        GcmPushListenerService.sendRegistrationToServer(null);
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
    public static void ensureCurrentNetworkGet(boolean z) {
        if (z || currentNetworkInfo == null) {
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

    private void scheduleGetTokenWorker() {
        RegisterDeviceWorker.scheduleNextWorker(this, ExistingWorkPolicy.KEEP, 60L);
    }
}
