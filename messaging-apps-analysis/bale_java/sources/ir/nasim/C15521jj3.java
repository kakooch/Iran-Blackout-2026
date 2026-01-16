package ir.nasim;

/* renamed from: ir.nasim.jj3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C15521jj3 extends C22725vj3 implements InterfaceC24075y01 {
    private final boolean c;

    public C15521jj3(InterfaceC13730gj3 interfaceC13730gj3) {
        super(true);
        A0(interfaceC13730gj3);
        this.c = d1();
    }

    private final boolean d1() {
        C22725vj3 c22725vj3B;
        CS0 cs0W0 = w0();
        DS0 ds0 = cs0W0 instanceof DS0 ? (DS0) cs0W0 : null;
        if (ds0 != null && (c22725vj3B = ds0.B()) != null) {
            while (!c22725vj3B.t0()) {
                CS0 cs0W02 = c22725vj3B.w0();
                DS0 ds02 = cs0W02 instanceof DS0 ? (DS0) cs0W02 : null;
                if (ds02 == null || (c22725vj3B = ds02.B()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC24075y01
    public boolean c() {
        return F0(C19938rB7.a);
    }

    @Override // ir.nasim.InterfaceC24075y01
    public boolean e(Throwable th) {
        return F0(new B01(th, false, 2, null));
    }

    @Override // ir.nasim.C22725vj3
    public boolean t0() {
        return this.c;
    }

    @Override // ir.nasim.C22725vj3
    public boolean u0() {
        return true;
    }
}
