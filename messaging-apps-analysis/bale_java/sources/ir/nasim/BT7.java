package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class BT7 extends AbstractC17467n1 {
    private static final /* synthetic */ InterfaceC5446Jj3.a p = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a q = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a r = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a s = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a t = null;
    private int n;
    private int[] o;

    static {
        n();
    }

    public BT7() {
        super("vmhd");
        this.n = 0;
        this.o = new int[3];
        r(1);
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("VideoMediaHeaderBox.java", BT7.class);
        p = c20224rf2.f("method-execution", c20224rf2.e("1", "getGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "int"), 39);
        q = c20224rf2.f("method-execution", c20224rf2.e("1", "getOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "[I"), 43);
        r = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "java.lang.String"), 71);
        s = c20224rf2.f("method-execution", c20224rf2.e("1", "setOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "[I", "opcolor", "", "void"), 75);
        t = c20224rf2.f("method-execution", c20224rf2.e("1", "setGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "int", "graphicsmode", "", "void"), 79);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        this.n = AbstractC5635Ke3.h(byteBuffer);
        this.o = new int[3];
        for (int i = 0; i < 3; i++) {
            this.o[i] = AbstractC5635Ke3.h(byteBuffer);
        }
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        t(byteBuffer);
        AbstractC5869Le3.e(byteBuffer, this.n);
        for (int i : this.o) {
            AbstractC5869Le3.e(byteBuffer, i);
        }
    }

    @Override // ir.nasim.D0
    protected long c() {
        return 12L;
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(r, this, this));
        return "VideoMediaHeaderBox[graphicsmode=" + u() + ";opcolor0=" + v()[0] + ";opcolor1=" + v()[1] + ";opcolor2=" + v()[2] + "]";
    }

    public int u() {
        C18943pW5.b().c(C20224rf2.c(p, this, this));
        return this.n;
    }

    public int[] v() {
        C18943pW5.b().c(C20224rf2.c(q, this, this));
        return this.o;
    }
}
