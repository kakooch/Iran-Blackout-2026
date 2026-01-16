package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17019mF7 extends AbstractC20556sC7 {
    private final boolean a;
    private final boolean b;
    private final boolean c;

    public C17019mF7(boolean z, boolean z2, boolean z3) {
        super(null);
        this.a = z;
        this.b = z2;
        this.c = z3;
    }

    public final boolean a() {
        return this.c;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17019mF7)) {
            return false;
        }
        C17019mF7 c17019mF7 = (C17019mF7) obj;
        return this.a == c17019mF7.a && this.b == c17019mF7.b && this.c == c17019mF7.c;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "UpdatePremiumPurchaseStatus(isSuccess=" + this.a + ", isPending=" + this.b + ", isFailed=" + this.c + Separators.RPAREN;
    }
}
