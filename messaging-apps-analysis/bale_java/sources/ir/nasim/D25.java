package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* loaded from: classes5.dex */
public final class D25 {
    private final String a;
    private final Avatar b;
    private final boolean c;
    private final ir.nasim.features.mxp.entity.a d;

    public D25(String str, Avatar avatar, boolean z, ir.nasim.features.mxp.entity.a aVar) {
        AbstractC13042fc3.i(str, "title");
        this.a = str;
        this.b = avatar;
        this.c = z;
        this.d = aVar;
    }

    public final Avatar a() {
        return this.b;
    }

    public final ir.nasim.features.mxp.entity.a b() {
        return this.d;
    }

    public final String c() {
        return this.a;
    }

    public final boolean d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D25)) {
            return false;
        }
        D25 d25 = (D25) obj;
        return AbstractC13042fc3.d(this.a, d25.a) && AbstractC13042fc3.d(this.b, d25.b) && this.c == d25.c && this.d == d25.d;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Avatar avatar = this.b;
        int iHashCode2 = (((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.c)) * 31;
        ir.nasim.features.mxp.entity.a aVar = this.d;
        return iHashCode2 + (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "PeerDesc(title=" + this.a + ", avatar=" + this.b + ", isDeletedAccount=" + this.c + ", puppetType=" + this.d + Separators.RPAREN;
    }
}
