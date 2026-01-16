package ir.nasim.features.pfm;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public abstract class j {

    public static final class a extends j {
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

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // ir.nasim.features.pfm.j
        public String toString() {
            return "Error(exception=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends j {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    public static final class c extends j {
        private final Object a;

        public c(Object obj) {
            super(null);
            this.a = obj;
        }

        public final Object a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            Object obj = this.a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // ir.nasim.features.pfm.j
        public String toString() {
            return "Success(data=" + this.a + Separators.RPAREN;
        }
    }

    private j() {
    }

    public String toString() {
        if (this instanceof c) {
            return "Success[data=" + ((c) this).a() + "]";
        }
        if (!(this instanceof a)) {
            if (AbstractC13042fc3.d(this, b.a)) {
                return "Loading";
            }
            throw new NoWhenBranchMatchedException();
        }
        return "Error[exception=" + ((a) this).a() + "]";
    }

    public /* synthetic */ j(ED1 ed1) {
        this();
    }
}
