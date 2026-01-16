package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.qk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19670qk5 {

    /* renamed from: ir.nasim.qk5$a */
    public static final class a {
        private final String a;

        public a(String str) {
            AbstractC13042fc3.i(str, "name");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return AbstractC13042fc3.d(this.a, ((a) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.qk5$b */
    public static final class b {
    }

    public abstract Map a();

    public abstract Object b(a aVar);

    public final C4772Gm4 c() {
        return new C4772Gm4(AbstractC20051rO3.A(a()), false);
    }

    public final AbstractC19670qk5 d() {
        return new C4772Gm4(AbstractC20051rO3.A(a()), true);
    }
}
