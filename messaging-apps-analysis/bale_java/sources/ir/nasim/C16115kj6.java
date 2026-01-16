package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.kj6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C16115kj6 {
    private final boolean a;
    private final boolean b;
    private final boolean c;

    public C16115kj6(boolean z, boolean z2, boolean z3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
    }

    public static /* synthetic */ C16115kj6 b(C16115kj6 c16115kj6, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = c16115kj6.a;
        }
        if ((i & 2) != 0) {
            z2 = c16115kj6.b;
        }
        if ((i & 4) != 0) {
            z3 = c16115kj6.c;
        }
        return c16115kj6.a(z, z2, z3);
    }

    public final C16115kj6 a(boolean z, boolean z2, boolean z3) {
        return new C16115kj6(z, z2, z3);
    }

    public final boolean c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    public final boolean e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16115kj6)) {
            return false;
        }
        C16115kj6 c16115kj6 = (C16115kj6) obj;
        return this.a == c16115kj6.a && this.b == c16115kj6.b && this.c == c16115kj6.c;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "SecurityMxpSwitchState(checked=" + this.a + ", loading=" + this.b + ", showConfirmDialog=" + this.c + Separators.RPAREN;
    }
}
