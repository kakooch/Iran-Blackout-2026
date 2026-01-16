package ir.nasim;

import android.graphics.ColorFilter;

/* renamed from: ir.nasim.Rg0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7328Rg0 extends AbstractC24975zX0 {
    private final long c;
    private final int d;

    public /* synthetic */ C7328Rg0(long j, int i, ColorFilter colorFilter, ED1 ed1) {
        this(j, i, colorFilter);
    }

    public final int b() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7328Rg0)) {
            return false;
        }
        C7328Rg0 c7328Rg0 = (C7328Rg0) obj;
        return C24381yX0.q(this.c, c7328Rg0.c) && AbstractC7094Qg0.E(this.d, c7328Rg0.d);
    }

    public int hashCode() {
        return (C24381yX0.w(this.c) * 31) + AbstractC7094Qg0.F(this.d);
    }

    public String toString() {
        return "BlendModeColorFilter(color=" + ((Object) C24381yX0.x(this.c)) + ", blendMode=" + ((Object) AbstractC7094Qg0.G(this.d)) + ')';
    }

    public /* synthetic */ C7328Rg0(long j, int i, ED1 ed1) {
        this(j, i);
    }

    private C7328Rg0(long j, int i, ColorFilter colorFilter) {
        super(colorFilter);
        this.c = j;
        this.d = i;
    }

    private C7328Rg0(long j, int i) {
        this(j, i, AbstractC8831Xn.a(j, i), null);
    }
}
