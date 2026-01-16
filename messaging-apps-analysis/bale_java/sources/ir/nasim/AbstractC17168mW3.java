package ir.nasim;

import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.mW3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17168mW3 extends AbstractC22597vW1 {
    private final Drawable a;
    private final byte[] b;
    private XV4 c;

    public AbstractC17168mW3(Drawable drawable, byte[] bArr, XV4 xv4) {
        AbstractC13042fc3.i(xv4, "measuredSize");
        this.a = drawable;
        this.b = bArr;
        this.c = xv4;
    }

    public static /* synthetic */ void A(AbstractC17168mW3 abstractC17168mW3, byte[] bArr, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadThumbnail");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        abstractC17168mW3.z(bArr, z);
    }

    public void B(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "measuredWidthAndHeight");
        if (AbstractC13042fc3.d(this.c, xv4)) {
            return;
        }
        this.c = xv4;
        z(this.b, false);
    }

    protected final void C(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "<set-?>");
        this.c = xv4;
    }

    protected final XV4 v() {
        return this.c;
    }

    protected final Drawable w() {
        return this.a;
    }

    protected final byte[] x() {
        return this.b;
    }

    protected final C20107rU5 y(boolean z) {
        C20107rU5 c20107rU5 = (C20107rU5) ((C20107rU5) new C20107rU5().c0(((Number) this.c.e()).intValue(), ((Number) this.c.f()).intValue())).y0(new C5191Ih0(10, 3), new LH0());
        if (z) {
            c20107rU5 = (C20107rU5) c20107rU5.f0(this.a);
        }
        AbstractC13042fc3.h(c20107rU5, "let(...)");
        return c20107rU5;
    }

    public abstract void z(byte[] bArr, boolean z);
}
