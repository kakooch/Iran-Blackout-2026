package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* loaded from: classes4.dex */
public final class WL4 {
    private final int a;
    private final String b;
    private final String c;
    private final Avatar d;
    private final boolean e;
    private final InterfaceC4557Fq2 f;

    public WL4(int i, String str, String str2, Avatar avatar, boolean z, InterfaceC4557Fq2 interfaceC4557Fq2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(interfaceC4557Fq2, "lastSeen");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = avatar;
        this.e = z;
        this.f = interfaceC4557Fq2;
    }

    public final int a() {
        return this.a;
    }

    public final Avatar b() {
        return this.d;
    }

    public final InterfaceC4557Fq2 c() {
        return this.f;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WL4)) {
            return false;
        }
        WL4 wl4 = (WL4) obj;
        return this.a == wl4.a && AbstractC13042fc3.d(this.b, wl4.b) && AbstractC13042fc3.d(this.c, wl4.c) && AbstractC13042fc3.d(this.d, wl4.d) && this.e == wl4.e && AbstractC13042fc3.d(this.f, wl4.f);
    }

    public final boolean f() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Avatar avatar = this.d;
        return ((((iHashCode2 + (avatar != null ? avatar.hashCode() : 0)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "OrganizationContactItem(id=" + this.a + ", name=" + this.b + ", nick=" + this.c + ", image=" + this.d + ", isBot=" + this.e + ", lastSeen=" + this.f + Separators.RPAREN;
    }
}
