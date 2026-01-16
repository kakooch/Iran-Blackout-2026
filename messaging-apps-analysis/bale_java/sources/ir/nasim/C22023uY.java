package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.uY, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C22023uY {
    private final int a;
    private final String b;
    private final a c;
    private final boolean d;
    private final PI7 e;

    /* renamed from: ir.nasim.uY$a */
    public static abstract class a {

        /* renamed from: ir.nasim.uY$a$a, reason: collision with other inner class name */
        public static final class C1635a extends a {
            private final Avatar a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1635a(Avatar avatar) {
                super(null);
                AbstractC13042fc3.i(avatar, "avatar");
                this.a = avatar;
            }

            public final Avatar a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C1635a) && AbstractC13042fc3.d(this.a, ((C1635a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "AvatarImage(avatar=" + this.a + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.uY$a$b */
        public static final class b extends a {
            private final int a;

            public b(int i) {
                super(null);
                this.a = i;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && this.a == ((b) obj).a;
            }

            public int hashCode() {
                return Integer.hashCode(this.a);
            }

            public String toString() {
                return "ResourceImage(resourceId=" + this.a + Separators.RPAREN;
            }
        }

        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C22023uY(int i, String str, a aVar, boolean z, PI7 pi7) {
        AbstractC13042fc3.i(str, "name");
        this.a = i;
        this.b = str;
        this.c = aVar;
        this.d = z;
        this.e = pi7;
    }

    public static /* synthetic */ C22023uY b(C22023uY c22023uY, int i, String str, a aVar, boolean z, PI7 pi7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = c22023uY.a;
        }
        if ((i2 & 2) != 0) {
            str = c22023uY.b;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            aVar = c22023uY.c;
        }
        a aVar2 = aVar;
        if ((i2 & 8) != 0) {
            z = c22023uY.d;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            pi7 = c22023uY.e;
        }
        return c22023uY.a(i, str2, aVar2, z2, pi7);
    }

    public final C22023uY a(int i, String str, a aVar, boolean z, PI7 pi7) {
        AbstractC13042fc3.i(str, "name");
        return new C22023uY(i, str, aVar, z, pi7);
    }

    public final int c() {
        return this.a;
    }

    public final a d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22023uY)) {
            return false;
        }
        C22023uY c22023uY = (C22023uY) obj;
        return this.a == c22023uY.a && AbstractC13042fc3.d(this.b, c22023uY.b) && AbstractC13042fc3.d(this.c, c22023uY.c) && this.d == c22023uY.d && AbstractC13042fc3.d(this.e, c22023uY.e);
    }

    public final PI7 f() {
        return this.e;
    }

    public final boolean g() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        a aVar = this.c;
        int iHashCode2 = (((iHashCode + (aVar == null ? 0 : aVar.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31;
        PI7 pi7 = this.e;
        return iHashCode2 + (pi7 != null ? pi7.hashCode() : 0);
    }

    public String toString() {
        return "BaleContactItem(id=" + this.a + ", name=" + this.b + ", image=" + this.c + ", isBot=" + this.d + ", presence=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C22023uY(int i, String str, a aVar, boolean z, PI7 pi7, int i2, ED1 ed1) {
        this(i, str, aVar, z, (i2 & 16) != 0 ? null : pi7);
    }
}
