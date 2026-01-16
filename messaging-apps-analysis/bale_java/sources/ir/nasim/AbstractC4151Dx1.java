package ir.nasim;

import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Dx1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4151Dx1 implements InterfaceC21549tj7 {
    private final int a;
    private final int b;
    private RP5 c;

    public AbstractC4151Dx1() {
        this(RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION);
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public final RP5 getRequest() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public final void h(YD6 yd6) {
        yd6.d(this.a, this.b);
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public final void l(RP5 rp5) {
        this.c = rp5;
    }

    public AbstractC4151Dx1(int i, int i2) {
        if (YM7.v(i, i2)) {
            this.a = i;
            this.b = i2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void f() {
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void i() {
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void onDestroy() {
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public final void c(YD6 yd6) {
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public void e(Drawable drawable) {
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public void k(Drawable drawable) {
    }
}
