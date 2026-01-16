package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC22053ub1;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ir.nasim.bb6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C10429bb6 implements InterfaceC9809ab6 {
    public static final c e = new c(null);
    private static final InterfaceC8230Vb6 f = AbstractC8464Wb6.a(a.e, b.e);
    private final Map a;
    private final C7386Rm4 b;
    private InterfaceC11814db6 c;
    private final UA2 d;

    /* renamed from: ir.nasim.bb6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C10429bb6 c10429bb6) {
            return c10429bb6.i();
        }
    }

    /* renamed from: ir.nasim.bb6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C10429bb6 invoke(Map map) {
            return new C10429bb6(map);
        }
    }

    /* renamed from: ir.nasim.bb6$c */
    public static final class c {
        private c() {
        }

        public final InterfaceC8230Vb6 a() {
            return C10429bb6.f;
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.bb6$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Object f;
        final /* synthetic */ InterfaceC11814db6 g;

        /* renamed from: ir.nasim.bb6$d$a */
        public static final class a implements KV1 {
            final /* synthetic */ C10429bb6 a;
            final /* synthetic */ Object b;
            final /* synthetic */ InterfaceC11814db6 c;

            public a(C10429bb6 c10429bb6, Object obj, InterfaceC11814db6 interfaceC11814db6) {
                this.a = c10429bb6;
                this.b = obj;
                this.c = interfaceC11814db6;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                Object objU = this.a.b.u(this.b);
                InterfaceC11814db6 interfaceC11814db6 = this.c;
                if (objU == interfaceC11814db6) {
                    C10429bb6 c10429bb6 = this.a;
                    c10429bb6.j(interfaceC11814db6, c10429bb6.a, this.b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Object obj, InterfaceC11814db6 interfaceC11814db6) {
            super(1);
            this.f = obj;
            this.g = interfaceC11814db6;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            boolean z = !C10429bb6.this.b.b(this.f);
            Object obj = this.f;
            if (z) {
                C10429bb6.this.a.remove(this.f);
                C10429bb6.this.b.x(this.f, this.g);
                return new a(C10429bb6.this, this.f, this.g);
            }
            throw new IllegalArgumentException(("Key " + obj + " was used multiple times ").toString());
        }
    }

    /* renamed from: ir.nasim.bb6$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            InterfaceC11814db6 interfaceC11814db6H = C10429bb6.this.h();
            return Boolean.valueOf(interfaceC11814db6H != null ? interfaceC11814db6H.a(obj) : true);
        }
    }

    public C10429bb6(Map map) {
        this.a = map;
        this.b = AbstractC22068uc6.b();
        this.d = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map i() {
        /*
            r17 = this;
            r0 = r17
            java.util.Map r1 = r0.a
            ir.nasim.Rm4 r2 = r0.b
            java.lang.Object[] r3 = r2.b
            java.lang.Object[] r4 = r2.c
            long[] r2 = r2.a
            int r5 = r2.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L4f
            r6 = 0
            r7 = r6
        L13:
            r8 = r2[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L4a
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L2d:
            if (r12 >= r10) goto L48
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L44
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r4[r13]
            ir.nasim.db6 r13 = (ir.nasim.InterfaceC11814db6) r13
            r0.j(r13, r1, r14)
        L44:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L2d
        L48:
            if (r10 != r11) goto L4f
        L4a:
            if (r7 == r5) goto L4f
            int r7 = r7 + 1
            goto L13
        L4f:
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L56
            r1 = 0
        L56:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10429bb6.i():java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(InterfaceC11814db6 interfaceC11814db6, Map map, Object obj) {
        Map mapD = interfaceC11814db6.d();
        if (mapD.isEmpty()) {
            map.remove(obj);
        } else {
            map.put(obj, mapD);
        }
    }

    @Override // ir.nasim.InterfaceC9809ab6
    public void b(Object obj, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-1198538093);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1198538093, i, -1, "androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider (SaveableStateHolder.kt:69)");
        }
        interfaceC22053ub1.K(207, obj);
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            if (!((Boolean) this.d.invoke(obj)).booleanValue()) {
                throw new IllegalArgumentException(("Type of the key " + obj + " is not supported. On Android you can only use types which can be stored inside the Bundle.").toString());
            }
            objB = AbstractC13035fb6.a((Map) this.a.get(obj), this.d);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC11814db6 interfaceC11814db6 = (InterfaceC11814db6) objB;
        AbstractC11024cc1.a(AbstractC13035fb6.e().d(interfaceC11814db6), interfaceC14603iB2, interfaceC22053ub1, (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | C7252Qx5.i);
        C19938rB7 c19938rB7 = C19938rB7.a;
        boolean zD = interfaceC22053ub1.D(this) | interfaceC22053ub1.D(obj) | interfaceC22053ub1.D(interfaceC11814db6);
        Object objB2 = interfaceC22053ub1.B();
        if (zD || objB2 == aVar.a()) {
            objB2 = new d(obj, interfaceC11814db6);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.a(c19938rB7, (UA2) objB2, interfaceC22053ub1, 6);
        interfaceC22053ub1.z();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
    }

    @Override // ir.nasim.InterfaceC9809ab6
    public void c(Object obj) {
        if (this.b.u(obj) == null) {
            this.a.remove(obj);
        }
    }

    public final InterfaceC11814db6 h() {
        return this.c;
    }

    public final void k(InterfaceC11814db6 interfaceC11814db6) {
        this.c = interfaceC11814db6;
    }

    public /* synthetic */ C10429bb6(Map map, int i, ED1 ed1) {
        this((i & 1) != 0 ? new LinkedHashMap() : map);
    }
}
