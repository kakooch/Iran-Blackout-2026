package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.um7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC22169um7 {

    /* renamed from: ir.nasim.um7$a */
    public static final class a extends AbstractC22169um7 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1143146132;
        }

        public String toString() {
            return "Default";
        }
    }

    /* renamed from: ir.nasim.um7$b */
    public static final class b extends AbstractC22169um7 {
        private final EnumC9920am7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EnumC9920am7 enumC9920am7) {
            super(null);
            AbstractC13042fc3.i(enumC9920am7, "state");
            this.a = enumC9920am7;
        }

        public final EnumC9920am7 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Error(state=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.um7$c */
    public static final class c extends AbstractC22169um7 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -65007217;
        }

        public String toString() {
            return "Loading";
        }
    }

    private AbstractC22169um7() {
    }

    public /* synthetic */ AbstractC22169um7(ED1 ed1) {
        this();
    }
}
