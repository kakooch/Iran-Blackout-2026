package ir.nasim;

import android.content.Context;

/* loaded from: classes3.dex */
public class Fb8 {
    private static final Fb8 b = new Fb8();
    private JS4 a = null;

    public static JS4 a(Context context) {
        return b.b(context);
    }

    public final synchronized JS4 b(Context context) {
        try {
            if (this.a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.a = new JS4(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.a;
    }
}
