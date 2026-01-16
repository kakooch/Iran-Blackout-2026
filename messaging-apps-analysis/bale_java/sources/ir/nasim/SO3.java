package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.protobuf.AbstractC2383g;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class SO3 extends Z6 {

    public static final class a implements InterfaceC15283jK {
        private final int a;
        private final int b;
        private final int c;
        private final boolean d;

        public a(int i, int i2, int i3, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = z;
        }

        public final int a() {
            return this.a;
        }

        public final boolean b() {
            return this.d;
        }

        public final int c() {
            return this.b;
        }

        public final int d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "GetCategoriesList(categoryId=" + this.a + ", level=" + this.b + ", version=" + this.c + ", includeSampleStores=" + this.d + Separators.RPAREN;
        }
    }

    public static final class b implements InterfaceC15283jK {
        private final int a;
        private final int b;
        private final int c;

        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "GetCategoryMarkets(categoryId=" + this.a + ", limit=" + this.b + ", page=" + this.c + Separators.RPAREN;
        }
    }

    public static final class c implements InterfaceC15283jK {
        private final int a;
        private final int b;
        private final int c;

        public c(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b && this.c == cVar.c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "GetCategoryProducts(categoryId=" + this.a + ", limit=" + this.b + ", page=" + this.c + Separators.RPAREN;
        }
    }

    public static final class d implements InterfaceC15283jK {
    }

    public static final class e implements InterfaceC15283jK {
        private final String a;
        private final boolean b;
        private final AbstractC2383g c;

        public e(String str, boolean z, AbstractC2383g abstractC2383g) {
            AbstractC13042fc3.i(str, "query");
            this.a = str;
            this.b = z;
            this.c = abstractC2383g;
        }

        public final AbstractC2383g a() {
            return this.c;
        }

        public final String b() {
            return this.a;
        }

        public final boolean c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return AbstractC13042fc3.d(this.a, eVar.a) && this.b == eVar.b && AbstractC13042fc3.d(this.c, eVar.c);
        }

        public int hashCode() {
            int iHashCode = ((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31;
            AbstractC2383g abstractC2383g = this.c;
            return iHashCode + (abstractC2383g == null ? 0 : abstractC2383g.hashCode());
        }

        public String toString() {
            return "SearchMarket(query=" + this.a + ", withCategory=" + this.b + ", loadMore=" + this.c + Separators.RPAREN;
        }
    }

    public static final class f implements InterfaceC15283jK {
        private final String a;
        private final AbstractC2383g b;

        public f(String str, AbstractC2383g abstractC2383g) {
            AbstractC13042fc3.i(str, "query");
            this.a = str;
            this.b = abstractC2383g;
        }

        public final AbstractC2383g a() {
            return this.b;
        }

        public final String b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return AbstractC13042fc3.d(this.a, fVar.a) && AbstractC13042fc3.d(this.b, fVar.b);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            AbstractC2383g abstractC2383g = this.b;
            return iHashCode + (abstractC2383g == null ? 0 : abstractC2383g.hashCode());
        }

        public String toString() {
            return "SearchProduct(query=" + this.a + ", loadMore=" + this.b + Separators.RPAREN;
        }
    }

    public static final class g implements InterfaceC15283jK {
        private final int a;
        private final String b;

        public g(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public final String a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.a == gVar.a && AbstractC13042fc3.d(this.b, gVar.b);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.a) * 31;
            String str = this.b;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "SendFeedback(rate=" + this.a + ", description=" + this.b + Separators.RPAREN;
        }
    }

    public static final class h implements InterfaceC15283jK {
        private final boolean a;
        private final EnumC10336bU3 b;
        private final ArrayList c;

        public h(boolean z, EnumC10336bU3 enumC10336bU3, ArrayList arrayList) {
            this.a = z;
            this.b = enumC10336bU3;
            this.c = arrayList;
        }

        public final ArrayList a() {
            return this.c;
        }

        public final EnumC10336bU3 b() {
            return this.b;
        }

        public final boolean c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.a == hVar.a && this.b == hVar.b && AbstractC13042fc3.d(this.c, hVar.c);
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.a) * 31;
            EnumC10336bU3 enumC10336bU3 = this.b;
            int iHashCode2 = (iHashCode + (enumC10336bU3 == null ? 0 : enumC10336bU3.hashCode())) * 31;
            ArrayList arrayList = this.c;
            return iHashCode2 + (arrayList != null ? arrayList.hashCode() : 0);
        }

        public String toString() {
            return "SetOnboardingData(isSkipped=" + this.a + ", gender=" + this.b + ", categoryIds=" + this.c + Separators.RPAREN;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SO3(C9528a7 c9528a7) {
        super(c9528a7);
        AbstractC13042fc3.i(c9528a7, "actorRef");
    }

    public final C6517Nv5 j(a aVar) {
        AbstractC13042fc3.i(aVar, "getCategoriesList");
        C6517Nv5 c6517Nv5C = c(aVar);
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 k(b bVar) {
        AbstractC13042fc3.i(bVar, "getCategoryMarkets");
        C6517Nv5 c6517Nv5C = c(bVar);
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 l(c cVar) {
        AbstractC13042fc3.i(cVar, "getCategoryProducts");
        C6517Nv5 c6517Nv5C = c(cVar);
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 m() {
        C6517Nv5 c6517Nv5C = c(new d());
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 n(e eVar) {
        AbstractC13042fc3.i(eVar, "searchMarket");
        C6517Nv5 c6517Nv5C = c(eVar);
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 o(f fVar) {
        AbstractC13042fc3.i(fVar, "searchMarket");
        C6517Nv5 c6517Nv5C = c(fVar);
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 p(g gVar) {
        AbstractC13042fc3.i(gVar, "sendFeedback");
        C6517Nv5 c6517Nv5C = c(gVar);
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 q(h hVar) {
        AbstractC13042fc3.i(hVar, "setOnboardingData");
        C6517Nv5 c6517Nv5C = c(hVar);
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }
}
