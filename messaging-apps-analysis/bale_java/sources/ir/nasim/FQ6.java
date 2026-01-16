package ir.nasim;

/* loaded from: classes7.dex */
public abstract class FQ6 {

    public static final class a extends FQ6 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1809066094;
        }

        public String toString() {
            return "Failed";
        }
    }

    public static final class b extends FQ6 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 1669714731;
        }

        public String toString() {
            return "Loading";
        }
    }

    public static final class c extends FQ6 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -832579140;
        }

        public String toString() {
            return "Nothing";
        }
    }

    public static final class d extends FQ6 {
        private final InterfaceC3346Am2 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterfaceC3346Am2 interfaceC3346Am2) {
            super(null);
            AbstractC13042fc3.i(interfaceC3346Am2, "fileSystemReference");
            this.a = interfaceC3346Am2;
        }

        public final InterfaceC3346Am2 a() {
            return this.a;
        }
    }

    private FQ6() {
    }

    public /* synthetic */ FQ6(ED1 ed1) {
        this();
    }
}
