package ir.nasim;

import java.io.UnsupportedEncodingException;

/* renamed from: ir.nasim.f12, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C12679f12 extends AbstractC24641yx5 {
    public long a;
    public String b;

    public C12679f12(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 13;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
        this.b = c9207Yy1.i();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) throws UnsupportedEncodingException {
        c12658ez1.i(this.a);
        c12658ez1.m(this.b);
    }

    public String toString() {
        return "Drop[" + this.b + "]";
    }
}
