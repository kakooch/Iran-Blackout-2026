package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Ry1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C7491Ry1 {
    private final int a;
    private final int b;

    public C7491Ry1(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C7491Ry1)) {
            return false;
        }
        C7491Ry1 c7491Ry1 = (C7491Ry1) obj;
        return this.a == c7491Ry1.a && this.b == c7491Ry1.b;
    }

    public final int hashCode() {
        return this.a ^ this.b;
    }

    public final String toString() {
        return this.a + Separators.LPAREN + this.b + ')';
    }
}
