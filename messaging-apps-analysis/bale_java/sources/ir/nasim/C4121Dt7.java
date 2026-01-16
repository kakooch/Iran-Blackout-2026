package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;
import java.util.Date;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.Dt7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4121Dt7 extends R0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a A = null;
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
    private static final /* synthetic */ InterfaceC5446Jj3.a Y = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a Z = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a x = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a y = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a z = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a z0 = null;
    private Date n;
    private Date o;
    private long p;
    private long q;
    private int r;
    private int s;
    private float t;
    private BV3 u;
    private double v;
    private double w;

    static {
        n();
    }

    public C4121Dt7() {
        super("tkhd");
        this.u = BV3.j;
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("TrackHeaderBox.java", C4121Dt7.class);
        x = c20224rf2.f("method-execution", c20224rf2.e("1", "getCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 60);
        y = c20224rf2.f("method-execution", c20224rf2.e("1", "getModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 64);
        Z = c20224rf2.f("method-execution", c20224rf2.e("1", "getContent", "com.coremedia.iso.boxes.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), WKSRecord.Service.BL_IDM);
        z0 = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.lang.String"), 170);
        A0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 196);
        B0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 203);
        C0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "trackId", "", "void"), 211);
        D0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "duration", "", "void"), 215);
        E0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "layer", "", "void"), 222);
        F0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "alternateGroup", "", "void"), 226);
        G0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "float", "volume", "", "void"), SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER);
        H0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER);
        z = c20224rf2.f("method-execution", c20224rf2.e("1", "getTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 68);
        I0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "width", "", "void"), SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER);
        J0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "height", "", "void"), 242);
        K0 = c20224rf2.f("method-execution", c20224rf2.e("1", "isEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), SetRpcStruct$ComposedRpc.RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER);
        L0 = c20224rf2.f("method-execution", c20224rf2.e("1", "isInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), Type.IXFR);
        M0 = c20224rf2.f("method-execution", c20224rf2.e("1", "isInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 255);
        N0 = c20224rf2.f("method-execution", c20224rf2.e("1", "isInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), Type.DOA);
        O0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "enabled", "", "void"), 263);
        P0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inMovie", "", "void"), 271);
        Q0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPreview", "", "void"), 279);
        R0 = c20224rf2.f("method-execution", c20224rf2.e("1", "setInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPoster", "", "void"), 287);
        A = c20224rf2.f("method-execution", c20224rf2.e("1", "getDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 72);
        B = c20224rf2.f("method-execution", c20224rf2.e("1", "getLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 76);
        D = c20224rf2.f("method-execution", c20224rf2.e("1", "getAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 80);
        G = c20224rf2.f("method-execution", c20224rf2.e("1", "getVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "float"), 84);
        H = c20224rf2.f("method-execution", c20224rf2.e("1", "getMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 88);
        J = c20224rf2.f("method-execution", c20224rf2.e("1", "getWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 92);
        Y = c20224rf2.f("method-execution", c20224rf2.e("1", "getHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 96);
    }

    public long A() {
        C18943pW5.b().c(C20224rf2.c(z, this, this));
        return this.p;
    }

    public float B() {
        C18943pW5.b().c(C20224rf2.c(G, this, this));
        return this.t;
    }

    public double C() {
        C18943pW5.b().c(C20224rf2.c(J, this, this));
        return this.v;
    }

    public void D(int i) {
        C18943pW5.b().c(C20224rf2.d(F0, this, this, AbstractC5480Jn1.d(i)));
        this.s = i;
    }

    public void E(Date date) {
        C18943pW5.b().c(C20224rf2.d(A0, this, this, date));
        this.n = date;
        if (AbstractC16377lA1.a(date) >= 4294967296L) {
            s(1);
        }
    }

    public void F(long j) {
        C18943pW5.b().c(C20224rf2.d(D0, this, this, AbstractC5480Jn1.e(j)));
        this.q = j;
        if (j >= 4294967296L) {
            r(1);
        }
    }

    public void G(boolean z2) {
        C18943pW5.b().c(C20224rf2.d(O0, this, this, AbstractC5480Jn1.a(z2)));
        if (z2) {
            r(o() | 1);
        } else {
            r(o() & (-2));
        }
    }

    public void H(double d) {
        C18943pW5.b().c(C20224rf2.d(J0, this, this, AbstractC5480Jn1.b(d)));
        this.w = d;
    }

    public void I(boolean z2) {
        C18943pW5.b().c(C20224rf2.d(P0, this, this, AbstractC5480Jn1.a(z2)));
        if (z2) {
            r(o() | 2);
        } else {
            r(o() & (-3));
        }
    }

    public void J(boolean z2) {
        C18943pW5.b().c(C20224rf2.d(Q0, this, this, AbstractC5480Jn1.a(z2)));
        if (z2) {
            r(o() | 4);
        } else {
            r(o() & (-5));
        }
    }

    public void K(int i) {
        C18943pW5.b().c(C20224rf2.d(E0, this, this, AbstractC5480Jn1.d(i)));
        this.r = i;
    }

    public void L(BV3 bv3) {
        C18943pW5.b().c(C20224rf2.d(H0, this, this, bv3));
        this.u = bv3;
    }

    public void M(Date date) {
        C18943pW5.b().c(C20224rf2.d(B0, this, this, date));
        this.o = date;
        if (AbstractC16377lA1.a(date) >= 4294967296L) {
            s(1);
        }
    }

    public void N(long j) {
        C18943pW5.b().c(C20224rf2.d(C0, this, this, AbstractC5480Jn1.e(j)));
        this.p = j;
    }

    public void O(float f) {
        C18943pW5.b().c(C20224rf2.d(G0, this, this, AbstractC5480Jn1.c(f)));
        this.t = f;
    }

    public void P(double d) {
        C18943pW5.b().c(C20224rf2.d(I0, this, this, AbstractC5480Jn1.b(d)));
        this.v = d;
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        if (p() == 1) {
            this.n = AbstractC16377lA1.b(AbstractC5635Ke3.l(byteBuffer));
            this.o = AbstractC16377lA1.b(AbstractC5635Ke3.l(byteBuffer));
            this.p = AbstractC5635Ke3.j(byteBuffer);
            AbstractC5635Ke3.j(byteBuffer);
            long j = byteBuffer.getLong();
            this.q = j;
            if (j < -1) {
                throw new RuntimeException("The tracks duration is bigger than Long.MAX_VALUE");
            }
        } else {
            this.n = AbstractC16377lA1.b(AbstractC5635Ke3.j(byteBuffer));
            this.o = AbstractC16377lA1.b(AbstractC5635Ke3.j(byteBuffer));
            this.p = AbstractC5635Ke3.j(byteBuffer);
            AbstractC5635Ke3.j(byteBuffer);
            this.q = AbstractC5635Ke3.j(byteBuffer);
        }
        AbstractC5635Ke3.j(byteBuffer);
        AbstractC5635Ke3.j(byteBuffer);
        this.r = AbstractC5635Ke3.h(byteBuffer);
        this.s = AbstractC5635Ke3.h(byteBuffer);
        this.t = AbstractC5635Ke3.e(byteBuffer);
        AbstractC5635Ke3.h(byteBuffer);
        this.u = BV3.a(byteBuffer);
        this.v = AbstractC5635Ke3.d(byteBuffer);
        this.w = AbstractC5635Ke3.d(byteBuffer);
    }

    @Override // ir.nasim.D0
    public void b(ByteBuffer byteBuffer) {
        C18943pW5.b().c(C20224rf2.d(Z, this, this, byteBuffer));
        t(byteBuffer);
        if (p() == 1) {
            AbstractC5869Le3.i(byteBuffer, AbstractC16377lA1.a(this.n));
            AbstractC5869Le3.i(byteBuffer, AbstractC16377lA1.a(this.o));
            AbstractC5869Le3.g(byteBuffer, this.p);
            AbstractC5869Le3.g(byteBuffer, 0L);
            AbstractC5869Le3.i(byteBuffer, this.q);
        } else {
            AbstractC5869Le3.g(byteBuffer, AbstractC16377lA1.a(this.n));
            AbstractC5869Le3.g(byteBuffer, AbstractC16377lA1.a(this.o));
            AbstractC5869Le3.g(byteBuffer, this.p);
            AbstractC5869Le3.g(byteBuffer, 0L);
            AbstractC5869Le3.g(byteBuffer, this.q);
        }
        AbstractC5869Le3.g(byteBuffer, 0L);
        AbstractC5869Le3.g(byteBuffer, 0L);
        AbstractC5869Le3.e(byteBuffer, this.r);
        AbstractC5869Le3.e(byteBuffer, this.s);
        AbstractC5869Le3.c(byteBuffer, this.t);
        AbstractC5869Le3.e(byteBuffer, 0);
        this.u.c(byteBuffer);
        AbstractC5869Le3.b(byteBuffer, this.v);
        AbstractC5869Le3.b(byteBuffer, this.w);
    }

    @Override // ir.nasim.D0
    protected long c() {
        return (p() == 1 ? 36L : 24L) + 60;
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(z0, this, this));
        return "TrackHeaderBox[creationTime=" + v() + Separators.SEMICOLON + "modificationTime=" + z() + Separators.SEMICOLON + "trackId=" + A() + Separators.SEMICOLON + "duration=" + w() + Separators.SEMICOLON + "layer=" + y() + Separators.SEMICOLON + "alternateGroup=" + u() + Separators.SEMICOLON + "volume=" + B() + Separators.SEMICOLON + "matrix=" + this.u + Separators.SEMICOLON + "width=" + C() + Separators.SEMICOLON + "height=" + x() + "]";
    }

    public int u() {
        C18943pW5.b().c(C20224rf2.c(D, this, this));
        return this.s;
    }

    public Date v() {
        C18943pW5.b().c(C20224rf2.c(x, this, this));
        return this.n;
    }

    public long w() {
        C18943pW5.b().c(C20224rf2.c(A, this, this));
        return this.q;
    }

    public double x() {
        C18943pW5.b().c(C20224rf2.c(Y, this, this));
        return this.w;
    }

    public int y() {
        C18943pW5.b().c(C20224rf2.c(B, this, this));
        return this.r;
    }

    public Date z() {
        C18943pW5.b().c(C20224rf2.c(y, this, this));
        return this.o;
    }
}
