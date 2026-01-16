package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

/* renamed from: ir.nasim.zK1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC24859zK1 {
    static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            return false;
        }
        return b(context, str, AbstractC10158bA5.assume_strong_biometrics_models);
    }

    private static boolean b(Context context, String str, int i) throws Resources.NotFoundException {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i)) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(Context context, String str, int i) throws Resources.NotFoundException {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i)) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean d(Context context, String str, int i) throws Resources.NotFoundException {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i)) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    static boolean e(Context context, String str) {
        if (Build.VERSION.SDK_INT != 29) {
            return false;
        }
        return b(context, str, AbstractC10158bA5.delay_showing_prompt_models);
    }

    static boolean f(Context context, String str) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return c(context, str, AbstractC10158bA5.hide_fingerprint_instantly_prefixes);
    }

    static boolean g(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return d(context, str, AbstractC10158bA5.crypto_fingerprint_fallback_vendors) || c(context, str2, AbstractC10158bA5.crypto_fingerprint_fallback_prefixes);
    }
}
