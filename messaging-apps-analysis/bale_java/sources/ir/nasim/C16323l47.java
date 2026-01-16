package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.l47, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C16323l47 extends R0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a o = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a p = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a q = null;
    private long[] n;

    static {
        n();
    }

    public C16323l47() {
        super("stss");
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("SyncSampleBox.java", C16323l47.class);
        o = c20224rf2.f("method-execution", c20224rf2.e("1", "getSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "[J"), 46);
        p = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "java.lang.String"), 77);
        q = c20224rf2.f("method-execution", c20224rf2.e("1", "setSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "[J", "sampleNumber", "", "void"), 81);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        int iA = CH0.a(AbstractC5635Ke3.j(byteBuffer));
        this.n = new long[iA];
        for (int i = 0; i < iA; i++) {
            this.n[i] = AbstractC5635Ke3.j(byteBuffer);
        }
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        t(byteBuffer);
        AbstractC5869Le3.g(byteBuffer, this.n.length);
        for (long j : this.n) {
            AbstractC5869Le3.g(byteBuffer, j);
        }
    }

    @Override // ir.nasim.D0
    protected long c() {
        return (this.n.length * 4) + 8;
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(p, this, this));
        return "SyncSampleBox[entryCount=" + this.n.length + "]";
    }

    public void u(long[] jArr) {
        C18943pW5.b().c(C20224rf2.d(q, this, this, jArr));
        this.n = jArr;
    }
}
