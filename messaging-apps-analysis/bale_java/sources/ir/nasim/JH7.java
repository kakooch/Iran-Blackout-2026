package ir.nasim;

/* loaded from: classes5.dex */
public interface JH7 {

    public static final class a implements JH7 {
        private final long a;
        private final byte[] b;
        private final InterfaceC3346Am2 c;

        public a(long j, byte[] bArr, InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "fileReference");
            this.a = j;
            this.b = bArr;
            this.c = interfaceC3346Am2;
        }

        @Override // ir.nasim.JH7
        public long a() {
            return this.a;
        }

        @Override // ir.nasim.JH7
        public InterfaceC3346Am2 b() {
            return this.c;
        }

        public final byte[] c() {
            return this.b;
        }
    }

    public static final class b implements JH7 {
        private final InterfaceC3346Am2 a;
        private final long b;

        public b(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "fileReference");
            this.a = interfaceC3346Am2;
        }

        @Override // ir.nasim.JH7
        public long a() {
            return this.b;
        }

        @Override // ir.nasim.JH7
        public InterfaceC3346Am2 b() {
            return this.a;
        }
    }

    long a();

    InterfaceC3346Am2 b();
}
