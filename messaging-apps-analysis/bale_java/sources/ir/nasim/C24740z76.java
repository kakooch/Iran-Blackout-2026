package ir.nasim;

/* renamed from: ir.nasim.z76, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24740z76 implements InterfaceC4735Gi3 {
    public static final C24740z76 a = new C24740z76();

    /* renamed from: ir.nasim.z76$a */
    public static final class a implements InterfaceC4486Fi3 {
        private final IL5 b;

        public a(IL5 il5) {
            AbstractC13042fc3.i(il5, "javaElement");
            this.b = il5;
        }

        @Override // ir.nasim.JH6
        public KH6 b() {
            KH6 kh6 = KH6.a;
            AbstractC13042fc3.h(kh6, "NO_SOURCE_FILE");
            return kh6;
        }

        @Override // ir.nasim.InterfaceC4486Fi3
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public IL5 c() {
            return this.b;
        }

        public String toString() {
            return a.class.getName() + ": " + c();
        }
    }

    private C24740z76() {
    }

    @Override // ir.nasim.InterfaceC4735Gi3
    public InterfaceC4486Fi3 a(InterfaceC13720gi3 interfaceC13720gi3) {
        AbstractC13042fc3.i(interfaceC13720gi3, "javaElement");
        return new a((IL5) interfaceC13720gi3);
    }
}
