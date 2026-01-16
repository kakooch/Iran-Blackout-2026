package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.x4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C23523x4 {
    public static final a i = new a(null);
    public static final int j = 8;
    private static final C23523x4 k = new C23523x4("", "", "", "", AbstractC10360bX0.m(), false, null, false, 128, null);
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final List e;
    private final boolean f;
    private final String g;
    private final boolean h;

    /* renamed from: ir.nasim.x4$a */
    public static final class a {
        private a() {
        }

        public final C23523x4 a() {
            return C23523x4.k;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C23523x4(String str, String str2, String str3, String str4, List list, boolean z, String str5, boolean z2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "phoneNumber");
        AbstractC13042fc3.i(str3, "userId");
        AbstractC13042fc3.i(str4, "about");
        AbstractC13042fc3.i(list, "avatars");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = list;
        this.f = z;
        this.g = str5;
        this.h = z2;
    }

    public final C23523x4 b(String str, String str2, String str3, String str4, List list, boolean z, String str5, boolean z2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "phoneNumber");
        AbstractC13042fc3.i(str3, "userId");
        AbstractC13042fc3.i(str4, "about");
        AbstractC13042fc3.i(list, "avatars");
        return new C23523x4(str, str2, str3, str4, list, z, str5, z2);
    }

    public final String d() {
        return this.d;
    }

    public final List e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23523x4)) {
            return false;
        }
        C23523x4 c23523x4 = (C23523x4) obj;
        return AbstractC13042fc3.d(this.a, c23523x4.a) && AbstractC13042fc3.d(this.b, c23523x4.b) && AbstractC13042fc3.d(this.c, c23523x4.c) && AbstractC13042fc3.d(this.d, c23523x4.d) && AbstractC13042fc3.d(this.e, c23523x4.e) && this.f == c23523x4.f && AbstractC13042fc3.d(this.g, c23523x4.g) && this.h == c23523x4.h;
    }

    public final String f() {
        return this.a;
    }

    public final String g() {
        return this.b;
    }

    public final boolean h() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31;
        String str = this.g;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.h);
    }

    public final boolean i() {
        return this.h;
    }

    public final String j() {
        return this.g;
    }

    public final String k() {
        return this.c;
    }

    public String toString() {
        return "AccountInfoUiState(name=" + this.a + ", phoneNumber=" + this.b + ", userId=" + this.c + ", about=" + this.d + ", avatars=" + this.e + ", showLoading=" + this.f + ", snackBarMessage=" + this.g + ", showPassport=" + this.h + Separators.RPAREN;
    }

    public /* synthetic */ C23523x4(String str, String str2, String str3, String str4, List list, boolean z, String str5, boolean z2, int i2, ED1 ed1) {
        this(str, str2, str3, str4, list, z, str5, (i2 & 128) != 0 ? false : z2);
    }
}
