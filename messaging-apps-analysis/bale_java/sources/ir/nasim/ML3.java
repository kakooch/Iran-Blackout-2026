package ir.nasim;

/* loaded from: classes5.dex */
public class ML3 extends AbstractC24641yx5 {
    private long a;
    private byte[] b;

    public ML3(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 4;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
        this.b = c9207Yy1.g();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.i(this.a);
        byte[] bArr = this.b;
        c12658ez1.k(bArr, 0, bArr.length);
    }

    public long g() {
        return this.a;
    }

    public byte[] h() {
        return this.b;
    }

    public String toString() {
        return "ResponseBox [" + this.a + "]";
    }
}
