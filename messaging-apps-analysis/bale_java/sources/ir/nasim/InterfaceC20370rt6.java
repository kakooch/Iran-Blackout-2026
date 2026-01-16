package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.rt6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC20370rt6 {
    EnumC19761qt6 a();

    /* renamed from: ir.nasim.rt6$a */
    public static final class a implements InterfaceC20370rt6 {
        private final int a;
        private final String b;
        private final EnumC19761qt6 c;
        private final AbstractC12710f43 d;

        public a(int i, String str, EnumC19761qt6 enumC19761qt6, AbstractC12710f43 abstractC12710f43) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(enumC19761qt6, "sectionState");
            this.a = i;
            this.b = str;
            this.c = enumC19761qt6;
            this.d = abstractC12710f43;
        }

        @Override // ir.nasim.InterfaceC20370rt6
        public EnumC19761qt6 a() {
            return this.c;
        }

        public final AbstractC12710f43 b() {
            return this.d;
        }

        public int c() {
            return this.a;
        }

        public String d() {
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
            return this.a == aVar.a && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c && AbstractC13042fc3.d(this.d, aVar.d);
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            AbstractC12710f43 abstractC12710f43 = this.d;
            return iHashCode + (abstractC12710f43 == null ? 0 : abstractC12710f43.hashCode());
        }

        public String toString() {
            return "Banner(title='" + d() + "', sectionState=" + a() + ", bannerUIs=" + this.d + Separators.RPAREN;
        }

        public /* synthetic */ a(int i, String str, EnumC19761qt6 enumC19761qt6, AbstractC12710f43 abstractC12710f43, int i2, ED1 ed1) {
            this(i, str, (i2 & 4) != 0 ? EnumC19761qt6.a : enumC19761qt6, (i2 & 8) != 0 ? null : abstractC12710f43);
        }
    }

    /* renamed from: ir.nasim.rt6$b */
    public static final class b implements InterfaceC20370rt6 {
        private final int a;
        private final String b;
        private final EnumC19761qt6 c;
        private final List d;

        public b(int i, String str, EnumC19761qt6 enumC19761qt6, List list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(enumC19761qt6, "sectionState");
            this.a = i;
            this.b = str;
            this.c = enumC19761qt6;
            this.d = list;
        }

        @Override // ir.nasim.InterfaceC20370rt6
        public EnumC19761qt6 a() {
            return this.c;
        }

        public final List b() {
            return this.d;
        }

        public int c() {
            return this.a;
        }

        public String d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c && AbstractC13042fc3.d(this.d, bVar.d);
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            List list = this.d;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "BotsVitrine(title='" + d() + "', sectionState=" + a() + ", botItemUIs=" + this.d + Separators.RPAREN;
        }

        public /* synthetic */ b(int i, String str, EnumC19761qt6 enumC19761qt6, List list, int i2, ED1 ed1) {
            this(i, str, (i2 & 4) != 0 ? EnumC19761qt6.a : enumC19761qt6, (i2 & 8) != 0 ? null : list);
        }
    }

    /* renamed from: ir.nasim.rt6$d */
    public static final class d implements InterfaceC20370rt6 {
        private final int a;
        private final String b;
        private final EnumC19761qt6 c;
        private final List d;

        public d(int i, String str, EnumC19761qt6 enumC19761qt6, List list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(enumC19761qt6, "sectionState");
            this.a = i;
            this.b = str;
            this.c = enumC19761qt6;
            this.d = list;
        }

        @Override // ir.nasim.InterfaceC20370rt6
        public EnumC19761qt6 a() {
            return this.c;
        }

        public int b() {
            return this.a;
        }

        public final List c() {
            return this.d;
        }

        public String d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && AbstractC13042fc3.d(this.b, dVar.b) && this.c == dVar.c && AbstractC13042fc3.d(this.d, dVar.d);
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            List list = this.d;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "CustomServices(title='" + d() + "', sectionState=" + a() + ", serviceItemUIs=" + this.d + Separators.RPAREN;
        }

        public /* synthetic */ d(int i, String str, EnumC19761qt6 enumC19761qt6, List list, int i2, ED1 ed1) {
            this(i, str, (i2 & 4) != 0 ? EnumC19761qt6.a : enumC19761qt6, (i2 & 8) != 0 ? null : list);
        }
    }

    /* renamed from: ir.nasim.rt6$f */
    public static final class f implements InterfaceC20370rt6 {
        private final int a;
        private final String b;
        private final EnumC19761qt6 c;
        private final AbstractC12710f43 d;

        public f(int i, String str, EnumC19761qt6 enumC19761qt6, AbstractC12710f43 abstractC12710f43) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(enumC19761qt6, "sectionState");
            this.a = i;
            this.b = str;
            this.c = enumC19761qt6;
            this.d = abstractC12710f43;
        }

        @Override // ir.nasim.InterfaceC20370rt6
        public EnumC19761qt6 a() {
            return this.c;
        }

        public int b() {
            return this.a;
        }

        public final AbstractC12710f43 c() {
            return this.d;
        }

        public String d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.a == fVar.a && AbstractC13042fc3.d(this.b, fVar.b) && this.c == fVar.c && AbstractC13042fc3.d(this.d, fVar.d);
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            AbstractC12710f43 abstractC12710f43 = this.d;
            return iHashCode + (abstractC12710f43 == null ? 0 : abstractC12710f43.hashCode());
        }

        public String toString() {
            return "ServicesShortcuts(title='" + d() + "', sectionState=" + a() + ", serviceShortcutUIs=" + this.d + Separators.RPAREN;
        }

        public /* synthetic */ f(int i, String str, EnumC19761qt6 enumC19761qt6, AbstractC12710f43 abstractC12710f43, int i2, ED1 ed1) {
            this(i, str, (i2 & 4) != 0 ? EnumC19761qt6.a : enumC19761qt6, (i2 & 8) != 0 ? null : abstractC12710f43);
        }
    }

    /* renamed from: ir.nasim.rt6$g */
    public static final class g implements InterfaceC20370rt6 {
        private final int a;
        private final String b;
        private final EnumC19761qt6 c;
        private final Long d;
        private final QJ2 e;
        private final List f;

        public g(int i, String str, EnumC19761qt6 enumC19761qt6, Long l, QJ2 qj2, List list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(enumC19761qt6, "sectionState");
            AbstractC13042fc3.i(qj2, "goldWalletUI");
            this.a = i;
            this.b = str;
            this.c = enumC19761qt6;
            this.d = l;
            this.e = qj2;
            this.f = list;
        }

        public static /* synthetic */ g c(g gVar, int i, String str, EnumC19761qt6 enumC19761qt6, Long l, QJ2 qj2, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = gVar.a;
            }
            if ((i2 & 2) != 0) {
                str = gVar.b;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                enumC19761qt6 = gVar.c;
            }
            EnumC19761qt6 enumC19761qt62 = enumC19761qt6;
            if ((i2 & 8) != 0) {
                l = gVar.d;
            }
            Long l2 = l;
            if ((i2 & 16) != 0) {
                qj2 = gVar.e;
            }
            QJ2 qj22 = qj2;
            if ((i2 & 32) != 0) {
                list = gVar.f;
            }
            return gVar.b(i, str2, enumC19761qt62, l2, qj22, list);
        }

        @Override // ir.nasim.InterfaceC20370rt6
        public EnumC19761qt6 a() {
            return this.c;
        }

        public final g b(int i, String str, EnumC19761qt6 enumC19761qt6, Long l, QJ2 qj2, List list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(enumC19761qt6, "sectionState");
            AbstractC13042fc3.i(qj2, "goldWalletUI");
            return new g(i, str, enumC19761qt6, l, qj2, list);
        }

        public final List d() {
            return this.f;
        }

        public final QJ2 e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.a == gVar.a && AbstractC13042fc3.d(this.b, gVar.b) && this.c == gVar.c && AbstractC13042fc3.d(this.d, gVar.d) && AbstractC13042fc3.d(this.e, gVar.e) && AbstractC13042fc3.d(this.f, gVar.f);
        }

        public String f() {
            return this.b;
        }

        public final Long g() {
            return this.d;
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            Long l = this.d;
            int iHashCode2 = (((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.e.hashCode()) * 31;
            List list = this.f;
            return iHashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Wallet(title='" + f() + "', sectionState=" + a() + ", walletBalance=" + this.d + ", goldWalletBalance=" + this.e.c() + ", creditCards=" + this.f + Separators.RPAREN;
        }

        public /* synthetic */ g(int i, String str, EnumC19761qt6 enumC19761qt6, Long l, QJ2 qj2, List list, int i2, ED1 ed1) {
            this(i, str, (i2 & 4) != 0 ? EnumC19761qt6.a : enumC19761qt6, (i2 & 8) != 0 ? null : l, (i2 & 16) != 0 ? new QJ2(false, null, false, 7, null) : qj2, (i2 & 32) != 0 ? null : list);
        }
    }

    /* renamed from: ir.nasim.rt6$e */
    public static final class e implements InterfaceC20370rt6 {
        private final int a;
        private final String b;
        private final EnumC19761qt6 c;
        private final String d;
        private final EnumC18579ot6 e;
        private final int f;
        private final EnumC19170pt6 g;
        private final List h;

        public e(int i, String str, EnumC19761qt6 enumC19761qt6, String str2, EnumC18579ot6 enumC18579ot6, int i2, EnumC19170pt6 enumC19170pt6, List list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(enumC19761qt6, "sectionState");
            AbstractC13042fc3.i(str2, "buttonText");
            AbstractC13042fc3.i(enumC18579ot6, "navigationType");
            AbstractC13042fc3.i(enumC19170pt6, "badgeType");
            this.a = i;
            this.b = str;
            this.c = enumC19761qt6;
            this.d = str2;
            this.e = enumC18579ot6;
            this.f = i2;
            this.g = enumC19170pt6;
            this.h = list;
        }

        @Override // ir.nasim.InterfaceC20370rt6
        public EnumC19761qt6 a() {
            return this.c;
        }

        public final e b(int i, String str, EnumC19761qt6 enumC19761qt6, String str2, EnumC18579ot6 enumC18579ot6, int i2, EnumC19170pt6 enumC19170pt6, List list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(enumC19761qt6, "sectionState");
            AbstractC13042fc3.i(str2, "buttonText");
            AbstractC13042fc3.i(enumC18579ot6, "navigationType");
            AbstractC13042fc3.i(enumC19170pt6, "badgeType");
            return new e(i, str, enumC19761qt6, str2, enumC18579ot6, i2, enumC19170pt6, list);
        }

        public final EnumC19170pt6 d() {
            return this.g;
        }

        public final String e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.a == eVar.a && AbstractC13042fc3.d(this.b, eVar.b) && this.c == eVar.c && AbstractC13042fc3.d(this.d, eVar.d) && this.e == eVar.e && this.f == eVar.f && this.g == eVar.g && AbstractC13042fc3.d(this.h, eVar.h);
        }

        public final int f() {
            return this.f;
        }

        public final EnumC18579ot6 g() {
            return this.e;
        }

        public int h() {
            return this.a;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode()) * 31;
            List list = this.h;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public final List i() {
            return this.h;
        }

        public String j() {
            return this.b;
        }

        public String toString() {
            return "ServiceItemsExtra(title='" + j() + "', sectionState=" + a() + ", serviceItemUIs=" + this.h + Separators.RPAREN;
        }

        public /* synthetic */ e(int i, String str, EnumC19761qt6 enumC19761qt6, String str2, EnumC18579ot6 enumC18579ot6, int i2, EnumC19170pt6 enumC19170pt6, List list, int i3, ED1 ed1) {
            this(i, str, (i3 & 4) != 0 ? EnumC19761qt6.a : enumC19761qt6, str2, enumC18579ot6, i2, enumC19170pt6, (i3 & 128) != 0 ? null : list);
        }
    }

    /* renamed from: ir.nasim.rt6$c */
    public static final class c implements InterfaceC20370rt6 {
        private final int a;
        private final String b;
        private final EnumC19761qt6 c;
        private final String d;
        private final EnumC18579ot6 e;
        private final String f;
        private final int g;
        private final EnumC19170pt6 h;
        private final List i;

        public c(int i, String str, EnumC19761qt6 enumC19761qt6, String str2, EnumC18579ot6 enumC18579ot6, String str3, int i2, EnumC19170pt6 enumC19170pt6, List list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(enumC19761qt6, "sectionState");
            AbstractC13042fc3.i(str2, "buttonText");
            AbstractC13042fc3.i(enumC18579ot6, "navigationType");
            AbstractC13042fc3.i(str3, "navigationDestinationUrl");
            AbstractC13042fc3.i(enumC19170pt6, "badgeType");
            this.a = i;
            this.b = str;
            this.c = enumC19761qt6;
            this.d = str2;
            this.e = enumC18579ot6;
            this.f = str3;
            this.g = i2;
            this.h = enumC19170pt6;
            this.i = list;
        }

        @Override // ir.nasim.InterfaceC20370rt6
        public EnumC19761qt6 a() {
            return this.c;
        }

        public final c b(int i, String str, EnumC19761qt6 enumC19761qt6, String str2, EnumC18579ot6 enumC18579ot6, String str3, int i2, EnumC19170pt6 enumC19170pt6, List list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(enumC19761qt6, "sectionState");
            AbstractC13042fc3.i(str2, "buttonText");
            AbstractC13042fc3.i(enumC18579ot6, "navigationType");
            AbstractC13042fc3.i(str3, "navigationDestinationUrl");
            AbstractC13042fc3.i(enumC19170pt6, "badgeType");
            return new c(i, str, enumC19761qt6, str2, enumC18579ot6, str3, i2, enumC19170pt6, list);
        }

        public final EnumC19170pt6 d() {
            return this.h;
        }

        public final List e() {
            return this.i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && AbstractC13042fc3.d(this.b, cVar.b) && this.c == cVar.c && AbstractC13042fc3.d(this.d, cVar.d) && this.e == cVar.e && AbstractC13042fc3.d(this.f, cVar.f) && this.g == cVar.g && this.h == cVar.h && AbstractC13042fc3.d(this.i, cVar.i);
        }

        public final String f() {
            return this.d;
        }

        public final int g() {
            return this.g;
        }

        public final String h() {
            return this.f;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g)) * 31) + this.h.hashCode()) * 31;
            List list = this.i;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public final EnumC18579ot6 i() {
            return this.e;
        }

        public int j() {
            return this.a;
        }

        public String k() {
            return this.b;
        }

        public String toString() {
            return "BotsVitrineExtra(title='" + k() + "', sectionState=" + a() + ", botItemUIs=" + this.i + Separators.RPAREN;
        }

        public /* synthetic */ c(int i, String str, EnumC19761qt6 enumC19761qt6, String str2, EnumC18579ot6 enumC18579ot6, String str3, int i2, EnumC19170pt6 enumC19170pt6, List list, int i3, ED1 ed1) {
            this(i, str, (i3 & 4) != 0 ? EnumC19761qt6.a : enumC19761qt6, str2, enumC18579ot6, str3, i2, enumC19170pt6, (i3 & 256) != 0 ? null : list);
        }
    }
}
