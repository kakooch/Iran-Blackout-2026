package ir.nasim;

/* loaded from: classes5.dex */
public class IP {
    private PQ a;
    private final boolean b;
    private final boolean c;

    public IP(PQ pq) {
        this.a = pq;
        this.c = false;
        this.b = false;
    }

    public PQ a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public IP(boolean z) {
        this.c = z;
        this.b = true;
    }
}
