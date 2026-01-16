package ir.nasim;

/* renamed from: ir.nasim.hZ5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C14224hZ5 extends AbstractC24641yx5 {
    private long a;
    private byte[] b;

    public C14224hZ5(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) -29;
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

    public byte[] g() {
        return this.b;
    }

    public long h() {
        return this.a;
    }
}
