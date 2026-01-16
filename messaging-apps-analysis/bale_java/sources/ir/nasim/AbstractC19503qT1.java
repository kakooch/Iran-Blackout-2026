package ir.nasim;

import android.gov.nist.core.Separators;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.qT1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC19503qT1 {

    /* renamed from: ir.nasim.qT1$a */
    public static final class a extends AbstractC19503qT1 {
        public static final a a = new a();

        private a() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.qT1$b */
    public static final class b extends AbstractC19503qT1 {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.qT1$c */
    public static final class c extends AbstractC19503qT1 {
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

        @Override // ir.nasim.AbstractC19503qT1
        public String toString() {
            return "Success(data=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC19503qT1() {
    }

    public String toString() {
        if (!(this instanceof c)) {
            if (AbstractC13042fc3.d(this, a.a) || AbstractC13042fc3.d(this, b.a)) {
                return "Loading";
            }
            throw new NoWhenBranchMatchedException();
        }
        return "Success[data=" + ((c) this).a() + "]";
    }

    public /* synthetic */ AbstractC19503qT1(ED1 ed1) {
        this();
    }
}
