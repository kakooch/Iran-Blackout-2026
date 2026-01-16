package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;
import java.util.Date;

/* renamed from: ir.nasim.pX3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C18950pX3 extends R0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a A = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a B = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a D = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a s = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a t = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a u = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a v = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a w = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a x = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a y = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a z = null;
    private Date n;
    private Date o;
    private long p;
    private long q;
    private String r;

    static {
        n();
    }

    public C18950pX3() {
        super("mdhd");
        this.n = new Date();
        this.o = new Date();
        this.r = "eng";
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("MediaHeaderBox.java", C18950pX3.class);
        s = c20224rf2.f("method-execution", c20224rf2.e("1", "getCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 46);
        t = c20224rf2.f("method-execution", c20224rf2.e("1", "getModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 50);
        D = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER);
        u = c20224rf2.f("method-execution", c20224rf2.e("1", "getTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 54);
        v = c20224rf2.f("method-execution", c20224rf2.e("1", "getDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 58);
        w = c20224rf2.f("method-execution", c20224rf2.e("1", "getLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 62);
        x = c20224rf2.f("method-execution", c20224rf2.e("1", "setCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 79);
        y = c20224rf2.f("method-execution", c20224rf2.e("1", "setModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 83);
        z = c20224rf2.f("method-execution", c20224rf2.e("1", "setTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "timescale", "", "void"), 87);
        A = c20224rf2.f("method-execution", c20224rf2.e("1", "setDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "duration", "", "void"), 91);
        B = c20224rf2.f("method-execution", c20224rf2.e("1", "setLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "java.lang.String", "language", "", "void"), 95);
    }

    public void A(long j) {
        C18943pW5.b().c(C20224rf2.d(A, this, this, AbstractC5480Jn1.e(j)));
        this.q = j;
    }

    public void B(String str) {
        C18943pW5.b().c(C20224rf2.d(B, this, this, str));
        this.r = str;
    }

    public void C(long j) {
        C18943pW5.b().c(C20224rf2.d(z, this, this, AbstractC5480Jn1.e(j)));
        this.p = j;
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        if (p() == 1) {
            this.n = AbstractC16377lA1.b(AbstractC5635Ke3.l(byteBuffer));
            this.o = AbstractC16377lA1.b(AbstractC5635Ke3.l(byteBuffer));
            this.p = AbstractC5635Ke3.j(byteBuffer);
            this.q = AbstractC5635Ke3.l(byteBuffer);
        } else {
            this.n = AbstractC16377lA1.b(AbstractC5635Ke3.j(byteBuffer));
            this.o = AbstractC16377lA1.b(AbstractC5635Ke3.j(byteBuffer));
            this.p = AbstractC5635Ke3.j(byteBuffer);
            this.q = AbstractC5635Ke3.j(byteBuffer);
        }
        this.r = AbstractC5635Ke3.f(byteBuffer);
        AbstractC5635Ke3.h(byteBuffer);
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        t(byteBuffer);
        if (p() == 1) {
            AbstractC5869Le3.i(byteBuffer, AbstractC16377lA1.a(this.n));
            AbstractC5869Le3.i(byteBuffer, AbstractC16377lA1.a(this.o));
            AbstractC5869Le3.g(byteBuffer, this.p);
            AbstractC5869Le3.i(byteBuffer, this.q);
        } else {
            AbstractC5869Le3.g(byteBuffer, AbstractC16377lA1.a(this.n));
            AbstractC5869Le3.g(byteBuffer, AbstractC16377lA1.a(this.o));
            AbstractC5869Le3.g(byteBuffer, this.p);
            AbstractC5869Le3.g(byteBuffer, this.q);
        }
        AbstractC5869Le3.d(byteBuffer, this.r);
        AbstractC5869Le3.e(byteBuffer, 0);
    }

    @Override // ir.nasim.D0
    protected long c() {
        return (p() == 1 ? 32L : 20L) + 4;
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(D, this, this));
        return "MediaHeaderBox[creationTime=" + u() + Separators.SEMICOLON + "modificationTime=" + x() + Separators.SEMICOLON + "timescale=" + y() + Separators.SEMICOLON + "duration=" + v() + Separators.SEMICOLON + "language=" + w() + "]";
    }

    public Date u() {
        C18943pW5.b().c(C20224rf2.c(s, this, this));
        return this.n;
    }

    public long v() {
        C18943pW5.b().c(C20224rf2.c(v, this, this));
        return this.q;
    }

    public String w() {
        C18943pW5.b().c(C20224rf2.c(w, this, this));
        return this.r;
    }

    public Date x() {
        C18943pW5.b().c(C20224rf2.c(t, this, this));
        return this.o;
    }

    public long y() {
        C18943pW5.b().c(C20224rf2.c(u, this, this));
        return this.p;
    }

    public void z(Date date) {
        C18943pW5.b().c(C20224rf2.d(x, this, this, date));
        this.n = date;
    }
}
