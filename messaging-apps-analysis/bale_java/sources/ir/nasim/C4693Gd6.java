package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC24849zJ0;

/* renamed from: ir.nasim.Gd6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4693Gd6 {
    private final String a;
    private final String b;
    private final String c;
    private final OM2 d;
    private final AbstractC24849zJ0 e;

    public C4693Gd6(String str, String str2, String str3, OM2 om2, AbstractC24849zJ0 abstractC24849zJ0) {
        AbstractC13042fc3.i(str2, "groupOrChannelName");
        AbstractC13042fc3.i(str3, "channelId");
        AbstractC13042fc3.i(om2, "groupRestriction");
        AbstractC13042fc3.i(abstractC24849zJ0, "channelIdUiState");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = om2;
        this.e = abstractC24849zJ0;
    }

    public static /* synthetic */ C4693Gd6 b(C4693Gd6 c4693Gd6, String str, String str2, String str3, OM2 om2, AbstractC24849zJ0 abstractC24849zJ0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c4693Gd6.a;
        }
        if ((i & 2) != 0) {
            str2 = c4693Gd6.b;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = c4693Gd6.c;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            om2 = c4693Gd6.d;
        }
        OM2 om22 = om2;
        if ((i & 16) != 0) {
            abstractC24849zJ0 = c4693Gd6.e;
        }
        return c4693Gd6.a(str, str4, str5, om22, abstractC24849zJ0);
    }

    public final C4693Gd6 a(String str, String str2, String str3, OM2 om2, AbstractC24849zJ0 abstractC24849zJ0) {
        AbstractC13042fc3.i(str2, "groupOrChannelName");
        AbstractC13042fc3.i(str3, "channelId");
        AbstractC13042fc3.i(om2, "groupRestriction");
        AbstractC13042fc3.i(abstractC24849zJ0, "channelIdUiState");
        return new C4693Gd6(str, str2, str3, om2, abstractC24849zJ0);
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.c;
    }

    public final AbstractC24849zJ0 e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4693Gd6)) {
            return false;
        }
        C4693Gd6 c4693Gd6 = (C4693Gd6) obj;
        return AbstractC13042fc3.d(this.a, c4693Gd6.a) && AbstractC13042fc3.d(this.b, c4693Gd6.b) && AbstractC13042fc3.d(this.c, c4693Gd6.c) && this.d == c4693Gd6.d && AbstractC13042fc3.d(this.e, c4693Gd6.e);
    }

    public final String f() {
        return this.b;
    }

    public final OM2 g() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        return ((((((((str == null ? 0 : str.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "ScreenUiState(avatarPath=" + this.a + ", groupOrChannelName=" + this.b + ", channelId=" + this.c + ", groupRestriction=" + this.d + ", channelIdUiState=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C4693Gd6(String str, String str2, String str3, OM2 om2, AbstractC24849zJ0 abstractC24849zJ0, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? "" : str2, (i & 4) == 0 ? str3 : "", (i & 8) != 0 ? OM2.b : om2, (i & 16) != 0 ? AbstractC24849zJ0.b.a : abstractC24849zJ0);
    }
}
