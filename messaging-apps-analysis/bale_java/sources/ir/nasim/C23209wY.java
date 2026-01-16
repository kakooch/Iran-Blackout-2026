package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.wY, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C23209wY {
    private final int a;
    private final String b;
    private final Avatar c;
    private final boolean d;
    private final String e;
    private final InterfaceC4557Fq2 f;

    public C23209wY(int i, String str, Avatar avatar, boolean z, String str2, InterfaceC4557Fq2 interfaceC4557Fq2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(interfaceC4557Fq2, "lastSeen");
        this.a = i;
        this.b = str;
        this.c = avatar;
        this.d = z;
        this.e = str2;
        this.f = interfaceC4557Fq2;
    }

    public final int a() {
        return this.a;
    }

    public final Avatar b() {
        return this.c;
    }

    public final InterfaceC4557Fq2 c() {
        return this.f;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23209wY)) {
            return false;
        }
        C23209wY c23209wY = (C23209wY) obj;
        return this.a == c23209wY.a && AbstractC13042fc3.d(this.b, c23209wY.b) && AbstractC13042fc3.d(this.c, c23209wY.c) && this.d == c23209wY.d && AbstractC13042fc3.d(this.e, c23209wY.e) && AbstractC13042fc3.d(this.f, c23209wY.f);
    }

    public final boolean f() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Avatar avatar = this.c;
        int iHashCode2 = (((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31;
        String str = this.e;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "BaleContactItem(id=" + this.a + ", name=" + this.b + ", image=" + this.c + ", isBot=" + this.d + ", nick=" + this.e + ", lastSeen=" + this.f + Separators.RPAREN;
    }
}
