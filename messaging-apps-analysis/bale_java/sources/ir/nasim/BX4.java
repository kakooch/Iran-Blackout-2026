package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class BX4 {
    private final int a;
    private final String b;
    private final String c;
    private final DX4 d;
    private final boolean e;
    private final EX4 f;
    private final boolean g;

    public BX4(int i, String str, String str2, DX4 dx4, boolean z, EX4 ex4, boolean z2) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "placeHolder");
        AbstractC13042fc3.i(dx4, "state");
        AbstractC13042fc3.i(ex4, "type");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = dx4;
        this.e = z;
        this.f = ex4;
        this.g = z2;
    }

    public static /* synthetic */ BX4 b(BX4 bx4, int i, String str, String str2, DX4 dx4, boolean z, EX4 ex4, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bx4.a;
        }
        if ((i2 & 2) != 0) {
            str = bx4.b;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = bx4.c;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            dx4 = bx4.d;
        }
        DX4 dx42 = dx4;
        if ((i2 & 16) != 0) {
            z = bx4.e;
        }
        boolean z3 = z;
        if ((i2 & 32) != 0) {
            ex4 = bx4.f;
        }
        EX4 ex42 = ex4;
        if ((i2 & 64) != 0) {
            z2 = bx4.g;
        }
        return bx4.a(i, str3, str4, dx42, z3, ex42, z2);
    }

    public final BX4 a(int i, String str, String str2, DX4 dx4, boolean z, EX4 ex4, boolean z2) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "placeHolder");
        AbstractC13042fc3.i(dx4, "state");
        AbstractC13042fc3.i(ex4, "type");
        return new BX4(i, str, str2, dx4, z, ex4, z2);
    }

    public final boolean c() {
        return this.g;
    }

    public final int d() {
        return this.a;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BX4)) {
            return false;
        }
        BX4 bx4 = (BX4) obj;
        return this.a == bx4.a && AbstractC13042fc3.d(this.b, bx4.b) && AbstractC13042fc3.d(this.c, bx4.c) && AbstractC13042fc3.d(this.d, bx4.d) && this.e == bx4.e && AbstractC13042fc3.d(this.f, bx4.f) && this.g == bx4.g;
    }

    public final String f() {
        return this.c;
    }

    public final DX4 g() {
        return this.d;
    }

    public final String h() {
        return this.b;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g);
    }

    public final EX4 i() {
        return this.f;
    }

    public String toString() {
        return "PassportField(id=" + this.a + ", title=" + this.b + ", placeHolder=" + this.c + ", state=" + this.d + ", neeValidationWithBackend=" + this.e + ", type=" + this.f + ", editable=" + this.g + Separators.RPAREN;
    }
}
