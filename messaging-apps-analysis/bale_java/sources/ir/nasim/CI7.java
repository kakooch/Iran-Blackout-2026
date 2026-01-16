package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* loaded from: classes5.dex */
public final class CI7 {
    public static final a f = new a(null);
    private final int a;
    private final String b;
    private final Avatar c;
    private final boolean d;
    private final boolean e;

    public static final class a {
        private a() {
        }

        public final CI7 a(C17637nI7 c17637nI7) {
            AbstractC13042fc3.i(c17637nI7, "user");
            int iN0 = c17637nI7.n0();
            String name = c17637nI7.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            return new CI7(iN0, name, c17637nI7.S(), c17637nI7.r0(), c17637nI7.p0());
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public CI7(int i, String str, Avatar avatar, boolean z, boolean z2) {
        AbstractC13042fc3.i(str, "name");
        this.a = i;
        this.b = str;
        this.c = avatar;
        this.d = z;
        this.e = z2;
    }

    public final Avatar a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CI7)) {
            return false;
        }
        CI7 ci7 = (CI7) obj;
        return this.a == ci7.a && AbstractC13042fc3.d(this.b, ci7.b) && AbstractC13042fc3.d(this.c, ci7.c) && this.d == ci7.d && this.e == ci7.e;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Avatar avatar = this.c;
        return ((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "UserLight(uid=" + this.a + ", name=" + this.b + ", avatar=" + this.c + ", isDeletedAccount=" + this.d + ", isBot=" + this.e + Separators.RPAREN;
    }
}
