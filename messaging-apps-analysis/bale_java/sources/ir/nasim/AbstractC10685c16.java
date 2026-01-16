package ir.nasim;

import ir.nasim.C9475a16;

/* renamed from: ir.nasim.c16, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10685c16 {
    public static final Object a(Throwable th) {
        AbstractC13042fc3.i(th, "exception");
        return new C9475a16.b(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof C9475a16.b) {
            throw ((C9475a16.b) obj).a;
        }
    }
}
