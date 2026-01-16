package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.qV6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C19526qV6 {
    private final int a;
    private final Drawable b;
    private final boolean c;
    private final boolean d;

    public C19526qV6(int i, Drawable drawable, boolean z, boolean z2) {
        AbstractC13042fc3.i(drawable, "badgeDrawable");
        this.a = i;
        this.b = drawable;
        this.c = z;
        this.d = z2;
    }

    public static /* synthetic */ C19526qV6 b(C19526qV6 c19526qV6, int i, Drawable drawable, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = c19526qV6.a;
        }
        if ((i2 & 2) != 0) {
            drawable = c19526qV6.b;
        }
        if ((i2 & 4) != 0) {
            z = c19526qV6.c;
        }
        if ((i2 & 8) != 0) {
            z2 = c19526qV6.d;
        }
        return c19526qV6.a(i, drawable, z, z2);
    }

    public final C19526qV6 a(int i, Drawable drawable, boolean z, boolean z2) {
        AbstractC13042fc3.i(drawable, "badgeDrawable");
        return new C19526qV6(i, drawable, z, z2);
    }

    public final Drawable c() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }

    public final boolean e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19526qV6)) {
            return false;
        }
        C19526qV6 c19526qV6 = (C19526qV6) obj;
        return this.a == c19526qV6.a && AbstractC13042fc3.d(this.b, c19526qV6.b) && this.c == c19526qV6.c && this.d == c19526qV6.d;
    }

    public final boolean f() {
        return this.d;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "StoryTagEditor(id=" + this.a + ", badgeDrawable=" + this.b + ", isEnabled=" + this.c + ", isSpecial=" + this.d + Separators.RPAREN;
    }
}
