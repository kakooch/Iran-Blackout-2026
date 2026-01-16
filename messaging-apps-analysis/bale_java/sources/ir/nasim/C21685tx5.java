package ir.nasim;

/* renamed from: ir.nasim.tx5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C21685tx5 extends AbstractC20998sx5 {
    private long a;
    private long b;
    private C20408rx5 c;

    public C21685tx5(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC20998sx5
    public AbstractC20998sx5 a(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
        this.b = c9207Yy1.e();
        this.c = new C20408rx5(c9207Yy1);
        return this;
    }

    @Override // ir.nasim.AbstractC20998sx5
    public void c(C12658ez1 c12658ez1) {
        c12658ez1.i(this.a);
        c12658ez1.i(this.b);
        this.c.c(c12658ez1);
    }

    public long d() {
        return this.a;
    }

    public C20408rx5 e() {
        return this.c;
    }

    public long f() {
        return this.b;
    }

    public String toString() {
        return "ProtoPackage[" + this.a + "|" + this.b + "]";
    }

    public C21685tx5(long j, long j2, C20408rx5 c20408rx5) {
        this.a = j;
        this.b = j2;
        this.c = c20408rx5;
    }
}
