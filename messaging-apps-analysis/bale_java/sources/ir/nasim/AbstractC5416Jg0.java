package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Jg0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC5416Jg0 {

    /* renamed from: ir.nasim.Jg0$a */
    public static final class a extends AbstractC5416Jg0 {
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

    /* renamed from: ir.nasim.Jg0$b */
    public static final class b extends AbstractC5416Jg0 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1198090851;
        }

        public String toString() {
            return "Idle";
        }
    }

    /* renamed from: ir.nasim.Jg0$c */
    public static final class c extends AbstractC5416Jg0 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 1821035219;
        }

        public String toString() {
            return "Loading";
        }
    }

    /* renamed from: ir.nasim.Jg0$d */
    public static final class d extends AbstractC5416Jg0 {
        private final List a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(List list) {
            super(null);
            AbstractC13042fc3.i(list, "users");
            this.a = list;
        }

        public final d a(List list) {
            AbstractC13042fc3.i(list, "users");
            return new d(list);
        }

        public final List b() {
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
            return "Success(users=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC5416Jg0() {
    }

    public /* synthetic */ AbstractC5416Jg0(ED1 ed1) {
        this();
    }
}
