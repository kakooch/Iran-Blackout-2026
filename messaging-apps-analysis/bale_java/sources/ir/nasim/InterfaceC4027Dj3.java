package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC4027Dj3;

/* renamed from: ir.nasim.Dj3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC4027Dj3 {

    /* renamed from: ir.nasim.Dj3$b */
    public static final class b implements InterfaceC4027Dj3 {
        private final InterfaceC14603iB2 a;
        private final InterfaceC19114po0 b;

        /* renamed from: ir.nasim.Dj3$b$a */
        static final class a implements InterfaceC14603iB2 {
            public static final a a = new a();

            a() {
            }

            public final String a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(1174040720);
                interfaceC22053ub1.Q();
                return "";
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            }
        }

        public b(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC19114po0 interfaceC19114po0) {
            AbstractC13042fc3.i(interfaceC14603iB2, "provideButtonText");
            AbstractC13042fc3.i(interfaceC19114po0, "buttonStates");
            this.a = interfaceC14603iB2;
            this.b = interfaceC19114po0;
        }

        public InterfaceC19114po0 a() {
            return this.b;
        }

        public String b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(1750277879);
            String str = (String) this.a.invoke(interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
            return str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "IsLoading(provideButtonText=" + this.a + ", buttonStates=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ b(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC19114po0 interfaceC19114po0, int i, ED1 ed1) {
            this((i & 1) != 0 ? a.a : interfaceC14603iB2, (i & 2) != 0 ? InterfaceC19114po0.b.C1454b.a : interfaceC19114po0);
        }
    }

    /* renamed from: ir.nasim.Dj3$a */
    public static final class a implements InterfaceC4027Dj3 {
        private final InterfaceC14603iB2 a;
        private final int b;
        private final InterfaceC19114po0 c;

        /* renamed from: ir.nasim.Dj3$a$a, reason: collision with other inner class name */
        static final class C0325a implements InterfaceC14603iB2 {
            public static final C0325a a = new C0325a();

            C0325a() {
            }

            public final String a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(758042279);
                String strC = UY6.c(UD5.core_ui_joined, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return strC;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            }
        }

        public a(InterfaceC14603iB2 interfaceC14603iB2, int i, InterfaceC19114po0 interfaceC19114po0) {
            AbstractC13042fc3.i(interfaceC14603iB2, "provideButtonText");
            AbstractC13042fc3.i(interfaceC19114po0, "buttonStates");
            this.a = interfaceC14603iB2;
            this.b = i;
            this.c = interfaceC19114po0;
        }

        public InterfaceC19114po0 a() {
            return this.c;
        }

        public String b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1855768736);
            String str = (String) this.a.invoke(interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
            return str;
        }

        public final int c() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "IsJoined(provideButtonText=" + this.a + ", iconResId=" + this.b + ", buttonStates=" + this.c + Separators.RPAREN;
        }

        public /* synthetic */ a(InterfaceC14603iB2 interfaceC14603iB2, int i, InterfaceC19114po0 interfaceC19114po0, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? C0325a.a : interfaceC14603iB2, (i2 & 2) != 0 ? AbstractC24188yB5.tick_done : i, (i2 & 4) != 0 ? InterfaceC19114po0.b.c.a : interfaceC19114po0);
        }
    }

    /* renamed from: ir.nasim.Dj3$c */
    public static final class c implements InterfaceC4027Dj3 {
        public static final int d = 8;
        private final InterfaceC14603iB2 a;
        private final InterfaceC19114po0 b;
        private final SA2 c;

        /* renamed from: ir.nasim.Dj3$c$a */
        static final class a implements InterfaceC14603iB2 {
            public static final a a = new a();

            a() {
            }

            public final String a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(-187421104);
                String strC = UY6.c(UD5.core_ui_join, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return strC;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            }
        }

        public c(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC19114po0 interfaceC19114po0, SA2 sa2) {
            AbstractC13042fc3.i(interfaceC14603iB2, "provideButtonText");
            AbstractC13042fc3.i(interfaceC19114po0, "buttonStates");
            AbstractC13042fc3.i(sa2, "onJoinClick");
            this.a = interfaceC14603iB2;
            this.b = interfaceC19114po0;
            this.c = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b() {
            return C19938rB7.a;
        }

        public InterfaceC19114po0 c() {
            return this.b;
        }

        public String d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-474292489);
            String str = (String) this.a.invoke(interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
            return str;
        }

        public final SA2 e() {
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
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "IsNotJoined(provideButtonText=" + this.a + ", buttonStates=" + this.b + ", onJoinClick=" + this.c + Separators.RPAREN;
        }

        public /* synthetic */ c(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC19114po0 interfaceC19114po0, SA2 sa2, int i, ED1 ed1) {
            this((i & 1) != 0 ? a.a : interfaceC14603iB2, (i & 2) != 0 ? InterfaceC19114po0.b.C1454b.a : interfaceC19114po0, (i & 4) != 0 ? new SA2() { // from class: ir.nasim.Ej3
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return InterfaceC4027Dj3.c.b();
                }
            } : sa2);
        }
    }
}
