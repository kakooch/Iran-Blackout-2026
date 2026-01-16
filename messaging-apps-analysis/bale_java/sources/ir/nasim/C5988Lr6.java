package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.List;

/* renamed from: ir.nasim.Lr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5988Lr6 {
    public static final a p = new a(null);
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final Integer g;
    private final Integer h;
    private final String i;
    private final String j;
    private final String k;
    private final int l;
    private final int m;
    private final int n;
    private final List o;

    /* renamed from: ir.nasim.Lr6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C5988Lr6(int i, String str, String str2, String str3, String str4, int i2, Integer num, Integer num2, String str5, String str6, String str7, int i3, int i4, int i5, List list) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, ParameterNames.ICON);
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = i2;
        this.g = num;
        this.h = num2;
        this.i = str5;
        this.j = str6;
        this.k = str7;
        this.l = i3;
        this.m = i4;
        this.n = i5;
        this.o = list;
    }

    public final int a() {
        return this.f;
    }

    public final String b() {
        return this.e;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.j;
    }

    public final String e() {
        return this.k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5988Lr6)) {
            return false;
        }
        C5988Lr6 c5988Lr6 = (C5988Lr6) obj;
        return this.a == c5988Lr6.a && AbstractC13042fc3.d(this.b, c5988Lr6.b) && AbstractC13042fc3.d(this.c, c5988Lr6.c) && AbstractC13042fc3.d(this.d, c5988Lr6.d) && AbstractC13042fc3.d(this.e, c5988Lr6.e) && this.f == c5988Lr6.f && AbstractC13042fc3.d(this.g, c5988Lr6.g) && AbstractC13042fc3.d(this.h, c5988Lr6.h) && AbstractC13042fc3.d(this.i, c5988Lr6.i) && AbstractC13042fc3.d(this.j, c5988Lr6.j) && AbstractC13042fc3.d(this.k, c5988Lr6.k) && this.l == c5988Lr6.l && this.m == c5988Lr6.m && this.n == c5988Lr6.n && AbstractC13042fc3.d(this.o, c5988Lr6.o);
    }

    public final String f() {
        return this.c;
    }

    public final int g() {
        return this.a;
    }

    public final int h() {
        return this.n;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.f)) * 31;
        Integer num = this.g;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.h;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.i;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.j;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.k;
        int iHashCode8 = (((((((iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31) + Integer.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + Integer.hashCode(this.n)) * 31;
        List list = this.o;
        return iHashCode8 + (list != null ? list.hashCode() : 0);
    }

    public final List i() {
        return this.o;
    }

    public final int j() {
        return this.m;
    }

    public final Integer k() {
        return this.g;
    }

    public final Integer l() {
        return this.h;
    }

    public final int m() {
        return this.l;
    }

    public final String n() {
        return this.b;
    }

    public final String o() {
        return this.i;
    }

    public String toString() {
        return "ServiceItemEntity(id=" + this.a + ", title=" + this.b + ", icon=" + this.c + ", customIcon=" + this.d + ", badge=" + this.e + ", action=" + this.f + ", peerId=" + this.g + ", peerType=" + this.h + ", url=" + this.i + ", eventKey=" + this.j + ", eventName=" + this.k + ", sectionId=" + this.l + ", minAppVersion=" + this.m + ", maxAppVersion=" + this.n + ", menuItems=" + this.o + Separators.RPAREN;
    }
}
