package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Ml5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C6167Ml5 {
    private final long a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final boolean g;
    private final long h;
    private final long i;
    private final long j;
    private final List k;

    public C6167Ml5(long j, String str, String str2, String str3, String str4, String str5, boolean z, long j2, long j3, long j4, List list) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "titleEn");
        AbstractC13042fc3.i(str3, "desc");
        AbstractC13042fc3.i(str4, "descEn");
        AbstractC13042fc3.i(list, "featureList");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = z;
        this.h = j2;
        this.i = j3;
        this.j = j4;
        this.k = list;
    }

    public final C6167Ml5 a(long j, String str, String str2, String str3, String str4, String str5, boolean z, long j2, long j3, long j4, List list) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "titleEn");
        AbstractC13042fc3.i(str3, "desc");
        AbstractC13042fc3.i(str4, "descEn");
        AbstractC13042fc3.i(list, "featureList");
        return new C6167Ml5(j, str, str2, str3, str4, str5, z, j2, j3, j4, list);
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final List e() {
        return this.k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6167Ml5)) {
            return false;
        }
        C6167Ml5 c6167Ml5 = (C6167Ml5) obj;
        return this.a == c6167Ml5.a && AbstractC13042fc3.d(this.b, c6167Ml5.b) && AbstractC13042fc3.d(this.c, c6167Ml5.c) && AbstractC13042fc3.d(this.d, c6167Ml5.d) && AbstractC13042fc3.d(this.e, c6167Ml5.e) && AbstractC13042fc3.d(this.f, c6167Ml5.f) && this.g == c6167Ml5.g && this.h == c6167Ml5.h && this.i == c6167Ml5.i && this.j == c6167Ml5.j && AbstractC13042fc3.d(this.k, c6167Ml5.k);
    }

    public final long f() {
        return this.a;
    }

    public final long g() {
        return this.i;
    }

    public final long h() {
        return this.j;
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String str = this.f;
        return ((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31) + this.k.hashCode();
    }

    public final String i() {
        return this.b;
    }

    public final String j() {
        return this.c;
    }

    public final boolean k() {
        return this.g;
    }

    public String toString() {
        return "PremiumItem(id=" + this.a + ", title=" + this.b + ", titleEn=" + this.c + ", desc=" + this.d + ", descEn=" + this.e + ", iconUrl=" + this.f + ", isSpecial=" + this.g + ", duration=" + this.h + ", price=" + this.i + ", priceAfterDiscount=" + this.j + ", featureList=" + this.k + Separators.RPAREN;
    }

    public /* synthetic */ C6167Ml5(long j, String str, String str2, String str3, String str4, String str5, boolean z, long j2, long j3, long j4, List list, int i, ED1 ed1) {
        this(j, str, str2, str3, str4, (i & 32) != 0 ? null : str5, z, j2, j3, (i & 512) != 0 ? j3 : j4, list);
    }
}
