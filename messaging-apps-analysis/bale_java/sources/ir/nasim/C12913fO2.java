package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.fO2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12913fO2 {
    private final int a;
    private final E25 b;
    private final String c;
    private final int d;
    private final Avatar e;
    private final boolean f;

    public C12913fO2(int i, E25 e25, String str, int i2, Avatar avatar, boolean z) {
        AbstractC13042fc3.i(e25, "peerIdentity");
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(avatar, "avatar");
        this.a = i;
        this.b = e25;
        this.c = str;
        this.d = i2;
        this.e = avatar;
        this.f = z;
    }

    public static /* synthetic */ C12913fO2 b(C12913fO2 c12913fO2, int i, E25 e25, String str, int i2, Avatar avatar, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = c12913fO2.a;
        }
        if ((i3 & 2) != 0) {
            e25 = c12913fO2.b;
        }
        E25 e252 = e25;
        if ((i3 & 4) != 0) {
            str = c12913fO2.c;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            i2 = c12913fO2.d;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            avatar = c12913fO2.e;
        }
        Avatar avatar2 = avatar;
        if ((i3 & 32) != 0) {
            z = c12913fO2.f;
        }
        return c12913fO2.a(i, e252, str2, i4, avatar2, z);
    }

    public final C12913fO2 a(int i, E25 e25, String str, int i2, Avatar avatar, boolean z) {
        AbstractC13042fc3.i(e25, "peerIdentity");
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(avatar, "avatar");
        return new C12913fO2(i, e25, str, i2, avatar, z);
    }

    public final Avatar c() {
        return this.e;
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12913fO2)) {
            return false;
        }
        C12913fO2 c12913fO2 = (C12913fO2) obj;
        return this.a == c12913fO2.a && this.b == c12913fO2.b && AbstractC13042fc3.d(this.c, c12913fO2.c) && this.d == c12913fO2.d && AbstractC13042fc3.d(this.e, c12913fO2.e) && this.f == c12913fO2.f;
    }

    public final E25 f() {
        return this.b;
    }

    public final String g() {
        return this.c;
    }

    public final boolean h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f);
    }

    public final C11458d25 i() {
        return new C11458d25(W25.b, this.a);
    }

    public String toString() {
        return "GroupUI(groupId=" + this.a + ", peerIdentity=" + this.b + ", title=" + this.c + ", memberCount=" + this.d + ", avatar=" + this.e + ", isMember=" + this.f + Separators.RPAREN;
    }
}
