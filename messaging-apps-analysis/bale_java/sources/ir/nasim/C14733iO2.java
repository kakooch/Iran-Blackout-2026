package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.HashSet;

/* renamed from: ir.nasim.iO2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C14733iO2 extends AbstractC14869id0 {
    private int A;
    private final C8512Wh0 B;
    private C19482qQ7 C;
    private C19482qQ7 D;
    private C19482qQ7 E;
    private C8512Wh0 F;
    private O92 G;
    private final int a;
    private int b;
    private final C19482qQ7 c;
    private C6305Na3 d;
    private final C10410bZ6 e;
    private final C8512Wh0 f;
    private C19482qQ7 g;
    private C19482qQ7 h;
    private C19482qQ7 i;
    private C8512Wh0 j;
    private final C19482qQ7 k;
    private final ZN2 l;
    private C8512Wh0 m;
    private final C10410bZ6 n;
    private C8512Wh0 o;
    private C8512Wh0 p;
    private C19482qQ7 q;
    private C19482qQ7 r;
    private C19482qQ7 s;
    private C19482qQ7 t;
    private C10410bZ6 u;
    private C10410bZ6 v;
    private final int w;
    private final C10410bZ6 x;
    private ExPeerType y;
    private C19482qQ7 z;

    public C14733iO2(C14697iL2 c14697iL2, int i) {
        this.w = i;
        int iP0 = c14697iL2.p0();
        this.a = iP0;
        this.b = c14697iL2.w0();
        this.e = new C10410bZ6("group." + iP0 + ".title", c14697iL2.G0());
        this.c = new C19482qQ7("group." + iP0 + ".avatar", c14697iL2.h0());
        this.d = new C6305Na3("group." + this.d + ".membersCount", Integer.valueOf(c14697iL2.t0()));
        this.f = new C8512Wh0("group." + iP0 + ".isMember", Boolean.valueOf(c14697iL2.H0()));
        if (c14697iL2.s0() != null) {
            this.g = new C19482qQ7("group." + iP0 + ".members", new HashSet(c14697iL2.s0()));
            this.h = new C19482qQ7("group." + iP0 + ".member." + i, c14697iL2.r0(i));
        }
        this.k = new C19482qQ7("group." + iP0 + ".presence", 0);
        this.l = c14697iL2.q0();
        this.m = new C8512Wh0("group." + this.m + ".canSendMessage", Boolean.valueOf(c14697iL2.D()));
        this.n = new C10410bZ6("group." + iP0 + ".about", c14697iL2.d0());
        this.o = new C8512Wh0("group." + this.o + ".canViewMembers", Boolean.valueOf(c14697iL2.E()));
        this.p = new C8512Wh0("group." + this.p + ".canInvitePeople", Boolean.valueOf(c14697iL2.C()));
        this.x = new C10410bZ6("group." + iP0 + ".nick", c14697iL2.v0());
        this.B = new C8512Wh0("group." + iP0 + ".becameOrphaned", c14697iL2.j0());
        this.y = c14697iL2.getExPeerType();
        this.z = new C19482qQ7("group." + this.z + ".peerIdentity", c14697iL2.x0());
        this.A = c14697iL2.l0();
        this.q = new C19482qQ7("group." + this.q + ".pinMessageRemoved", c14697iL2.A0());
        this.r = new C19482qQ7("group." + this.r + ".pinMessageAdded", c14697iL2.z0());
        this.s = new C19482qQ7("group." + this.s + ".restriction", c14697iL2.E0());
        this.t = new C19482qQ7("group." + this.t + ".adType", c14697iL2.e0());
        this.u = new C10410bZ6("group." + this.u + ".bannerAdTag", c14697iL2.i0());
        this.v = new C10410bZ6("group." + this.v + ".nativeAdTag", c14697iL2.u0());
        this.C = new C19482qQ7("group." + this.C + ".restriction", c14697iL2.y0());
        this.D = new C19482qQ7("group." + this.D + ".defaultPermissions", c14697iL2.m0());
        this.E = new C19482qQ7("group." + this.E + ".availableReactions", c14697iL2.g0());
        this.F = new C8512Wh0("group." + this.F + ".isSuspended", c14697iL2.F0());
        this.i = new C19482qQ7("group." + this.i + ".discussionGroupId", c14697iL2.o0());
        this.j = new C8512Wh0("group." + this.j + ".isDiscussionGroupEnabled", c14697iL2.n0());
        this.G = new O92("group." + this.G + ".privacyBarMode", c14697iL2.C0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C14733iO2 G(int i, C14697iL2 c14697iL2) {
        return new C14733iO2(c14697iL2, i);
    }

    public static InterfaceC20073rQ7 d(final int i) {
        return new InterfaceC20073rQ7() { // from class: ir.nasim.hO2
            @Override // ir.nasim.InterfaceC20073rQ7
            public final AbstractC14869id0 a(Object obj) {
                return C14733iO2.G(i, (C14697iL2) obj);
            }
        };
    }

    public C19482qQ7 A() {
        return this.r;
    }

    public C19482qQ7 B() {
        return this.q;
    }

    public C19482qQ7 C() {
        return this.k;
    }

    public O92 D() {
        return this.G;
    }

    public C19482qQ7 E() {
        return this.s;
    }

    public C8512Wh0 F() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC14869id0
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void b(C14697iL2 c14697iL2) {
        this.e.i(c14697iL2.G0());
        this.n.i(c14697iL2.d0());
        this.c.i(c14697iL2.h0());
        this.d.i(Integer.valueOf(c14697iL2.t0()));
        this.f.i(Boolean.valueOf(c14697iL2.H0()));
        if (c14697iL2.s0() != null) {
            this.g.i(new HashSet(c14697iL2.s0()));
            this.h.i(c14697iL2.r0(this.w));
        }
        this.b = c14697iL2.w0();
        this.m.i(Boolean.valueOf(c14697iL2.D()));
        this.o.i(Boolean.valueOf(c14697iL2.E()));
        this.p.i(Boolean.valueOf(c14697iL2.C()));
        this.x.i(c14697iL2.v0());
        this.B.i(c14697iL2.j0());
        this.y = c14697iL2.getExPeerType();
        this.z.i(c14697iL2.x0());
        this.A = c14697iL2.l0();
        C19482qQ7 c19482qQ7 = this.t;
        if (c19482qQ7 != null) {
            c19482qQ7.i(c14697iL2.e0());
        }
        C10410bZ6 c10410bZ6 = this.u;
        if (c10410bZ6 != null) {
            c10410bZ6.i(c14697iL2.i0());
        }
        C10410bZ6 c10410bZ62 = this.v;
        if (c10410bZ62 != null) {
            c10410bZ62.i(c14697iL2.u0());
        }
        C19482qQ7 c19482qQ72 = this.C;
        if (c19482qQ72 != null) {
            c19482qQ72.i(c14697iL2.y0());
        }
        C19482qQ7 c19482qQ73 = this.D;
        if (c19482qQ73 != null) {
            c19482qQ73.i(c14697iL2.m0());
        }
        C19482qQ7 c19482qQ74 = this.q;
        if (c19482qQ74 != null) {
            c19482qQ74.i(c14697iL2.A0());
        }
        C19482qQ7 c19482qQ75 = this.r;
        if (c19482qQ75 != null) {
            c19482qQ75.i(c14697iL2.z0());
        }
        C19482qQ7 c19482qQ76 = this.s;
        if (c19482qQ76 != null) {
            c19482qQ76.i(c14697iL2.E0());
        }
        this.E.i(c14697iL2.g0());
        this.F.i(c14697iL2.F0());
        C19482qQ7 c19482qQ77 = this.i;
        if (c19482qQ77 != null) {
            c19482qQ77.i(c14697iL2.o0());
        }
        C8512Wh0 c8512Wh0 = this.j;
        if (c8512Wh0 != null) {
            c8512Wh0.i(c14697iL2.n0());
        }
        O92 o92 = this.G;
        if (o92 != null) {
            o92.i(c14697iL2.C0());
        }
    }

    public C8512Wh0 e() {
        return this.p;
    }

    public C8512Wh0 f() {
        return this.m;
    }

    public C8512Wh0 g() {
        return this.o;
    }

    public C10410bZ6 h() {
        return this.n;
    }

    public C19482qQ7 i() {
        return this.E;
    }

    public C19482qQ7 j() {
        return this.c;
    }

    public C8512Wh0 k() {
        return this.B;
    }

    public int l() {
        return this.A;
    }

    public C19482qQ7 m() {
        return this.D;
    }

    public C8512Wh0 n() {
        return this.j;
    }

    public C19482qQ7 o() {
        return this.i;
    }

    public ExPeerType p() {
        return this.y;
    }

    public ZN2 q() {
        return this.l;
    }

    public int r() {
        return this.a;
    }

    public C19482qQ7 s() {
        return this.h;
    }

    public C19482qQ7 t() {
        return this.g;
    }

    public C6305Na3 u() {
        return this.d;
    }

    public C10410bZ6 v() {
        return this.e;
    }

    public C10410bZ6 w() {
        return this.x;
    }

    public int x() {
        return this.b;
    }

    public C19482qQ7 y() {
        return this.z;
    }

    public C19482qQ7 z() {
        return this.C;
    }
}
