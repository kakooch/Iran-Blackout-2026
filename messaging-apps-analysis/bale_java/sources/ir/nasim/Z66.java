package ir.nasim;

/* loaded from: classes5.dex */
public class Z66 extends AbstractC24641yx5 {
    public int a;
    public byte[] b;

    public Z66(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 1;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.d();
        this.b = c9207Yy1.g();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.h(this.a);
        byte[] bArr = this.b;
        c12658ez1.k(bArr, 0, bArr.length);
    }

    public String toString() {
        return "RpcOk{" + this.a + "]";
    }
}
