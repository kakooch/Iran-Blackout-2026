package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: ir.nasim.Gm2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4770Gm2 extends D0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a m = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a n = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a o = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a p = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a q = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a r = null;
    private String j;
    private long k;
    private List l;

    static {
        n();
    }

    public C4770Gm2(String str, long j, List list) {
        super("ftyp");
        Collections.emptyList();
        this.j = str;
        this.k = j;
        this.l = list;
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("FileTypeBox.java", C4770Gm2.class);
        m = c20224rf2.f("method-execution", c20224rf2.e("1", "getMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.lang.String"), 85);
        n = c20224rf2.f("method-execution", c20224rf2.e("1", "setMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        o = c20224rf2.f("method-execution", c20224rf2.e("1", "setMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", "long", "minorVersion", "", "void"), 103);
        p = c20224rf2.f("method-execution", c20224rf2.e("1", "getMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "long"), 113);
        q = c20224rf2.f("method-execution", c20224rf2.e("1", "getCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.util.List"), 122);
        r = c20224rf2.f("method-execution", c20224rf2.e("1", "setCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        this.j = AbstractC5635Ke3.b(byteBuffer);
        this.k = AbstractC5635Ke3.j(byteBuffer);
        int iRemaining = byteBuffer.remaining() / 4;
        this.l = new LinkedList();
        for (int i = 0; i < iRemaining; i++) {
            this.l.add(AbstractC5635Ke3.b(byteBuffer));
        }
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        byteBuffer.put(AbstractC5401Je3.l(this.j));
        AbstractC5869Le3.g(byteBuffer, this.k);
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            byteBuffer.put(AbstractC5401Je3.l((String) it.next()));
        }
    }

    @Override // ir.nasim.D0
    protected long c() {
        return (this.l.size() * 4) + 8;
    }

    public String o() {
        C18943pW5.b().c(C20224rf2.c(m, this, this));
        return this.j;
    }

    public long p() {
        C18943pW5.b().c(C20224rf2.c(p, this, this));
        return this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileTypeBox[");
        sb.append("majorBrand=");
        sb.append(o());
        sb.append(Separators.SEMICOLON);
        sb.append("minorVersion=");
        sb.append(p());
        for (String str : this.l) {
            sb.append(Separators.SEMICOLON);
            sb.append("compatibleBrand=");
            sb.append(str);
        }
        sb.append("]");
        return sb.toString();
    }
}
