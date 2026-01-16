package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public abstract class Bq8 {
    private static SharedPreferences a;

    public static SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            try {
                if (a == null) {
                    a = (SharedPreferences) AbstractC9931an8.a(new CallableC10591br8(context));
                }
                sharedPreferences = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sharedPreferences;
    }
}
