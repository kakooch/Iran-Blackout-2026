package ir.nasim;

import android.content.SharedPreferences;
import android.util.Log;

/* renamed from: ir.nasim.yj8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC24506yj8 extends AbstractC13124fh8 {
    public static Boolean a(SharedPreferences sharedPreferences, String str, Boolean bool) {
        try {
            return (Boolean) AbstractC9931an8.a(new Xk8(sharedPreferences, str, bool));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return bool;
        }
    }
}
