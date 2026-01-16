package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class R0 extends D0 implements InterfaceC4984Hk0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a l = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a m = null;
    private int j;
    private int k;

    static {
        n();
    }

    protected R0(String str) {
        super(str);
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("AbstractFullBox.java", R0.class);
        l = c20224rf2.f("method-execution", c20224rf2.e("1", "setVersion", "com.googlecode.mp4parser.AbstractFullBox", "int", ParameterNames.VERSION, "", "void"), 51);
        m = c20224rf2.f("method-execution", c20224rf2.e("1", "setFlags", "com.googlecode.mp4parser.AbstractFullBox", "int", "flags", "", "void"), 64);
    }

    public int o() {
        if (!this.d) {
            l();
        }
        return this.k;
    }

    public int p() {
        if (!this.d) {
            l();
        }
        return this.j;
    }

    protected final long q(ByteBuffer byteBuffer) {
        this.j = AbstractC5635Ke3.m(byteBuffer);
        this.k = AbstractC5635Ke3.i(byteBuffer);
        return 4L;
    }

    public void r(int i) {
        C18943pW5.b().c(C20224rf2.d(m, this, this, AbstractC5480Jn1.d(i)));
        this.k = i;
    }

    public void s(int i) {
        C18943pW5.b().c(C20224rf2.d(l, this, this, AbstractC5480Jn1.d(i)));
        this.j = i;
    }

    protected final void t(ByteBuffer byteBuffer) {
        AbstractC5869Le3.j(byteBuffer, this.j);
        AbstractC5869Le3.f(byteBuffer, this.k);
    }
}
