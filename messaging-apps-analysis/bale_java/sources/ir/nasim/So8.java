package ir.nasim;

import android.content.SharedPreferences;
import android.util.Log;

/* loaded from: classes3.dex */
public abstract class So8 extends AbstractC13124fh8 {
    public static String a(SharedPreferences sharedPreferences, String str, String str2) {
        try {
            return (String) AbstractC9931an8.a(new CallableC9964aq8(sharedPreferences, str, str2));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return str2;
        }
    }
}
