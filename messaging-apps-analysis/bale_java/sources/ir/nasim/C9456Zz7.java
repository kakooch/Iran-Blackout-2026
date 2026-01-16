package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;

/* renamed from: ir.nasim.Zz7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9456Zz7 {
    private final Q64 a;
    private final Spannable b;
    private final M44 c;
    private final J44 d;
    private final SA2 e;
    private final GM5 f;
    private final boolean g;
    private final String h;
    private final Object i;

    public C9456Zz7(Q64 q64, Spannable spannable, M44 m44, J44 j44, SA2 sa2, GM5 gm5, boolean z, String str, Object obj) {
        AbstractC13042fc3.i(q64, "mId");
        AbstractC13042fc3.i(spannable, "body");
        AbstractC13042fc3.i(m44, "availableActions");
        AbstractC13042fc3.i(j44, "oldMessage");
        AbstractC13042fc3.i(sa2, "suggestionChannels");
        AbstractC13042fc3.i(gm5, "relatedChannelsListener");
        AbstractC13042fc3.i(str, "relatedChannelsTitle");
        this.a = q64;
        this.b = spannable;
        this.c = m44;
        this.d = j44;
        this.e = sa2;
        this.f = gm5;
        this.g = z;
        this.h = str;
        this.i = obj;
    }

    public final C9456Zz7 a(Q64 q64, Spannable spannable, M44 m44, J44 j44, SA2 sa2, GM5 gm5, boolean z, String str, Object obj) {
        AbstractC13042fc3.i(q64, "mId");
        AbstractC13042fc3.i(spannable, "body");
        AbstractC13042fc3.i(m44, "availableActions");
        AbstractC13042fc3.i(j44, "oldMessage");
        AbstractC13042fc3.i(sa2, "suggestionChannels");
        AbstractC13042fc3.i(gm5, "relatedChannelsListener");
        AbstractC13042fc3.i(str, "relatedChannelsTitle");
        return new C9456Zz7(q64, spannable, m44, j44, sa2, gm5, z, str, obj);
    }

    public final M44 c() {
        return this.c;
    }

    public final Spannable d() {
        return this.b;
    }

    public final Object e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9456Zz7)) {
            return false;
        }
        C9456Zz7 c9456Zz7 = (C9456Zz7) obj;
        return AbstractC13042fc3.d(this.a, c9456Zz7.a) && AbstractC13042fc3.d(this.b, c9456Zz7.b) && AbstractC13042fc3.d(this.c, c9456Zz7.c) && AbstractC13042fc3.d(this.d, c9456Zz7.d) && AbstractC13042fc3.d(this.e, c9456Zz7.e) && AbstractC13042fc3.d(this.f, c9456Zz7.f) && this.g == c9456Zz7.g && AbstractC13042fc3.d(this.h, c9456Zz7.h) && AbstractC13042fc3.d(this.i, c9456Zz7.i);
    }

    public final Q64 f() {
        return this.a;
    }

    public final J44 g() {
        return this.d;
    }

    public final GM5 h() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g)) * 31) + this.h.hashCode()) * 31;
        Object obj = this.i;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final SA2 i() {
        return this.e;
    }

    public final boolean j() {
        return this.g;
    }

    public String toString() {
        Q64 q64 = this.a;
        Spannable spannable = this.b;
        return "UIServiceMessage(mId=" + q64 + ", body=" + ((Object) spannable) + ", availableActions=" + this.c + ", oldMessage=" + this.d + ", suggestionChannels=" + this.e + ", relatedChannelsListener=" + this.f + ", isPublicChannel=" + this.g + ", relatedChannelsTitle=" + this.h + ", data=" + this.i + Separators.RPAREN;
    }
}
