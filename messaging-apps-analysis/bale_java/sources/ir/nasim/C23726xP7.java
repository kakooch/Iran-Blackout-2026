package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.xP7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C23726xP7 {
    private final String a;
    private final boolean b;
    private final String c;
    private final String d;
    private final long e;
    private final long f;
    private final boolean g;

    public C23726xP7(String str, boolean z, String str2, String str3, long j, long j2, boolean z2) {
        AbstractC13042fc3.i(str, "textMessage");
        AbstractC13042fc3.i(str3, "validationCode");
        this.a = str;
        this.b = z;
        this.c = str2;
        this.d = str3;
        this.e = j;
        this.f = j2;
        this.g = z2;
    }

    public final C23726xP7 a(String str, boolean z, String str2, String str3, long j, long j2, boolean z2) {
        AbstractC13042fc3.i(str, "textMessage");
        AbstractC13042fc3.i(str3, "validationCode");
        return new C23726xP7(str, z, str2, str3, j, j2, z2);
    }

    public final String c() {
        return this.c;
    }

    public final long d() {
        return this.f;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23726xP7)) {
            return false;
        }
        C23726xP7 c23726xP7 = (C23726xP7) obj;
        return AbstractC13042fc3.d(this.a, c23726xP7.a) && this.b == c23726xP7.b && AbstractC13042fc3.d(this.c, c23726xP7.c) && AbstractC13042fc3.d(this.d, c23726xP7.d) && this.e == c23726xP7.e && this.f == c23726xP7.f && this.g == c23726xP7.g;
    }

    public final String f() {
        return this.a;
    }

    public final String g() {
        return this.d;
    }

    public final boolean h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31;
        String str = this.c;
        return ((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Boolean.hashCode(this.g);
    }

    public final boolean i() {
        return this.b;
    }

    public String toString() {
        return "ValidationCodeModel(textMessage=" + this.a + ", isLoading=" + this.b + ", error=" + this.c + ", validationCode=" + this.d + ", nextSendCodeWaitTimeMillis=" + this.e + ", fullPhoneNumber=" + this.f + ", isCodeValidated=" + this.g + Separators.RPAREN;
    }

    public /* synthetic */ C23726xP7(String str, boolean z, String str2, String str3, long j, long j2, boolean z2, int i, ED1 ed1) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2, (i & 8) == 0 ? str3 : "", (i & 16) != 0 ? 0L : j, (i & 32) != 0 ? -1L : j2, (i & 64) == 0 ? z2 : false);
    }
}
