package ir.nasim;

/* renamed from: ir.nasim.wr3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23401wr3 implements JH6 {
    private final C8407Vv3 b;

    public C23401wr3(C8407Vv3 c8407Vv3) {
        AbstractC13042fc3.i(c8407Vv3, "packageFragment");
        this.b = c8407Vv3;
    }

    @Override // ir.nasim.JH6
    public KH6 b() {
        KH6 kh6 = KH6.a;
        AbstractC13042fc3.h(kh6, "NO_SOURCE_FILE");
        return kh6;
    }

    public String toString() {
        return this.b + ": " + this.b.L0().keySet();
    }
}
