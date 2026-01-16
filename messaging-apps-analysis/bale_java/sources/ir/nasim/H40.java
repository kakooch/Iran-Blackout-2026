package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public final class H40 {
    private AbstractC20471s40 a;
    private final int b;
    private String c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private boolean h;

    public H40(AbstractC20471s40 abstractC20471s40, int i, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        AbstractC13042fc3.i(abstractC20471s40, "bankCard");
        AbstractC13042fc3.i(str, "cardNumber");
        AbstractC13042fc3.i(str2, "cardNumberMasked");
        this.a = abstractC20471s40;
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = z;
        this.g = z2;
        this.h = z3;
    }

    public final AbstractC20471s40 a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H40)) {
            return false;
        }
        H40 h40 = (H40) obj;
        return AbstractC13042fc3.d(this.a, h40.a) && this.b == h40.b && AbstractC13042fc3.d(this.c, h40.c) && AbstractC13042fc3.d(this.d, h40.d) && AbstractC13042fc3.d(this.e, h40.e) && this.f == h40.f && this.g == h40.g && this.h == h40.h;
    }

    public final boolean f() {
        return this.f;
    }

    public final boolean g() {
        return this.h;
    }

    public final boolean h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = ((((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String str = this.e;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h);
    }

    public final void i(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.c = str;
    }

    public String toString() {
        return "BankCardSaved(bankCard=" + this.a + ", bankLogoId=" + this.b + ", cardNumber=" + this.c + ", cardNumberMasked=" + this.d + ", name=" + this.e + ", isDefault=" + this.f + ", isShaparkMigrationNeed=" + this.g + ", isFromRemote=" + this.h + Separators.RPAREN;
    }

    public /* synthetic */ H40(AbstractC20471s40 abstractC20471s40, int i, String str, String str2, String str3, boolean z, boolean z2, boolean z3, int i2, ED1 ed1) {
        this(abstractC20471s40, i, str, str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? false : z2, (i2 & 128) != 0 ? false : z3);
    }
}
