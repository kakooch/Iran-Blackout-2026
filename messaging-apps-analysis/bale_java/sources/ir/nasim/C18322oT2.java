package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.oT2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C18322oT2 extends R0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a A = null;
    public static final Map u;
    private static final /* synthetic */ InterfaceC5446Jj3.a v = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a w = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a x = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a y = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a z = null;
    private String n;
    private String o;
    private long p;
    private long q;
    private long r;
    private boolean s;
    private long t;

    static {
        n();
        HashMap map = new HashMap();
        map.put("odsm", "ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("crsm", "ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("sdsm", "SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("m7sm", "MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("ocsm", "ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("ipsm", "IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("mjsm", "MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("mdir", "Apple Meta Data iTunes Reader");
        map.put("mp7b", "MPEG-7 binary XML");
        map.put("mp7t", "MPEG-7 XML");
        map.put("vide", "Video Track");
        map.put("soun", "Sound Track");
        map.put("hint", "Hint Track");
        map.put("appl", "Apple specific");
        map.put("meta", "Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        u = Collections.unmodifiableMap(map);
    }

    public C18322oT2() {
        super("hdlr");
        this.o = null;
        this.s = true;
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("HandlerBox.java", C18322oT2.class);
        v = c20224rf2.f("method-execution", c20224rf2.e("1", "getHandlerType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 78);
        w = c20224rf2.f("method-execution", c20224rf2.e("1", "setName", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "name", "", "void"), 87);
        x = c20224rf2.f("method-execution", c20224rf2.e("1", "setHandlerType", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "handlerType", "", "void"), 91);
        y = c20224rf2.f("method-execution", c20224rf2.e("1", "getName", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 95);
        z = c20224rf2.f("method-execution", c20224rf2.e("1", "getHumanReadableTrackType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 99);
        A = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 149);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        this.t = AbstractC5635Ke3.j(byteBuffer);
        this.n = AbstractC5635Ke3.b(byteBuffer);
        this.p = AbstractC5635Ke3.j(byteBuffer);
        this.q = AbstractC5635Ke3.j(byteBuffer);
        this.r = AbstractC5635Ke3.j(byteBuffer);
        if (byteBuffer.remaining() <= 0) {
            this.s = false;
            return;
        }
        String strG = AbstractC5635Ke3.g(byteBuffer, byteBuffer.remaining());
        this.o = strG;
        if (!strG.endsWith("\u0000")) {
            this.s = false;
            return;
        }
        String str = this.o;
        this.o = str.substring(0, str.length() - 1);
        this.s = true;
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        t(byteBuffer);
        AbstractC5869Le3.g(byteBuffer, this.t);
        byteBuffer.put(AbstractC5401Je3.l(this.n));
        AbstractC5869Le3.g(byteBuffer, this.p);
        AbstractC5869Le3.g(byteBuffer, this.q);
        AbstractC5869Le3.g(byteBuffer, this.r);
        String str = this.o;
        if (str != null) {
            byteBuffer.put(PM7.b(str));
        }
        if (this.s) {
            byteBuffer.put((byte) 0);
        }
    }

    @Override // ir.nasim.D0
    protected long c() {
        return this.s ? PM7.c(this.o) + 25 : PM7.c(this.o) + 24;
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(A, this, this));
        return "HandlerBox[handlerType=" + u() + ";name=" + v() + "]";
    }

    public String u() {
        C18943pW5.b().c(C20224rf2.c(v, this, this));
        return this.n;
    }

    public String v() {
        C18943pW5.b().c(C20224rf2.c(y, this, this));
        return this.o;
    }

    public void w(String str) {
        C18943pW5.b().c(C20224rf2.d(x, this, this, str));
        this.n = str;
    }

    public void x(String str) {
        C18943pW5.b().c(C20224rf2.d(w, this, this, str));
        this.o = str;
    }
}
