package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.LP;
import java.util.List;

/* renamed from: ir.nasim.yP7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24316yP7 {
    private final boolean a;
    private final String b;
    private final Integer c;
    private final boolean d;
    private final LP e;
    private final boolean f;
    private final boolean g;
    private final String h;
    private final SQ i;
    private final long j;
    private final SQ k;
    private final long l;
    private final List m;
    private final List n;
    private final String o;

    public C24316yP7(boolean z, String str, Integer num, boolean z2, LP lp, boolean z3, boolean z4, String str2, SQ sq, long j, SQ sq2, long j2, List list, List list2, String str3) {
        AbstractC13042fc3.i(str, "textMessage");
        AbstractC13042fc3.i(lp, "error");
        AbstractC13042fc3.i(str2, "validationCode");
        AbstractC13042fc3.i(sq, "sentCodeType");
        AbstractC13042fc3.i(sq2, "nextSendCodeType");
        AbstractC13042fc3.i(list, "availableType");
        AbstractC13042fc3.i(list2, "exInfoList");
        AbstractC13042fc3.i(str3, "callUssd");
        this.a = z;
        this.b = str;
        this.c = num;
        this.d = z2;
        this.e = lp;
        this.f = z3;
        this.g = z4;
        this.h = str2;
        this.i = sq;
        this.j = j;
        this.k = sq2;
        this.l = j2;
        this.m = list;
        this.n = list2;
        this.o = str3;
    }

    public final C24316yP7 a(boolean z, String str, Integer num, boolean z2, LP lp, boolean z3, boolean z4, String str2, SQ sq, long j, SQ sq2, long j2, List list, List list2, String str3) {
        AbstractC13042fc3.i(str, "textMessage");
        AbstractC13042fc3.i(lp, "error");
        AbstractC13042fc3.i(str2, "validationCode");
        AbstractC13042fc3.i(sq, "sentCodeType");
        AbstractC13042fc3.i(sq2, "nextSendCodeType");
        AbstractC13042fc3.i(list, "availableType");
        AbstractC13042fc3.i(list2, "exInfoList");
        AbstractC13042fc3.i(str3, "callUssd");
        return new C24316yP7(z, str, num, z2, lp, z3, z4, str2, sq, j, sq2, j2, list, list2, str3);
    }

    public final List c() {
        return this.m;
    }

    public final String d() {
        return this.o;
    }

    public final LP e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24316yP7)) {
            return false;
        }
        C24316yP7 c24316yP7 = (C24316yP7) obj;
        return this.a == c24316yP7.a && AbstractC13042fc3.d(this.b, c24316yP7.b) && AbstractC13042fc3.d(this.c, c24316yP7.c) && this.d == c24316yP7.d && AbstractC13042fc3.d(this.e, c24316yP7.e) && this.f == c24316yP7.f && this.g == c24316yP7.g && AbstractC13042fc3.d(this.h, c24316yP7.h) && this.i == c24316yP7.i && this.j == c24316yP7.j && this.k == c24316yP7.k && this.l == c24316yP7.l && AbstractC13042fc3.d(this.m, c24316yP7.m) && AbstractC13042fc3.d(this.n, c24316yP7.n) && AbstractC13042fc3.d(this.o, c24316yP7.o);
    }

    public final List f() {
        return this.n;
    }

    public final Integer g() {
        return this.c;
    }

    public final boolean h() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Integer num = this.c;
        return ((((((((((((((((((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + Long.hashCode(this.j)) * 31) + this.k.hashCode()) * 31) + Long.hashCode(this.l)) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode();
    }

    public final SQ i() {
        return this.k;
    }

    public final long j() {
        return this.l;
    }

    public final SQ k() {
        return this.i;
    }

    public final String l() {
        return this.b;
    }

    public final String m() {
        return this.h;
    }

    public final boolean n() {
        return this.a;
    }

    public final boolean o() {
        return this.d;
    }

    public final boolean p() {
        return this.g;
    }

    public String toString() {
        return "ValidationCodeModel(isFinish=" + this.a + ", textMessage=" + this.b + ", icon=" + this.c + ", isLoading=" + this.d + ", error=" + this.e + ", needSignUp=" + this.f + ", isTwoFANeeded=" + this.g + ", validationCode=" + this.h + ", sentCodeType=" + this.i + ", codeTimeoutMillis=" + this.j + ", nextSendCodeType=" + this.k + ", nextSendCodeWaitTimeMillis=" + this.l + ", availableType=" + this.m + ", exInfoList=" + this.n + ", callUssd=" + this.o + Separators.RPAREN;
    }

    public /* synthetic */ C24316yP7(boolean z, String str, Integer num, boolean z2, LP lp, boolean z3, boolean z4, String str2, SQ sq, long j, SQ sq2, long j2, List list, List list2, String str3, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? LP.c.b : lp, (i & 32) != 0 ? false : z3, (i & 64) == 0 ? z4 : false, (i & 128) != 0 ? "" : str2, (i & 256) != 0 ? SQ.a : sq, (i & 512) != 0 ? 0L : j, (i & 1024) != 0 ? SQ.a : sq2, (i & 2048) != 0 ? 0L : j2, (i & 4096) != 0 ? AbstractC10360bX0.m() : list, (i & 8192) != 0 ? AbstractC10360bX0.m() : list2, (i & 16384) != 0 ? "" : str3);
    }
}
