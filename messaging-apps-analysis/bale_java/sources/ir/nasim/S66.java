package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.UnsupportedEncodingException;

/* loaded from: classes5.dex */
public class S66 extends AbstractC24641yx5 {
    public int a;
    public String b;
    public String c;
    public boolean d;
    public byte[] e;

    public S66(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 2;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.d();
        this.b = c9207Yy1.i();
        this.c = c9207Yy1.i();
        this.d = c9207Yy1.f();
        this.e = c9207Yy1.g();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) throws UnsupportedEncodingException {
        c12658ez1.h(this.a);
        c12658ez1.m(this.b);
        c12658ez1.m(this.c);
        c12658ez1.j(this.d);
        byte[] bArr = this.e;
        c12658ez1.k(bArr, 0, bArr.length);
    }

    public String toString() {
        return "RpcError [#" + this.a + Separators.SP + this.b + "]";
    }
}
