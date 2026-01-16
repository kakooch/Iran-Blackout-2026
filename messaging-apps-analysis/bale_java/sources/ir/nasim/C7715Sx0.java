package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.Sx0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C7715Sx0 implements InterfaceC5569Jx0 {
    private final String a;
    private final Drawable b;
    private final SA2 c;
    private final boolean d;
    private final DL4 e;

    public C7715Sx0(String str, Drawable drawable, SA2 sa2, boolean z, DL4 dl4) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(sa2, "onClick");
        AbstractC13042fc3.i(dl4, "type");
        this.a = str;
        this.b = drawable;
        this.c = sa2;
        this.d = z;
        this.e = dl4;
    }

    @Override // ir.nasim.InterfaceC5569Jx0
    public boolean a() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC5569Jx0
    public SA2 b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7715Sx0)) {
            return false;
        }
        C7715Sx0 c7715Sx0 = (C7715Sx0) obj;
        return AbstractC13042fc3.d(this.a, c7715Sx0.a) && AbstractC13042fc3.d(this.b, c7715Sx0.b) && AbstractC13042fc3.d(this.c, c7715Sx0.c) && this.d == c7715Sx0.d && this.e == c7715Sx0.e;
    }

    @Override // ir.nasim.InterfaceC5569Jx0
    public Drawable getIcon() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC5569Jx0
    public String getTitle() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Drawable drawable = this.b;
        return ((((((iHashCode + (drawable == null ? 0 : drawable.hashCode())) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "CallOptionItem(title=" + this.a + ", icon=" + this.b + ", onClick=" + this.c + ", doesHaveNewBadge=" + this.d + ", type=" + this.e + Separators.RPAREN;
    }
}
