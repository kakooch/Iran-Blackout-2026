package ir.nasim;

/* renamed from: ir.nasim.g82, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C13385g82 extends AbstractC20998sx5 {
    private byte[] a;
    private byte[] b;

    public C13385g82(byte[] bArr, byte[] bArr2) {
        this.a = bArr;
        this.b = bArr2;
    }

    @Override // ir.nasim.AbstractC20998sx5
    public AbstractC20998sx5 a(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.g();
        this.b = c9207Yy1.g();
        return this;
    }

    @Override // ir.nasim.AbstractC20998sx5
    public void c(C12658ez1 c12658ez1) {
        byte[] bArr = this.a;
        c12658ez1.k(bArr, 0, bArr.length);
        byte[] bArr2 = this.b;
        c12658ez1.k(bArr2, 0, bArr2.length);
    }

    public byte[] d() {
        return this.b;
    }

    public byte[] e() {
        return this.a;
    }

    public C13385g82(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }
}
