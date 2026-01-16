package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.Es7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4346Es7 {
    private final C11458d25 a;
    private final Avatar b;
    private final String c;
    private final long d;
    private final boolean e;

    public C4346Es7(C11458d25 c11458d25, Avatar avatar, String str, long j, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, "username");
        this.a = c11458d25;
        this.b = avatar;
        this.c = str;
        this.d = j;
        this.e = z;
    }

    public final Avatar a() {
        return this.b;
    }

    public final C11458d25 b() {
        return this.a;
    }

    public final long c() {
        return this.d;
    }

    public final String d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4346Es7)) {
            return false;
        }
        C4346Es7 c4346Es7 = (C4346Es7) obj;
        return AbstractC13042fc3.d(this.a, c4346Es7.a) && AbstractC13042fc3.d(this.b, c4346Es7.b) && AbstractC13042fc3.d(this.c, c4346Es7.c) && this.d == c4346Es7.d && this.e == c4346Es7.e;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Avatar avatar = this.b;
        return ((((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "TopPeer(peer=" + this.a + ", avatar=" + this.b + ", username=" + this.c + ", score=" + this.d + ", isSavedMessages=" + this.e + Separators.RPAREN;
    }
}
