package ir.nasim;

/* renamed from: ir.nasim.Yc2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C9010Yc2 {
    private final int a;
    private final int b;
    private final Runnable c;

    public C9010Yc2(int i, int i2, Runnable runnable) {
        this.a = i;
        this.b = i2;
        this.c = runnable;
    }

    public int a() {
        return this.b;
    }

    public Runnable b() {
        return this.c;
    }

    public int c() {
        return this.a;
    }

    public String toString() {
        return "ExecuteAfter {" + this.a + "," + this.b + "}";
    }
}
