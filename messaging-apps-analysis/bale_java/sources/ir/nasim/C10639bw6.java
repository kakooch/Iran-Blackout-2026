package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC23562x78;

/* renamed from: ir.nasim.bw6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C10639bw6 {
    public static final a j = new a(null);
    private static final C10639bw6 k = new C10639bw6("", "", false, false, AbstractC23562x78.a.a, false, null, null, false);
    private final String a;
    private final String b;
    private final boolean c;
    private final boolean d;
    private final AbstractC23562x78 e;
    private final boolean f;
    private final C9619aG6 g;
    private final H07 h;
    private final boolean i;

    /* renamed from: ir.nasim.bw6$a */
    public static final class a {
        private a() {
        }

        public final C10639bw6 a() {
            return C10639bw6.k;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C10639bw6(String str, String str2, boolean z, boolean z2, AbstractC23562x78 abstractC23562x78, boolean z3, C9619aG6 c9619aG6, H07 h07, boolean z4) {
        AbstractC13042fc3.i(str, "language");
        AbstractC13042fc3.i(str2, ParameterNames.VERSION);
        AbstractC13042fc3.i(abstractC23562x78, "webViewDebuggingItemState");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
        this.e = abstractC23562x78;
        this.f = z3;
        this.g = c9619aG6;
        this.h = h07;
        this.i = z4;
    }

    public final C10639bw6 b(String str, String str2, boolean z, boolean z2, AbstractC23562x78 abstractC23562x78, boolean z3, C9619aG6 c9619aG6, H07 h07, boolean z4) {
        AbstractC13042fc3.i(str, "language");
        AbstractC13042fc3.i(str2, ParameterNames.VERSION);
        AbstractC13042fc3.i(abstractC23562x78, "webViewDebuggingItemState");
        return new C10639bw6(str, str2, z, z2, abstractC23562x78, z3, c9619aG6, h07, z4);
    }

    public final String d() {
        return this.a;
    }

    public final H07 e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10639bw6)) {
            return false;
        }
        C10639bw6 c10639bw6 = (C10639bw6) obj;
        return AbstractC13042fc3.d(this.a, c10639bw6.a) && AbstractC13042fc3.d(this.b, c10639bw6.b) && this.c == c10639bw6.c && this.d == c10639bw6.d && AbstractC13042fc3.d(this.e, c10639bw6.e) && this.f == c10639bw6.f && AbstractC13042fc3.d(this.g, c10639bw6.g) && AbstractC13042fc3.d(this.h, c10639bw6.h) && this.i == c10639bw6.i;
    }

    public final boolean f() {
        return this.i;
    }

    public final boolean g() {
        return this.f;
    }

    public final C9619aG6 h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31;
        C9619aG6 c9619aG6 = this.g;
        int iHashCode2 = (iHashCode + (c9619aG6 == null ? 0 : c9619aG6.hashCode())) * 31;
        H07 h07 = this.h;
        return ((iHashCode2 + (h07 != null ? h07.hashCode() : 0)) * 31) + Boolean.hashCode(this.i);
    }

    public final String i() {
        return this.b;
    }

    public final AbstractC23562x78 j() {
        return this.e;
    }

    public final boolean k() {
        return this.d;
    }

    public final boolean l() {
        return this.c;
    }

    public String toString() {
        return "SettingUiState(language=" + this.a + ", version=" + this.b + ", isLogSendingEnable=" + this.c + ", isDeveloperModeEnable=" + this.d + ", webViewDebuggingItemState=" + this.e + ", showLoading=" + this.f + ", snackBarState=" + this.g + ", logSendingState=" + this.h + ", showFoldersBadge=" + this.i + Separators.RPAREN;
    }
}
