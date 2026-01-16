package ir.nasim;

/* loaded from: classes5.dex */
public class VB7 extends AbstractC24641yx5 {
    private long a;
    private long b;
    private int c;

    public VB7(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 8;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
        this.b = c9207Yy1.e();
        this.c = c9207Yy1.d();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.i(this.a);
        c12658ez1.i(this.b);
        c12658ez1.h(this.c);
    }

    public long g() {
        return this.a;
    }

    public long h() {
        return this.b;
    }

    public String toString() {
        return "UnsentResponse[" + this.a + "->" + this.b + "]";
    }
}
