package ir.nasim;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.t02, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21036t02 implements RW5 {
    private final InterfaceC13106fg0 a;
    private final RW5 b;
    private final RW5 c;

    public C21036t02(InterfaceC13106fg0 interfaceC13106fg0, RW5 rw5, RW5 rw52) {
        this.a = interfaceC13106fg0;
        this.b = rw5;
        this.c = rw52;
    }

    @Override // ir.nasim.RW5
    public DW5 a(DW5 dw5, HL4 hl4) {
        Drawable drawable = (Drawable) dw5.get();
        if (drawable instanceof BitmapDrawable) {
            return this.b.a(C14288hg0.d(((BitmapDrawable) drawable).getBitmap(), this.a), hl4);
        }
        if (drawable instanceof C11598dH2) {
            return this.c.a(b(dw5), hl4);
        }
        return null;
    }

    private static DW5 b(DW5 dw5) {
        return dw5;
    }
}
