package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: ir.nasim.mq7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17368mq7 extends R0 {
    static Map o;
    private static final /* synthetic */ InterfaceC5446Jj3.a p = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a q = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a r = null;
    List n;

    /* renamed from: ir.nasim.mq7$a */
    public static class a {
        long a;
        long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public long a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public void c(long j) {
            this.a = j;
        }

        public String toString() {
            return "Entry{count=" + this.a + ", delta=" + this.b + '}';
        }
    }

    static {
        n();
        o = new WeakHashMap();
    }

    public C17368mq7() {
        super("stts");
        this.n = Collections.emptyList();
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("TimeToSampleBox.java", C17368mq7.class);
        p = c20224rf2.f("method-execution", c20224rf2.e("1", "getEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.util.List"), 79);
        q = c20224rf2.f("method-execution", c20224rf2.e("1", "setEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "java.util.List", "entries", "", "void"), 83);
        r = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.lang.String"), 87);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        int iA = CH0.a(AbstractC5635Ke3.j(byteBuffer));
        this.n = new ArrayList(iA);
        for (int i = 0; i < iA; i++) {
            this.n.add(new a(AbstractC5635Ke3.j(byteBuffer), AbstractC5635Ke3.j(byteBuffer)));
        }
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        t(byteBuffer);
        AbstractC5869Le3.g(byteBuffer, this.n.size());
        for (a aVar : this.n) {
            AbstractC5869Le3.g(byteBuffer, aVar.a());
            AbstractC5869Le3.g(byteBuffer, aVar.b());
        }
    }

    @Override // ir.nasim.D0
    protected long c() {
        return (this.n.size() * 8) + 8;
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(r, this, this));
        return "TimeToSampleBox[entryCount=" + this.n.size() + "]";
    }

    public void u(List list) {
        C18943pW5.b().c(C20224rf2.d(q, this, this, list));
        this.n = list;
    }
}
