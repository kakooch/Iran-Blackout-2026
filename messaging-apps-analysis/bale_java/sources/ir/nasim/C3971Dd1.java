package ir.nasim;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: ir.nasim.Dd1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3971Dd1 {
    public static int a = 1;
    private static volatile C3971Dd1 b;

    public static C3971Dd1 c() {
        C3971Dd1 c3971Dd1 = b;
        if (c3971Dd1 == null) {
            synchronized (C3971Dd1.class) {
                try {
                    c3971Dd1 = b;
                    if (c3971Dd1 == null) {
                        c3971Dd1 = new C3971Dd1();
                        b = c3971Dd1;
                    }
                } finally {
                }
            }
        }
        return c3971Dd1;
    }

    public static boolean d() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) C5721Ko.b.getSystemService("connectivity");
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
            C19406qI3.d("baleMessages", e);
            return true;
        }
    }

    public int a() {
        int i = a;
        a = i + 1;
        return i;
    }

    public int b() {
        return (int) (System.currentTimeMillis() / 1000);
    }
}
