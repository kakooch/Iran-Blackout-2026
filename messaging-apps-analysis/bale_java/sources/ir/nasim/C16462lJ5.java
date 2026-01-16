package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.lJ5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C16462lJ5 {
    private final int a;
    private final String b;
    private final boolean c;
    private final String d;
    private final Avatar e;

    public C16462lJ5(int i, String str, boolean z, String str2, Avatar avatar) {
        AbstractC13042fc3.i(str, "title");
        this.a = i;
        this.b = str;
        this.c = z;
        this.d = str2;
        this.e = avatar;
    }

    public final Avatar a() {
        return this.e;
    }

    public final String b() {
        return this.d;
    }

    public final boolean c() {
        return this.c;
    }

    public final int d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16462lJ5)) {
            return false;
        }
        C16462lJ5 c16462lJ5 = (C16462lJ5) obj;
        return this.a == c16462lJ5.a && AbstractC13042fc3.d(this.b, c16462lJ5.b) && this.c == c16462lJ5.c && AbstractC13042fc3.d(this.d, c16462lJ5.d) && AbstractC13042fc3.d(this.e, c16462lJ5.e);
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31;
        String str = this.d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Avatar avatar = this.e;
        return iHashCode2 + (avatar != null ? avatar.hashCode() : 0);
    }

    public String toString() {
        return "RecommendedPeer(peerId=" + this.a + ", title=" + this.b + ", hasBlueTick=" + this.c + ", description=" + this.d + ", avatar=" + this.e + Separators.RPAREN;
    }
}
