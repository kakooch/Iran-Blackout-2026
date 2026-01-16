package ir.nasim;

/* renamed from: ir.nasim.Kd6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5629Kd6 {
    private final SA2 a;
    private final SA2 b;
    private final boolean c;

    public C5629Kd6(SA2 sa2, SA2 sa22, boolean z) {
        this.a = sa2;
        this.b = sa22;
        this.c = z;
    }

    public final SA2 a() {
        return this.b;
    }

    public final boolean b() {
        return this.c;
    }

    public final SA2 c() {
        return this.a;
    }

    public String toString() {
        return "ScrollAxisRange(value=" + ((Number) this.a.invoke()).floatValue() + ", maxValue=" + ((Number) this.b.invoke()).floatValue() + ", reverseScrolling=" + this.c + ')';
    }

    public /* synthetic */ C5629Kd6(SA2 sa2, SA2 sa22, boolean z, int i, ED1 ed1) {
        this(sa2, sa22, (i & 4) != 0 ? false : z);
    }
}
