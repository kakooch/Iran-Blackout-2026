package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class HH6 extends AbstractC17467n1 {
    private static final /* synthetic */ InterfaceC5446Jj3.a o = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a p = null;
    private float n;

    static {
        n();
    }

    public HH6() {
        super("smhd");
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("SoundMediaHeaderBox.java", HH6.class);
        o = c20224rf2.f("method-execution", c20224rf2.e("1", "getBalance", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "float"), 36);
        p = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "java.lang.String"), 58);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        this.n = AbstractC5635Ke3.e(byteBuffer);
        AbstractC5635Ke3.h(byteBuffer);
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        t(byteBuffer);
        AbstractC5869Le3.c(byteBuffer, this.n);
        AbstractC5869Le3.e(byteBuffer, 0);
    }

    @Override // ir.nasim.D0
    protected long c() {
        return 8L;
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(p, this, this));
        return "SoundMediaHeaderBox[balance=" + u() + "]";
    }

    public float u() {
        C18943pW5.b().c(C20224rf2.c(o, this, this));
        return this.n;
    }
}
