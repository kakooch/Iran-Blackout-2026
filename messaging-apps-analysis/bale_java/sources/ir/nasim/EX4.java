package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public abstract class EX4 {

    public static final class a extends EX4 {
        private final Long a;
        private final Long b;
        private final Long c;

        public a(Long l, Long l2, Long l3) {
            super(null);
            this.a = l;
            this.b = l2;
            this.c = l3;
        }

        public static /* synthetic */ a b(a aVar, Long l, Long l2, Long l3, int i, Object obj) {
            if ((i & 1) != 0) {
                l = aVar.a;
            }
            if ((i & 2) != 0) {
                l2 = aVar.b;
            }
            if ((i & 4) != 0) {
                l3 = aVar.c;
            }
            return aVar.a(l, l2, l3);
        }

        public final a a(Long l, Long l2, Long l3) {
            return new a(l, l2, l3);
        }

        public final Long c() {
            return this.c;
        }

        public final Long d() {
            return this.b;
        }

        public final Long e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            Long l = this.a;
            int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
            Long l2 = this.b;
            int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.c;
            return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
        }

        public String toString() {
            return "Date(value=" + this.a + ", minDate=" + this.b + ", maxDate=" + this.c + Separators.RPAREN;
        }
    }

    public static final class b extends EX4 {
        private final Integer a;
        private final Integer b;
        private final Integer c;

        public b(Integer num, Integer num2, Integer num3) {
            super(null);
            this.a = num;
            this.b = num2;
            this.c = num3;
        }

        public static /* synthetic */ b b(b bVar, Integer num, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = bVar.a;
            }
            if ((i & 2) != 0) {
                num2 = bVar.b;
            }
            if ((i & 4) != 0) {
                num3 = bVar.c;
            }
            return bVar.a(num, num2, num3);
        }

        public final b a(Integer num, Integer num2, Integer num3) {
            return new b(num, num2, num3);
        }

        public final Integer c() {
            return this.c;
        }

        public final Integer d() {
            return this.b;
        }

        public final Integer e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c);
        }

        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.b;
            int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.c;
            return iHashCode2 + (num3 != null ? num3.hashCode() : 0);
        }

        public String toString() {
            return "Number(value=" + this.a + ", minValue=" + this.b + ", maxValue=" + this.c + Separators.RPAREN;
        }
    }

    public static final class c extends EX4 {
        private final String a;
        private final EnumC14492i05 b;
        private final Integer c;
        private final Integer d;
        private final EnumC15099j05 e;
        private final C20644sM5 f;

        public c(String str, EnumC14492i05 enumC14492i05, Integer num, Integer num2, EnumC15099j05 enumC15099j05, C20644sM5 c20644sM5) {
            super(null);
            this.a = str;
            this.b = enumC14492i05;
            this.c = num;
            this.d = num2;
            this.e = enumC15099j05;
            this.f = c20644sM5;
        }

        public static /* synthetic */ c b(c cVar, String str, EnumC14492i05 enumC14492i05, Integer num, Integer num2, EnumC15099j05 enumC15099j05, C20644sM5 c20644sM5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cVar.a;
            }
            if ((i & 2) != 0) {
                enumC14492i05 = cVar.b;
            }
            EnumC14492i05 enumC14492i052 = enumC14492i05;
            if ((i & 4) != 0) {
                num = cVar.c;
            }
            Integer num3 = num;
            if ((i & 8) != 0) {
                num2 = cVar.d;
            }
            Integer num4 = num2;
            if ((i & 16) != 0) {
                enumC15099j05 = cVar.e;
            }
            EnumC15099j05 enumC15099j052 = enumC15099j05;
            if ((i & 32) != 0) {
                c20644sM5 = cVar.f;
            }
            return cVar.a(str, enumC14492i052, num3, num4, enumC15099j052, c20644sM5);
        }

        public final c a(String str, EnumC14492i05 enumC14492i05, Integer num, Integer num2, EnumC15099j05 enumC15099j05, C20644sM5 c20644sM5) {
            return new c(str, enumC14492i05, num, num2, enumC15099j05, c20644sM5);
        }

        public final EnumC15099j05 c() {
            return this.e;
        }

        public final C20644sM5 d() {
            return this.f;
        }

        public final EnumC14492i05 e() {
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
            return AbstractC13042fc3.d(this.a, cVar.a) && this.b == cVar.b && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d) && this.e == cVar.e && AbstractC13042fc3.d(this.f, cVar.f);
        }

        public final Integer f() {
            return this.d;
        }

        public final Integer g() {
            return this.c;
        }

        public final String h() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            EnumC14492i05 enumC14492i05 = this.b;
            int iHashCode2 = (iHashCode + (enumC14492i05 == null ? 0 : enumC14492i05.hashCode())) * 31;
            Integer num = this.c;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.d;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            EnumC15099j05 enumC15099j05 = this.e;
            int iHashCode5 = (iHashCode4 + (enumC15099j05 == null ? 0 : enumC15099j05.hashCode())) * 31;
            C20644sM5 c20644sM5 = this.f;
            return iHashCode5 + (c20644sM5 != null ? c20644sM5.hashCode() : 0);
        }

        public String toString() {
            return "Text(value=" + this.a + ", inputMode=" + this.b + ", minLength=" + this.c + ", maxLength=" + this.d + ", builtInValidation=" + this.e + ", customRegex=" + this.f + Separators.RPAREN;
        }
    }

    public static final class d extends EX4 {
        public static final d a = new d();

        private d() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return -49296473;
        }

        public String toString() {
            return "UnSupported";
        }
    }

    private EX4() {
    }

    public /* synthetic */ EX4(ED1 ed1) {
        this();
    }
}
