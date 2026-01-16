package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.Y45;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.Gb1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4670Gb1 implements InterfaceC22053ub1 {
    private int B;
    private int C;
    private boolean D;
    private final c E;
    private final ArrayList F;
    private boolean G;
    private boolean H;
    private C21176tE6 I;
    private C21850uE6 J;
    private C24216yE6 K;
    private boolean L;
    private Y45 M;
    private OI0 N;
    private final C23239wb1 O;
    private C6669Om P;
    private C21604tp2 Q;
    private boolean R;
    private int S;
    private InterfaceC7518Sb1 T;
    private final InterfaceC15247jG b;
    private final AbstractC7050Qb1 c;
    private final C21850uE6 d;
    private final Set e;
    private OI0 f;
    private OI0 g;
    private final InterfaceC25123zm1 h;
    private C18675p35 j;
    private int k;
    private int l;
    private int m;
    private int[] o;
    private C15552jm4 p;
    private boolean q;
    private boolean r;
    private boolean s;
    private C16734lm4 w;
    private boolean x;
    private boolean z;
    private final ArrayList i = DJ6.c(null, 1, null);
    private final C5131Ia3 n = new C5131Ia3();
    private final List t = new ArrayList();
    private final C5131Ia3 u = new C5131Ia3();
    private Y45 v = Z45.a();
    private final C5131Ia3 y = new C5131Ia3();
    private int A = -1;

    /* renamed from: ir.nasim.Gb1$b */
    public final class b extends AbstractC7050Qb1 {
        private final int a;
        private final boolean b;
        private final boolean c;
        private final C14249hc1 d;
        private Set e;
        private final Set f = new LinkedHashSet();
        private final InterfaceC9102Ym4 g = AbstractC10222bH6.h(Z45.a(), AbstractC10222bH6.p());

        public b(int i, boolean z, boolean z2, C14249hc1 c14249hc1) {
            this.a = i;
            this.b = z;
            this.c = z2;
            this.d = c14249hc1;
        }

        private final Y45 u() {
            return (Y45) this.g.getValue();
        }

        private final void v(Y45 y45) {
            this.g.setValue(y45);
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public void a(InterfaceC25123zm1 interfaceC25123zm1, InterfaceC14603iB2 interfaceC14603iB2) {
            C4670Gb1.this.c.a(interfaceC25123zm1, interfaceC14603iB2);
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public void b() {
            C4670Gb1 c4670Gb1 = C4670Gb1.this;
            c4670Gb1.B--;
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public boolean c() {
            return C4670Gb1.this.c.c();
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public boolean d() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public boolean e() {
            return this.c;
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public Y45 f() {
            return u();
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public int g() {
            return this.a;
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public InterfaceC11938do1 h() {
            return C4670Gb1.this.c.h();
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public C14249hc1 i() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public void j(C20869sk4 c20869sk4) {
            C4670Gb1.this.c.j(c20869sk4);
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public void k(InterfaceC25123zm1 interfaceC25123zm1) {
            C4670Gb1.this.c.k(C4670Gb1.this.F0());
            C4670Gb1.this.c.k(interfaceC25123zm1);
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public AbstractC20278rk4 l(C20869sk4 c20869sk4) {
            return C4670Gb1.this.c.l(c20869sk4);
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public void m(Set set) {
            Set hashSet = this.e;
            if (hashSet == null) {
                hashSet = new HashSet();
                this.e = hashSet;
            }
            hashSet.add(set);
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public void n(InterfaceC22053ub1 interfaceC22053ub1) {
            AbstractC13042fc3.g(interfaceC22053ub1, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
            super.n((C4670Gb1) interfaceC22053ub1);
            this.f.add(interfaceC22053ub1);
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public void o(InterfaceC25123zm1 interfaceC25123zm1) {
            C4670Gb1.this.c.o(interfaceC25123zm1);
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public void p() {
            C4670Gb1.this.B++;
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public void q(InterfaceC22053ub1 interfaceC22053ub1) {
            Set<Set> set = this.e;
            if (set != null) {
                for (Set set2 : set) {
                    AbstractC13042fc3.g(interfaceC22053ub1, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
                    set2.remove(((C4670Gb1) interfaceC22053ub1).d);
                }
            }
            AbstractC19810qy7.a(this.f).remove(interfaceC22053ub1);
        }

        @Override // ir.nasim.AbstractC7050Qb1
        public void r(InterfaceC25123zm1 interfaceC25123zm1) {
            C4670Gb1.this.c.r(interfaceC25123zm1);
        }

        public final void s() {
            if (!this.f.isEmpty()) {
                Set set = this.e;
                if (set != null) {
                    for (C4670Gb1 c4670Gb1 : this.f) {
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            ((Set) it.next()).remove(c4670Gb1.d);
                        }
                    }
                }
                this.f.clear();
            }
        }

        public final Set t() {
            return this.f;
        }

        public final void w(Y45 y45) {
            v(y45);
        }
    }

    /* renamed from: ir.nasim.Gb1$c */
    public static final class c implements InterfaceC19995rI1 {
        c() {
        }

        @Override // ir.nasim.InterfaceC19995rI1
        public void a(InterfaceC19404qI1 interfaceC19404qI1) {
            C4670Gb1 c4670Gb1 = C4670Gb1.this;
            c4670Gb1.B--;
        }

        @Override // ir.nasim.InterfaceC19995rI1
        public void b(InterfaceC19404qI1 interfaceC19404qI1) {
            C4670Gb1.this.B++;
        }
    }

    /* renamed from: ir.nasim.Gb1$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ OI0 f;
        final /* synthetic */ C21176tE6 g;
        final /* synthetic */ C20869sk4 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(OI0 oi0, C21176tE6 c21176tE6, C20869sk4 c20869sk4) {
            super(0);
            this.f = oi0;
            this.g = c21176tE6;
            this.h = c20869sk4;
        }

        public final void a() {
            C23239wb1 c23239wb1 = C4670Gb1.this.O;
            OI0 oi0 = this.f;
            C4670Gb1 c4670Gb1 = C4670Gb1.this;
            C21176tE6 c21176tE6 = this.g;
            C20869sk4 c20869sk4 = this.h;
            OI0 oi0O = c23239wb1.o();
            try {
                c23239wb1.S(oi0);
                C21176tE6 c21176tE6J0 = c4670Gb1.J0();
                int[] iArr = c4670Gb1.o;
                C16734lm4 c16734lm4 = c4670Gb1.w;
                c4670Gb1.o = null;
                c4670Gb1.w = null;
                try {
                    c4670Gb1.i1(c21176tE6);
                    C23239wb1 c23239wb12 = c4670Gb1.O;
                    boolean zP = c23239wb12.p();
                    try {
                        c23239wb12.T(false);
                        c20869sk4.c();
                        c4670Gb1.O0(null, c20869sk4.e(), c20869sk4.f(), true);
                        c23239wb12.T(zP);
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    } catch (Throwable th) {
                        c23239wb12.T(zP);
                        throw th;
                    }
                } finally {
                    c4670Gb1.i1(c21176tE6J0);
                    c4670Gb1.o = iArr;
                    c4670Gb1.w = c16734lm4;
                }
            } finally {
                c23239wb1.S(oi0O);
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Gb1$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C20869sk4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C20869sk4 c20869sk4) {
            super(0);
            this.f = c20869sk4;
        }

        public final void a() {
            C4670Gb1 c4670Gb1 = C4670Gb1.this;
            this.f.c();
            c4670Gb1.O0(null, this.f.e(), this.f.f(), true);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Gb1$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AbstractC19669qk4 abstractC19669qk4, Object obj) {
            super(2);
            this.e = obj;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
            } else {
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(316014703, i, -1, "androidx.compose.runtime.ComposerImpl.invokeMovableContentLambda.<anonymous> (Composer.kt:3386)");
                }
                throw null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public C4670Gb1(InterfaceC15247jG interfaceC15247jG, AbstractC7050Qb1 abstractC7050Qb1, C21850uE6 c21850uE6, Set set, OI0 oi0, OI0 oi02, InterfaceC25123zm1 interfaceC25123zm1) {
        this.b = interfaceC15247jG;
        this.c = abstractC7050Qb1;
        this.d = c21850uE6;
        this.e = set;
        this.f = oi0;
        this.g = oi02;
        this.h = interfaceC25123zm1;
        this.D = abstractC7050Qb1.e() || abstractC7050Qb1.c();
        this.E = new c();
        this.F = DJ6.c(null, 1, null);
        C21176tE6 c21176tE6V = c21850uE6.V();
        c21176tE6V.d();
        this.I = c21176tE6V;
        C21850uE6 c21850uE62 = new C21850uE6();
        if (abstractC7050Qb1.e()) {
            c21850uE62.B();
        }
        if (abstractC7050Qb1.c()) {
            c21850uE62.A();
        }
        this.J = c21850uE62;
        C24216yE6 c24216yE6W = c21850uE62.W();
        c24216yE6W.L(true);
        this.K = c24216yE6W;
        this.O = new C23239wb1(this, this.f);
        C21176tE6 c21176tE6V2 = this.J.V();
        try {
            C6669Om c6669OmA = c21176tE6V2.a(0);
            c21176tE6V2.d();
            this.P = c6669OmA;
            this.Q = new C21604tp2();
        } catch (Throwable th) {
            c21176tE6V2.d();
            throw th;
        }
    }

    private final void A0(boolean z, C18675p35 c18675p35) {
        DJ6.j(this.i, this.j);
        this.j = c18675p35;
        this.n.h(this.l);
        this.n.h(this.m);
        this.n.h(this.k);
        if (z) {
            this.k = 0;
        }
        this.l = 0;
        this.m = 0;
    }

    private final int A1(int i) {
        int i2;
        if (i >= 0) {
            int[] iArr = this.o;
            return (iArr == null || (i2 = iArr[i]) < 0) ? this.I.N(i) : i2;
        }
        C15552jm4 c15552jm4 = this.p;
        if (c15552jm4 == null || !c15552jm4.a(i)) {
            return 0;
        }
        return c15552jm4.c(i);
    }

    private final void B0(int i, boolean z) {
        C18675p35 c18675p35 = (C18675p35) DJ6.i(this.i);
        if (c18675p35 != null && !z) {
            c18675p35.l(c18675p35.a() + 1);
        }
        this.j = c18675p35;
        this.k = this.n.g() + i;
        this.m = this.n.g();
        this.l = this.n.g() + i;
    }

    private final void B1() {
        if (!this.s) {
            AbstractC5138Ib1.s("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.s = false;
    }

    private final void C0() {
        this.O.n();
        if (!DJ6.e(this.i)) {
            AbstractC5138Ib1.s("Start/end imbalance");
        }
        k0();
    }

    private final void C1() {
        if (!this.s) {
            return;
        }
        AbstractC5138Ib1.s("A call to createNode(), emitNode() or useNode() expected");
    }

    private final void D0() {
        C21850uE6 c21850uE6 = new C21850uE6();
        if (this.D) {
            c21850uE6.B();
        }
        if (this.c.c()) {
            c21850uE6.A();
        }
        this.J = c21850uE6;
        C24216yE6 c24216yE6W = c21850uE6.W();
        c24216yE6W.L(true);
        this.K = c24216yE6W;
    }

    private final Object I0(C21176tE6 c21176tE6) {
        return c21176tE6.L(c21176tE6.u());
    }

    private final int K0(C21176tE6 c21176tE6, int i) {
        Object objZ;
        if (c21176tE6.G(i)) {
            Object objD = c21176tE6.D(i);
            if (objD != null) {
                return objD instanceof Enum ? ((Enum) objD).ordinal() : objD.hashCode();
            }
            return 0;
        }
        int iC = c21176tE6.C(i);
        if (iC == 207 && (objZ = c21176tE6.z(i)) != null && !AbstractC13042fc3.d(objZ, InterfaceC22053ub1.a.a())) {
            iC = objZ.hashCode();
        }
        return iC;
    }

    private final void L0(List list) throws Throwable {
        C23239wb1 c23239wb1;
        OI0 oi0;
        C23239wb1 c23239wb12;
        OI0 oi02;
        C21176tE6 c21176tE6;
        C16734lm4 c16734lm4;
        int[] iArr;
        C23239wb1 c23239wb13;
        OI0 oi03;
        int i;
        int i2;
        C21176tE6 c21176tE62;
        List list2 = list;
        int i3 = 1;
        C23239wb1 c23239wb14 = this.O;
        OI0 oi04 = this.g;
        OI0 oi0O = c23239wb14.o();
        try {
            c23239wb14.S(oi04);
            this.O.Q();
            int size = list2.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size) {
                try {
                    XV4 xv4 = (XV4) list2.get(i5);
                    C20869sk4 c20869sk4 = (C20869sk4) xv4.a();
                    C20869sk4 c20869sk42 = (C20869sk4) xv4.b();
                    C6669Om c6669OmA = c20869sk4.a();
                    int iT = c20869sk4.g().t(c6669OmA);
                    C3478Ba3 c3478Ba3 = new C3478Ba3(i4, i3, null);
                    this.O.e(c3478Ba3, c6669OmA);
                    if (c20869sk42 == null) {
                        if (AbstractC13042fc3.d(c20869sk4.g(), this.J)) {
                            o0();
                        }
                        C21176tE6 c21176tE6V = c20869sk4.g().V();
                        try {
                            c21176tE6V.Q(iT);
                            this.O.z(iT);
                            OI0 oi05 = new OI0();
                            c21176tE62 = c21176tE6V;
                            try {
                                Y0(this, null, null, null, null, new d(oi05, c21176tE6V, c20869sk4), 15, null);
                                this.O.s(oi05, c3478Ba3);
                                C19938rB7 c19938rB7 = C19938rB7.a;
                                c21176tE62.d();
                                c23239wb12 = c23239wb14;
                                oi02 = oi0O;
                                i = size;
                                i2 = i5;
                            } catch (Throwable th) {
                                th = th;
                                c21176tE62.d();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            c21176tE62 = c21176tE6V;
                        }
                    } else {
                        AbstractC20278rk4 abstractC20278rk4L = this.c.l(c20869sk42);
                        C21850uE6 c21850uE6G = c20869sk42.g();
                        C6669Om c6669OmA2 = c20869sk42.a();
                        List listQ = AbstractC5138Ib1.q(c21850uE6G, c6669OmA2);
                        if (!listQ.isEmpty()) {
                            this.O.b(listQ, c3478Ba3);
                            if (AbstractC13042fc3.d(c20869sk4.g(), this.d)) {
                                int iT2 = this.d.t(c6669OmA);
                                v1(iT2, A1(iT2) + listQ.size());
                            }
                        }
                        this.O.c(abstractC20278rk4L, this.c, c20869sk42, c20869sk4);
                        C21176tE6 c21176tE6V2 = c21850uE6G.V();
                        try {
                            C21176tE6 c21176tE6J0 = J0();
                            int[] iArr2 = this.o;
                            C16734lm4 c16734lm42 = this.w;
                            this.o = null;
                            this.w = null;
                            try {
                                i1(c21176tE6V2);
                                int iT3 = c21850uE6G.t(c6669OmA2);
                                c21176tE6V2.Q(iT3);
                                this.O.z(iT3);
                                OI0 oi06 = new OI0();
                                C23239wb1 c23239wb15 = this.O;
                                OI0 oi0O2 = c23239wb15.o();
                                try {
                                    c23239wb15.S(oi06);
                                    i = size;
                                    C23239wb1 c23239wb16 = this.O;
                                    c23239wb12 = c23239wb14;
                                    try {
                                        boolean zP = c23239wb16.p();
                                        try {
                                            c23239wb16.T(false);
                                            InterfaceC25123zm1 interfaceC25123zm1B = c20869sk42.b();
                                            InterfaceC25123zm1 interfaceC25123zm1B2 = c20869sk4.b();
                                            Integer numValueOf = Integer.valueOf(c21176tE6V2.k());
                                            oi02 = oi0O;
                                            oi03 = oi0O2;
                                            i2 = i5;
                                            c21176tE6 = c21176tE6V2;
                                            iArr = iArr2;
                                            c23239wb13 = c23239wb15;
                                            try {
                                                X0(interfaceC25123zm1B, interfaceC25123zm1B2, numValueOf, c20869sk42.d(), new e(c20869sk4));
                                                try {
                                                    c23239wb16.T(zP);
                                                    try {
                                                        c23239wb13.S(oi03);
                                                        this.O.s(oi06, c3478Ba3);
                                                        C19938rB7 c19938rB72 = C19938rB7.a;
                                                        try {
                                                            i1(c21176tE6J0);
                                                            this.o = iArr;
                                                            this.w = c16734lm42;
                                                            try {
                                                                c21176tE6.d();
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                                c23239wb1 = c23239wb12;
                                                                oi0 = oi02;
                                                                c23239wb1.S(oi0);
                                                                throw th;
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            c21176tE6.d();
                                                            throw th;
                                                        }
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        c16734lm4 = c16734lm42;
                                                        i1(c21176tE6J0);
                                                        this.o = iArr;
                                                        this.w = c16734lm4;
                                                        throw th;
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    c16734lm4 = c16734lm42;
                                                    try {
                                                        c23239wb13.S(oi03);
                                                        throw th;
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        i1(c21176tE6J0);
                                                        this.o = iArr;
                                                        this.w = c16734lm4;
                                                        throw th;
                                                    }
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                c16734lm4 = c16734lm42;
                                                try {
                                                    c23239wb16.T(zP);
                                                    throw th;
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    c23239wb13.S(oi03);
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th10) {
                                            th = th10;
                                            c16734lm4 = c16734lm42;
                                            c23239wb13 = c23239wb15;
                                            c21176tE6 = c21176tE6V2;
                                            oi03 = oi0O2;
                                            iArr = iArr2;
                                        }
                                    } catch (Throwable th11) {
                                        th = th11;
                                        c16734lm4 = c16734lm42;
                                        c23239wb13 = c23239wb15;
                                        c21176tE6 = c21176tE6V2;
                                        oi03 = oi0O2;
                                        iArr = iArr2;
                                        c23239wb13.S(oi03);
                                        throw th;
                                    }
                                } catch (Throwable th12) {
                                    th = th12;
                                    c16734lm4 = c16734lm42;
                                    c23239wb13 = c23239wb15;
                                    c21176tE6 = c21176tE6V2;
                                }
                            } catch (Throwable th13) {
                                th = th13;
                                c16734lm4 = c16734lm42;
                                c21176tE6 = c21176tE6V2;
                                iArr = iArr2;
                            }
                        } catch (Throwable th14) {
                            th = th14;
                            c21176tE6 = c21176tE6V2;
                        }
                    }
                    this.O.V();
                    i5 = i2 + 1;
                    list2 = list;
                    i3 = 1;
                    size = i;
                    c23239wb14 = c23239wb12;
                    oi0O = oi02;
                    i4 = 0;
                } catch (Throwable th15) {
                    th = th15;
                    c23239wb12 = c23239wb14;
                    oi02 = oi0O;
                }
            }
            C23239wb1 c23239wb17 = c23239wb14;
            OI0 oi07 = oi0O;
            this.O.h();
            this.O.z(0);
            c23239wb17.S(oi07);
        } catch (Throwable th16) {
            th = th16;
            c23239wb1 = c23239wb14;
            oi0 = oi0O;
        }
    }

    private final int N0(int i) {
        return (-2) - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(AbstractC19669qk4 abstractC19669qk4, Y45 y45, Object obj, boolean z) {
        F(126665345, abstractC19669qk4);
        y1(obj);
        int iR = R();
        try {
            this.S = 126665345;
            boolean z2 = false;
            if (h()) {
                C24216yE6.s0(this.K, 0, 1, null);
            }
            if (!h() && !AbstractC13042fc3.d(this.I.l(), y45)) {
                z2 = true;
            }
            if (z2) {
                c1(y45);
            }
            m1(202, AbstractC5138Ib1.z(), AbstractC20032rM2.a.a(), y45);
            this.M = null;
            if (!h() || z) {
                boolean z3 = this.x;
                this.x = z2;
                BN7.b(this, AbstractC19242q11.c(316014703, true, new f(abstractC19669qk4, obj)));
                this.x = z3;
            } else {
                this.L = true;
                C24216yE6 c24216yE6 = this.K;
                this.c.j(new C20869sk4(abstractC19669qk4, obj, F0(), this.J, c24216yE6.D(c24216yE6.D0(c24216yE6.b0())), AbstractC10360bX0.m(), p0(), null));
            }
            w0();
            this.M = null;
            this.S = iR;
            T();
        } catch (Throwable th) {
            w0();
            this.M = null;
            this.S = iR;
            T();
            throw th;
        }
    }

    private final Object S0(C21176tE6 c21176tE6, int i) {
        return c21176tE6.L(i);
    }

    private final int T0(int i, int i2, int i3, int i4) {
        int iP = this.I.P(i2);
        while (iP != i3 && !this.I.J(iP)) {
            iP = this.I.P(iP);
        }
        if (this.I.J(iP)) {
            i4 = 0;
        }
        if (iP == i2) {
            return i4;
        }
        int iA1 = (A1(iP) - this.I.N(i2)) + i4;
        loop1: while (i4 < iA1 && iP != i) {
            iP++;
            while (iP < i) {
                int iE = this.I.E(iP) + iP;
                if (i >= iE) {
                    i4 += this.I.J(iP) ? 1 : A1(iP);
                    iP = iE;
                }
            }
            break loop1;
        }
        return i4;
    }

    private final int V0(int i) {
        int iP = this.I.P(i) + 1;
        int i2 = 0;
        while (iP < i) {
            if (!this.I.G(iP)) {
                i2++;
            }
            iP += this.I.E(iP);
        }
        return i2;
    }

    private final void X() {
        k0();
        DJ6.a(this.i);
        this.n.a();
        this.u.a();
        this.y.a();
        this.w = null;
        this.Q.a();
        this.S = 0;
        this.B = 0;
        this.s = false;
        this.R = false;
        this.z = false;
        this.G = false;
        this.r = false;
        this.A = -1;
        if (!this.I.i()) {
            this.I.d();
        }
        if (this.K.Z()) {
            return;
        }
        D0();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[Catch: all -> 0x0029, TRY_LEAVE, TryCatch #0 {all -> 0x0029, blocks: (B:3:0x0005, B:5:0x0013, B:7:0x0025, B:11:0x002f, B:10:0x002b, B:14:0x0036, B:16:0x003c, B:18:0x0042), top: B:23:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object X0(ir.nasim.InterfaceC25123zm1 r7, ir.nasim.InterfaceC25123zm1 r8, java.lang.Integer r9, java.util.List r10, ir.nasim.SA2 r11) {
        /*
            r6 = this;
            boolean r0 = r6.G
            int r1 = r6.k
            r2 = 1
            r6.G = r2     // Catch: java.lang.Throwable -> L29
            r2 = 0
            r6.k = r2     // Catch: java.lang.Throwable -> L29
            r3 = r10
            java.util.Collection r3 = (java.util.Collection) r3     // Catch: java.lang.Throwable -> L29
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L29
        L11:
            if (r2 >= r3) goto L32
            java.lang.Object r4 = r10.get(r2)     // Catch: java.lang.Throwable -> L29
            ir.nasim.XV4 r4 = (ir.nasim.XV4) r4     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r4.a()     // Catch: java.lang.Throwable -> L29
            ir.nasim.PJ5 r5 = (ir.nasim.PJ5) r5     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r4.b()     // Catch: java.lang.Throwable -> L29
            if (r4 == 0) goto L2b
            r6.s1(r5, r4)     // Catch: java.lang.Throwable -> L29
            goto L2f
        L29:
            r7 = move-exception
            goto L4b
        L2b:
            r4 = 0
            r6.s1(r5, r4)     // Catch: java.lang.Throwable -> L29
        L2f:
            int r2 = r2 + 1
            goto L11
        L32:
            if (r7 == 0) goto L42
            if (r9 == 0) goto L3b
            int r9 = r9.intValue()     // Catch: java.lang.Throwable -> L29
            goto L3c
        L3b:
            r9 = -1
        L3c:
            java.lang.Object r7 = r7.j(r8, r9, r11)     // Catch: java.lang.Throwable -> L29
            if (r7 != 0) goto L46
        L42:
            java.lang.Object r7 = r11.invoke()     // Catch: java.lang.Throwable -> L29
        L46:
            r6.G = r0
            r6.k = r1
            return r7
        L4b:
            r6.G = r0
            r6.k = r1
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4670Gb1.X0(ir.nasim.zm1, ir.nasim.zm1, java.lang.Integer, java.util.List, ir.nasim.SA2):java.lang.Object");
    }

    static /* synthetic */ Object Y0(C4670Gb1 c4670Gb1, InterfaceC25123zm1 interfaceC25123zm1, InterfaceC25123zm1 interfaceC25123zm12, Integer num, List list, SA2 sa2, int i, Object obj) {
        InterfaceC25123zm1 interfaceC25123zm13 = (i & 1) != 0 ? null : interfaceC25123zm1;
        InterfaceC25123zm1 interfaceC25123zm14 = (i & 2) != 0 ? null : interfaceC25123zm12;
        Integer num2 = (i & 4) != 0 ? null : num;
        if ((i & 8) != 0) {
            list = AbstractC10360bX0.m();
        }
        return c4670Gb1.X0(interfaceC25123zm13, interfaceC25123zm14, num2, list, sa2);
    }

    private final void Z0() {
        boolean z = this.G;
        this.G = true;
        int iU = this.I.u();
        int iE = this.I.E(iU) + iU;
        int i = this.k;
        int iR = R();
        int i2 = this.l;
        int i3 = this.m;
        C9826ad3 c9826ad3Y = AbstractC5138Ib1.y(this.t, this.I.k(), iE);
        int i4 = iU;
        boolean z2 = false;
        while (c9826ad3Y != null) {
            int iB = c9826ad3Y.b();
            AbstractC5138Ib1.N(this.t, iB);
            if (c9826ad3Y.d()) {
                this.I.Q(iB);
                int iK = this.I.k();
                d1(i4, iK, iU);
                this.k = T0(iB, iK, iU, i);
                this.m = V0(iK);
                this.S = n0(this.I.P(iK), iU, iR);
                this.M = null;
                boolean z3 = !this.z && c9826ad3Y.c().r();
                if (z3) {
                    this.z = true;
                }
                c9826ad3Y.c().g(this);
                if (z3) {
                    this.z = false;
                }
                this.M = null;
                this.I.R(iU);
                i4 = iK;
                z2 = true;
            } else {
                DJ6.j(this.F, c9826ad3Y.c());
                c9826ad3Y.c().B();
                DJ6.i(this.F);
            }
            c9826ad3Y = AbstractC5138Ib1.y(this.t, this.I.k(), iE);
        }
        if (z2) {
            d1(i4, iU, iU);
            this.I.T();
            int iA1 = A1(iU);
            this.k = i + iA1;
            this.l = i2 + iA1;
            this.m = i3;
        } else {
            l1();
        }
        this.S = iR;
        this.G = z;
    }

    private final void a1() {
        g1(this.I.k());
        this.O.O();
    }

    private final void b1(C6669Om c6669Om) {
        if (this.Q.e()) {
            this.O.t(c6669Om, this.J);
        } else {
            this.O.u(c6669Om, this.J, this.Q);
            this.Q = new C21604tp2();
        }
    }

    private final void c1(Y45 y45) {
        C16734lm4 c16734lm4 = this.w;
        if (c16734lm4 == null) {
            c16734lm4 = new C16734lm4(0, 1, null);
            this.w = c16734lm4;
        }
        c16734lm4.r(this.I.k(), y45);
    }

    private final void d1(int i, int i2, int i3) {
        C21176tE6 c21176tE6 = this.I;
        int iK = AbstractC5138Ib1.K(c21176tE6, i, i2, i3);
        while (i > 0 && i != iK) {
            if (c21176tE6.J(i)) {
                this.O.A();
            }
            i = c21176tE6.P(i);
        }
        u0(i2, iK);
    }

    private final C6669Om e1() {
        int i;
        int i2;
        if (h()) {
            if (!AbstractC5138Ib1.H(this.K)) {
                return null;
            }
            int iA0 = this.K.a0() - 1;
            int iD0 = this.K.D0(iA0);
            while (true) {
                int i3 = iD0;
                i2 = iA0;
                iA0 = i3;
                if (iA0 == this.K.b0() || iA0 < 0) {
                    break;
                }
                iD0 = this.K.D0(iA0);
            }
            return this.K.D(i2);
        }
        if (!AbstractC5138Ib1.G(this.I)) {
            return null;
        }
        int iK = this.I.k() - 1;
        int iP = this.I.P(iK);
        while (true) {
            int i4 = iP;
            i = iK;
            iK = i4;
            if (iK == this.I.u() || iK < 0) {
                break;
            }
            iP = this.I.P(iK);
        }
        return this.I.a(i);
    }

    private final void f1() {
        if (this.d.C()) {
            InterfaceC25123zm1 interfaceC25123zm1F0 = F0();
            AbstractC13042fc3.g(interfaceC25123zm1F0, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            ((C8225Vb1) interfaceC25123zm1F0).P();
            OI0 oi0 = new OI0();
            this.N = oi0;
            C21176tE6 c21176tE6V = this.d.V();
            try {
                this.I = c21176tE6V;
                C23239wb1 c23239wb1 = this.O;
                OI0 oi0O = c23239wb1.o();
                try {
                    c23239wb1.S(oi0);
                    g1(0);
                    this.O.M();
                    c23239wb1.S(oi0O);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    c23239wb1.S(oi0O);
                    throw th;
                }
            } finally {
                c21176tE6V.d();
            }
        }
    }

    private final void g1(int i) {
        boolean zJ = this.I.J(i);
        if (zJ) {
            this.O.i();
            this.O.w(this.I.L(i));
        }
        h1(this, i, i, zJ, 0);
        this.O.i();
        if (zJ) {
            this.O.A();
        }
    }

    private static final int h1(C4670Gb1 c4670Gb1, int i, int i2, boolean z, int i3) {
        C21176tE6 c21176tE6 = c4670Gb1.I;
        if (c21176tE6.F(i2)) {
            int iC = c21176tE6.C(i2);
            Object objD = c21176tE6.D(i2);
            if (iC != 206 || !AbstractC13042fc3.d(objD, AbstractC5138Ib1.E())) {
                if (c21176tE6.J(i2)) {
                    return 1;
                }
                return c21176tE6.N(i2);
            }
            Object objB = c21176tE6.B(i2, 0);
            a aVar = objB instanceof a ? (a) objB : null;
            if (aVar != null) {
                for (C4670Gb1 c4670Gb12 : aVar.a().t()) {
                    c4670Gb12.f1();
                    c4670Gb1.c.o(c4670Gb12.F0());
                }
            }
            return c21176tE6.N(i2);
        }
        if (!c21176tE6.e(i2)) {
            if (c21176tE6.J(i2)) {
                return 1;
            }
            return c21176tE6.N(i2);
        }
        int iE = c21176tE6.E(i2) + i2;
        int iH1 = 0;
        for (int iE2 = i2 + 1; iE2 < iE; iE2 += c21176tE6.E(iE2)) {
            boolean zJ = c21176tE6.J(iE2);
            if (zJ) {
                c4670Gb1.O.i();
                c4670Gb1.O.w(c21176tE6.L(iE2));
            }
            iH1 += h1(c4670Gb1, i, iE2, zJ || z, zJ ? 0 : i3 + iH1);
            if (zJ) {
                c4670Gb1.O.i();
                c4670Gb1.O.A();
            }
        }
        if (c21176tE6.J(i2)) {
            return 1;
        }
        return iH1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void i0() {
        /*
            r4 = this;
            boolean r0 = r4.h()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl"
            if (r0 == 0) goto L24
            ir.nasim.PJ5 r0 = new ir.nasim.PJ5
            ir.nasim.zm1 r2 = r4.F0()
            ir.nasim.AbstractC13042fc3.g(r2, r1)
            ir.nasim.Vb1 r2 = (ir.nasim.C8225Vb1) r2
            r0.<init>(r2)
            java.util.ArrayList r1 = r4.F
            ir.nasim.DJ6.j(r1, r0)
            r4.z1(r0)
            int r1 = r4.C
            r0.N(r1)
            goto L8c
        L24:
            java.util.List r0 = r4.t
            ir.nasim.tE6 r2 = r4.I
            int r2 = r2.u()
            ir.nasim.ad3 r0 = ir.nasim.AbstractC5138Ib1.l(r0, r2)
            ir.nasim.tE6 r2 = r4.I
            java.lang.Object r2 = r2.K()
            ir.nasim.ub1$a r3 = ir.nasim.InterfaceC22053ub1.a
            java.lang.Object r3 = r3.a()
            boolean r3 = ir.nasim.AbstractC13042fc3.d(r2, r3)
            if (r3 == 0) goto L54
            ir.nasim.PJ5 r2 = new ir.nasim.PJ5
            ir.nasim.zm1 r3 = r4.F0()
            ir.nasim.AbstractC13042fc3.g(r3, r1)
            ir.nasim.Vb1 r3 = (ir.nasim.C8225Vb1) r3
            r2.<init>(r3)
            r4.z1(r2)
            goto L5b
        L54:
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            ir.nasim.AbstractC13042fc3.g(r2, r1)
            ir.nasim.PJ5 r2 = (ir.nasim.PJ5) r2
        L5b:
            r1 = 1
            r3 = 0
            if (r0 != 0) goto L6d
            boolean r0 = r2.m()
            if (r0 == 0) goto L68
            r2.G(r3)
        L68:
            if (r0 == 0) goto L6b
            goto L6d
        L6b:
            r0 = r3
            goto L6e
        L6d:
            r0 = r1
        L6e:
            r2.I(r0)
            java.util.ArrayList r0 = r4.F
            ir.nasim.DJ6.j(r0, r2)
            int r0 = r4.C
            r2.N(r0)
            boolean r0 = r2.n()
            if (r0 == 0) goto L8c
            r2.H(r3)
            r2.K(r1)
            ir.nasim.wb1 r0 = r4.O
            r0.W(r2)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4670Gb1.i0():void");
    }

    private final void k0() {
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.S = 0;
        this.s = false;
        this.O.R();
        DJ6.a(this.F);
        l0();
    }

    private final void k1() {
        this.l += this.I.S();
    }

    private final void l0() {
        this.o = null;
        this.p = null;
    }

    private final void l1() {
        this.l = this.I.v();
        this.I.T();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m1(int r14, java.lang.Object r15, int r16, java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4670Gb1.m1(int, java.lang.Object, int, java.lang.Object):void");
    }

    private final int n0(int i, int i2, int i3) {
        int iRotateLeft;
        int i4 = 3;
        int iRotateLeft2 = 0;
        int i5 = 0;
        while (i >= 0) {
            if (i == i2) {
                iRotateLeft = Integer.rotateLeft(i3, i5);
            } else {
                int iK0 = K0(this.I, i);
                if (iK0 == 126665345) {
                    iRotateLeft = Integer.rotateLeft(iK0, i5);
                } else {
                    iRotateLeft2 = (iRotateLeft2 ^ Integer.rotateLeft(iK0, i4)) ^ Integer.rotateLeft(this.I.G(i) ? 0 : V0(i), i5);
                    i4 = (i4 + 6) % 32;
                    i5 = (i5 + 6) % 32;
                    i = this.I.P(i);
                }
            }
            return iRotateLeft ^ iRotateLeft2;
        }
        return iRotateLeft2;
    }

    private final void n1(int i) {
        m1(i, null, AbstractC20032rM2.a.a(), null);
    }

    private final void o0() {
        if (!this.K.Z()) {
            AbstractC5138Ib1.s("Check failed");
        }
        D0();
    }

    private final void o1(int i, Object obj) {
        m1(i, obj, AbstractC20032rM2.a.a(), null);
    }

    private final Y45 p0() {
        Y45 y45 = this.M;
        return y45 != null ? y45 : q0(this.I.u());
    }

    private final void p1(boolean z, Object obj) {
        if (z) {
            this.I.V();
            return;
        }
        if (obj != null && this.I.l() != obj) {
            this.O.Z(obj);
        }
        this.I.U();
    }

    private final Y45 q0(int i) {
        Y45 y45;
        if (h() && this.L) {
            int iB0 = this.K.b0();
            while (iB0 > 0) {
                if (this.K.h0(iB0) == 202 && AbstractC13042fc3.d(this.K.i0(iB0), AbstractC5138Ib1.z())) {
                    Object objF0 = this.K.f0(iB0);
                    AbstractC13042fc3.g(objF0, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    Y45 y452 = (Y45) objF0;
                    this.M = y452;
                    return y452;
                }
                iB0 = this.K.D0(iB0);
            }
        }
        if (this.I.x() > 0) {
            while (i > 0) {
                if (this.I.C(i) == 202 && AbstractC13042fc3.d(this.I.D(i), AbstractC5138Ib1.z())) {
                    C16734lm4 c16734lm4 = this.w;
                    if (c16734lm4 == null || (y45 = (Y45) c16734lm4.b(i)) == null) {
                        Object objZ = this.I.z(i);
                        AbstractC13042fc3.g(objZ, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        y45 = (Y45) objZ;
                    }
                    this.M = y45;
                    return y45;
                }
                i = this.I.P(i);
            }
        }
        Y45 y453 = this.v;
        this.M = y453;
        return y453;
    }

    private final void r1() {
        this.m = 0;
        this.I = this.d.V();
        n1(100);
        this.c.p();
        this.v = this.c.f();
        this.y.h(AbstractC5138Ib1.p(this.x));
        this.x = V(this.v);
        this.M = null;
        if (!this.q) {
            this.q = this.c.d();
        }
        if (!this.D) {
            this.D = this.c.e();
        }
        Set set = (Set) AbstractC12431ec1.b(this.v, S93.a());
        if (set != null) {
            set.add(C());
            this.c.m(set);
        }
        n1(this.c.g());
    }

    private final void t0(C7386Rm4 c7386Rm4, InterfaceC14603iB2 interfaceC14603iB2) {
        if (!(!this.G)) {
            AbstractC5138Ib1.s("Reentrant composition is not supported");
        }
        C17398mt7 c17398mt7 = C17398mt7.a;
        Object objA = c17398mt7.a("Compose:recompose");
        try {
            this.C = Long.hashCode(androidx.compose.runtime.snapshots.j.I().i());
            this.w = null;
            u1(c7386Rm4);
            this.k = 0;
            this.G = true;
            try {
                r1();
                Object objQ0 = Q0();
                if (objQ0 != interfaceC14603iB2 && interfaceC14603iB2 != null) {
                    z1(interfaceC14603iB2);
                }
                c cVar = this.E;
                C12544en4 c12544en4C = AbstractC10222bH6.c();
                try {
                    c12544en4C.d(cVar);
                    if (interfaceC14603iB2 != null) {
                        o1(200, AbstractC5138Ib1.A());
                        BN7.b(this, interfaceC14603iB2);
                        w0();
                    } else if ((!this.r && !this.x) || objQ0 == null || AbstractC13042fc3.d(objQ0, InterfaceC22053ub1.a.a())) {
                        j1();
                    } else {
                        o1(200, AbstractC5138Ib1.A());
                        BN7.b(this, (InterfaceC14603iB2) AbstractC19810qy7.g(objQ0, 2));
                        w0();
                    }
                    c12544en4C.w(c12544en4C.o() - 1);
                    y0();
                    this.G = false;
                    this.t.clear();
                    o0();
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    c17398mt7.b(objA);
                } catch (Throwable th) {
                    c12544en4C.w(c12544en4C.o() - 1);
                    throw th;
                }
            } catch (Throwable th2) {
                this.G = false;
                this.t.clear();
                X();
                o0();
                throw th2;
            }
        } catch (Throwable th3) {
            C17398mt7.a.b(objA);
            throw th3;
        }
    }

    private final void u0(int i, int i2) {
        if (i <= 0 || i == i2) {
            return;
        }
        u0(this.I.P(i), i2);
        if (this.I.J(i)) {
            this.O.w(S0(this.I, i));
        }
    }

    private final void v0(boolean z) {
        int iHashCode;
        int iW;
        Set set;
        List list;
        int iHashCode2;
        int iE = this.n.e() - 1;
        if (h()) {
            int iB0 = this.K.b0();
            int iH0 = this.K.h0(iB0);
            Object objI0 = this.K.i0(iB0);
            Object objF0 = this.K.f0(iB0);
            if (objI0 != null) {
                iHashCode2 = Integer.hashCode(objI0 instanceof Enum ? ((Enum) objI0).ordinal() : objI0.hashCode()) ^ Integer.rotateRight(R(), 3);
            } else if (objF0 == null || iH0 != 207 || AbstractC13042fc3.d(objF0, InterfaceC22053ub1.a.a())) {
                iHashCode2 = Integer.rotateRight(iE ^ R(), 3) ^ Integer.hashCode(iH0);
            } else {
                this.S = Integer.rotateRight(Integer.rotateRight(iE ^ R(), 3) ^ Integer.hashCode(objF0.hashCode()), 3);
            }
            this.S = Integer.rotateRight(iHashCode2, 3);
        } else {
            int iU = this.I.u();
            int iC = this.I.C(iU);
            Object objD = this.I.D(iU);
            Object objZ = this.I.z(iU);
            if (objD != null) {
                iHashCode = Integer.hashCode(objD instanceof Enum ? ((Enum) objD).ordinal() : objD.hashCode()) ^ Integer.rotateRight(R(), 3);
            } else if (objZ == null || iC != 207 || AbstractC13042fc3.d(objZ, InterfaceC22053ub1.a.a())) {
                iHashCode = Integer.rotateRight(iE ^ R(), 3) ^ Integer.hashCode(iC);
            } else {
                this.S = Integer.rotateRight(Integer.rotateRight(iE ^ R(), 3) ^ Integer.hashCode(objZ.hashCode()), 3);
            }
            this.S = Integer.rotateRight(iHashCode, 3);
        }
        int i = this.l;
        C18675p35 c18675p35 = this.j;
        if (c18675p35 != null && c18675p35.b().size() > 0) {
            List listB = c18675p35.b();
            List listF = c18675p35.f();
            Set setE = AbstractC13424gC3.e(listF);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = listF.size();
            int size2 = listB.size();
            int i2 = 0;
            int i3 = 0;
            int iO = 0;
            while (i2 < size2) {
                C23961xo3 c23961xo3 = (C23961xo3) listB.get(i2);
                if (setE.contains(c23961xo3)) {
                    set = setE;
                    if (!linkedHashSet.contains(c23961xo3)) {
                        if (i3 < size) {
                            C23961xo3 c23961xo32 = (C23961xo3) listF.get(i3);
                            if (c23961xo32 != c23961xo3) {
                                int iG = c18675p35.g(c23961xo32);
                                linkedHashSet.add(c23961xo32);
                                if (iG != iO) {
                                    int iO2 = c18675p35.o(c23961xo32);
                                    list = listF;
                                    this.O.x(c18675p35.e() + iG, iO + c18675p35.e(), iO2);
                                    c18675p35.j(iG, iO, iO2);
                                } else {
                                    list = listF;
                                }
                            } else {
                                list = listF;
                                i2++;
                            }
                            i3++;
                            iO += c18675p35.o(c23961xo32);
                            setE = set;
                            listF = list;
                        }
                    }
                    setE = set;
                } else {
                    this.O.P(c18675p35.g(c23961xo3) + c18675p35.e(), c23961xo3.c());
                    c18675p35.n(c23961xo3.b(), 0);
                    this.O.y(c23961xo3.b());
                    this.I.Q(c23961xo3.b());
                    a1();
                    this.I.S();
                    set = setE;
                    AbstractC5138Ib1.O(this.t, c23961xo3.b(), c23961xo3.b() + this.I.E(c23961xo3.b()));
                }
                i2++;
                setE = set;
            }
            this.O.i();
            if (listB.size() > 0) {
                this.O.y(this.I.m());
                this.I.T();
            }
        }
        boolean zH = h();
        if (!zH && (iW = this.I.w()) > 0) {
            this.O.X(iW);
        }
        int i4 = this.k;
        while (!this.I.H()) {
            int iK = this.I.k();
            a1();
            this.O.P(i4, this.I.S());
            AbstractC5138Ib1.O(this.t, iK, this.I.k());
        }
        if (zH) {
            if (z) {
                this.Q.c();
                i = 1;
            }
            this.I.f();
            int iB02 = this.K.b0();
            this.K.T();
            if (!this.I.t()) {
                int iN0 = N0(iB02);
                this.K.U();
                this.K.L(true);
                b1(this.P);
                this.R = false;
                if (!this.d.isEmpty()) {
                    v1(iN0, 0);
                    w1(iN0, i);
                }
            }
        } else {
            if (z) {
                this.O.A();
            }
            this.O.g();
            int iU2 = this.I.u();
            if (i != A1(iU2)) {
                w1(iU2, i);
            }
            if (z) {
                i = 1;
            }
            this.I.g();
            this.O.i();
        }
        B0(i, zH);
    }

    private final void v1(int i, int i2) {
        if (A1(i) != i2) {
            if (i < 0) {
                C15552jm4 c15552jm4 = this.p;
                if (c15552jm4 == null) {
                    c15552jm4 = new C15552jm4(0, 1, null);
                    this.p = c15552jm4;
                }
                c15552jm4.q(i, i2);
                return;
            }
            int[] iArr = this.o;
            if (iArr == null) {
                iArr = new int[this.I.x()];
                AbstractC9648aK.w(iArr, -1, 0, 0, 6, null);
                this.o = iArr;
            }
            iArr[i] = i2;
        }
    }

    private final void w0() {
        v0(false);
    }

    private final void w1(int i, int i2) {
        int iA1 = A1(i);
        if (iA1 != i2) {
            int i3 = i2 - iA1;
            int iD = DJ6.d(this.i) - 1;
            while (i != -1) {
                int iA12 = A1(i) + i3;
                v1(i, iA12);
                int i4 = iD;
                while (true) {
                    if (-1 < i4) {
                        C18675p35 c18675p35 = (C18675p35) DJ6.h(this.i, i4);
                        if (c18675p35 != null && c18675p35.n(i, iA12)) {
                            iD = i4 - 1;
                            break;
                        }
                        i4--;
                    } else {
                        break;
                    }
                }
                if (i < 0) {
                    i = this.I.u();
                } else if (this.I.J(i)) {
                    return;
                } else {
                    i = this.I.P(i);
                }
            }
        }
    }

    private final Y45 x1(Y45 y45, Y45 y452) {
        Y45.a aVarM = y45.m();
        aVarM.putAll(y452);
        Y45 y45F = aVarM.f();
        o1(SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER, AbstractC5138Ib1.D());
        y1(y45F);
        y1(y452);
        w0();
        return y45F;
    }

    private final void y0() {
        w0();
        this.c.b();
        w0();
        this.O.k();
        C0();
        this.I.d();
        this.r = false;
        this.x = AbstractC5138Ib1.o(this.y.g());
    }

    private final void y1(Object obj) {
        Q0();
        z1(obj);
    }

    private final void z0() {
        if (this.K.Z()) {
            C24216yE6 c24216yE6W = this.J.W();
            this.K = c24216yE6W;
            c24216yE6W.U0();
            this.L = false;
            this.M = null;
        }
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void A(int i) {
        m1(i, null, AbstractC20032rM2.a.a(), null);
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public Object B() {
        return R0();
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public InterfaceC7518Sb1 C() {
        InterfaceC7518Sb1 interfaceC7518Sb1 = this.T;
        if (interfaceC7518Sb1 != null) {
            return interfaceC7518Sb1;
        }
        C7755Tb1 c7755Tb1 = new C7755Tb1(F0());
        this.T = c7755Tb1;
        return c7755Tb1;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public boolean D(Object obj) {
        if (Q0() == obj) {
            return false;
        }
        z1(obj);
        return true;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void E() {
        m1(-127, null, AbstractC20032rM2.a.a(), null);
    }

    public final boolean E0() {
        return this.B > 0;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void F(int i, Object obj) {
        m1(i, obj, AbstractC20032rM2.a.a(), null);
    }

    public InterfaceC25123zm1 F0() {
        return this.h;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void G() {
        m1(125, null, AbstractC20032rM2.a.c(), null);
        this.s = true;
    }

    public final PJ5 G0() {
        ArrayList arrayList = this.F;
        if (this.B == 0 && DJ6.f(arrayList)) {
            return (PJ5) DJ6.g(arrayList);
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public Object H(AbstractC8979Yb1 abstractC8979Yb1) {
        return AbstractC12431ec1.b(p0(), abstractC8979Yb1);
    }

    public final OI0 H0() {
        return this.N;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void I(C7252Qx5 c7252Qx5) {
        InterfaceC18300oQ7 interfaceC18300oQ7;
        Y45 y45P0 = p0();
        o1(201, AbstractC5138Ib1.C());
        Object objB = B();
        if (AbstractC13042fc3.d(objB, InterfaceC22053ub1.a.a())) {
            interfaceC18300oQ7 = null;
        } else {
            AbstractC13042fc3.g(objB, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            interfaceC18300oQ7 = (InterfaceC18300oQ7) objB;
        }
        AbstractC8979Yb1 abstractC8979Yb1B = c7252Qx5.b();
        AbstractC13042fc3.g(abstractC8979Yb1B, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        AbstractC13042fc3.g(c7252Qx5, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        InterfaceC18300oQ7 interfaceC18300oQ7B = abstractC8979Yb1B.b(c7252Qx5, interfaceC18300oQ7);
        boolean z = true;
        boolean z2 = !AbstractC13042fc3.d(interfaceC18300oQ7B, interfaceC18300oQ7);
        if (z2) {
            s(interfaceC18300oQ7B);
        }
        boolean z3 = false;
        if (h()) {
            if (c7252Qx5.a() || !AbstractC12431ec1.a(y45P0, abstractC8979Yb1B)) {
                y45P0 = y45P0.w(abstractC8979Yb1B, interfaceC18300oQ7B);
            }
            this.L = true;
        } else {
            C21176tE6 c21176tE6 = this.I;
            Object objZ = c21176tE6.z(c21176tE6.k());
            AbstractC13042fc3.g(objZ, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            Y45 y45 = (Y45) objZ;
            if ((!k() || z2) && (c7252Qx5.a() || !AbstractC12431ec1.a(y45P0, abstractC8979Yb1B))) {
                y45P0 = y45P0.w(abstractC8979Yb1B, interfaceC18300oQ7B);
            } else if ((!z2 && !this.x) || !this.x) {
                y45P0 = y45;
            }
            if (!this.z && y45 == y45P0) {
                z = false;
            }
            z3 = z;
        }
        if (z3 && !h()) {
            c1(y45P0);
        }
        this.y.h(AbstractC5138Ib1.p(this.x));
        this.x = z3;
        this.M = y45P0;
        m1(202, AbstractC5138Ib1.z(), AbstractC20032rM2.a.a(), y45P0);
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void J() {
        this.z = false;
    }

    public final C21176tE6 J0() {
        return this.I;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void K(int i, Object obj) {
        if (!h() && this.I.n() == i && !AbstractC13042fc3.d(this.I.l(), obj) && this.A < 0) {
            this.A = this.I.k();
            this.z = true;
        }
        m1(i, null, AbstractC20032rM2.a.a(), obj);
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void L() {
        if (!(this.l == 0)) {
            AbstractC5138Ib1.s("No nodes can be emitted before calling skipAndEndGroup");
        }
        if (h()) {
            return;
        }
        PJ5 pj5G0 = G0();
        if (pj5G0 != null) {
            pj5G0.C();
        }
        if (this.t.isEmpty()) {
            l1();
        } else {
            Z0();
        }
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void M(C7252Qx5[] c7252Qx5Arr) {
        Y45 y45X1;
        Y45 y45P0 = p0();
        o1(201, AbstractC5138Ib1.C());
        boolean z = true;
        boolean z2 = false;
        if (h()) {
            y45X1 = x1(y45P0, AbstractC12431ec1.d(c7252Qx5Arr, y45P0, null, 4, null));
            this.L = true;
        } else {
            Object objA = this.I.A(0);
            AbstractC13042fc3.g(objA, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            Y45 y45 = (Y45) objA;
            Object objA2 = this.I.A(1);
            AbstractC13042fc3.g(objA2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            Y45 y452 = (Y45) objA2;
            Y45 y45C = AbstractC12431ec1.c(c7252Qx5Arr, y45P0, y452);
            if (k() && !this.z && AbstractC13042fc3.d(y452, y45C)) {
                k1();
                y45X1 = y45;
            } else {
                y45X1 = x1(y45P0, y45C);
                if (!this.z && AbstractC13042fc3.d(y45X1, y45)) {
                    z = false;
                }
                z2 = z;
            }
        }
        if (z2 && !h()) {
            c1(y45X1);
        }
        this.y.h(AbstractC5138Ib1.p(this.x));
        this.x = z2;
        this.M = y45X1;
        m1(202, AbstractC5138Ib1.z(), AbstractC20032rM2.a.a(), y45X1);
    }

    public void M0(List list) {
        try {
            L0(list);
            k0();
        } catch (Throwable th) {
            X();
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void N() {
        w0();
        w0();
        this.x = AbstractC5138Ib1.o(this.y.g());
        this.M = null;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public boolean O() {
        if (!k() || this.x) {
            return true;
        }
        PJ5 pj5G0 = G0();
        return pj5G0 != null && pj5G0.l();
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void P(SA2 sa2) {
        this.O.U(sa2);
    }

    public final boolean P0() {
        return this.G;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void Q() {
        w0();
    }

    public final Object Q0() {
        if (h()) {
            C1();
            return InterfaceC22053ub1.a.a();
        }
        Object objK = this.I.K();
        return (!this.z || (objK instanceof InterfaceC24680z16)) ? objK : InterfaceC22053ub1.a.a();
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public int R() {
        return this.S;
    }

    public final Object R0() {
        if (h()) {
            C1();
            return InterfaceC22053ub1.a.a();
        }
        Object objK = this.I.K();
        return (!this.z || (objK instanceof InterfaceC24680z16)) ? objK instanceof ZM5 ? ((ZM5) objK).b() : objK : InterfaceC22053ub1.a.a();
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public AbstractC7050Qb1 S() {
        o1(SetRpcStruct$ComposedRpc.CHECK_NICK_NAME_FIELD_NUMBER, AbstractC5138Ib1.E());
        if (h()) {
            C24216yE6.s0(this.K, 0, 1, null);
        }
        Object objQ0 = Q0();
        a aVar = objQ0 instanceof a ? (a) objQ0 : null;
        if (aVar == null) {
            int iR = R();
            boolean z = this.q;
            boolean z2 = this.D;
            InterfaceC25123zm1 interfaceC25123zm1F0 = F0();
            C8225Vb1 c8225Vb1 = interfaceC25123zm1F0 instanceof C8225Vb1 ? (C8225Vb1) interfaceC25123zm1F0 : null;
            aVar = new a(new b(iR, z, z2, c8225Vb1 != null ? c8225Vb1.G() : null));
            z1(aVar);
        }
        aVar.a().w(p0());
        w0();
        return aVar.a();
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void T() {
        w0();
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void U() {
        w0();
    }

    public final void U0(SA2 sa2) {
        if (!(!this.G)) {
            AbstractC5138Ib1.s("Preparing a composition while composing is not supported");
        }
        this.G = true;
        try {
            sa2.invoke();
        } finally {
            this.G = false;
        }
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public boolean V(Object obj) {
        if (AbstractC13042fc3.d(Q0(), obj)) {
            return false;
        }
        z1(obj);
        return true;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void W(int i) {
        if (this.j != null) {
            m1(i, null, AbstractC20032rM2.a.a(), null);
            return;
        }
        C1();
        this.S = this.m ^ Integer.rotateLeft(Integer.rotateLeft(R(), 3) ^ i, 3);
        this.m++;
        C21176tE6 c21176tE6 = this.I;
        if (h()) {
            c21176tE6.c();
            this.K.f1(i, InterfaceC22053ub1.a.a());
            A0(false, null);
            return;
        }
        if (c21176tE6.n() == i && !c21176tE6.s()) {
            c21176tE6.U();
            A0(false, null);
            return;
        }
        if (!c21176tE6.H()) {
            int i2 = this.k;
            int iK = c21176tE6.k();
            a1();
            this.O.P(i2, c21176tE6.S());
            AbstractC5138Ib1.O(this.t, iK, c21176tE6.k());
        }
        c21176tE6.c();
        this.R = true;
        this.M = null;
        z0();
        C24216yE6 c24216yE6 = this.K;
        c24216yE6.H();
        int iA0 = c24216yE6.a0();
        c24216yE6.f1(i, InterfaceC22053ub1.a.a());
        this.P = c24216yE6.D(iA0);
        A0(false, null);
    }

    public final boolean W0(C7386Rm4 c7386Rm4, WA6 wa6) {
        if (!this.f.c()) {
            AbstractC5138Ib1.s("Expected applyChanges() to have been called");
        }
        if (AbstractC19601qd6.f(c7386Rm4) <= 0 && !(!this.t.isEmpty()) && !this.r) {
            return false;
        }
        t0(c7386Rm4, null);
        return this.f.d();
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public boolean a(boolean z) {
        Object objQ0 = Q0();
        if ((objQ0 instanceof Boolean) && z == ((Boolean) objQ0).booleanValue()) {
            return false;
        }
        z1(Boolean.valueOf(z));
        return true;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void b(OJ5 oj5) {
        PJ5 pj5 = oj5 instanceof PJ5 ? (PJ5) oj5 : null;
        if (pj5 == null) {
            return;
        }
        pj5.M(true);
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public boolean c(float f2) {
        Object objQ0 = Q0();
        if ((objQ0 instanceof Float) && f2 == ((Number) objQ0).floatValue()) {
            return false;
        }
        z1(Float.valueOf(f2));
        return true;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void d() {
        this.z = this.A >= 0;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public boolean e(int i) {
        Object objQ0 = Q0();
        if ((objQ0 instanceof Integer) && i == ((Number) objQ0).intValue()) {
            return false;
        }
        z1(Integer.valueOf(i));
        return true;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public boolean f(long j) {
        Object objQ0 = Q0();
        if ((objQ0 instanceof Long) && j == ((Number) objQ0).longValue()) {
            return false;
        }
        z1(Long.valueOf(j));
        return true;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void g(SA2 sa2) {
        B1();
        if (!h()) {
            AbstractC5138Ib1.s("createNode() can only be called when inserting");
        }
        int iC = this.n.c();
        C24216yE6 c24216yE6 = this.K;
        C6669Om c6669OmD = c24216yE6.D(c24216yE6.b0());
        this.l++;
        this.Q.b(sa2, iC, c6669OmD);
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public boolean h() {
        return this.R;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void i(boolean z) {
        if (!(this.l == 0)) {
            AbstractC5138Ib1.s("No nodes can be emitted before calling dactivateToEndGroup");
        }
        if (h()) {
            return;
        }
        if (!z) {
            l1();
            return;
        }
        int iK = this.I.k();
        int iJ = this.I.j();
        this.O.d();
        AbstractC5138Ib1.O(this.t, iK, iJ);
        this.I.T();
    }

    public final void i1(C21176tE6 c21176tE6) {
        this.I = c21176tE6;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public InterfaceC22053ub1 j(int i) {
        W(i);
        i0();
        return this;
    }

    public final void j0() {
        this.w = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j1() {
        /*
            r9 = this;
            java.util.List r0 = r9.t
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Ld
            r9.k1()
            goto Le1
        Ld:
            ir.nasim.tE6 r0 = r9.I
            int r1 = r0.n()
            java.lang.Object r2 = r0.o()
            java.lang.Object r3 = r0.l()
            int r4 = r9.m
            r5 = 207(0xcf, float:2.9E-43)
            r6 = 3
            if (r2 != 0) goto L58
            if (r3 == 0) goto L47
            if (r1 != r5) goto L47
            ir.nasim.ub1$a r7 = ir.nasim.InterfaceC22053ub1.a
            java.lang.Object r7 = r7.a()
            boolean r7 = ir.nasim.AbstractC13042fc3.d(r3, r7)
            if (r7 != 0) goto L47
            int r7 = r3.hashCode()
            int r8 = r9.R()
            int r8 = java.lang.Integer.rotateLeft(r8, r6)
            r7 = r7 ^ r8
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
            r7 = r7 ^ r4
            r9.S = r7
            goto L76
        L47:
            int r7 = r9.R()
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
            r7 = r7 ^ r1
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
            r7 = r7 ^ r4
        L55:
            r9.S = r7
            goto L76
        L58:
            boolean r7 = r2 instanceof java.lang.Enum
            if (r7 == 0) goto L71
            r7 = r2
            java.lang.Enum r7 = (java.lang.Enum) r7
            int r7 = r7.ordinal()
        L63:
            int r8 = r9.R()
            int r8 = java.lang.Integer.rotateLeft(r8, r6)
            r7 = r7 ^ r8
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
            goto L55
        L71:
            int r7 = r2.hashCode()
            goto L63
        L76:
            boolean r7 = r0.I()
            r8 = 0
            r9.p1(r7, r8)
            r9.Z0()
            r0.g()
            if (r2 != 0) goto Lc4
            if (r3 == 0) goto Laf
            if (r1 != r5) goto Laf
            ir.nasim.ub1$a r0 = ir.nasim.InterfaceC22053ub1.a
            java.lang.Object r0 = r0.a()
            boolean r0 = ir.nasim.AbstractC13042fc3.d(r3, r0)
            if (r0 != 0) goto Laf
            int r0 = r3.hashCode()
            int r1 = r9.R()
            r1 = r1 ^ r4
            int r1 = java.lang.Integer.rotateRight(r1, r6)
            int r0 = java.lang.Integer.hashCode(r0)
            r0 = r0 ^ r1
            int r0 = java.lang.Integer.rotateRight(r0, r6)
            r9.S = r0
            goto Le1
        Laf:
            int r0 = r9.R()
            r0 = r0 ^ r4
            int r0 = java.lang.Integer.rotateRight(r0, r6)
            int r1 = java.lang.Integer.hashCode(r1)
            r0 = r0 ^ r1
        Lbd:
            int r0 = java.lang.Integer.rotateRight(r0, r6)
            r9.S = r0
            goto Le1
        Lc4:
            boolean r0 = r2 instanceof java.lang.Enum
            if (r0 == 0) goto Ldc
            java.lang.Enum r2 = (java.lang.Enum) r2
            int r0 = r2.ordinal()
        Lce:
            int r1 = r9.R()
            int r1 = java.lang.Integer.rotateRight(r1, r6)
            int r0 = java.lang.Integer.hashCode(r0)
            r0 = r0 ^ r1
            goto Lbd
        Ldc:
            int r0 = r2.hashCode()
            goto Lce
        Le1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4670Gb1.j1():void");
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public boolean k() {
        PJ5 pj5G0;
        return (h() || this.z || this.x || (pj5G0 = G0()) == null || pj5G0.o() || this.r) ? false : true;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public InterfaceC15247jG l() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public InterfaceC20208rd6 m() {
        C6669Om c6669OmA;
        PJ5 pj5 = null;
        PJ5 pj52 = DJ6.f(this.F) ? (PJ5) DJ6.i(this.F) : null;
        if (pj52 != null) {
            pj52.I(false);
            UA2 ua2H = pj52.h(this.C);
            if (ua2H != null) {
                this.O.f(ua2H, F0());
            }
            if (pj52.q()) {
                pj52.K(false);
                this.O.j(pj52);
            }
        }
        if (pj52 != null && !pj52.s() && (pj52.t() || this.q)) {
            if (pj52.i() == null) {
                if (h()) {
                    C24216yE6 c24216yE6 = this.K;
                    c6669OmA = c24216yE6.D(c24216yE6.b0());
                } else {
                    C21176tE6 c21176tE6 = this.I;
                    c6669OmA = c21176tE6.a(c21176tE6.u());
                }
                pj52.D(c6669OmA);
            }
            pj52.F(false);
            pj5 = pj52;
        }
        v0(false);
        return pj5;
    }

    public final void m0(C7386Rm4 c7386Rm4, InterfaceC14603iB2 interfaceC14603iB2, WA6 wa6) {
        if (!this.f.c()) {
            AbstractC5138Ib1.s("Expected applyChanges() to have been called");
        }
        t0(c7386Rm4, interfaceC14603iB2);
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void n() {
        m1(125, null, AbstractC20032rM2.a.b(), null);
        this.s = true;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public boolean o(boolean z, int i) {
        return ((i & 1) == 0 && (h() || this.z)) || z || !k();
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public InterfaceC11938do1 p() {
        return this.c.h();
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public InterfaceC11819dc1 q() {
        return p0();
    }

    public final void q1() {
        this.A = 100;
        this.z = true;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void r() {
        B1();
        if (!(!h())) {
            AbstractC5138Ib1.s("useNode() called while inserting");
        }
        Object objI0 = I0(this.I);
        this.O.w(objI0);
        if (this.z && (objI0 instanceof InterfaceC11014cb1)) {
            this.O.c0(objI0);
        }
    }

    public final void r0() {
        DJ6.a(this.F);
        this.t.clear();
        this.f.a();
        this.w = null;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void s(Object obj) {
        t1(obj);
    }

    public final void s0() {
        C17398mt7 c17398mt7 = C17398mt7.a;
        Object objA = c17398mt7.a("Compose:Composer.dispose");
        try {
            this.c.q(this);
            r0();
            l().clear();
            this.H = true;
            C19938rB7 c19938rB7 = C19938rB7.a;
            c17398mt7.b(objA);
        } catch (Throwable th) {
            C17398mt7.a.b(objA);
            throw th;
        }
    }

    public final boolean s1(PJ5 pj5, Object obj) {
        C6669Om c6669OmI = pj5.i();
        if (c6669OmI == null) {
            return false;
        }
        int iD = c6669OmI.d(this.I.y());
        if (!this.G || iD < this.I.k()) {
            return false;
        }
        AbstractC5138Ib1.F(this.t, iD, pj5, obj);
        return true;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void t() {
        w0();
        w0();
        this.x = AbstractC5138Ib1.o(this.y.g());
        this.M = null;
    }

    public final void t1(Object obj) {
        if (obj instanceof YM5) {
            ZM5 zm5 = new ZM5((YM5) obj, e1());
            if (h()) {
                this.O.N(zm5);
            }
            this.e.add(obj);
            obj = zm5;
        }
        z1(obj);
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void u() {
        v0(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u1(ir.nasim.C7386Rm4 r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.Object[] r2 = r1.b
            java.lang.Object[] r3 = r1.c
            long[] r1 = r1.a
            int r4 = r1.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L67
            r6 = 0
        L10:
            r7 = r1[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L62
            int r9 = r6 - r4
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = 0
        L2a:
            if (r11 >= r9) goto L60
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.3E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L5c
            int r12 = r6 << 3
            int r12 = r12 + r11
            r13 = r2[r12]
            r12 = r3[r12]
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            ir.nasim.AbstractC13042fc3.g(r13, r14)
            ir.nasim.PJ5 r13 = (ir.nasim.PJ5) r13
            ir.nasim.Om r14 = r13.i()
            if (r14 == 0) goto L5c
            int r14 = r14.a()
            java.util.List r15 = r0.t
            ir.nasim.pd6 r5 = ir.nasim.C19010pd6.a
            if (r12 != r5) goto L54
            r12 = 0
        L54:
            ir.nasim.ad3 r5 = new ir.nasim.ad3
            r5.<init>(r13, r14, r12)
            r15.add(r5)
        L5c:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L2a
        L60:
            if (r9 != r10) goto L67
        L62:
            if (r6 == r4) goto L67
            int r6 = r6 + 1
            goto L10
        L67:
            java.util.List r1 = r0.t
            java.util.Comparator r2 = ir.nasim.AbstractC5138Ib1.g()
            ir.nasim.ZW0.B(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4670Gb1.u1(ir.nasim.Rm4):void");
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void v(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        if (h()) {
            this.Q.f(obj, interfaceC14603iB2);
        } else {
            this.O.a0(obj, interfaceC14603iB2);
        }
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void w() {
        w0();
        PJ5 pj5G0 = G0();
        if (pj5G0 == null || !pj5G0.t()) {
            return;
        }
        pj5G0.E(true);
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void x() {
        this.q = true;
        this.D = true;
        this.d.B();
        this.J.B();
        this.K.t1();
    }

    public final void x0() {
        if (!(!this.G && this.A == 100)) {
            AbstractC5214Ij5.a("Cannot disable reuse from root if it was caused by other groups");
        }
        this.A = -1;
        this.z = false;
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public OJ5 y() {
        return G0();
    }

    @Override // ir.nasim.InterfaceC22053ub1
    public void z() {
        if (this.z && this.I.u() == this.A) {
            this.A = -1;
            this.z = false;
        }
        v0(false);
    }

    public final void z1(Object obj) {
        if (h()) {
            this.K.k1(obj);
            return;
        }
        if (!this.I.r()) {
            C23239wb1 c23239wb1 = this.O;
            C21176tE6 c21176tE6 = this.I;
            c23239wb1.a(c21176tE6.a(c21176tE6.u()), obj);
            return;
        }
        int iQ = this.I.q() - 1;
        if (!this.O.q()) {
            this.O.b0(obj, iQ);
            return;
        }
        C23239wb1 c23239wb12 = this.O;
        C21176tE6 c21176tE62 = this.I;
        c23239wb12.Y(obj, c21176tE62.a(c21176tE62.u()), iQ);
    }

    /* renamed from: ir.nasim.Gb1$a */
    public static final class a implements InterfaceC24680z16 {
        private final b a;

        public a(b bVar) {
            this.a = bVar;
        }

        public final b a() {
            return this.a;
        }

        @Override // ir.nasim.YM5
        public void d() {
            this.a.s();
        }

        @Override // ir.nasim.YM5
        public void e() {
            this.a.s();
        }

        @Override // ir.nasim.YM5
        public void b() {
        }
    }
}
