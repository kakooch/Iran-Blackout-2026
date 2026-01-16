package ir.nasim;

/* loaded from: classes2.dex */
public final class TZ6 {
    public static final int f = 8;
    private final VZ6 a;
    private C5077Hu3 b;
    private final InterfaceC14603iB2 c;
    private final InterfaceC14603iB2 d;
    private final InterfaceC14603iB2 e;

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        b() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, AbstractC7050Qb1 abstractC7050Qb1) {
            TZ6.this.h().H(abstractC7050Qb1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (AbstractC7050Qb1) obj2);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        c() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, InterfaceC14603iB2 interfaceC14603iB2) {
            c3419Au3.j(TZ6.this.h().u(interfaceC14603iB2));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (InterfaceC14603iB2) obj2);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        d() {
            super(2);
        }

        public final void a(C3419Au3 c3419Au3, TZ6 tz6) {
            TZ6 tz62 = TZ6.this;
            C5077Hu3 c5077Hu3C0 = c3419Au3.C0();
            if (c5077Hu3C0 == null) {
                c5077Hu3C0 = new C5077Hu3(c3419Au3, TZ6.this.a);
                c3419Au3.Y1(c5077Hu3C0);
            }
            tz62.b = c5077Hu3C0;
            TZ6.this.h().B();
            TZ6.this.h().I(TZ6.this.a);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C3419Au3) obj, (TZ6) obj2);
            return C19938rB7.a;
        }
    }

    public TZ6(VZ6 vz6) {
        this.a = vz6;
        this.c = new d();
        this.d = new b();
        this.e = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C5077Hu3 h() {
        C5077Hu3 c5077Hu3 = this.b;
        if (c5077Hu3 != null) {
            return c5077Hu3;
        }
        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout".toString());
    }

    public final void d() {
        h().z();
    }

    public final InterfaceC14603iB2 e() {
        return this.d;
    }

    public final InterfaceC14603iB2 f() {
        return this.e;
    }

    public final InterfaceC14603iB2 g() {
        return this.c;
    }

    public final a i(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        return h().F(obj, interfaceC14603iB2);
    }

    public TZ6() {
        this(PA4.a);
    }

    public interface a {
        void dispose();

        default int e() {
            return 0;
        }

        default void a(Object obj, UA2 ua2) {
        }

        default void b(int i, long j) {
        }
    }
}
