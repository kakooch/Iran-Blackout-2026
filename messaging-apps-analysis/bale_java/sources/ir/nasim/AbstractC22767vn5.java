package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.vn5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC22767vn5 {

    /* renamed from: ir.nasim.vn5$a */
    public static final class a extends AbstractC22767vn5 {
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

    /* renamed from: ir.nasim.vn5$b */
    public static final class b extends AbstractC22767vn5 {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.vn5$c */
    public static final class c extends AbstractC22767vn5 {
        public static final c a = new c();

        private c() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.vn5$d */
    public static final class d extends AbstractC22767vn5 {
        private final List a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(List list) {
            super(null);
            AbstractC13042fc3.i(list, "items");
            this.a = list;
        }

        public final List a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Success(items=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC22767vn5() {
    }

    public /* synthetic */ AbstractC22767vn5(ED1 ed1) {
        this();
    }
}
