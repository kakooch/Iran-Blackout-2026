package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Gr7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4820Gr7 {

    /* renamed from: ir.nasim.Gr7$a */
    public static final class a extends AbstractC4820Gr7 {
        private final EnumC11273cj7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EnumC11273cj7 enumC11273cj7) {
            super(null);
            AbstractC13042fc3.i(enumC11273cj7, "tabType");
            this.a = enumC11273cj7;
        }

        public final EnumC11273cj7 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Action(tabType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Gr7$b */
    public static final class b extends AbstractC4820Gr7 {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.Gr7$c */
    public static final class c extends AbstractC4820Gr7 {
        public static final c a = new c();

        private c() {
            super(null);
        }
    }

    private AbstractC4820Gr7() {
    }

    public /* synthetic */ AbstractC4820Gr7(ED1 ed1) {
        this();
    }
}
