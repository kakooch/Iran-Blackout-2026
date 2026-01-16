package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class JD4 {
    public static final a i = new a(null);
    private final long a;
    private final String b;
    private final String c;
    private final long d;
    private final EnumC13889gz5 e;
    private final long f;
    private final String g;
    private final Integer h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public JD4(long j, String str, String str2, long j2, EnumC13889gz5 enumC13889gz5, long j3, String str3, Integer num) {
        AbstractC13042fc3.i(str, "peerId");
        AbstractC13042fc3.i(str2, "messageRid");
        AbstractC13042fc3.i(enumC13889gz5, "pushType");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = j2;
        this.e = enumC13889gz5;
        this.f = j3;
        this.g = str3;
        this.h = num;
    }

    public final String a() {
        return this.g;
    }

    public final long b() {
        return this.a;
    }

    public final long c() {
        return this.d;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JD4)) {
            return false;
        }
        JD4 jd4 = (JD4) obj;
        return this.a == jd4.a && AbstractC13042fc3.d(this.b, jd4.b) && AbstractC13042fc3.d(this.c, jd4.c) && this.d == jd4.d && this.e == jd4.e && this.f == jd4.f && AbstractC13042fc3.d(this.g, jd4.g) && AbstractC13042fc3.d(this.h, jd4.h);
    }

    public final long f() {
        return this.f;
    }

    public final EnumC13889gz5 g() {
        return this.e;
    }

    public final Integer h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = ((((((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31;
        String str = this.g;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.h;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "NotificationRecordEntity(id=" + this.a + ", peerId=" + this.b + ", messageRid=" + this.c + ", messageDate=" + this.d + ", pushType=" + this.e + ", pushSendDate=" + this.f + ", content=" + this.g + ", reactionCount=" + this.h + Separators.RPAREN;
    }

    public /* synthetic */ JD4(long j, String str, String str2, long j2, EnumC13889gz5 enumC13889gz5, long j3, String str3, Integer num, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 0L : j, str, str2, j2, enumC13889gz5, j3, str3, num);
    }
}
