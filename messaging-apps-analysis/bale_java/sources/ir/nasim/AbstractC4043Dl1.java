package ir.nasim;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Dl1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4043Dl1 {
    private static final Object a = new Object();

    /* renamed from: ir.nasim.Dl1$a */
    static class a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        static Drawable b(Context context, int i) {
            return context.getDrawable(i);
        }

        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* renamed from: ir.nasim.Dl1$b */
    static class b {
        static int a(Context context, int i) {
            return context.getColor(i);
        }

        static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    /* renamed from: ir.nasim.Dl1$c */
    static class c {
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        static File b(Context context) {
            return context.getDataDir();
        }

        static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    /* renamed from: ir.nasim.Dl1$d */
    static class d {
        static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
            return ((i & 4) == 0 || str != null) ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i & 1) : context.registerReceiver(broadcastReceiver, intentFilter, AbstractC4043Dl1.m(context), handler);
        }

        static ComponentName b(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    /* renamed from: ir.nasim.Dl1$e */
    static class e {
        static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    public static int a(Context context, String str) {
        FG4.d(str, "permission must be non-null");
        return (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : AD4.e(context).a() ? 0 : -1;
    }

    public static Context b(Context context) {
        return c.a(context);
    }

    public static int c(Context context, int i) {
        return b.a(context, i);
    }

    public static ColorStateList d(Context context, int i) {
        return VW5.e(context.getResources(), i, context.getTheme());
    }

    public static Context e(Context context) {
        JH3 jh3A = OH3.a(context);
        if (Build.VERSION.SDK_INT > 32 || jh3A.e()) {
            return context;
        }
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        AbstractC9243Zc1.b(configuration, jh3A);
        return context.createConfigurationContext(configuration);
    }

    public static Drawable f(Context context, int i) {
        return a.b(context, i);
    }

    public static File[] g(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] h(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static Executor i(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? e.a(context) : AbstractC11035cd2.a(new Handler(context.getMainLooper()));
    }

    public static File j(Context context) {
        return a.c(context);
    }

    public static String k(Context context, int i) {
        return e(context).getString(i);
    }

    public static Object l(Context context, Class cls) {
        return b.b(context, cls);
    }

    static String m(Context context) {
        String str = context.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (F35.c(context, str) == 0) {
            return str;
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    public static boolean n(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static void o(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void p(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            d.b(context, intent);
        } else {
            context.startService(intent);
        }
    }
}
