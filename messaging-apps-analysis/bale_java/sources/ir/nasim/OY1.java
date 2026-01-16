package ir.nasim;

import ir.nasim.OY1;

/* loaded from: classes6.dex */
public abstract class OY1 {

    public static final class a extends OY1 {
        public static final a a = new a();
        private static final UA2 b = new UA2() { // from class: ir.nasim.NY1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(OY1.a.c((EX1) obj));
            }
        };

        private a() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean c(EX1 ex1) {
            AbstractC13042fc3.i(ex1, "it");
            return true;
        }

        @Override // ir.nasim.OY1
        public UA2 a() {
            return b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1027424380;
        }

        public String toString() {
            return "Infinite";
        }
    }

    public static final class b extends OY1 {
        public static final b a = new b();
        private static final UA2 b = new UA2() { // from class: ir.nasim.PY1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(OY1.b.c((EX1) obj));
            }
        };

        private b() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean c(EX1 ex1) {
            AbstractC13042fc3.i(ex1, "it");
            return false;
        }

        @Override // ir.nasim.OY1
        public UA2 a() {
            return b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1182253912;
        }

        public String toString() {
            return "None";
        }
    }

    private OY1() {
    }

    public abstract UA2 a();

    public /* synthetic */ OY1(ED1 ed1) {
        this();
    }
}
