package ir.nasim;

/* loaded from: classes5.dex */
public class MM3 {
    private final C3939Cz5 a;
    private final int b;

    public MM3(C3939Cz5 c3939Cz5) {
        this.a = c3939Cz5;
        this.b = c3939Cz5.h();
    }

    public R92[] a() {
        R92[] r92Arr = (R92[]) this.a.d(this.b).toArray(new R92[0]);
        this.a.b(this.b);
        return r92Arr;
    }

    public void b(R92 r92) {
        if (r92.a() != this) {
            throw new RuntimeException("envelope.mailbox != this mailbox");
        }
        this.a.e(this.b, r92);
    }

    public void c(R92 r92) {
        if (r92.a() != this) {
            throw new RuntimeException("envelope.mailbox != this mailbox");
        }
        this.a.f(this.b, r92, true);
    }
}
