package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class AF1 {
    public static final a d = new a(null);
    private static final AF1 e = new AF1(EnumC15002iq4.b, false, null);
    private final EnumC15002iq4 a;
    private final boolean b;
    private final XF6 c;

    public static final class a {
        private a() {
        }

        public final AF1 a() {
            return AF1.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public AF1(EnumC15002iq4 enumC15002iq4, boolean z, XF6 xf6) {
        AbstractC13042fc3.i(enumC15002iq4, "defaultTab");
        this.a = enumC15002iq4;
        this.b = z;
        this.c = xf6;
    }

    public static /* synthetic */ AF1 c(AF1 af1, EnumC15002iq4 enumC15002iq4, boolean z, XF6 xf6, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC15002iq4 = af1.a;
        }
        if ((i & 2) != 0) {
            z = af1.b;
        }
        if ((i & 4) != 0) {
            xf6 = af1.c;
        }
        return af1.b(enumC15002iq4, z, xf6);
    }

    public final AF1 b(EnumC15002iq4 enumC15002iq4, boolean z, XF6 xf6) {
        AbstractC13042fc3.i(enumC15002iq4, "defaultTab");
        return new AF1(enumC15002iq4, z, xf6);
    }

    public final EnumC15002iq4 d() {
        return this.a;
    }

    public final boolean e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AF1)) {
            return false;
        }
        AF1 af1 = (AF1) obj;
        return this.a == af1.a && this.b == af1.b && this.c == af1.c;
    }

    public final XF6 f() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31;
        XF6 xf6 = this.c;
        return iHashCode + (xf6 == null ? 0 : xf6.hashCode());
    }

    public String toString() {
        return "DefaultTabUiState(defaultTab=" + this.a + ", showLoading=" + this.b + ", snackBarState=" + this.c + Separators.RPAREN;
    }
}
