package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.cA7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10776cA7 {
    private final int a;
    private final int b;
    private final XE4 c;
    private final AbstractC3336Al1 d;
    private final AbstractC3336Al1 e;
    private final AbstractC3336Al1 f;
    private final EnumC23696xM4 g;
    private final G47 h;

    public C10776cA7(int i, int i2, XE4 xe4, AbstractC3336Al1 abstractC3336Al1, AbstractC3336Al1 abstractC3336Al12, AbstractC3336Al1 abstractC3336Al13, EnumC23696xM4 enumC23696xM4, G47 g47) {
        AbstractC13042fc3.i(abstractC3336Al1, "contentCenter");
        AbstractC13042fc3.i(enumC23696xM4, "orientation");
        AbstractC13042fc3.i(g47, "systemBarState");
        this.a = i;
        this.b = i2;
        this.c = xe4;
        this.d = abstractC3336Al1;
        this.e = abstractC3336Al12;
        this.f = abstractC3336Al13;
        this.g = enumC23696xM4;
        this.h = g47;
    }

    public final AbstractC3336Al1 a() {
        return this.d;
    }

    public final AbstractC3336Al1 b() {
        return this.e;
    }

    public final AbstractC3336Al1 c() {
        return this.f;
    }

    public final XE4 d() {
        return this.c;
    }

    public final EnumC23696xM4 e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10776cA7)) {
            return false;
        }
        C10776cA7 c10776cA7 = (C10776cA7) obj;
        return this.a == c10776cA7.a && this.b == c10776cA7.b && AbstractC13042fc3.d(this.c, c10776cA7.c) && AbstractC13042fc3.d(this.d, c10776cA7.d) && AbstractC13042fc3.d(this.e, c10776cA7.e) && AbstractC13042fc3.d(this.f, c10776cA7.f) && this.g == c10776cA7.g && AbstractC13042fc3.d(this.h, c10776cA7.h);
    }

    public final G47 f() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31;
        XE4 xe4 = this.c;
        int iHashCode2 = (((iHashCode + (xe4 == null ? 0 : xe4.hashCode())) * 31) + this.d.hashCode()) * 31;
        AbstractC3336Al1 abstractC3336Al1 = this.e;
        int iHashCode3 = (iHashCode2 + (abstractC3336Al1 == null ? 0 : abstractC3336Al1.hashCode())) * 31;
        AbstractC3336Al1 abstractC3336Al12 = this.f;
        return ((((iHashCode3 + (abstractC3336Al12 != null ? abstractC3336Al12.hashCode() : 0)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "UIState(currentIndex=" + this.a + ", totalContents=" + this.b + ", notifier=" + this.c + ", contentCenter=" + this.d + ", contentLeft=" + this.e + ", contentRight=" + this.f + ", orientation=" + this.g + ", systemBarState=" + this.h + Separators.RPAREN;
    }

    public /* synthetic */ C10776cA7(int i, int i2, XE4 xe4, AbstractC3336Al1 abstractC3336Al1, AbstractC3336Al1 abstractC3336Al12, AbstractC3336Al1 abstractC3336Al13, EnumC23696xM4 enumC23696xM4, G47 g47, int i3, ED1 ed1) {
        this(i, i2, (i3 & 4) != 0 ? null : xe4, abstractC3336Al1, (i3 & 16) != 0 ? null : abstractC3336Al12, (i3 & 32) != 0 ? null : abstractC3336Al13, (i3 & 64) != 0 ? EnumC23696xM4.a.a() : enumC23696xM4, (i3 & 128) != 0 ? new G47(false, false, 3, null) : g47);
    }
}
