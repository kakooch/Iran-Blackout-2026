package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* loaded from: classes4.dex */
public final class BI7 {
    private final int a;
    private final String b;
    private final Avatar c;
    private final boolean d;
    private final InterfaceC4557Fq2 e;
    private final boolean f;

    public BI7(int i, String str, Avatar avatar, boolean z, InterfaceC4557Fq2 interfaceC4557Fq2, boolean z2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(interfaceC4557Fq2, "lastSeen");
        this.a = i;
        this.b = str;
        this.c = avatar;
        this.d = z;
        this.e = interfaceC4557Fq2;
        this.f = z2;
    }

    public static /* synthetic */ BI7 b(BI7 bi7, int i, String str, Avatar avatar, boolean z, InterfaceC4557Fq2 interfaceC4557Fq2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bi7.a;
        }
        if ((i2 & 2) != 0) {
            str = bi7.b;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            avatar = bi7.c;
        }
        Avatar avatar2 = avatar;
        if ((i2 & 8) != 0) {
            z = bi7.d;
        }
        boolean z3 = z;
        if ((i2 & 16) != 0) {
            interfaceC4557Fq2 = bi7.e;
        }
        InterfaceC4557Fq2 interfaceC4557Fq22 = interfaceC4557Fq2;
        if ((i2 & 32) != 0) {
            z2 = bi7.f;
        }
        return bi7.a(i, str2, avatar2, z3, interfaceC4557Fq22, z2);
    }

    public final BI7 a(int i, String str, Avatar avatar, boolean z, InterfaceC4557Fq2 interfaceC4557Fq2, boolean z2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(interfaceC4557Fq2, "lastSeen");
        return new BI7(i, str, avatar, z, interfaceC4557Fq2, z2);
    }

    public final Avatar c() {
        return this.c;
    }

    public final int d() {
        return this.a;
    }

    public final InterfaceC4557Fq2 e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BI7)) {
            return false;
        }
        BI7 bi7 = (BI7) obj;
        return this.a == bi7.a && AbstractC13042fc3.d(this.b, bi7.b) && AbstractC13042fc3.d(this.c, bi7.c) && this.d == bi7.d && AbstractC13042fc3.d(this.e, bi7.e) && this.f == bi7.f;
    }

    public final String f() {
        return this.b;
    }

    public final boolean g() {
        return this.f;
    }

    public final boolean h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Avatar avatar = this.c;
        return ((((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "UserInviteModel(id=" + this.a + ", name=" + this.b + ", avatar=" + this.c + ", isSelected=" + this.d + ", lastSeen=" + this.e + ", isBot=" + this.f + Separators.RPAREN;
    }

    public /* synthetic */ BI7(int i, String str, Avatar avatar, boolean z, InterfaceC4557Fq2 interfaceC4557Fq2, boolean z2, int i2, ED1 ed1) {
        this(i, str, avatar, (i2 & 8) != 0 ? true : z, interfaceC4557Fq2, z2);
    }
}
