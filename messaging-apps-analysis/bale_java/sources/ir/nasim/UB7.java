package ir.nasim;

/* loaded from: classes5.dex */
public class UB7 extends AbstractC24641yx5 {
    private long a;
    private int b;

    public UB7(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 7;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
        this.b = c9207Yy1.d();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.i(this.a);
        c12658ez1.h(this.b);
    }

    public long g() {
        return this.a;
    }

    public String toString() {
        return "UnsentMessage[" + this.a + "]";
    }
}
