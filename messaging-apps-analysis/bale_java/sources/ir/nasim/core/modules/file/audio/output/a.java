package ir.nasim.core.modules.file.audio.output;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;

/* loaded from: classes5.dex */
public interface a extends Comparable {

    /* renamed from: ir.nasim.core.modules.file.audio.output.a$a, reason: collision with other inner class name */
    public static final class C0993a implements a {
        public static final C0993a a = new C0993a();
        private static final int b = 3;

        private C0993a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof C0993a);
        }

        @Override // ir.nasim.core.modules.file.audio.output.a
        public int getPriority() {
            return b;
        }

        public int hashCode() {
            return 1663011565;
        }

        public String toString() {
            return "Bluetooth";
        }
    }

    public static abstract class b implements a {
        private final int a;

        /* renamed from: ir.nasim.core.modules.file.audio.output.a$b$a, reason: collision with other inner class name */
        public static final class C0994a extends b {
            public static final C0994a b = new C0994a();

            private C0994a() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C0994a);
            }

            public int hashCode() {
                return 1492333988;
            }

            public String toString() {
                return "Earpiece";
            }
        }

        /* renamed from: ir.nasim.core.modules.file.audio.output.a$b$b, reason: collision with other inner class name */
        public static final class C0995b extends b {
            public static final C0995b b = new C0995b();

            private C0995b() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C0995b);
            }

            public int hashCode() {
                return -1934386637;
            }

            public String toString() {
                return "Speaker";
            }
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }

        @Override // ir.nasim.core.modules.file.audio.output.a
        public int getPriority() {
            return this.a;
        }

        private b() {
            this.a = 1;
        }
    }

    public static final class c implements a {
        public static final c a = new c();
        private static final int b = 2;

        private c() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        @Override // ir.nasim.core.modules.file.audio.output.a
        public int getPriority() {
            return b;
        }

        public int hashCode() {
            return 41361470;
        }

        public String toString() {
            return "Wired";
        }
    }

    int getPriority();

    @Override // java.lang.Comparable
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    default int compareTo(a aVar) {
        AbstractC13042fc3.i(aVar, "other");
        return AbstractC13042fc3.k(getPriority(), aVar.getPriority());
    }
}
