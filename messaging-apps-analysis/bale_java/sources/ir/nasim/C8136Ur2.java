package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Ur2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8136Ur2 {
    private final boolean a;
    private final boolean b;
    private final boolean c;

    public C8136Ur2(boolean z, boolean z2, boolean z3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
    }

    public static /* synthetic */ C8136Ur2 b(C8136Ur2 c8136Ur2, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = c8136Ur2.a;
        }
        if ((i & 2) != 0) {
            z2 = c8136Ur2.b;
        }
        if ((i & 4) != 0) {
            z3 = c8136Ur2.c;
        }
        return c8136Ur2.a(z, z2, z3);
    }

    public final C8136Ur2 a(boolean z, boolean z2, boolean z3) {
        return new C8136Ur2(z, z2, z3);
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean d() {
        return this.a;
    }

    public final boolean e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8136Ur2)) {
            return false;
        }
        C8136Ur2 c8136Ur2 = (C8136Ur2) obj;
        return this.a == c8136Ur2.a && this.b == c8136Ur2.b && this.c == c8136Ur2.c;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "FolderBottomSheet(addToFolder=" + this.a + ", addFolder=" + this.b + ", createFolder=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C8136Ur2(boolean z, boolean z2, boolean z3, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }
}
