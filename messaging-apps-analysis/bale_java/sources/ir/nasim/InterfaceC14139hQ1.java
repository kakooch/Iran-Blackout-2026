package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.hQ1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC14139hQ1 {

    /* renamed from: ir.nasim.hQ1$c */
    public static final class c implements InterfaceC14139hQ1 {
        public static final c a = new c();

        private c() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -1170230933;
        }

        public String toString() {
            return "ShareMode";
        }
    }

    /* renamed from: ir.nasim.hQ1$a */
    public static final class a implements InterfaceC14139hQ1 {
        private final XI3 a;
        private final boolean b;
        private final AbstractC9512a53 c;
        private final String d;

        public a(XI3 xi3, boolean z, AbstractC9512a53 abstractC9512a53, String str) {
            AbstractC13042fc3.i(xi3, "logoState");
            AbstractC13042fc3.i(abstractC9512a53, "inAppUpdateMenuState");
            this.a = xi3;
            this.b = z;
            this.c = abstractC9512a53;
            this.d = str;
        }

        public static /* synthetic */ a b(a aVar, XI3 xi3, boolean z, AbstractC9512a53 abstractC9512a53, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                xi3 = aVar.a;
            }
            if ((i & 2) != 0) {
                z = aVar.b;
            }
            if ((i & 4) != 0) {
                abstractC9512a53 = aVar.c;
            }
            if ((i & 8) != 0) {
                str = aVar.d;
            }
            return aVar.a(xi3, z, abstractC9512a53, str);
        }

        public final a a(XI3 xi3, boolean z, AbstractC9512a53 abstractC9512a53, String str) {
            AbstractC13042fc3.i(xi3, "logoState");
            AbstractC13042fc3.i(abstractC9512a53, "inAppUpdateMenuState");
            return new a(xi3, z, abstractC9512a53, str);
        }

        public final AbstractC9512a53 c() {
            return this.c;
        }

        public final XI3 d() {
            return this.a;
        }

        public final boolean e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d);
        }

        public int hashCode() {
            int iHashCode = ((((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + this.c.hashCode()) * 31;
            String str = this.d;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Normal(logoState=" + this.a + ", showBadgeMenu=" + this.b + ", inAppUpdateMenuState=" + this.c + ", premiumBadgeContent=" + this.d + Separators.RPAREN;
        }

        public /* synthetic */ a(XI3 xi3, boolean z, AbstractC9512a53 abstractC9512a53, String str, int i, ED1 ed1) {
            this(xi3, z, abstractC9512a53, (i & 8) != 0 ? null : str);
        }
    }

    /* renamed from: ir.nasim.hQ1$b */
    public static final class b implements InterfaceC14139hQ1 {
        private final int a;
        private final boolean b;
        private final boolean c;
        private final boolean d;
        private final boolean e;
        private final EnumC7540Sd5 f;
        private final EnumC19108pn4 g;
        private final boolean h;
        private final EnumC5526Js2 i;
        private final boolean j;
        private final boolean k;
        private final EnumC18820pJ l;

        public b(int i, boolean z, boolean z2, boolean z3, boolean z4, EnumC7540Sd5 enumC7540Sd5, EnumC19108pn4 enumC19108pn4, boolean z5, EnumC5526Js2 enumC5526Js2, boolean z6, boolean z7, EnumC18820pJ enumC18820pJ) {
            this.a = i;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.e = z4;
            this.f = enumC7540Sd5;
            this.g = enumC19108pn4;
            this.h = z5;
            this.i = enumC5526Js2;
            this.j = z6;
            this.k = z7;
            this.l = enumC18820pJ;
        }

        public final b a(int i, boolean z, boolean z2, boolean z3, boolean z4, EnumC7540Sd5 enumC7540Sd5, EnumC19108pn4 enumC19108pn4, boolean z5, EnumC5526Js2 enumC5526Js2, boolean z6, boolean z7, EnumC18820pJ enumC18820pJ) {
            return new b(i, z, z2, z3, z4, enumC7540Sd5, enumC19108pn4, z5, enumC5526Js2, z6, z7, enumC18820pJ);
        }

        public final EnumC18820pJ c() {
            return this.l;
        }

        public final EnumC5526Js2 d() {
            return this.i;
        }

        public final EnumC19108pn4 e() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g && this.h == bVar.h && this.i == bVar.i && this.j == bVar.j && this.k == bVar.k && this.l == bVar.l;
        }

        public final EnumC7540Sd5 f() {
            return this.f;
        }

        public final int g() {
            return this.a;
        }

        public final boolean h() {
            return this.c;
        }

        public int hashCode() {
            int iHashCode = ((((((((Integer.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31;
            EnumC7540Sd5 enumC7540Sd5 = this.f;
            int iHashCode2 = (iHashCode + (enumC7540Sd5 == null ? 0 : enumC7540Sd5.hashCode())) * 31;
            EnumC19108pn4 enumC19108pn4 = this.g;
            int iHashCode3 = (((iHashCode2 + (enumC19108pn4 == null ? 0 : enumC19108pn4.hashCode())) * 31) + Boolean.hashCode(this.h)) * 31;
            EnumC5526Js2 enumC5526Js2 = this.i;
            int iHashCode4 = (((((iHashCode3 + (enumC5526Js2 == null ? 0 : enumC5526Js2.hashCode())) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31;
            EnumC18820pJ enumC18820pJ = this.l;
            return iHashCode4 + (enumC18820pJ != null ? enumC18820pJ.hashCode() : 0);
        }

        public final boolean i() {
            return this.k;
        }

        public final boolean j() {
            return this.j;
        }

        public final boolean k() {
            return this.h;
        }

        public final boolean l() {
            return this.d;
        }

        public final boolean m() {
            return this.e;
        }

        public final boolean n() {
            return this.b;
        }

        public String toString() {
            return "SelectionMode(selectedItemCount=" + this.a + ", isSelectAll=" + this.b + ", shouldShowContactProfile=" + this.c + ", isMoreMenuExpanded=" + this.d + ", isMoreMenuVisible=" + this.e + ", pinState=" + this.f + ", muteState=" + this.g + ", isMarkAsRead=" + this.h + ", folderMenuState=" + this.i + ", showBadgeMore=" + this.j + ", showBadgeArchive=" + this.k + ", archiveState=" + this.l + Separators.RPAREN;
        }

        public /* synthetic */ b(int i, boolean z, boolean z2, boolean z3, boolean z4, EnumC7540Sd5 enumC7540Sd5, EnumC19108pn4 enumC19108pn4, boolean z5, EnumC5526Js2 enumC5526Js2, boolean z6, boolean z7, EnumC18820pJ enumC18820pJ, int i2, ED1 ed1) {
            this(i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3, (i2 & 16) != 0 ? true : z4, (i2 & 32) != 0 ? null : enumC7540Sd5, (i2 & 64) != 0 ? null : enumC19108pn4, (i2 & 128) != 0 ? false : z5, (i2 & 256) != 0 ? null : enumC5526Js2, z6, z7, (i2 & 2048) != 0 ? null : enumC18820pJ);
        }
    }
}
