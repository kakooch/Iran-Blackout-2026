package ir.nasim;

import android.os.Trace;

/* renamed from: ir.nasim.qt7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19762qt7 {
    public static void a(String str) {
        if (AbstractC9683aN7.a >= 18) {
            b(str);
        }
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (AbstractC9683aN7.a >= 18) {
            d();
        }
    }

    private static void d() {
        Trace.endSection();
    }
}
