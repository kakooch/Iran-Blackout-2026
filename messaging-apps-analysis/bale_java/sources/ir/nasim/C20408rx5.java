package ir.nasim;

/* renamed from: ir.nasim.rx5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20408rx5 extends AbstractC20998sx5 {
    private long a;
    private byte[] b;

    public C20408rx5(long j, byte[] bArr) {
        this.a = j;
        this.b = bArr;
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

    public long d() {
        return this.a;
    }

    public byte[] e() {
        return this.b;
    }

    public String toString() {
        return "ProtoMessage [#" + this.a + "]";
    }

    public C20408rx5(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }
}
