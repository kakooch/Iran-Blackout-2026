package ir.nasim;

/* renamed from: ir.nasim.yx5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC24641yx5 extends AbstractC20998sx5 {
    protected AbstractC24641yx5(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC20998sx5
    public final AbstractC20998sx5 a(C9207Yy1 c9207Yy1) {
        e(c9207Yy1);
        return this;
    }

    @Override // ir.nasim.AbstractC20998sx5
    public final void c(C12658ez1 c12658ez1) {
        byte bD = d();
        if (bD != 0) {
            c12658ez1.d(bD);
        }
        f(c12658ez1);
    }

    protected abstract byte d();

    protected abstract void e(C9207Yy1 c9207Yy1);

    protected abstract void f(C12658ez1 c12658ez1);

    protected AbstractC24641yx5() {
    }
}
