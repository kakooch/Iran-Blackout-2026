package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.sk, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC20864sk {

    /* renamed from: ir.nasim.sk$a */
    public static final class a extends AbstractC20864sk {
        private final Throwable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable th) {
            super(null);
            AbstractC13042fc3.i(th, "e");
            this.a = th;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Failure(e=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.sk$b */
    public static final class b extends AbstractC20864sk {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1958787832;
        }

        public String toString() {
            return "Idle";
        }
    }

    /* renamed from: ir.nasim.sk$c */
    public static final class c extends AbstractC20864sk {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 144727944;
        }

        public String toString() {
            return "Loading";
        }
    }

    /* renamed from: ir.nasim.sk$d */
    public static final class d extends AbstractC20864sk {
        private final long a;
        private final boolean b;

        public d(long j, boolean z) {
            super(null);
            this.a = j;
            this.b = z;
        }

        public final long a() {
            return this.a;
        }

        public final boolean b() {
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
            return this.a == dVar.a && this.b == dVar.b;
        }

        public int hashCode() {
            return (Long.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "Success(amount=" + this.a + ", shouldShowDialog=" + this.b + Separators.RPAREN;
        }
    }

    private AbstractC20864sk() {
    }

    public /* synthetic */ AbstractC20864sk(ED1 ed1) {
        this();
    }
}
