package ir.nasim;

import android.content.SharedPreferences;
import android.util.Log;

/* loaded from: classes3.dex */
public abstract class Vl8 extends AbstractC13124fh8 {
    public static Integer a(SharedPreferences sharedPreferences, String str, Integer num) {
        try {
            return (Integer) AbstractC9931an8.a(new Vm8(sharedPreferences, str, num));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return num;
        }
    }
}
