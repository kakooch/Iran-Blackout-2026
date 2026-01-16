package ir.nasim;

/* loaded from: classes2.dex */
public class LK5 implements InterfaceC9904al1 {
    private final String a;
    private final InterfaceC4104Ds b;
    private final InterfaceC4104Ds c;
    private final C17380ms d;
    private final boolean e;

    public LK5(String str, InterfaceC4104Ds interfaceC4104Ds, InterfaceC4104Ds interfaceC4104Ds2, C17380ms c17380ms, boolean z) {
        this.a = str;
        this.b = interfaceC4104Ds;
        this.c = interfaceC4104Ds2;
        this.d = c17380ms;
        this.e = z;
    }

    @Override // ir.nasim.InterfaceC9904al1
    public InterfaceC14939ik1 a(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0) {
        return new JK5(qVar, abstractC3236Aa0, this);
    }

    public C17380ms b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public InterfaceC4104Ds d() {
        return this.b;
    }

    public InterfaceC4104Ds e() {
        return this.c;
    }

    public boolean f() {
        return this.e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.b + ", size=" + this.c + '}';
    }
}
