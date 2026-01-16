package ir.nasim;

import ir.nasim.C18761pC3;

/* loaded from: classes5.dex */
public class PE extends AbstractC21707u0 {
    private final C9057Yh4 b;
    private QE c;
    private C22481vJ2 d;
    private C9528a7 e;
    private C9528a7 f;
    private String g;

    public PE(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.g = "AppStateModule";
        this.b = c9057Yh4;
        this.d = new C22481vJ2(c9057Yh4);
        C();
    }

    private void C() {
        this.f = C12736f7.n().f("actor/app/force_update", C4614Fw5.d(new V6() { // from class: ir.nasim.NE
            @Override // ir.nasim.V6
            public final K6 create() {
                return this.a.F();
            }
        }).a("D_network"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 F() {
        return new C12259eJ2(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 G() {
        return new C18761pC3(this.b);
    }

    public QE D() {
        return this.c;
    }

    public C22481vJ2 E() {
        return this.d;
    }

    public void H(C16110kj1 c16110kj1) {
        try {
            this.e.d(new C18761pC3.a(c16110kj1));
        } catch (Exception e) {
            C19406qI3.a(this.g, "onBookImportStateChanged listStatesActor error : " + e.getMessage(), new Object[0]);
        }
    }

    public void I() {
        this.e.d(new C18761pC3.b());
    }

    public void J() {
        this.e.d(new C18761pC3.d());
    }

    public void K(boolean z) {
        this.e.d(new C18761pC3.c(z));
    }

    public void L(OP1 op1, EnumC12820fE enumC12820fE) {
        this.e.d(new C18761pC3.e(op1, enumC12820fE));
    }

    public void M(EF2 ef2) {
        try {
            this.e.d(new C18761pC3.f(ef2));
        } catch (Exception e) {
            C19406qI3.a(this.g, "onGetContactsChanged listStatesActor error : " + e.getMessage(), new Object[0]);
        }
    }

    public void N() {
        this.e.d(new C18761pC3.g());
    }

    public void O() {
        this.c = new QE(this.b);
        this.e = C12736f7.n().d("actor/app/state", new V6() { // from class: ir.nasim.OE
            @Override // ir.nasim.V6
            public final K6 create() {
                return this.a.G();
            }
        });
    }
}
