package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.PeersStruct$OutPeer;
import com.google.firebase.messaging.FirebaseMessaging;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.runtime.AccountInfo;
import ir.nasim.database.entity.ContactEntity;

/* renamed from: ir.nasim.Yh4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C9057Yh4 implements InterfaceC7803Tg4 {
    private volatile C23572x88 A;
    private volatile UP4 B;
    private volatile A08 C;
    private volatile VE4 D;
    private volatile QQ3 E;
    private volatile C11941do4 F;
    private volatile BankingModule G;
    private DB3 H;
    private final AbstractC18427oe4 a;
    private final C8468Wc1 b;
    private InterfaceC3570Bk5 d;
    private C6559Oa2 e;
    private MO6 f;
    private C6287Mz g;
    private final C15346jR h;
    private volatile UG7 i;
    private volatile OK7 j;
    private volatile C10299bQ2 k;
    private volatile PE l;
    private volatile E84 m;
    private volatile C17453mz5 n;
    private volatile C14375ho5 o;
    private volatile C4892Gz7 p;
    private volatile C14970in2 q;
    private volatile C8054Ui1 r;
    private volatile SettingsModule s;
    private volatile C6508Nu5 t;
    private volatile C4471Fg6 u;
    private volatile C14934ij6 v;
    private volatile BV1 w;
    private volatile C18831pK1 x;
    private volatile C22686vf4 y;
    private volatile C11461d28 z;
    private boolean I = true;
    private InterfaceC3570Bk5 c = KN6.o();

    public C9057Yh4(AbstractC18427oe4 abstractC18427oe4, C8468Wc1 c8468Wc1) {
        this.a = abstractC18427oe4;
        this.b = c8468Wc1;
        r();
        this.h = new C15346jR(this);
        this.f = new MO6(this, KN6.g("blob", new C7812Th4()));
        this.e = new C6559Oa2();
        this.g = new C6287Mz(this, this.d);
        this.s = new SettingsModule(this, this.c);
        this.l = new PE(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        y();
        Y();
        Z();
        A().c0();
    }

    private boolean b0() {
        return C13923h3.a.o().size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C17557nA c0(C17637nI7 c17637nI7) {
        return new C17557nA(CA.PRIVATE, c17637nI7.n0(), c17637nI7.getAccessHash());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C17557nA d0(C14697iL2 c14697iL2) {
        return new C17557nA(CA.GROUP, c14697iL2.p0(), c14697iL2.getAccessHash());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(C11458d25 c11458d25, C7234Qv5 c7234Qv5) {
        if (c11458d25.s() == W25.a) {
            W().p0().a(c11458d25.getPeerId()).h0(new InterfaceC17569nB2() { // from class: ir.nasim.Wh4
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return C9057Yh4.c0((C17637nI7) obj);
                }
            }).i0(c7234Qv5);
        } else {
            if (c11458d25.s() == W25.b) {
                E().X1().a(c11458d25.getPeerId()).h0(new InterfaceC17569nB2() { // from class: ir.nasim.Xh4
                    @Override // ir.nasim.InterfaceC17569nB2
                    public final Object apply(Object obj) {
                        return C9057Yh4.d0((C14697iL2) obj);
                    }
                }).i0(c7234Qv5);
                return;
            }
            throw new RuntimeException("Unknown peer: " + c11458d25);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PeersStruct$OutPeer f0(C17637nI7 c17637nI7) {
        return (PeersStruct$OutPeer) PeersStruct$OutPeer.newBuilder().B(c17637nI7.n0()).A(c17637nI7.getAccessHash()).C(EnumC16311l35.PeerType_PRIVATE).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PeersStruct$OutPeer g0(C14697iL2 c14697iL2) {
        return (PeersStruct$OutPeer) PeersStruct$OutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).C(EnumC16311l35.PeerType_GROUP).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(C11458d25 c11458d25, C7234Qv5 c7234Qv5) {
        if (c11458d25.s() == W25.a) {
            W().p0().a(c11458d25.getPeerId()).h0(new InterfaceC17569nB2() { // from class: ir.nasim.Rh4
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return C9057Yh4.f0((C17637nI7) obj);
                }
            }).i0(c7234Qv5);
        } else {
            if (c11458d25.s() == W25.b) {
                E().X1().a(c11458d25.getPeerId()).h0(new InterfaceC17569nB2() { // from class: ir.nasim.Sh4
                    @Override // ir.nasim.InterfaceC17569nB2
                    public final Object apply(Object obj) {
                        return C9057Yh4.g0((C14697iL2) obj);
                    }
                }).i0(c7234Qv5);
                return;
            }
            throw new RuntimeException("Unknown peer: " + c11458d25);
        }
    }

    public static C22993wA k(C11458d25 c11458d25) {
        if (c11458d25.s() == W25.a) {
            return new C22993wA(CA.PRIVATE, c11458d25.getPeerId());
        }
        if (c11458d25.s() == W25.b) {
            return new C22993wA(CA.GROUP, c11458d25.getPeerId());
        }
        return null;
    }

    private void l0() {
        if (C8386Vt0.u8()) {
            ((HS1) I22.a(C5721Ko.b, HS1.class)).Q0().start();
        }
    }

    public C8054Ui1 A() {
        if (this.r == null) {
            synchronized (C8054Ui1.class) {
                try {
                    if (this.r == null) {
                        this.H = KN6.l(ContactEntity.TABLE_NAME, C3512Be1.f);
                        this.r = new C8054Ui1(this, this.H);
                        this.r.y0();
                    }
                } finally {
                }
            }
        }
        return this.r;
    }

    public C18831pK1 B() {
        if (this.x == null) {
            synchronized (C18831pK1.class) {
                try {
                    if (this.x == null) {
                        this.x = new C18831pK1(this);
                        this.x.b();
                    }
                } finally {
                }
            }
        }
        return this.x;
    }

    public BV1 C() {
        if (this.w == null) {
            synchronized (BV1.class) {
                try {
                    if (this.w == null) {
                        if (C13923h3.a.t()) {
                            this.w = new BV1(this);
                        } else {
                            C19406qI3.d("Modules", new Exception("Unappropriated Access to getDisplayListsModule"));
                        }
                    }
                } finally {
                }
            }
        }
        return this.w;
    }

    public C14970in2 D() {
        if (this.q == null) {
            synchronized (C14970in2.class) {
                try {
                    if (this.q == null) {
                        this.q = new C14970in2(this);
                        this.q.c0();
                    }
                } finally {
                }
            }
        }
        return this.q;
    }

    public C10299bQ2 E() {
        if (this.k == null) {
            synchronized (C10299bQ2.class) {
                try {
                    if (this.k == null) {
                        this.k = new C10299bQ2(this, KN6.i("groups", C14733iO2.d(w().p()), C14697iL2.E0));
                        this.k.z3();
                    }
                } finally {
                }
            }
        }
        return this.k;
    }

    public QQ3 F() {
        if (this.E == null) {
            synchronized (QQ3.class) {
                try {
                    if (this.E == null) {
                        this.E = new QQ3(this);
                    }
                } finally {
                }
            }
        }
        return this.E;
    }

    public E84 G() {
        if (this.m == null) {
            synchronized (E84.class) {
                try {
                    if (this.m == null) {
                        this.m = new E84(this);
                        this.m.k2();
                    }
                } finally {
                }
            }
        }
        return this.m;
    }

    public AbstractC18427oe4 H() {
        return this.a;
    }

    public C22686vf4 I() {
        if (this.y == null) {
            synchronized (C22686vf4.class) {
                try {
                    if (this.y == null) {
                        this.y = new C22686vf4(this);
                        this.y.C();
                    }
                } finally {
                }
            }
        }
        return this.y;
    }

    public C11941do4 J() {
        if (this.F == null) {
            synchronized (QQ3.class) {
                try {
                    if (this.F == null) {
                        this.F = new C11941do4(this);
                    }
                } finally {
                }
            }
        }
        return this.F;
    }

    public VE4 K() {
        if (this.D == null) {
            synchronized (VE4.class) {
                try {
                    if (this.D == null) {
                        this.D = new VE4(this);
                    }
                } finally {
                }
            }
        }
        return this.D;
    }

    public UP4 L() {
        if (this.B == null) {
            synchronized (E84.class) {
                try {
                    if (this.B == null) {
                        this.B = new UP4(this);
                    }
                } finally {
                }
            }
        }
        return this.B;
    }

    public C14375ho5 N() {
        if (this.o == null) {
            synchronized (C14375ho5.class) {
                try {
                    if (this.o == null) {
                        this.o = new C14375ho5(this);
                    }
                } finally {
                }
            }
        }
        return this.o;
    }

    public C6508Nu5 O() {
        if (this.t == null) {
            synchronized (C6508Nu5.class) {
                try {
                    if (this.t == null) {
                        this.t = new C6508Nu5(this);
                    }
                } finally {
                }
            }
        }
        return this.t;
    }

    public C17453mz5 P() {
        if (this.n == null) {
            synchronized (C17453mz5.class) {
                try {
                    if (this.n == null) {
                        this.n = new C17453mz5(this);
                    }
                } finally {
                }
            }
        }
        return this.n;
    }

    public C4471Fg6 Q() {
        if (this.u == null) {
            synchronized (C4471Fg6.class) {
                try {
                    if (this.u == null) {
                        this.u = new C4471Fg6(this);
                    }
                } finally {
                }
            }
        }
        return this.u;
    }

    public C14934ij6 R() {
        if (this.v == null) {
            synchronized (C14934ij6.class) {
                try {
                    if (this.v == null) {
                        this.v = new C14934ij6(this);
                    }
                } finally {
                }
            }
        }
        return this.v;
    }

    public SettingsModule S() {
        if (this.s == null) {
            synchronized (SettingsModule.class) {
                try {
                    if (this.s == null) {
                        this.s = new SettingsModule(this, this.c);
                        this.s.Y5();
                    }
                } finally {
                }
            }
        }
        return this.s;
    }

    public MO6 T() {
        if (this.f == null) {
            synchronized (MO6.class) {
                try {
                    if (this.f == null) {
                        this.f = new MO6(this, KN6.g("blob", new C7812Th4()));
                    }
                } finally {
                }
            }
        }
        return this.f;
    }

    public C4892Gz7 U() {
        if (this.p == null) {
            synchronized (C4892Gz7.class) {
                try {
                    if (this.p == null) {
                        this.p = new C4892Gz7(this);
                    }
                } finally {
                }
            }
        }
        return this.p;
    }

    public UG7 V() {
        return this.i;
    }

    public OK7 W() {
        if (this.j == null) {
            synchronized (OK7.class) {
                try {
                    if (this.j == null) {
                        this.j = new OK7(this, KN6.i("users", C21231tK7.c(), C17637nI7.D));
                        this.j.B0();
                    }
                } finally {
                }
            }
        }
        return this.j;
    }

    public A08 X() {
        if (this.C == null) {
            synchronized (E84.class) {
                try {
                    if (this.C == null) {
                        this.C = new A08(this);
                    }
                } finally {
                }
            }
        }
        return this.C;
    }

    public C11461d28 Y() {
        if (this.z == null) {
            synchronized (C11461d28.class) {
                try {
                    if (this.z == null) {
                        this.z = new C11461d28(this);
                        this.z.L();
                    }
                } finally {
                }
            }
        }
        return this.z;
    }

    public C23572x88 Z() {
        if (this.A == null) {
            synchronized (C23572x88.class) {
                try {
                    if (this.A == null) {
                        this.A = new C23572x88(this);
                        this.A.G();
                    }
                } finally {
                }
            }
        }
        return this.A;
    }

    @Override // ir.nasim.InterfaceC7803Tg4
    public C6559Oa2 a() {
        if (this.e == null) {
            synchronized (C6559Oa2.class) {
                try {
                    if (this.e == null) {
                        this.e = new C6559Oa2();
                    }
                } finally {
                }
            }
        }
        return this.e;
    }

    public boolean a0() {
        return this.I;
    }

    @Override // ir.nasim.InterfaceC7803Tg4
    public C9354Zo4 b() {
        return s().H();
    }

    @Override // ir.nasim.InterfaceC7803Tg4
    public InterfaceC3570Bk5 c() {
        if (this.c == null) {
            synchronized (InterfaceC3570Bk5.class) {
                try {
                    if (this.c == null) {
                        this.c = KN6.o();
                    }
                } finally {
                }
            }
        }
        return this.c;
    }

    public int i0() {
        return w().p();
    }

    public void j0(boolean z) {
        this.I = z;
        this.s.Y5();
        this.l.O();
        G();
        N();
        W();
        E();
        U();
        D();
        this.i = new UG7(this);
        A();
        BN6.o(s(), c(), C7183Qq.q(EnumC18608ow5.j));
        I();
        B();
        R();
        P();
        ((InterfaceC12620ev0) I22.a(C5721Ko.b, InterfaceC12620ev0.class)).s().n();
        this.i.x0();
        if (C21753u45.S(C5721Ko.b)) {
            C7077Qe1.a(C5721Ko.b.getContentResolver());
        }
        l0();
    }

    public synchronized void k0() {
        try {
            if (b0()) {
                FirebaseMessaging.n().k();
                AbstractC9599aE4.g(C5721Ko.b);
            }
            KN6.t();
            AbstractC20507s76.y();
        } catch (Throwable th) {
            throw th;
        }
    }

    public PeersStruct$ExPeer l(C11458d25 c11458d25) {
        C14697iL2 c14697iL2;
        if (c11458d25.s() == W25.a) {
            C17637nI7 c17637nI7 = (C17637nI7) W().p0().d(c11458d25.getPeerId());
            if (c17637nI7 == null) {
                return null;
            }
            return (PeersStruct$ExPeer) PeersStruct$ExPeer.newBuilder().C(c17637nI7.p0() ? EnumC10088b35.ExPeerType_BOT : EnumC10088b35.ExPeerType_PRIVATE).B(c17637nI7.n0()).A(c17637nI7.getAccessHash()).a();
        }
        if (c11458d25.s() != W25.b || (c14697iL2 = (C14697iL2) E().X1().d(c11458d25.getPeerId())) == null) {
            return null;
        }
        return (PeersStruct$ExPeer) PeersStruct$ExPeer.newBuilder().C(c14697iL2.q0() == ZN2.CHANNEL ? EnumC10088b35.ExPeerType_CHANNEL : EnumC10088b35.ExPeerType_GROUP).B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).a();
    }

    public C16966mA m(C11458d25 c11458d25) {
        if (c11458d25.s() == W25.a) {
            C17637nI7 c17637nI7 = (C17637nI7) W().p0().d(c11458d25.getPeerId());
            if (c17637nI7 == null) {
                return null;
            }
            return new C16966mA(c17637nI7.p0() ? EnumC9196Yx.BOT : EnumC9196Yx.PRIVATE, c17637nI7.n0(), c17637nI7.getAccessHash());
        }
        if (c11458d25.s() == W25.b) {
            C14697iL2 c14697iL2 = (C14697iL2) E().X1().d(c11458d25.getPeerId());
            if (c14697iL2 == null) {
                return null;
            }
            return new C16966mA(c14697iL2.q0() == ZN2.CHANNEL ? EnumC9196Yx.CHANNEL : EnumC9196Yx.GROUP, c14697iL2.p0(), c14697iL2.getAccessHash());
        }
        throw new RuntimeException("Unknown peer: " + c11458d25);
    }

    public void m0() {
        this.h.s();
    }

    public C17557nA n(C11458d25 c11458d25) {
        if (c11458d25.s() == W25.a) {
            C17637nI7 c17637nI7 = (C17637nI7) W().p0().d(c11458d25.getPeerId());
            if (c17637nI7 == null) {
                return null;
            }
            return new C17557nA(CA.PRIVATE, c17637nI7.n0(), c17637nI7.getAccessHash());
        }
        if (c11458d25.s() == W25.b) {
            C14697iL2 c14697iL2 = (C14697iL2) E().X1().d(c11458d25.getPeerId());
            if (c14697iL2 == null) {
                return null;
            }
            return new C17557nA(CA.GROUP, c14697iL2.p0(), c14697iL2.getAccessHash());
        }
        throw new RuntimeException("Unknown peer: " + c11458d25);
    }

    public void n0() {
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.Uh4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.M();
            }
        });
    }

    public C6517Nv5 o(final C11458d25 c11458d25) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Vh4
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.e0(c11458d25, c7234Qv5);
            }
        });
    }

    public PeersStruct$OutPeer p(C11458d25 c11458d25) {
        if (c11458d25.s() == W25.a) {
            C17637nI7 c17637nI7 = (C17637nI7) W().p0().d(c11458d25.getPeerId());
            if (c17637nI7 == null) {
                return null;
            }
            return (PeersStruct$OutPeer) PeersStruct$OutPeer.newBuilder().B(c17637nI7.n0()).A(c17637nI7.getAccessHash()).C(EnumC16311l35.PeerType_PRIVATE).a();
        }
        if (c11458d25.s() == W25.b) {
            C14697iL2 c14697iL2 = (C14697iL2) E().X1().d(c11458d25.getPeerId());
            if (c14697iL2 == null) {
                return null;
            }
            return (PeersStruct$OutPeer) PeersStruct$OutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).C(EnumC16311l35.PeerType_GROUP).a();
        }
        throw new RuntimeException("Unknown peer: " + c11458d25);
    }

    public C6517Nv5 q(final C11458d25 c11458d25) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Qh4
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.h0(c11458d25, c7234Qv5);
            }
        });
    }

    void r() {
        this.d = new T34();
        C13923h3 c13923h3 = C13923h3.a;
        if (c13923h3.t()) {
            AccountInfo accountInfoK = c13923h3.k();
            this.d.putInt("auth_uid", accountInfoK.getUid());
            this.d.putLong("auth_id", accountInfoK.getAuthId());
            this.d.putString("auth_jwt", accountInfoK.getJwt());
            this.d.putLong("auth_phone", accountInfoK.getPhone());
            this.d.f("auth_master_key", accountInfoK.getMasterKey());
            this.d.putLong("auth_access_hash", accountInfoK.getAccessHash());
            this.d.g("auth_yes", true);
        }
    }

    public C6287Mz s() {
        if (this.g == null) {
            synchronized (C6287Mz.class) {
                try {
                    if (this.g == null) {
                        this.g = new C6287Mz(this, this.d);
                    }
                } finally {
                }
            }
        }
        return this.g;
    }

    public C16966mA t(C11458d25 c11458d25) {
        if (c11458d25.s() == W25.a) {
            C17637nI7 c17637nI7 = (C17637nI7) this.j.p0().d(c11458d25.getPeerId());
            if (c17637nI7.getExPeerType() == null) {
                return null;
            }
            return new C16966mA(c17637nI7.getExPeerType().toApi(), c11458d25.getPeerId(), c17637nI7.getAccessHash());
        }
        if (c11458d25.s() != W25.b) {
            return null;
        }
        C14697iL2 c14697iL2 = (C14697iL2) this.k.X1().d(c11458d25.getPeerId());
        if (c14697iL2.getExPeerType() == null) {
            return null;
        }
        return new C16966mA(c14697iL2.getExPeerType().toApi(), c11458d25.getPeerId(), c14697iL2.getAccessHash());
    }

    public C17557nA u(C11458d25 c11458d25) {
        if (c11458d25 == null) {
            return null;
        }
        if (c11458d25.s() == W25.a) {
            return new C17557nA(CA.PRIVATE, c11458d25.getPeerId(), ((C17637nI7) this.j.p0().d(c11458d25.getPeerId())).getAccessHash());
        }
        if (c11458d25.s() == W25.b) {
            return new C17557nA(CA.GROUP, c11458d25.getPeerId(), ((C14697iL2) this.k.X1().d(c11458d25.getPeerId())).getAccessHash());
        }
        return null;
    }

    public PE v() {
        if (this.l == null) {
            synchronized (PE.class) {
                try {
                    if (this.l == null) {
                        this.l = new PE(this);
                        this.l.O();
                    }
                } finally {
                }
            }
        }
        return this.l;
    }

    public C15346jR w() {
        return this.h;
    }

    public InterfaceC3570Bk5 x() {
        if (this.d == null) {
            synchronized (InterfaceC3570Bk5.class) {
                try {
                    if (this.d == null) {
                        r();
                    }
                } finally {
                }
            }
        }
        return this.d;
    }

    public BankingModule y() {
        if (this.G == null) {
            synchronized (BankingModule.class) {
                try {
                    if (this.G == null) {
                        this.G = new BankingModule(this).K2();
                    }
                } finally {
                }
            }
        }
        return this.G;
    }

    public C8468Wc1 z() {
        return this.b;
    }
}
