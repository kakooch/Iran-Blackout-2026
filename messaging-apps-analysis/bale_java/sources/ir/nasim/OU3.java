package ir.nasim;

import java.util.List;

/* loaded from: classes8.dex */
public interface OU3 {

    public static final class a {
        public static b a(OU3 ou3) {
            return new b(ou3);
        }
    }

    public static final class b {
        private final OU3 a;

        public b(OU3 ou3) {
            AbstractC13042fc3.i(ou3, "match");
            this.a = ou3;
        }

        public final OU3 a() {
            return this.a;
        }
    }

    b a();

    List b();

    C24411ya3 c();

    NU3 d();

    String getValue();

    OU3 next();
}
