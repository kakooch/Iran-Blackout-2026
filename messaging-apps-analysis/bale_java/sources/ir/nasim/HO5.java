package ir.nasim;

/* loaded from: classes2.dex */
public class HO5 implements InterfaceC9904al1 {
    private final String a;
    private final C17380ms b;
    private final C17380ms c;
    private final C3636Bs d;
    private final boolean e;

    public HO5(String str, C17380ms c17380ms, C17380ms c17380ms2, C3636Bs c3636Bs, boolean z) {
        this.a = str;
        this.b = c17380ms;
        this.c = c17380ms2;
        this.d = c3636Bs;
        this.e = z;
    }

    @Override // ir.nasim.InterfaceC9904al1
    public InterfaceC14939ik1 a(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0) {
        return new IO5(qVar, abstractC3236Aa0, this);
    }

    public C17380ms b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public C17380ms d() {
        return this.c;
    }

    public C3636Bs e() {
        return this.d;
    }

    public boolean f() {
        return this.e;
    }
}
