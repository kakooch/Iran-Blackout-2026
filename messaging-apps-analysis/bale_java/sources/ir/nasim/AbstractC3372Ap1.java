package ir.nasim;

import android.content.Context;
import android.util.Log;

/* renamed from: ir.nasim.Ap1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3372Ap1 {
    private static final String[] a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    public static boolean a(Context context, Throwable th) {
        try {
            AbstractC3795Cj5.j(context);
            AbstractC3795Cj5.j(th);
            return false;
        } catch (Exception e) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
            return false;
        }
    }
}
