package ir.nasim;

/* renamed from: ir.nasim.yX5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C24386yX5 extends AbstractC24641yx5 {
    private long a;
    private byte[] b;
    private byte[] c;

    public C24386yX5(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) -25;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
        this.b = c9207Yy1.g();
        this.c = c9207Yy1.g();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.i(this.a);
        byte[] bArr = this.b;
        c12658ez1.k(bArr, 0, bArr.length);
        byte[] bArr2 = this.c;
        c12658ez1.k(bArr2, 0, bArr2.length);
    }

    public long g() {
        return this.a;
    }

    public byte[] h() {
        return this.c;
    }
}
