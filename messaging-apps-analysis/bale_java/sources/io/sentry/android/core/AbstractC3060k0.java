package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.gov.nist.core.Separators;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.Y2;
import io.sentry.android.core.util.a;
import io.sentry.protocol.C3166a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: io.sentry.android.core.k0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3060k0 {
    private static final io.sentry.android.core.util.a a = new io.sentry.android.core.util.a(new a.InterfaceC0230a() { // from class: io.sentry.android.core.g0
        @Override // io.sentry.android.core.util.a.InterfaceC0230a
        public final Object a(Context context) {
            return AbstractC3060k0.t(context);
        }
    });
    private static final io.sentry.android.core.util.a b = new io.sentry.android.core.util.a(new a.InterfaceC0230a() { // from class: io.sentry.android.core.h0
        @Override // io.sentry.android.core.util.a.InterfaceC0230a
        public final Object a(Context context) {
            return AbstractC3060k0.u(context);
        }
    });
    private static final io.sentry.android.core.util.a c = new io.sentry.android.core.util.a(new a.InterfaceC0230a() { // from class: io.sentry.android.core.i0
        @Override // io.sentry.android.core.util.a.InterfaceC0230a
        public final Object a(Context context) {
            return AbstractC3060k0.v(context);
        }
    });
    private static final io.sentry.android.core.util.a d = new io.sentry.android.core.util.a(new a.InterfaceC0230a() { // from class: io.sentry.android.core.j0
        @Override // io.sentry.android.core.util.a.InterfaceC0230a
        public final Object a(Context context) {
            return AbstractC3060k0.w(context);
        }
    });
    private static final io.sentry.android.core.util.a e = new io.sentry.android.core.util.a(new a.InterfaceC0230a() { // from class: io.sentry.android.core.f0
        @Override // io.sentry.android.core.util.a.InterfaceC0230a
        public final Object a(Context context) {
            return AbstractC3060k0.x(context);
        }
    });

    /* renamed from: io.sentry.android.core.k0$a */
    static class a {
        private final boolean a;
        private final String b;

        public a(boolean z, String str) {
            this.a = z;
            this.b = str;
        }

        public Map a() {
            HashMap map = new HashMap();
            map.put("isSideLoaded", String.valueOf(this.a));
            String str = this.b;
            if (str != null) {
                map.put("installerStore", str);
            }
            return map;
        }
    }

    /* renamed from: io.sentry.android.core.k0$b */
    static class b {
        private final boolean a;
        private final String[] b;

        public b(boolean z, String[] strArr) {
            this.a = z;
            this.b = strArr;
        }

        public String[] a() {
            return this.b;
        }

        public boolean b() {
            return this.a;
        }
    }

    static a A(Context context, ILogger iLogger, Y y) {
        String str;
        try {
            PackageInfo packageInfoP = p(context, y);
            PackageManager packageManager = context.getPackageManager();
            if (packageInfoP != null && packageManager != null) {
                str = packageInfoP.packageName;
                try {
                    String installerPackageName = packageManager.getInstallerPackageName(str);
                    return new a(installerPackageName == null, installerPackageName);
                } catch (IllegalArgumentException unused) {
                    iLogger.c(Y2.DEBUG, "%s package isn't installed.", str);
                    return null;
                }
            }
        } catch (IllegalArgumentException unused2) {
            str = null;
        }
        return null;
    }

    static b B(Context context, Y y) {
        Bundle bundle;
        ApplicationInfo applicationInfoH = h(context, y);
        PackageInfo packageInfoP = p(context, y);
        if (packageInfoP == null) {
            return null;
        }
        return new b((applicationInfoH == null || (bundle = applicationInfoH.metaData) == null) ? false : bundle.getBoolean("com.android.vending.splits.required"), packageInfoP.splitNames);
    }

    static void C(PackageInfo packageInfo, Y y, C3072q0 c3072q0, C3166a c3166a) {
        c3166a.n(packageInfo.packageName);
        c3166a.q(packageInfo.versionName);
        c3166a.m(q(packageInfo, y));
        HashMap map = new HashMap();
        String[] strArr = packageInfo.requestedPermissions;
        int[] iArr = packageInfo.requestedPermissionsFlags;
        if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                map.put(str.substring(str.lastIndexOf(46) + 1), (iArr[i] & 2) == 2 ? "granted" : "not_granted");
            }
        }
        c3166a.s(map);
        if (c3072q0 != null) {
            try {
                b bVarM = c3072q0.m();
                if (bVarM != null) {
                    c3166a.t(Boolean.valueOf(bVarM.b()));
                    if (bVarM.a() != null) {
                        c3166a.u(Arrays.asList(bVarM.a()));
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean f(Context context) {
        if (!context.getPackageName().endsWith(".test")) {
            return false;
        }
        try {
            Iterator<ActivityManager.AppTask> it = ((ActivityManager) context.getSystemService("activity")).getAppTasks().iterator();
            while (it.hasNext()) {
                ComponentName component = it.next().getTaskInfo().baseIntent.getComponent();
                if (component != null && component.getClassName().equals("androidx.compose.ui.tooling.PreviewActivity")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Context g(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    static ApplicationInfo h(Context context, Y y) {
        return y.d() >= 33 ? (ApplicationInfo) d.a(context) : (ApplicationInfo) e.a(context);
    }

    static String i(Context context) {
        return (String) c.a(context);
    }

    static String[] j() {
        return Build.SUPPORTED_ABIS;
    }

    static DisplayMetrics k(Context context, ILogger iLogger) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            iLogger.b(Y2.ERROR, "Error getting DisplayMetrics.", th);
            return null;
        }
    }

    static String l(ILogger iLogger) {
        try {
            return Build.MODEL.split(Separators.SP, -1)[0];
        } catch (Throwable th) {
            iLogger.b(Y2.ERROR, "Error getting device family.", th);
            return null;
        }
    }

    static String m(ILogger iLogger) throws IOException {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                return line;
            } finally {
            }
        } catch (IOException e2) {
            iLogger.b(Y2.ERROR, "Exception while attempting to read kernel information", e2);
            return property;
        }
    }

    static ActivityManager.MemoryInfo n(Context context, ILogger iLogger) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            iLogger.c(Y2.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Throwable th) {
            iLogger.b(Y2.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    static PackageInfo o(Context context, int i, ILogger iLogger, Y y) {
        try {
            return y.d() >= 33 ? context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(i)) : context.getPackageManager().getPackageInfo(context.getPackageName(), i);
        } catch (Throwable th) {
            iLogger.b(Y2.ERROR, "Error getting package info.", th);
            return null;
        }
    }

    static PackageInfo p(Context context, Y y) {
        return y.d() >= 33 ? (PackageInfo) a.a(context) : (PackageInfo) b.a(context);
    }

    static String q(PackageInfo packageInfo, Y y) {
        return y.d() >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : r(packageInfo);
    }

    private static String r(PackageInfo packageInfo) {
        return Integer.toString(packageInfo.versionCode);
    }

    public static boolean s() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            return runningAppProcessInfo.importance == 100;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PackageInfo t(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PackageInfo u(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String v(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i != 0) {
                return context.getString(i);
            }
            CharSequence charSequence = applicationInfo.nonLocalizedLabel;
            return charSequence != null ? charSequence.toString() : context.getPackageManager().getApplicationLabel(applicationInfo).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ApplicationInfo w(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ApplicationInfo x(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Intent y(Context context, C3155n3 c3155n3, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler) {
        return z(context, new Y(c3155n3.getLogger()), broadcastReceiver, intentFilter, handler);
    }

    static Intent z(Context context, Y y, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler) {
        return y.d() >= 33 ? context.registerReceiver(broadcastReceiver, intentFilter, null, handler, 4) : context.registerReceiver(broadcastReceiver, intentFilter, null, handler);
    }
}
