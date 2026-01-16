package ir.nasim;

/* renamed from: ir.nasim.cU0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C10949cU0 implements InterfaceC9904al1 {
    private final String a;
    private final InterfaceC4104Ds b;
    private final C20944ss c;
    private final boolean d;
    private final boolean e;

    public C10949cU0(String str, InterfaceC4104Ds interfaceC4104Ds, C20944ss c20944ss, boolean z, boolean z2) {
        this.a = str;
        this.b = interfaceC4104Ds;
        this.c = c20944ss;
        this.d = z;
        this.e = z2;
    }

    @Override // ir.nasim.InterfaceC9904al1
    public InterfaceC14939ik1 a(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0) {
        return new K52(qVar, abstractC3236Aa0, this);
    }

    public String b() {
        return this.a;
    }

    public InterfaceC4104Ds c() {
        return this.b;
    }

    public C20944ss d() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.d;
    }
}
