package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.hV6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14189hV6 {
    private final int a;
    private final boolean b;

    public C14189hV6(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public final int a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14189hV6)) {
            return false;
        }
        C14189hV6 c14189hV6 = (C14189hV6) obj;
        return this.a == c14189hV6.a && this.b == c14189hV6.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "StoryTag(id=" + this.a + ", isSpecial=" + this.b + Separators.RPAREN;
    }
}
