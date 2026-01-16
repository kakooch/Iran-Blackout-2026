package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Tz3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC7975Tz3 {
    long a(InterfaceC22053ub1 interfaceC22053ub1, int i);

    int b();

    /* renamed from: ir.nasim.Tz3$a */
    public static final class a implements InterfaceC7975Tz3 {
        private final InterfaceC14603iB2 a;
        private final int b;

        /* renamed from: ir.nasim.Tz3$a$a, reason: collision with other inner class name */
        static final class C0675a implements InterfaceC14603iB2 {
            public static final C0675a a = new C0675a();

            C0675a() {
            }

            public final long a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(1668597905);
                long jI = G10.a.a(interfaceC22053ub1, 6).I();
                interfaceC22053ub1.Q();
                return jI;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return C24381yX0.k(a((InterfaceC22053ub1) obj, ((Number) obj2).intValue()));
            }
        }

        public a(InterfaceC14603iB2 interfaceC14603iB2, int i) {
            AbstractC13042fc3.i(interfaceC14603iB2, "provideIconColor");
            this.a = interfaceC14603iB2;
            this.b = i;
        }

        @Override // ir.nasim.InterfaceC7975Tz3
        public long a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(1109144579);
            long jY = ((C24381yX0) this.a.invoke(interfaceC22053ub1, 0)).y();
            interfaceC22053ub1.Q();
            return jY;
        }

        @Override // ir.nasim.InterfaceC7975Tz3
        public int b() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "Paused(provideIconColor=" + this.a + ", iconRes=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ a(InterfaceC14603iB2 interfaceC14603iB2, int i, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? C0675a.a : interfaceC14603iB2, (i2 & 2) != 0 ? AbstractC24188yB5.stop : i);
        }
    }

    /* renamed from: ir.nasim.Tz3$b */
    public static final class b implements InterfaceC7975Tz3 {
        private final InterfaceC14603iB2 a;
        private final int b;

        /* renamed from: ir.nasim.Tz3$b$a */
        static final class a implements InterfaceC14603iB2 {
            public static final a a = new a();

            a() {
            }

            public final long a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(-339574778);
                long jT = G10.a.a(interfaceC22053ub1, 6).t();
                interfaceC22053ub1.Q();
                return jT;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return C24381yX0.k(a((InterfaceC22053ub1) obj, ((Number) obj2).intValue()));
            }
        }

        public b(InterfaceC14603iB2 interfaceC14603iB2, int i) {
            AbstractC13042fc3.i(interfaceC14603iB2, "provideIconColor");
            this.a = interfaceC14603iB2;
            this.b = i;
        }

        @Override // ir.nasim.InterfaceC7975Tz3
        public long a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(1989045204);
            long jY = ((C24381yX0) this.a.invoke(interfaceC22053ub1, 0)).y();
            interfaceC22053ub1.Q();
            return jY;
        }

        @Override // ir.nasim.InterfaceC7975Tz3
        public int b() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "RetryFailed(provideIconColor=" + this.a + ", iconRes=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ b(InterfaceC14603iB2 interfaceC14603iB2, int i, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? a.a : interfaceC14603iB2, (i2 & 2) != 0 ? AbstractC24188yB5.ic_retry : i);
        }
    }

    /* renamed from: ir.nasim.Tz3$c */
    public static final class c implements InterfaceC7975Tz3 {
        private final InterfaceC14603iB2 a;
        private final int b;

        /* renamed from: ir.nasim.Tz3$c$a */
        static final class a implements InterfaceC14603iB2 {
            public static final a a = new a();

            a() {
            }

            public final long a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(-880782548);
                long jI = G10.a.a(interfaceC22053ub1, 6).I();
                interfaceC22053ub1.Q();
                return jI;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return C24381yX0.k(a((InterfaceC22053ub1) obj, ((Number) obj2).intValue()));
            }
        }

        public c(InterfaceC14603iB2 interfaceC14603iB2, int i) {
            AbstractC13042fc3.i(interfaceC14603iB2, "provideIconColor");
            this.a = interfaceC14603iB2;
            this.b = i;
        }

        @Override // ir.nasim.InterfaceC7975Tz3
        public long a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1274663778);
            long jY = ((C24381yX0) this.a.invoke(interfaceC22053ub1, 0)).y();
            interfaceC22053ub1.Q();
            return jY;
        }

        @Override // ir.nasim.InterfaceC7975Tz3
        public int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && this.b == cVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "RetryTemporary(provideIconColor=" + this.a + ", iconRes=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ c(InterfaceC14603iB2 interfaceC14603iB2, int i, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? a.a : interfaceC14603iB2, (i2 & 2) != 0 ? AbstractC24188yB5.ic_retry : i);
        }
    }
}
