package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class JW7 {
    public static final a f = new a(null);
    private final EnumC9782aY7 a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    public static final class a {
        private a() {
        }

        public final JW7 a(int i) {
            boolean z = (i & 1) == 1;
            boolean z2 = ((i & 2) >> 1) == 1;
            boolean z3 = ((i & 4) >> 2) == 1;
            boolean z4 = ((i & 8) >> 3) == 1;
            int i2 = (i >> 4) - 100;
            if (i2 < 0) {
                return new JW7(EnumC9782aY7.u, z, z2, false, false, 16, null);
            }
            return new JW7(EnumC9782aY7.values()[i2], z, z2, z3, z4);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public JW7(EnumC9782aY7 enumC9782aY7, boolean z, boolean z2, boolean z3, boolean z4) {
        AbstractC13042fc3.i(enumC9782aY7, "type");
        this.a = enumC9782aY7;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
    }

    public final boolean a() {
        return this.c;
    }

    public final boolean b() {
        return this.d;
    }

    public final boolean c() {
        return this.e;
    }

    public final EnumC9782aY7 d() {
        return this.a;
    }

    public final int e() {
        int iOrdinal = (this.a.ordinal() + 100) << 4;
        if (this.b) {
            iOrdinal |= 1;
        }
        if (this.c) {
            iOrdinal |= 2;
        }
        if (this.d) {
            iOrdinal |= 4;
        }
        return this.e ? iOrdinal | 8 : iOrdinal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JW7)) {
            return false;
        }
        JW7 jw7 = (JW7) obj;
        return this.a == jw7.a && this.b == jw7.b && this.c == jw7.c && this.d == jw7.d && this.e == jw7.e;
    }

    public final boolean f() {
        return this.b;
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "ViewHolderType(type=" + this.a + ", isIncoming=" + this.b + ", hasTemplate=" + this.c + ", showChannelForwardIcon=" + this.d + ", showUpVoteIcon=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ JW7(EnumC9782aY7 enumC9782aY7, boolean z, boolean z2, boolean z3, boolean z4, int i, ED1 ed1) {
        this(enumC9782aY7, z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? false : z4);
    }
}
