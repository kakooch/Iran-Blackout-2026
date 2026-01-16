package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ry5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC20417ry5 {

    /* renamed from: ir.nasim.ry5$a */
    public static final class a extends AbstractC20417ry5 {
        private final Throwable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable th) {
            super(null);
            AbstractC13042fc3.i(th, "err");
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
            return "Error(err=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.ry5$b */
    public static final class b extends AbstractC20417ry5 {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.ry5$c */
    public static final class c extends AbstractC20417ry5 {
        public static final c a = new c();

        private c() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.ry5$d */
    public static final class d extends AbstractC20417ry5 {
        private final String a;

        public d(String str) {
            super(null);
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            String str = this.a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Success(sadaadToken=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC20417ry5() {
    }

    public /* synthetic */ AbstractC20417ry5(ED1 ed1) {
        this();
    }
}
