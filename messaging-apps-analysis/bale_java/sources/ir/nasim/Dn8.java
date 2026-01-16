package ir.nasim;

import android.content.SharedPreferences;
import android.util.Log;

/* loaded from: classes3.dex */
public abstract class Dn8 extends AbstractC13124fh8 {
    public static Long a(SharedPreferences sharedPreferences, String str, Long l) {
        try {
            return (Long) AbstractC9931an8.a(new CallableC16167ko8(sharedPreferences, str, l));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return l;
        }
    }
}
