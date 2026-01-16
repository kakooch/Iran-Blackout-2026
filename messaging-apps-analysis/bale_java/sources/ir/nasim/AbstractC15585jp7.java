package ir.nasim;

import android.os.Looper;

/* renamed from: ir.nasim.jp7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC15585jp7 {
    private static final long a;

    static {
        long id;
        try {
            id = Looper.getMainLooper().getThread().getId();
        } catch (Exception unused) {
            id = -1;
        }
        a = id;
    }

    public static final long a() {
        return a;
    }
}
