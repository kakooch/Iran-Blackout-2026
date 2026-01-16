package ir.nasim;

/* renamed from: ir.nasim.ym7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24535ym7 {
    public static final C13245fu a(C23945xm7 c23945xm7) {
        return c23945xm7.e().t(c23945xm7.g());
    }

    public static final C13245fu b(C23945xm7 c23945xm7, int i) {
        return c23945xm7.e().subSequence(C4301En7.k(c23945xm7.g()), Math.min(C4301En7.k(c23945xm7.g()) + i, c23945xm7.h().length()));
    }

    public static final C13245fu c(C23945xm7 c23945xm7, int i) {
        return c23945xm7.e().subSequence(Math.max(0, C4301En7.l(c23945xm7.g()) - i), C4301En7.l(c23945xm7.g()));
    }
}
