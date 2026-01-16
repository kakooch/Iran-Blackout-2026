package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13463gG6;

/* renamed from: ir.nasim.gG6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC13463gG6 {
    public static final int a = 0;

    /* renamed from: ir.nasim.gG6$b */
    public static final class b extends AbstractC13463gG6 {
        public static final int d = 8;
        private final int b;
        private int c;

        public b(int i) {
            super(null);
            this.b = i;
            this.c = C6399Nk7.b.f();
        }

        @Override // ir.nasim.AbstractC13463gG6
        public int a() {
            return this.c;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.b == ((b) obj).b;
        }

        public int hashCode() {
            return Integer.hashCode(this.b);
        }

        public String toString() {
            return "Icon(iconRes=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.gG6$c */
    public static final class c extends AbstractC13463gG6 {
        public static final c b = new c();
        private static int c = C6399Nk7.b.f();
        public static final int d = 8;

        private c() {
            super(null);
        }

        @Override // ir.nasim.AbstractC13463gG6
        public int a() {
            return c;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -1262751287;
        }

        public String toString() {
            return "Normal";
        }
    }

    private AbstractC13463gG6() {
    }

    public abstract int a();

    /* renamed from: ir.nasim.gG6$a */
    public static final class a extends AbstractC13463gG6 {
        private final String b;
        private final Integer c;
        private final boolean d;
        private final SA2 e;
        private int f;

        public /* synthetic */ a(String str, Integer num, boolean z, SA2 sa2, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? true : z, (i & 8) != 0 ? new SA2() { // from class: ir.nasim.fG6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return AbstractC13463gG6.a.c();
                }
            } : sa2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c() {
            return C19938rB7.a;
        }

        @Override // ir.nasim.AbstractC13463gG6
        public int a() {
            return this.f;
        }

        public final Integer d() {
            return this.c;
        }

        public final SA2 e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && this.d == aVar.d && AbstractC13042fc3.d(this.e, aVar.e);
        }

        public final boolean f() {
            return this.d;
        }

        public final String g() {
            return this.b;
        }

        public int hashCode() {
            String str = this.b;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.c;
            return ((((iHashCode + (num != null ? num.hashCode() : 0)) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "Action(textAction=" + this.b + ", iconRes=" + this.c + ", shouldShowCircularProgress=" + this.d + ", onActionClickListener=" + this.e + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Integer num, boolean z, SA2 sa2) {
            super(null);
            AbstractC13042fc3.i(sa2, "onActionClickListener");
            this.b = str;
            this.c = num;
            this.d = z;
            this.e = sa2;
            this.f = C6399Nk7.b.f();
        }
    }

    public /* synthetic */ AbstractC13463gG6(ED1 ed1) {
        this();
    }
}
