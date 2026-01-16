package ir.nasim;

/* renamed from: ir.nasim.yx6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C24642yx6 implements InterfaceC9904al1 {
    private final String a;
    private final int b;
    private final C22221us c;
    private final boolean d;

    public C24642yx6(String str, int i, C22221us c22221us, boolean z) {
        this.a = str;
        this.b = i;
        this.c = c22221us;
        this.d = z;
    }

    @Override // ir.nasim.InterfaceC9904al1
    public InterfaceC14939ik1 a(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0) {
        return new C13872gx6(qVar, abstractC3236Aa0, this);
    }

    public String b() {
        return this.a;
    }

    public C22221us c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.b + '}';
    }
}
