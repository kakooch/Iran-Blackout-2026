package ir.nasim;

/* loaded from: classes5.dex */
public class W66 extends AbstractC24641yx5 {
    private boolean a;
    private int b;

    public W66(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 4;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.f();
        this.b = c9207Yy1.d();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.j(this.a);
        c12658ez1.h(this.b);
    }

    public int g() {
        return this.b;
    }

    public boolean h() {
        return this.a;
    }
}
