package ir.nasim;

/* loaded from: classes5.dex */
public class DV5 extends AbstractC24641yx5 {
    private long a;

    public DV5(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) -32;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.i(this.a);
    }

    public String toString() {
        return "RequestStartAuth{" + this.a + "}";
    }

    public DV5(long j) {
        this.a = j;
    }
}
