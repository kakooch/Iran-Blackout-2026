package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.kc1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C16040kc1 extends R0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a o = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a p = null;
    List n;

    /* renamed from: ir.nasim.kc1$a */
    public static class a {
        int a;
        int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public void c(int i) {
            this.a = i;
        }

        public String toString() {
            return "Entry{count=" + this.a + ", offset=" + this.b + '}';
        }
    }

    static {
        n();
    }

    public C16040kc1() {
        super("ctts");
        this.n = Collections.emptyList();
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("CompositionTimeToSample.java", C16040kc1.class);
        o = c20224rf2.f("method-execution", c20224rf2.e("1", "getEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "", "", "", "java.util.List"), 57);
        p = c20224rf2.f("method-execution", c20224rf2.e("1", "setEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "java.util.List", "entries", "", "void"), 61);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        int iA = CH0.a(AbstractC5635Ke3.j(byteBuffer));
        this.n = new ArrayList(iA);
        for (int i = 0; i < iA; i++) {
            this.n.add(new a(CH0.a(AbstractC5635Ke3.j(byteBuffer)), byteBuffer.getInt()));
        }
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        t(byteBuffer);
        AbstractC5869Le3.g(byteBuffer, this.n.size());
        for (a aVar : this.n) {
            AbstractC5869Le3.g(byteBuffer, aVar.a());
            byteBuffer.putInt(aVar.b());
        }
    }

    @Override // ir.nasim.D0
    protected long c() {
        return (this.n.size() * 8) + 8;
    }

    public void u(List list) {
        C18943pW5.b().c(C20224rf2.d(p, this, this, list));
        this.n = list;
    }
}
