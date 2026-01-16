package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Xr2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8870Xr2 {
    private final int a;
    private final String b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;

    public C8870Xr2(int i, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        AbstractC13042fc3.i(str, "name");
        this.a = i;
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = z4;
    }

    public static /* synthetic */ C8870Xr2 b(C8870Xr2 c8870Xr2, int i, String str, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = c8870Xr2.a;
        }
        if ((i2 & 2) != 0) {
            str = c8870Xr2.b;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            z = c8870Xr2.c;
        }
        boolean z5 = z;
        if ((i2 & 8) != 0) {
            z2 = c8870Xr2.d;
        }
        boolean z6 = z2;
        if ((i2 & 16) != 0) {
            z3 = c8870Xr2.e;
        }
        boolean z7 = z3;
        if ((i2 & 32) != 0) {
            z4 = c8870Xr2.f;
        }
        return c8870Xr2.a(i, str2, z5, z6, z7, z4);
    }

    public final C8870Xr2 a(int i, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        AbstractC13042fc3.i(str, "name");
        return new C8870Xr2(i, str, z, z2, z3, z4);
    }

    public final int c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public final boolean e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8870Xr2)) {
            return false;
        }
        C8870Xr2 c8870Xr2 = (C8870Xr2) obj;
        return this.a == c8870Xr2.a && AbstractC13042fc3.d(this.b, c8870Xr2.b) && this.c == c8870Xr2.c && this.d == c8870Xr2.d && this.e == c8870Xr2.e && this.f == c8870Xr2.f;
    }

    public final boolean f() {
        return this.e;
    }

    public final boolean g() {
        return this.f;
    }

    public final boolean h() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "FolderDTO(id=" + this.a + ", name=" + this.b + ", isReservedFolder=" + this.c + ", isActive=" + this.d + ", isLoading=" + this.e + ", isMenuExpanded=" + this.f + Separators.RPAREN;
    }

    public /* synthetic */ C8870Xr2(int i, String str, boolean z, boolean z2, boolean z3, boolean z4, int i2, ED1 ed1) {
        this(i, str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? false : z3, (i2 & 32) != 0 ? false : z4);
    }
}
