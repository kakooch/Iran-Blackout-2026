package ir.nasim;

/* renamed from: ir.nasim.i82, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C14574i82 extends AbstractC20998sx5 {
    private long a;
    private byte[] b;

    public C14574i82(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC20998sx5
    public AbstractC20998sx5 a(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
        this.b = c9207Yy1.g();
        return this;
    }

    @Override // ir.nasim.AbstractC20998sx5
    public void c(C12658ez1 c12658ez1) {
        c12658ez1.i(this.a);
        byte[] bArr = this.b;
        c12658ez1.k(bArr, 0, bArr.length);
    }

    public byte[] d() {
        return this.b;
    }

    public long e() {
        return this.a;
    }

    public C14574i82(long j, byte[] bArr) {
        this.a = j;
        this.b = bArr;
    }
}
