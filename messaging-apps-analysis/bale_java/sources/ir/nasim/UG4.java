package ir.nasim;

/* loaded from: classes2.dex */
public final class UG4 implements InterfaceC24304yO4 {
    public static final b b = new b(null);
    public static final int c = 8;
    private static final UA2 d = a.e;
    private final SG4 a;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final void a(UG4 ug4) {
            if (ug4.Z0()) {
                ug4.b().x0();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((UG4) obj);
            return C19938rB7.a;
        }
    }

    public static final class b {
        private b() {
        }

        public final UA2 a() {
            return UG4.d;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public UG4(SG4 sg4) {
        this.a = sg4;
    }

    @Override // ir.nasim.InterfaceC24304yO4
    public boolean Z0() {
        return this.a.h().b2();
    }

    public final SG4 b() {
        return this.a;
    }
}
