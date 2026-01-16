package ir.nasim;

import ir.nasim.C6374Ni0;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.nI7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C17637nI7 extends Ab8 implements InterfaceC8844Xo3 {
    public static InterfaceC17311ml0 D = new InterfaceC17311ml0() { // from class: ir.nasim.mI7
        @Override // ir.nasim.InterfaceC17311ml0
        public final Object a() {
            return C17637nI7.u();
        }
    };
    private EnumC3633Br5 A;
    private Boolean B;
    private int c;
    private long d;
    private String e;
    private String f;
    private String g;
    private String h;
    private Avatar i;
    private boolean j;
    private C5902Li0 k;
    private List l;
    private boolean m;
    private boolean n;
    private List o;
    private ExPeerType p;
    private E25 q;
    private String r;
    private String s;
    private boolean t;
    private boolean u;
    private Long v;
    private int w;
    private boolean x;
    private ir.nasim.features.mxp.entity.a y;
    private Long z;

    public C17637nI7(C15811kD c15811kD, C16256ky c16256ky) {
        super(10, 20, c15811kD, c16256ky);
    }

    private static C6374Ni0 U(C20983sw c20983sw) {
        if (c20983sw.r() == null) {
            return null;
        }
        C7723Sy c7723SyR = c20983sw.r();
        C7489Ry c7489RyQ = c20983sw.r().q();
        String strR = c7723SyR.r();
        C6374Ni0.a aVarV = V(c7489RyQ);
        if (aVarV == null && (strR == null || YP1.a(strR))) {
            return null;
        }
        return new C6374Ni0(strR, aVarV);
    }

    private static C6374Ni0.a V(C7489Ry c7489Ry) {
        if (c7489Ry == null) {
            return null;
        }
        C12056dy fileLocation = c7489Ry.getFileLocation();
        AbstractC21697tz abstractC21697tzQ = c7489Ry.q();
        if (fileLocation == null || abstractC21697tzQ == null) {
            return null;
        }
        if (abstractC21697tzQ instanceof C7255Qy) {
            C7255Qy c7255Qy = (C7255Qy) abstractC21697tzQ;
            return new C6374Ni0.a.b(c7255Qy.y(), c7255Qy.u(), m0(c7255Qy.w()), c0(fileLocation), c7489Ry.getFileName(), c7489Ry.getFileSize(), c7489Ry.r());
        }
        if (!(abstractC21697tzQ instanceof C7962Ty)) {
            return new C6374Ni0.a.e(c0(fileLocation), c7489Ry.getFileName(), c7489Ry.getFileSize(), c7489Ry.r());
        }
        C7962Ty c7962Ty = (C7962Ty) abstractC21697tzQ;
        return new C6374Ni0.a.c(c7962Ty.y(), c7962Ty.u(), m0(c7962Ty.w()), c0(fileLocation), c7489Ry.getFileName(), c7489Ry.getFileSize(), c7489Ry.r());
    }

    private static C6374Ni0.a.C0536a c0(C12056dy c12056dy) {
        if (c12056dy == null) {
            return null;
        }
        return new C6374Ni0.a.C0536a(c12056dy.getFileId(), c12056dy.getAccessHash());
    }

    private static C6374Ni0.a.d m0(C11413cy c11413cy) {
        if (c11413cy == null) {
            return null;
        }
        return new C6374Ni0.a.d(c11413cy.u(), c11413cy.q(), c11413cy.s());
    }

    public static /* synthetic */ C17637nI7 u() {
        return new C17637nI7();
    }

    public C17637nI7 C(String str) {
        C16256ky c16256ky = (C16256ky) s();
        if (c16256ky == null) {
            return this;
        }
        return new C17637nI7((C15811kD) getWrapped(), new C16256ky(c16256ky.D(), c16256ky.s(), str, c16256ky.E(), c16256ky.H(), c16256ky.r(), c16256ky.C(), c16256ky.J(), c16256ky.z(), c16256ky.w(), c16256ky.y(), c16256ky.L(), c16256ky.K(), c16256ky.G(), c16256ky.u(), c16256ky.F(), c16256ky.M()));
    }

    public C17637nI7 D(C6984Pv c6984Pv) {
        C15811kD c15811kD = (C15811kD) getWrapped();
        C15811kD c15811kD2 = new C15811kD(c15811kD.w(), c15811kD.getAccessHash(), c15811kD.getName(), c15811kD.y(), c15811kD.z(), c15811kD.D(), c6984Pv, c15811kD.F(), c15811kD.u(), c15811kD.E(), c15811kD.G(), c15811kD.C(), c15811kD.s(), c15811kD.r());
        c15811kD2.setUnmappedObjects(c15811kD.getUnmappedObjects());
        return new C17637nI7(c15811kD2, (C16256ky) s());
    }

    public C17637nI7 E(boolean z) {
        C16256ky c16256ky = (C16256ky) s();
        if (c16256ky == null) {
            return this;
        }
        return new C17637nI7((C15811kD) getWrapped(), new C16256ky(c16256ky.D(), c16256ky.s(), c16256ky.q(), c16256ky.E(), c16256ky.H(), c16256ky.r(), c16256ky.C(), Boolean.valueOf(z), c16256ky.z(), c16256ky.w(), c16256ky.y(), c16256ky.L(), c16256ky.K(), c16256ky.G(), c16256ky.u(), c16256ky.F(), c16256ky.M()));
    }

    public C17637nI7 F(List list) {
        C16256ky c16256ky = (C16256ky) s();
        if (c16256ky == null) {
            return this;
        }
        return new C17637nI7((C15811kD) getWrapped(), new C16256ky(c16256ky.D(), c16256ky.s(), c16256ky.q(), c16256ky.E(), c16256ky.H(), list, c16256ky.C(), c16256ky.J(), c16256ky.z(), c16256ky.w(), c16256ky.y(), c16256ky.L(), c16256ky.K(), c16256ky.G(), c16256ky.u(), c16256ky.F(), c16256ky.M()));
    }

    public C17637nI7 G(List list) {
        C16256ky c16256ky = (C16256ky) s();
        if (c16256ky == null) {
            return this;
        }
        return new C17637nI7((C15811kD) getWrapped(), new C16256ky(c16256ky.D(), list, c16256ky.q(), c16256ky.E(), c16256ky.H(), c16256ky.r(), c16256ky.C(), c16256ky.J(), c16256ky.z(), c16256ky.w(), c16256ky.y(), c16256ky.L(), c16256ky.K(), c16256ky.G(), c16256ky.u(), c16256ky.F(), c16256ky.M()));
    }

    public C17637nI7 H(String str) {
        C16256ky c16256ky = (C16256ky) s();
        if (c16256ky == null) {
            return this;
        }
        return new C17637nI7((C15811kD) getWrapped(), new C16256ky(c16256ky.D(), c16256ky.s(), c16256ky.q(), c16256ky.E(), c16256ky.H(), c16256ky.r(), c16256ky.C(), c16256ky.J(), c16256ky.z(), str, c16256ky.y(), c16256ky.L(), c16256ky.K(), c16256ky.G(), c16256ky.u(), c16256ky.F(), c16256ky.M()));
    }

    public C17637nI7 J(String str) {
        C16256ky c16256ky = (C16256ky) s();
        if (c16256ky == null) {
            return this;
        }
        return new C17637nI7((C15811kD) getWrapped(), new C16256ky(c16256ky.D(), c16256ky.s(), c16256ky.q(), c16256ky.E(), c16256ky.H(), c16256ky.r(), c16256ky.C(), c16256ky.J(), c16256ky.z(), c16256ky.w(), str, c16256ky.L(), c16256ky.K(), c16256ky.G(), c16256ky.u(), c16256ky.F(), c16256ky.M()));
    }

    public C17637nI7 K(C7714Sx c7714Sx) {
        C16256ky c16256ky = (C16256ky) s();
        if (c16256ky == null) {
            return this;
        }
        return new C17637nI7((C15811kD) getWrapped(), new C16256ky(c16256ky.D(), c16256ky.s(), c16256ky.q(), c16256ky.E(), c16256ky.H(), c16256ky.r(), c16256ky.C(), c16256ky.J(), c7714Sx, c16256ky.w(), c16256ky.y(), c16256ky.L(), c16256ky.K(), c16256ky.G(), c16256ky.u(), c16256ky.F(), c16256ky.M()));
    }

    public C17637nI7 L(C19811qz c19811qz) {
        C15811kD c15811kD = (C15811kD) getWrapped();
        C15811kD c15811kD2 = new C15811kD(c15811kD.w(), c15811kD.getAccessHash(), c15811kD.getName(), c15811kD.y(), c15811kD.z(), c15811kD.D(), c15811kD.q(), c15811kD.F(), c19811qz, c15811kD.E(), c15811kD.G(), c15811kD.C(), c15811kD.s(), c15811kD.r());
        c15811kD2.setUnmappedObjects(c15811kD.getUnmappedObjects());
        return new C17637nI7(c15811kD2, (C16256ky) s());
    }

    public C17637nI7 M(C19811qz c19811qz) {
        C16256ky c16256ky = (C16256ky) s();
        if (c16256ky == null) {
            return this;
        }
        return new C17637nI7((C15811kD) getWrapped(), new C16256ky(c16256ky.D(), c16256ky.s(), c16256ky.q(), c16256ky.E(), c16256ky.H(), c16256ky.r(), c19811qz, c16256ky.J(), c16256ky.z(), c16256ky.w(), c16256ky.y(), c16256ky.L(), c16256ky.K(), c16256ky.G(), c16256ky.u(), c16256ky.F(), c16256ky.M()));
    }

    public C17637nI7 N(boolean z) {
        C16256ky c16256ky = (C16256ky) s();
        if (c16256ky == null) {
            return this;
        }
        return new C17637nI7((C15811kD) getWrapped(), new C16256ky(c16256ky.D(), c16256ky.s(), c16256ky.q(), c16256ky.E(), c16256ky.H(), c16256ky.r(), c16256ky.C(), c16256ky.J(), c16256ky.z(), c16256ky.w(), c16256ky.y(), c16256ky.L(), Boolean.valueOf(z), c16256ky.G(), c16256ky.u(), c16256ky.F(), c16256ky.M()));
    }

    public C17637nI7 O(String str) {
        C15811kD c15811kD = (C15811kD) getWrapped();
        C15811kD c15811kD2 = new C15811kD(c15811kD.w(), c15811kD.getAccessHash(), c15811kD.getName(), str, c15811kD.z(), c15811kD.D(), c15811kD.q(), c15811kD.F(), c15811kD.u(), c15811kD.E(), c15811kD.G(), c15811kD.C(), c15811kD.s(), c15811kD.r());
        c15811kD2.setUnmappedObjects(c15811kD.getUnmappedObjects());
        return new C17637nI7(c15811kD2, (C16256ky) s());
    }

    public C17637nI7 P(String str) {
        C15811kD c15811kD = (C15811kD) getWrapped();
        C15811kD c15811kD2 = new C15811kD(c15811kD.w(), c15811kD.getAccessHash(), str, c15811kD.y(), c15811kD.z(), c15811kD.D(), c15811kD.q(), c15811kD.F(), c15811kD.u(), c15811kD.E(), c15811kD.G(), c15811kD.C(), c15811kD.s(), c15811kD.r());
        c15811kD2.setUnmappedObjects(c15811kD.getUnmappedObjects());
        return new C17637nI7(c15811kD2, (C16256ky) s());
    }

    public C17637nI7 Q(String str) {
        C15811kD c15811kD = (C15811kD) getWrapped();
        C15811kD c15811kD2 = new C15811kD(c15811kD.w(), c15811kD.getAccessHash(), c15811kD.getName(), c15811kD.y(), str, c15811kD.D(), c15811kD.q(), c15811kD.F(), c15811kD.u(), c15811kD.E(), c15811kD.G(), c15811kD.C(), c15811kD.s(), c15811kD.r());
        c15811kD2.setUnmappedObjects(c15811kD.getUnmappedObjects());
        return new C17637nI7(c15811kD2, (C16256ky) s());
    }

    public String R() {
        return this.h;
    }

    public Avatar S() {
        return this.i;
    }

    public C5902Li0 T() {
        return this.k;
    }

    public List W() {
        return this.o;
    }

    public String X() {
        return this.r;
    }

    public String Y() {
        return this.s;
    }

    @Override // ir.nasim.InterfaceC8844Xo3
    public long a() {
        return n0();
    }

    public int a0() {
        return this.w;
    }

    public String b0() {
        return this.f;
    }

    public String d0() {
        return this.g;
    }

    public E25 e0() {
        return this.q;
    }

    public Boolean g0() {
        return this.B;
    }

    public long getAccessHash() {
        return this.d;
    }

    public ExPeerType getExPeerType() {
        return this.p;
    }

    public String getName() {
        String str = this.f;
        return (str == null || str.isEmpty()) ? this.e : this.f;
    }

    public EnumC3633Br5 h0() {
        return this.A;
    }

    public ir.nasim.features.mxp.entity.a i0() {
        return this.y;
    }

    public List j0() {
        return this.l;
    }

    public String l0() {
        return this.e;
    }

    public int n0() {
        return this.c;
    }

    public boolean o0() {
        return this.m;
    }

    public boolean p0() {
        return this.j;
    }

    @Override // ir.nasim.Ab8, ir.nasim.AbstractC25020zb8, ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) throws IOException {
        if (!c19084pl0.c(8, false)) {
            throw new IOException("Unsupported obsolete format");
        }
        super.parse(c19084pl0);
    }

    public boolean q0() {
        return this.u;
    }

    public boolean r0() {
        return this.t;
    }

    public boolean s0() {
        return this.x;
    }

    @Override // ir.nasim.Ab8, ir.nasim.AbstractC25020zb8, ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(8, true);
        super.serialize(c19675ql0);
    }

    public boolean t0() {
        return this.n;
    }

    public C11458d25 u0() {
        return new C11458d25(W25.a, this.c);
    }

    public C17637nI7 v0(C16256ky c16256ky) {
        return new C17637nI7((C15811kD) getWrapped(), c16256ky);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.Ab8
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void q(C15811kD c15811kD, C16256ky c16256ky) {
        this.c = c15811kD.w();
        this.d = c15811kD.getAccessHash();
        this.e = c15811kD.getName();
        this.f = c15811kD.y();
        if (c15811kD.z() == null || c15811kD.z().length() <= 0) {
            this.g = null;
        } else {
            this.g = c15811kD.z();
        }
        if (c15811kD.q() != null) {
            this.i = new Avatar(c15811kD.q());
        }
        this.j = false;
        if (c15811kD.F() != null) {
            this.j = c15811kD.F().booleanValue();
        }
        if (c15811kD.r() != null) {
            C20983sw c20983swR = c15811kD.r();
            String strQ = c20983swR.q();
            Boolean bool = Boolean.TRUE;
            this.k = new C5902Li0(strQ, bool.equals(c20983swR.s()), bool.equals(c20983swR.u()), U(c20983swR));
        } else {
            this.k = new C5902Li0();
        }
        this.v = c15811kD.E();
        this.t = false;
        if (c15811kD.G() != null) {
            this.t = c15811kD.G().booleanValue();
        }
        if (c15811kD.u() != null) {
            this.n = true;
            for (C20420rz c20420rz : c15811kD.u().u()) {
                if ("is_verified".equals(c20420rz.getKey()) && (c20420rz.q() instanceof C5577Jy)) {
                    this.n = ((C5577Jy) c20420rz.q()).u() > 0;
                }
                if ("group_id".equals(c20420rz.getKey()) && (c20420rz.q() instanceof OC)) {
                    this.w = Integer.valueOf(((OC) c20420rz.q()).u()).intValue();
                }
            }
        }
        this.z = c15811kD.s();
        if (c15811kD.C() != null) {
            this.y = ir.nasim.features.mxp.entity.a.j(c15811kD.C().j());
        } else {
            this.y = null;
        }
        if (c16256ky == null) {
            this.m = false;
            this.x = false;
            this.l = new ArrayList();
            this.o = new ArrayList();
            this.h = null;
            this.p = this.j ? ExPeerType.BOT : ExPeerType.PRIVATE;
            this.q = E25.INFORMAL;
            this.r = "";
            this.s = "";
            this.B = Boolean.FALSE;
            return;
        }
        this.x = true;
        this.l = new ArrayList();
        this.o = new ArrayList();
        if (c16256ky.J() != null) {
            this.m = c16256ky.J().booleanValue();
        } else {
            this.m = false;
        }
        for (C13865gx c13865gx : c16256ky.s()) {
            if (c13865gx.u() == EnumC14458hx.PHONE) {
                this.l.add(new C5651Kg1(EnumC5885Lg1.a, "" + c13865gx.q(), c13865gx.s()));
            } else if (c13865gx.u() == EnumC14458hx.EMAIL) {
                this.l.add(new C5651Kg1(EnumC5885Lg1.b, c13865gx.r(), c13865gx.s()));
            } else if (c13865gx.u() == EnumC14458hx.WEB) {
                this.l.add(new C5651Kg1(EnumC5885Lg1.c, c13865gx.r(), c13865gx.s()));
            } else if (c13865gx.u() == EnumC14458hx.SOCIAL) {
                this.l.add(new C5651Kg1(EnumC5885Lg1.d, c13865gx.r(), c13865gx.s()));
            }
        }
        for (C20393rw c20393rw : c16256ky.r()) {
            this.o.add(new C24488yi0(c20393rw.s(), c20393rw.q(), c20393rw.r()));
        }
        this.u = false;
        if (c16256ky.K() != null) {
            this.u = c16256ky.K().booleanValue();
        }
        this.h = c16256ky.q();
        this.q = E25.INFORMAL;
        this.p = this.j ? ExPeerType.BOT : ExPeerType.PRIVATE;
        if (c16256ky.z() != null) {
            if (c16256ky.z().q() != null) {
                this.p = C18732p92.v(c16256ky.z().q());
            }
            if (c16256ky.z().r() != null) {
                this.q = C18732p92.p(c16256ky.z().r());
            }
        }
        this.r = c16256ky.w();
        this.s = c16256ky.y();
        this.A = EnumC3633Br5.a.a(c16256ky.F());
        this.B = c16256ky.M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.Ab8
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public C16256ky r() {
        return new C16256ky();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC25020zb8
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public C15811kD createInstance() {
        return new C15811kD();
    }

    private C17637nI7() {
        super(10, 20);
    }
}
