package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.dT6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC11710dT6 {

    /* renamed from: ir.nasim.dT6$a */
    public static final class a extends AbstractC11710dT6 {
        public static final a a = new a();

        private a() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.dT6$b */
    public static final class b extends AbstractC11710dT6 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(null);
            AbstractC13042fc3.i(str, "unicode");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "REACTION(unicode=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.dT6$c */
    public static final class c extends AbstractC11710dT6 {
        public static final c a = new c();

        private c() {
            super(null);
        }
    }

    private AbstractC11710dT6() {
    }

    public /* synthetic */ AbstractC11710dT6(ED1 ed1) {
        this();
    }
}
