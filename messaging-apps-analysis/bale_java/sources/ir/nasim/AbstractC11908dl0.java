package ir.nasim;

import android.content.Context;
import android.net.Uri;

/* renamed from: ir.nasim.dl0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC11908dl0 {

    /* renamed from: ir.nasim.dl0$a */
    public static class a {
    }

    public static boolean a(Uri uri, boolean z, boolean[] zArr) {
        return false;
    }

    public static boolean b(String str, boolean z, boolean[] zArr) {
        return a(Uri.parse(str), z, zArr);
    }

    public static boolean c(String str) {
        String lowerCase;
        if (str == null) {
            return false;
        }
        try {
            lowerCase = str.toLowerCase();
        } catch (Throwable unused) {
        }
        if (lowerCase.startsWith("tg:passport") || lowerCase.startsWith("tg://passport") || lowerCase.startsWith("tg:secureid")) {
            return true;
        }
        if (lowerCase.contains("resolve")) {
            if (lowerCase.contains("domain=telegrampassport")) {
                return true;
            }
        }
        return false;
    }

    public static void d(Context context, Uri uri) {
        e(context, uri, true);
    }

    public static void e(Context context, Uri uri, boolean z) {
        f(context, uri, z, true);
    }

    public static void f(Context context, Uri uri, boolean z, boolean z2) {
        g(context, uri, z, z2, false, null);
    }

    public static void h(Context context, String str) {
        if (str == null) {
            return;
        }
        e(context, Uri.parse(str), true);
    }

    public static void g(Context context, Uri uri, boolean z, boolean z2, boolean z3, a aVar) {
    }
}
