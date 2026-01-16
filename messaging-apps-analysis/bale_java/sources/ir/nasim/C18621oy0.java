package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.call.ui.startOutGoingCall.StartOutGoingCallPeerData;

/* renamed from: ir.nasim.oy0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18621oy0 {
    private final EnumC18030ny0 a;
    private final StartOutGoingCallPeerData b;
    private final Long c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final C17637nI7 k;
    private final String l;
    private final String m;
    private final long n;
    private final String o;
    private final int p;
    private final boolean q;
    private final String r;
    private final Integer s;

    public C18621oy0(EnumC18030ny0 enumC18030ny0, StartOutGoingCallPeerData startOutGoingCallPeerData, Long l, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, C17637nI7 c17637nI7, String str, String str2, long j, String str3, int i, boolean z8, String str4, Integer num) {
        AbstractC13042fc3.i(enumC18030ny0, "callPreviewMode");
        AbstractC13042fc3.i(str4, "callPreviewInfo");
        this.a = enumC18030ny0;
        this.b = startOutGoingCallPeerData;
        this.c = l;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = z5;
        this.i = z6;
        this.j = z7;
        this.k = c17637nI7;
        this.l = str;
        this.m = str2;
        this.n = j;
        this.o = str3;
        this.p = i;
        this.q = z8;
        this.r = str4;
        this.s = num;
    }

    public final C18621oy0 a(EnumC18030ny0 enumC18030ny0, StartOutGoingCallPeerData startOutGoingCallPeerData, Long l, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, C17637nI7 c17637nI7, String str, String str2, long j, String str3, int i, boolean z8, String str4, Integer num) {
        AbstractC13042fc3.i(enumC18030ny0, "callPreviewMode");
        AbstractC13042fc3.i(str4, "callPreviewInfo");
        return new C18621oy0(enumC18030ny0, startOutGoingCallPeerData, l, z, z2, z3, z4, z5, z6, z7, c17637nI7, str, str2, j, str3, i, z8, str4, num);
    }

    public final Long c() {
        return this.c;
    }

    public final String d() {
        return this.m;
    }

    public final String e() {
        return this.r;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18621oy0)) {
            return false;
        }
        C18621oy0 c18621oy0 = (C18621oy0) obj;
        return this.a == c18621oy0.a && AbstractC13042fc3.d(this.b, c18621oy0.b) && AbstractC13042fc3.d(this.c, c18621oy0.c) && this.d == c18621oy0.d && this.e == c18621oy0.e && this.f == c18621oy0.f && this.g == c18621oy0.g && this.h == c18621oy0.h && this.i == c18621oy0.i && this.j == c18621oy0.j && AbstractC13042fc3.d(this.k, c18621oy0.k) && AbstractC13042fc3.d(this.l, c18621oy0.l) && AbstractC13042fc3.d(this.m, c18621oy0.m) && this.n == c18621oy0.n && AbstractC13042fc3.d(this.o, c18621oy0.o) && this.p == c18621oy0.p && this.q == c18621oy0.q && AbstractC13042fc3.d(this.r, c18621oy0.r) && AbstractC13042fc3.d(this.s, c18621oy0.s);
    }

    public final EnumC18030ny0 f() {
        return this.a;
    }

    public final long g() {
        return this.n;
    }

    public final int h() {
        return this.p;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        StartOutGoingCallPeerData startOutGoingCallPeerData = this.b;
        int iHashCode2 = (iHashCode + (startOutGoingCallPeerData == null ? 0 : startOutGoingCallPeerData.hashCode())) * 31;
        Long l = this.c;
        int iHashCode3 = (((((((((((((((iHashCode2 + (l == null ? 0 : l.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31) + Boolean.hashCode(this.j)) * 31;
        C17637nI7 c17637nI7 = this.k;
        int iHashCode4 = (iHashCode3 + (c17637nI7 == null ? 0 : c17637nI7.hashCode())) * 31;
        String str = this.l;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.m;
        int iHashCode6 = (((iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31) + Long.hashCode(this.n)) * 31;
        String str3 = this.o;
        int iHashCode7 = (((((((iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31) + Integer.hashCode(this.p)) * 31) + Boolean.hashCode(this.q)) * 31) + this.r.hashCode()) * 31;
        Integer num = this.s;
        return iHashCode7 + (num != null ? num.hashCode() : 0);
    }

    public final String i() {
        return this.o;
    }

    public final C17637nI7 j() {
        return this.k;
    }

    public final String k() {
        return this.l;
    }

    public final Integer l() {
        return this.s;
    }

    public final StartOutGoingCallPeerData m() {
        return this.b;
    }

    public final boolean n() {
        return this.h;
    }

    public final boolean o() {
        return this.q;
    }

    public final boolean p() {
        return this.i;
    }

    public final boolean q() {
        return this.g;
    }

    public final boolean r() {
        return this.e;
    }

    public final boolean s() {
        return this.f;
    }

    public final boolean t() {
        return this.j;
    }

    public String toString() {
        return "CallPreviewUiState(callPreviewMode=" + this.a + ", startOutGoingCallPeerData=" + this.b + ", callId=" + this.c + ", isVoiceMuted=" + this.d + ", isSpeaking=" + this.e + ", isVideoMuted=" + this.f + ", isPrivate=" + this.g + ", isAllowedToJoin=" + this.h + ", isPending=" + this.i + ", isVideoOnFrontCamera=" + this.j + ", myUser=" + this.k + ", previewTitle=" + this.l + ", callLink=" + this.m + ", callStartTime=" + this.n + ", initiatorUserName=" + this.o + ", initiatorUserId=" + this.p + ", isCallRunning=" + this.q + ", callPreviewInfo=" + this.r + ", snackBarRes=" + this.s + Separators.RPAREN;
    }

    public final boolean u() {
        return this.d;
    }

    public /* synthetic */ C18621oy0(EnumC18030ny0 enumC18030ny0, StartOutGoingCallPeerData startOutGoingCallPeerData, Long l, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, C17637nI7 c17637nI7, String str, String str2, long j, String str3, int i, boolean z8, String str4, Integer num, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? EnumC18030ny0.c : enumC18030ny0, (i2 & 2) != 0 ? null : startOutGoingCallPeerData, (i2 & 4) != 0 ? null : l, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? true : z3, (i2 & 64) != 0 ? false : z4, (i2 & 128) != 0 ? false : z5, (i2 & 256) != 0 ? false : z6, (i2 & 512) == 0 ? z7 : true, (i2 & 1024) != 0 ? null : c17637nI7, (i2 & 2048) != 0 ? null : str, (i2 & 4096) != 0 ? null : str2, (i2 & 8192) != 0 ? 0L : j, (i2 & 16384) != 0 ? null : str3, (i2 & 32768) != 0 ? 0 : i, (i2 & 65536) == 0 ? z8 : false, (i2 & 131072) != 0 ? "" : str4, (i2 & 262144) != 0 ? null : num);
    }
}
