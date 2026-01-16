package ir.nasim;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import ir.nasim.tgwidgets.editor.messenger.NativeLoader;
import java.io.File;

/* renamed from: ir.nasim.hG, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC14047hG {
    public static volatile Context a = null;
    public static volatile Handler b = null;
    public static volatile boolean c = true;
    public static volatile boolean d = true;

    public static String a() {
        return null;
    }

    public static File b() {
        for (int i = 0; i < 10; i++) {
            File filesDir = a.getFilesDir();
            if (filesDir != null) {
                return filesDir;
            }
        }
        try {
            File file = new File(a.getApplicationInfo().dataDir, "files");
            file.mkdirs();
            return file;
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
            return new File("/data/data/ir.nasim/files/tgwidgets");
        }
    }

    public static boolean c() {
        return d();
    }

    public static boolean d() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) a.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || (!activeNetworkInfo.isConnectedOrConnecting() && !activeNetworkInfo.isAvailable())) {
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
            AbstractC6403Nl2.d(e);
            return true;
        }
    }

    public static void e() {
        c = true;
        d = true;
    }

    public static void f() {
        c = false;
        d = false;
    }

    public static void g(Context context) {
        a = context;
        b = new Handler(a.getMainLooper());
        NativeLoader.b(a);
    }
}
