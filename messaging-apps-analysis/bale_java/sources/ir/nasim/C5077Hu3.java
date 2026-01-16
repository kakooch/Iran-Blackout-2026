package ir.nasim;

import androidx.compose.runtime.snapshots.g;
import androidx.compose.ui.e;
import ir.nasim.C3419Au3;
import ir.nasim.TZ6;
import ir.nasim.VZ6;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Hu3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5077Hu3 implements InterfaceC11014cb1 {
    private final C3419Au3 a;
    private AbstractC7050Qb1 b;
    private VZ6 c;
    private int d;
    private int e;
    private int n;
    private int o;
    private final C7386Rm4 f = AbstractC22068uc6.b();
    private final C7386Rm4 g = AbstractC22068uc6.b();
    private final c h = new c();
    private final a i = new a();
    private final C7386Rm4 j = AbstractC22068uc6.b();
    private final VZ6.a k = new VZ6.a(null, 1, null);
    private final C7386Rm4 l = AbstractC22068uc6.b();
    private final C12544en4 m = new C12544en4(new Object[16], 0);
    private final String p = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";

    /* renamed from: ir.nasim.Hu3$a */
    private final class a implements UZ6, InterfaceC12377eW3 {
        private final /* synthetic */ c a;

        public a() {
            this.a = C5077Hu3.this.h;
        }

        @Override // ir.nasim.WH1
        public int A1(long j) {
            return this.a.A1(j);
        }

        @Override // ir.nasim.WH1
        public int B0(float f) {
            return this.a.B0(f);
        }

        @Override // ir.nasim.WH1
        public float D(int i) {
            return this.a.D(i);
        }

        @Override // ir.nasim.InterfaceC12377eW3
        public InterfaceC11734dW3 E0(int i, int i2, Map map, UA2 ua2, UA2 ua22) {
            return this.a.E0(i, i2, map, ua2, ua22);
        }

        @Override // ir.nasim.WH1
        public float I0(long j) {
            return this.a.I0(j);
        }

        @Override // ir.nasim.WH1
        public long I1(long j) {
            return this.a.I1(j);
        }

        @Override // ir.nasim.UZ6
        public List L0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
            C3419Au3 c3419Au3 = (C3419Au3) C5077Hu3.this.g.e(obj);
            return (c3419Au3 == null || C5077Hu3.this.a.V().indexOf(c3419Au3) >= C5077Hu3.this.d) ? C5077Hu3.this.t(obj, interfaceC14603iB2) : c3419Au3.Q();
        }

        @Override // ir.nasim.InterfaceC12377eW3
        public InterfaceC11734dW3 P1(int i, int i2, Map map, UA2 ua2) {
            return this.a.P1(i, i2, map, ua2);
        }

        @Override // ir.nasim.InterfaceC23430wu2
        public long T(float f) {
            return this.a.T(f);
        }

        @Override // ir.nasim.WH1
        public long U(long j) {
            return this.a.U(j);
        }

        @Override // ir.nasim.InterfaceC23430wu2
        public float Y(long j) {
            return this.a.Y(j);
        }

        @Override // ir.nasim.WH1
        public float getDensity() {
            return this.a.getDensity();
        }

        @Override // ir.nasim.InterfaceC10436bc3
        public EnumC12613eu3 getLayoutDirection() {
            return this.a.getLayoutDirection();
        }

        @Override // ir.nasim.WH1
        public long j0(float f) {
            return this.a.j0(f);
        }

        @Override // ir.nasim.WH1
        public float o1(float f) {
            return this.a.o1(f);
        }

        @Override // ir.nasim.InterfaceC10436bc3
        public boolean s0() {
            return this.a.s0();
        }

        @Override // ir.nasim.InterfaceC23430wu2
        public float t1() {
            return this.a.t1();
        }

        @Override // ir.nasim.WH1
        public float w1(float f) {
            return this.a.w1(f);
        }
    }

    /* renamed from: ir.nasim.Hu3$c */
    private final class c implements UZ6 {
        private EnumC12613eu3 a = EnumC12613eu3.b;
        private float b;
        private float c;

        /* renamed from: ir.nasim.Hu3$c$a */
        public static final class a implements InterfaceC11734dW3 {
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            final /* synthetic */ Map c;
            final /* synthetic */ UA2 d;
            final /* synthetic */ c e;
            final /* synthetic */ C5077Hu3 f;
            final /* synthetic */ UA2 g;

            a(int i, int i2, Map map, UA2 ua2, c cVar, C5077Hu3 c5077Hu3, UA2 ua22) {
                this.a = i;
                this.b = i2;
                this.c = map;
                this.d = ua2;
                this.e = cVar;
                this.f = c5077Hu3;
                this.g = ua22;
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public int getHeight() {
                return this.b;
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public int getWidth() {
                return this.a;
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public void j() {
                DJ3 dj3E2;
                if (!this.e.s0() || (dj3E2 = this.f.a.Y().E2()) == null) {
                    this.g.invoke(this.f.a.Y().D1());
                } else {
                    this.g.invoke(dj3E2.D1());
                }
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public UA2 k() {
                return this.d;
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public Map t() {
                return this.c;
            }
        }

        public c() {
        }

        @Override // ir.nasim.InterfaceC12377eW3
        public InterfaceC11734dW3 E0(int i, int i2, Map map, UA2 ua2, UA2 ua22) {
            if (!((i & (-16777216)) == 0 && ((-16777216) & i2) == 0)) {
                M73.b("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
            }
            return new a(i, i2, map, ua2, this, C5077Hu3.this, ua22);
        }

        @Override // ir.nasim.UZ6
        public List L0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
            return C5077Hu3.this.J(obj, interfaceC14603iB2);
        }

        public void b(float f) {
            this.b = f;
        }

        @Override // ir.nasim.WH1
        public float getDensity() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10436bc3
        public EnumC12613eu3 getLayoutDirection() {
            return this.a;
        }

        public void h(float f) {
            this.c = f;
        }

        public void o(EnumC12613eu3 enumC12613eu3) {
            this.a = enumC12613eu3;
        }

        @Override // ir.nasim.InterfaceC10436bc3
        public boolean s0() {
            return C5077Hu3.this.a.g0() == C3419Au3.e.d || C5077Hu3.this.a.g0() == C3419Au3.e.b;
        }

        @Override // ir.nasim.InterfaceC23430wu2
        public float t1() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.Hu3$d */
    public static final class d extends C3419Au3.f {
        final /* synthetic */ InterfaceC14603iB2 c;

        /* renamed from: ir.nasim.Hu3$d$a */
        public static final class a implements InterfaceC11734dW3 {
            private final /* synthetic */ InterfaceC11734dW3 a;
            final /* synthetic */ C5077Hu3 b;
            final /* synthetic */ int c;
            final /* synthetic */ InterfaceC11734dW3 d;

            public a(InterfaceC11734dW3 interfaceC11734dW3, C5077Hu3 c5077Hu3, int i, InterfaceC11734dW3 interfaceC11734dW32) {
                this.b = c5077Hu3;
                this.c = i;
                this.d = interfaceC11734dW32;
                this.a = interfaceC11734dW3;
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public int getHeight() {
                return this.a.getHeight();
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public int getWidth() {
                return this.a.getWidth();
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public void j() {
                this.b.e = this.c;
                this.d.j();
                this.b.y();
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public UA2 k() {
                return this.a.k();
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public Map t() {
                return this.a.t();
            }
        }

        /* renamed from: ir.nasim.Hu3$d$b */
        public static final class b implements InterfaceC11734dW3 {
            private final /* synthetic */ InterfaceC11734dW3 a;
            final /* synthetic */ C5077Hu3 b;
            final /* synthetic */ int c;
            final /* synthetic */ InterfaceC11734dW3 d;

            public b(InterfaceC11734dW3 interfaceC11734dW3, C5077Hu3 c5077Hu3, int i, InterfaceC11734dW3 interfaceC11734dW32) {
                this.b = c5077Hu3;
                this.c = i;
                this.d = interfaceC11734dW32;
                this.a = interfaceC11734dW3;
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public int getHeight() {
                return this.a.getHeight();
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public int getWidth() {
                return this.a.getWidth();
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public void j() {
                this.b.d = this.c;
                this.d.j();
                C5077Hu3 c5077Hu3 = this.b;
                c5077Hu3.x(c5077Hu3.d);
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public UA2 k() {
                return this.a.k();
            }

            @Override // ir.nasim.InterfaceC11734dW3
            public Map t() {
                return this.a.t();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC14603iB2 interfaceC14603iB2, String str) {
            super(str);
            this.c = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            C5077Hu3.this.h.o(interfaceC12377eW3.getLayoutDirection());
            C5077Hu3.this.h.b(interfaceC12377eW3.getDensity());
            C5077Hu3.this.h.h(interfaceC12377eW3.t1());
            if (interfaceC12377eW3.s0() || C5077Hu3.this.a.k0() == null) {
                C5077Hu3.this.d = 0;
                InterfaceC11734dW3 interfaceC11734dW3 = (InterfaceC11734dW3) this.c.invoke(C5077Hu3.this.h, C17833ne1.a(j));
                return new b(interfaceC11734dW3, C5077Hu3.this, C5077Hu3.this.d, interfaceC11734dW3);
            }
            C5077Hu3.this.e = 0;
            InterfaceC11734dW3 interfaceC11734dW32 = (InterfaceC11734dW3) this.c.invoke(C5077Hu3.this.i, C17833ne1.a(j));
            return new a(interfaceC11734dW32, C5077Hu3.this, C5077Hu3.this.e, interfaceC11734dW32);
        }
    }

    /* renamed from: ir.nasim.Hu3$f */
    public static final class f implements TZ6.a {
        final /* synthetic */ Object b;

        f(Object obj) {
            this.b = obj;
        }

        @Override // ir.nasim.TZ6.a
        public void a(Object obj, UA2 ua2) {
            VA4 va4T0;
            e.c cVarK;
            C3419Au3 c3419Au3 = (C3419Au3) C5077Hu3.this.j.e(this.b);
            if (c3419Au3 == null || (va4T0 = c3419Au3.t0()) == null || (cVarK = va4T0.k()) == null) {
                return;
            }
            AbstractC8931Xv7.e(cVarK, obj, ua2);
        }

        @Override // ir.nasim.TZ6.a
        public void b(int i, long j) {
            C3419Au3 c3419Au3 = (C3419Au3) C5077Hu3.this.j.e(this.b);
            if (c3419Au3 == null || !c3419Au3.b()) {
                return;
            }
            int size = c3419Au3.R().size();
            if (i < 0 || i >= size) {
                M73.d("Index (" + i + ") is out of bound of [0, " + size + ')');
            }
            if (!(!c3419Au3.o())) {
                M73.a("Pre-measure called on node that is not placed");
            }
            C3419Au3 c3419Au32 = C5077Hu3.this.a;
            c3419Au32.s = true;
            AbstractC4360Eu3.b(c3419Au3).J((C3419Au3) c3419Au3.R().get(i), j);
            c3419Au32.s = false;
        }

        @Override // ir.nasim.TZ6.a
        public void dispose() {
            C5077Hu3.this.B();
            C3419Au3 c3419Au3 = (C3419Au3) C5077Hu3.this.j.u(this.b);
            if (c3419Au3 != null) {
                if (!(C5077Hu3.this.o > 0)) {
                    M73.b("No pre-composed items to dispose");
                }
                int iIndexOf = C5077Hu3.this.a.V().indexOf(c3419Au3);
                if (!(iIndexOf >= C5077Hu3.this.a.V().size() - C5077Hu3.this.o)) {
                    M73.b("Item is not in pre-composed item range");
                }
                C5077Hu3.this.n++;
                C5077Hu3 c5077Hu3 = C5077Hu3.this;
                c5077Hu3.o--;
                int size = (C5077Hu3.this.a.V().size() - C5077Hu3.this.o) - C5077Hu3.this.n;
                C5077Hu3.this.D(iIndexOf, size, 1);
                C5077Hu3.this.x(size);
            }
        }

        @Override // ir.nasim.TZ6.a
        public int e() {
            List listR;
            C3419Au3 c3419Au3 = (C3419Au3) C5077Hu3.this.j.e(this.b);
            if (c3419Au3 == null || (listR = c3419Au3.R()) == null) {
                return 0;
            }
            return listR.size();
        }
    }

    /* renamed from: ir.nasim.Hu3$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ b e;
        final /* synthetic */ InterfaceC14603iB2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(b bVar, InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.e = bVar;
            this.f = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1750409193, i, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:522)");
            }
            boolean zA = this.e.a();
            InterfaceC14603iB2 interfaceC14603iB2 = this.f;
            interfaceC22053ub1.K(207, Boolean.valueOf(zA));
            boolean zA2 = interfaceC22053ub1.a(zA);
            if (zA) {
                interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
            } else {
                interfaceC22053ub1.i(zA2);
            }
            interfaceC22053ub1.z();
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

    public C5077Hu3(C3419Au3 c3419Au3, VZ6 vz6) {
        this.a = c3419Au3;
        this.c = vz6;
    }

    private final Object A(List list, int i) {
        Object objE = this.f.e((C3419Au3) list.get(i));
        AbstractC13042fc3.f(objE);
        return ((b) objE).f();
    }

    private final void C(boolean z) {
        this.o = 0;
        this.j.k();
        List listV = this.a.V();
        int size = listV.size();
        if (this.n != size) {
            this.n = size;
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            androidx.compose.runtime.snapshots.g gVarD = aVar.d();
            UA2 ua2G = gVarD != null ? gVarD.g() : null;
            androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
            for (int i = 0; i < size; i++) {
                try {
                    C3419Au3 c3419Au3 = (C3419Au3) listV.get(i);
                    b bVar = (b) this.f.e(c3419Au3);
                    if (bVar != null && bVar.a()) {
                        G(c3419Au3);
                        if (z) {
                            InterfaceC24090y16 interfaceC24090y16B = bVar.b();
                            if (interfaceC24090y16B != null) {
                                interfaceC24090y16B.deactivate();
                            }
                            bVar.h(AbstractC13472gH6.d(Boolean.FALSE, null, 2, null));
                        } else {
                            bVar.g(false);
                        }
                        bVar.m(SZ6.a);
                    }
                } catch (Throwable th) {
                    aVar.l(gVarD, gVarE, ua2G);
                    throw th;
                }
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            aVar.l(gVarD, gVarE, ua2G);
            this.g.k();
        }
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int i, int i2, int i3) {
        C3419Au3 c3419Au3 = this.a;
        c3419Au3.s = true;
        this.a.m1(i, i2, i3);
        c3419Au3.s = false;
    }

    static /* synthetic */ void E(C5077Hu3 c5077Hu3, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        c5077Hu3.D(i, i2, i3);
    }

    private final void G(C3419Au3 c3419Au3) {
        C10354bW3 c10354bW3M0 = c3419Au3.m0();
        C3419Au3.g gVar = C3419Au3.g.c;
        c10354bW3M0.q2(gVar);
        GJ3 gj3J0 = c3419Au3.j0();
        if (gj3J0 != null) {
            gj3J0.o2(gVar);
        }
    }

    private final void K(C3419Au3 c3419Au3, b bVar) {
        g.a aVar = androidx.compose.runtime.snapshots.g.e;
        androidx.compose.runtime.snapshots.g gVarD = aVar.d();
        UA2 ua2G = gVarD != null ? gVarD.g() : null;
        androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
        try {
            C3419Au3 c3419Au32 = this.a;
            c3419Au32.s = true;
            InterfaceC14603iB2 interfaceC14603iB2C = bVar.c();
            InterfaceC24090y16 interfaceC24090y16B = bVar.b();
            AbstractC7050Qb1 abstractC7050Qb1 = this.b;
            if (abstractC7050Qb1 == null) {
                M73.c("parent composition reference not set");
                throw new KotlinNothingValueException();
            }
            bVar.i(M(interfaceC24090y16B, c3419Au3, bVar.e(), abstractC7050Qb1, AbstractC19242q11.c(-1750409193, true, new g(bVar, interfaceC14603iB2C))));
            bVar.l(false);
            c3419Au32.s = false;
            C19938rB7 c19938rB7 = C19938rB7.a;
        } finally {
            aVar.l(gVarD, gVarE, ua2G);
        }
    }

    private final void L(C3419Au3 c3419Au3, Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        C7386Rm4 c7386Rm4 = this.f;
        Object objE = c7386Rm4.e(c3419Au3);
        if (objE == null) {
            objE = new b(obj, W91.a.a(), null, 4, null);
            c7386Rm4.x(c3419Au3, objE);
        }
        b bVar = (b) objE;
        InterfaceC24090y16 interfaceC24090y16B = bVar.b();
        boolean zR = interfaceC24090y16B != null ? interfaceC24090y16B.r() : true;
        if (bVar.c() != interfaceC14603iB2 || zR || bVar.d()) {
            bVar.j(interfaceC14603iB2);
            K(c3419Au3, bVar);
            bVar.k(false);
        }
    }

    private final InterfaceC24090y16 M(InterfaceC24090y16 interfaceC24090y16, C3419Au3 c3419Au3, boolean z, AbstractC7050Qb1 abstractC7050Qb1, InterfaceC14603iB2 interfaceC14603iB2) {
        if (interfaceC24090y16 == null || interfaceC24090y16.a()) {
            interfaceC24090y16 = WZ6.a(c3419Au3, abstractC7050Qb1);
        }
        if (z) {
            interfaceC24090y16.w(interfaceC14603iB2);
        } else {
            interfaceC24090y16.l(interfaceC14603iB2);
        }
        return interfaceC24090y16;
    }

    private final C3419Au3 N(Object obj) {
        int i;
        if (this.n == 0) {
            return null;
        }
        List listV = this.a.V();
        int size = listV.size() - this.o;
        int i2 = size - this.n;
        int i3 = size - 1;
        int i4 = i3;
        while (true) {
            if (i4 < i2) {
                i = -1;
                break;
            }
            if (AbstractC13042fc3.d(A(listV, i4), obj)) {
                i = i4;
                break;
            }
            i4--;
        }
        if (i == -1) {
            while (i3 >= i2) {
                Object objE = this.f.e((C3419Au3) listV.get(i3));
                AbstractC13042fc3.f(objE);
                b bVar = (b) objE;
                if (bVar.f() == SZ6.a || this.c.a(obj, bVar.f())) {
                    bVar.m(obj);
                    i4 = i3;
                    i = i4;
                    break;
                }
                i3--;
            }
            i4 = i3;
        }
        if (i == -1) {
            return null;
        }
        if (i4 != i2) {
            D(i4, i2, 1);
        }
        this.n--;
        C3419Au3 c3419Au3 = (C3419Au3) listV.get(i2);
        Object objE2 = this.f.e(c3419Au3);
        AbstractC13042fc3.f(objE2);
        b bVar2 = (b) objE2;
        bVar2.h(AbstractC13472gH6.d(Boolean.TRUE, null, 2, null));
        bVar2.l(true);
        bVar2.k(true);
        return c3419Au3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List t(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        if (!(this.m.o() >= this.e)) {
            M73.a("Error: currentApproachIndex cannot be greater than the size of theapproachComposedSlotIds list.");
        }
        int iO = this.m.o();
        int i = this.e;
        if (iO == i) {
            this.m.d(obj);
        } else {
            this.m.A(i, obj);
        }
        this.e++;
        if (!this.j.b(obj)) {
            this.l.x(obj, F(obj, interfaceC14603iB2));
            if (this.a.g0() == C3419Au3.e.c) {
                this.a.y1(true);
            } else {
                C3419Au3.B1(this.a, true, false, false, 6, null);
            }
        }
        C3419Au3 c3419Au3 = (C3419Au3) this.j.e(obj);
        if (c3419Au3 != null) {
            List listS1 = c3419Au3.m0().s1();
            int size = listS1.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((C10354bW3) listS1.get(i2)).Z1();
            }
            if (listS1 != null) {
                return listS1;
            }
        }
        return AbstractC10360bX0.m();
    }

    private final C3419Au3 v(int i) {
        C3419Au3 c3419Au3 = new C3419Au3(true, 0, 2, null);
        C3419Au3 c3419Au32 = this.a;
        c3419Au32.s = true;
        this.a.L0(i, c3419Au3);
        c3419Au32.s = false;
        return c3419Au3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void w() {
        /*
            r15 = this;
            ir.nasim.Au3 r0 = r15.a
            r1 = 1
            ir.nasim.C3419Au3.A(r0, r1)
            ir.nasim.Rm4 r1 = r15.f
            java.lang.Object[] r2 = r1.c
            long[] r1 = r1.a
            int r3 = r1.length
            int r3 = r3 + (-2)
            r4 = 0
            if (r3 < 0) goto L53
            r5 = r4
        L13:
            r6 = r1[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L4e
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L2d:
            if (r10 >= r8) goto L4c
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L48
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            ir.nasim.Hu3$b r11 = (ir.nasim.C5077Hu3.b) r11
            ir.nasim.y16 r11 = r11.b()
            if (r11 == 0) goto L48
            r11.dispose()
        L48:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L2d
        L4c:
            if (r8 != r9) goto L53
        L4e:
            if (r5 == r3) goto L53
            int r5 = r5 + 1
            goto L13
        L53:
            ir.nasim.Au3 r1 = r15.a
            r1.u1()
            ir.nasim.C3419Au3.A(r0, r4)
            ir.nasim.Rm4 r0 = r15.f
            r0.k()
            ir.nasim.Rm4 r0 = r15.g
            r0.k()
            r15.o = r4
            r15.n = r4
            ir.nasim.Rm4 r0 = r15.j
            r0.k()
            r15.B()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5077Hu3.w():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        C7386Rm4 c7386Rm4 = this.l;
        long[] jArr = c7386Rm4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj = c7386Rm4.b[i4];
                        TZ6.a aVar = (TZ6.a) c7386Rm4.c[i4];
                        int iP = this.m.p(obj);
                        if (iP < 0 || iP >= this.e) {
                            aVar.dispose();
                            c7386Rm4.v(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void B() {
        int size = this.a.V().size();
        if (!(this.f.g() == size)) {
            M73.a("Inconsistency between the count of nodes tracked by the state (" + this.f.g() + ") and the children count on the SubcomposeLayout (" + size + "). Are you trying to use the state of the disposed SubcomposeLayout?");
        }
        if (!((size - this.n) - this.o >= 0)) {
            M73.a("Incorrect state. Total children " + size + ". Reusable children " + this.n + ". Precomposed children " + this.o);
        }
        if (this.j.g() == this.o) {
            return;
        }
        M73.a("Incorrect state. Precomposed children " + this.o + ". Map size " + this.j.g());
    }

    public final TZ6.a F(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        if (!this.a.b()) {
            return new e();
        }
        B();
        if (!this.g.c(obj)) {
            this.l.u(obj);
            C7386Rm4 c7386Rm4 = this.j;
            Object objE = c7386Rm4.e(obj);
            if (objE == null) {
                objE = N(obj);
                if (objE != null) {
                    D(this.a.V().indexOf(objE), this.a.V().size(), 1);
                    this.o++;
                } else {
                    objE = v(this.a.V().size());
                    this.o++;
                }
                c7386Rm4.x(obj, objE);
            }
            L((C3419Au3) objE, obj, interfaceC14603iB2);
        }
        return new f(obj);
    }

    public final void H(AbstractC7050Qb1 abstractC7050Qb1) {
        this.b = abstractC7050Qb1;
    }

    public final void I(VZ6 vz6) {
        if (this.c != vz6) {
            this.c = vz6;
            C(false);
            C3419Au3.F1(this.a, false, false, false, 7, null);
        }
    }

    public final List J(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        B();
        C3419Au3.e eVarG0 = this.a.g0();
        C3419Au3.e eVar = C3419Au3.e.a;
        if (!(eVarG0 == eVar || eVarG0 == C3419Au3.e.c || eVarG0 == C3419Au3.e.b || eVarG0 == C3419Au3.e.d)) {
            M73.b("subcompose can only be used inside the measure or layout blocks");
        }
        C7386Rm4 c7386Rm4 = this.g;
        Object objE = c7386Rm4.e(obj);
        if (objE == null) {
            objE = (C3419Au3) this.j.u(obj);
            if (objE != null) {
                if (!(this.o > 0)) {
                    M73.b("Check failed.");
                }
                this.o--;
            } else {
                objE = N(obj);
                if (objE == null) {
                    objE = v(this.d);
                }
            }
            c7386Rm4.x(obj, objE);
        }
        C3419Au3 c3419Au3 = (C3419Au3) objE;
        if (AbstractC15401jX0.t0(this.a.V(), this.d) != c3419Au3) {
            int iIndexOf = this.a.V().indexOf(c3419Au3);
            if (!(iIndexOf >= this.d)) {
                M73.a("Key \"" + obj + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.");
            }
            int i = this.d;
            if (i != iIndexOf) {
                E(this, iIndexOf, i, 0, 4, null);
            }
        }
        this.d++;
        L(c3419Au3, obj, interfaceC14603iB2);
        return (eVarG0 == eVar || eVarG0 == C3419Au3.e.c) ? c3419Au3.Q() : c3419Au3.P();
    }

    @Override // ir.nasim.InterfaceC11014cb1
    public void i() {
        C(true);
    }

    @Override // ir.nasim.InterfaceC11014cb1
    public void m() {
        C(false);
    }

    @Override // ir.nasim.InterfaceC11014cb1
    public void q() {
        w();
    }

    public final InterfaceC10970cW3 u(InterfaceC14603iB2 interfaceC14603iB2) {
        return new d(interfaceC14603iB2, this.p);
    }

    public final void x(int i) {
        boolean z = false;
        this.n = 0;
        List listV = this.a.V();
        int size = (listV.size() - this.o) - 1;
        if (i <= size) {
            this.k.clear();
            if (i <= size) {
                int i2 = i;
                while (true) {
                    this.k.add(A(listV, i2));
                    if (i2 == size) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.c.b(this.k);
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            androidx.compose.runtime.snapshots.g gVarD = aVar.d();
            UA2 ua2G = gVarD != null ? gVarD.g() : null;
            androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
            boolean z2 = false;
            while (size >= i) {
                try {
                    C3419Au3 c3419Au3 = (C3419Au3) listV.get(size);
                    Object objE = this.f.e(c3419Au3);
                    AbstractC13042fc3.f(objE);
                    b bVar = (b) objE;
                    Object objF = bVar.f();
                    if (this.k.contains(objF)) {
                        this.n++;
                        if (bVar.a()) {
                            G(c3419Au3);
                            bVar.g(false);
                            z2 = true;
                        }
                    } else {
                        C3419Au3 c3419Au32 = this.a;
                        c3419Au32.s = true;
                        this.f.u(c3419Au3);
                        InterfaceC24090y16 interfaceC24090y16B = bVar.b();
                        if (interfaceC24090y16B != null) {
                            interfaceC24090y16B.dispose();
                        }
                        this.a.v1(size, 1);
                        c3419Au32.s = false;
                    }
                    this.g.u(objF);
                    size--;
                } catch (Throwable th) {
                    aVar.l(gVarD, gVarE, ua2G);
                    throw th;
                }
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            aVar.l(gVarD, gVarE, ua2G);
            z = z2;
        }
        if (z) {
            androidx.compose.runtime.snapshots.g.e.m();
        }
        B();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z() {
        /*
            r14 = this;
            ir.nasim.Au3 r0 = r14.a
            java.util.List r0 = r0.V()
            int r0 = r0.size()
            int r1 = r14.n
            if (r1 == r0) goto L68
            ir.nasim.Rm4 r0 = r14.f
            java.lang.Object[] r1 = r0.c
            long[] r0 = r0.a
            int r2 = r0.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L56
            r3 = 0
            r4 = r3
        L1b:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L51
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L35:
            if (r9 >= r7) goto L4f
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L4b
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            ir.nasim.Hu3$b r10 = (ir.nasim.C5077Hu3.b) r10
            r11 = 1
            r10.k(r11)
        L4b:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L35
        L4f:
            if (r7 != r8) goto L56
        L51:
            if (r4 == r2) goto L56
            int r4 = r4 + 1
            goto L1b
        L56:
            ir.nasim.Au3 r0 = r14.a
            boolean r0 = r0.n0()
            if (r0 != 0) goto L68
            ir.nasim.Au3 r1 = r14.a
            r5 = 7
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            ir.nasim.C3419Au3.F1(r1, r2, r3, r4, r5, r6)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5077Hu3.z():void");
    }

    /* renamed from: ir.nasim.Hu3$b */
    private static final class b {
        private Object a;
        private InterfaceC14603iB2 b;
        private InterfaceC24090y16 c;
        private boolean d;
        private boolean e;
        private InterfaceC9102Ym4 f;

        public b(Object obj, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC24090y16 interfaceC24090y16) {
            this.a = obj;
            this.b = interfaceC14603iB2;
            this.c = interfaceC24090y16;
            this.f = AbstractC13472gH6.d(Boolean.TRUE, null, 2, null);
        }

        public final boolean a() {
            return ((Boolean) this.f.getValue()).booleanValue();
        }

        public final InterfaceC24090y16 b() {
            return this.c;
        }

        public final InterfaceC14603iB2 c() {
            return this.b;
        }

        public final boolean d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }

        public final Object f() {
            return this.a;
        }

        public final void g(boolean z) {
            this.f.setValue(Boolean.valueOf(z));
        }

        public final void h(InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.f = interfaceC9102Ym4;
        }

        public final void i(InterfaceC24090y16 interfaceC24090y16) {
            this.c = interfaceC24090y16;
        }

        public final void j(InterfaceC14603iB2 interfaceC14603iB2) {
            this.b = interfaceC14603iB2;
        }

        public final void k(boolean z) {
            this.d = z;
        }

        public final void l(boolean z) {
            this.e = z;
        }

        public final void m(Object obj) {
            this.a = obj;
        }

        public /* synthetic */ b(Object obj, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC24090y16 interfaceC24090y16, int i, ED1 ed1) {
            this(obj, interfaceC14603iB2, (i & 4) != 0 ? null : interfaceC24090y16);
        }
    }

    /* renamed from: ir.nasim.Hu3$e */
    public static final class e implements TZ6.a {
        e() {
        }

        @Override // ir.nasim.TZ6.a
        public void dispose() {
        }
    }
}
