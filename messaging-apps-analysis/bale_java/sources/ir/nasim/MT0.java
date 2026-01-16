package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;

/* loaded from: classes2.dex */
public abstract class MT0 extends R0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a n = null;

    static {
        n();
    }

    public MT0(String str) {
        super(str);
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("ChunkOffsetBox.java", MT0.class);
        n = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.coremedia.iso.boxes.ChunkOffsetBox", "", "", "", "java.lang.String"), 18);
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(n, this, this));
        return getClass().getSimpleName() + "[entryCount=" + u().length + "]";
    }

    public abstract long[] u();
}
