package ir.nasim;

import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.ea2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12412ea2 extends Y23 {
    private final Drawable a;
    private final W23 b;
    private final Throwable c;

    public C12412ea2(Drawable drawable, W23 w23, Throwable th) {
        super(null);
        this.a = drawable;
        this.b = w23;
        this.c = th;
    }

    @Override // ir.nasim.Y23
    public Drawable a() {
        return this.a;
    }

    @Override // ir.nasim.Y23
    public W23 b() {
        return this.b;
    }

    public final Throwable c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C12412ea2) {
            C12412ea2 c12412ea2 = (C12412ea2) obj;
            if (AbstractC13042fc3.d(a(), c12412ea2.a()) && AbstractC13042fc3.d(b(), c12412ea2.b()) && AbstractC13042fc3.d(this.c, c12412ea2.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Drawable drawableA = a();
        return ((((drawableA != null ? drawableA.hashCode() : 0) * 31) + b().hashCode()) * 31) + this.c.hashCode();
    }
}
