package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.fa6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13025fa6 extends R0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a q = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a r = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a s = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a t = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a u = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a v = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a w = null;
    private long n;
    private long[] o;
    int p;

    static {
        n();
    }

    public C13025fa6() {
        super("stsz");
        this.o = new long[0];
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("SampleSizeBox.java", C13025fa6.class);
        q = c20224rf2.f("method-execution", c20224rf2.e("1", "getSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 50);
        r = c20224rf2.f("method-execution", c20224rf2.e("1", "setSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "long", "sampleSize", "", "void"), 54);
        s = c20224rf2.f("method-execution", c20224rf2.e("1", "getSampleSizeAtIndex", "com.coremedia.iso.boxes.SampleSizeBox", "int", "index", "", "long"), 59);
        t = c20224rf2.f("method-execution", c20224rf2.e("1", "getSampleCount", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 67);
        u = c20224rf2.f("method-execution", c20224rf2.e("1", "getSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "[J"), 76);
        v = c20224rf2.f("method-execution", c20224rf2.e("1", "setSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
        w = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "java.lang.String"), 119);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        this.n = AbstractC5635Ke3.j(byteBuffer);
        int iA = CH0.a(AbstractC5635Ke3.j(byteBuffer));
        this.p = iA;
        if (this.n == 0) {
            this.o = new long[iA];
            for (int i = 0; i < this.p; i++) {
                this.o[i] = AbstractC5635Ke3.j(byteBuffer);
            }
        }
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        t(byteBuffer);
        AbstractC5869Le3.g(byteBuffer, this.n);
        if (this.n != 0) {
            AbstractC5869Le3.g(byteBuffer, this.p);
            return;
        }
        AbstractC5869Le3.g(byteBuffer, this.o.length);
        for (long j : this.o) {
            AbstractC5869Le3.g(byteBuffer, j);
        }
    }

    @Override // ir.nasim.D0
    protected long c() {
        return (this.n == 0 ? this.o.length * 4 : 0) + 12;
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(w, this, this));
        return "SampleSizeBox[sampleSize=" + v() + ";sampleCount=" + u() + "]";
    }

    public long u() {
        C18943pW5.b().c(C20224rf2.c(t, this, this));
        return this.n > 0 ? this.p : this.o.length;
    }

    public long v() {
        C18943pW5.b().c(C20224rf2.c(q, this, this));
        return this.n;
    }

    public void w(long[] jArr) {
        C18943pW5.b().c(C20224rf2.d(v, this, this, jArr));
        this.o = jArr;
    }
}
