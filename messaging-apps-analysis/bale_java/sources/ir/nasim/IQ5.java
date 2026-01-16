package ir.nasim;

/* loaded from: classes5.dex */
public class IQ5 extends AbstractC24641yx5 {
    private long a;
    private long b;
    private byte[] c;
    private byte[] d;

    public IQ5(long j, long j2, byte[] bArr, byte[] bArr2) {
        this.a = j;
        this.b = j2;
        this.c = bArr;
        this.d = bArr2;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) -22;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
        this.b = c9207Yy1.e();
        this.c = c9207Yy1.g();
        this.d = c9207Yy1.g();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.i(this.a);
        c12658ez1.i(this.b);
        byte[] bArr = this.c;
        c12658ez1.k(bArr, 0, bArr.length);
        byte[] bArr2 = this.d;
        c12658ez1.k(bArr2, 0, bArr2.length);
    }
}
