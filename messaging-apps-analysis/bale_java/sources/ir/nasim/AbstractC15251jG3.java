package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.jG3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC15251jG3 {

    /* renamed from: ir.nasim.jG3$a */
    public static final class a extends AbstractC15251jG3 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(null);
            AbstractC13042fc3.i(str, "exception");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        @Override // ir.nasim.AbstractC15251jG3
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
            return "Error(exception=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.jG3$b */
    public static final class b extends AbstractC15251jG3 {
        private final Object a;

        public b(Object obj) {
            super(null);
            this.a = obj;
        }

        public final Object a() {
            return this.a;
        }

        @Override // ir.nasim.AbstractC15251jG3
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

        public String toString() {
            return "Loaded(data=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.jG3$c */
    public static final class c extends AbstractC15251jG3 {
        public static final c a = new c();

        private c() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.jG3$d */
    public static final class d extends AbstractC15251jG3 {
        public static final d a = new d();

        private d() {
            super(null);
        }
    }

    private AbstractC15251jG3() {
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return false;
        }
        return this == obj || AbstractC13042fc3.d(getClass(), obj.getClass());
    }

    public /* synthetic */ AbstractC15251jG3(ED1 ed1) {
        this();
    }
}
