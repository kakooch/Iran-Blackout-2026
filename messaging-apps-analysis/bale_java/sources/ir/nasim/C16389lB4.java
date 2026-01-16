package ir.nasim;

import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.lB4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C16389lB4 extends D02 {
    private C16389lB4(Drawable drawable) {
        super(drawable);
    }

    static DW5 d(Drawable drawable) {
        if (drawable != null) {
            return new C16389lB4(drawable);
        }
        return null;
    }

    @Override // ir.nasim.DW5
    public Class b() {
        return this.a.getClass();
    }

    @Override // ir.nasim.DW5
    public int f() {
        return Math.max(1, this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight() * 4);
    }

    @Override // ir.nasim.DW5
    public void a() {
    }
}
