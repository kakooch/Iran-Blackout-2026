package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;
import java.util.Date;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.vk4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C22736vk4 extends R0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a A0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a B = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a B0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a C0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a D = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a D0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a E0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a F0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a G = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a G0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a H = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a H0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a I0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a J = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a J0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a K0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a L0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a M0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a N0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a O0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a P0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a Q0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a R0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a S0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a T0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a U0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a Y = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a Z = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a z0 = null;
    private int A;
    private Date n;
    private Date o;
    private long p;
    private long q;
    private double r;
    private float s;
    private BV3 t;
    private long u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    static {
        n();
    }

    public C22736vk4() {
        super("mvhd");
        this.r = 1.0d;
        this.s = 1.0f;
        this.t = BV3.j;
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("MovieHeaderBox.java", C22736vk4.class);
        B = c20224rf2.f("method-execution", c20224rf2.e("1", "getCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 63);
        D = c20224rf2.f("method-execution", c20224rf2.e("1", "getModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 67);
        C0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 203);
        D0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "timescale", "", "void"), 211);
        E0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "duration", "", "void"), 215);
        F0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setRate", "com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), 222);
        G0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "float", "volume", "", "void"), 226);
        H0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER);
        I0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "nextTrackId", "", "void"), SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER);
        J0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER);
        K0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), 242);
        L0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER);
        G = c20224rf2.f("method-execution", c20224rf2.e("1", "getTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 71);
        M0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), Type.TSIG);
        N0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 254);
        O0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), Type.AVC);
        P0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 262);
        Q0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 266);
        R0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 270);
        S0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 274);
        T0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 278);
        U0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "currentTime", "", "void"), 282);
        H = c20224rf2.f("method-execution", c20224rf2.e("1", "getDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 75);
        J = c20224rf2.f("method-execution", c20224rf2.e("1", "getRate", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 79);
        Y = c20224rf2.f("method-execution", c20224rf2.e("1", "getVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "float"), 83);
        Z = c20224rf2.f("method-execution", c20224rf2.e("1", "getMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 87);
        z0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 91);
        A0 = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.lang.String"), WKSRecord.Service.NETBIOS_SSN);
        B0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), 195);
    }

    public float A() {
        C18943pW5.b().c(C20224rf2.c(Y, this, this));
        return this.s;
    }

    public void B(Date date) {
        C18943pW5.b().c(C20224rf2.d(B0, this, this, date));
        this.n = date;
        if (AbstractC16377lA1.a(date) >= 4294967296L) {
            s(1);
        }
    }

    public void C(long j) {
        C18943pW5.b().c(C20224rf2.d(E0, this, this, AbstractC5480Jn1.e(j)));
        this.q = j;
        if (j >= 4294967296L) {
            s(1);
        }
    }

    public void D(BV3 bv3) {
        C18943pW5.b().c(C20224rf2.d(H0, this, this, bv3));
        this.t = bv3;
    }

    public void E(Date date) {
        C18943pW5.b().c(C20224rf2.d(C0, this, this, date));
        this.o = date;
        if (AbstractC16377lA1.a(date) >= 4294967296L) {
            s(1);
        }
    }

    public void F(long j) {
        C18943pW5.b().c(C20224rf2.d(I0, this, this, AbstractC5480Jn1.e(j)));
        this.u = j;
    }

    public void G(long j) {
        C18943pW5.b().c(C20224rf2.d(D0, this, this, AbstractC5480Jn1.e(j)));
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
        this.r = AbstractC5635Ke3.d(byteBuffer);
        this.s = AbstractC5635Ke3.e(byteBuffer);
        AbstractC5635Ke3.h(byteBuffer);
        AbstractC5635Ke3.j(byteBuffer);
        AbstractC5635Ke3.j(byteBuffer);
        this.t = BV3.a(byteBuffer);
        this.v = byteBuffer.getInt();
        this.w = byteBuffer.getInt();
        this.x = byteBuffer.getInt();
        this.y = byteBuffer.getInt();
        this.z = byteBuffer.getInt();
        this.A = byteBuffer.getInt();
        this.u = AbstractC5635Ke3.j(byteBuffer);
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
        AbstractC5869Le3.b(byteBuffer, this.r);
        AbstractC5869Le3.c(byteBuffer, this.s);
        AbstractC5869Le3.e(byteBuffer, 0);
        AbstractC5869Le3.g(byteBuffer, 0L);
        AbstractC5869Le3.g(byteBuffer, 0L);
        this.t.c(byteBuffer);
        byteBuffer.putInt(this.v);
        byteBuffer.putInt(this.w);
        byteBuffer.putInt(this.x);
        byteBuffer.putInt(this.y);
        byteBuffer.putInt(this.z);
        byteBuffer.putInt(this.A);
        AbstractC5869Le3.g(byteBuffer, this.u);
    }

    @Override // ir.nasim.D0
    protected long c() {
        return (p() == 1 ? 32L : 20L) + 80;
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(A0, this, this));
        return "MovieHeaderBox[creationTime=" + u() + Separators.SEMICOLON + "modificationTime=" + w() + Separators.SEMICOLON + "timescale=" + z() + Separators.SEMICOLON + "duration=" + v() + Separators.SEMICOLON + "rate=" + y() + Separators.SEMICOLON + "volume=" + A() + Separators.SEMICOLON + "matrix=" + this.t + Separators.SEMICOLON + "nextTrackId=" + x() + "]";
    }

    public Date u() {
        C18943pW5.b().c(C20224rf2.c(B, this, this));
        return this.n;
    }

    public long v() {
        C18943pW5.b().c(C20224rf2.c(H, this, this));
        return this.q;
    }

    public Date w() {
        C18943pW5.b().c(C20224rf2.c(D, this, this));
        return this.o;
    }

    public long x() {
        C18943pW5.b().c(C20224rf2.c(z0, this, this));
        return this.u;
    }

    public double y() {
        C18943pW5.b().c(C20224rf2.c(J, this, this));
        return this.r;
    }

    public long z() {
        C18943pW5.b().c(C20224rf2.c(G, this, this));
        return this.p;
    }
}
