package ir.nasim;

import android.gov.nist.core.Separators;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public abstract class QA7 {

    public static final class a extends QA7 {
        private final Exception a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Exception exc) {
            super(null);
            AbstractC13042fc3.i(exc, "exception");
            this.a = exc;
        }

        public final Exception a() {
            return this.a;
        }

        @Override // ir.nasim.QA7
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // ir.nasim.QA7
        public String toString() {
            return "Error(exception=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends QA7 {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    public static final class c extends QA7 {
        public static final c a = new c();

        private c() {
            super(null);
        }
    }

    public static final class d extends QA7 {
        private final Object a;

        public d(Object obj) {
            super(null);
            this.a = obj;
        }

        public final Object a() {
            return this.a;
        }

        @Override // ir.nasim.QA7
        public boolean equals(Object obj) {
            if (this != obj) {
                return false;
            }
            return super.equals(obj);
        }

        public int hashCode() {
            Object obj = this.a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // ir.nasim.QA7
        public String toString() {
            return "Success(data=" + this.a + Separators.RPAREN;
        }
    }

    private QA7() {
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return false;
        }
        return this == obj || AbstractC13042fc3.d(getClass(), obj.getClass());
    }

    public String toString() {
        if (this instanceof d) {
            return "Success[data=" + ((d) this).a() + "]";
        }
        if (!(this instanceof a)) {
            if (AbstractC13042fc3.d(this, c.a)) {
                return "Loading";
            }
            if (AbstractC13042fc3.d(this, b.a)) {
                return "IsEmpty";
            }
            throw new NoWhenBranchMatchedException();
        }
        return "Error[exception=" + ((a) this).a() + "]";
    }

    public /* synthetic */ QA7(ED1 ed1) {
        this();
    }
}
