package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.Hg2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C4950Hg2 {
    private final long a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final int j;
    private final String k;
    private final String l;
    private final EnumC17768nX3 m;
    private final long n;
    private final long o;

    public C4950Hg2(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, EnumC17768nX3 enumC17768nX3, long j2, long j3) {
        AbstractC13042fc3.i(str, "faTitle");
        AbstractC13042fc3.i(str2, "enTitle");
        AbstractC13042fc3.i(str3, "faShortDescription");
        AbstractC13042fc3.i(str4, "enShortDescription");
        AbstractC13042fc3.i(str5, "faLongDescription");
        AbstractC13042fc3.i(str6, "enLongDescription");
        AbstractC13042fc3.i(str7, "faUnit");
        AbstractC13042fc3.i(str8, "enUnit");
        AbstractC13042fc3.i(str9, ParameterNames.ICON);
        AbstractC13042fc3.i(str10, "media");
        AbstractC13042fc3.i(enumC17768nX3, "mediaFormat");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = i;
        this.k = str9;
        this.l = str10;
        this.m = enumC17768nX3;
        this.n = j2;
        this.o = j3;
    }

    public final String a() {
        return this.e;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.b;
    }

    public final long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4950Hg2)) {
            return false;
        }
        C4950Hg2 c4950Hg2 = (C4950Hg2) obj;
        return this.a == c4950Hg2.a && AbstractC13042fc3.d(this.b, c4950Hg2.b) && AbstractC13042fc3.d(this.c, c4950Hg2.c) && AbstractC13042fc3.d(this.d, c4950Hg2.d) && AbstractC13042fc3.d(this.e, c4950Hg2.e) && AbstractC13042fc3.d(this.f, c4950Hg2.f) && AbstractC13042fc3.d(this.g, c4950Hg2.g) && AbstractC13042fc3.d(this.h, c4950Hg2.h) && AbstractC13042fc3.d(this.i, c4950Hg2.i) && this.j == c4950Hg2.j && AbstractC13042fc3.d(this.k, c4950Hg2.k) && AbstractC13042fc3.d(this.l, c4950Hg2.l) && this.m == c4950Hg2.m && this.n == c4950Hg2.n && this.o == c4950Hg2.o;
    }

    public final String f() {
        return this.k;
    }

    public final int g() {
        return this.j;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + Integer.hashCode(this.j)) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + Long.hashCode(this.n)) * 31) + Long.hashCode(this.o);
    }

    public String toString() {
        return "FeatureInfo(featureId=" + this.a + ", faTitle=" + this.b + ", enTitle=" + this.c + ", faShortDescription=" + this.d + ", enShortDescription=" + this.e + ", faLongDescription=" + this.f + ", enLongDescription=" + this.g + ", faUnit=" + this.h + ", enUnit=" + this.i + ", minAppVersion=" + this.j + ", icon=" + this.k + ", media=" + this.l + ", mediaFormat=" + this.m + ", quota=" + this.n + ", resetPeriod=" + this.o + Separators.RPAREN;
    }
}
