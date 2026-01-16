package ir.nasim;

import android.os.Trace;

/* renamed from: ir.nasim.nt7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17989nt7 {
    public static final C17989nt7 a = new C17989nt7();

    private C17989nt7() {
    }

    public final boolean a() {
        return Trace.isEnabled();
    }

    public final void b(String str, int i) {
        AbstractC13042fc3.i(str, "counterName");
        Trace.setCounter(str, i);
    }
}
