package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.zJ0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC24849zJ0 {

    /* renamed from: ir.nasim.zJ0$a */
    public static final class a extends AbstractC24849zJ0 {
        private final Throwable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable th) {
            super(null);
            AbstractC13042fc3.i(th, "error");
            this.a = th;
        }

        public final Throwable a() {
            return this.a;
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
            return "Fail(error=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.zJ0$b */
    public static final class b extends AbstractC24849zJ0 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -132972359;
        }

        public String toString() {
            return "Ideal";
        }
    }

    /* renamed from: ir.nasim.zJ0$c */
    public static final class c extends AbstractC24849zJ0 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 1832589159;
        }

        public String toString() {
            return "Success";
        }
    }

    private AbstractC24849zJ0() {
    }

    public /* synthetic */ AbstractC24849zJ0(ED1 ed1) {
        this();
    }
}
