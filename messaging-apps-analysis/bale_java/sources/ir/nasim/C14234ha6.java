package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.ha6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C14234ha6 extends R0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a o = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a p = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a q = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a r = null;
    List n;

    /* renamed from: ir.nasim.ha6$a */
    public static class a {
        long a;
        long b;
        long c;

        public a(long j, long j2, long j3) {
            this.a = j;
            this.b = j2;
            this.c = j3;
        }

        public long a() {
            return this.a;
        }

        public long b() {
            return this.c;
        }

        public long c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.c == aVar.c && this.b == aVar.b;
        }

        public int hashCode() {
            long j = this.a;
            long j2 = this.b;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.c;
            return i + ((int) ((j3 >>> 32) ^ j3));
        }

        public String toString() {
            return "Entry{firstChunk=" + this.a + ", samplesPerChunk=" + this.b + ", sampleDescriptionIndex=" + this.c + '}';
        }
    }

    static {
        n();
    }

    public C14234ha6() {
        super("stsc");
        this.n = Collections.emptyList();
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("SampleToChunkBox.java", C14234ha6.class);
        o = c20224rf2.f("method-execution", c20224rf2.e("1", "getEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.util.List"), 47);
        p = c20224rf2.f("method-execution", c20224rf2.e("1", "setEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "java.util.List", "entries", "", "void"), 51);
        q = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.lang.String"), 84);
        r = c20224rf2.f("method-execution", c20224rf2.e("1", "blowup", "com.coremedia.iso.boxes.SampleToChunkBox", "int", "chunkCount", "", "[J"), 95);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        int iA = CH0.a(AbstractC5635Ke3.j(byteBuffer));
        this.n = new ArrayList(iA);
        for (int i = 0; i < iA; i++) {
            this.n.add(new a(AbstractC5635Ke3.j(byteBuffer), AbstractC5635Ke3.j(byteBuffer), AbstractC5635Ke3.j(byteBuffer)));
        }
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        t(byteBuffer);
        AbstractC5869Le3.g(byteBuffer, this.n.size());
        for (a aVar : this.n) {
            AbstractC5869Le3.g(byteBuffer, aVar.a());
            AbstractC5869Le3.g(byteBuffer, aVar.c());
            AbstractC5869Le3.g(byteBuffer, aVar.b());
        }
    }

    @Override // ir.nasim.D0
    protected long c() {
        return (this.n.size() * 12) + 8;
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(q, this, this));
        return "SampleToChunkBox[entryCount=" + this.n.size() + "]";
    }

    public List u() {
        C18943pW5.b().c(C20224rf2.c(o, this, this));
        return this.n;
    }

    public void v(List list) {
        C18943pW5.b().c(C20224rf2.d(p, this, this, list));
        this.n = list;
    }
}
