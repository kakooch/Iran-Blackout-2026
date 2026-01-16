package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.tK7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C21231tK7 extends AbstractC14869id0 {
    private int a;
    private boolean b;
    private C10410bZ6 c;
    private C10410bZ6 d;
    private C10410bZ6 e;
    private C10410bZ6 f;
    private C10410bZ6 g;
    private C19482qQ7 h;
    private C8512Wh0 i;
    private C8512Wh0 j;
    private C8512Wh0 k;
    private C19482qQ7 l;
    private C19482qQ7 m;
    private C19482qQ7 n;
    private C19482qQ7 o;
    private C19482qQ7 p;
    private C19482qQ7 q;
    private ExPeerType r;
    private C19482qQ7 s;
    private C10410bZ6 t;
    private C10410bZ6 u;
    private C8512Wh0 v;
    private O92 w;
    private O92 x;
    private C8512Wh0 y;
    private int z;

    public C21231tK7(C17637nI7 c17637nI7) {
        this.a = c17637nI7.n0();
        this.b = c17637nI7.p0();
        this.c = new C10410bZ6("user." + this.a + ".name", c17637nI7.getName());
        this.d = new C10410bZ6("user." + this.a + ".local_name", c17637nI7.b0());
        this.e = new C10410bZ6("user." + this.a + ".server_name", c17637nI7.l0());
        this.f = new C10410bZ6("user." + this.a + ".nick", c17637nI7.d0());
        this.q = new C19482qQ7("user." + this.a + ".bot_ex_info", c17637nI7.T());
        this.g = new C10410bZ6("user." + this.a + ".about", c17637nI7.R());
        this.h = new C19482qQ7("user." + this.a + ".avatar", c17637nI7.S());
        this.i = new C8512Wh0("user." + this.a + ".contact", Boolean.valueOf(c17637nI7.q0()));
        this.j = new C8512Wh0("user." + this.a + ".blocked", Boolean.valueOf(c17637nI7.o0()));
        this.k = new C8512Wh0("user." + this.a + ".is_verified", Boolean.valueOf(c17637nI7.t0()));
        this.l = new C19482qQ7("user." + this.a + ".phones", f(c17637nI7.j0()));
        this.m = new C19482qQ7("user." + this.a + ".emails", d(c17637nI7.j0()));
        this.n = new C19482qQ7("user." + this.a + ".links", e(c17637nI7.j0()));
        this.o = new C19482qQ7("user." + this.a + ".contacts", new ArrayList(c17637nI7.j0()));
        this.p = new C19482qQ7("user." + this.a + ".bot_commands", new FJ(c17637nI7.W()));
        this.r = c17637nI7.getExPeerType();
        this.s = new C19482qQ7("user." + this.a + ".peerIdentity", c17637nI7.e0());
        this.t = new C10410bZ6("user." + this.a + ".defaultBankAccount", c17637nI7.X());
        this.u = new C10410bZ6("user." + this.a + ".defaultCardNumber", c17637nI7.Y());
        this.v = new C8512Wh0("user." + this.a + ".isDeletedAccount", Boolean.valueOf(c17637nI7.r0()));
        this.z = c17637nI7.a0();
        this.w = new O92("user." + this.a + ".puppeteer", c17637nI7.i0());
        this.x = new O92("user." + this.a + ".privacyBarMode", c17637nI7.h0());
        this.y = new C8512Wh0("user." + this.a + ".privacyAllowedToInvite", c17637nI7.g0());
    }

    public static InterfaceC20073rQ7 c() {
        return new InterfaceC20073rQ7() { // from class: ir.nasim.sK7
            @Override // ir.nasim.InterfaceC20073rQ7
            public final AbstractC14869id0 a(Object obj) {
                return new C21231tK7((C17637nI7) obj);
            }
        };
    }

    private ArrayList d(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C5651Kg1 c5651Kg1 = (C5651Kg1) it.next();
            if (c5651Kg1.c() == EnumC5885Lg1.b) {
                arrayList.add(new C24253yI7(c5651Kg1.a(), c5651Kg1.b()));
            }
        }
        return arrayList;
    }

    private ArrayList e(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C5651Kg1 c5651Kg1 = (C5651Kg1) it.next();
            if (c5651Kg1.c() == EnumC5885Lg1.c) {
                arrayList.add(new DI7(c5651Kg1.a(), c5651Kg1.b()));
            }
        }
        return arrayList;
    }

    private ArrayList f(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C5651Kg1 c5651Kg1 = (C5651Kg1) it.next();
            if (c5651Kg1.c() == EnumC5885Lg1.a) {
                arrayList.add(new NI7(Long.parseLong(c5651Kg1.a()), c5651Kg1.b()));
            }
        }
        return arrayList;
    }

    public C8512Wh0 A() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC14869id0
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void b(C17637nI7 c17637nI7) {
        this.c.i(c17637nI7.getName());
        this.d.i(c17637nI7.b0());
        this.e.i(c17637nI7.l0());
        this.f.i(c17637nI7.d0());
        this.g.i(c17637nI7.R());
        this.h.i(c17637nI7.S());
        this.j.i(Boolean.valueOf(c17637nI7.o0()));
        this.k.i(Boolean.valueOf(c17637nI7.t0()));
        this.q.i(c17637nI7.T());
        this.p.i(new FJ(c17637nI7.W()));
        this.l.i(f(c17637nI7.j0()));
        this.m.i(d(c17637nI7.j0()));
        this.n.i(e(c17637nI7.j0()));
        this.o.i(new HJ(c17637nI7.j0()));
        this.r = c17637nI7.getExPeerType();
        C19482qQ7 c19482qQ7 = this.s;
        if (c19482qQ7 != null) {
            c19482qQ7.i(c17637nI7.e0());
        }
        C10410bZ6 c10410bZ6 = this.t;
        if (c10410bZ6 != null) {
            c10410bZ6.i(c17637nI7.X());
        }
        C10410bZ6 c10410bZ62 = this.u;
        if (c10410bZ62 != null) {
            c10410bZ62.i(c17637nI7.Y());
        }
        this.v.i(Boolean.valueOf(c17637nI7.r0()));
        this.i.i(Boolean.valueOf(c17637nI7.q0()));
        this.z = c17637nI7.a0();
        this.w.i(c17637nI7.i0());
        O92 o92 = this.x;
        if (o92 != null) {
            o92.i(c17637nI7.h0());
        }
        C8512Wh0 c8512Wh0 = this.y;
        if (c8512Wh0 != null) {
            c8512Wh0.i(c17637nI7.g0());
        }
    }

    public C10410bZ6 g() {
        return this.g;
    }

    public C19482qQ7 h() {
        return this.h;
    }

    public C19482qQ7 i() {
        return this.p;
    }

    public C19482qQ7 j() {
        return this.q;
    }

    public C10410bZ6 k() {
        return this.t;
    }

    public C10410bZ6 l() {
        return this.u;
    }

    public C19482qQ7 m() {
        return this.m;
    }

    public ExPeerType n() {
        return this.r;
    }

    public int o() {
        return this.a;
    }

    public C8512Wh0 p() {
        return this.j;
    }

    public C10410bZ6 q() {
        return this.d;
    }

    public C10410bZ6 r() {
        return this.c;
    }

    public C10410bZ6 s() {
        return this.f;
    }

    public C19482qQ7 t() {
        return this.s;
    }

    public C19482qQ7 u() {
        return this.l;
    }

    public C8512Wh0 v() {
        return this.y;
    }

    public O92 w() {
        return this.x;
    }

    public O92 x() {
        return this.w;
    }

    public boolean y() {
        return this.b;
    }

    public C8512Wh0 z() {
        return this.i;
    }
}
