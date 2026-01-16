package ir.nasim;

/* loaded from: classes5.dex */
public class KL3 extends AbstractC24641yx5 {
    private byte[] a;

    public KL3(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 5;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.g();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        byte[] bArr = this.a;
        c12658ez1.k(bArr, 0, bArr.length);
    }

    public byte[] g() {
        return this.a;
    }

    public String toString() {
        return "UpdateBox";
    }
}
