package ir.nasim;

import ir.nasim.C9475a16;

/* loaded from: classes8.dex */
public abstract class FJ6 {
    private static final StackTraceElement a = new C13492gK().a();
    private static final String b;
    private static final String c;

    static {
        Object objB;
        Object objB2;
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(E90.class.getCanonicalName());
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.e(objB) != null) {
            objB = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        b = (String) objB;
        try {
            objB2 = C9475a16.b(FJ6.class.getCanonicalName());
        } catch (Throwable th2) {
            C9475a16.a aVar3 = C9475a16.b;
            objB2 = C9475a16.b(AbstractC10685c16.a(th2));
        }
        if (C9475a16.e(objB2) != null) {
            objB2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        c = (String) objB2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
