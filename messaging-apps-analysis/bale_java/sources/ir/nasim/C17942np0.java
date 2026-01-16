package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.np0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17942np0 {
    private final float a;
    private final float b;

    public C17942np0(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public final float a() {
        return this.b;
    }

    public final float b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17942np0)) {
            return false;
        }
        C17942np0 c17942np0 = (C17942np0) obj;
        return Float.compare(this.a, c17942np0.a) == 0 && Float.compare(this.b, c17942np0.b) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.a) * 31) + Float.hashCode(this.b);
    }

    public String toString() {
        return "CacheSpan(startPosition=" + this.a + ", endPosition=" + this.b + Separators.RPAREN;
    }
}
