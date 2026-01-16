package ir.nasim;

/* renamed from: ir.nasim.pw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19197pw3 {
    private final InterfaceC9809ab6 a;
    private final SA2 b;
    private final C7386Rm4 c = AbstractC22068uc6.b();

    /* renamed from: ir.nasim.pw3$a */
    private final class a {
        private final Object a;
        private final Object b;
        private int c;
        private InterfaceC14603iB2 d;

        /* renamed from: ir.nasim.pw3$a$a, reason: collision with other inner class name */
        static final class C1458a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ C19197pw3 e;
            final /* synthetic */ a f;

            /* renamed from: ir.nasim.pw3$a$a$a, reason: collision with other inner class name */
            static final class C1459a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ a e;

                /* renamed from: ir.nasim.pw3$a$a$a$a, reason: collision with other inner class name */
                public static final class C1460a implements KV1 {
                    final /* synthetic */ a a;

                    public C1460a(a aVar) {
                        this.a = aVar;
                    }

                    @Override // ir.nasim.KV1
                    public void dispose() {
                        this.a.d = null;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1459a(a aVar) {
                    super(1);
                    this.e = aVar;
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final KV1 invoke(LV1 lv1) {
                    return new C1460a(this.e);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1458a(C19197pw3 c19197pw3, a aVar) {
                super(2);
                this.e = c19197pw3;
                this.f = aVar;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(1403994769, i, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:87)");
                }
                InterfaceC20397rw3 interfaceC20397rw3 = (InterfaceC20397rw3) this.e.d().invoke();
                int iF = this.f.f();
                if ((iF >= interfaceC20397rw3.a() || !AbstractC13042fc3.d(interfaceC20397rw3.d(iF), this.f.g())) && (iF = interfaceC20397rw3.c(this.f.g())) != -1) {
                    this.f.c = iF;
                }
                int i2 = iF;
                if (i2 != -1) {
                    interfaceC22053ub1.W(-660404355);
                    AbstractC19788qw3.a(interfaceC20397rw3, CJ6.a(this.e.a), i2, CJ6.a(this.f.g()), interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(-660169871);
                    interfaceC22053ub1.Q();
                }
                Object objG = this.f.g();
                boolean zD = interfaceC22053ub1.D(this.f);
                a aVar = this.f;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C1459a(aVar);
                    interfaceC22053ub1.s(objB);
                }
                AbstractC10721c52.a(objG, (UA2) objB, interfaceC22053ub1, 0);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        public a(int i, Object obj, Object obj2) {
            this.a = obj;
            this.b = obj2;
            this.c = i;
        }

        private final InterfaceC14603iB2 c() {
            return AbstractC19242q11.c(1403994769, true, new C1458a(C19197pw3.this, this));
        }

        public final InterfaceC14603iB2 d() {
            InterfaceC14603iB2 interfaceC14603iB2 = this.d;
            if (interfaceC14603iB2 != null) {
                return interfaceC14603iB2;
            }
            InterfaceC14603iB2 interfaceC14603iB2C = c();
            this.d = interfaceC14603iB2C;
            return interfaceC14603iB2C;
        }

        public final Object e() {
            return this.b;
        }

        public final int f() {
            return this.c;
        }

        public final Object g() {
            return this.a;
        }
    }

    public C19197pw3(InterfaceC9809ab6 interfaceC9809ab6, SA2 sa2) {
        this.a = interfaceC9809ab6;
        this.b = sa2;
    }

    public final InterfaceC14603iB2 b(int i, Object obj, Object obj2) {
        a aVar = (a) this.c.e(obj);
        if (aVar != null && aVar.f() == i && AbstractC13042fc3.d(aVar.e(), obj2)) {
            return aVar.d();
        }
        a aVar2 = new a(i, obj, obj2);
        this.c.x(obj, aVar2);
        return aVar2.d();
    }

    public final Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        a aVar = (a) this.c.e(obj);
        if (aVar != null) {
            return aVar.e();
        }
        InterfaceC20397rw3 interfaceC20397rw3 = (InterfaceC20397rw3) this.b.invoke();
        int iC = interfaceC20397rw3.c(obj);
        if (iC != -1) {
            return interfaceC20397rw3.f(iC);
        }
        return null;
    }

    public final SA2 d() {
        return this.b;
    }
}
