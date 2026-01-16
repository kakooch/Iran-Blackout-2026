package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.hy4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC14472hy4 {
    public static final int a = 0;

    /* renamed from: ir.nasim.hy4$a */
    public static final class a extends AbstractC14472hy4 {
        private final Integer b;
        private final String c;
        private final Integer d;

        public /* synthetic */ a(Integer num, String str, Integer num2, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2);
        }

        @Override // ir.nasim.AbstractC14472hy4
        public TY0 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1054003121);
            G10 g10 = G10.a;
            TY0 ty0 = new TY0(g10.a(interfaceC22053ub1, 6).t(), g10.a(interfaceC22053ub1, 6).t(), null);
            interfaceC22053ub1.Q();
            return ty0;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public Integer b() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public Integer c() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public String d() {
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
            return AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d);
        }

        public int hashCode() {
            Integer num = this.b;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.c;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num2 = this.d;
            return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "Fail(iconRes=" + this.b + ", message=" + this.c + ", count=" + this.d + Separators.RPAREN;
        }

        public a(Integer num, String str, Integer num2) {
            super(null);
            this.b = num;
            this.c = str;
            this.d = num2;
        }
    }

    /* renamed from: ir.nasim.hy4$c */
    public static final class c extends AbstractC14472hy4 {
        private final Integer b;
        private final String c;
        private final Integer d;

        public /* synthetic */ c(Integer num, String str, Integer num2, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2);
        }

        @Override // ir.nasim.AbstractC14472hy4
        public TY0 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1682251478);
            G10 g10 = G10.a;
            TY0 ty0 = new TY0(g10.a(interfaceC22053ub1, 6).B(), g10.a(interfaceC22053ub1, 6).B(), null);
            interfaceC22053ub1.Q();
            return ty0;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public Integer b() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public Integer c() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public String d() {
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
            return AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d);
        }

        public int hashCode() {
            Integer num = this.b;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.c;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num2 = this.d;
            return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "OnFocus(iconRes=" + this.b + ", message=" + this.c + ", count=" + this.d + Separators.RPAREN;
        }

        public c(Integer num, String str, Integer num2) {
            super(null);
            this.b = num;
            this.c = str;
            this.d = num2;
        }
    }

    /* renamed from: ir.nasim.hy4$d */
    public static final class d extends AbstractC14472hy4 {
        public static final int e = 0;
        private final Integer b;
        private final String c;
        private final Integer d;

        public /* synthetic */ d(Integer num, String str, Integer num2, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2);
        }

        @Override // ir.nasim.AbstractC14472hy4
        public TY0 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1341183840);
            G10 g10 = G10.a;
            TY0 ty0 = new TY0(g10.a(interfaceC22053ub1, 6).L(), g10.a(interfaceC22053ub1, 6).L(), null);
            interfaceC22053ub1.Q();
            return ty0;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public Integer b() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public Integer c() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public String d() {
            return this.c;
        }

        public d(Integer num, String str, Integer num2) {
            super(null);
            this.b = num;
            this.c = str;
            this.d = num2;
        }
    }

    private AbstractC14472hy4() {
    }

    public abstract TY0 a(InterfaceC22053ub1 interfaceC22053ub1, int i);

    public abstract Integer b();

    public abstract Integer c();

    public abstract String d();

    /* renamed from: ir.nasim.hy4$b */
    public static final class b extends AbstractC14472hy4 {
        public static final int e = 0;
        private final Integer b;
        private final String c;
        private final Integer d;

        public /* synthetic */ b(Integer num, String str, Integer num2, int i, ED1 ed1) {
            this((i & 1) != 0 ? Integer.valueOf(AbstractC24188yB5.loading_search) : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2);
        }

        @Override // ir.nasim.AbstractC14472hy4
        public TY0 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(1062357127);
            G10 g10 = G10.a;
            TY0 ty0 = new TY0(g10.a(interfaceC22053ub1, 6).B(), g10.a(interfaceC22053ub1, 6).I(), null);
            interfaceC22053ub1.Q();
            return ty0;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public Integer b() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public Integer c() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC14472hy4
        public String d() {
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
            return AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d);
        }

        public int hashCode() {
            Integer num = this.b;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.c;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num2 = this.d;
            return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "Loading(iconRes=" + this.b + ", message=" + this.c + ", count=" + this.d + Separators.RPAREN;
        }

        public b(Integer num, String str, Integer num2) {
            super(null);
            this.b = num;
            this.c = str;
            this.d = num2;
        }
    }

    public /* synthetic */ AbstractC14472hy4(ED1 ed1) {
        this();
    }
}
