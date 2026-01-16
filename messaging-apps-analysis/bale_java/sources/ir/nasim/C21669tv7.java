package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC23924xk6;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;

/* renamed from: ir.nasim.tv7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21669tv7 {
    private final AbstractC4607Fv7 a;
    private final C21669tv7 b;
    private final String c;
    private final InterfaceC9102Ym4 d;
    private final InterfaceC9102Ym4 e;
    private final InterfaceC23352wm4 f;
    private final InterfaceC23352wm4 g;
    private final InterfaceC9102Ym4 h;
    private final C14063hH6 i;
    private final C14063hH6 j;
    private final InterfaceC9102Ym4 k;
    private long l;
    private final InterfaceC9664aL6 m;

    /* renamed from: ir.nasim.tv7$a */
    public final class a {
        private final InterfaceC5342Ix7 a;
        private final String b;
        private final InterfaceC9102Ym4 c = AbstractC13472gH6.d(null, null, 2, null);

        /* renamed from: ir.nasim.tv7$a$a, reason: collision with other inner class name */
        public final class C1612a implements InterfaceC9664aL6 {
            private final d a;
            private UA2 b;
            private UA2 c;

            public C1612a(d dVar, UA2 ua2, UA2 ua22) {
                this.a = dVar;
                this.b = ua2;
                this.c = ua22;
            }

            public final void A(UA2 ua2) {
                this.b = ua2;
            }

            public final void B(b bVar) {
                Object objInvoke = this.c.invoke(bVar.a());
                if (!C21669tv7.this.u()) {
                    this.a.Q(objInvoke, (InterfaceC4788Go2) this.b.invoke(bVar));
                } else {
                    this.a.P(this.c.invoke(bVar.b()), objInvoke, (InterfaceC4788Go2) this.b.invoke(bVar));
                }
            }

            public final d f() {
                return this.a;
            }

            @Override // ir.nasim.InterfaceC9664aL6
            public Object getValue() {
                B(C21669tv7.this.m());
                return this.a.getValue();
            }

            public final UA2 i() {
                return this.c;
            }

            public final UA2 j() {
                return this.b;
            }

            public final void z(UA2 ua2) {
                this.c = ua2;
            }
        }

        public a(InterfaceC5342Ix7 interfaceC5342Ix7, String str) {
            this.a = interfaceC5342Ix7;
            this.b = str;
        }

        public final InterfaceC9664aL6 a(UA2 ua2, UA2 ua22) {
            C1612a c1612aB = b();
            if (c1612aB == null) {
                C21669tv7 c21669tv7 = C21669tv7.this;
                c1612aB = new C1612a(c21669tv7.new d(ua22.invoke(c21669tv7.h()), AbstractC6483Nt.i(this.a, ua22.invoke(C21669tv7.this.h())), this.a, this.b), ua2, ua22);
                C21669tv7 c21669tv72 = C21669tv7.this;
                c(c1612aB);
                c21669tv72.c(c1612aB.f());
            }
            C21669tv7 c21669tv73 = C21669tv7.this;
            c1612aB.z(ua22);
            c1612aB.A(ua2);
            c1612aB.B(c21669tv73.m());
            return c1612aB;
        }

        public final C1612a b() {
            return (C1612a) this.c.getValue();
        }

        public final void c(C1612a c1612a) {
            this.c.setValue(c1612a);
        }

        public final void d() {
            C1612a c1612aB = b();
            if (c1612aB != null) {
                C21669tv7 c21669tv7 = C21669tv7.this;
                c1612aB.f().P(c1612aB.i().invoke(c21669tv7.m().b()), c1612aB.i().invoke(c21669tv7.m().a()), (InterfaceC4788Go2) c1612aB.j().invoke(c21669tv7.m()));
            }
        }
    }

    /* renamed from: ir.nasim.tv7$b */
    public interface b {
        Object a();

        Object b();

        default boolean c(Object obj, Object obj2) {
            return AbstractC13042fc3.d(obj, b()) && AbstractC13042fc3.d(obj2, a());
        }
    }

    /* renamed from: ir.nasim.tv7$c */
    private static final class c implements b {
        private final Object a;
        private final Object b;

        public c(Object obj, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }

        @Override // ir.nasim.C21669tv7.b
        public Object a() {
            return this.b;
        }

        @Override // ir.nasim.C21669tv7.b
        public Object b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (AbstractC13042fc3.d(b(), bVar.b()) && AbstractC13042fc3.d(a(), bVar.a())) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Object objB = b();
            int iHashCode = (objB != null ? objB.hashCode() : 0) * 31;
            Object objA = a();
            return iHashCode + (objA != null ? objA.hashCode() : 0);
        }
    }

    /* renamed from: ir.nasim.tv7$d */
    public final class d implements InterfaceC9664aL6 {
        private final InterfaceC5342Ix7 a;
        private final String b;
        private final InterfaceC9102Ym4 c;
        private final C18827pJ6 d;
        private final InterfaceC9102Ym4 e;
        private final InterfaceC9102Ym4 f;
        private C23915xj7 g;
        private final InterfaceC9102Ym4 h;
        private final InterfaceC14354hm4 i;
        private boolean j;
        private final InterfaceC9102Ym4 k;
        private AbstractC8151Ut l;
        private final InterfaceC23352wm4 m;
        private boolean n;
        private final InterfaceC4788Go2 o;

        public d(Object obj, AbstractC8151Ut abstractC8151Ut, InterfaceC5342Ix7 interfaceC5342Ix7, String str) {
            Object objInvoke;
            this.a = interfaceC5342Ix7;
            this.b = str;
            this.c = AbstractC13472gH6.d(obj, null, 2, null);
            C18827pJ6 c18827pJ6J = AbstractC5999Lt.j(0.0f, 0.0f, null, 7, null);
            this.d = c18827pJ6J;
            this.e = AbstractC13472gH6.d(c18827pJ6J, null, 2, null);
            this.f = AbstractC13472gH6.d(new C23915xj7(i(), interfaceC5342Ix7, obj, B(), abstractC8151Ut), null, 2, null);
            this.h = AbstractC13472gH6.d(Boolean.TRUE, null, 2, null);
            this.i = AbstractC4326Eq5.a(-1.0f);
            this.k = AbstractC13472gH6.d(obj, null, 2, null);
            this.l = abstractC8151Ut;
            this.m = WG6.a(f().d());
            Float f = (Float) IY7.h().get(interfaceC5342Ix7);
            if (f != null) {
                float fFloatValue = f.floatValue();
                AbstractC8151Ut abstractC8151Ut2 = (AbstractC8151Ut) interfaceC5342Ix7.a().invoke(obj);
                int iB = abstractC8151Ut2.b();
                for (int i = 0; i < iB; i++) {
                    abstractC8151Ut2.e(i, fFloatValue);
                }
                objInvoke = this.a.b().invoke(abstractC8151Ut2);
            } else {
                objInvoke = null;
            }
            this.o = AbstractC5999Lt.j(0.0f, 0.0f, objInvoke, 3, null);
        }

        private final Object B() {
            return this.c.getValue();
        }

        private final void G(C23915xj7 c23915xj7) {
            this.f.setValue(c23915xj7);
        }

        private final void H(InterfaceC4788Go2 interfaceC4788Go2) {
            this.e.setValue(interfaceC4788Go2);
        }

        private final void L(Object obj) {
            this.c.setValue(obj);
        }

        private final void N(Object obj, boolean z) {
            C23915xj7 c23915xj7 = this.g;
            if (AbstractC13042fc3.d(c23915xj7 != null ? c23915xj7.g() : null, B())) {
                G(new C23915xj7(this.o, this.a, obj, obj, AbstractC8385Vt.g(this.l)));
                this.j = true;
                I(f().d());
                return;
            }
            InterfaceC5766Kt interfaceC5766KtI = (!z || this.n || (i() instanceof C18827pJ6)) ? i() : this.o;
            if (C21669tv7.this.l() > 0) {
                interfaceC5766KtI = AbstractC5999Lt.c(interfaceC5766KtI, C21669tv7.this.l());
            }
            G(new C23915xj7(interfaceC5766KtI, this.a, obj, B(), this.l));
            I(f().d());
            this.j = false;
            C21669tv7.this.v();
        }

        static /* synthetic */ void O(d dVar, Object obj, boolean z, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = dVar.getValue();
            }
            if ((i & 2) != 0) {
                z = false;
            }
            dVar.N(obj, z);
        }

        public final float A() {
            return this.i.a();
        }

        public final boolean C() {
            return ((Boolean) this.h.getValue()).booleanValue();
        }

        public final void D(long j, boolean z) {
            if (z) {
                j = f().d();
            }
            M(f().f(j));
            this.l = f().b(j);
            if (f().c(j)) {
                J(true);
            }
        }

        public final void E() {
            K(-2.0f);
        }

        public final void F(long j) {
            if (A() == -1.0f) {
                this.n = true;
                if (AbstractC13042fc3.d(f().g(), f().i())) {
                    M(f().g());
                } else {
                    M(f().f(j));
                    this.l = f().b(j);
                }
            }
        }

        public final void I(long j) {
            this.m.w(j);
        }

        public final void J(boolean z) {
            this.h.setValue(Boolean.valueOf(z));
        }

        public final void K(float f) {
            this.i.s(f);
        }

        public void M(Object obj) {
            this.k.setValue(obj);
        }

        public final void P(Object obj, Object obj2, InterfaceC4788Go2 interfaceC4788Go2) {
            L(obj2);
            H(interfaceC4788Go2);
            if (AbstractC13042fc3.d(f().i(), obj) && AbstractC13042fc3.d(f().g(), obj2)) {
                return;
            }
            O(this, obj, false, 2, null);
        }

        public final void Q(Object obj, InterfaceC4788Go2 interfaceC4788Go2) {
            if (this.j) {
                C23915xj7 c23915xj7 = this.g;
                if (AbstractC13042fc3.d(obj, c23915xj7 != null ? c23915xj7.g() : null)) {
                    return;
                }
            }
            if (AbstractC13042fc3.d(B(), obj) && A() == -1.0f) {
                return;
            }
            L(obj);
            H(interfaceC4788Go2);
            N(A() == -3.0f ? obj : getValue(), !C());
            J(A() == -3.0f);
            if (A() >= 0.0f) {
                M(f().f((long) (f().d() * A())));
            } else if (A() == -3.0f) {
                M(obj);
            }
            this.j = false;
            K(-1.0f);
        }

        public final C23915xj7 f() {
            return (C23915xj7) this.f.getValue();
        }

        @Override // ir.nasim.InterfaceC9664aL6
        public Object getValue() {
            return this.k.getValue();
        }

        public final InterfaceC4788Go2 i() {
            return (InterfaceC4788Go2) this.e.getValue();
        }

        public final long j() {
            return this.m.getLongValue();
        }

        public String toString() {
            return "current value: " + getValue() + ", target: " + B() + ", spec: " + i();
        }

        public final AbstractC23924xk6.a z() {
            return null;
        }
    }

    /* renamed from: ir.nasim.tv7$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Object f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Object obj, int i) {
            super(2);
            this.f = obj;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C21669tv7.this.e(this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tv7$g */
    static final class g extends AbstractC8614Ws3 implements SA2 {
        g() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(C21669tv7.this.f());
        }
    }

    public C21669tv7(AbstractC4607Fv7 abstractC4607Fv7, C21669tv7 c21669tv7, String str) {
        this.a = abstractC4607Fv7;
        this.b = c21669tv7;
        this.c = str;
        this.d = AbstractC13472gH6.d(h(), null, 2, null);
        this.e = AbstractC13472gH6.d(new c(h(), h()), null, 2, null);
        this.f = WG6.a(0L);
        this.g = WG6.a(Long.MIN_VALUE);
        Boolean bool = Boolean.FALSE;
        this.h = AbstractC13472gH6.d(bool, null, 2, null);
        this.i = AbstractC10222bH6.f();
        this.j = AbstractC10222bH6.f();
        this.k = AbstractC13472gH6.d(bool, null, 2, null);
        this.m = AbstractC10222bH6.d(new g());
        abstractC4607Fv7.f(this);
    }

    private final void H(b bVar) {
        this.e.setValue(bVar);
    }

    private final void K(boolean z) {
        this.h.setValue(Boolean.valueOf(z));
    }

    private final void L(long j) {
        this.f.w(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long f() {
        C14063hH6 c14063hH6 = this.i;
        int size = c14063hH6.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            jMax = Math.max(jMax, ((d) c14063hH6.get(i)).j());
        }
        C14063hH6 c14063hH62 = this.j;
        int size2 = c14063hH62.size();
        for (int i2 = 0; i2 < size2; i2++) {
            jMax = Math.max(jMax, ((C21669tv7) c14063hH62.get(i2)).f());
        }
        return jMax;
    }

    private final boolean r() {
        return ((Boolean) this.h.getValue()).booleanValue();
    }

    private final long s() {
        return this.f.getLongValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        K(true);
        if (u()) {
            C14063hH6 c14063hH6 = this.i;
            int size = c14063hH6.size();
            long jMax = 0;
            for (int i = 0; i < size; i++) {
                d dVar = (d) c14063hH6.get(i);
                jMax = Math.max(jMax, dVar.j());
                dVar.F(this.l);
            }
            K(false);
        }
    }

    public final void A(long j) {
        I(j);
        this.a.e(true);
    }

    public final void B(a aVar) {
        d dVarF;
        a.C1612a c1612aB = aVar.b();
        if (c1612aB == null || (dVarF = c1612aB.f()) == null) {
            return;
        }
        C(dVarF);
    }

    public final void C(d dVar) {
        this.i.remove(dVar);
    }

    public final boolean D(C21669tv7 c21669tv7) {
        return this.j.remove(c21669tv7);
    }

    public final void E(Object obj, Object obj2, long j) {
        I(Long.MIN_VALUE);
        this.a.e(false);
        if (!u() || !AbstractC13042fc3.d(h(), obj) || !AbstractC13042fc3.d(o(), obj2)) {
            if (!AbstractC13042fc3.d(h(), obj)) {
                AbstractC4607Fv7 abstractC4607Fv7 = this.a;
                if (abstractC4607Fv7 instanceof C11932dn4) {
                    abstractC4607Fv7.d(obj);
                }
            }
            J(obj2);
            G(true);
            H(new c(obj, obj2));
        }
        C14063hH6 c14063hH6 = this.j;
        int size = c14063hH6.size();
        for (int i = 0; i < size; i++) {
            C21669tv7 c21669tv7 = (C21669tv7) c14063hH6.get(i);
            AbstractC13042fc3.g(c21669tv7, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            if (c21669tv7.u()) {
                c21669tv7.E(c21669tv7.h(), c21669tv7.o(), j);
            }
        }
        C14063hH6 c14063hH62 = this.i;
        int size2 = c14063hH62.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((d) c14063hH62.get(i2)).F(j);
        }
        this.l = j;
    }

    public final void F(long j) {
        if (this.b == null) {
            L(j);
        }
    }

    public final void G(boolean z) {
        this.k.setValue(Boolean.valueOf(z));
    }

    public final void I(long j) {
        this.g.w(j);
    }

    public final void J(Object obj) {
        this.d.setValue(obj);
    }

    public final void M(Object obj) {
        if (AbstractC13042fc3.d(o(), obj)) {
            return;
        }
        H(new c(o(), obj));
        if (!AbstractC13042fc3.d(h(), o())) {
            this.a.d(o());
        }
        J(obj);
        if (!t()) {
            K(true);
        }
        C14063hH6 c14063hH6 = this.i;
        int size = c14063hH6.size();
        for (int i = 0; i < size; i++) {
            ((d) c14063hH6.get(i)).E();
        }
    }

    public final boolean c(d dVar) {
        return this.i.add(dVar);
    }

    public final boolean d(C21669tv7 c21669tv7) {
        return this.j.add(c21669tv7);
    }

    public final void e(Object obj, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1493585151);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(obj) : interfaceC22053ub1J.D(obj) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(this) ? 32 : 16;
        }
        if (interfaceC22053ub1J.o((i2 & 19) != 18, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1493585151, i2, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:1176)");
            }
            if (u()) {
                interfaceC22053ub1J.W(1824284987);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(1822801203);
                M(obj);
                if (!AbstractC13042fc3.d(obj, h()) || t() || r()) {
                    interfaceC22053ub1J.W(1823032494);
                    Object objB = interfaceC22053ub1J.B();
                    InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                    if (objB == aVar.a()) {
                        objB = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1J);
                        interfaceC22053ub1J.s(objB);
                    }
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB;
                    boolean zD = interfaceC22053ub1J.D(interfaceC20315ro1);
                    int i3 = i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
                    boolean z = zD | (i3 == 32);
                    Object objB2 = interfaceC22053ub1J.B();
                    if (z || objB2 == aVar.a()) {
                        objB2 = new e(interfaceC20315ro1, this);
                        interfaceC22053ub1J.s(objB2);
                    }
                    AbstractC10721c52.b(interfaceC20315ro1, this, (UA2) objB2, interfaceC22053ub1J, i3);
                    interfaceC22053ub1J.Q();
                } else {
                    interfaceC22053ub1J.W(1824275067);
                    interfaceC22053ub1J.Q();
                }
                interfaceC22053ub1J.Q();
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new f(obj, i));
        }
    }

    public final List g() {
        return this.i;
    }

    public final Object h() {
        return this.a.a();
    }

    public final boolean i() {
        C14063hH6 c14063hH6 = this.i;
        int size = c14063hH6.size();
        for (int i = 0; i < size; i++) {
            ((d) c14063hH6.get(i)).z();
        }
        C14063hH6 c14063hH62 = this.j;
        int size2 = c14063hH62.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (((C21669tv7) c14063hH62.get(i2)).i()) {
                return true;
            }
        }
        return false;
    }

    public final String j() {
        return this.c;
    }

    public final long k() {
        return this.l;
    }

    public final long l() {
        C21669tv7 c21669tv7 = this.b;
        return c21669tv7 != null ? c21669tv7.l() : s();
    }

    public final b m() {
        return (b) this.e.getValue();
    }

    public final long n() {
        return this.g.getLongValue();
    }

    public final Object o() {
        return this.d.getValue();
    }

    public final long p() {
        return ((Number) this.m.getValue()).longValue();
    }

    public final List q() {
        return this.j;
    }

    public final boolean t() {
        return n() != Long.MIN_VALUE;
    }

    public String toString() {
        List listG = g();
        int size = listG.size();
        String str = "Transition animation values: ";
        for (int i = 0; i < size; i++) {
            str = str + ((d) listG.get(i)) + ", ";
        }
        return str;
    }

    public final boolean u() {
        return ((Boolean) this.k.getValue()).booleanValue();
    }

    public final void w() {
        z();
        this.a.g();
    }

    public final void x(long j, float f2) {
        if (n() == Long.MIN_VALUE) {
            A(j);
        }
        long jN = j - n();
        if (f2 != 0.0f) {
            jN = AbstractC20723sV3.e(jN / f2);
        }
        F(jN);
        y(jN, f2 == 0.0f);
    }

    public final void y(long j, boolean z) {
        boolean z2 = true;
        if (n() == Long.MIN_VALUE) {
            A(j);
        } else if (!this.a.c()) {
            this.a.e(true);
        }
        K(false);
        C14063hH6 c14063hH6 = this.i;
        int size = c14063hH6.size();
        for (int i = 0; i < size; i++) {
            d dVar = (d) c14063hH6.get(i);
            if (!dVar.C()) {
                dVar.D(j, z);
            }
            if (!dVar.C()) {
                z2 = false;
            }
        }
        C14063hH6 c14063hH62 = this.j;
        int size2 = c14063hH62.size();
        for (int i2 = 0; i2 < size2; i2++) {
            C21669tv7 c21669tv7 = (C21669tv7) c14063hH62.get(i2);
            if (!AbstractC13042fc3.d(c21669tv7.o(), c21669tv7.h())) {
                c21669tv7.y(j, z);
            }
            if (!AbstractC13042fc3.d(c21669tv7.o(), c21669tv7.h())) {
                z2 = false;
            }
        }
        if (z2) {
            z();
        }
    }

    public final void z() {
        I(Long.MIN_VALUE);
        AbstractC4607Fv7 abstractC4607Fv7 = this.a;
        if (abstractC4607Fv7 instanceof C11932dn4) {
            abstractC4607Fv7.d(o());
        }
        F(0L);
        this.a.e(false);
        C14063hH6 c14063hH6 = this.j;
        int size = c14063hH6.size();
        for (int i = 0; i < size; i++) {
            ((C21669tv7) c14063hH6.get(i)).z();
        }
    }

    /* renamed from: ir.nasim.tv7$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC20315ro1 e;
        final /* synthetic */ C21669tv7 f;

        /* renamed from: ir.nasim.tv7$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            float b;
            int c;
            private /* synthetic */ Object d;
            final /* synthetic */ C21669tv7 e;

            /* renamed from: ir.nasim.tv7$e$a$a, reason: collision with other inner class name */
            static final class C1613a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ C21669tv7 e;
                final /* synthetic */ float f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1613a(C21669tv7 c21669tv7, float f) {
                    super(1);
                    this.e = c21669tv7;
                    this.f = f;
                }

                public final void a(long j) {
                    if (this.e.u()) {
                        return;
                    }
                    this.e.x(j, this.f);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a(((Number) obj).longValue());
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21669tv7 c21669tv7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = c21669tv7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.e, interfaceC20295rm1);
                aVar.d = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                float fN;
                InterfaceC20315ro1 interfaceC20315ro1;
                Object objE = AbstractC14862ic3.e();
                int i = this.c;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.d;
                    fN = AbstractC18086o37.n(interfaceC20315ro12.getCoroutineContext());
                    interfaceC20315ro1 = interfaceC20315ro12;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    fN = this.b;
                    interfaceC20315ro1 = (InterfaceC20315ro1) this.d;
                    AbstractC10685c16.b(obj);
                }
                while (AbstractC20906so1.g(interfaceC20315ro1)) {
                    C1613a c1613a = new C1613a(this.e, fN);
                    this.d = interfaceC20315ro1;
                    this.b = fN;
                    this.c = 1;
                    if (AbstractC16704lj4.c(c1613a, this) == objE) {
                        return objE;
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC20315ro1 interfaceC20315ro1, C21669tv7 c21669tv7) {
            super(1);
            this.e = interfaceC20315ro1;
            this.f = c21669tv7;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            AbstractC10533bm0.d(this.e, null, EnumC23959xo1.UNDISPATCHED, new a(this.f, null), 1, null);
            return new b();
        }

        /* renamed from: ir.nasim.tv7$e$b */
        public static final class b implements KV1 {
            @Override // ir.nasim.KV1
            public void dispose() {
            }
        }
    }

    public C21669tv7(AbstractC4607Fv7 abstractC4607Fv7, String str) {
        this(abstractC4607Fv7, null, str);
    }

    public C21669tv7(Object obj, String str) {
        this(new C11932dn4(obj), null, str);
    }
}
