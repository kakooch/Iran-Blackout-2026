package ir.nasim;

/* renamed from: ir.nasim.Bw4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C3677Bw4 extends AbstractC24641yx5 {
    public long a;
    public long b;

    public C3677Bw4(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 12;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
        this.b = c9207Yy1.e();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.i(this.a);
        c12658ez1.i(this.b);
    }

    public long g() {
        return this.b;
    }

    public String toString() {
        return "NewSession {" + this.a + "}";
    }
}
