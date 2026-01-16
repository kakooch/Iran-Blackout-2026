package ir.nasim;

/* renamed from: ir.nasim.Al6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3341Al6 {
    public static final AbstractC23344wl6 b(Object obj) {
        if (obj == AbstractC3494Bc1.a) {
            throw new IllegalStateException("Does not contain segment".toString());
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (AbstractC23344wl6) obj;
    }

    public static final boolean c(Object obj) {
        return obj == AbstractC3494Bc1.a;
    }

    public static Object a(Object obj) {
        return obj;
    }
}
