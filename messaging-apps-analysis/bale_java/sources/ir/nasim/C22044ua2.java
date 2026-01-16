package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ua2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22044ua2 {
    private long a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Long f;
    private String g;
    private String h;
    private String i;
    private String j;

    public C22044ua2(long j, String str, String str2, String str3, String str4, Long l, String str5, String str6, String str7, String str8) {
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = l;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = str8;
    }

    public final String a() {
        return this.g;
    }

    public final String b() {
        return this.j;
    }

    public final Long c() {
        return this.f;
    }

    public final long d() {
        return this.a;
    }

    public final String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22044ua2)) {
            return false;
        }
        C22044ua2 c22044ua2 = (C22044ua2) obj;
        return this.a == c22044ua2.a && AbstractC13042fc3.d(this.b, c22044ua2.b) && AbstractC13042fc3.d(this.c, c22044ua2.c) && AbstractC13042fc3.d(this.d, c22044ua2.d) && AbstractC13042fc3.d(this.e, c22044ua2.e) && AbstractC13042fc3.d(this.f, c22044ua2.f) && AbstractC13042fc3.d(this.g, c22044ua2.g) && AbstractC13042fc3.d(this.h, c22044ua2.h) && AbstractC13042fc3.d(this.i, c22044ua2.i) && AbstractC13042fc3.d(this.j, c22044ua2.j);
    }

    public final String f() {
        return this.i;
    }

    public final String g() {
        return this.c;
    }

    public final String h() {
        return this.b;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l = this.f;
        int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        String str5 = this.g;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.h;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.i;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.j;
        return iHashCode9 + (str8 != null ? str8.hashCode() : 0);
    }

    public final String i() {
        return this.h;
    }

    public final String j() {
        return this.e;
    }

    public final void k(String str) {
        this.g = str;
    }

    public final void l(String str) {
        this.j = str;
    }

    public final void m(Long l) {
        this.f = l;
    }

    public final void n(long j) {
        this.a = j;
    }

    public final void o(String str) {
        this.d = str;
    }

    public final void p(String str) {
        this.i = str;
    }

    public final void q(String str) {
        this.c = str;
    }

    public final void r(String str) {
        this.b = str;
    }

    public final void s(String str) {
        this.h = str;
    }

    public final void t(String str) {
        this.e = str;
    }

    public String toString() {
        return "EventBarEntity(id=" + this.a + ", title=" + this.b + ", linkText=" + this.c + ", linkAddress=" + this.d + ", titleEmoji=" + this.e + ", expireDateInMilliSeconds=" + this.f + ", backgroundColor=" + this.g + ", titleColor=" + this.h + ", linkColor=" + this.i + ", closeButtonColor=" + this.j + Separators.RPAREN;
    }

    public /* synthetic */ C22044ua2(long j, String str, String str2, String str3, String str4, Long l, String str5, String str6, String str7, String str8, int i, ED1 ed1) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) == 0 ? str8 : null);
    }
}
