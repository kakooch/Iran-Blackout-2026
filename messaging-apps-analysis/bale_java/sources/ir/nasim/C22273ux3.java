package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC11814db6;
import java.util.Map;

/* renamed from: ir.nasim.ux3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C22273ux3 implements InterfaceC11814db6, InterfaceC9809ab6 {
    public static final b d = new b(null);
    private final InterfaceC11814db6 a;
    private final InterfaceC9809ab6 b;
    private final C7620Sm4 c;

    /* renamed from: ir.nasim.ux3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC11814db6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC11814db6 interfaceC11814db6) {
            super(1);
            this.e = interfaceC11814db6;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            InterfaceC11814db6 interfaceC11814db6 = this.e;
            return Boolean.valueOf(interfaceC11814db6 != null ? interfaceC11814db6.a(obj) : true);
        }
    }

    /* renamed from: ir.nasim.ux3$b */
    public static final class b {

        /* renamed from: ir.nasim.ux3$b$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            public static final a e = new a();

            a() {
                super(2);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Map invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C22273ux3 c22273ux3) {
                Map mapD = c22273ux3.d();
                if (mapD.isEmpty()) {
                    return null;
                }
                return mapD;
            }
        }

        /* renamed from: ir.nasim.ux3$b$b, reason: collision with other inner class name */
        static final class C1654b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ InterfaceC11814db6 e;
            final /* synthetic */ InterfaceC9809ab6 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1654b(InterfaceC11814db6 interfaceC11814db6, InterfaceC9809ab6 interfaceC9809ab6) {
                super(1);
                this.e = interfaceC11814db6;
                this.f = interfaceC9809ab6;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C22273ux3 invoke(Map map) {
                return new C22273ux3(this.e, map, this.f);
            }
        }

        private b() {
        }

        public final InterfaceC8230Vb6 a(InterfaceC11814db6 interfaceC11814db6, InterfaceC9809ab6 interfaceC9809ab6) {
            return AbstractC8464Wb6.a(a.e, new C1654b(interfaceC11814db6, interfaceC9809ab6));
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ux3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Object f;

        /* renamed from: ir.nasim.ux3$c$a */
        public static final class a implements KV1 {
            final /* synthetic */ C22273ux3 a;
            final /* synthetic */ Object b;

            public a(C22273ux3 c22273ux3, Object obj) {
                this.a = c22273ux3;
                this.b = obj;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.c.x(this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object obj) {
            super(1);
            this.f = obj;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            C22273ux3.this.c.u(this.f);
            return new a(C22273ux3.this, this.f);
        }
    }

    public C22273ux3(InterfaceC11814db6 interfaceC11814db6, InterfaceC9809ab6 interfaceC9809ab6) {
        this.a = interfaceC11814db6;
        this.b = interfaceC9809ab6;
        this.c = AbstractC23254wc6.a();
    }

    @Override // ir.nasim.InterfaceC11814db6
    public boolean a(Object obj) {
        return this.a.a(obj);
    }

    @Override // ir.nasim.InterfaceC9809ab6
    public void b(Object obj, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-697180401);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-697180401, i, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:74)");
        }
        int i2 = i & 14;
        this.b.b(obj, interfaceC14603iB2, interfaceC22053ub1, (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | i2);
        boolean zD = interfaceC22053ub1.D(this) | interfaceC22053ub1.D(obj);
        Object objB = interfaceC22053ub1.B();
        if (zD || objB == InterfaceC22053ub1.a.a()) {
            objB = new c(obj);
            interfaceC22053ub1.s(objB);
        }
        AbstractC10721c52.a(obj, (UA2) objB, interfaceC22053ub1, i2);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
    }

    @Override // ir.nasim.InterfaceC9809ab6
    public void c(Object obj) {
        this.b.c(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    @Override // ir.nasim.InterfaceC11814db6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map d() {
        /*
            r14 = this;
            ir.nasim.Sm4 r0 = r14.c
            java.lang.Object[] r1 = r0.b
            long[] r0 = r0.a
            int r2 = r0.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L47
            r3 = 0
            r4 = r3
        Ld:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L42
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L27:
            if (r9 >= r7) goto L40
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L3c
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            ir.nasim.ab6 r11 = r14.b
            r11.c(r10)
        L3c:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L27
        L40:
            if (r7 != r8) goto L47
        L42:
            if (r4 == r2) goto L47
            int r4 = r4 + 1
            goto Ld
        L47:
            ir.nasim.db6 r0 = r14.a
            java.util.Map r0 = r0.d()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22273ux3.d():java.util.Map");
    }

    @Override // ir.nasim.InterfaceC11814db6
    public Object e(String str) {
        return this.a.e(str);
    }

    @Override // ir.nasim.InterfaceC11814db6
    public InterfaceC11814db6.a f(String str, SA2 sa2) {
        return this.a.f(str, sa2);
    }

    public C22273ux3(InterfaceC11814db6 interfaceC11814db6, Map map, InterfaceC9809ab6 interfaceC9809ab6) {
        this(AbstractC13035fb6.a(map, new a(interfaceC11814db6)), interfaceC9809ab6);
    }
}
