package ir.nasim;

/* loaded from: classes5.dex */
public class B06 extends AbstractC24641yx5 {
    private long a;
    private long[] b;
    private byte[] c;

    public B06(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) -31;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
        this.b = c9207Yy1.h();
        this.c = c9207Yy1.g();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.i(this.a);
        c12658ez1.l(this.b);
        c12658ez1.f(this.c);
    }

    public long[] g() {
        return this.b;
    }

    public long h() {
        return this.a;
    }

    public byte[] i() {
        return this.c;
    }
}
