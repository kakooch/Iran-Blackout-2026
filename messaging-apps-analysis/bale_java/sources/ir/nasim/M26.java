package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class M26 {
    public static final int p = 0;
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final String e;
    private final EnumC23259wd1 f;
    private final N26 g;
    private final AV7 h;
    private final AV7 i;
    private final boolean j;
    private final Long k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;

    public M26(boolean z, boolean z2, boolean z3, boolean z4, String str, EnumC23259wd1 enumC23259wd1, N26 n26, AV7 av7, AV7 av72, boolean z5, Long l, String str2, String str3, String str4, String str5) {
        AbstractC13042fc3.i(str, "userUniqId");
        AbstractC13042fc3.i(enumC23259wd1, "connectionQuality");
        AbstractC13042fc3.i(n26, "roomParticipantType");
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = str;
        this.f = enumC23259wd1;
        this.g = n26;
        this.h = av7;
        this.i = av72;
        this.j = z5;
        this.k = l;
        this.l = str2;
        this.m = str3;
        this.n = str4;
        this.o = str5;
    }

    public final M26 a(boolean z, boolean z2, boolean z3, boolean z4, String str, EnumC23259wd1 enumC23259wd1, N26 n26, AV7 av7, AV7 av72, boolean z5, Long l, String str2, String str3, String str4, String str5) {
        AbstractC13042fc3.i(str, "userUniqId");
        AbstractC13042fc3.i(enumC23259wd1, "connectionQuality");
        AbstractC13042fc3.i(n26, "roomParticipantType");
        return new M26(z, z2, z3, z4, str, enumC23259wd1, n26, av7, av72, z5, l, str2, str3, str4, str5);
    }

    public final String c() {
        return this.l;
    }

    public final EnumC23259wd1 d() {
        return this.f;
    }

    public final String e() {
        return this.n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M26)) {
            return false;
        }
        M26 m26 = (M26) obj;
        return this.a == m26.a && this.b == m26.b && this.c == m26.c && this.d == m26.d && AbstractC13042fc3.d(this.e, m26.e) && this.f == m26.f && this.g == m26.g && AbstractC13042fc3.d(this.h, m26.h) && AbstractC13042fc3.d(this.i, m26.i) && this.j == m26.j && AbstractC13042fc3.d(this.k, m26.k) && AbstractC13042fc3.d(this.l, m26.l) && AbstractC13042fc3.d(this.m, m26.m) && AbstractC13042fc3.d(this.n, m26.n) && AbstractC13042fc3.d(this.o, m26.o);
    }

    public final Long f() {
        return this.k;
    }

    public final String g() {
        return this.o;
    }

    public final N26 h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        AV7 av7 = this.h;
        int iHashCode2 = (iHashCode + (av7 == null ? 0 : av7.hashCode())) * 31;
        AV7 av72 = this.i;
        int iHashCode3 = (((iHashCode2 + (av72 == null ? 0 : av72.hashCode())) * 31) + Boolean.hashCode(this.j)) * 31;
        Long l = this.k;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.l;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.m;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.n;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.o;
        return iHashCode7 + (str4 != null ? str4.hashCode() : 0);
    }

    public final AV7 i() {
        return this.i;
    }

    public final String j() {
        return this.e;
    }

    public final AV7 k() {
        return this.h;
    }

    public final String l() {
        return this.m;
    }

    public final boolean m() {
        return this.c && !this.b;
    }

    public final boolean n() {
        return this.c && this.d;
    }

    public final boolean o() {
        return this.d;
    }

    public final boolean p() {
        return this.j;
    }

    public final boolean q() {
        return this.c;
    }

    public final boolean r() {
        return this.b;
    }

    public final boolean s() {
        return this.a;
    }

    public String toString() {
        return "RoomParticipant(isVoiceMuted=" + this.a + ", isVideoMuted=" + this.b + ", isVideoEnabled=" + this.c + ", isShareScreenEnabled=" + this.d + ", userUniqId=" + this.e + ", connectionQuality=" + this.f + ", roomParticipantType=" + this.g + ", videoSurfaceView=" + this.h + ", screenShareSurfaceView=" + this.i + ", isSpeaking=" + this.j + ", joinedAt=" + this.k + ", audioTrackId=" + this.l + ", videoTrackId=" + this.m + ", identity=" + this.n + ", name=" + this.o + Separators.RPAREN;
    }

    public /* synthetic */ M26(boolean z, boolean z2, boolean z3, boolean z4, String str, EnumC23259wd1 enumC23259wd1, N26 n26, AV7 av7, AV7 av72, boolean z5, Long l, String str2, String str3, String str4, String str5, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? "" : str, (i & 32) != 0 ? EnumC23259wd1.d : enumC23259wd1, (i & 64) != 0 ? N26.a : n26, (i & 128) != 0 ? null : av7, (i & 256) != 0 ? null : av72, (i & 512) == 0 ? z5 : false, (i & 1024) != 0 ? null : l, (i & 2048) != 0 ? null : str2, (i & 4096) != 0 ? null : str3, (i & 8192) != 0 ? null : str4, (i & 16384) == 0 ? str5 : null);
    }
}
