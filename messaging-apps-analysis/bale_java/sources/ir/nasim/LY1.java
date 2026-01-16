package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public interface LY1 {

    public static final class b implements LY1 {
        private static final Void b = null;
        public static final b a = new b();
        private static final int c = 1;

        private b() {
        }

        @Override // ir.nasim.LY1
        public int a() {
            return c;
        }

        @Override // ir.nasim.LY1
        public /* bridge */ /* synthetic */ LX1 b() {
            AbstractC18350oW3.a(c());
            return null;
        }

        public Void c() {
            return b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -822413573;
        }

        public String toString() {
            return "Manual";
        }
    }

    int a();

    LX1 b();

    public static final class a implements LY1 {
        private final int a;

        public a(LX1 lx1) {
            this.a = 2;
        }

        @Override // ir.nasim.LY1
        public int a() {
            return this.a;
        }

        @Override // ir.nasim.LY1
        public LX1 b() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            ((a) obj).getClass();
            return AbstractC13042fc3.d(null, null);
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "AutoStart(group=" + ((Object) null) + Separators.RPAREN;
        }

        public /* synthetic */ a(LX1 lx1, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : lx1);
        }
    }
}
