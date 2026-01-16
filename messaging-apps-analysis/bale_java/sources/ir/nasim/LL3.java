package ir.nasim;

/* loaded from: classes5.dex */
public class LL3 extends AbstractC24641yx5 {
    public byte[] a;

    public LL3(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 3;
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

    public String toString() {
        return "RequestBox";
    }

    public LL3(byte[] bArr) {
        this.a = bArr;
    }
}
