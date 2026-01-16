package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class UL6 extends MT0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a p = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a q = null;
    private long[] o;

    static {
        n();
    }

    public UL6() {
        super("stco");
        this.o = new long[0];
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("StaticChunkOffsetBox.java", UL6.class);
        p = c20224rf2.f("method-execution", c20224rf2.e("1", "getChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "", "", "", "[J"), 39);
        q = c20224rf2.f("method-execution", c20224rf2.e("1", "setChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "[J", "chunkOffsets", "", "void"), 48);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        int iA = CH0.a(AbstractC5635Ke3.j(byteBuffer));
        this.o = new long[iA];
        for (int i = 0; i < iA; i++) {
            this.o[i] = AbstractC5635Ke3.j(byteBuffer);
        }
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        t(byteBuffer);
        AbstractC5869Le3.g(byteBuffer, this.o.length);
        for (long j : this.o) {
            AbstractC5869Le3.g(byteBuffer, j);
        }
    }

    @Override // ir.nasim.D0
    protected long c() {
        return (this.o.length * 4) + 8;
    }

    @Override // ir.nasim.MT0
    public long[] u() {
        C18943pW5.b().c(C20224rf2.c(p, this, this));
        return this.o;
    }

    public void v(long[] jArr) {
        C18943pW5.b().c(C20224rf2.d(q, this, this, jArr));
        this.o = jArr;
    }
}
