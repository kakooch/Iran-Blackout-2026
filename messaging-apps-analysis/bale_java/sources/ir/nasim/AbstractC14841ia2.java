package ir.nasim;

import android.content.Context;
import android.util.Log;

/* renamed from: ir.nasim.ia2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC14841ia2 {
    static String a(Context context, int i) {
        if (context == null) {
            return "";
        }
        if (i == 1) {
            return context.getString(ND5.fingerprint_error_hw_not_available);
        }
        if (i != 7) {
            switch (i) {
                case 9:
                    break;
                case 10:
                    return context.getString(ND5.fingerprint_error_user_canceled);
                case 11:
                    return context.getString(ND5.fingerprint_error_no_fingerprints);
                case 12:
                    return context.getString(ND5.fingerprint_error_hw_not_present);
                default:
                    Log.e("BiometricUtils", "Unknown error code: " + i);
                    return context.getString(ND5.default_error_msg);
            }
        }
        return context.getString(ND5.fingerprint_error_lockout);
    }

    static boolean b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            case 6:
            default:
                return false;
        }
    }

    static boolean c(int i) {
        return i == 7 || i == 9;
    }
}
