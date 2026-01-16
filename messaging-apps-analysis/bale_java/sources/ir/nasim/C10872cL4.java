package ir.nasim;

/* renamed from: ir.nasim.cL4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C10872cL4 {
    private final EnumC11636dL4 a;
    private final long b;
    private final long c;
    private int d;

    public C10872cL4(EnumC11636dL4 enumC11636dL4, long j, long j2) {
        this.a = enumC11636dL4;
        this.b = j;
        this.c = j2;
    }

    public int a() {
        return this.d;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public EnumC11636dL4 d() {
        return this.a;
    }

    public String toString() {
        return "OpenHistoryCommand{type=" + this.a + ", rid=" + this.b + ", sortDate=" + this.c + ", offset=" + this.d + '}';
    }

    public C10872cL4(EnumC11636dL4 enumC11636dL4, long j, long j2, int i) {
        this.a = enumC11636dL4;
        this.b = j;
        this.c = j2;
        this.d = i;
    }
}
