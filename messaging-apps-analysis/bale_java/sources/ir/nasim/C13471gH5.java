package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.gH5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13471gH5 {
    private final String a;
    private final boolean b;
    private final Drawable c;
    private final Drawable d;

    public C13471gH5(String str, boolean z, Drawable drawable, Drawable drawable2) {
        AbstractC13042fc3.i(str, "emojiCode");
        AbstractC13042fc3.i(drawable2, "placeholder");
        this.a = str;
        this.b = z;
        this.c = drawable;
        this.d = drawable2;
    }

    public final String a() {
        return this.a;
    }

    public final Drawable b() {
        return this.c;
    }

    public final Drawable c() {
        return this.d;
    }

    public final boolean d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13471gH5)) {
            return false;
        }
        C13471gH5 c13471gH5 = (C13471gH5) obj;
        return AbstractC13042fc3.d(this.a, c13471gH5.a) && this.b == c13471gH5.b && AbstractC13042fc3.d(this.c, c13471gH5.c) && AbstractC13042fc3.d(this.d, c13471gH5.d);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31;
        Drawable drawable = this.c;
        return ((iHashCode + (drawable == null ? 0 : drawable.hashCode())) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ReactionItem(emojiCode=" + this.a + ", isReacted=" + this.b + ", emojiDrawable=" + this.c + ", placeholder=" + this.d + Separators.RPAREN;
    }
}
