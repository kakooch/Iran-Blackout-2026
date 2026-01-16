package ir.nasim;

/* renamed from: ir.nasim.sy5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C21007sy5 extends AbstractC24641yx5 {
    public int a;
    public byte[] b;

    public C21007sy5(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    public byte d() {
        return (byte) 0;
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
        return "Update[" + this.a + "]";
    }
}
